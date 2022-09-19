package JavaAdvance.DefiningClassesLab.Constructors;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car (String brand, String model, int horsePower){
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car(String brand){
        this(brand, "unknown", -1);
    }

    public String getBrand() {
        return this.brand;
    }

    public String setBrand(String brand){
        return this.brand = brand;
    }

    public String getModel (){
        return this.model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public int getHorsePower(){
        return this.horsePower;
    }

    public void setHorsePower(int horsePower){
        this.horsePower = horsePower;
    }

    public String carInfo (){
        return String.format("The car is: %s %s - %d HP.",getBrand(),getModel(),getHorsePower());
    }
}
