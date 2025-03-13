import java.util.ArrayList;
import java.util.Scanner;

// Course class (Can exist independently)
class Course {
    private String name;
    private ArrayList<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public void displayEnrolledStudents() {
        System.out.println("Course: " + name + " has students:");
        for (Student student : students) {
            System.out.println("  - " + student.getName());
        }
    }
}

// Student class (Can exist independently)
class Student {
    private String name;
    private ArrayList<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    public void displayEnrolledCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println("  - " + course.getName());
        }
    }
}

// School class (Aggregation)
class School {
    private String name;
    private ArrayList<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("School: " + name + " has students:");
        for (Student student : students) {
            System.out.println("  - " + student.getName());
        }
    }
}

// Main class to demonstrate user input
public class SchoolSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter school name: ");
        School school = new School(sc.nextLine());

        System.out.print("How many students to add? ");
        int studentCount = sc.nextInt();
        sc.nextLine();

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < studentCount; i++) {
            System.out.print("Enter student name: ");
            Student student = new Student(sc.nextLine());
            students.add(student);
            school.addStudent(student);
        }

        System.out.print("How many courses to add? ");
        int courseCount = sc.nextInt();
        sc.nextLine();

        ArrayList<Course> courses = new ArrayList<>();

        for (int i = 0; i < courseCount; i++) {
            System.out.print("Enter course name: ");
            Course course = new Course(sc.nextLine());
            courses.add(course);
        }

        for (Student student : students) {
            System.out.print("How many courses to enroll " + student.getName() + " in? ");
            int enrollCount = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < enrollCount; j++) {
                System.out.print("Enter course name for " + student.getName() + ": ");
                String courseName = sc.nextLine();

                for (Course course : courses) {
                    if (course.getName().equalsIgnoreCase(courseName)) {
                        student.enrollInCourse(course);
                    }
                }
            }
        }

        school.displayStudents();
        for (Student student : students) {
            student.displayEnrolledCourses();
        }
        for (Course course : courses) {
            course.displayEnrolledStudents();
        }

    }
}


/*

I/P->
Enter school name: KVM
How many students to add? 4
Enter student name: Sanya Khanna
Enter student name: Sehajpreet
Enter student name: Chirag
Enter student name: Riya Dhir
How many courses to add? 3
Enter course name: Java
Enter course name: Fine Arts
Enter course name: Dance
How many courses to enroll Sanya Khanna in? 2
Enter course name for Sanya Khanna: Java
Enter course name for Sanya Khanna: Fine Arts
How many courses to enroll Sehajpreet in? 1
Enter course name for Sehajpreet: Dance
How many courses to enroll Chirag in? 3
Enter course name for Chirag: Java
Enter course name for Chirag: Dance
Enter course name for Chirag:
How many courses to enroll Riya Dhir in? 1
Enter course name for Riya Dhir: Dance


O/P ->
School: KVM has students:
  - Sanya Khanna
  - Sehajpreet
  - Chirag
  - Riya Dhir
Student: Sanya Khanna is enrolled in:
  - Java
  - Fine Arts
Student: Sehajpreet is enrolled in:
  - Dance
Student: Chirag is enrolled in:
  - Java
  - Dance
Student: Riya Dhir is enrolled in:
  - Dance
Course: Java has students:
  - Sanya Khanna
  - Chirag
Course: Fine Arts has students:
  - Sanya Khanna
Course: Dance has students:
  - Sehajpreet
  - Chirag
  - Riya Dhir

 */