package medical_action_tracking;

import patient_intake.Patient;

public class EmergencyWaitingRoom {
    private LinkedQueue<Patient> level1;
    private LinkedQueue<Patient> level2;
    private LinkedQueue<Patient> level3;
    private LinkedQueue<Patient> level4;

    public EmergencyWaitingRoom() {
        level1 = new LinkedQueue<>();
        level2 = new LinkedQueue<>();
        level3 = new LinkedQueue<>();
        level4 = new LinkedQueue<>();
    }

    /**
     * Add a patient to the FIFO lane matching their triage level.
     *
     * @return true if added; false for null patients or levels outside 1-4
     */
    public boolean addPatient(Patient patient) {
        if (patient == null) return false;
        int level = patient.getTriageLevel();
        if (level < 1 || level > 4) return false;
        switch (level) {
            case 1:
                level1.enqueue(patient);
                break;
            case 2:
                level2.enqueue(patient);
                break;
            case 3:
                level3.enqueue(patient);
                break;
            case 4:
                level4.enqueue(patient);
        }
        return true;
    }

    /**
     * Remove the next patient, checking triage level 1 before level 2, and so on.
     */
    public Patient nextPatient() {
        Patient p = null;
        p = level1.dequeue();
        if (p != null) return p;
        p = level2.dequeue();
        if (p != null) return p;
        p = level3.dequeue();
        if (p != null) return p;
        p = level4.dequeue();
        return p;
    }

    public boolean isEmpty() {
        if (level1.isEmpty() &&
            level2.isEmpty() &&
            level3.isEmpty() &&
            level4.isEmpty()) return true;
        return false;
    }

    public int size() {
        return level1.size() + level2.size() + level3.size() + level4.size();
    }
}
