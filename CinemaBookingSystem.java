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
        this.theaters = initializeTheaters();
        this.movies = new ArrayList<>();
        
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
                   System.out.print("Enter day to view schedule (Saturday or Sunday) or 'all' for all dates: ");
                    String input = scanner.nextLine().trim();
                    if ("all".equalsIgnoreCase(input)) {
                        system.showAllSchedules();
                    } else {
                        system.displaySchedulesByDay(input);
                    }
                    break;
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
    
    private ArrayList<Theater> initializeTheaters() 
    {
        ArrayList<Theater> theaters = new ArrayList<>();
        theaters.add(new Theater(1, 40, 5));
        theaters.add(new Theater(2, 60, 6));
        theaters.add(new Theater(3, 70, 7));
        theaters.add(new Theater(4, 50, 5));
        theaters.add(new Theater(5, 90, 6));
        return theaters; // Return the list of initialized theaters
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
    
    private void createSchedules() 
    {
        ArrayList<Theater> theaters = initializeTheaters(); // Make sure theaters are initialized
        Schedule saturdaySchedule = new Schedule(theaters, "Saturday");
    
        // Add shows to Saturday schedule
        saturdaySchedule.addShow("Abigail", new ShowTime(11, 30, 12, 30), theaters.get(0));
        saturdaySchedule.addShow("Abigail", new ShowTime(18, 00, 19, 00), theaters.get(4));
        saturdaySchedule.addShow("Abigail", new ShowTime(20, 30, 21, 30), theaters.get(0));

        saturdaySchedule.addShow("Challengers", new ShowTime(9, 00, 10, 00), theaters.get(0));
        saturdaySchedule.addShow("Challengers", new ShowTime(14, 00, 15, 00), theaters.get(4));
        saturdaySchedule.addShow("Challengers", new ShowTime(16, 30, 17, 30), theaters.get(2));
        saturdaySchedule.addShow("Challengers", new ShowTime(20, 30, 21, 30), theaters.get(2));

        saturdaySchedule.addShow("Civil War", new ShowTime(9, 00, 10, 00), theaters.get(2));
        saturdaySchedule.addShow("Civil War", new ShowTime(11, 30, 12, 30), theaters.get(1));
        saturdaySchedule.addShow("Civil War", new ShowTime(14, 00, 15, 00), theaters.get(2));
        saturdaySchedule.addShow("Civil War", new ShowTime(16, 30, 17, 30), theaters.get(4));
        saturdaySchedule.addShow("Civil War", new ShowTime(18, 00, 19, 00), theaters.get(1));

        saturdaySchedule.addShow("Godzilla x Kong: The New Empire", new ShowTime(11, 30, 12, 30), theaters.get(3));
        saturdaySchedule.addShow("Godzilla x Kong: The New Empire", new ShowTime(14, 00, 15, 00), theaters.get(0));
        saturdaySchedule.addShow("Godzilla x Kong: The New Empire", new ShowTime(20, 30, 21, 30), theaters.get(1));

        saturdaySchedule.addShow("Kung Fu Panda 4", new ShowTime(11, 30, 12, 30), theaters.get(2));
        saturdaySchedule.addShow("Kung Fu Panda 4", new ShowTime(16, 30, 17, 30), theaters.get(0));
        saturdaySchedule.addShow("Kung Fu Panda 4", new ShowTime(18, 00, 19, 00), theaters.get(0));

        saturdaySchedule.addShow("Spy x Family Code: White", new ShowTime(9, 00, 10, 00), theaters.get(3));
        saturdaySchedule.addShow("Spy x Family Code: White", new ShowTime(11, 30, 12, 30), theaters.get(4));
        saturdaySchedule.addShow("Spy x Family Code: White", new ShowTime(14, 00, 15, 00), theaters.get(3));
        saturdaySchedule.addShow("Spy x Family Code: White", new ShowTime(16, 30, 17, 30), theaters.get(1));
        saturdaySchedule.addShow("Spy x Family Code: White", new ShowTime(18, 00, 19, 00), theaters.get(2));

        saturdaySchedule.addShow("Star Wars Episode I: The Phantom Menace", new ShowTime(9, 00, 10, 00), theaters.get(4));
        saturdaySchedule.addShow("Star Wars Episode I: The Phantom Menace", new ShowTime(16, 30, 17, 30), theaters.get(3));
        saturdaySchedule.addShow("Star Wars Episode I: The Phantom Menace", new ShowTime(20, 30, 21, 30), theaters.get(4));

        saturdaySchedule.addShow("Unsung Hero", new ShowTime(9, 00, 10, 00), theaters.get(1));
        saturdaySchedule.addShow("Unsung Hero", new ShowTime(14, 00, 15, 00), theaters.get(1));
        saturdaySchedule.addShow("Unsung Hero", new ShowTime(20, 30, 21, 30), theaters.get(3));

        schedules.add(saturdaySchedule);
        
        Schedule sundaySchedule = new Schedule(theaters, "Sunday");

        // Add shows to Sunday schedule
        sundaySchedule.addShow("Abigail", new ShowTime(9, 00, 10, 00), theaters.get(4));
        sundaySchedule.addShow("Abigail", new ShowTime(11, 30, 12, 30), theaters.get(2));
        sundaySchedule.addShow("Abigail", new ShowTime(18, 00, 19, 00), theaters.get(4));
        sundaySchedule.addShow("Abigail", new ShowTime(20, 30, 21, 30), theaters.get(2));
    
        sundaySchedule.addShow("Challengers", new ShowTime(9, 00, 10, 00), theaters.get(1));
        sundaySchedule.addShow("Challengers", new ShowTime(16, 30, 17, 30), theaters.get(2));
        sundaySchedule.addShow("Challengers", new ShowTime(18, 00, 19, 00), theaters.get(2));
    
        sundaySchedule.addShow("Civil War", new ShowTime(9, 00, 10, 00), theaters.get(0));
        sundaySchedule.addShow("Civil War", new ShowTime(11, 30, 12, 30), theaters.get(3));
        sundaySchedule.addShow("Civil War", new ShowTime(14, 00, 15, 00), theaters.get(0));
        sundaySchedule.addShow("Civil War", new ShowTime(16, 30, 17, 30), theaters.get(4));
        sundaySchedule.addShow("Civil War", new ShowTime(18, 00, 19, 00), theaters.get(3));
    
        sundaySchedule.addShow("Godzilla x Kong: The New Empire", new ShowTime(14, 00, 15, 00), theaters.get(2));
        sundaySchedule.addShow("Godzilla x Kong: The New Empire", new ShowTime(16, 30, 17, 30), theaters.get(1));
        sundaySchedule.addShow("Godzilla x Kong: The New Empire", new ShowTime(20, 30, 21, 30), theaters.get(0));
    
        sundaySchedule.addShow("Kung Fu Panda 4", new ShowTime(11, 30, 12, 30), theaters.get(0));
        sundaySchedule.addShow("Kung Fu Panda 4", new ShowTime(14, 00, 15, 00), theaters.get(4));
        sundaySchedule.addShow("Kung Fu Panda 4", new ShowTime(16, 30, 17, 30), theaters.get(3));
        sundaySchedule.addShow("Kung Fu Panda 4", new ShowTime(18, 00, 19, 00), theaters.get(1));
    
        sundaySchedule.addShow("Spy x Family Code: White", new ShowTime(9, 00, 10, 00), theaters.get(2));
        sundaySchedule.addShow("Spy x Family Code: White", new ShowTime(11, 30, 12, 30), theaters.get(1));
        sundaySchedule.addShow("Spy x Family Code: White", new ShowTime(14, 00, 15, 00), theaters.get(1));
        sundaySchedule.addShow("Spy x Family Code: White", new ShowTime(18, 00, 19, 00), theaters.get(0));
    
        sundaySchedule.addShow("Star Wars Episode I: The Phantom Menace", new ShowTime(11, 30, 12, 30), theaters.get(4));
        sundaySchedule.addShow("Star Wars Episode I: The Phantom Menace", new ShowTime(16, 30, 17, 30), theaters.get(0));
        sundaySchedule.addShow("Star Wars Episode I: The Phantom Menace", new ShowTime(20, 30, 21, 30), theaters.get(4));
    
        sundaySchedule.addShow("Unsung Hero", new ShowTime(9, 00, 10, 00), theaters.get(3));
        sundaySchedule.addShow("Unsung Hero", new ShowTime(14, 00, 15, 00), theaters.get(3));
        sundaySchedule.addShow("Unsung Hero", new ShowTime(20, 30, 21, 30), theaters.get(3));
    
        schedules.add(sundaySchedule);
    }
        
    public void addCustomer(String name, String phoneNumber) 
    {
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

    public void showAllSchedules() 
    {
        if (schedules.isEmpty()) {
            System.out.println("No schedules available.");
        } else {
            System.out.println("All Available Schedules:");
            for (Schedule schedule : schedules) {
                displaySchedule(schedule);
            }
        }
    }

    private void displaySchedule(Schedule schedule) 
    {
        System.out.println("\nSchedule for " + schedule.getDate() + ":");
        ArrayList<Show> shows = schedule.getShows();
        if (shows.isEmpty()) {
            System.out.println("No shows available on this date.");
        } else {
            for (Show show : shows) {
                String time = show.getShowTime().getStartTime().toString();
                String movieName = show.getMovieName();
                String theaterInfo = "Theater " + show.getTheater().getId();
                System.out.println(movieName + " at " + time + " in " + theaterInfo);
            }
        }
    }
    
    public void displaySchedulesByDay(String dayName) 
    {
        boolean found = false;
        dayName = dayName.trim().toUpperCase();  // Normalize the day name to uppercase for comparison

        for (Schedule schedule : schedules) {
            String scheduleDay = getDayOfWeekAsString(schedule.getDate());
            if (scheduleDay.equals(dayName)) {
                displaySchedule(schedule);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No schedules found for " + dayName);
        }
    }

    private String getDayShow(LocalDate date) 
    {
        switch (date.getDayOfWeek()) {
            case MONDAY:
                return "MONDAY";
            case TUESDAY:
                return "TUESDAY";
            case WEDNESDAY:
                return "WEDNESDAY";
            case THURSDAY:
                return "THURSDAY";
            case FRIDAY:
                return "FRIDAY";
            case SATURDAY:
                return "SATURDAY";
            case SUNDAY:
                return "SUNDAY";
            default:
                return "";
        }
    }
}