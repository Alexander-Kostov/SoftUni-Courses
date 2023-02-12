import entities.Bike;
import entities.Car;
import entities.Plane;
import entities.Vehicle;
import hasEntities.Article;
import hasEntities.PlateNumber;
import hasEntities.Truck;
import hasEntities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManager relations = Persistence.createEntityManagerFactory("relations").createEntityManager();

        relations.getTransaction().begin();

//        Vehicle car = new Car("Audi A7", "Petrol", 4);
//        Vehicle bike = new Bike();
//        Vehicle plane = new Plane("Airbus", "Petrol", 40);
//
//        relations.persist(car);
//        relations.persist(bike);
//        relations.persist(plane);
//
//        Car car1 = relations.find(Car.class, 1L);
//
//        PlateNumber plateNumber = new PlateNumber("1234");
//        Truck truck1 = new Truck(plateNumber);
//        Truck truck2 = new Truck(plateNumber);
//
//        relations.persist(plateNumber);
//        relations.persist(truck1);
//        relations.persist(truck2);
//
//        System.out.println(car1.getSeats() + car1.getModel());

        Article article = new Article("dsadsada");
        User author = new User("Toshko");

        article.setAuthor(author);
        author.addArticle(article);

        relations.persist(author);

        relations.getTransaction().commit();
        relations.close();
    }
}