package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GarageTests {
    private Garage garage;
    private Car firstCar;
    private Car secondCar;
    private Car thirdCar;

    @Before
    public void setup(){
        garage = new Garage();
        firstCar = new Car("Audi", 200, 20);
        secondCar = new Car("Audi", 240, 40);
        thirdCar = new Car("Bmw", 220, 30);

        garage.addCar(firstCar);
        garage.addCar(secondCar);
        garage.addCar(thirdCar);
    }

    @Test
    public void checkIfCountIsAccurate() {
        Assert.assertEquals(3, garage.getCount());
    }

    @Test
    public void findAllCarsWithMaxSpeed() {
        List<Car> expected = new ArrayList<>();
        expected.add(secondCar);
        expected.add(thirdCar);

        Assert.assertEquals(expected, garage.findAllCarsWithMaxSpeedAbove(200));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addInvalidNullCar() {
        garage.addCar(null);
    }

    @Test
    public void checkForMostExpensiveCar() {
        Assert.assertEquals(secondCar,garage.getTheMostExpensiveCar());
    }

    @Test
    public void findAllCarsByBrandAudi() {
        List<Car> cars = new ArrayList<>();
        cars.add(firstCar);
        cars.add(secondCar);

        Assert.assertEquals(cars,garage.findAllCarsByBrand("Audi"));
    }


}