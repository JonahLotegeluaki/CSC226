package staff_assignment;

import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.TreeSet;

import medical_action_tracking.TreatmentHistory;
import medical_action_tracking.TreatmentRecord;

public class StaffRoster {
    // Week 3 stack-based history; every assignment is recorded here so it can be undone.
    private final TreatmentHistory history = new TreatmentHistory();

    // Outer map groups staff by seniority; each inner set is sorted by StaffMember's ordering.
    private final TreeMap<Seniority, TreeSet<StaffMember>> tiers = new TreeMap<>();

    // Initialize the roster
    public StaffRoster() {
        for (Seniority s : Seniority.values()) {
            tiers.put(s, new TreeSet<>());
        }
    }

    // Add the staff member to the correct tier, and reject a duplicate staffId.
    public void addStaff(StaffMember staff) {
        if (findById(staff.getStaffId()) == null)
            tiers.get(staff.getSeniority()).add(staff);
        else throw new IllegalArgumentException();
    }

    // Pick the least-loaded staff member at or above "required", raise their load by 1, and return them.
    public StaffMember assign(Seniority required) {
        if (this.size() == 0) return null;
        java.util.ArrayList<StaffMember> l = new java.util.ArrayList<>();
        // Picks the lowest from each set
        for (Seniority s : Seniority.values()) {
            if (s.compareTo(required) >= 0 && tiers.get(s).size() > 0) // Get required seniority level
                l.add(tiers.get(s).first());
        }
        if (l.size() == 0) throw new NoSuchElementException();
        // Finds whoever has the lowest in all
        StaffMember m = l.get(0);
        if (l.size() != 1) for (StaffMember mem : l)
            if (mem.compareTo(m) < 0) m = mem;
        // Add to the case load
        changeLoad(m, m.getCaseLoad() + 1);
        return m;
    }

    // Lower the staff member's load by 1 (never below 0) and keep the tree ordered.
    public void release(StaffMember staff) {
        if (!tiers.get(staff.getSeniority()).contains(staff)) throw new NoSuchElementException();
        int load = staff.getCaseLoad();
        if (load > 0)
            changeLoad(staff, load - 1);
    }

    // Return how many staff members are in the roster.
    public int size() {
        int size = 0;
        for (Seniority s : Seniority.values())
            size += tiers.get(s).size();
        return size;
    }

    // Print each tier, most senior first, listing its staff in order.
    public void displayRoster() {
        for (Seniority s : Seniority.values()) {
            for (StaffMember stf : tiers.get(s)) {
                System.out.println(stf.toString());
            }
        }
    }

    // Remove the member, set the new load, then add them back (the only safe way to change a load).
    private void changeLoad(StaffMember member, int newLoad) {
        tiers.get(member.getSeniority()).remove(member);
        member.setCaseLoad(newLoad);
        tiers.get(member.getSeniority()).add(member);
    }

    // Call assign(), record the treatment in history with the chosen staffId, and return that staff member.
    public StaffMember assignTreatment(String patientID, String treatment, String timestamp, Seniority required) {
        StaffMember m = assign(required);
        history.addTreatment(patientID, treatment, timestamp, m.getStaffId());
        return m;
    }

    // Pop the globally most recent treatment with your Week 3 undo, release whoever performed it, and return them (null if none).
    public StaffMember undoLastAssignment() {
        TreatmentRecord rec = history.undoLastAction();
        if (rec == null) return null;
        StaffMember m = findById(rec.getPerformedBy());
        if (m == null) return null;
        changeLoad(m, m.getCaseLoad() - 1);
        return m;
    }

    // Return the staff member with this staffId, or null if they are not in the roster.
    private StaffMember findById(String staffId) {
        for (Seniority s : Seniority.values())
            for (StaffMember m : (StaffMember[]) tiers.get(s).toArray(new StaffMember[tiers.get(s).size()])) {
                if (m.getStaffId() == staffId) return m;
            }
        return null;
    }
}
