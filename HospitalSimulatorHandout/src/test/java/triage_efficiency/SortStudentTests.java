package triage_efficiency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import patient_intake.*;

public class SortStudentTests {
    
    EfficiencyTester alg = new EfficiencyTester();
    Patient[] arr = {
        new Patient("P002", "b", "b", 2, "z", 2, "z", "z", 2, "z"),
        new Patient("P001", "a", "a", 1, "z", 1, "z", "z", 1, "z"),
        new Patient("P003", "c", "c", 3, "z", 3, "z", "z", 3, "z"),
        new Patient("P006", null, null, 0, null, 0, null, null, 0, null),
        new Patient("P004", null, null, 0, null, 0, null, null, 0, null),
        new Patient("P011", null, null, 0, null, 0, null, null, 0, null),
    };

    // Tests that the sorting function works correctly.
    // Necessary for binary search.
    @Test 
    void testArraySorting() {
        assertEquals("P001", arr[1].getPatientID());
        Patient[] arr2 = Main.sortByPatientId(arr);
        assertEquals("P001", arr2[0].getPatientID());
    }

    // Test that linear search works correctly.
    // Necessary for credit.
    @Test 
    void testLinearSearch() {
        assertEquals(2, alg.linearSearch(arr, "P002").getAge());
        assertEquals(null, alg.linearSearch(arr, "P013"));
    }

    // Test that binary search works correctly.
    // Required for credit.
    @Test 
    void testBinarySearch() {
        Patient[] arr2 = Main.sortByPatientId(arr);
        assertEquals("b", alg.binarySearch(arr2, "P002").getFirstName());
        assertEquals(null, alg.binarySearch(arr2, "P199"));
    }

    // Test that exponential search works correctly.
    // Required for optional credit.
    @Test 
    void testExponentialSearch() {
        Patient[] arr2 = Main.sortByPatientId(arr);
        assertEquals(3, alg.logNSearch(arr2, "P003").getAge());
        assertEquals(null, alg.logNSearch(arr2, "P023"));
    }
}
