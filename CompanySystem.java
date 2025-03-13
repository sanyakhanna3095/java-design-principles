import java.util.ArrayList;
import java.util.Scanner;

// Employee class (Exists only within Department)
class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("   Employee: " + name);
    }
}

// Department class (Exists only within Company)
class Department {
    private String name;
    private ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void addEmployee(String empName) {
        employees.add(new Employee(empName));
    }

    public void display() {
        System.out.println(" Department: " + name);
        for (int i = 0; i < employees.size(); i++) {
            employees.get(i).display();
        }
    }
}

// Company class (Deleting Company deletes all Departments and Employees)
class Company {
    private String name;
    private ArrayList<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addEmployeeToDepartment(String deptName, String empName) {
        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).getName().equals(deptName)) {
                departments.get(i).addEmployee(empName);
                return;
            }
        }
    }


    public void display() {
        System.out.println("Company: " + name);
        for (int i = 0; i < departments.size(); i++) {
            departments.get(i).display();
        }
    }
}

// Main class to demonstrate Composition
public class CompanySystem {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        //Take user input
        System.out.println("Enter name of the comapany: ");
        String company=sc.nextLine();
        Company c1 = new Company(company);


        c1.addDepartment("IT");
        c1.addDepartment("HR");

        c1.addEmployeeToDepartment("IT", "Sanya Khanna");
        c1.addEmployeeToDepartment("HR", "Sehajpreet Kaur");
        c1.addEmployeeToDepartment("IT", "Ritik");

        c1.display(); // Display Company, Departments, and Employees
    }
}

/*
I/P ->
Enter name of the comapany:
Amazon

O/P->
Company: Amazon
 Department: IT
   Employee: Sanya Khanna
   Employee: Ritik
 Department: HR
   Employee: Sehajpreet Kaur

 */