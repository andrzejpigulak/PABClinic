package com.PabClinic.Model.Database;
import com.PabClinic.Model.Patient.Patient;
import java.sql.*;
import java.util.ArrayList;

public class DBPatient {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost/PABClinic";
    private static final String LOGIN = "postgres";
//    private static final String PASSWORD = "Qparox123!"; // Pawła hasło na postgresa
    private static final String PASSWORD = "postgres"; // Bartka hasło na postgresa


    private Statement stmt;
    Connection conn;

    public DBPatient() {

    }

    public void getPatients(ArrayList<Patient> patientList){


        try {
            connectToDb();

            ResultSet rs = stmt.executeQuery("select * from patient");

            while (rs.next()) {
                Patient patient = new Patient(rs.getInt("user_id"),rs.getString("firstname"),rs.getString("lastname"),
                        rs.getString("userpassword"),rs.getLong("pesel"),rs.getString("login"),rs.getString("email"),
                        rs.getInt("telephonenumber"), rs.getString("address"), rs.getString("postcode"), rs.getString("city"));
                patientList.add(patient);
            }

            disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void connectToDb() throws ClassNotFoundException, SQLException {

        Class.forName(JDBC_DRIVER);

        conn = DriverManager.getConnection(URL,LOGIN,PASSWORD);

        stmt = conn.createStatement();
    }

    private void disconnectDB() throws SQLException {
        stmt.close();
        conn.close();
    }


}
