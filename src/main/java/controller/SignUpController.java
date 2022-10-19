package controller;

import com.example.loginscreen4.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    @FXML
    private DialogPane dio;

    @FXML
    private Button registerButonu;

    @FXML
    private PasswordField registerPassword;

    @FXML
    private PasswordField registerPassword2;

    @FXML
    private TextField registerEmail;

    public Button getRegisterButonu() {
        return registerButonu;
    }


   /* public boolean checkPassword() {
        if (this.registerPassword == this.registerPassword2) {
            return false;
        } else {
            System.out.println("Passwords doesnt match");
            return true;
        }
    }*/



    @FXML
    protected void onRegisterButon() throws SQLException {

        User user = new User();
        user.setEmail(this.registerEmail.getText());
        user.setPassword(this.registerPassword.getText());

        DataAccess.getInstance().saveUser(user);





    }
}

