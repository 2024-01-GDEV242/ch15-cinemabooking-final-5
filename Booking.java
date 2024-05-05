
/**
 * Write a description of class Booking here.
 *
 * @authors Steven Coss &
 * @version 5.5.2024
 */
public class Booking
{
    /**
     * Constructor for objects of class Booking
     */
    private Seat theSeat;
    private Show theShow;
    private Customer theCustomer;
    private int theDate;
    private ShowTime theShowTime;

    public Booking(Customer customer,Show show,Seat seat,int date)
    {
        theCustomer = customer;
        theShow = show;
        theSeat = seat;
        theDate = date;
        theShowTime = show.getShowTime();
    }
    public Seat getTheSeat()
    {
        return theSeat;
    }
    public Customer getTheCustomer()
    {
        return theCustomer;
    }

}
