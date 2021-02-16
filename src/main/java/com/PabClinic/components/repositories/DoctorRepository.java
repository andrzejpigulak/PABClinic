package com.PabClinic.components.repositories;


import com.PabClinic.components.configurations.DataBase;
import com.PabClinic.model.dtos.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DoctorRepository {

    private DataBase dataBase;

    @Autowired
    public DoctorRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public List<com.PabClinic.model.dtos.DoctorDTO> getDoctors() {

        List<com.PabClinic.model.dtos.DoctorDTO> doctors = new ArrayList<>();

        try {
            dataBase.connectToDb();

            ResultSet rs = dataBase.getStmt().executeQuery("select * from doctor");

            while (rs.next()) {
                com.PabClinic.model.dtos.DoctorDTO doctor = new com.PabClinic.model.dtos.DoctorDTO(
                        rs.getInt("doctor_id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("login"),
                        rs.getString("doctorPassword"),
                        rs.getString("specialisation"));

                doctors.add(doctor);
            }

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return doctors;
    }

    public void addDoctor(DoctorDTO doctor) {

        try {
            dataBase.connectToDb();

            String queryCount = "SELECT COUNT(*) from doctor";

            ResultSet rs = dataBase.getStmt().executeQuery(queryCount);
            rs.next();

            int i = rs.getInt("count");

            String queryInsert = "insert into doctor (firstName, lastName, login, doctorPassword, specialisation) values (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = dataBase.getConn().prepareStatement(queryInsert);

            preparedStatement.setString(1, doctor.getFirstName());
            preparedStatement.setString(2, doctor.getLastName());
            preparedStatement.setString(3, doctor.getLogin());
            preparedStatement.setString(4, doctor.getPassword());
            preparedStatement.setString(5, doctor.getSpecialisation());

            preparedStatement.executeUpdate();

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeDoctor(DoctorDTO doctor) {

        try {
            dataBase.connectToDb();

            String queryRemove = "delete from doctor where doctor_ID=?";

            PreparedStatement preparedStatement = dataBase.getConn().prepareStatement(queryRemove);

            preparedStatement.setInt(1, doctor.getDoctor_ID());

            preparedStatement.executeUpdate();

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public DoctorDTO findDoctor(DoctorDTO doctor) {

        try {
            dataBase.connectToDb();

            String queryEdit = "select * from doctor where doctor_ID=" + doctor.getDoctor_ID();

            ResultSet rs = dataBase.getStmt().executeQuery(queryEdit);

            while (rs.next()) {
                doctor = new DoctorDTO(rs.getInt("doctor_id"), rs.getString("firstName"), rs.getString("lastName"),
                        rs.getString("login"), rs.getString("doctorPassword"), rs.getString("specialisation"));
            }

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return doctor;
    }

    public void updateDoctor(DoctorDTO doctor) {

        try {
            dataBase.connectToDb();

            String queryUpdate = "update doctor set firstname=?, lastname=?, login=?, doctorPassword=?, specialisation=? where doctor_ID=" + doctor.getDoctor_ID();

            PreparedStatement preparedStatement = dataBase.getConn().prepareStatement(queryUpdate);

            preparedStatement.setString(1, doctor.getFirstName());
            preparedStatement.setString(2, doctor.getLastName());
            preparedStatement.setString(3, doctor.getLogin());
            preparedStatement.setString(4, doctor.getPassword());
            preparedStatement.setString(5, doctor.getSpecialisation());

            preparedStatement.executeUpdate();

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }






}
