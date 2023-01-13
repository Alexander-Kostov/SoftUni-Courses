package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GiftFactoryTests {

    private GiftFactory giftFactory;
    private Gift firstGift;
    private Gift secondGift;

    @Before
    public void setup() {
        giftFactory = new GiftFactory();
        firstGift = new Gift("White", 5);
        secondGift = new Gift("Black", 10);

        giftFactory.createGift(firstGift);
        giftFactory.createGift(secondGift);
    }

    @Test
    public void checkCount() {
        Assert.assertEquals(2,giftFactory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createExistingGift() {
        giftFactory.createGift(firstGift);
    }

    @Test(expected = NullPointerException.class)
    public void checkIfEmptyNameThrowsException() {
        giftFactory.removeGift(null);
    }

    @Test
    public void checkIfExistingGiftIsRemoved() {
        boolean deleted = giftFactory.removeGift("White");

        Assert.assertTrue(deleted);
    }

    @Test
    public void checkPresentWithLeastMagic() {
        Gift gift = giftFactory.getPresentWithLeastMagic();

        Assert.assertEquals(firstGift, gift);
    }

    @Test
    public void checkIfGetPresentIsIdentical() {
        Assert.assertEquals(firstGift, giftFactory.getPresent("White"));
    }
}
