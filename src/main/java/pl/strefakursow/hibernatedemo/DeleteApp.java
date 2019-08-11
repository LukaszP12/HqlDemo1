package pl.strefakursow.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.hibernatedemo1.entity.Employee;

public class DeleteApp {

    public static void main(String[] args) {
        // stworzyc obiekt Configuration
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");

        // wczytanie adnotacji
        conf.addAnnotatedClass(Employee .class);

        // stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();

        // pobranie sesji
        Session session = factory.getCurrentSession();

        // wczytujemy pracownika
        session = factory.getCurrentSession();

        //nowe wartosci
        int idEmployee = 267;

        session.beginTransaction();

        String delete = "delete Employee e where e.idEmployee=:idEmployee";
        Query query = session.createQuery(delete);
        query.setParameter("idEmployee",idEmployee);
        query.executeUpdate();

        session.getTransaction().commit();

        // zamknięcie obiektu SessionFactory
        factory.close();

    }

}