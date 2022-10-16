package controller;

import com.example.loginscreen4.User;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.ArrayList;

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

    //private ArrayList<String> usernameList = new ArrayList<>();
    //private ArrayList<String> passwordList = new ArrayList<>();

    public boolean checkDatabaseForRegisterUsername(TextField registerUsername) throws SQLException {

        //Önce database üzerinde aynı isimde bir kayıt var mı yok mu kontrol edilecek
        //Eğer yoksa kayıt yapılacak, varsa geriye uyarı döndürecek


        ResultSet rs = statement.executeQuery("select * from userss  ");
        ArrayList<String> usernameList = new ArrayList<>();

        while (rs.next()) {
            usernameList.add(rs.getString("username"));
        }
        boolean a = false;
        for (int i = 0; i < usernameList.size(); i++) {
            if (usernameList.get(i).equals(registerUsername)) {
                a = false;
                break;
            } else a = true;
        }
        return a;


    }

    public boolean checkDataBaseForLogin(TextField username, TextField password) throws SQLException {
        ResultSet rs = statement.executeQuery("select  * from  userss");
        ArrayList<String> usernameList = new ArrayList<>();
        ArrayList<String> passwordList = new ArrayList<>();
        while (rs.next()){
            passwordList.add(rs.getString("password"));
            usernameList.add(rs.getString("username"));
        }

        boolean b = false;
        for (int i = 0; i<usernameList.size(); i++){
            if(username.getText().equals(usernameList.get(i))&& password.getText().equals(passwordList.get(i))){
                b=true;
                break;
            }else b = false;
        } return b;
    }

}

