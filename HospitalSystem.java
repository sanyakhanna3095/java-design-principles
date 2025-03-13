import java.util.ArrayList;
import java.util.Scanner;

// Patient class
class Patient {
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Doctor class (Consults multiple patients)
class Doctor {
    private String name;
    private ArrayList<Patient> patients; // List of patients consulted by the doctor

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Consult a patient (Association)
    public void consult(Patient patient) {
        patients.add(patient);
        System.out.println("Dr. " + name + " is consulting " + patient.getName());
    }

    // Display patients consulted by this doctor
    public void showPatients() {
        System.out.println("Dr. " + name + "'s Patients:");
        for (Patient patient : patients) {
            System.out.println("  - " + patient.getName());
        }
    }
}

// Hospital class (Contains Doctors and Patients)
class Hospital {
    private String name;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    // Add Doctor
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Add Patient
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Display Hospital Details
    public void displayDetails() {
        System.out.println("Hospital: " + name);

        // Display Doctors
        System.out.println("Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("  - " + doctor.getName());
        }

        // Display Patients
        System.out.println("Patients:");
        for (Patient patient : patients) {
            System.out.println("  - " + patient.getName());
        }
    }
}

// Main class to demonstrate Association & Communication with user input
public class HospitalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating Hospital
        System.out.print("Enter hospital name: ");
        Hospital hospital = new Hospital(sc.nextLine());

        // Adding Doctors
        System.out.print("How many doctors to add? ");
        int doctorCount = sc.nextInt();
        sc.nextLine();

        ArrayList<Doctor> doctors = new ArrayList<>();
        for (int i = 0; i < doctorCount; i++) {
            System.out.print("Enter doctor name: ");
            Doctor doctor = new Doctor(sc.nextLine());
            doctors.add(doctor);
            hospital.addDoctor(doctor);
        }

        // Adding Patients
        System.out.print("How many patients to add? ");
        int patientCount = sc.nextInt();
        sc.nextLine();

        ArrayList<Patient> patients = new ArrayList<>();
        for (int i = 0; i < patientCount; i++) {
            System.out.print("Enter patient name: ");
            Patient patient = new Patient(sc.nextLine());
            patients.add(patient);
            hospital.addPatient(patient);
        }

        // Consultations
        System.out.print("How many consultations to add? ");
        int consultationCount = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < consultationCount; i++) {
            System.out.print("Enter doctor's name for consultation: ");
            String doctorName = sc.nextLine();
            System.out.print("Enter patient's name for consultation: ");
            String patientName = sc.nextLine();

            Doctor doctor = doctors.stream().filter(d -> d.getName().equals(doctorName)).findFirst().orElse(null);
            Patient patient = patients.stream().filter(p -> p.getName().equals(patientName)).findFirst().orElse(null);

            if (doctor != null && patient != null) {
                doctor.consult(patient);
            }
            else {
                System.out.println("Invalid doctor or patient name.");
            }
        }

        // Display Hospital Details
        System.out.println();
        hospital.displayDetails();

        // Display Consultations
        System.out.println();
        for (Doctor doctor : doctors) {
            doctor.showPatients();
        }
    }
}


/*
I/P ->
Enter hospital name: Fortis
How many doctors to add? 2
Enter doctor name: Sanya Khanna
Enter doctor name: Arushi Sharma
How many patients to add? 3
Enter patient name: John White
Enter patient name: Mike Newton
Enter patient name: Alice
How many consultations to add? 2
Enter doctor's name for consultation: Sanya Khanna
Enter patient's name for consultation:
Invalid doctor or patient name.
Enter doctor's name for consultation: Sanya Khanna
Enter patient's name for consultation: John White
Dr. Sanya Khanna is consulting John White

O/P ->
Hospital: Fortis
Doctors:
  - Sanya Khanna
  - Arushi Sharma
Patients:
  - John White
  - Mike Newton
  - Alice

Dr. Sanya Khanna's Patients:
  - John White
Dr. Arushi Sharma's Patients:
 */