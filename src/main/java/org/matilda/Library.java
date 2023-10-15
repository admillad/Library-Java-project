package org.matilda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> bookCollection ;
    private ArrayList<User> memberCollection;


    public Library(){
        this.bookCollection=new ArrayList<Book>();
        this.memberCollection=new ArrayList<User>();
    }


    // prints all the books available in the library
    public void printBookCollection(){
        System.out.println("There are currently "+ this.bookCollection.size() +" books available in the Library: ");
        for (int i=0;i<this.bookCollection.size();i++){
            System.out.println((i+1) + ". " + this.bookCollection.get(i).getTitle()) ;
        }
    }
    //adds new books to the library if the book is not exists in the collection.
    public boolean addToBookCollection(Book book){
        if(findBook(book.getTitle()) >=0){
            System.out.println("Book is already exists.");
            return false;
        }
        this.bookCollection.add(book);
        System.out.println("The book has been successfully added.");
        return true;
    }
    //It will go through bookcollecation to find the book and will return the index number of book if it exists in the collection.
    private int findBook(Book book){
        return this.bookCollection.indexOf(book);
    }
    private int findBook(String bookTitle) {
        for (int i = 0; i < this.bookCollection.size(); i++) {
            Book book = this.bookCollection.get(i);
            if (book.getTitle().equals(bookTitle)) {
                return i;
            }
        }return -1;
    }

    //removes book from library's Book collection if the book exists.
    public boolean removeFromBookCollection(Book book){
        int bookPosition=findBook(book);
        if (bookPosition<0){
            System.out.println("The Book "  + book.getTitle() + " is not in the collection.");
            return false;
        }
        this.bookCollection.remove(bookPosition);
        System.out.println("The book removed successfully.");
        return true;
    }
    public Book queryBook(String name){
        int position=findBook(name);
        if (position>=0){
            return this.bookCollection.get(position);
        }return null;
    }
    //add new member to Library's Member list:
    public void addNewMemberToMemberList(User user){
        memberCollection.add(user);
        System.out.println("The new member has been successfully added.");
    }

}
