package com.pabclinic.repositories;

import com.pabclinic.model.dtos.*;
import com.pabclinic.configurations.DataBase;
import com.pabclinic.model.daos.VisitDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VisitRepository {

    private DataBase dataBase;
    private UserLoginDTO userLoginDTO;
    private SingleVisitDTO singleVisitDTO;

    @Autowired
    public VisitRepository(DataBase dataBase, UserLoginDTO userLoginDTO, SingleVisitDTO singleVisitDTO) {
        this.dataBase = dataBase;
        this.userLoginDTO = userLoginDTO;
        this.singleVisitDTO = singleVisitDTO;
    }

    public void addVisitHistory(String date, String doctorName, String doctorLastName, String login, String patientName,
                                String patientLastName, String visitDescription) {

        try {
            dataBase.connectToDb();

            String queryCount = "SELECT * from visit where visitDate='" + LocalDate.now().toString() + "' and" +
                    " patientName='" + patientName + "' and patientLastName='" + patientLastName + "'";

            ResultSet rs = dataBase.getStmt().executeQuery(queryCount);
            rs.next();

            String username = rs.getString("patientUsername");


            queryCount = "SELECT COUNT(*) from visithistory";

            rs = dataBase.getStmt().executeQuery(queryCount);
            rs.next();

            int i = rs.getInt("count");

            String queryInsert = "insert into visithistory (visitDate, doctorName, doctorLastName, doctorUsername, patientName, patientLastName, patientUsername, visitDescription) values (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = dataBase.getConn().prepareStatement(queryInsert);

            preparedStatement.setString(1, date);
            preparedStatement.setString(2, doctorName);
            preparedStatement.setString(3, doctorLastName);
            preparedStatement.setString(4, login);
            preparedStatement.setString(5, patientName);
            preparedStatement.setString(6, patientLastName);
            preparedStatement.setString(7, username);
            preparedStatement.setString(8, visitDescription);

            preparedStatement.executeUpdate();

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<VisitDAO> getVisits() {

        List<VisitDAO> visits = new ArrayList<>();

        try {

            dataBase.connectToDb();

            String queryCount = "SELECT * from visit";

            ResultSet rs = dataBase.getStmt().executeQuery(queryCount);

            while (rs.next()) {

                VisitDAO visit = new VisitDAO(
                        rs.getString("visitDate"),
                        rs.getString("visitTime"),
                        rs.getString("doctorName"),
                        rs.getString("doctorLastName"),
                        rs.getString("patientName"),
                        rs.getString("patientLastName")
                );

                visits.add(visit);

            }

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return visits;

    }

    public List<VisitTimeDTO> getVisitsTime() {

        List<VisitTimeDTO> visitsTime = new ArrayList<>();

        try {

            dataBase.connectToDb();

            String queryCount = "SELECT * from VisitDAO";

            ResultSet rs = dataBase.getStmt().executeQuery(queryCount);

            while (rs.next()) {

                VisitTimeDTO visit = new VisitTimeDTO(rs.getString("visitTime"));

                visitsTime.add(visit);

            }

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return visitsTime;

    }

    public List<VisitDTO> findDoctorVisitsFromUsernameSession() {

        List<VisitDTO> doctorVisits = new ArrayList<>();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }


        try {

            dataBase.connectToDb();

            String queryCount = "SELECT * from visit where visitDate='" + LocalDate.now().toString()
                    + "' and doctorUserName='" + username + "'";

            System.out.println(queryCount);

            ResultSet rs = dataBase.getStmt().executeQuery(queryCount);

            while (rs.next()) {

                doctorVisits.add(new VisitDTO(
                        rs.getString("visitDate"),
                        rs.getString("visitTime"),
                        rs.getString("doctorName"),
                        rs.getString("doctorLastName"),
                        rs.getString("patientName"),
                        rs.getString("patientLastName")
                ));
            }

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (VisitDTO v : doctorVisits) {

            System.out.println(v);

        }

        return doctorVisits;

    }

    public DoctorDTO findDoctorFromDb(UserLoginDTO userLoginDTO) {

        DoctorDTO doctorDTO = null;

        try {

            dataBase.connectToDb();

            String queryCount = "SELECT * from users where username='" + userLoginDTO.getUsername() + "'";

            ResultSet rs = dataBase.getStmt().executeQuery(queryCount);

            while (rs.next()) {

                doctorDTO = new DoctorDTO(
                        rs.getInt("user_id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("specialisation"));
            }


            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return doctorDTO;
    }

    public List<VisitDTO> findVisitHistory() {

        List<VisitDTO> visits = new ArrayList<>();
        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        try {

            dataBase.connectToDb();

            String queryCount = "SELECT * from visithistory where patientUsername='" + username + "'";

            ResultSet rs = dataBase.getStmt().executeQuery(queryCount);

            while (rs.next()) {

                VisitDTO visit = new VisitDTO(
                        rs.getString("visitDate"),
                        rs.getString("visitDate"),
                        rs.getString("doctorName"),
                        rs.getString("doctorLastName"),
                        rs.getString("patientName"),
                        rs.getString("patientLastName"),
                        rs.getString("visitDescription")
                );

                visits.add(visit);

            }

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return visits;
    }

    public List<VisitDAO> addVisit() {

        List<VisitDAO> visits = new ArrayList<>();

        try {

            String queryCount = "SELECT COUNT(*) from visit";

            ResultSet rs = dataBase.getStmt().executeQuery(queryCount);
            rs.next();

            int i = rs.getInt("count");

            String queryInsert = "insert into visit (visitDate, visitTime, doctorName, doctorLastName, doctorUsername, patientName, patientLastName, patientUsername) values (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = dataBase.getConn().prepareStatement(queryInsert);

            preparedStatement.setString(1, singleVisitDTO.getVisitDate());
            preparedStatement.setString(2, singleVisitDTO.getVisitTime());
            preparedStatement.setString(3, singleVisitDTO.getDoctorName());
            preparedStatement.setString(4, singleVisitDTO.getDoctorLastName());
            preparedStatement.setString(5, singleVisitDTO.getDoctorUsername());
            preparedStatement.setString(6, singleVisitDTO.getPatientName());
            preparedStatement.setString(7, singleVisitDTO.getPatientLastName());
            preparedStatement.setString(8, singleVisitDTO.getPatientUsername());

            preparedStatement.executeUpdate();

            rs = dataBase.getStmt().executeQuery(queryCount);

            dataBase.disconnectDB();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return visits;

    }

    public List<VisitTimeDTO> findDoctorVisitsFromDataBase() {

        List<VisitTimeDTO> doctorVisits = new ArrayList<>(getVisitsTime());

        List<VisitTimeDTO> tempDoctorVisits = new ArrayList<>();

        try {

            dataBase.connectToDb();

            String queryCount = "SELECT * from visit where visitDate='" + singleVisitDTO.getVisitDate()
                    + "' and doctorUserName='" + singleVisitDTO.getDoctorUsername() + "'";

            ResultSet rs = dataBase.getStmt().executeQuery(queryCount);

            while (rs.next()) {

                tempDoctorVisits.add(new VisitTimeDTO(
                        rs.getString("visitTime")
                ));
            }

            doctorVisits.removeAll(tempDoctorVisits);

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return doctorVisits;

    }

}
