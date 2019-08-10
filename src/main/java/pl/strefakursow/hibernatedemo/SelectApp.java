package pl.strefakursow.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.hibernatedemo1.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class SelectApp {

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

        String select = "select firstName, lastName from Employee"; // piszemy nazwy z encji
        String select1 = "select e.firstName, e.lastName from Employee as e"; // korzystamy z aliasu
        String select2 = "select e.firstName, e.lastName from Employee"; // nawet jeżeli nie damy e, to Hibernate i domyśli się, że jest to alias

        Query query = session.createQuery(select);
        List<Object> result = query.getResultList(); // wyniki w formie listy obiektów

        session.getTransaction().commit();

        for(Object[] values : result){
            System.out.println("firstName: " + values[0] + ", lastName: " + values[1]);
            }

        // zamknięcie obiektu SessionFactory
        factory.close();

        }
    }

