package pl.strefakursow.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.hibernatedemo1.entity.Employee;

import java.util.List;

public class OrderByApp {

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

        String orderBy = "select e.firstName, e.lastName from Employee e order by e.firstName";
        //String orderBy = "select e.firstName, e.lastName from Employee e order by e.lastName desc";
        String orderBy3 = "select e.firstName, e.lastName, e.salary from Employee e order by e.salary asc";

        Query query = session.createQuery(orderBy);
        //Query  query1 = session.createQuery(orderBy);
        Query query1 = session.createQuery(orderBy3);

        List<Object[]> result1 = query1.getResultList();

        List<Object[]> result = query.getResultList();

        // zamknięcie obiektu SessionFactory
        factory.close();


        }

    }