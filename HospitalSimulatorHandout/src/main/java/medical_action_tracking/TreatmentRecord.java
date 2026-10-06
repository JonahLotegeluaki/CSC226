package medical_action_tracking;

public class TreatmentRecord {
    private String patientID;
    private String treatmentName;
    private String timestamp;

    public TreatmentRecord(String patientID, String treatmentName, String timestamp) {
        this.patientID = patientID;
        this.treatmentName = treatmentName;
        this.timestamp = timestamp;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s", timestamp, patientID, treatmentName);
    }
}
