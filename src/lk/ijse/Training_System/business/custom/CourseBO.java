package lk.ijse.Training_System.business.custom;

import lk.ijse.Training_System.business.SuperBO;
import lk.ijse.Training_System.dto.CourseDTO;
import lk.ijse.Training_System.dto.StudentDTO;

import java.util.List;

public interface CourseBO extends SuperBO {
    public boolean saveCourse(CourseDTO course)throws Exception;

    public boolean deleteCourse(CourseDTO course)throws Exception;

    public boolean updateCourse(CourseDTO course)throws Exception;

    public CourseDTO getCourse(String code)throws Exception;

    public List<CourseDTO> getAllCourses()throws Exception;
}
