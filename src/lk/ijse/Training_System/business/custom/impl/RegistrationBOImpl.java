package lk.ijse.Training_System.business.custom.impl;

import lk.ijse.Training_System.business.custom.RegistrationBO;
import lk.ijse.Training_System.dao.DAOFactory;
import lk.ijse.Training_System.dao.DAOType;
import lk.ijse.Training_System.dao.custom.RegistrationDAO;
import lk.ijse.Training_System.dao.custom.StudentDAO;
import lk.ijse.Training_System.dto.RegistrationDTO;
import lk.ijse.Training_System.entity.Registration;
import lk.ijse.Training_System.entity.Student;

public class RegistrationBOImpl implements RegistrationBO {
    RegistrationDAO registrationDAO = DAOFactory.getInstance().getDAO(DAOType.REGISTRATION);
    @Override
    public boolean saveRegistration(RegistrationDTO registration) throws Exception {
        return registrationDAO.save(new Registration());
    }
}
