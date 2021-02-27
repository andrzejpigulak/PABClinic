package com.pabclinic.repositories;

import com.pabclinic.configurations.DataBase;
import com.pabclinic.model.dtos.PatientDTO;
import com.pabclinic.model.dtos.ResearchDTO;
import com.pabclinic.model.dtos.VisitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ResearchRepository {

    private DataBase dataBase;

    @Autowired
    public ResearchRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public List<ResearchDTO> getResearches() {

        List<ResearchDTO> researches = new ArrayList<>();

        try {
            dataBase.connectToDb();

            ResultSet rs = dataBase.getStmt().executeQuery("select * from Badania");

            while (rs.next()) {
                researches.add(new ResearchDTO(rs.getInt("badanie_id"), rs.getString("nazwaBadania"), rs.getInt("cenaBadania")));

            }

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return researches;

    }

    public void removeResearch(String researchName) {

        try {
            dataBase.connectToDb();

            String queryRemove = "delete from badania where nazwaBadania=?";

            PreparedStatement preparedStatement = dataBase.getConn().prepareStatement(queryRemove);

            preparedStatement.setString(1, researchName);

            preparedStatement.executeUpdate();

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addResearchToDb(ResearchDTO researchDTO) {

        try {
            dataBase.connectToDb();

            String queryCount = "SELECT COUNT(*) from badania";

            ResultSet rs = dataBase.getStmt().executeQuery(queryCount);
            rs.next();

            int i = rs.getInt("count");

            String queryInsert = "insert into badania (nazwabadania, cenabadania) values (?, ?)";

            PreparedStatement preparedStatement = dataBase.getConn().prepareStatement(queryInsert);

            preparedStatement.setString(1, researchDTO.getResearchName());
            preparedStatement.setInt(2, researchDTO.getResearchPrice());

            preparedStatement.executeUpdate();

            dataBase.disconnectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

