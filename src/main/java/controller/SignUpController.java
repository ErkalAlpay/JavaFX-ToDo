package controller;

import com.example.loginscreen4.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    private Button registerButonu;

    @FXML
    private PasswordField registerPassword;

    @FXML
    private PasswordField registerPassword2;

    @FXML
    private TextField registerUserName;

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
        try {

            if (DataAccess.getInstance().checkDatabaseForRegisterUsername(this.registerUserName.getText())) {
                System.out.println("Aynı isimde username bulunmakta");

            }else {
                User user = new User(this.registerUserName.getText(), this.registerPassword.getText());
                DataAccess.getInstance().addUser(user);
                System.out.println("Başarıyla kayıt olundu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* (checkPassword()==true && DataAccess.getInstance().checkDatabase(this.registerPassword)==true){

            User user = new User(this.registerUserName.getText(), this.registerPassword.getText());
            DataAccess.getInstance().addUser(user);

        }else checkPassword();*/

    }
}

