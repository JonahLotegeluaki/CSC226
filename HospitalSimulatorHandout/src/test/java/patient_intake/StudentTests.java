package patient_intake;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class StudentTests {
    
    // Test that the array expands correctly
    @Test 
    void testArrayExpansion() {
        PatientRegistry reg = new PatientRegistry();
        for (int i=0;i<6;i++) {
            reg.addPatient(new Patient("P29", "Monkey", "Gorilla", 20031, "Hungry", 0, "None", "Lobby", 1, "123yowrgfuyewrfg"));
            reg.addPatient(new Patient("P22", "Ape", "Bonobo", 22033, "Hungry", 0, "None", "Lobby", 1, "12cgd3yowrgfuyewrfg"));
        }
        assertEquals(12, reg.getPatientRegistry().length);
    }

    // Verify that remove by ID handles missing values correctly
    @Test 
    void testRemoveByID() {
        PatientRegistry reg = new PatientRegistry();
        for (int i=0;i<6;i++) {
            reg.addPatient(new Patient("P29", "Monkey", "Gorilla", 20031, "Hungry", 0, "None", "Lobby", 1, "123yowrgfuyewrfg"));
            reg.addPatient(new Patient("P22", "Ape", "Bonobo", 22033, "Hungry", 0, "None", "Lobby", 1, "12cgd3yowrgfuyewrfg"));
        }
        assertEquals(false, reg.removePatient("P11"));
    }

    // Verify that remove by index handles wrong values correctly and without throwing exceptions
    @Test 
    void testRemoveByIndex() {
        PatientRegistry reg = new PatientRegistry();
        for (int i=0;i<6;i++) {
            reg.addPatient(new Patient("P29", "Monkey", "Gorilla", 20031, "Hungry", 0, "None", "Lobby", 1, "123yowrgfuyewrfg"));
            reg.addPatient(new Patient("P22", "Ape", "Bonobo", 22033, "Hungry", 0, "None", "Lobby", 1, "12cgd3yowrgfuyewrfg"));
        }
        assertEquals(null, reg.removePatient(24));
        assertEquals(null, reg.removePatient(-6));
    }

    // Test if a Patient constructed with an invalid age will cause problems
    @Test
    void testPatientInvalidAge() {
        Patient p = new Patient("P-0001", "Invalid", "Patient", -97, "Universe is broken", -4, "Time Travel", "The Floor", -473, "h");
        PatientRegistry reg = new PatientRegistry();
        reg.addPatient(p);
        for (Patient a : reg.getPatientRegistry()) System.out.println(a.toString());
    }

    // Test that setAge() works correctly, and accepts 120yrs but rejects 121 with the correct exception
    @Test 
    void testSetAge() {
        Patient p = new Patient("P29", "Monkey", "Gorilla", 20031, "Hungry", 0, "None", "Lobby", 1, "123yowrgfuyewrfg");
        try {
            p.setAge(120);
        } catch (Exception e) {
            fail();
        }
        try {
            p.setAge(121);
        } catch (IllegalArgumentException e) {
            // Should catch
            System.out.println("Correct exception thrown");
        }
    }

    // Tests that getPatientRegistry() does not return the real registry but rather a copy, for security
    @Test 
    void testGetPatientRegistry() {
        PatientRegistry reg = new PatientRegistry();
        reg.addPatient(new Patient("P29", "Monkey", "Gorilla", 20031, "Hungry", 0, "None", "Lobby", 1, "123yowrgfuyewrfg"));
        reg.addPatient(new Patient("P22", "Ape", "Bonobo", 22033, "Hungry", 0, "None", "Lobby", 1, "12cgd3yowrgfuyewrfg"));
        Patient[] reg2 = reg.getPatientRegistry();
        reg2[1] = new Patient(
            "P001", "Literally Anyone", "and Everyone", 26, "who used Java for just 0.054ms", 4, "Near Death", "ERICUSVUSUV", 15, "none");
        assertEquals(22033, reg.getPatientByID("P22").age);
    }

    // Test if the JVM accepts this patient (i was out of ideas) (this is 7th test btw)
    @Test 
    void testIfHumanWillLive() {
        boolean alive = true;
        Patient p = new Patient(
            "P001", "Literally Anyone", "and Everyone", 26, "who used Java for just 0.054ms", 4, "Near Death", "ERICUSVUSUV", 15, "none");
        if (p.getChiefComplaint().contains("Java")) {
            p = null;
            alive = false;
        }
        assertEquals(false, alive);
    }
}
