package semifinal;

import java.util.ArrayList;

/**
 * RideManager - keeps every booked ride in ONE list of type Ride.
 * RULE: this file must never name a child class of Ride.
 * It only talks to the abstraction (Ride and StudentDiscount).
 */
public class RideManager {
    // GIVEN: one list that can hold ANY kind of ride (upcasting)
    private final ArrayList<Ride> rides = new ArrayList<>();

    // GIVEN
    public void addRide(Ride ride) {
        rides.add(ride);
    }

    // GIVEN: search by passenger name (not case-sensitive)
    public Ride findRide(String passenger) {
        for (Ride r : rides) {
            if (r.getPassenger().equalsIgnoreCase(passenger)) {
                return r;
            }
        }
        return null;
    }

    // TODO 8 (8 pts): Print every ticket.
    // Use a for-each loop over rides: for (Ride r : rides)
    // and call r.printTicket() - no if/else, no type checking.
    public void showAllTickets() {
        for (Ride r : rides) {
            r.printTicket();
        }
    }

    // TODO 9 (10 pts): Print student discounts ONLY for rides that
    // implement StudentDiscount.
    // For each Ride r in rides:
    // 1. if (r instanceof StudentDiscount)
    // 2. print "   " + r.getPassenger() + " (" + r.vehicle() + ")"
    // 3. downcast: StudentDiscount s = (StudentDiscount) r;
    // 4. call s.printDiscount();
    public void showStudentDiscounts() {
        for (Ride r : rides) {
            if (r instanceof StudentDiscount) {
                System.out.println("   " + r.getPassenger() + " (" + r.vehicle() + ")");
                StudentDiscount s = (StudentDiscount) r;
                s.printDiscount();
            }
        }
    }

    // TODO 10 (7 pts): Return the total of all fares.
    // Start with double total = 0; add r.fare() for every ride,
    // then return total.
    public double totalSales() {
        double total = 0;
        for (Ride r : rides) {
            total += r.fare();
        }
        return total;
    }

    // GIVEN
    public int count() {
        return rides.size();
    }
}