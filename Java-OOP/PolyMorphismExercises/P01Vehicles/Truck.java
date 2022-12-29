package PolyMorphismExercises.P01Vehicles;

public class Truck extends AbstractVehicle{
    private static final double FUEL_CONSUMPTION_INCREASE = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + FUEL_CONSUMPTION_INCREASE);
    }

    @Override
    public String drive(double kilometers) {
        return "Truck " + super.drive(kilometers);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
