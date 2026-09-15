package patient_intake;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      String filePath = "src/main/java/patient_intake/patients.csv";
      PatientRegistry patients = new PatientRegistry();

      try (Scanner fileReader = new Scanner(new File(filePath))) {
         if (fileReader.hasNextLine()) {
            fileReader.nextLine(); // Skip the CSV header.
         }

         while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] parts = line.split(",");

            // patientID,name,age,chiefComplaint,triageLevel,currentStage,assignedRoom,arrivalHour,insuranceID
            String[] names = parts[1].split(" ");
            patients.addPatient(new Patient(
               parts[0], names[0], names[1], Integer.parseInt(parts[2]), parts[3], Integer.parseInt(parts[4]),
               parts[5], parts[6], Integer.parseInt(parts[7]), parts[8]
            ));
         }

         for (Patient p : patients.getPatientRegistry())
            System.out.println(p.toString());
      } catch (FileNotFoundException exception) {
         System.err.println("[Error] Registry file not found.");
      }
   }
}