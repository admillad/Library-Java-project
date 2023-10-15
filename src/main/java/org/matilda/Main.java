package org.matilda;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library();
    private static Member member = new Member();

    public static void main(String[] args) {
        User user = new User();
        BookKeeper bookKeeper = new BookKeeper();
        Scanner scanner = new Scanner(System.in);
        System.out.println("please select one of options below: ");
//        Scanner scanner = new Scanner(System.in);
        int in;
        int actionChoice1;
        int actionChoice2;

        do {
            //Displays first options to gets type of user
            user.getTypeOfUser();
            in = scanner.nextInt();
            switch (in) {
                // displays options for member and gets the action
                case 1:
                    System.out.println("-------Welcome to the library ------");
                    boolean quit = false;
                    while (!quit) {
                        member.showOptionMember();
                        actionChoice1 = scanner.nextInt();
                        switch (actionChoice1) {
                            case 1:
                                addNewBorrowedBook();
                                break;
                            case 2:
                                removeBorrowedBook();
                                break;
                            case 3:
                                member.printBorrowedBook();
                                break;
                            case 4:
                                library.printBookCollection();
                            case 5:
                                System.out.println("See you Next time.");
                                quit = true;
                                break;
                        }

                    }
                    break;

                //displays options for bookkeeper and gets the action
                case 2:
                    System.out.println("-------Welcome to the library ------\n");
                    boolean quit2 = false;
                    while (!quit2) {
                        bookKeeper.showOptionBookKeeper();
                        actionChoice2 = scanner.nextInt();
                        switch (actionChoice2) {
                            case 1:
                                addNewBookToCollection();
                                break;
                            case 2:
                                removeBookFromCollection();
                                break;
                            case 3:
                                addNewMember();
                                break;
                            case 4:
                                library.printBookCollection();
                                break;
                            case 5:
                                System.out.println("See you Next time.");
                                quit2 = true;
                                break;

                        }
                    }break;

            }
            break;


        } while (in != 3);
    }

    //Calls add book method from member class and will add new book abject to member's borrowed book list.
    private static void addNewBorrowedBook() {
        System.out.println("Please enter the book title:  ");
        String title = scanner.nextLine();
        System.out.println("Please enter book's author: ");
        String author = scanner.nextLine();
        Book newBook = Book.createBook(title, author);
        member.addToBorrowedBook(newBook);
    }

    //Calls remove book method from member class and will delete the book from member's borrowed book list.
//    private static void removeBorrowedBook() {
//        System.out.println("Please enter the book title:  ");
//        String title = scanner.nextLine();
//        System.out.println("Please enter book's author: ");
//        String author = scanner.nextLine();
//        Book newBook = Book.createBook(title, author);
//        member.removeFromBorrowedBook(newBook);
//    }
    private static void removeBorrowedBook() {
        System.out.println("Please enter the book title:  ");
        String bookTitle = scanner.nextLine();

        member.removeFromBorrowedBook(bookTitle);
    }

    // will call add member method in library class and add member to the library's member list.
    private static void addNewMember() {
        System.out.println("please enter new member Firstname: ");
        String firstname = scanner.nextLine();
        System.out.println("please enter new member Lastname: ");
        String lastname = scanner.nextLine();
        System.out.println("please enter new member username: ");
        String username = scanner.nextLine();
        System.out.println("please enter new member password: ");
        String password = scanner.nextLine();
        User newUser = User.createUser(firstname, lastname, username, password);
        library.addNewMemberToMemberList(newUser);
    }

    //will call remove book method from library class and removes the book from library's book collection.
    private static void removeBookFromCollection() {
        System.out.println("Please enter the book title:  ");
        String title = scanner.nextLine();
        System.out.println("Please enter book's author: ");
        String author = scanner.nextLine();
        Book newBook = Book.createBook(title, author);
        library.removeFromBookCollection(newBook);
    }

    //will call add book method from library class and add the book to the library's book collection.
    private static void addNewBookToCollection() {
        System.out.println("Please enter the book title:  ");
        String title = scanner.nextLine();
        System.out.println("Please enter book's author: ");
        String author = scanner.nextLine();
        Book newBook = Book.createBook(title, author);
        library.addToBookCollection(newBook);
    }
}
