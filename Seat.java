
/**
 * Write a description of class Seat here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
