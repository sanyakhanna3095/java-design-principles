import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println("Book: " + title + " by " + author);
    }
}

// Library class (Aggregation)
class Library {
    private String name;
    private ArrayList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("\nLibrary: " + name);
        for (int i = 0; i < books.size(); i++) {
            books.get(i).display();
        }
    }
}

// Main class to demonstrate Aggregation
public class LibrarySystem {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        //Take user input
        System.out.println("Enter the name of book: ");
        String name=sc.nextLine();
        System.out.println("Enter the name of author: ");
        String author=sc.nextLine();
        // Creating independent books
        Book b1 = new Book(name, author);
        Book b2 = new Book("Wings of Fire", "APJ Abdul Kalam");
        Book b3 = new Book("Meditations", "Marcus Aurelius");

        // Creating libraries
        System.out.println("Enter the library name: ");
        String lib=sc.nextLine();
        Library lib1 = new Library(lib);
        Library lib2 = new Library("Chitkara Library");

        // Adding books to libraries
        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2);
        lib2.addBook(b3);

        // Display books in each library
        lib1.displayBooks();
        lib2.displayBooks();
    }
}


/*
I/P ->
Enter the name of book:
Harry Potter
Enter the name of author:
JK. Rowling
Enter the library name:
PU Library

O/P->
Library: PU Library
Book: Harry Potter by JK. Rowling
Book: Wings of Fire by APJ Abdul Kalam

Library: Chitkara Library
Book: Wings of Fire by APJ Abdul Kalam
Book: Meditations by Marcus Aurelius
 */