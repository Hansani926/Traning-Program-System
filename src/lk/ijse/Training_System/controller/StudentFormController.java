package lk.ijse.Training_System.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Training_System.business.BOFactory;
import lk.ijse.Training_System.business.BOType;
import lk.ijse.Training_System.business.custom.StudentBO;
import lk.ijse.Training_System.dto.StudentDTO;
import lk.ijse.Training_System.model.StudentTM;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static sun.net.www.MimeTable.loadTable;

public class StudentFormController {
    public AnchorPane root;
    public ImageView img;
    public TextField txtId;
    public TextField txtStudentName;
    public TextField txtAddress;
    public TextField txtContact;
    public TextField txtdob;
    public ComboBox cmbGender;
    public TextField txtSearch;
    public TableView<StudentTM> tableStudent;
    public TableColumn colId;
    public TableColumn colStudentName;
    public TableColumn colContact;
    public TableColumn coldob;
    public TableColumn colGender;
    public Button btnSave;
    public Button btnDelete;
    public Button btnUpdate;
    public TableColumn colAddress;
    public TextField txtGender;

    StudentBO studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);

public  void  initialize(){
    btnDelete.setDisable(true);

    tableStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Id"));
    tableStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("StudentName"));
    tableStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Address"));
    tableStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Contact"));
    tableStudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("dob"));
    tableStudent.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("Gender"));

    loadTable();
    tableStudent.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<StudentTM>() {
        @Override
        public void changed(ObservableValue<? extends StudentTM> observable, StudentTM oldValue, StudentTM newValue) {
            btnDelete.setDisable(false);
            btnSave.setText("Save");

            StudentTM selectedItem=tableStudent.getSelectionModel().getSelectedItem();
            if (selectedItem == null){
                return;
            }
            txtId.setText(selectedItem.getId());
            txtStudentName.setText(selectedItem.getStudentName());
            txtAddress.setText(selectedItem.getAddress());
            txtContact.setText(selectedItem.getContact()+"");
            txtdob.setText(selectedItem.getdob());
            txtGender.setText(selectedItem.getGender());

        }
    });
}











    public void BackToHomeOnAction(MouseEvent mouseEvent) throws IOException{
        setUI("MainForm.fxml");
    }

    private void setUI(String location) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/"+location))));
    }

    public void saveOnAction(ActionEvent actionEvent) {
    String Id=txtId.getText();
    String StudentName=txtStudentName.getText();
    String Address=txtAddress.getText();
    int Contact=Integer.parseInt(txtContact.getText());
    String dob=txtdob.getText();
    String Gender=txtGender.getText();
    StudentDTO studentDTO=new StudentDTO(Id,StudentName,Address,Contact,dob,Gender);




        if(btnSave.getText().trim().equals("Save")){
            save(studentDTO);
           /* System.out.println("cont"+studentDTO);*/
        }else {
            update(studentDTO);
        }
        txtId.clear();
        txtStudentName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtdob.clear();
        txtGender.clear();
        btnSave.setText("Save");
        loadTable();
    }

    private void update(StudentDTO studentDTO) {
        try {
            boolean isAdded = studentBO.updateStudent(studentDTO);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student update").showAndWait();
            } else {
                new Alert(Alert.AlertType.ERROR, "Student Not Update").showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    private void save(StudentDTO studentDTO) {
    try {
        boolean isAdded =studentBO.saveStudent(studentDTO);
        if (isAdded){
            new Alert(Alert.AlertType.CONFIRMATION,"Student add..").showAndWait();
        }else {
            new Alert(Alert.AlertType.ERROR,"NO Student Not Added").showAndWait();
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        String Id=txtId.getText();
        String StudentName=txtStudentName.getText();
        String Address=txtAddress.getText();
        int Contact=Integer.parseInt(txtContact.getText());
        String dob=txtdob.getText();
        String Gender=txtGender.getText();
        try {
            Alert alert=new Alert(Alert.AlertType.WARNING,"Are You Sure ?",ButtonType.YES,ButtonType.NO);
            Optional<ButtonType>buttonType=alert.showAndWait();

            if (buttonType.get().equals(ButtonType.YES)){
                 studentBO.deleteStudent(new StudentDTO(Id, StudentName, Address, Contact, dob, Gender));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public  void loadTable(){
        ObservableList<StudentTM>items=tableStudent.getItems();
        items.clear();
        try {
            List<StudentDTO>allStudents=studentBO.getAllStudents();
            for (StudentDTO student:allStudents){
                items.add(new StudentTM(student.getId(),student.getStudentName(),student.getAddress(),student.getContact(),student.getdob(),student.getGender()));
            }
            tableStudent.refresh();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void UpdateOnAction(ActionEvent actionEvent) throws Exception {
    boolean isUpdated=studentBO.updateStudent(new StudentDTO(txtId.getText(),txtStudentName.getText(),txtAddress.getText(),txtContact.getText(),txtdob.getText(),txtGender.getText()));
    if (isUpdated){
        new Alert(Alert.AlertType.CONFIRMATION,"Update Success...",ButtonType.OK).showAndWait();
    }else {
        new Alert(Alert.AlertType.CONFIRMATION,"Update Fail....",ButtonType.OK,ButtonType.CANCEL).showAndWait();
    }
        txtId.clear();
        txtStudentName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtdob.clear();
        txtGender.clear();
        loadTable();
    }

    public void getDataOnAction(ActionEvent actionEvent) {
    }
}
