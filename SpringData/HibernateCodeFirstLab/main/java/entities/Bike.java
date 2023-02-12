package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Bike extends Vehicle{
    private static String BIKE_TYPE = "Bike";

    public Bike() {
        super(BIKE_TYPE);
    }

}
