package pl.strefakursow.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.hibernatedemo1.entity.Employee;

import java.util.List;

public class UpdateApp {

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

        //nowe wartosci
        int idEmployee = 267;
        int salary = 15000;

        session.beginTransaction();

        String update = "Update Employee e set e.salary=:salary where e.idEmployee=:idEmployee";
        Query query = session.createQuery(update);
        query.setParameter("salary",salary);
        query.setParameter("idEmployee",idEmployee);
        query.executeUpdate();

        session.getTransaction().commit();

        // zamknięcie obiektu SessionFactory
        factory.close();
    }

}
