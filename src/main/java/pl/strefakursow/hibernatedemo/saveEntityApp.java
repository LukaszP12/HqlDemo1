package pl.strefakursow.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.hibernatedemo1.entity.Employee;

public class saveEntityApp {

    public static void main(String[] args) {

        // configuration object
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        // adding the annotated class
        configuration.addAnnotatedClass(Employee.class);

        // starting the session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // starting the session
        Session currentSession = sessionFactory.getCurrentSession();

        // begining the transaction
        currentSession.beginTransaction();

        Employee employee = new Employee();

        employee.setIdEmployee(119);
        employee.setFirstName("Lukas");
        employee.setLastName("Kowalski");
        employee.setSalary(4000);

        currentSession.save(employee);

        sessionFactory.close();

    }

}
