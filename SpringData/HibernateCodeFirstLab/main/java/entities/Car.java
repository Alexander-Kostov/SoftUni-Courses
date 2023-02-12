package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Car extends PassengerVehicle{
    private static String CAR_TYPE = "CAR";

    public Car() {
        super(CAR_TYPE);
    }

    public Car(String model, String fuelType, int seats) {
        this();
        this.model = model;
        this.fuelType = fuelType;
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
