import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class P12EmployeesMaximumSalaries {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

       entityManager.createQuery("SELECT e.department.name, MAX(e.salary) FROM Employee e GROUP BY e.department.id " +
                "HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000", Object[].class).getResultList().forEach(o -> {
            System.out.println(o[0] + " " + o[1]);
        });




        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
