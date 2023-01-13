package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PetStoreTests {
    private PetStore petStore;
    private Animal firstAnimal;
    private Animal secondAnimal;
    private Animal thirdAnimal;
    private Animal fourthAnimal;

    @Before
    public void setup() {
        petStore = new PetStore();

        firstAnimal = new Animal("Dog", 20, 5.50);
        secondAnimal = new Animal("Cat", 9, 10.00);
        thirdAnimal = new Animal("Dog", 14, 6.20);
        fourthAnimal = new Animal("Monkey", 17, 25);


        petStore.addAnimal(firstAnimal);
        petStore.addAnimal(secondAnimal);
        petStore.addAnimal(thirdAnimal);
        petStore.addAnimal(fourthAnimal);


    }

    @Test
    public void animalCount() {
        Assert.assertEquals(4, petStore.getCount());
    }

    @Test
    public void findAnimalsMaxKg() {
        List<Animal> expected = new ArrayList<>();

        expected.add(firstAnimal);
        expected.add(fourthAnimal);

        List<Animal> actual = petStore.findAllAnimalsWithMaxKilograms(15);

        Assert.assertEquals(expected, actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void addingNullAnimalShouldThrowException() {
        petStore.addAnimal(null);
    }

    @Test
    public void mostExpensiveAnimalShouldBeMonkey() {
        Animal expected = petStore.getTheMostExpensiveAnimal();

        Assert.assertEquals(expected, fourthAnimal);
    }

    @Test
    public void findAnimalBySpecieDog() {
        List<Animal> expected = new ArrayList<>();
        expected.add(firstAnimal);
        expected.add(thirdAnimal);

        List<Animal> actual = petStore.findAllAnimalBySpecie("Dog");

        Assert.assertEquals(expected, actual);
    }
}

