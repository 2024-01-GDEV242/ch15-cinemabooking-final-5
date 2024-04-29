import java.util.ArrayList;

/**
 * Write a description of class Theater here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Theater
{
    // instance variables - replace the example below with your own
    private int row;
    private int col;
    private ArrayList<Seat> seats;
    //private ArrayList<Show> shows;

    /**
     * Constructor for objects of class Theater
     */
    public Theater(int row, int col)
    {
        seats = new ArrayList<>();
        this.row = row;
        this.col = col;
    }
    private void createSeats()
    {
        for (int x =0 ;x < row ; x++)
        {
            for (int y =0; y <col; y ++)
            {   
               seats.add(new Seat((row))); 
            }
        }
    }
    public boolean checkAvailablity(int row, int col)
    {
        //test if seat is available
        return true;
    }
    public Seat getSeat(int row,int col)
    {
        return seats.get(0);
    }
}
