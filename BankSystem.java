import java.util.ArrayList;
import java.util.Scanner;

// Bank class
class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    public void openAccount(Customer customer) {
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("Account opened for " + customer.getName() + " in " + name);
    }

    public String getName() {
        return name;
    }
}

// Customer class
class Customer {
    private String name;
    private Bank bank;

    public Customer(String name, Bank bank) {
        this.name = name;
        this.bank = bank;
    }

    public void viewBalance() {
        System.out.println(name + " has an account in " + bank.getName()); // Now this works
    }

    public String getName() {
        return name;
    }
}

// Main class
public class BankSystem {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        //Take user input
        System.out.println("Enter bank name: ");
        String bank=sc.nextLine();
        System.out.println("Enter name of account holder: ");
        String name=sc.nextLine();
        Bank b1 = new Bank(bank);
        Customer c1 = new Customer(name, b1);
        Customer c2 = new Customer("Rahul Sharma", b1);

        b1.openAccount(c1);
        b1.openAccount(c2);

        c1.viewBalance();
        c2.viewBalance();
    }
}

/*
Enter bank name:
Bank of Baroda
Enter name of account holder:
Sanya Khanna
Account opened for Sanya Khanna in Bank of Baroda
Account opened for Rahul Sharma in Bank of Baroda
Sanya Khanna has an account in Bank of Baroda
Rahul Sharma has an account in Bank of Baroda
 */