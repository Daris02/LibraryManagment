package com.prog;

import java.util.Arrays;

import com.prog.model.Author;
import com.prog.services.AuthorService;
import com.prog.services.BookService;

public class Main {

    public static void main(String[] args) throws Exception {
        test();
    }

    public static void test() {
        AuthorService testAuthor = new AuthorService();
        BookService testBook = new BookService();

    //  System.out.println(testAuthor.getAllAuthors());
    //  System.out.println(testAuthor.getAuthorById("e9aafb2f-8627-41fe-9111-ca141446b354"));
    //  System.out.println(testAuthor.saveAuthor(new Author( "Christian Bale", "M")));
    //  Author[] list = {new Author("Alice", "F"), new Author("Bob", "M")};
    //  System.out.println(testAuthor.saveAllAuthors(Arrays.asList(list)));
    //  System.out.println(testAuthor.deleAuthor(new Author("edd94a0b-ef79-48f4-b14b-3f14a1118689", "Alice", "M")));

    //  System.out.println(testBook.getAllBooks());
        System.out.println(testBook.getBookById("fd84b946-9ed3-48c6-8672-1dada63d1ba3")); 
        
    }
}