
/**
 * Write a description of class Seat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Seat
{
    private boolean availablity;
    private int row;
    /**
     * Constructor for objects of class Seat
     */
    public Seat(int row)
    {
        availablity = true;
    }
    public boolean isFree()
    {
        return availablity;
    }
    public void booked()
    {
        availablity = false;
    }
    public int getRow()
    {
        return row;
    }
    
}
