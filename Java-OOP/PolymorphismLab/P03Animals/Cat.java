package PolymorphismLab.P03Animals;

public class Cat extends Animal {

    private String name;
    private String favouriteFood;

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("%s%nMEEOW",super.explainSelf());
    }
}
