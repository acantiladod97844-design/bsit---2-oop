package semifinal;

/**
 * Taxi - a child of Ride with NO student discount.
 *
 * Fare: PHP 45.00 flag-down, plus PHP 13.50 per km.
 */
// TODO 6 (3 pts): Complete the class header so Taxi EXTENDS Ride.
// Taxi must NOT implement StudentDiscount.
public class Taxi extends Ride {

    // GIVEN: constructor
    public Taxi(String passenger, double km) {
        super(passenger, km);
    }

    // TODO 7 (5 pts): Override TWO methods. Put @Override above each.
    // a) fare() - return 45.00 + getKm() * 13.50
    // b) vehicle() - return "Taxi"
    @Override
    public double fare() {
        return 45.00 + getKm() * 13.50;
    }

    @Override
    public String vehicle() {
        return "Taxi";
    }
}