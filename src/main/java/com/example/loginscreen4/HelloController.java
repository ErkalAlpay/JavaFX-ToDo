package com.example.loginscreen4;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField kullaniciAdi;

    @FXML
    private TextField passwordField;


    @FXML
    private Button loginButonu;

    @FXML
    protected void onHelloButtonClick() {
        User user = new User(kullaniciAdi.getText(), passwordField.getText());
        DataAccess.getInstance().addUser(user);
        loginButonu.setText("Logged in Succesfully");





    }
}