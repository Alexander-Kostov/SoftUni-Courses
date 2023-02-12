package P04HospitalDatabase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.sql.Connection;

public class P04Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernateExercise");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
