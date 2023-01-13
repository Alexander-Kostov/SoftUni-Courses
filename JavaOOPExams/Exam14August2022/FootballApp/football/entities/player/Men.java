package football.entities.player;

public class Men extends BasePlayer {

    private static final double KG = 85.50;
    private static final int STRENGTH = 145;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, strength);
    }


    @Override
    public void stimulation() {
        setStrength(getStrength() + STRENGTH);
    }

}
