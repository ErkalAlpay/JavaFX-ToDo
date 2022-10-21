package controller;

import com.example.loginscreen4.ToDo;
import com.example.loginscreen4.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.*;
import java.util.ArrayList;

public class DataAccess {

    private static DataAccess instance;
    private static User loginYapmisUser;




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

    private void addTodo(ToDo todo) throws SQLException{
        String sql = "insert into todo (todo, userid) values ('"+todo.getTodo()+"','"+todo.getUser_id()+"')";
        statement.addBatch(sql);
        statement.executeBatch();
    }

    public void saveTodo(ToDo todo) throws SQLException{
        todo.setUser_id(loginYapmisUser.getId());
        addTodo(todo);
    }

    public void deleteTodo(ToDo todo) throws SQLException {
        String sql = "delete from todo where id ='"+todo.getId()+"'";
        statement.executeUpdate(sql);
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
    loginYapmisUser = dbUser;
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
     private ArrayList<ToDo> getDataBaseTodoByUserId(int userId) throws SQLException {
        String sql = "select * from todo where userid = '"+userId+"'";
        ResultSet sonuc = statement.executeQuery(sql);
        ArrayList<ToDo> dbToDoList = new ArrayList<>();
        while(sonuc.next()){
            ToDo todo = new ToDo();
            todo.setTodo(sonuc.getString("todo"));
            todo.setCompleted(sonuc.getBoolean("isCompleted"));
            todo.setId(sonuc.getInt("id"));
            todo.setUser_id(sonuc.getInt("userid"));
            dbToDoList.add(todo);
        }return dbToDoList;

     }

     public ArrayList<ToDo> getToDoList() throws SQLException {
       return getDataBaseTodoByUserId(loginYapmisUser.getId());
     }

}

