package staff_assignment;

import medical_action_tracking.TreatmentHistory;

public class Main {
    public static void main(String[] args) {
        StaffRoster roster = new StaffRoster();
        StaffMember a1 = new StaffMember("S1", "Bob", Seniority.ATTENDING);
        StaffMember r1 = new StaffMember("S2", "Jimmy", Seniority.RESIDENT);
        StaffMember n1 = new StaffMember("S3", "Michael", Seniority.NURSE);
        StaffMember t1 = new StaffMember("S4", "Timmy", Seniority.TECH);
        StaffMember a2 = new StaffMember("S5", "SuperDoctor", Seniority.ATTENDING);
        StaffMember n2 = new StaffMember("S6", "Joe", Seniority.NURSE);
        for (StaffMember m : new StaffMember[]{a1, r1, n1, t1, a2, n2})
            roster.addStaff(m);
        TreatmentHistory hist = new TreatmentHistory();

        // A ton of extreme cases just came in!
        roster.assignTreatment("Ow", "Reconstruct Skeleton out of plastic", "AD 3000", Seniority.ATTENDING);
        roster.assignTreatment("Ow", "Reconstruct Skeleton out of plastic", "AD 3000", Seniority.ATTENDING);
        roster.assignTreatment("Ow", "Reconstruct Skeleton out of plastic", "AD 3000", Seniority.ATTENDING);
        roster.assignTreatment("Ow", "Reconstruct Skeleton out of plastic", "AD 3000", Seniority.ATTENDING);
        roster.assignTreatment("Ow", "Reconstruct Skeleton out of plastic", "AD 3000", Seniority.ATTENDING);
        roster.assignTreatment("Ow", "Reconstruct Skeleton out of plastic", "AD 3000", Seniority.ATTENDING);
        roster.assignTreatment("Ow", "Reconstruct Skeleton out of plastic", "AD 3000", Seniority.ATTENDING);
        roster.assignTreatment("Ow", "Reconstruct Skeleton out of plastic", "AD 3000", Seniority.ATTENDING);
        roster.assignTreatment("Ow", "Reconstruct Skeleton out of plastic", "AD 3000", Seniority.ATTENDING);
        hist.addTreatment("Ow", "Reconstruct skeleton", "AD 3000", "Bob");
        // Bob wasn't supposed to do that one
        roster.undoLastAssignment();

        // And then some people come in with scrapes
        roster.assignTreatment("Eh", "BandAid", "Now", Seniority.TECH);
        roster.assignTreatment("Eh", "BandAid", "Now", Seniority.TECH);
        roster.assignTreatment("Eh", "BandAid", "Now", Seniority.TECH);
        roster.assignTreatment("Eh", "BandAid", "Now", Seniority.TECH);
        roster.assignTreatment("Eh", "BandAid", "Now", Seniority.TECH);
        roster.assignTreatment("Eh", "BandAid", "Now", Seniority.TECH);

        // Some other minor cases.
        roster.assignTreatment("No biggie", "Patch up", "Today", Seniority.NURSE);
        roster.assignTreatment("No biggie", "Patch up", "Today", Seniority.NURSE);
        roster.assignTreatment("No biggie", "Patch up", "Today", Seniority.RESIDENT);
        roster.assignTreatment("No biggie", "Patch up", "Today", Seniority.NURSE);
        roster.assignTreatment("No biggie", "Patch up", "Today", Seniority.RESIDENT);

        // Oops
        roster.undoLastAssignment();

        // Give them a break
        for (int i=0;i<5;i++) {
            roster.release(a1);
            roster.release(a2);
        }
    }
}
