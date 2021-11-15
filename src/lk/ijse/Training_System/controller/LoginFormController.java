package lk.ijse.Training_System.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class LoginFormController {
   public TextField txtusername;
    public PasswordField txtpw;
    public AnchorPane root;

    public Button btnCancel;
    public Button btnlogin;

    public void setUI(String location) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/"+location))));
        stage.centerOnScreen();
    }

    public void login(ActionEvent actionEvent) throws IOException {

           String username=txtusername.getText().trim();
           String password=txtpw.getText().trim();
        if (username.length()>0 && password.length()>0){

            if (username.equalsIgnoreCase(" Hansani  ")
                    && password.equalsIgnoreCase("1234")){


                URL resource = this.getClass().getResource("/view/MainForm.fxml");
                Parent load = FXMLLoader.load(resource);
                Scene scene= new Scene(load);
                Stage stage= (Stage) root.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();


            }else{
                new Alert(Alert.AlertType.WARNING,"Try Again !!!!",
                        ButtonType.OK,ButtonType.NO).show();
            }
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty !!!!",
                    ButtonType.OK,ButtonType.NO).show();
        }


    }


    public void CancelOnAction(ActionEvent actionEvent) {
    }
}
