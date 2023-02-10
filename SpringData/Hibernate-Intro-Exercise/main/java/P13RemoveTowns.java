import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class P13RemoveTowns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        String townName = scanner.nextLine();

        List<Address> addresses = entityManager.
                createQuery("SELECT a FROM Address a WHERE a.town.name = :town", Address.class).
                setParameter("town", townName).
                getResultList();

        if (addresses.size() == 0) {
            System.out.println("No town found");
            entityManager.close();
            return;
        }


        addresses.forEach(a -> {
            a.getEmployees().forEach(e -> e.setAddress(null));
            entityManager.remove(a);
        });

        Town townToDelete = entityManager.
                createQuery("SELECT t FROM Town t WHERE t.name = :town", Town.class).
                setParameter("town", townName).
                getSingleResult();

        entityManager.remove(townToDelete);

        String address = addresses.size() == 1 ? "address" : "addresses";
        System.out.printf("%d %s in %s deleted", addresses.size(), address, townName);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
