package com.prog.repository;

import com.prog.model.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.prog.connectionDB.ConnectionDB.createConnection;

public class AuthorCrudOperations implements CrudOperations<Author> {
    public AuthorCrudOperations() { }

    @Override
    public Author getById(String id) {
        String sql = "SELECT  * FROM \"author\" WHERE id = '" + id + "';";
        Author responseSQL = null;

        try {
            ResultSet resultSet = createConnection().createStatement().executeQuery(sql);

            while (resultSet.next()) {
                responseSQL = new Author(
                                resultSet.getString("id"),
                                resultSet.getString("name"),
                                resultSet.getString("sex"));
            }
            return responseSQL;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Author> findAll() {
        String sql = "SELECT  * FROM \"author\" ORDER BY name;";
        List<Author> responseSQL = new ArrayList<>();

        try {
            ResultSet resultSet = createConnection().createStatement().executeQuery(sql);

            while (resultSet.next()) {
                responseSQL.add(new Author(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("sex")
                        )
                );
            }
            return responseSQL;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) {
        for (Author author : toSave) {
            save(author);
        }
        return toSave;
    }

    @Override
    public Author save(Author toSave) {
        String sql = "INSERT INTO \"author\" (id, name, sex) VALUES ('" + toSave.getId() + "', '" + toSave.getName() + "', '"
                + toSave.getSex() + "' );";

        try {
            createConnection().createStatement().executeUpdate(sql);
            return getById(toSave.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Author delete(Author toDelete) {
        String sql = "DELETE FROM \"author\" WHERE id = '" + toDelete.getId() + "' ;";
        try {
            createConnection().createStatement().executeUpdate(sql);
            return toDelete;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
