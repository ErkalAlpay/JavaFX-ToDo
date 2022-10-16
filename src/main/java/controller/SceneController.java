package controller;

import com.example.loginscreen4.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class SceneController {

    HelloController helloController = new HelloController();
    SignUpController signUpController = new SignUpController();
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToLoginScene() throws IOException {
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(root.load());
        Stage stage = new Stage();
        stage.setTitle("Login Screen");
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRegisterScene() throws IOException {
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("sign-up.fxml"));
        Scene scene = new Scene(root.load());
        Stage stage = new Stage();
        stage.setTitle("Register Screen");
        stage.setScene(scene);
        stage.show();

    }



}
