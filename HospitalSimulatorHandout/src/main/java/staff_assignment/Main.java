package staff_assignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

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

        // EXTENSION
        // Structure comparison
        TreeSet<StaffMember> ts = new TreeSet<>();
        ArrayList<StaffMember> al = new ArrayList<>();
        LinkedList<StaffMember> ll = new LinkedList<>();
        Random r = new Random();
        // Test for 100 insertions
        long addtime100ts = timeOp(() -> {for (StaffMember m : newStaff(r, 100)) ts.add(m);});
        long addtime100al = timeOp(() -> {for (StaffMember m : newStaff(r, 100)) {al.add(m); al.sort(null);}});
        long addtime100ll = timeOp(() -> {for (StaffMember m : newStaff(r, 100)) {ll.add(m); ll.sort(null);}});
        // Test for 1000
        long addtime1000ts = timeOp(() -> {for (StaffMember m : newStaff(r, 1000)) ts.add(m);});
        long addtime1000al = timeOp(() -> {for (StaffMember m : newStaff(r, 1000)) {al.add(m); al.sort(null);}});
        long addtime1000ll = timeOp(() -> {for (StaffMember m : newStaff(r, 1000)) {ll.add(m); ll.sort(null);}});
        // Test for 10000
        long addtime10000ts = timeOp(() -> {for (StaffMember m : newStaff(r, 10000)) ts.add(m);});
        long addtime10000al = timeOp(() -> {for (StaffMember m : newStaff(r, 10000)) {al.add(m); al.sort(null);}});
        long addtime10000ll = timeOp(() -> {for (StaffMember m : newStaff(r, 10000)) {ll.add(m); ll.sort(null);}});
        // Print
        System.out.printf("100 Loops:\nTreeSet:    %d\nArrayList:  %d\nLinkedList: %d\n", addtime100ts, addtime100al, addtime100ll);
        System.out.printf("1000 Loops:\nTreeSet:    %d\nArrayList:  %d\nLinkedList: %d\n", addtime1000ts, addtime1000al, addtime1000ll);
        System.out.printf("10000 Loops:\nTreeSet:    %d\nArrayList:  %d\nLinkedList: %d\n", addtime10000ts, addtime10000al, addtime10000ll);
    }
    static long timeOp(Runnable fn) {
        long start = System.nanoTime();
        fn.run();
        long end = System.nanoTime();
        return end - start;
    }
    static StaffMember[] newStaff(Random rand, int n) {
        StaffMember[] l = new StaffMember[n];
        for (int i=0;i<n;i++) {
            l[i] = new StaffMember(
                "S" + rand.nextInt(100000), 
                "",
                Seniority.values()[rand.nextInt(Seniority.values().length)]);
        }
        return l;
    }
}

