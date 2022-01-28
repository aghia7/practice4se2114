package db.postgres;

import db.DB;

import java.sql.*;

public class Postgres implements DB {
    private Connection conn;

    public Postgres() {
        String connectionUrl = "jdbc:postgresql://localhost:5432/simpleappdb";

        try {
            Class.forName("org.postgresql.Driver"); // do we have this kind of driver
            conn = DriverManager.getConnection(connectionUrl, "postgres", "0000");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        return conn;
    }

    @Override
    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
