package PolyMorphismExercises.P03WildFarm;

public class Zebra extends Mammal{


    public Zebra(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, "Zebra", animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat){
            System.out.println("Zebras are not eating that type of food!");
            return;
        }
        setFoodEaten(getFoodEaten() + food.getQuantity());
    }
}
