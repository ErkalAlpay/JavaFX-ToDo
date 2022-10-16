module com.example.loginscreen4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.loginscreen4 to javafx.fxml;
    exports com.example.loginscreen4;
    exports controller;
    opens controller to javafx.fxml;
}