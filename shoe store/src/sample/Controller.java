package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authorization;

    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Button applyReg;

    @FXML
    private TextField notify;

    @FXML
    void initialize() {

        authorization.setOnAction(event -> {
            authorization.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Authorization.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        applyReg.setOnAction(event -> {

            applyReg.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Authorization.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        applyReg.setOnAction(event1 -> {

            signUpNewUser();

        });
    }

    private void signUpNewUser() {
        applyReg.setText("Аккаунт успешно создан!");
        DatabaseHandler dbHandler = new DatabaseHandler();

        String Name = name.getText();
        String Surname = surname.getText();
        String Email = email.getText();
        String Password = password.getText();

        User user = new User(Name, Surname, Email, Password);

        dbHandler.signUpUser(user);
    }
}

