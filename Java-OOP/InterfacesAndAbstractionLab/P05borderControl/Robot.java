package InterfacesAndAbstractionLab.P05borderControl;

public class Robot implements Identifiable{

    private String model;
    private String id;


    protected Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String getId() {
        return id;
    }
}
