package fairyShop.models;

import java.util.Collection;

public class Happy extends BaseHelper {

    public Happy(String name) {
        super(name, 100);
    }

    public long getBrokenInstrument() {
        return getInstruments().stream().filter(Instrument::isBroken).count();
    }

}