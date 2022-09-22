package JavaAdvance.DefiningClassesExercise.P03SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int distance;

    public Car (String model, double fuelAmount, double fuelCost){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distance = 0;
    }
    public boolean hasEnoughFuel (int kilometers){
        return fuelAmount >= calculatedFuel(kilometers);
    }

    public void drive (int kilometers){
        double fuelNeed = calculatedFuel(kilometers);
        fuelAmount -= fuelNeed;
        distance += kilometers;
    }

    public double calculatedFuel (int kilometers){
        return kilometers * fuelCost;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model,fuelAmount,distance);
    }
}
