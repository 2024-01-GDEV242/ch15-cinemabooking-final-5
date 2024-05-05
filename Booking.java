
/**
 * Write a description of class Booking here.
 *
 * @authors Steven Coss &
 * @version 5.5.2024
 */
public class Booking
{
    private Seat theSeat;
    private Show theShow;
    private Customer theCustomer;
    private int theDate;
    private ShowTime theShowTime;
    /**
     * Constructor for objects of class Booking
     */

    public Booking(Customer customer,Show show,Seat seat,int date)
    {
        theCustomer = customer;
        theShow = show;
        theSeat = seat;
        theDate = date;
        theShowTime = show.getShowTime();
    }
    /**
     * Returns the seat of a booking
     */
    public Seat getTheSeat()
    {
        return theSeat;
    }
    /**
     * Returns the customer of a booking
     */
    public Customer getTheCustomer()
    {
        return theCustomer;
    }

}
