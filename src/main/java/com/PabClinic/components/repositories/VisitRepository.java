package com.PabClinic.components.repositories;
import com.PabClinic.model.dtos.DoctorDTO;
import com.PabClinic.model.dtos.UserLoginDTO;
import com.PabClinic.model.dtos.VisitDTO;
import com.PabClinic.model.dtos.VisitTimeDTO;
import com.PabClinic.components.configurations.DataBase;
import com.PabClinic.model.daos.VisitDAO;
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

    public VisitRepository(DataBase dataBase, UserLoginDTO userLoginDTO) {
        this.dataBase = dataBase;
        this.userLoginDTO = userLoginDTO;
    }

    public void addVisitHistory(String date, String doctorName, String doctorLastName, String login, String patientName,
                                String patientLastName, String visitDescription) {

        try {
            dataBase.connectToDb();

            String queryCount = "SELECT COUNT(*) from visithistory";

            ResultSet rs = dataBase.getStmt().executeQuery(queryCount);
            rs.next();

            int i = rs.getInt("count");

            String queryInsert = "insert into visithistory (visitDate, doctorName, doctorLastName, doctorUserName, patientName, patientLastName, visitDescription) values (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = dataBase.getConn().prepareStatement(queryInsert);

            preparedStatement.setString(1, date);
            preparedStatement.setString(2, doctorName);
            preparedStatement.setString(3, doctorLastName);
            preparedStatement.setString(4, login);
            preparedStatement.setString(5, patientName);
            preparedStatement.setString(6, patientLastName);
            preparedStatement.setString(7, visitDescription);

            preparedStatement.executeUpdate();

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<VisitDAO> getVisits(){

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

    public List<VisitTimeDTO> getVisitsTime(){

        List<VisitTimeDTO> visitsTime = new ArrayList<>();

        try {

            dataBase.connectToDb();

            String queryCount = "SELECT * from VisitDTO";

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

    public List<VisitDTO> findDoctorVisits(UserLoginDTO userLoginDTO){

        List<VisitDTO> doctorVisits = new ArrayList<>();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            userLoginDTO.setUsername(username);
        } else {
            String username = principal.toString();
            userLoginDTO.setUsername(username);
        }


        try {

            dataBase.connectToDb();

            String queryCount = "SELECT * from visit where visitDate='" + LocalDate.now().toString()
            + "' and doctorUserName='"+ userLoginDTO.getUsername() +"'";

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
}
