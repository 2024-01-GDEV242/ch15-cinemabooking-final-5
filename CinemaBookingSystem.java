import java.util.ArrayList;

/**
 * Write a description of class CinemaBookingSystem here.
 *
 * @authors Steven Coss &
 * @version 5.5.2024
 */
public class CinemaBookingSystem
{
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
    /**
     * adds a Customer to the booking systems list of customers
     * 
     * @param customer  the customer to be added 
     */
    public void addCustomer(Customer customer)
    {
        customers.add(customer);
    }
    /**
     * Creates a booking for a customer and make the seat unavailable for future bookings
     * 
     * @param  customerIndex the customer at an index within the booking system that will be assigned to the bookings
     * @param  row the row that the seats will be in
     * @param  col the colum of the seat to be booked
     * @param  date the day of the showing which is the index of the schedules
     * @param  showName the name of the movie 
     * @param  startTime  the time of the movie
     */
    public void createBooking(int customerIndex,int row,int col,int date,String showName,int startTime)
    {
        if(schedules.get(date).getShow(showName,startTime).getTheater().checkAvailablity(col,row)) //checks availibily of the seats
        {                               //get customer                  get the show                                get the seats                                                               get date           
            bookings.add(new Booking(customers.get(customerIndex),schedules.get(date).getShow(showName,startTime),schedules.get(date).getShow(showName,startTime).getTheater().getSeat(row,col),date));
            schedules.get(date).getShow(showName,startTime).getTheater().getSeat(row,col).booked(); // makes seat unavilible
        }
    }
    /**
     * Creates a set of bookings starting from one seat and continuing for however many is requested assuming their is room
     *
     * @param  customerIndex the customer at an index within the booking system that will be assigned to the bookings
     * @param  numberOfBookings the number or requested seats
     * @param  row the row that the seats will be in
     * @param  colStart the first sit in the row that is to be booked
     * @param  date the day of the showing which is the index of the schedules
     * @param  showName the name of the movie 
     * @param  startTime  the time of the movie
     * 
     */
    public void createRowBooking(int customerIndex,int numberOfBookings,int row, int colStart,int date,String showName,int startTime)
    {
        for (int x = 0; x <numberOfBookings; x ++)
        {
            createBooking(customerIndex,row,colStart+x,date,showName,startTime);
        }
    }
    /**
     * Cancles all previously made bookings of a given customer
     *
     * @param  Customer is the customer who's canceling the bookings
     */
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
