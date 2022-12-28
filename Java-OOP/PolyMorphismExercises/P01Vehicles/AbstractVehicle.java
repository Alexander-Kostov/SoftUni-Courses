package PolyMorphismExercises.P01Vehicles;

import java.text.DecimalFormat;

public abstract class AbstractVehicle implements Vehicle{

    private double fuelQuantity;
    private double fuelConsumption;
    


    public AbstractVehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    protected boolean hasEnoughFuel (double kilometers){
        double totalFuelCost = kilometers * getFuelConsumption();
        return totalFuelCost < fuelQuantity;
    }

    public String drive(double kilometers){
        DecimalFormat dc = new DecimalFormat( "#.##" );
        if (hasEnoughFuel(kilometers)){
            consumeFuel(kilometers);
            return "travelled " + dc.format(kilometers) + " km";
        }
        return "needs refueling";
    }

    public void consumeFuel(double kilometers){
        fuelQuantity -= kilometers * fuelConsumption;
    }

    public void refuel(double liters) {
        setFuelQuantity(getFuelQuantity() + liters);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(),getFuelQuantity());
    }
}
