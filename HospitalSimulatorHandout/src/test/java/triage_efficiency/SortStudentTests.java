package triage_efficiency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import patient_intake.*;

public class SortStudentTests {
    
    // Tests that the sorting function works correctly.
    // Necessary for binary search.
    @Test 
    void testArraySorting() {
        Patient[] arr = new Patient[2];
        arr[1] = new Patient("P001", "a", "a", 1, "z", 1, "z", "z", 1, "z");
        arr[0] = new Patient("P002", "b", "b", 2, "z", 2, "z", "z", 2, "z");
        assertEquals("P001", arr[1].getPatientID());
        Patient[] arr2 = PatientRegistry.sortByID(arr);
        assertEquals("P001", arr2[0].getPatientID());
    }
}
