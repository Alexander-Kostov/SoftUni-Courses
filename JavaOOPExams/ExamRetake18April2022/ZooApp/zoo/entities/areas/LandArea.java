package zoo.entities.areas;

import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.Collection;

public class LandArea extends BaseArea {

    private static final int CAPACITY = 25;

    public LandArea(String name) {
        super(name, CAPACITY);
    }

}
