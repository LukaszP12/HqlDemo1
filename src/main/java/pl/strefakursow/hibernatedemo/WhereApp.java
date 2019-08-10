package pl.strefakursow.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.hibernatedemo1.entity.Employee;

import java.util.List;

public class WhereApp {

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

        session.beginTransaction();

        String where = "from Employee where firstName='Tadeusz'";
        String where2 = "from Employee where salary > 12000";
        String where3 = "from Employee where salary < 3000 or salary > 13000";
        String where4 = "from Employee where salary is null";
        String where5 = "from Employee where lastName in ('Hutton','Errazuriz','Wiśniewski)";

        Query query = session.createQuery(where2);
        Query query1 = session.createQuery(where3);
        Query query2 = session.createQuery(where4);
        Query query3 = session.createQuery(where5); 

        List<Employee> list = query.getResultList();

        session.getTransaction().commit();

        for(Employee employee : list){
            System.out.println(employee);
        }

        // zamknięcie obiektu SessionFactory
        factory.close();

    }

}
