package lk.ijse.Training_System.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Training_System.business.BOFactory;
import lk.ijse.Training_System.business.BOType;
import lk.ijse.Training_System.business.custom.RegistrationBO;
import lk.ijse.Training_System.dto.CourseDTO;
import lk.ijse.Training_System.dto.RegistrationDTO;
import lk.ijse.Training_System.dto.StudentDTO;
import lk.ijse.Training_System.entity.Registration;

import java.io.IOException;

public class RegistrationFormController {
    public AnchorPane root;
    public TextField txtRegNo;
    public TextField txtStudentId;
    public TextField txtCourseCode;
    public TextField txtRegFee;
    public DatePicker txtRegDate;
    public Button btnRegisration;
    public ComboBox cmbId;
    public ComboBox cmbcode;

    RegistrationBO registrationBO = BOFactory.getInstance().getBO(BOType.REGISTRATION);

    public void backToHomeOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/MainForm.fxml"))));
    }

    public void RegistrationOnAction(ActionEvent actionEvent) {
     /* try{
          int RegNo=Integer.parseInt(txtRegNo.getText());
          String RegDate = txtRegDate.getPromptText();
          double RegFee=Double.parseDouble(txtRegFee.getText());
          StudentDTO studentDTO=new StudentDTO(cmbId.getValue().toString());
          CourseDTO
      }*/
    }

    /*private void registration(RegistrationDTO registrationDTO) {
        try {
            boolean isAdded =registrationBO.saveRegistration(registrationDTO);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Registration Successful...").showAndWait();
            } else {
                new Alert(Alert.AlertType.ERROR, "not REgistration").showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
