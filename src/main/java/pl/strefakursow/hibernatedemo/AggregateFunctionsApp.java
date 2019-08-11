package pl.strefakursow.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.hibernatedemo1.entity.Employee;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class AggregateFunctionsApp {

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

        String avg = "select avg(e.salary) from Employee e";
        String sum = "select sum(e.salary) from Employee e";
        String min = "select min(e.salary) from Employee e";
        String max = "select max(e.salary) from Employee e";
        String count = "select count(e) from Employee e";

        Query query = session.createQuery(avg);
        Query query1 = session.createQuery(sum);
        Query query2 = session.createQuery(min);
        Query query3 = session.createQuery(max);
        Query query4 = session.createQuery(count);

        Double resultAvg = (Double) query.getSingleResult(); // funkcje agregujace zwrcaja różne typy

        Long resultSum = (Long) query1.getSingleResult();

        Integer resultMin = (Integer) query2.getSingleResult();

        Integer resultMax = (Integer) query3.getSingleResult();

        Long resultCount = (Long) query4.getSingleResult();


        session.getTransaction().commit();

        System.out.println("wynik: " + result);

        // zamknięcie obiektu SessionFactory
        factory.close();

    }

}
