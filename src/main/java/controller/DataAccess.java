package controller;

import com.example.loginscreen4.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.*;

public class DataAccess {

    private static DataAccess instance;




    public static DataAccess getInstance() {
        if (instance == null) instance = new DataAccess();
        return instance;
    }

    private DataAccess() {
        init();
    }

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final String dataSource = "jdbc:postgresql://localhost:5432/postgres";
    private final String dataUsername = "postgres";
    private final String dataPassword = "writemaster";
    private Connection connection = null;
    private Statement statement = null;


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


    private void addUser(User user) throws SQLException {
        String sql = "insert into users ( email, password) VALUES ('" + user.getEmail() + "','" + user.getPassword() + "')";
        //addBatch komutu statement üzerinden kullanılan veri eklemek için kullanılan metotdur.
        statement.addBatch(sql);
        statement.executeBatch();

    }

    public void saveUser(User user) throws SQLException {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        addUser(user);
        //JavaMailSender.mailSender(user.getEmail());

    }

    // email = saiddemir  şifre = saiddemir
    public void login(User user) throws Exception {
        User dbUser = getUserByEmail(user.getEmail());
        if (dbUser == null || !passwordEncoder.matches(user.getPassword(), dbUser.getPassword())){
            throw new Exception("Kullanıcı adı veya şifre bulunamadı");
        }



    }

    private User getUserByEmail(String email) throws SQLException {
        String sql = "select * from users where email = '"+email+"' ";
        ResultSet sonuc = statement.executeQuery(sql);

        if (sonuc.next()){
            User user = new User();
            user.setEmail(sonuc.getString("email"));
            user.setPassword(sonuc.getString("password"));
            user.setId(sonuc.getInt("id"));
            return user;
        } return null;



    }

}

