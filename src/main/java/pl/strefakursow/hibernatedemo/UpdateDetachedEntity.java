package pl.strefakursow.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.hibernatedemo1.entity.Employee;

public class UpdateDetachedEntity {

    public static void main(String[] args) {
        // stworzyc obiekt Configuration
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");

        // wczytanie adnotacji
        conf.addAnnotatedClass(Employee.class);

        // stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();

        // pobranie sesji
        Session session = factory.getCurrentSession();

        // wczytujemy pracownika
        session = factory.getCurrentSession();

        session.beginTransaction();

        Employee employee = session.get(Employee.class, 123);

        session.getTransaction().commit();

        System.out.println("Dane pracownika: " + employee);

        employee.setFirstName("Marcin");
        employee.setLastName("Kwaśniewski");

        session = factory.getCurrentSession();
        session.beginTransaction();

        session.update(employee);

        session.getTransaction().commit();

        session.close();

    }



}
