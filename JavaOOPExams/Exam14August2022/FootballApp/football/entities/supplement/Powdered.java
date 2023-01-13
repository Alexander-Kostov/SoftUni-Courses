package football.entities.supplement;

import football.entities.supplement.BaseSupplement;

public class Powdered extends BaseSupplement {

    private static final int ENERGY = 120;
    private static final double PRICE = 15.00;

    public Powdered() {
        super(ENERGY, PRICE);
    }

    @Override
    public int getEnergy() {
        return ENERGY;
    }

    @Override
    public double getPrice() {
        return PRICE;
    }
}
