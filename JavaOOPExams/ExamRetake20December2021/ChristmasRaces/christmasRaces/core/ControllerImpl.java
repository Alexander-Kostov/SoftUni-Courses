package christmasRaces.core;

import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

import static christmasRaces.common.ExceptionMessages.*;
import static christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        Driver driverToAdd = driverRepository.getByName(driver);

        if (driverToAdd != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
        }
        Driver newDriver = new DriverImpl(driver);
        driverRepository.add(newDriver);
        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;
        String typeCar = null;

        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        if (carRepository.getByName(model) != null){
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }

        if (type.equals("Muscle")){
            car = new MuscleCar(model, horsePower);
            typeCar = "MuscleCar";
        }else if (type.equals("Sports")){
            car = new SportsCar(model, horsePower);
            typeCar = "SportsCar";
        }

        carRepository.add(car);

        return String.format(CAR_CREATED, typeCar, model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = driverRepository.getByName(driverName);
        if (driver == null){
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        Car car = carRepository.getByName(carModel);
        if (car == null){
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }

        driver.addCar(car);

        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null){
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        Driver driver = driverRepository.getByName(driverName);
        if (driver == null){
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        race.addDriver(driver);
        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        if (raceRepository.getByName(raceName) == null){
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        Race race = raceRepository.getByName(raceName);
        if (race.getDrivers().stream().filter(Driver::getCanParticipate).count() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

//        List<Driver> sortedDrivers = race.getDrivers().stream().sorted((d1,d2) ->
//                Double.compare(d1.getCar().calculateRacePoints(race.getLaps()),d2.getCar().calculateRacePoints(race.getLaps()))).
//                collect(Collectors.toList());

        List<Driver> sortedDrivers = race.getDrivers().stream().
                sorted((s1, s2) -> Double.compare(s2.getCar().calculateRacePoints(race.getLaps()), s1.getCar().calculateRacePoints(race.getLaps()))).
                collect(Collectors.toList());
        return String.format(DRIVER_FIRST_POSITION, sortedDrivers.get(0).getName(), raceName) + System.lineSeparator() +
                String.format(DRIVER_SECOND_POSITION, sortedDrivers.get(1).getName(), raceName) + System.lineSeparator() +
                String.format(DRIVER_THIRD_POSITION, sortedDrivers.get(2).getName(), raceName);
    }

    @Override
    public String createRace(String name, int laps) {


        if (raceRepository.getByName(name) != null){
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }

        RaceImpl race = new RaceImpl(name, laps);
        raceRepository.add(race);
        return String.format(RACE_CREATED, name);
    }
}
