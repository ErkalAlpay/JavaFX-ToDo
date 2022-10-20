module com.example.loginscreen4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires spring.security.crypto;
    requires spring.boot.starter.mail;



    opens com.example.loginscreen4 to javafx.fxml;
    exports com.example.loginscreen4;
    exports controller;
    opens controller to javafx.fxml;
}