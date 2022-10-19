package controller;

import javafx.fxml.FXML;
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
    protected void loginButtonAction() throws SQLException, IOException {

        if (DataAccess.getInstance().checkDataBaseForLogin(kullaniciAdi.getText(), passwordField.getText())) {
            SceneController asd = new SceneController();
            asd.switchToToDoScene();
        } else System.out.println("Kullanıcı adı veya şifre hatalı");


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









