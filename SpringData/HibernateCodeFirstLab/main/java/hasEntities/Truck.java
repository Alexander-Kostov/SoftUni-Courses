package hasEntities;

import javax.persistence.*;

@Entity
@Table(name = "trucks")
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "plate_number_id", referencedColumnName = "id")
    private PlateNumber plateNumber;

    public Truck(){}

    public Truck(PlateNumber plateNumber) {
        this.plateNumber = plateNumber;
    }
}
