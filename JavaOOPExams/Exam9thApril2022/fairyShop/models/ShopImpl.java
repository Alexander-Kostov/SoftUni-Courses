package fairyShop.models;

public class ShopImpl implements Shop{

    public void craft(Present present, Helper helper) {
        if (helper.canWork()) {
            for (Instrument instrument : helper.getInstruments()) {
                while (!instrument.isBroken()) {
                    if (!instrument.isBroken() && helper.canWork()) {
                        present.getCrafted();
                        helper.work();
                        instrument.use();
                    }
                    if (present.isDone()) {
                        return;
                    }
                    if (!helper.canWork()) {
                        return;
                    }
                }
            }
        }
    }

//@Override
//public void craft(Present present, Helper helper) {
//    if(!helper.canWork()) return;
//
//    Instrument instrument = helper.getInstruments().stream().filter(s -> !s.isBroken()).findFirst().orElse(null);
//    if(instrument == null) return;
//
//    helper.work();
//    instrument.use();
//    present.getCrafted();
//
//    if(!present.isDone()) {
//        craft(present, helper);
//    }
}

