import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Seat here.
 *
 * @author Fhaungfha Suvannakajorn
 * @version (a version number or a date)
 */
public class Seat
{
    private int seatNumber;
    private int row;
    private boolean available;
    
    public Seat(int seatNumber, int row, boolean available) {
        this.seatNumber = seatNumber;
        this.row = row;
        this.available = available;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public int getRow() {
        return row;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Theater {
    private int theaterId;
    private List<Seat> seats;

    public Theater(int theaterId, int numberOfSeats, int rows) {
        this.theaterId = theaterId;
        this.seats = new ArrayList<>();
        int seatsPerRow = numberOfSeats / rows;
        for (int row = 1; row <= rows; row++) {
            for (int seat = 1; seat <= seatsPerRow; seat++) {
                seats.add(new Seat(seat, row, true)); // Initially, all seats are available
            }
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Seat getSeat(int row, int seatNumber) {
        for (Seat seat : seats) {
            if (seat.getRow() == row && seat.getSeatNumber() == seatNumber) {
                return seat;
            }
        }
        return null;
    }

    public void bookSeat(int row, int seatNumber) {
        Seat seat = getSeat(row, seatNumber);
        if (seat != null && seat.isAvailable()) {
            seat.setAvailable(false);
            System.out.println("Seat " + seatNumber + " in row " + row + " is now booked.");
        } else {
            System.out.println("Seat " + seatNumber + " in row " + row + " is not available.");
        }
    }

    public void cancelBooking(int row, int seatNumber) {
        Seat seat = getSeat(row, seatNumber);
        if (seat != null && !seat.isAvailable()) {
            seat.setAvailable(true);
            System.out.println("Booking for seat " + seatNumber + " in row " + row + " has been cancelled.");
        } else {
            System.out.println("No booking found for seat " + seatNumber + " in row " + row + ".");
        }
    }
}
