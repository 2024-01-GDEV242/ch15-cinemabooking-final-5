import java.util.ArrayList;

/**
 * Write a description of class CinemaBookingSystem here.
 *
 * @authors Steven Coss &
 * @version 5.5.2024
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
    public void addCustomer(Customer customer)
    {
        customers.add(customer);
    }
    public void createBooking(int customerIndex,int row,int col,int date,String showName,int startTime)
    {
        if(schedules.get(date).getShow(showName,startTime).getTheater().checkAvailablity(col,row)) //checks availibily of the seats
        {                               //get customer                  get the show                                get the seats                                                               get date           
            bookings.add(new Booking(customers.get(customerIndex),schedules.get(date).getShow(showName,startTime),schedules.get(date).getShow(showName,startTime).getTheater().getSeat(row,col),date));
            schedules.get(date).getShow(showName,startTime).getTheater().getSeat(row,col).booked(); // makes seat unavilible
        }
    }
    public void createRowBooking(int customerIndex,int numberOfBookings,int row, int colStart,int date,String showName,int startTime)
    {
        for (int x = 0; x <numberOfBookings; x ++)
        {
            createBooking(customerIndex,row,colStart+x,date,showName,startTime);
        }
    }
    public void cancelBooking(Customer customer)
    {
        for (int x =0; x < bookings.size(); x++)
        {
            if(customer == bookings.get(x).getTheCustomer())
            {
                bookings.get(x).getTheSeat().unBooked();
                bookings.remove(x);
            }
        }
    }
        
}
