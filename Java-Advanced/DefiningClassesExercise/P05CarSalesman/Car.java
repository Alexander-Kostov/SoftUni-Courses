package JavaAdvance.DefiningClassesExercise.P05CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine){
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    public Car (String model, Engine engine, int weight){
        this(model,engine);
        this.weight = weight;
    }

    public Car (String model, Engine engine, String color){
        this(model,engine);
        this.color = color;
    }
    public Car (String model, Engine engine, int weight, String color){
        this(model,engine);
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        String weight;
        if (this.weight == -1){
            weight = "n/a";
        }else {
            weight = this.weight + "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(model).append(":").append("\n").append(engine.toString()).append("\n").append("Weight: ")
                .append(weight).append("\n").append("Color: ").append(color);
        return sb.toString();
    }
}
