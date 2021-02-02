package com.PabClinic.Model.Database;
import com.PabClinic.Model.Patient.Patient;
import java.sql.*;
import java.util.ArrayList;

public class DBPatient {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost/PABClinic";
    private static final String LOGIN = "postgres";
//        private static final String PASSWORD = "ANDpig1906!@"; // Andrzeja hasło na postgresa
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

    public void registerPatient(Patient patient) {

        try {
            connectToDb();

            String queryCount = "SELECT COUNT(*) from patient";

            ResultSet rs = stmt.executeQuery(queryCount);
            rs.next();

            int i = rs.getInt("count");

            String queryInsert = "insert into patient (firstName, lastName, userPassword, pesel, login, email, telephoneNumber, address, postCode, city) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(queryInsert);

//            preparedStatement.setInt(1, ++i);
            preparedStatement.setString(1,patient.getFirstName());
            preparedStatement.setString(2,patient.getLastName());
            preparedStatement.setString(3,patient.getPassword());
            preparedStatement.setLong(4,patient.getPesel());
            preparedStatement.setString(5,patient.getLogin());
            preparedStatement.setString(6,patient.getEmail());
            preparedStatement.setInt(7,patient.getTelephoneNumber());
            preparedStatement.setString(8,patient.getAddress());
            preparedStatement.setString(9,patient.getPostCode());
            preparedStatement.setString(10,patient.getCity());

            preparedStatement.executeUpdate();

            disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removePatient(Patient patient) {

        try {
            connectToDb();

            String queryRemove = "delete from patient where user_ID=?";

            PreparedStatement preparedStatement = conn.prepareStatement(queryRemove);

            preparedStatement.setInt(1, patient.getUser_id());

            preparedStatement.executeUpdate();

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
