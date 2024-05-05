import java.util.ArrayList;

/**
 * Write a description of class Theater here.
 *
 * @authors Steven Coss &
 * @version 5.5.2024
 */
public class Theater
{
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
        createSeats();
    }
    /**
     * makes seats in the theater
     */
    private void createSeats()
    {
        for (int x =0 ;x < row ; x++)
        {
            for (int y =0; y <col; y ++)
            {   
               seats.add(new Seat(x,y)); 
            }
        }
    }
    /**
     * checks if a specific seat is available to be booked or not
     * 
     * @param row the specific row of the seat to be tested
     * @param col the specific colum of the seat to be tested
     */
    public boolean checkAvailablity(int row, int col)
    {
        //test if seat is available
        boolean availability = false;
        for (int x=0; x< seats.size(); x++)
        {
            if (seats.get(x).getRow() == row && seats.get(x).getCol() == col)
            {
                availability = seats.get(x).getAvailability();
            }
        }
        return availability;
    }
    /**
     * returns a specific seat from its array of seats
     * 
     * @param row the specific row of the seat 
     * @param col the specific colum of the seat
     */
    public Seat getSeat(int row,int col)
    {
        Seat theSeat;
        for (int x=0; x< seats.size(); x++)
        {
            if (seats.get(x).getRow() == row && seats.get(x).getCol() == col)
            {
                theSeat = seats.get(x);
                return theSeat;
            }
        }
        return null;
    }
}
