package PolymorphismLab.P03Animals;

public abstract class Animal {

    private String name;
    private String favouriteFood;

    protected Animal(String name, String favouriteFood) {
//        this.setName(name);
//        this.setFavouriteFood(favouriteFood);
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s", name, favouriteFood);
    }
}
