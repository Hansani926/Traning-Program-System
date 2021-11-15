package lk.ijse.Training_System.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Training_System.business.BOFactory;
import lk.ijse.Training_System.business.BOType;
import lk.ijse.Training_System.business.custom.CourseBO;
import lk.ijse.Training_System.dto.CourseDTO;
import lk.ijse.Training_System.model.CourseTM;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static sun.net.www.MimeTable.loadTable;

public class CourseFormController {
    public AnchorPane root;
    public TextField txtcode;
    public TextField txtcourseName;
    public TextField txtcourseType;
    public TextField txtduration;
    public TextField txtSearch;
    public TableView<CourseTM> tableCourse;
    public TableColumn colcode;
    public TableColumn colcourseType;
    public TableColumn colduration;
    public TableColumn colcourseName;
    public Button btnSave;
    public Button btnDelete;
    public Button btnUpdate;

    CourseBO courseBO = BOFactory.getInstance().getBO(BOType.COURSE);

    public  void  initialize(){
        btnDelete.setDisable(true);

        tableCourse.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("code"));
        tableCourse.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("courseName"));
        tableCourse.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("courseType"));
        tableCourse.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("duration"));

        loadTable();

tableCourse.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CourseTM>() {
    @Override
    public void changed(ObservableValue<? extends CourseTM> observable, CourseTM oldValue, CourseTM newValue) {
        btnDelete.setDisable(false);
        btnSave.setText("Save");

        CourseTM selectedItem =tableCourse.getSelectionModel().getSelectedItem();
        if(selectedItem==null){
            return;
        }
        txtcode.setText(selectedItem.getCode());
        txtcourseName.setText(selectedItem.getCourseName());
        txtcourseType.setText(selectedItem.getCourseType());
        txtduration.setText(selectedItem.getDuration());
    }
});

    }










    public void backOnAction(MouseEvent mouseEvent) throws IOException{
        setUI("MainForm.fxml");
    }

    private void setUI(String location) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/"+location))));
    }

    public void backToHomeOnAction(MouseEvent mouseEvent) {
    }

    public void getDataOnAtion(ActionEvent actionEvent) {
    }

    public void SaveOnAction(ActionEvent actionEvent) {
        String code=txtcode.getText();
        String courseName=txtcourseName.getText();
        String courseType=txtcourseType.getText();
        String duration=txtduration.getText();

        CourseDTO courseDTO = new CourseDTO(code,courseName,courseType,duration);
        if (btnSave.getText().trim().equals("Save")){
            save(courseDTO);
        }else {
            update(courseDTO);
        }

        txtcode.clear();
        txtcourseName.clear();
        txtcourseType.clear();
        txtduration.clear();
        btnSave.setText("Save");
        loadTable();
    }

    private void update(CourseDTO courseDTO) {
        try {
            boolean isAdded = courseBO.updateCourse(courseDTO);
            if(isAdded){
                new Alert(Alert.AlertType.CONFIRMATION, "Add Course.....").showAndWait();
            }else {
                new Alert(Alert.AlertType.ERROR, "Course not Added...").showAndWait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void save(CourseDTO courseDTO) {
        try {
            boolean isAdded = courseBO.saveCourse(courseDTO);
            if(isAdded){
                new Alert(Alert.AlertType.CONFIRMATION, "Add Course.....").showAndWait();
            }else {
                new Alert(Alert.AlertType.ERROR, "Course not Added...").showAndWait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        String code= txtcode.getText();
        String courseName=txtcourseName.getText();
        String courseType=txtcourseType.getText();
        String duration =txtduration.getText();
       try {
           Alert alert =new Alert(Alert.AlertType.WARNING,"Delete Course....",ButtonType.YES,ButtonType.NO);
           Optional<ButtonType> buttonType=alert.showAndWait();

           if (buttonType.get().equals(ButtonType.YES)){
               courseBO.deleteCourse(new CourseDTO(code,courseName,courseType,duration));
           }
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public  void  loadTable(){
        ObservableList<CourseTM>items=tableCourse.getItems();
        items.clear();
        try {
            List<CourseDTO>allCourses=courseBO.getAllCourses();
            for (CourseDTO course:allCourses){
                items.add(new CourseTM(course.getCode(),course.getCourseName(),course.getCourseType(),course.getDuration()));
            }
            tableCourse.refresh();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }
}
