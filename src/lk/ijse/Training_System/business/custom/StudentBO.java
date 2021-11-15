package lk.ijse.Training_System.business.custom;

import lk.ijse.Training_System.business.SuperBO;
import lk.ijse.Training_System.dto.StudentDTO;

import java.util.List;

public interface StudentBO extends SuperBO {
    public boolean saveStudent(StudentDTO student)throws Exception;

    public boolean deleteStudent(StudentDTO student)throws Exception;

    public boolean updateStudent(StudentDTO student)throws Exception;

    public StudentDTO getStudent(String Id)throws Exception;

    public List<StudentDTO> getAllStudents()throws Exception;
}
