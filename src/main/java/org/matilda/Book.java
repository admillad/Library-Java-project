package org.matilda;

public class Book extends Library {
    private String title;
    private String author;

    //Constructor 1
    public Book(){
        this("title","author");
    }
    public Book(String title, String author){
        this.title= title;
        this.author= author;
    }
    //Constructor 2
    public Book(String title){
        this(title, "author");
    }
    //getter author
    public String getAuthor() {
        return author;
    }

    //getter title
    public String getTitle() {
        return title;
    }

    //creates new book objects. "Factory method"
    public static Book createBook(String title,String author){
        return new Book(title,author);
    }
}
