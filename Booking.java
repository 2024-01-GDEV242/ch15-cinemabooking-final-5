import java.time.LocalDate;

/**
 * The Booking class represents a reservation made for a specific show, seat, and customer on a given date.
 * This class is essential for managing the reservations within a cinema booking system, ensuring that each
 * booking is linked to a specific customer, show, and seat.
 *
 * @authors Steven Coss & Fhaungfha Suvannakajorn
 * @version 5.5.2024
 */
public class Booking {
    private Seat theSeat;
    private Show theShow;
    private Customer theCustomer;
    private LocalDate theDate; // Changed type from int to LocalDate for accurate date management.
    
    /**
     * Constructor for objects of class Booking.
     * Initializes a booking with the specified customer, show, seat, and date.
     * 
     * @param customer The customer who made the booking.
     * @param show The show for which the booking is made.
     * @param seat The seat reserved for this booking.
     * @param date The date of the show for which the booking is made, provided as a LocalDate.
     */
    public Booking(Customer customer, Show show, Seat seat, LocalDate date) {
        this.theCustomer = customer;
        this.theShow = show;
        this.theSeat = seat;
        this.theDate = date;
    }
    
    /**
     * Returns the seat associated with this booking.
     * 
     * @return the reserved Seat object.
     */
    public Seat getTheSeat() {
        return theSeat;
    }
    
    /**
     * Returns the customer who made the booking.
     * 
     * @return the Customer object associated with this booking.
     */
    public Customer getTheCustomer() {
        return theCustomer;
    }

    /**
     * Returns the show associated with this booking.
     * 
     * @return the Show object for which the booking was made.
     */
    public Show getTheShow() {
        return theShow;
    }

    /**
     * Returns the date of the booking.
     * 
     * @return the LocalDate representing the date of the show.
     */
    public LocalDate getTheDate() {
        return theDate;
    }
}
