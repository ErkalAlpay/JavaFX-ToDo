package com.example.loginscreen4;

import javafx.scene.chart.PieChart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {

    private static DataAccess instance;


    private String dataSource = "jdbc:postgresql://localhost:5432/postgres";
    private String dataUsername = "postgres";
    private String dataPassword = "writemaster";
    private Connection connection = null;
    private Statement statement = null;

    private DataAccess() {
        init();
    }

    private void init() {
        try {
            //Bağlantı nesnesi
            connection = DriverManager.getConnection(dataSource, dataUsername, dataPassword);
            System.out.println("Connected to the database");
            //Baglanti nesnesi uzerinden islem yapmaya yarayan nesne "Statement"
            statement = connection.createStatement();


        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static DataAccess getInstance() {
        if (instance != null) {
            return instance;

        } else {
            instance = new DataAccess();
            return instance;
        }

    }

    public void addUser(User user) {
        String sql = "insert into userss (username,password)values('" + user.getUserName() + "','" + user.getPassword() + "')";
        try {
            //addBatch komutu statement üzerinden kullanılan veri eklemek için kullanılan metotdur.
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
