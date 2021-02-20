package com.pabclinic.repositories;

import com.pabclinic.configurations.DataBase;
import com.pabclinic.model.dtos.PatientDTO;
import com.pabclinic.model.dtos.VisitDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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

            ResultSet rs = dataBase.getStmt().executeQuery("select * from users where role='USER'");

            while (rs.next()) {
                PatientDTO patient = new PatientDTO(
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

            String queryCount = "SELECT COUNT(*) from users where role='USER'";

            ResultSet rs = dataBase.getStmt().executeQuery(queryCount);
            rs.next();

            int i = rs.getInt("count");

            String queryInsert = "insert into Users (firstName, lastName, password, pesel, username, email, telephoneNumber, address, postCode, city, enabled, role) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            preparedStatement.setString(12, "USER");

            preparedStatement.executeUpdate();

            rs = dataBase.getStmt().executeQuery(queryCount);
            rs.next();

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

            String queryRemove = "delete from users where user_id=?";

            PreparedStatement preparedStatement = dataBase.getConn().prepareStatement(queryRemove);

            preparedStatement.setInt(1, patient.getId());

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
            String queryUpdate = "update users set firstname=?, lastname=?, password=?, pesel=?, username=?, email=?, telephonenumber=?, " +
                    "address=?, postcode=?, city=? where user_id=" + patient.getId();

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

            String queryEdit = "select * from users where user_id=" + patient.getId();

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
                        rs.getString("city"));
                ;
            }

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return patient;
    }

    public PatientDTO findPatientFromDbByUsername() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        PatientDTO patientDTO = null;

        try {

            dataBase.connectToDb();

            String queryCount = "SELECT * from users where username='" + username + "'";

            ResultSet rs = dataBase.getStmt().executeQuery(queryCount);

            while (rs.next()) {

                patientDTO = new PatientDTO(
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("username")
                );


            }

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return patientDTO;


    }

}
