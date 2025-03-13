import java.util.ArrayList;
import java.util.Scanner;

// Student class
class StudentInfo {
    private String name;
    private ArrayList<CourseInfo> courses;

    public StudentInfo(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(CourseInfo course) {
        courses.add(course);
        course.addStudent(this);
    }

    public void displayCourses() {
        System.out.println("Student: " + name);
        System.out.println("Enrolled Courses:");
        for (CourseInfo course : courses) {
            System.out.println("  - " + course.getCourseName());
        }
    }
}

// Professor class
class Professor {
    private String name;
    private ArrayList<CourseInfo> courses;

    public Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void assignCourse(CourseInfo course) {
        courses.add(course);
        course.setProfessor(this);
    }

    public void displayCourses() {
        System.out.println("Professor: " + name);
        System.out.println("Teaching Courses:");
        for (CourseInfo course : courses) {
            System.out.println("  - " + course.getCourseName());
        }
    }
}

// Course class
class CourseInfo {
    private String courseName;
    private Professor professor;
    private ArrayList<StudentInfo> students;

    public CourseInfo(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addStudent(StudentInfo student) {
        students.add(student);
    }

    public void displayDetails() {
        System.out.println("Course: " + courseName);
        if (professor != null) {
            System.out.println("Professor: " + professor.getName());
        }
        System.out.println("Enrolled Students:");
        for (StudentInfo student : students) {
            System.out.println("  - " + student.getName());
        }
    }
}

// Main class
public class UniversityManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating courses
        System.out.print("How many courses to add? ");
        int courseCount = sc.nextInt();
        sc.nextLine();
        ArrayList<CourseInfo> courses = new ArrayList<>();
        for (int i = 0; i < courseCount; i++) {
            System.out.print("Enter course name: ");
            courses.add(new CourseInfo(sc.nextLine()));
        }

        // Creating professors
        System.out.print("How many professors to add? ");
        int professorCount = sc.nextInt();
        sc.nextLine();
        ArrayList<Professor> professors = new ArrayList<>();
        for (int i = 0; i < professorCount; i++) {
            System.out.print("Enter professor name: ");
            professors.add(new Professor(sc.nextLine()));
        }

        // Assigning courses to professors
        for (Professor professor : professors) {
            System.out.print("How many courses to assign to " + professor.getName() + "? ");
            int assignCount = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < assignCount; j++) {
                System.out.print("Enter course name to assign: ");
                String courseName = sc.nextLine();
                CourseInfo course = courses.stream().filter(c -> c.getCourseName().equals(courseName)).findFirst().orElse(null);
                if (course != null) {
                    professor.assignCourse(course);
                }
                else {
                    System.out.println("Course not found.");
                }
            }
        }

        // Creating students
        System.out.print("How many students to add? ");
        int studentCount = sc.nextInt();
        sc.nextLine();
        ArrayList<StudentInfo> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            System.out.print("Enter student name: ");
            students.add(new StudentInfo(sc.nextLine()));
        }

        // Enrolling students in courses
        for (StudentInfo student : students) {
            System.out.print("How many courses to enroll " + student.getName() + " in? ");
            int enrollCount = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < enrollCount; j++) {
                System.out.print("Enter course name to enroll in: ");
                String courseName = sc.nextLine();
                CourseInfo course = courses.stream().filter(c -> c.getCourseName().equals(courseName)).findFirst().orElse(null);
                if (course != null) {
                    student.enrollCourse(course);
                }
                else {
                    System.out.println("Course not found.");
                }
            }
        }

        // Displaying details
        for (CourseInfo course : courses) {
            System.out.println();
            course.displayDetails();
        }
        for (StudentInfo student : students) {
            System.out.println();
            student.displayCourses();
        }
        for (Professor professor : professors) {
            System.out.println();
            professor.displayCourses();
        }
    }
}


/*

I/P ->
How many courses to add? 2
Enter course name: CSE
Enter course name: Law
How many professors to add? 2
Enter professor name: Sanya Khanna
Enter professor name: Mehak Sharma
How many courses to assign to Sanya Khanna? 1
Enter course name to assign: Law
How many courses to assign to Mehak Sharma? 2
Enter course name to assign: Law
Enter course name to assign: CSE
How many students to add? 3
Enter student name: John White
Enter student name: Harry Allen
Enter student name: Rishabh Jain
How many courses to enroll John White in? 1
Enter course name to enroll in: CSE
How many courses to enroll Harry Allen in? 3
Enter course name to enroll in: Law
Enter course name to enroll in: CSE
Enter course name to enroll in: IT
Course not found.
How many courses to enroll Rishabh Jain in? 2
Enter course name to enroll in: Law
Enter course name to enroll in: It
Course not found.

O/P ->
Course: CSE
Professor: Mehak Sharma
Enrolled Students:
  - John White
  - Harry Allen

Course: Law
Professor: Mehak Sharma
Enrolled Students:
  - Harry Allen
  - Rishabh Jain

Student: John White
Enrolled Courses:
  - CSE

Student: Harry Allen
Enrolled Courses:
  - Law
  - CSE

Student: Rishabh Jain
Enrolled Courses:
  - Law

Professor: Sanya Khanna
Teaching Courses:
  - Law

Professor: Mehak Sharma
Teaching Courses:
  - Law
  - CSE

 */