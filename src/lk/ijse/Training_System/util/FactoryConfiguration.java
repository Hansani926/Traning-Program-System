package lk.ijse.Training_System.util;

import lk.ijse.Training_System.entity.Course;
import lk.ijse.Training_System.entity.Registration;
import lk.ijse.Training_System.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {
private static FactoryConfiguration factoryConfiguration;
public  static SessionFactory sessionFactory;



    private FactoryConfiguration(){
        Properties properties =new Properties();
        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("lk/ijse/Training_System/application.properties"));
            sessionFactory = new Configuration().mergeProperties(properties)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Registration.class).buildSessionFactory();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public  static  FactoryConfiguration getInstance() {
        return (factoryConfiguration==null) ? (factoryConfiguration = new FactoryConfiguration()) : (factoryConfiguration);
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
