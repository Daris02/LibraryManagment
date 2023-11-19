package com.prog.services;

import java.util.List;
import java.util.UUID;

import com.prog.model.Author;
import com.prog.repository.AuthorCrudOperations;

public class AuthorService {
    private AuthorCrudOperations authorCrudOp = new AuthorCrudOperations();
    
    public Author getAuthorById(String id) {
        return authorCrudOp.getById(id);
    }

    public List<Author> getAllAuthors() {
        return authorCrudOp.findAll();
    }

    public Author saveAuthor(Author author) {
        author.setId(UUID.randomUUID().toString());

        return authorCrudOp.save(author);
    }

    public List<Author> saveAllAuthors(List<Author> authors) {
        for (Author author : authors) {
            author.setId(UUID.randomUUID().toString());
        }

        return authorCrudOp.saveAll(authors);
    }

    public Author deleAuthor(Author author) {
        Author toDelete = getAuthorById(author.getId());
        if (toDelete == null) {
            System.out.println("Author not exist");
            return null;
        }
        return authorCrudOp.delete(author);
    }
    
}
