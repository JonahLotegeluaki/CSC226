package triage_efficiency;

import patient_intake.Patient;
import java.util.List;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // TODO REQUIRED: Generate the patient data.
        // TODO REQUIRED: Sort the data by patientID when needed.
        // TODO REQUIRED: Run each search method and print a found and not-found example.
        // TODO OPTIONAL: Call timeDemo() to compare algorithm runtimes.

        EfficiencyTester alg = new EfficiencyTester();
        Patient[] list = sortByPatientId(generatePatients(100));
        alg.timeDemo(list, getRandomID(100), false);
        alg.timeDemo(list, "P103", true);
        list = sortByPatientId(generatePatients(1000));
        alg.timeDemo(list, getRandomID(1000), false);
        alg.timeDemo(list, "P9123", true);
        list = sortByPatientId(generatePatients(10000));
        alg.timeDemo(list, getRandomID(10000), false);
        alg.timeDemo(list, "P10757", true);
        list = sortByPatientId(generatePatients(100000));
        alg.timeDemo(list, getRandomID(100000), false);
        alg.timeDemo(list, "P110111", true);
    }
    private static String getRandomID(int bound) {
        Random r = new Random();
        return "P" + String.format("%06d", r.nextInt(bound));
    }

    /**
     * REQUIRED (80%): Generate sample patient data for testing.
     *
     * Build an array of Patient objects with realistic IDs, names, complaints,
     * and triage information so you can test each search method.
     */
    public static Patient[] generatePatients(int count) {
        if (count == 0) return null;
        Random r = new Random();
        Patient[] patients = new Patient[count];
        for (int i=0;i<count;i++) {
            String pid = "P" + String.format("%06d", i+1);    // Zero padded pid string
            String fname = firstNames[r.nextInt(firstNames.length)];
            String lname = lastNames[r.nextInt(lastNames.length)];
            String comp = complaints[r.nextInt(complaints.length)];
            String stage = stages[r.nextInt(stages.length)];
            String room = rooms[r.nextInt(rooms.length)];
            String ins = generateInsuranceID();
            patients[i] = new Patient(pid, fname, lname, r.nextInt(121), comp, r.nextInt(5), stage, room, r.nextInt(24), ins);
        }
        return patients;
    }

    /**
     * REQUIRED (80%): Sort patients by patientID before binary search.
     *
     * The binary-search version only works on an array sorted by patientID.
     */
    // This function is non-destructive to its input
    public static Patient[] sortByPatientId(Patient[] patients) {
        List<Patient> arrcopy = Arrays.asList(patients.clone());
        Collections.sort(arrcopy);
        return arrcopy.toArray(new Patient[arrcopy.size()]);
    }

    // Pools of data that can be selected from randomly for each patient generated

    private static String[] firstNames = {
        "John",
        "Michael",
        "Matthew",
        "Arthur",
        "Frank",
        "Robert",
        "Jack",
        "Albert",
        "Luke",
        "Thomas",
        "Elias",
        "Jeremy",
        "Paul",
        "Ella",
        "Kendal",
        "Ada",
        "Natalie",
        "Carmen"
    };

    private static String[] lastNames = {
        "Smith",
        "Johnson",
        "Newton",
        "Moore",
        "Stern",
        "Clayton",
        "Thomas",
    };

    private static String[] complaints = {
        "Back pain",
        "Head trauma",
        "Laceration"
    };

    private static String[] stages = {
        "Pediatrics",
        "Admission",
        "Triage",
        "Treatment",
        "Recovery",
        "Surgery",
        "Waiting"
    };

    private static String[] rooms = {
        "ER01",
        "ER02",
        "ER03",
        "WR01",
        "WR02",
        "WR03",
        "RC01",
        "RC02",
        "RC03",
        "PD01",
        "PD02",
        "PD03",
    };

    private static String generateInsuranceID() {
        final int length = 30;
        Random r = new Random();
        StringBuilder buf = new StringBuilder();
        for (int i=0;i<length;i++) {
            buf.append(r.nextInt(10));
        }
        return buf.toString();
    }
}
