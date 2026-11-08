package medical_action_tracking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HW4UpdatesTest {
    @Test 
    public void testHW4UpdatesToHW3() {
        TreatmentRecord tr = new TreatmentRecord("hufri", "chicken", "yesterday");
        assertNull(tr.getPerformedBy());
        tr = new TreatmentRecord("whuf", "hwri", "qwrf", "ME!");
        assertNotNull(tr.getPerformedBy());

        TreatmentHistory th = new TreatmentHistory();
        th.addTreatment("ehwif", "hywif", "gyuqwf", "test");
    }
}
