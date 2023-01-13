package zoo.entities.foods;

public class Vegetable extends BaseFood{

    private static final int CALORIES = 50;
    private static final double PRICE = 5.0;

    public Vegetable() {
        super(CALORIES, PRICE);
    }

    @Override
    public int getCalories() {
        return CALORIES;
    }

    @Override
    public double getPrice() {
        return PRICE;
    }
}
