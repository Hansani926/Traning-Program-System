package lk.ijse.Training_System.business.custom.impl;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import lk.ijse.Training_System.business.custom.StudentBO;
import lk.ijse.Training_System.dao.DAOFactory;
import lk.ijse.Training_System.dao.DAOType;
import lk.ijse.Training_System.dao.custom.StudentDAO;
import lk.ijse.Training_System.dto.StudentDTO;
import lk.ijse.Training_System.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOType.STUDENT);
    @Override
    public boolean saveStudent(StudentDTO student) throws Exception {
       /* System.out.println("bo"+student.toString());*/
        return studentDAO.save(new Student(student.getId(),
                student.getStudentName(),
                student.getAddress(),
                student.getContact(),
                student.getdob(),
                student.getGender()));
    }


    @Override
    public boolean deleteStudent(StudentDTO student) throws Exception {
        return studentDAO.delete(new Student(student.getId(),student.getStudentName(),student.getAddress(),student.getContact(),student.getdob(),student.getGender()));
    }

    @Override
    public boolean updateStudent(StudentDTO student) throws Exception {
        return studentDAO.update(new Student(student.getId(),student.getStudentName(),student.getAddress(),student.getContact(),student.getdob(),student.getGender()));
    }

    @Override
    public StudentDTO getStudent(String Id) throws Exception {
        Student s= studentDAO.getOne(Id);
        return new StudentDTO(s.getId(),s.getStudentName(),s.getAddress(),s.getContact(),s.getdob(),s.getGender());
    }

    @Override
    public List<StudentDTO> getAllStudents() throws Exception {
        List<Student> studentList = studentDAO.getAll();

        List<StudentDTO> studentDTOList = new ArrayList<>();

        for (Student student : studentList){
            studentDTOList.add(new StudentDTO(student.getId(),student.getStudentName(),student.getAddress(),student.getContact(),student.getdob(),student.getGender()));
        }
        return studentDTOList;
    }
}
