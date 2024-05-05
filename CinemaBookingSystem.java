import java.util.ArrayList;
import java.util.List;

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
    
    private List<Theater> theaters;

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
        
        this.theaters = new ArrayList<>();
        // Create theaters with different numbers of seats and rows
        theaters.add(new Theater(1, 40, 5)); // Theater 1 with 40 seats, 5 rows
        theaters.add(new Theater(2, 60, 6)); // Theater 2 with 60 seats, 6 rows
        theaters.add(new Theater(3, 70, 7)); // Theater 3 with 70 seats, 7 rows
        theaters.add(new Theater(4, 50, 5)); // Theater 4 with 50 seats, 5 rows
        theaters.add(new Theater(5, 90, 6)); // Theater 5 with 90 seats, 6 rows
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
