package triage_efficiency;

import patient_intake.Patient;
import patient_intake.PatientRegistry;

public class EfficiencyTester {

    /**
     * REQUIRED (80%): Implement linear search.
     *
     * Search through the patient array one element at a time until the matching
     * patientID is found. Return the Patient if it exists; otherwise return null.
     *
     * This method must run in O(n) time.
     */
    public Patient linearSearch(Patient[] patients, String pid) {
        // Search the entire array in order and return the matching Patient.
        for (Patient p : patients) {
            if (p.getPatientID() == pid) return p;
        }
        return null;
    }

    /**
     * REQUIRED (80%): Implement binary search.
     *
     * This method works only on an array that is sorted by patientID.
     * Repeatedly divide the search range in half until the target is found.
     *
     * This method must run in O(log n) time.
     */
    // Implemented from https://en.wikipedia.org/wiki/Binary_search#Algorithm
    public Patient binarySearch(Patient[] patients, String pid) {
        // The array must be sorted by patientID before calling this method.
        Patient[] sorted = PatientRegistry.sortByID(patients);
        int L = 0, R = sorted.length - 1, m;
        for (int i=0;i<1000;i++) {
            if (L > R) return null;
            m = L + Math.floorDiv(R - L, 2);
            String mPid = sorted[m].getPatientID();
            if (mPid == pid) return sorted[m];
            if (mPid.compareTo(pid) < 0) {
                L = m + 1;
                continue;
            }
            R = m - 1;
        }
        return null;
    }

    /**
     * OPTIONAL (+5%): Implement a different O(log n) search algorithm.
     *
     * Pick one of the following approaches and implement it:
     * - Exponential search
     * - Jump search
     * - Ternary search
     *
     * Add a short comment above the method explaining:
     * - which algorithm you chose
     * - where you learned about it
     * - why it works
     */
    public Patient logNSearch(Patient[] patients, String pid) {
        // TODO OPTIONAL: Research and implement a second O(log n) algorithm.
        // Cite your source and explain the approach in a comment before the logic.
        return null; // Remove this line and implement the method.
    }

    public void timeDemo() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int x = 5 + 5;
        }
        long endTime = System.nanoTime();

        System.out.println("The example addition took: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int x = 5 * 5;
        }
        endTime = System.nanoTime();
        System.out.println("The example multiplication took: " + (endTime - startTime) + " ns");
    }
}
