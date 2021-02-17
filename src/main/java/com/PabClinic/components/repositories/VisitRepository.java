package com.PabClinic.components.repositories;
import com.PabClinic.model.dtos.DoctorDTO;
import com.PabClinic.model.dtos.VisitDTO;
import com.PabClinic.model.dtos.VisitTimeDTO;
import com.PabClinic.components.configurations.DataBase;
import com.PabClinic.model.daos.VisitDAO;
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

    public VisitRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void addVisitHistory(String date, String doctorName, String doctorLastName, String patientName,
                                String patientLastName, String visitDescription) {

        try {
            dataBase.connectToDb();

            String queryCount = "SELECT COUNT(*) from visithistory";

            ResultSet rs = dataBase.getStmt().executeQuery(queryCount);
            rs.next();

            int i = rs.getInt("count");

            String queryInsert = "insert into visithistory (visitDate, doctorName, doctorLastName, patientName, patientLastName, visitDescription) values (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = dataBase.getConn().prepareStatement(queryInsert);

            preparedStatement.setString(1, date);
            preparedStatement.setString(2, doctorName);
            preparedStatement.setString(3, doctorLastName);
            preparedStatement.setString(4, patientName);
            preparedStatement.setString(5, patientLastName);
            preparedStatement.setString(6, visitDescription);

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

    public List<VisitDTO> findDoctorVisits(DoctorDTO doctor){

        List<VisitDTO> doctorVisits = new ArrayList<>();

        try {

            dataBase.connectToDb();

            String queryCount = "SELECT * from visit where visitDate=" + LocalDate.now().toString()
            + " and doctorLastName="+ doctor.getLastName();

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
}
