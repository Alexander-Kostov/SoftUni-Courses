package P04HospitalDatabase.entities;

import P03UniversitySystem.entities.Student;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "p04_medicaments")
public class Medicament{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "medicaments")
    private Set<Patient> patients;

    public Medicament() {}

    public Medicament(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
