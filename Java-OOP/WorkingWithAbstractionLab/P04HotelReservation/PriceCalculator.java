package WorkingWithAbstractionLab.P04HotelReservation;

public class PriceCalculator {
    private double price;
    private int days;
    private Season season;
    private Discount discount;

    public PriceCalculator(double price, int days, Season season, Discount discount) {
        this.price = price;
        this.days = days;
        this.season = season;
        this.discount = discount;
    }

    public double calculatePrice (){
        return price * days * season.getMultiplier() * discount.getPriceReduction();
    }
}
