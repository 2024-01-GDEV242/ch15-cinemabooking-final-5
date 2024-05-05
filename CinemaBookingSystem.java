import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a description of class CinemaBookingSystem here.
 *
 * @authors Steven Coss &
 * @version 5.5.2024
 */
public class CinemaBookingSystem {
    private ArrayList<Schedule> schedules;
    private ArrayList<Theater> theaters;
    private ArrayList<Customer> customers;
    private ArrayList<Booking> bookings;
    private ArrayList<Movie> movies;

    /**
     * Constructor for objects of class CinemaBookingSystem initializes the booking system
     * with predefined theaters of different sizes and rows.
     */
    public CinemaBookingSystem() 
    {
        this.bookings = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.schedules = new ArrayList<>();
        this.theaters = new ArrayList<>();
        this.movies = new ArrayList<>();

        initializeTheaters();
        initializeMovies();
    }
    
    public static void main() {
        CinemaBookingSystem system = new CinemaBookingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Cinema Booking System");
            System.out.println("1. Add Customer");
            System.out.println("2. Show Schedule");
            System.out.println("3. Create Booking");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine(); // Changed to nextLine()
                    try {
                        system.addCustomer(name, phoneNumber);
                        System.out.println("Customer added.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2: 
                    
                
                case 3:
                    // Placeholder for booking creation
                    System.out.println("Booking creation not implemented.");
                    break;
                case 4:
                    // Placeholder for booking cancellation
                    System.out.println("Booking cancellation not implemented.");
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    
    private void initializeTheaters() 
    {
        theaters.add(new Theater(1, 40, 5));
        theaters.add(new Theater(2, 60, 6));
        theaters.add(new Theater(3, 70, 7));
        theaters.add(new Theater(4, 50, 5));
        theaters.add(new Theater(5, 90, 6));
    }

    private void initializeMovies() 
    {
        movies.add(new Movie("Challengers"));
        movies.add(new Movie("Unsung Hero"));
        movies.add(new Movie("Civil War"));
        movies.add(new Movie("Spy x Family Code: White"));
        movies.add(new Movie("Star Wars Episode I: The Phantom Menace"));
        movies.add(new Movie("Abigail"));
        movies.add(new Movie("Kung Fu Panda 4"));
        movies.add(new Movie("Godzilla x Kong: The New Empire"));
    }
    
    public void addCustomer(String name, String phoneNumber) {
        Customer customer = new Customer(name, phoneNumber);
        customers.add(customer);
    }

    public void createBooking(int customerIndex, int row, int col, LocalDate date, String showName, LocalTime startTime) 
    {
        Schedule schedule = findScheduleByDate(date);
        if (schedule == null) {
            System.out.println("No schedule available for this date.");
            return;
        }

        Show show = schedule.getShow(showName, startTime);
        if (show == null || show.getTheater() == null || !show.getTheater().checkAvailability(row, col)) {
            System.out.println("Seat not available or show does not exist.");
            return;
        }

        Seat seat = show.getTheater().getSeat(row, col);
        if (seat != null && seat.isAvailable()) {
            seat.setAvailable(false);
            Booking booking = new Booking(customers.get(customerIndex), show, seat, date);
            bookings.add(booking);
        }
    }

    public void createRowBooking(int customerIndex, int numberOfBookings, int row, int colStart, LocalDate date, String showName, LocalTime startTime) {
        for (int i = 0; i < numberOfBookings; i++) {
            createBooking(customerIndex, row, colStart + i, date, showName, startTime);
        }
    }

    public void cancelBooking(Customer customer) {
        bookings.removeIf(booking -> {
            if (booking.getTheCustomer().equals(customer)) {
                booking.getTheSeat().setAvailable(true);
                return true;
            }
            return false;
        });
    }
    
    private Schedule findScheduleByDate(LocalDate date) 
    {
       for (Schedule schedule : schedules) {
           if (schedule.getDate().equals(date)) { 
               return schedule;
           }
       }
       return null; // No schedule found for the given date
    }
}