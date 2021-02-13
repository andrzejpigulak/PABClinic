package com.PabClinic.Model.Doctor;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DoctorDAO {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost/PABClinic";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "ANDpig1906!@"; // Andrzeja hasło na postgresa

    private static Statement stmt;
    static Connection conn;

    private static final List<Doctor> doctors = new ArrayList<Doctor>();

    static {
        initData();
    }

    private static void initData() {
        {
            try {
                connectToDb();

                ResultSet rs = stmt.executeQuery("select * from doctor");

                while (rs.next()) {
                    Doctor doctor = new Doctor(rs.getInt("doctor_id"), rs.getString("firstname"), rs.getString("lastname"),
                            rs.getString("login"), rs.getString("doctorPassword"), rs.getString("specialisation"));
                    doctors.add(doctor);
                }

                disconnectDB();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private static void connectToDb() throws ClassNotFoundException, SQLException {

        Class.forName(JDBC_DRIVER);

        conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);

        stmt = conn.createStatement();
    }

    private static void disconnectDB() throws SQLException {
        stmt.close();
        conn.close();
    }

    public static List<Doctor> getDoctors() {
        return doctors;
    }
}
