package com.pabclinic.repositories;
import com.pabclinic.configurations.DataBase;
import com.pabclinic.model.dtos.ResearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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



}
