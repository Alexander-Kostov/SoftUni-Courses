import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;

public class P09FindLatest10Projects {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

       entityManager.createQuery("SELECT p FROM Project p " +
                "ORDER BY p.startDate DESC", Project.class).setMaxResults(10).getResultList().
               stream().sorted(Comparator.comparing(Project::getName)).forEach(System.out::println);


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
