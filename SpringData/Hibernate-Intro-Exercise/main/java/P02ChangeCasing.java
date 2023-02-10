import entities.Town;

import javax.persistence.*;
import java.util.List;

public class P02ChangeCasing {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Query fromQuery = entityManager.createQuery("SELECT t FROM Town as t", Town.class);

        List<Town> townResultSet = fromQuery.getResultList();

        for (Town town : townResultSet) {
            String name = town.getName();

            if (name.length() <= 5) {
                String upper = name.toUpperCase();
                town.setName(upper);
            }
            entityManager.persist(town);
        }


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
