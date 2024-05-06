/**
 * The Seat class manages seat bookings and availability in a theater with precise control over individual seat states. 
 * Each seat has a unique number and availability status indicating whether it is booked or available.
 *
 * @authors Steven Coss & Matt Romond & Fhaungfha Suvannakajorn 
 * @version 5.5.2024
 */
public class Seat
{
    private int seatNumber;
    private int row;
    private boolean available;
    
    /**
     * Constructor for objects of class Seat
     */
    public Seat(int seatNumber, int row, boolean available) {
        this.seatNumber = seatNumber;
        this.row = row;
        this.available = available;
    }

    /**
     * Retrieves the seat number of this seat.
     *
     * @return the seat number
     */
    public int getSeatNumber() {
        return seatNumber;
    }

    /**
     * Retrieves the row number where this seat is located.
     *
     * @return the row number
     */
    public int getRow() {
        return row;
    }

    /**
     * Checks if the seat is available for booking.
     *
     * @return true if the seat is available, false otherwise
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets the availability of this seat. This method is typically used to update the seat's
     * availability status during booking or cancellation processes.
     *
     * @param available true to make the seat available, false to mark it as booked
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }
}