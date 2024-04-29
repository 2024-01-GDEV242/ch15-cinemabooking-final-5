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
    private ArrayList<Schedule> schedules;
    //private ArrayList<Theater> theaters;
    private ArrayList<Customer> customers;
    private ArrayList<Booking> bookings;

    /**
     * Constructor for objects of class CinemaBookingSystem
     */
    public CinemaBookingSystem()
    {
        bookings = new ArrayList<>();
        customers = new ArrayList<>();
        schedules = new ArrayList<>();
        schedules.add(new Schedule());
        schedules.add(new Schedule());
        //theaters.add(new Theater());        
    }
    public void addCustomer(int phoneNumber)
    {
        customers.add(new Customer(phoneNumber));
    }
    public void createBooking(int customerIndex,int row,int col,int date)
    {
        if(schedules.get(date).getShow(0).getTheater().checkAvailablity(col,row)) //checks availibily of the seats
        {                               //get customer                  get the show                get the seats                                            get date    get the timeslot
            bookings.add(new Booking(customers.get(customerIndex),schedules.get(date).getShow(0),schedules.get(date).getShow(0).getTheater().getSeat(row,col),date,schedules.get(date).getShow(0).getShowTime()));
            schedules.get(date).getShow(0).getTheater().getSeat(row,col).booked(); // makes seat unavilible
        }
    }
}
