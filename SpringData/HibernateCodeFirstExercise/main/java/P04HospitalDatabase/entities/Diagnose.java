package P04HospitalDatabase.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "p04_diagnoses")
public class Diagnose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String comment;

    @ManyToMany(mappedBy = "diagnoses")
    private Set<Patient> patients;

    public Diagnose() {}

    public Diagnose(String name, String comment) {
        this.name = name;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
