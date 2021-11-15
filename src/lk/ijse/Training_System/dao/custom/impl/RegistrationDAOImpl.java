package lk.ijse.Training_System.dao.custom.impl;

import lk.ijse.Training_System.dao.custom.RegistrationDAO;
import lk.ijse.Training_System.entity.Registration;
import lk.ijse.Training_System.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {


    @Override
    public boolean save(Registration entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Serializable save= session.save(entity);

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public boolean delete(Registration entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Registration entity) throws Exception {
        return false;
    }

    @Override
    public List<Registration> getAll() throws Exception {
        return null;
    }

    @Override
    public Registration getOne(String s) throws Exception {
        return null;
    }
}
