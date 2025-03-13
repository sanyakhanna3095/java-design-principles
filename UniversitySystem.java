import java.util.ArrayList;
import java.util.Scanner;

// Faculty class (Can exist independently)
class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// AcademicDepartment class (Exists only within a University → Composition)
class AcademicDepartment {
    private String name;

    public AcademicDepartment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// University class (Composition: Contains Departments, Aggregation: Contains Faculty)
class University {
    private String name;
    private ArrayList<AcademicDepartment> departments; // Composition
    private ArrayList<Faculty> faculties; // Aggregation

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    // Adding Departments (Composition)
    public void addDepartment(String deptName) {
        departments.add(new AcademicDepartment(deptName));
    }

    // Adding Faculty (Aggregation)
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    // Display University details
    public void displayDetails() {
        System.out.println("University: " + name);

        // Display Departments
        System.out.println("Departments:");
        for (AcademicDepartment department : departments) {
            System.out.println("  - " + department.getName());
        }

        // Display Faculty
        System.out.println("Faculty Members:");
        for (Faculty faculty : faculties) {
            System.out.println("  - " + faculty.getName());
        }
    }
}

// Main class to demonstrate Composition & Aggregation with user input
public class UniversitySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating University
        System.out.print("Enter university name: ");
        University uni = new University(sc.nextLine());

        // Adding Departments
        System.out.print("How many departments to add? ");
        int deptCount = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < deptCount; i++) {
            System.out.print("Enter department name: ");
            uni.addDepartment(sc.nextLine());
        }

        // Adding Faculty
        System.out.print("How many faculty members to add? ");
        int facultyCount = sc.nextInt();
        sc.nextLine();

        ArrayList<Faculty> faculties = new ArrayList<>();

        for (int i = 0; i < facultyCount; i++) {
            System.out.print("Enter faculty member name: ");
            Faculty faculty = new Faculty(sc.nextLine());
            faculties.add(faculty);
            uni.addFaculty(faculty);
        }

        // Displaying University Details
        uni.displayDetails();

        // Deleting University (Departments should be deleted, Faculty still exists)
        uni = null;
        System.out.println("\nUniversity deleted! Departments are gone, but Faculty still exists.");
//        uni.displayDetails();
        System.out.print("Faculty members still exist: ");
        for (int i = 0; i < faculties.size(); i++) {
            System.out.print(faculties.get(i).getName());
            if (i < faculties.size() - 1) System.out.print(", ");
        }

    }
}


/*

I/P ->
Enter university name: Chitkara University
How many departments to add? 2
Enter department name: CSE
Enter department name: Lw
How many faculty members to add? 4
Enter faculty member name: Sanya Khanna
Enter faculty member name: Chirag Sharma
Enter faculty member name: Manpreet Kaur
Enter faculty member name: Hargun

O/P ->
University: Chitkara University
Departments:
  - CSE
  - Lw
Faculty Members:
  - Sanya Khanna
  - Chirag Sharma
  - Manpreet Kaur
  - Hargun

University deleted! Departments are gone, but Faculty still exists.
Faculty members still exist: Sanya Khanna, Chirag Sharma, Manpreet Kaur, Hargun
 */