package com.prog.services;

import java.util.List;
import java.util.UUID;

import com.prog.model.Book;
import com.prog.repository.BookCrudOperations;

public class BookService {
    private BookCrudOperations bookCrudOp = new BookCrudOperations();
    
    public Book getBookById(String id) {
        return bookCrudOp.getById(id);
    }

    public List<Book> getAllBooks() {
        return bookCrudOp.findAll();
    }

    public Book saveBook(Book book) {
        book.setId(UUID.randomUUID().toString());

        return bookCrudOp.save(book);
    }

    public List<Book> saveAllBooks(List<Book> books) {
        for (Book book : books) {
            book.setId(UUID.randomUUID().toString());
        }

        return bookCrudOp.saveAll(books);
    }

    public Book deleBook(Book book) {
        Book toDelete = getBookById(book.getId());
        if (toDelete == null) {
            System.out.println("Book not exist");
            return null;
        }
        return bookCrudOp.delete(book);
    }
    
}
