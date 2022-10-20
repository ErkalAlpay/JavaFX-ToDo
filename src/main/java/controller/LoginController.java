package controller;

import com.example.loginscreen4.User;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
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
    protected void loginButtonAction() throws Exception {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        try {
            User user = new User();
            user.setEmail(kullaniciAdi.getText());
            user.setPassword(passwordField.getText());
            DataAccess.getInstance().login(user);
            SceneController asd = new SceneController();
            asd.switchToToDoScene();
        } catch (Exception e) {
            alert.setTitle("Hata");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    @FXML
    protected void loginResgisterButtonAction() throws IOException {
        SceneController asd = new SceneController();
        asd.switchToRegisterScene();
    }


}









