package lk.ijse.Training_System.business.custom.impl;

import lk.ijse.Training_System.business.custom.CourseBO;
import lk.ijse.Training_System.dao.DAOFactory;
import lk.ijse.Training_System.dao.DAOType;
import lk.ijse.Training_System.dao.custom.CourseDAO;
import lk.ijse.Training_System.dao.custom.StudentDAO;
import lk.ijse.Training_System.dto.CourseDTO;
import lk.ijse.Training_System.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {
    CourseDAO courseDAO = DAOFactory.getInstance().getDAO(DAOType.COURSE);
    @Override
    public boolean saveCourse(CourseDTO course) throws Exception {
        return courseDAO.save(new Course(course.getCode(),course.getCourseName(), course.getCourseType(), course.getDuration()));
    }


    @Override
    public boolean deleteCourse(CourseDTO course) throws Exception {
        return courseDAO.delete(new Course(course.getCode(),course.getCourseName(), course.getCourseType(), course.getDuration()));
    }

    @Override
    public boolean updateCourse(CourseDTO course) throws Exception {
        return courseDAO.update(new Course(course.getCode(),course.getCourseName(), course.getCourseType(), course.getDuration()));
    }

    @Override
    public CourseDTO getCourse(String code) throws Exception {
        Course one = courseDAO.getOne(code);
        return new CourseDTO(one.getCode(),one.getCourseName(), one.getCourseType(), one.getDuration());
    }

    @Override
    public List<CourseDTO> getAllCourses() throws Exception {
        List<Course> all = courseDAO.getAll();

        List<CourseDTO> courseDTOList = new ArrayList<>();

        for (Course course : all) {
            courseDTOList.add(new CourseDTO(course.getCode(),course.getCourseName(), course.getCourseType(), course.getDuration()));
        }
        return courseDTOList;
    }
}
