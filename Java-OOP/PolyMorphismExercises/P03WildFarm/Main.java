package PolyMorphismExercises.P03WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();
        List<Food> foods = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] animalData = input.split("\\s+");
            String animalType = animalData[0];
            switch (animalType) {
                case "Mouse":
                    Mouse mouse = new Mouse(animalData[1], Double.parseDouble(animalData[2]), animalData[3]);
                    animals.add(mouse);
                    break;
                case "Zebra":
                    Zebra zebra = new Zebra(animalData[1], Double.parseDouble(animalData[2]), animalData[3]);
                    animals.add(zebra);
                    break;
                case "Cat":
                    Cat cat = new Cat(animalData[1], Double.parseDouble(animalData[2]), animalData[3], animalData[4]);
                    animals.add(cat);
                    break;
                case "Tiger":
                    Tiger tiger = new Tiger(animalData[1], Double.parseDouble(animalData[2]), animalData[3]);
                    animals.add(tiger);
                    break;
            }

            String[] foodData = scanner.nextLine().split("\\s+");
            if ("Vegetable".equals(foodData[0])){
                Vegetable vegetable = new Vegetable(Integer.parseInt(foodData[1]));
                foods.add(vegetable);
            }else if ("Meat".equals(foodData[0])){
                Meat meat = new Meat(Integer.parseInt(foodData[1]));
                foods.add(meat);
            }


                input = scanner.nextLine();
        }

        for (int i = 0; i < animals.size(); i++) {
            Animal currentAnimal = animals.get(i);
            Food food = foods.get(i);

            currentAnimal.makeSound();
            currentAnimal.eat(food);
        }

        for (int i = 0; i < animals.size(); i++) {
            Animal currentAnimal = animals.get(i);
            System.out.println(currentAnimal);
        }
    }
}
