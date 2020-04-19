package pl.strefakursow.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.hibernatedemo1.entity.Employee;

public class GetEntityApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");

        conf.addAnnotatedClass(Employee.class);

         SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session1 = sessionFactory.getCurrentSession();

        Employee employee = new Employee();
        employee.setFirstName("Janusz");
        employee.setLastName("Piotrowskki");
        employee.setSalary(10000);

        session1.beginTransaction();

        Integer id = (Integer) (session1.save(employee));

        session1.getTransaction().commit();

        session1 = sessionFactory.getCurrentSession();

        session1.beginTransaction();

        Employee retrivedEmployee = session1.get(Employee.class, id);

        session1.getTransaction().commit();

        System.out.println("Dane pracownik: " + retrivedEmployee);

        sessionFactory.close();

    }

}
