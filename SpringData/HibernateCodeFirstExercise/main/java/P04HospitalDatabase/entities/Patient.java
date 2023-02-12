package P04HospitalDatabase.entities;


import javax.persistence.*;
import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "p04_patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    private String address;

    @Column(unique = true)
    private String email;

    @Column(name = "brith_date", nullable = false)
    private LocalDate birthdate;

    @Column @Lob
    private Blob picture;

    @Column(name = "has_medical_insurance", nullable = false)
    private boolean hasMedicalInsurance;

    @OneToMany(mappedBy = "patient")
    private Set<Visitation> visitations;

    @ManyToMany
    @JoinTable(
            name = "p04_patients_medicaments",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "diagnose_id", referencedColumnName = "id")
    )
    private Set<Medicament> medicaments;

    @ManyToMany
    @JoinTable(
            name = "p04_patients_diagnoses",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "diagnose_id", referencedColumnName = "id")
    )
    private Set<Diagnose> diagnoses;

    public Patient () {}

    public Patient(String firstName, String lastName, String address, String email, LocalDate birthdate, Blob picture, boolean hasMedicalInsurance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.birthdate = birthdate;
        this.picture = picture;
        this.hasMedicalInsurance = hasMedicalInsurance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public boolean isHasMedicalInsurance() {
        return hasMedicalInsurance;
    }

    public void setHasMedicalInsurance(boolean hasMedicalInsurance) {
        this.hasMedicalInsurance = hasMedicalInsurance;
    }
}
