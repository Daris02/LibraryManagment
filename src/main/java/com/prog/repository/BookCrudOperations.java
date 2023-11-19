package com.prog.repository;

import com.prog.model.Author;
import com.prog.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.prog.connectionDB.ConnectionDB.createConnection;

public class BookCrudOperations implements CrudOperations<Book> {
    @Override
    public Book getById(String id) {
        String sql = "SELECT b.id, b.bookname, b.releasedate, b.idauthor, b.topic, a.name, a.sex FROM \"book\" b INNER JOIN \"author\" a ON b.idauthor = a.id  WHERE b.id = '" + id + "';";
        Book responseSQL = null;

        try {
            ResultSet resultSet = createConnection().createStatement().executeQuery(sql);

            while (resultSet.next()) {
                responseSQL = new Book(
                        resultSet.getString("id"),
                        resultSet.getString("bookname"),
                        new Author(resultSet.getString("idAuthor"), resultSet.getString("name"), resultSet.getString("sex")),
                        resultSet.getString("topic"),
                        resultSet.getDate("releaseDate")
                );
            }
            return responseSQL;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> findAll() {
         String sql = "SELECT b.id, b.bookname, b.releasedate, b.idauthor, b.topic, a.name, a.sex FROM \"book\" b INNER JOIN \"author\" a ON b.idauthor = a.id";
         List<Book> responseSQL = new ArrayList<>();

        try {
            ResultSet resultSet = createConnection().createStatement().executeQuery(sql);

            while (resultSet.next()) {
                responseSQL.add(new Book(
                        resultSet.getString("id"),
                        resultSet.getString("bookname"),
                        new Author(resultSet.getString("idAuthor"), resultSet.getString("name"), resultSet.getString("sex")),
                        resultSet.getString("topic"),
                        resultSet.getDate("releaseDate"))
                );
            }
            return responseSQL;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> saveAll(List<Book> toSave) {
        for (Book book : toSave) {
            save(book);
        }
        return toSave;
    }


    @Override
    public Book save(Book toSave) {
        String sql = "INSERT INTO \"book\" (id, bookname, releasedate) VALUES ('" + toSave.getId() + "', '" + toSave.getBookName() + "', '"
                + toSave.getReleaseDate().toString() + "' );";

        try {
            createConnection().createStatement().executeUpdate(sql);
            return getById(toSave.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }


    @Override
    public Book delete(Book toDelete) {
        String sql = "DELETE FROM \"book\" WHERE id = '" + toDelete.getId() + "' ;";
        try {
            createConnection().createStatement().executeUpdate(sql);
            return toDelete;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toDelete;
    }

}
