package patient_intake;
// Switch from using ArrayList to a flat array implementation for patient storage.

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class PatientRegistry {
    // Flat array to store patients and a size field to track the number of stored patients.
    private Patient[] patientRegistry;
    private int size; // track actual number of patients

    // Initial capacity for the flat array. Can be adjusted as needed.
    private static final int INITIAL_CAPACITY = 10;

    public PatientRegistry() {
        patientRegistry = new Patient[INITIAL_CAPACITY];
        size = 0;
    }

    public void addPatient(Patient patient) {
        // Expand array if limit reached
        if (size == patientRegistry.length) {
            Patient[] newReg = new Patient[patientRegistry.length + 5];
            // Copy data
            for (int i=0;i<patientRegistry.length;i++)
                newReg[i] = patientRegistry[i];
            patientRegistry = newReg;
        }
        patientRegistry[size] = patient;
        size++;
    }

    /**
     * Returns the patients currently stored in the registry.
     * The optional encapsulation extension requires returning a defensive copy.
     */
    public Patient[] getPatientRegistry() {
        if (size == 0) return new Patient[0];
        Patient[] arr = new Patient[size];
        for (int i=0;i<size;i++) arr[i] = patientRegistry[i];
        return arr;
    }

    public Patient getPatientByID(String patientID) {
        if (size == 0) return null;
        for (int i=0;i<size;i++) 
            if (patientRegistry[i].getPatientID() == patientID) return patientRegistry[i];
        return null;
    }

    /**
     * Removes a patient from the registry by patientID.
     * @param patientID The ID of the patient to remove
     * @return true if patient was found and removed, false otherwise
     */
    public boolean removePatient(String patientID) {
        if (size == 0) return false;
        int pos = -1;
        for (int i=0;i<size;i++)
            if (patientRegistry[i].getPatientID() == patientID) {
                pos = i;
                break;
            }
        if (pos == -1) return false; // Fail if ID not found
        
        // Shift remaining elements down, overwriting element to be erased
        for (int i=pos;i<size;i++)
            patientRegistry[i] = patientRegistry[i+1];
        size--; // Decrement size
        return true;
    }

    /**
     * Removes a patient from the registry by index.
     * @param index The index of the patient to remove
     * @return the removed Patient, or null if index is invalid
     */
    public Patient removePatient(int index) {
        if (index >= size || index < 0) return null;
        Patient p = patientRegistry[index];
        for (int i=index;i<size-1;i++)
            patientRegistry[i] = patientRegistry[i+1]; 
        size--;
        return p;
    }

    /**
     * Updates a patient in the registry by matching patientID.
     * @param updatedPatient The patient with updated information
     * @return true if patient was found and updated, false otherwise
     */
    public boolean updatePatient(Patient updatedPatient) {
        int id = -1;
        for (int i=0;i<size;i++) {
            if (patientRegistry[i].getPatientID() == updatedPatient.getPatientID()) id = i;
        }
        if (id == -1) return false;
        patientRegistry[id] = updatedPatient;
        return true;
    }

    // Sort patients in an array based on their patient ID
    public static Patient[] sortByID(Patient[] arrin) {
        List<Patient> arrcopy = Arrays.asList(arrin.clone());
        Collections.sort(arrcopy);
        return arrcopy.toArray(new Patient[arrcopy.size()]);
    }
    
    @Override
    public String toString() {
        return String.format("PatientRegistry, size %d", size);

    }

}


