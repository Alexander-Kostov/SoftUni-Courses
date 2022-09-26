package JavaAdvance.DefiningClassesExercise.P05CarSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;


    public Engine (String model, int power){
        this.model = model;
        this.power = power;
        this.displacement = -1;
        this.efficiency = "n/a";
    }

    public Engine (String model, int power, int displacement){
        this(model,power);
        this.displacement = displacement;
    }

    public Engine (String model, int power, String efficiency){
        this(model,power);
        this.efficiency = efficiency;
    }

    public Engine (String model, int power, int displacement, String efficiency){
        this(model,power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        String displacement;
        if (this.displacement == -1){
            displacement = "n/a";
        }else {
            displacement = this.displacement + "";
        }
        StringBuilder sb = new StringBuilder();

        sb.append(model).append(":").append("\n").
                append("Power: ").append(power).append("\n")
                .append("Displacement: ").append(displacement).append("\n")
                .append("Efficiency: ").append(efficiency);
        return sb.toString();
    }
}
