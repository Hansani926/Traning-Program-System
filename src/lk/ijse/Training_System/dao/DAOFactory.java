package lk.ijse.Training_System.dao;

import lk.ijse.Training_System.dao.custom.impl.CourseDAOImpl;
import lk.ijse.Training_System.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.Training_System.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOType daoType){
        switch (daoType){
            case STUDENT:
                return (T) new StudentDAOImpl();
            case COURSE:
                return (T) new CourseDAOImpl();
            case REGISTRATION:
                return (T) new RegistrationDAOImpl();

            default:
                return null;
        }
    }
}
