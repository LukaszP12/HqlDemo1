package pl.strefakursow.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.hibernatedemo1.entity.Employee;

import java.util.List;

public class GetAllEntitiesApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");

        conf.addAnnotatedClass(Employee.class);

        SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session1 = sessionFactory.getCurrentSession();

        session1.beginTransaction();

        List<Employee> from_employee = session1.createQuery("from Employee").getResultList();

        for (Employee employee : from_employee){
            System.out.println(employee.getFirstName() + " " + employee.getLastName() + "earns" +  employee.getSalary());
        }

        session1.close();

    }

}
