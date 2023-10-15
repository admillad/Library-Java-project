package org.matilda;

import java.util.ArrayList;
import java.util.Scanner;

public class Member extends User {
    //additional member field (compare to user class) is a list of borrowed book
    private ArrayList<Book> borrowedBook;


    //Constructor Member
    public Member() {
        this.borrowedBook = new ArrayList<Book>();
    }

    public Member(String userName, String password) {
        super(userName, password);
        this.borrowedBook = new ArrayList<Book>();

    }

    public Member(String firstName, String lastName, String userName, String password, ArrayList<Book> borrowedBook) {
        super(firstName, lastName, userName, password);
        this.borrowedBook = new ArrayList<Book>();

    }

    public ArrayList<Book> getBorrowedBook() {
        return borrowedBook;
    }

    //Adds book to the member's borrowed bok list.
    public void addToBorrowedBook(Book book) {
        borrowedBook.add(book);
        System.out.println("The book has been successfully added.");
    }

    //finds book position
    private int findBook(Book book) {
        return this.borrowedBook.indexOf(book);
    }

    private int findBook(String bookTitle) {
        for (int i = 0; i < this.borrowedBook.size(); i++) {
            Book book = this.borrowedBook.get(i);
            if (book.getTitle().equals(bookTitle)) {
                return i;
            }
        }
        return -1;
    }

    //Removes book from member's borrowed book list when it's been return to the library.
    public boolean removeFromBorrowedBook(Book book) {
        int bookPosition = findBook(book);
        if (bookPosition < 0) {
            System.out.println("The Book " + book.getTitle() + " is not in the collection.");
            return false;
        }
        this.borrowedBook.remove(bookPosition);
        System.out.println("The book removed successfully.");
        return true;
    }

    public boolean removeFromBorrowedBook(String bookTitle) {
        int bookPosition = findBook(bookTitle);
        if (bookPosition < 0) {
//            System.out.println("The Book "  + book.getTitle() + " is not in the collection.");
            return false;
        }
        this.borrowedBook.remove(bookPosition);
        System.out.println("The book removed successfully.");
        return true;
    }

    //prints all items of books in member borrowed list
    public void printBorrowedBook() {
        System.out.println("You have " + this.borrowedBook.size() + " items in your list: \n");
        for (int i = 0; i < this.borrowedBook.size(); i++) {
            System.out.println((i + 1) + ", " + this.borrowedBook.get(i).getTitle());
        }
    }

    // options for a member.
    public void showOptionMember() {
        System.out.println("\nWhat action do you want to do:\n");
        System.out.println("1) Borrow a new book ");
        System.out.println("2) Return a book");
        System.out.println("3) Show all my borrowed book");
        System.out.println("4) Show all available books");
        System.out.println("5) enter quit to exit.");
    }
}


