
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
    public boolean getAvailability()
    {
        return availability;
    }
    public void booked()
    {
        availability = false;
    }
    public void unBooked()
    {
        availability = true;
    }
    public int getRow()
    {
        return row;
    }
    public int getCol()
    {
        return col;
    }
    
}
