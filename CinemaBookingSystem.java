import java.util.ArrayList;

/**
 * Write a description of class CinemaBookingSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CinemaBookingSystem
{
    // instance variables - replace the example below with your own
    private ArrayList<Theater> theaters;
    private Customer testCustomer;

    /**
     * Constructor for objects of class CinemaBookingSystem
     */
    public CinemaBookingSystem()
    {
        theaters = new ArrayList<>();
        testCustomer = new Customer();
        theaters.add(new Theater());        
    }
}
