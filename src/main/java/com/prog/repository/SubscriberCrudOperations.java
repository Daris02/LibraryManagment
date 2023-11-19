package com.prog.repository;

import com.prog.model.Subscriber;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.prog.connectionDB.ConnectionDB.createConnection;

public class SubscriberCrudOperations implements CrudOperations<Subscriber> {
    @Override
    public Subscriber getById(String id) {
        String sql = "SELECT  * FROM \"subscriber\" WHERE id = '" + id + "';";
        Subscriber responseSQL = null;

        try {
            ResultSet resultSet = createConnection().createStatement().executeQuery(sql);

            while (resultSet.next()) {
                responseSQL = new Subscriber(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("reference"));
            }
            return responseSQL;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Subscriber> findAll() {
        String sql = "SELECT  * FROM \"subscriber\" ORDER BY name;";
        List<Subscriber> responseSQL = new ArrayList<>();

        try {
            ResultSet resultSet = createConnection().createStatement().executeQuery(sql);

            while (resultSet.next()) {
                responseSQL.add(new Subscriber(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("reference"))
                );
            }
            return responseSQL;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Subscriber> saveAll(List<Subscriber> toSave) {
        for (Subscriber subscriber : toSave) {
            save(subscriber);
        }
        return null;
    }

    @Override
    public Subscriber save(Subscriber toSave) {
        String sql = "INSERT INTO \"subscriber\" VALUES ('" + toSave.getId() + "', '" + toSave.getName() + "', '" + toSave.getReference() + "' );";

        try {
            createConnection().createStatement().executeUpdate(sql);
            return getById(toSave.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Subscriber delete(Subscriber toDelete) {
        String sql = "DELETE FROM \"subscriber\" WHERE id = '" + toDelete.getId() + "' ;";
        try {
            createConnection().createStatement().executeUpdate(sql);
            return toDelete;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
