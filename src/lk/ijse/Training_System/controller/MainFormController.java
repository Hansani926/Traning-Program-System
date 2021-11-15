package lk.ijse.Training_System.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainFormController {
    public AnchorPane root;
    public Button btnStudent;
    public Button btnCourse;
    public Button btnRegistration;

    public void studentOnAction(MouseEvent mouseEvent) throws IOException {
        initUi("StudentForm.fxml");
    }

    private void initUi(String location) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/" + location)));

    }

    public void courseOnAction(MouseEvent mouseEvent) throws IOException {
        initUi("CourseForm.fxml");
    }

    public void RegistrationOnAction(MouseEvent mouseEvent) throws IOException {
        initUi("RegistrationForm.fxml");
    }
}
