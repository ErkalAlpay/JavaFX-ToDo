package controller;

import com.example.loginscreen4.HelloApplication;
import com.example.loginscreen4.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloController {


    @FXML
    private TextField kullaniciAdi;

    @FXML
    private TextField passwordField;


    @FXML
    private Button loginButonu;

    public Button getLoginRegisterButton() {
        return loginRegisterButton;
    }

    @FXML
    private Button loginRegisterButton;

    @FXML
    protected void onHelloButtonClick() throws SQLException {

        if (DataAccess.getInstance().checkDataBaseForLogin(kullaniciAdi,passwordField)){
            loginButonu.setText("Logged in Succesfully");
        }else System.out.println("Kullanıcı adı veya şifre hatalı");



    }
    @FXML
    protected void loginResgisterButtonAction() throws IOException {

        SceneController asd = new SceneController();
        asd.switchToRegisterScene();

        /*
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("sign-up.fxml"));
        Scene scene = new Scene(root.load());
        Stage stage = new Stage();
        stage.setTitle("Register");
        stage.setScene(scene);
        stage.show(); */








        }


    }









