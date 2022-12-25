package InterfacesAndAbstractionLab.P05borderControl;

public class Citizen implements Identifiable {

    private String name;
    private int age;
    private String id;


    protected Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }
}
