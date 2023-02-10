import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class P06AddingANewAddressAndUpdatingEmployee {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        String addressText = "Vitoshka 15";
        Address address = new Address();
        address.setText(addressText);
        entityManager.persist(address);

        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();

        entityManager.createQuery("UPDATE Employee e SET e.address = :address WHERE e.lastName = :lastName")
                .setParameter("address", address).
                setParameter("lastName", lastName).
                executeUpdate();


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
