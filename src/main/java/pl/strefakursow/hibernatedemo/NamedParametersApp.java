package pl.strefakursow.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.hibernatedemo1.entity.Employee;

import java.util.List;

//named parameters

public class NamedParametersApp {

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

        String employeeFirstName = "Steven";
        String employeeLastName = "King";

        session.beginTransaction();

        String queryString = "select e.firstName, e.lastName, e.salary from Employee e where e.firstName=' "+
                employeeFirstName + "' and e.lastName='" + employeeLastName + "'";

        String namedParametersString = "select e.firstName, e.lastName, e.salary from Employee e where e.firstName=:firstName "; //: oznacza że dynamicznie chcemy wstawić imię

        Query namedParametersQuery = session.createNamedQuery(namedParametersString);
        namedParametersQuery.setParameter("firstName",employeeFirstName);
        namedParametersQuery.setParameter("lastName",employeeLastName);

        List<Object[]> result = namedParametersQuery.getResultList();

        session.getTransaction().commit();

        for (Object[] values : result){
            System.out.println("firstName: " + values[0] + "lastName: " + values[1] + ", salary: " + values[2]);
        }

        // zamknięcie obiektu SessionFactory
        factory.close();
    }

}