package com.PabClinic.components.repositories;

import com.PabClinic.components.configurations.DataBase;
import com.PabClinic.model.dtos.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientRepository {

    private DataBase dataBase;

    @Autowired
    public PatientRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public List<PatientDTO> getPatients() {

        List<PatientDTO> patientList = new ArrayList<>();


        try {
            dataBase.connectToDb();

            ResultSet rs = dataBase.getStmt().executeQuery("select * from patient");

            while (rs.next()) {
                PatientDTO patient = new PatientDTO(
                        rs.getInt("user_id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("login"),
                        rs.getString("userpassword"),
                        rs.getString("email"),
                        rs.getInt("telephonenumber"),
                        rs.getLong("pesel"),
                        rs.getString("address"),
                        rs.getString("postcode"),
                        rs.getString("city"));

                patientList.add(patient);
            }

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return patientList;
    }

    public void addPatient(PatientDTO patient) {

        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String pwd = bcryptPasswordEncoder.encode(patient.getPassword());

        try {
            dataBase.connectToDb();

            String queryCount = "SELECT COUNT(*) from patient";

            ResultSet rs = dataBase.getStmt().executeQuery(queryCount);
            rs.next();

            int i = rs.getInt("count");

            String queryInsert = "insert into patient (firstName, lastName, password, pesel, username, email, telephoneNumber, address, postCode, city, enabled) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = dataBase.getConn().prepareStatement(queryInsert);

            preparedStatement.setString(1, patient.getFirstName());
            preparedStatement.setString(2, patient.getLastName());
            preparedStatement.setString(3, pwd);
            preparedStatement.setLong(4, patient.getPesel());
            preparedStatement.setString(5, patient.getUsername());
            preparedStatement.setString(6, patient.getEmail());
            preparedStatement.setInt(7, patient.getTelephoneNumber());
            preparedStatement.setString(8, patient.getAddress());
            preparedStatement.setString(9, patient.getPostCode());
            preparedStatement.setString(10, patient.getCity());
            preparedStatement.setBoolean(11, true);

            preparedStatement.executeUpdate();

            rs = dataBase.getStmt().executeQuery(queryCount);
            rs.next();

            queryInsert = "insert into roles (username, role) values (?, ?)";

            preparedStatement = dataBase.getConn().prepareStatement(queryInsert);

            preparedStatement.setString(1, patient.getUsername());
            preparedStatement.setString(2, "USER");

            preparedStatement.executeUpdate();


            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removePatient(PatientDTO patient) {

        try {
            dataBase.connectToDb();

            String queryRemove = "delete from patient where user_ID=?";

            PreparedStatement preparedStatement = dataBase.getConn().prepareStatement(queryRemove);

            preparedStatement.setInt(1, patient.getUser_id());

            preparedStatement.executeUpdate();

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updatePatient(PatientDTO patient) {

        try {
            dataBase.connectToDb();
            String queryUpdate = "update patient set firstname=?, lastname=?, password=?, pesel=?, username=?, email=?, telephonenumber=?, " +
                    "address=?, postcode=?, city=? where user_ID=" + patient.getUser_id();

            PreparedStatement preparedStatement = dataBase.getConn().prepareStatement(queryUpdate);

            preparedStatement.setString(1, patient.getFirstName());
            preparedStatement.setString(2, patient.getLastName());
            preparedStatement.setString(3, patient.getPassword());
            preparedStatement.setLong(4, patient.getPesel());
            preparedStatement.setString(5, patient.getUsername());
            preparedStatement.setString(6, patient.getEmail());
            preparedStatement.setInt(7, patient.getTelephoneNumber());
            preparedStatement.setString(8, patient.getAddress());
            preparedStatement.setString(9, patient.getPostCode());
            preparedStatement.setString(10, patient.getCity());

            preparedStatement.executeUpdate();

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public PatientDTO findPatientFromDb(PatientDTO patient) {

        try {
            dataBase.connectToDb();

            String queryEdit = "select * from patient where user_ID=" + patient.getUser_id();

            ResultSet rs = dataBase.getStmt().executeQuery(queryEdit);

            while (rs.next()) {
                patient = new PatientDTO(
                        rs.getInt("user_id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getInt("telephonenumber"),
                        rs.getLong("pesel"),
                        rs.getString("address"),
                        rs.getString("postcode"),
                        rs.getString("city"));;
            }

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return patient;
    }

}
