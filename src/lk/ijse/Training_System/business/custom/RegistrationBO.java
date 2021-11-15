package lk.ijse.Training_System.business.custom;

import lk.ijse.Training_System.business.SuperBO;
import lk.ijse.Training_System.dto.RegistrationDTO;
import lk.ijse.Training_System.dto.StudentDTO;

public interface RegistrationBO extends SuperBO {
    public boolean saveRegistration(RegistrationDTO registration)throws Exception;
}
