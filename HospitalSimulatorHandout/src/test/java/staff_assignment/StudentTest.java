package staff_assignment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

public class StudentTest {
    
    // Test that an empty roster returns null from assign()
    @Test 
    void testEmptyRoster() {
        StaffRoster r = new StaffRoster();
        assertNull(r.assign(Seniority.TECH));
    }

    // Test that the roster distributes the workload evenly
    @Test 
    void testRosterEvenWorkload() {
        StaffRoster r = new StaffRoster();
        StaffMember s0 = new StaffMember("S0", "null", Seniority.ATTENDING);
        StaffMember s1 = new StaffMember("S1", "null", Seniority.ATTENDING);
        StaffMember s2 = new StaffMember("S2", "null", Seniority.ATTENDING);
        StaffMember s3 = new StaffMember("S3", "null", Seniority.ATTENDING);
        for (StaffMember m : new StaffMember[]{s0,s1,s2,s3}) r.addStaff(m);

        r.assign(Seniority.ATTENDING);
        r.assign(Seniority.ATTENDING);
        r.assign(Seniority.ATTENDING);
        r.assign(Seniority.ATTENDING);

        assertEquals(1, s0.getCaseLoad());
        assertEquals(1, s1.getCaseLoad());
        assertEquals(1, s2.getCaseLoad());
        assertEquals(1, s3.getCaseLoad());
    }

    // Test that a release of a nonexistent staff member throws the correct exception
    @Test 
    void testNonexistentIDthrows() {
        StaffRoster r = new StaffRoster();
        StaffMember m = new StaffMember("S01", "John", Seniority.ATTENDING);
        assertThrows(NoSuchElementException.class, () -> r.release(m));
    }
}
