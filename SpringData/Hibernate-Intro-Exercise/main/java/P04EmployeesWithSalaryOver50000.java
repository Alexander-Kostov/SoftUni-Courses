import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class P04EmployeesWithSalaryOver50000 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        List <String> resultList = entityManager.createQuery("SELECT e.firstName FROM Employee as e WHERE e.salary > 50000", String.class).
                getResultList();

        String result = String.join("\n", resultList);
        System.out.println(result);


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
