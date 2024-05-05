

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CinemaBookingSystemTest.
 *
 * @authors Steven Coss &
 * @version 5.5.2024
 */
public class CinemaBookingSystemTest
{
    /**
     * Default constructor for test class CinemaBookingSystemTest
     */
    public CinemaBookingSystemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void CreatingBooking()
    {
        CinemaBookingSystem cinemaBo1 = new CinemaBookingSystem();
        Customer customer1 = new Customer(908, 5555555);
        cinemaBo1.addCustomer(customer1);
        cinemaBo1.createBooking(0, 1, 1, 0, "lotr", 12);
    }

    @Test
    public void create4Bookings()
    {
        CinemaBookingSystem cinemaBo1 = new CinemaBookingSystem();
        Customer customer1 = new Customer(908, 5555555);
        cinemaBo1.addCustomer(customer1);
        cinemaBo1.createRowBooking(4,0, 1, 1, 0, "lotr", 12);
    }

    @Test
    public void RemoveBooking()
    {
        CinemaBookingSystem cinemaBo1 = new CinemaBookingSystem();
        Customer customer1 = new Customer(1, 908);
        cinemaBo1.addCustomer(customer1);
        cinemaBo1.createBooking(0, 1, 1, 0, "lotr", 12);
        cinemaBo1.cancelBooking(customer1);
    }
}





