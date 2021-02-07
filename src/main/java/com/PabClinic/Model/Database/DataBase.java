package com.PabClinic.Model.Database;

import com.PabClinic.Model.Doctor.Doctor;
import com.PabClinic.Model.Patient.Patient;
import com.PabClinic.Model.Research.Research;

import javax.print.Doc;
import java.sql.*;
import java.util.ArrayList;

public class DataBase {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost/PABClinic";
    private static final String LOGIN = "postgres";
//    private static final String PASSWORD = "ANDpig1906!@"; // Andrzeja hasło na postgresa
        private static final String PASSWORD = "Qparox123!"; // Pawła hasło na postgresa
//    private static final String PASSWORD = "postgres"; // Bartka hasło na postgresa


    private Statement stmt;
    Connection conn;

    public DataBase() {

    }

    public void getPatients(ArrayList<Patient> patientList) {


        try {
            connectToDb();

            ResultSet rs = stmt.executeQuery("select * from patient");

            while (rs.next()) {
                Patient patient = new Patient(rs.getInt("user_id"), rs.getString("firstname"), rs.getString("lastname"),
                        rs.getString("userpassword"), rs.getLong("pesel"), rs.getString("login"), rs.getString("email"),
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

    public void getResearches(ArrayList<Research> researchList) {

        try {
            connectToDb();

            ResultSet rs = stmt.executeQuery("select * from Badania");

            while (rs.next()) {
                Research research = new Research(rs.getInt("badanie_id"), rs.getString("nazwaBadania"), rs.getInt("cenaBadania"));

                researchList.add(research);
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

            preparedStatement.setString(1, patient.getFirstName());
            preparedStatement.setString(2, patient.getLastName());
            preparedStatement.setString(3, patient.getPassword());
            preparedStatement.setLong(4, patient.getPesel());
            preparedStatement.setString(5, patient.getLogin());
            preparedStatement.setString(6, patient.getEmail());
            preparedStatement.setInt(7, patient.getTelephoneNumber());
            preparedStatement.setString(8, patient.getAddress());
            preparedStatement.setString(9, patient.getPostCode());
            preparedStatement.setString(10, patient.getCity());

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


    public Patient editPatient(Patient patient) {

        try {
            connectToDb();

            String queryEdit = "select * from patient where user_ID=" + patient.getUser_id();

            ResultSet rs = stmt.executeQuery(queryEdit);

            while (rs.next()) {
                patient = new Patient(rs.getInt("user_id"), rs.getString("firstname"), rs.getString("lastname"),
                        rs.getString("userpassword"), rs.getLong("pesel"), rs.getString("login"), rs.getString("email"),
                        rs.getInt("telephonenumber"), rs.getString("address"), rs.getString("postcode"), rs.getString("city"));
            }

            disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return patient;
    }

    public void updatePatient(Patient patient) {

        try {
            connectToDb();

            String queryUpdate = "update patient set firstname=?, lastname=?, userpassword=?, pesel=?, login=?, email=?, telephonenumber=?, " +
                    "address=?, postcode=?, city=? where user_ID=" + patient.getUser_id();

            PreparedStatement preparedStatement = conn.prepareStatement(queryUpdate);

            preparedStatement.setString(1, patient.getFirstName());
            preparedStatement.setString(2, patient.getLastName());
            preparedStatement.setString(3, patient.getPassword());
            preparedStatement.setLong(4, patient.getPesel());
            preparedStatement.setString(5, patient.getLogin());
            preparedStatement.setString(6, patient.getEmail());
            preparedStatement.setInt(7, patient.getTelephoneNumber());
            preparedStatement.setString(8, patient.getAddress());
            preparedStatement.setString(9, patient.getPostCode());
            preparedStatement.setString(10, patient.getCity());

            preparedStatement.executeUpdate();

            disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getDoctors(ArrayList<Doctor> doctorList) {

        try {
            connectToDb();

            ResultSet rs = stmt.executeQuery("select * from doctor");

            while (rs.next()) {
                Doctor doctor = new Doctor(rs.getInt("doctor_id"), rs.getString("firstname"), rs.getString("lastname"),
                        rs.getString("login"), rs.getString("doctorPassword"), rs.getString("specialisation"));
                doctorList.add(doctor);
            }

            disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void registerDoctor(Doctor doctor) {

        try {
            connectToDb();

            String queryCount = "SELECT COUNT(*) from doctor";

            ResultSet rs = stmt.executeQuery(queryCount);
            rs.next();

            int i = rs.getInt("count");

            String queryInsert = "insert into doctor (firstName, lastName, login, doctorPassword, specialisation) values (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(queryInsert);

            preparedStatement.setString(1, doctor.getFirstName());
            preparedStatement.setString(2, doctor.getLastName());
            preparedStatement.setString(3, doctor.getLogin());
            preparedStatement.setString(4, doctor.getPassword());
            preparedStatement.setString(5, doctor.getSpecialisation());

            preparedStatement.executeUpdate();

            disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeDoctor(Doctor doctor) {

        try {
            connectToDb();

            String queryRemove = "delete from doctor where doctor_ID=?";

            PreparedStatement preparedStatement = conn.prepareStatement(queryRemove);

            preparedStatement.setInt(1, doctor.getDoctor_ID());

            preparedStatement.executeUpdate();

            disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Doctor editDoctor(Doctor doctor) {

        try {
            connectToDb();

            String queryEdit = "select * from doctor where doctor_ID=" + doctor.getDoctor_ID();

            ResultSet rs = stmt.executeQuery(queryEdit);

            while (rs.next()) {
                doctor = new Doctor(rs.getInt("doctor_id"), rs.getString("firstName"), rs.getString("lastName"),
                        rs.getString("login"), rs.getString("doctorPassword"), rs.getString("specialisation"));
            }

            disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return doctor;
    }

    public void updateDoctor(Doctor doctor) {

        try {
            connectToDb();

            String queryUpdate = "update doctor set firstname=?, lastname=?, login=?, doctorPassword=?, specialisation=? where doctor_ID=" + doctor.getDoctor_ID();

            PreparedStatement preparedStatement = conn.prepareStatement(queryUpdate);

            preparedStatement.setString(1, doctor.getFirstName());
            preparedStatement.setString(2, doctor.getLastName());
            preparedStatement.setString(3, doctor.getLogin());
            preparedStatement.setString(4, doctor.getPassword());
            preparedStatement.setString(5, doctor.getSpecialisation());

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

        conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);

        stmt = conn.createStatement();
    }

    private void disconnectDB() throws SQLException {
        stmt.close();
        conn.close();
    }

}
