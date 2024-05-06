import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

/**
 * The Booking class represents a reservation made for a specific show, seat, and customer on a given date.
 * This class is essential for managing the reservations within a cinema booking system, ensuring that each
 * booking is linked to a specific customer, show, and seat.
 *
 * @authors Steven Coss & Fhaungfha Suvannakajorn
 * @version 5.5.2024
 */
public class Booking {
    private Customer customer;
    private Show show;
    private Seat seat;
    private Schedule schedule;
    
    /**
     * Constructor for objects of class Booking.
     * Initializes a booking with the specified customer, show, seat, and date.
     */
    public Booking(Customer customer, Show show, Seat seat, Schedule schedule) {
        this.customer = customer;
        this.show = show;
        this.seat = seat;
        this.schedule = schedule;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public Show getShow() {
        return show;
    }

    public Seat getSeat() {
        return seat;
    }

    public Schedule getSchedule() {
        return schedule;
    }
}