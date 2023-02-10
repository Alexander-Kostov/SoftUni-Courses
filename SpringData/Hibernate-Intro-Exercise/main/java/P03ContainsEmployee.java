import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class P03ContainsEmployee {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String[] searchedName = scanner.nextLine().split("\\s+");

        entityManager.getTransaction().begin();
        Long employeeResult = entityManager.createQuery("SELECT count(e) FROM Employee as e WHERE e.firstName = :first_name AND " +
                        "e.lastName = :last_name", Long.class).
                setParameter("first_name", searchedName[0]).
                setParameter("last_name", searchedName[1]).
                getSingleResult();

        if (employeeResult == 0) {
            System.out.println("No");
        }else {
            System.out.println("Yes");
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
