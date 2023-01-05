package PolyMorphismExercises.P03WildFarm;

public class Mouse extends Mammal{


    public Mouse(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, "Mouse", animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat){
            System.out.println("Mice are not eating that type of food!");
            return;
        }
        setFoodEaten(getFoodEaten() + food.getQuantity());
    }
}
