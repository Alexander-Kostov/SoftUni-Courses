package zoo.core;

import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static zoo.common.ConstantMessages.*;
import static zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area;
        if (areaType.equals("WaterArea")) {
            area = new WaterArea(areaName);
        } else if (areaType.equals("LandArea")) {
            area = new LandArea(areaName);
        } else {
            throw new NullPointerException(INVALID_AREA_TYPE);
        }

        areas.add(area);

        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        if (foodType.equals("Meat")) {
            food = new Meat();
        } else if (foodType.equals("Vegetable")) {
            food = new Vegetable();
        } else {
            throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }

        foodRepository.add(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = foodRepository.findByType(foodType);
        if (food != null) {
            Area area = getArea(areaName);
            area.addFood(food);
            foodRepository.remove(food);
            return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
        } else {
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }
    }


    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;
        if (animalType.equals("AquaticAnimal")) {
            animal = new AquaticAnimal(animalName, kind, price);
        } else if (animalType.equals("TerrestrialAnimal")) {
            animal = new TerrestrialAnimal(animalName, kind, price);
        } else {
            throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }
        Area area = getArea(areaName);

        boolean waterAnimalIsFit = animalType.equals("AquaticAnimal") && area.getClass().getSimpleName().equals("WaterArea");
        boolean LandAnimalIsFit = animalType.equals("TerrestrialAnimal") && area.getClass().getSimpleName().equals("LandArea");

        if (waterAnimalIsFit || LandAnimalIsFit) {
            area.addAnimal(animal);
        } else {
            return AREA_NOT_SUITABLE;
        }


        return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }

    @Override
    public String feedAnimal(String areaName) {
        Area area = getArea(areaName);
        area.feed();
        int size = area.getAnimals().size();

        return String.format(ANIMALS_FED, size);
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = getArea(areaName);
        double sumKG = area.getAnimals().stream().mapToDouble(Animal::getKg).sum();
        return String.format(KILOGRAMS_AREA, areaName, sumKG);
    }

    @Override
    public String getStatistics() {
        return areas.stream().map(Area::getInfo).collect(Collectors.joining(System.lineSeparator()));
    }

    private Area getArea(String areaName) {
        return areas.stream().filter(s -> s.getName().equals(areaName)).findFirst().orElse(null);
    }
}
