package entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    @Column
    protected String type;
    @Column
    protected String model;
    @Column
    protected BigDecimal price;
    @Column(name = "fuel_type")
    protected String fuelType;

    public Vehicle() {}
    protected Vehicle (String type) {
        this.type = type;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuel) {
        this.fuelType = fuel;
    }
}
