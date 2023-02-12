package P02SalesDatabase.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "p02_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(name = "credit_card_number", nullable = false)
    private String creditCardNumber;

    @OneToMany(targetEntity = Sale.class, mappedBy = "customer")
    private Set<Sale> sales;

    public Customer() {}

    public Customer(String name, String email, String creditCardNumber) {
        this.name = name;
        this.email = email;
        this.creditCardNumber = creditCardNumber;
        this.sales = new HashSet<>();
    }

    public int getId () {
        return this.id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
