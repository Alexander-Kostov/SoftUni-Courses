package PolyMorphismExercises.P03WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {

    private String breed;

    public Cat(String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalName, "Cat", animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        setFoodEaten(getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat dc = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %s, %d]", getClass().getSimpleName(),
                getAnimalName(), breed, dc.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());
    }
}
