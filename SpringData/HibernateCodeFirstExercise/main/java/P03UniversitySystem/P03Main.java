package P03UniversitySystem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class P03Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernateExercise");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();



        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
