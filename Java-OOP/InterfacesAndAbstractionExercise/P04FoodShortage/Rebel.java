package InterfacesAndAbstractionExercise.P04FoodShortage;

public class Rebel implements Buyer, Person{

    String name;
    int age;
    String group;
    int food;

    public Rebel(String name) {
        this.name = name;
        this.food = 0;
    }

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    @Override
    public void buyFood() {
        food+=5;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }
}
