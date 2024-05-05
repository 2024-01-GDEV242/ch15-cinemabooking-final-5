import java.util.ArrayList;
import java.util.List;

/**
 * The Theater class manages seating arrangements in a theater, enabling seat bookings and availability checks. 
 * It is a core component of the cinema booking system, providing efficient control over individual theater seating configurations.
 *
 * @author Fhaungfha Suvannakajorn
 * @version (a version number or a date)
 */
public class Theater
{
    private int theaterId;
    private List<Seat> seats;

    /**
     * Constructor for objects of class Theater
     */
    public Theater(int theaterId, int numberOfSeats, int rows) 
    {
        this.theaterId = theaterId;
        this.seats = new ArrayList<>();
        int seatsPerRow = numberOfSeats / rows;
        for (int row = 1; row <= rows; row++) {
            for (int seat = 1; seat <= seatsPerRow; seat++) {
                seats.add(new Seat(seat, row, true)); // Initially, all seats are available
            }
        }
    }

    /**
     * This method retrieves a list of all seats in the theater and is useful for operations like displaying a seating chart 
     * that requires information about the entire seating configuration.
     * 
     * @return A list of Seat objects representing all the seats in the theater.
     */
    public List<Seat> getSeats() 
    {
        return seats;
    }

    /**
     * This method retrieves a list of all seats in the theater and allows you to retrieve a specific seat based on its row and seat number. 
     * It is useful for displaying a seating chart and for operations like booking or checking availability.
     * 
     * @param row The row number of the seat.
     * @param seatNumber The seat number within the specified row.
     * @return The Seat object if found, or null if no seat matches the specified location.
     */
    public Seat getSeat(int row, int seatNumber) 
    {
        for (Seat seat : seats) {
            if (seat.getRow() == row && seat.getSeatNumber() == seatNumber) {
                return seat;
            }
        }
        return null;
    }

    /**
     * This method reserves a seat in the theater. If the seat is available, 
     * it will be marked as booked, otherwise, an error message will be displayed.
     * 
     * @param row The row number of the seat to book.
     * @param seatNumber The seat number to book.
     */
    public void bookSeat(int row, int seatNumber) 
    {
        Seat seat = getSeat(row, seatNumber);
        if (seat != null && seat.isAvailable()) {
            seat.setAvailable(false);
            System.out.println("Seat " + seatNumber + " in row " + row + " is now booked.");
        } else {
            System.out.println("Seat " + seatNumber + " in row " + row + " is not available.");
        }
    }

    /**
     * This method Cancels a booking for a seat if it is currently booked. If the seat is not booked, an error message is displayed.
     * 
     * @param row The row number of the seat for which the booking is to be cancelled.
     * @param seatNumber The seat number of the booking to cancel.
     */
    public void cancelBooking(int row, int seatNumber) 
    {
        Seat seat = getSeat(row, seatNumber);
        if (seat != null && !seat.isAvailable()) {
            seat.setAvailable(true);
            System.out.println("Booking for seat " + seatNumber + " in row " + row + " has been cancelled.");
        } else {
            System.out.println("No booking found for seat " + seatNumber + " in row " + row + ".");
        }
    }
}