package entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Plane extends Vehicle {
    private static String planeType = "Plane";
    @Basic
    private int passengerCapacity;

    public Plane() {
        super(planeType);
    }

    public Plane(String model, String fuelType, int passengerCapacity) {
        this();

        this.model = model;
        this.fuelType = fuelType;
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
