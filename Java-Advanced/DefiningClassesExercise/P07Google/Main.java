package JavaAdvance.DefiningClassesExercise.P07Google;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        HashMap<String, Person> personData = new HashMap<>();

        while (!input.equals("End")){
            String [] data = input.split("\\s+");
            String name = data[0];

            if (!personData.containsKey(name)){
                personData.put(name,new Person());
            }
            String enteredData = data[1];

            switch (enteredData){
                case "company":
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);
                    Company company = new Company(companyName,department,salary);
                    personData.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = data[2];
                    String pokemonType = data[3];
                    Pokemon pokemon = new Pokemon(pokemonName,pokemonType);
                    personData.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = data[2];
                    String parentBirthday = data[3];
                    Parent parent = new Parent(parentName,parentBirthday);
                    personData.get(name).getParents().add(parent);
                    break;
                case "children":
                    String childName = data[2];
                    String childbirthday = data[3];
                    Child child = new Child(childName,childbirthday);
                    personData.get(name).getChildren().add(child);
                    break;
                case "car":
                    String carModel = data[2];
                    int carSpeed = Integer.parseInt(data[3]);
                    Car car = new Car(carModel,carSpeed);
                    personData.get(name).setCar(car);
                    break;
            }


            input = scanner.nextLine();
        }

        String searchedPerson = scanner.nextLine();
        System.out.println(searchedPerson);

        Person personalData = personData.get(searchedPerson);
        System.out.println(personalData);

    }
}
