package pl.strefakursow.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.hibernatedemo1.entity.Employee;

import java.util.List;
import java.util.Queue;

public class FromApp {

    public static void main(String[] args) {
        // stworzyc obiekt Configuration
        Configuration conf = new Configuration();

        // wczytanie pliku konfiguracyjnego
        conf.configure("hibernate.cfg.xml");

        // wczytanie adnotacji
        conf.addAnnotatedClass(Employee.class);

        // stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();

        // pobranie sesji
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // instrukcje HQL zapisuje się w postaci zwykłego Stringa
        String from = "from Employee"; // wielkosc liter nie ma znaczenie (jak w SQL)

     //   String from3 = "from pl.strefakursow.hqldemo1.entity.Employee"; gdyby tabele nazywaly sie tak samo

        // Teraz zapytanie w postaci obiektowej
        Query query = session.createQuery(from);

        List<Employee> list = query.getResultList();

        for(Employee employee : list){
            System.out.println(employee);
        }

        // zamknięcie obiektu SessionFactory
        factory.close();

    }
}