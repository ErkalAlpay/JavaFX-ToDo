package controller;

import com.example.loginscreen4.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class SceneController {

    LoginController loginController = new LoginController();
    SignUpController signUpController = new SignUpController();
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToLoginScene() throws IOException {
        FXMLLoader root = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(root.load());
        Stage stage = new Stage();
        stage.setTitle("Login Screen");
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRegisterScene() throws IOException {
        FXMLLoader root = new FXMLLoader(Main.class.getResource("sign-up.fxml"));
        Scene scene = new Scene(root.load());
        Stage stage = new Stage();
        stage.setTitle("Register Screen");
        stage.setScene(scene);
        stage.show();

    }

    public void switchToToDoScene() throws IOException {
        FXMLLoader root = new FXMLLoader(Main.class.getResource("todo.fxml"));
        Scene scene = new Scene(root.load());
        Stage stage = new Stage();
        stage.setTitle("To-Do Listesi");
        stage.setScene(scene);
        stage.show();

    }



}
