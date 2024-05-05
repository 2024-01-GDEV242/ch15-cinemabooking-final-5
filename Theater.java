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
    private ArrayList<Show> shows;

    /**
     * Constructor for objects of class Theater
     */
    public Theater(int theaterId, int numberOfSeats, int rows) 
    {
        this.theaterId = theaterId;
        this.seats = new ArrayList<>();
        this.shows = new ArrayList<>();
        
        int seatsPerRow = numberOfSeats / rows;
        for (int row = 1; row <= rows; row++) {
            for (int seat = 1; seat <= seatsPerRow; seat++) {
                seats.add(new Seat(seat, row, true)); // Initially, all seats are available
            }
        }
    }

    public Seat getSeat(int row, int seatNumber) {
        return seats.stream().filter(s -> s.getRow() == row && s.getSeatNumber() == seatNumber).findFirst().orElse(null);
    }

    public boolean checkAvailability(int row, int seatNumber) {
        Seat seat = getSeat(row, seatNumber);
        return seat != null && seat.isAvailable();
    }

    public void addShow(Show show) {
        shows.add(show);
    }
    
    public int getId() {
        return theaterId;
    }
}