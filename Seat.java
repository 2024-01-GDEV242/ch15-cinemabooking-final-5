
/**
 * Write a description of class Seat here.
 *
 * @authors Steven Coss &
 * @version 5.5.2024
 */
public class Seat
{
    private boolean availability;
    private int row;
    private int col;
    /**
     * Constructor for objects of class Seat
     */
    public Seat(int row, int col)
    {
        this.row = row;
        this.col = col;
        availability = true;
    }
    /**
     * tells if the seat is available or not
     */
    public boolean getAvailability()
    {
        return availability;
    }
    /**
     * Marks the seat as booked
     */
    public void booked()
    {
        availability = false;
    }
    /**
     * make it so the seat is available again
     */
    public void unBooked()
    {
        availability = true;
    }
    /**
     * gets the row of this seat in its theater
     */
    public int getRow()
    {
        return row;
    }
    /**
     * gets the col of this seat in its theater
     */
    public int getCol()
    {
        return col;
    }
    
}
