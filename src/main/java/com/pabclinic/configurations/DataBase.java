package com.pabclinic.configurations;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class DataBase {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost/PABClinic";
    private static final String LOGIN = "postgres";
//    private static final String PASSWORD = "ANDpig1906!@"; // Andrzeja hasło na postgresa
//        private static final String PASSWORD = "Qparox123!"; // Pawła hasło na postgresa
    private static final String PASSWORD = "postgres"; // Bartka hasło na postgresa

    private Statement stmt;
    private Connection conn;

    public DataBase() {

    }

    public Statement getStmt() {
        return stmt;
    }

    public Connection getConn() {
        return conn;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void connectToDb() throws ClassNotFoundException, SQLException {

        Class.forName(JDBC_DRIVER);

        conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);

        stmt = conn.createStatement();
    }

    public void disconnectDB() throws SQLException {
        stmt.close();
        conn.close();
    }

}
