package medical_action_tracking;

import patient_intake.Patient;
import patient_intake.PatientRegistry;
import triage_efficiency.EfficiencyTester;

public class Main {
    public static void main(String[] args) {
        PatientRegistry registry = new PatientRegistry();
        Patient[] samplePatients = {
                patient("P001", 3),
                patient("P002", 1),
                patient("P003", 1)
        };
        for (Patient patient : samplePatients) {
            registry.addPatient(patient);
        }

        // OPTIONAL ==================
        int[] arrivalMinutes = {11, 18, 27};
        int[] serviceMinutes = {16, 24, 21};
        int[] waitMinutes = new int[3];
        int clockMinute = 27;
        // ===========================

        Patient[] patients = registry.getPatientRegistry();
        Patient searchedPatient = new EfficiencyTester().linearSearch(patients, "P002");
        System.out.println("Week 2 search found: " + searchedPatient);

        EmergencyWaitingRoom waitingRoom = new EmergencyWaitingRoom();
        for (Patient patient : patients) {
            waitingRoom.addPatient(patient);
        }
        while (!waitingRoom.isEmpty()) {
            Patient nextPatient = waitingRoom.nextPatient();
            // OPTIONAL =========================================
            int idNumber = Integer.parseInt(nextPatient.getPatientID().substring(1)) - 1;
            waitMinutes[idNumber] = clockMinute - arrivalMinutes[idNumber];
            clockMinute += serviceMinutes[idNumber];
            // ==================================================
            System.out.println("Next patient: " + nextPatient.getPatientID()
                    + " (triage level " + nextPatient.getTriageLevel() + "); waited " + waitMinutes[idNumber] + " minutes");
        }
        double avg = (waitMinutes[0] + waitMinutes[1] + waitMinutes[2]) / 3;
        System.out.printf("Average waiting time was %f minutes\n\n", avg);

        TreatmentHistory history = new TreatmentHistory();
        history.addTreatment("P002", "Initial assessment", "2026-09-27 09:00");
        history.addTreatment("P001", "X-ray", "2026-09-27 09:10");
        history.addTreatment("P002", "Pain relief", "2026-09-27 09:15");

        System.out.println("Treatment log: " + history.displayHistory());
        TreatmentRecord undone = history.undoLastAction();
        System.out.println("Undid: " + undone);
        System.out.println("Remaining log: " + history.displayHistory());
    }

    private static Patient patient(String patientID, int triageLevel) {
        return new Patient(patientID, "Test", "Patient", 30, "Checkup", triageLevel,
                "Waiting", "ER-001", 9, "INS-001");
    }
}
