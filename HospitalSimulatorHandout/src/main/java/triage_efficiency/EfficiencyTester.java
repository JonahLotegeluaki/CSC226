package triage_efficiency;

import patient_intake.Patient;


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
            if (p.getPatientID().equals(pid)) return p;
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
    // The array passed is assumed to be sorted before function call.
    public Patient binarySearch(Patient[] patients, String pid) {
        if (patients.length == 0) return null;
        int L = 0, R = patients.length - 1,m;
        for (int i=0;i<1000;i++) {
            if (L > R) return null;
            m = L + Math.floorDiv(R - L, 2);
            String mPid = patients[m].getPatientID();
            if (mPid.equals(pid)) return patients[m];
            if (mPid.compareTo(pid) < 0) {
                L = m + 1;
                continue;
            }
            R = m - 1;
        }
        return null;
    }

    // Configurable start parameters for use in exponential search
    public Patient binarySearch(Patient[] patients, String pid, int low, int high) {
        if (patients.length == 0) return null;
        int L = low, R = high - 1, m;
        for (int i=0;i<1000;i++) {
            if (L > R) return null;
            m = L + Math.floorDiv(R - L, 2);
            String mPid = patients[m].getPatientID();
            if (mPid.equals(pid)) return patients[m];
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
    // OPTIONAL Exponential search
    // From https://en.wikipedia.org/wiki/Exponential_search#Algorithm
    // Exponentially increases the range in which the id should be found.
    // Then performs a binary search within that narrowed range.
    public Patient logNSearch(Patient[] patients, String pid) {
        if (patients.length == 0) return null;

        // Step 1: Limit the part of the array the id is in
        int bound = 1;
        while (bound < patients.length && patients[bound].compareTo(pid) < 0) {
            bound *= 2;
        }

        // Step 2: Binary search in this area
        return binarySearch(patients, pid, bound/2, patients.length < bound ? patients.length : bound + 1);
    }

    // Runs all 3 algorithms, logs their runtime, and checks if the nullness is correct
    // The timing check is part of the OPTIONAL work
    public void timeDemo(Patient[] list, String pid, boolean expectNull) {
        long start = System.nanoTime();
        Patient p = linearSearch(list, pid);
        long end = System.nanoTime();
        long linTime = end - start;
        if (expectNull) System.out.println(p == null ? "Linear correctly null" : "Linear incorrectly not-null");
        else System.out.println(p == null ? "Linear incorrectly null" : "Linear correctly not null");

        start = System.nanoTime();
        p = binarySearch(list, pid);
        end = System.nanoTime();
        long binTime = end - start;
        if (expectNull) System.out.println(p == null ? "Binary correctly null" : "Binary incorrectly not-null");
        else System.out.println(p == null ? "Binary incorrectly null" : "Binary correctly not null");
        
        start = System.nanoTime();
        p = logNSearch(list, pid);
        end = System.nanoTime();
        long lognTime = end - start;
        if (expectNull) System.out.println(p == null ? "Exponential correctly null" : "Exponential incorrectly not-null");
        else System.out.println(p == null ? "Exponential incorrectly null" : "Exponential correctly not null");

        System.out.printf("Searching %d patients for %s:\nLinear:      %d\nBinary:      %d\nExponential: %d\n\n",
            list.length, pid, linTime, binTime, lognTime
        );
    }
}
