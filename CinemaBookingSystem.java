import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Write a description of class CinemaBookingSystem here.
 *
 * @authors Steven Coss & Matt Romond & Fhaungfha Suvannakajorn 
 * @version 5.5.2024
 */
public class CinemaBookingSystem {
    private ArrayList<Schedule> schedules;
    private ArrayList<Theater> theaters;
    private ArrayList<Customer> customers;
    private ArrayList<Booking> bookings;
    private ArrayList<Movie> movies;
    private List<Seat> seats;

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
        this.seats = new ArrayList<>();
        
        initializeMovies();
        createSchedules();
    }
    
    public static void main() {
        CinemaBookingSystem system = new CinemaBookingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Cinema Booking System");
            System.out.println("     1. Add Customer");
            System.out.println("     2. Customer List");
            System.out.println("     3. Show Schedule");
            System.out.println("     4. Create Booking");
            System.out.println("     5. Cancel Booking");
            System.out.println("     6. Exit");
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
                    system.displayCustomers();
                    break;
                case 3: 
                    System.out.print("Enter day to view schedule (Saturday or Sunday) or 'all' for all dates: ");
                    String input = scanner.nextLine().trim();
                    if ("all".equalsIgnoreCase(input)) {
                        system.showAllSchedules();
                    } else if ("Saturday".equalsIgnoreCase(input) || "Sunday".equalsIgnoreCase(input)) {
                        system.displaySchedulesByDay(input);
                    } else {
                        System.out.println("Invalid input. Please enter either 'Saturday', 'Sunday', or 'all'.");
                    }
                    break;
                case 4:
                    handleBooking(system, scanner);
                    break;
                case 5:
                    system.cancelBooking(scanner);
                    break;
                case 6:
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
    
    public void displayCustomers() 
    {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("List of Customers:");
            for (int i = 0; i < customers.size(); i++) {
                Customer customer = customers.get(i);
                System.out.println("Customer " + (i + 1) + ":");
                System.out.println("Name: " + customer.getName());
                System.out.println("Phone Number: " + customer.getPhoneNumber());
                System.out.println("------------------------");
            }
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

    public void displaySchedule(Schedule schedule) 
    {
        System.out.println("\n" + schedule.getDay() + " Schedule");
        ArrayList<Show> shows = schedule.getShows();
        if (shows.isEmpty()) {
            System.out.println("No shows available on this date.");
        } else {
            
            Map<String, List<Show>> showsByMovie = new HashMap<>();
            for (Show show : shows) {
                String movieName = show.getMovieName();
                if (!showsByMovie.containsKey(movieName)) {
                    showsByMovie.put(movieName, new ArrayList<>());
                }
                showsByMovie.get(movieName).add(show);
            }
    
            
            for (String movieName : showsByMovie.keySet()) {
                System.out.println(movieName);
                List<Show> movieShows = showsByMovie.get(movieName);
                StringBuilder showInfo = new StringBuilder();
                for (Show show : movieShows) {
                    String time = show.getShowTime().toString();
                    String theaterInfo = "Theater" + show.getTheater().getId();
                    showInfo.append("     | ").append(time).append(" ").append(theaterInfo).append(" | \n");
                }
                
                if (showInfo.length() > 0) {
                    showInfo.delete(showInfo.length() - 2, showInfo.length());
                    System.out.println(showInfo);
                }
            }
        }
    }

    public void displaySchedulesByDay(String dayName) {
        boolean found = false;
        dayName = dayName.trim().toUpperCase();  
    
        for (Schedule schedule : schedules) {
            String scheduleDay = schedule.getDay().toUpperCase();
            if (scheduleDay.equals(dayName)) {
                displaySchedule(schedule);
                found = true;
                break; 
            }
        }
    
        if (!found) {
            System.out.println("No schedules found for " + dayName);
        }
    }
    
    private Schedule getScheduleByDay(String day) 
    {
        for (Schedule schedule : schedules) {
            if (schedule.getDay().equalsIgnoreCase(day)) {
                return schedule; 
            }
        }
        return null;
    }
      

    
    private static void handleBooking(CinemaBookingSystem system, Scanner scanner) {
        System.out.println("Creating Booking...");
        System.out.println("Select booking type:");
        System.out.println("     1. Single Seat Booking");
        System.out.println("     2. Row Booking");
        System.out.print("Enter your choice: ");
        int bookingType = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (bookingType == 1) {
            system.createBooking(scanner);
        } else if (bookingType == 2) {
            system.createRowBooking(scanner);
        } else {
            System.out.println("Invalid choice.");
        }
    }
    
    private void createBooking(Scanner scanner) {
        System.out.print("Enter customer number: ");
        int customerIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        System.out.print("Enter day (Saturday or Sunday): ");
        String day = scanner.nextLine();
        System.out.print("Enter show name: ");
        String showName = scanner.nextLine();
        System.out.print("Enter start time (HH:mm): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter row: ");
        int row = scanner.nextInt();
        System.out.print("Enter seat number: ");
        int seatNumber = scanner.nextInt();

        if (!isValidDay(day)) {
            System.out.println("Invalid day. Please enter a valid day (Saturday or Sunday).");
            return;
        }

        Schedule schedule = getScheduleByDay(day);
        if (schedule == null) {
            System.out.println("No schedule found for " + day + ".");
            return;
        }

        LocalTime bookingStartTime = parseStartTime(startTime);
        if (bookingStartTime == null) {
            System.out.println("Invalid start time format: " + startTime);
            return;
        }

        Show show = schedule.getShow(showName, bookingStartTime);
        if (show == null) {
            System.out.println("Show not found on " + day + " at " + startTime + ".");
            return;
        }
    
        Theater theater = show.getTheater();
 
        if (customerIndex < 0 || customerIndex >= customers.size()) {
            System.out.println("Invalid customer index.");
            return;
        }

        if (!isValidSeat(theater, row, seatNumber)) {
            System.out.println("Invalid row or seat number.");
            return;
        }
 
        Seat seat = theater.getSeat(row, seatNumber);
        if (!seat.isAvailable()) {
            System.out.println("Seat not available for booking.");
            return;
        }
    
        // Proceed with booking
        Customer customer = customers.get(customerIndex);
        Booking booking = new Booking(customer, show, seat, schedule);
        bookings.add(booking);
        seat.setAvailable(false);
    
        // Print booking information
        System.out.println("==================================\n");
        System.out.println("Booking Information:");
        System.out.println("Customer: " + customer.getName() + ", " + customer.getPhoneNumber());
        System.out.println("Show: " + showName);
        System.out.println("Day: " + schedule.getDay());
        System.out.println("Theater: " + theater.getId());
        System.out.println("Seat: Row " + row + ", Seat Number " + seatNumber);
        System.out.println("\n==================================");
    }

    private void createRowBooking(Scanner scanner) 
    {
        System.out.print("Enter customer number: ");
        int customerIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter day (Saturday or Sunday): ");
        String day = scanner.nextLine();
        
        System.out.print("Enter show name: ");
        String showName = scanner.nextLine();
        
        System.out.print("Enter start time (HH:mm): ");
        String startTime = scanner.nextLine();
        LocalTime parsedStartTime = parseStartTime(startTime);
        if (parsedStartTime == null) {
            System.out.println("Invalid start time format.");
            return;
        }
    
        System.out.print("Enter row: ");
        int row = scanner.nextInt();
        
        System.out.print("Enter start seat number in the row: "); 
        int startSeatNumber = scanner.nextInt();
    
        System.out.print("Enter number of seats in the row: ");
        int numberOfSeats = scanner.nextInt();
    
        if (customerIndex < 0 || customerIndex >= customers.size()) {
            System.out.println("Invalid customer index.");
            return;
        }
    
        Schedule schedule = getScheduleByDay(day);
        if (schedule == null) {
            System.out.println("No schedule found for " + day + ".");
            return;
        }
        
        Show show = schedule.getShow(showName, parsedStartTime);
        if (show == null) {
            System.out.println("Show not found on " + day + " at " + startTime + ".");
            return;
        }
        
        Theater theater = show.getTheater();
        boolean seatsAvailable = true;
        for (int i = 0; i < numberOfSeats; i++) {
            if (!theater.checkAvailability(row, startSeatNumber + i)) {
                seatsAvailable = false;
                System.out.println("Seat " + (startSeatNumber + i) + " is not available.");
                break;
            }
        }
        
        if (!seatsAvailable) {
            System.out.println("Not all requested seats are available.");
            return;
        }
        
        // Booking is valid, proceed with creating bookings for each seat in the row
        for (int i = 0; i < numberOfSeats; i++) {
            Seat seat = theater.getSeat(row, startSeatNumber + i);
            Booking booking = new Booking(customers.get(customerIndex), show, seat, schedule);
            bookings.add(booking);
            seat.setAvailable(false); // Update seat availability
        }
    
        // Print booking information
        System.out.println("==================================\n");
        System.out.println("Row booking created:");
        System.out.println("Customer: " + customers.get(customerIndex).getName());
        System.out.println("Show: " + showName + " at " + startTime);
        System.out.println("Theater: " + theater.getId());
        System.out.println("Row: " + row + ", Seats: " + numberOfSeats + " starting from seat number " + startSeatNumber);
        System.out.println("\n==================================");
    }
    
    private boolean isValidDay(String day) 
    {
        return day.equalsIgnoreCase("Saturday") || day.equalsIgnoreCase("Sunday");
    }
    
    private LocalTime parseStartTime(String startTime) 
    {
        try {
            int hour = Integer.parseInt(startTime.split(":")[0]);
            int minute = Integer.parseInt(startTime.split(":")[1]);
            return LocalTime.of(hour, minute);
        } catch (NumberFormatException e) {
            System.out.println("Invalid time format. Please use HH:mm format.");
            return null;
        }
    }
    
    private boolean isValidSeat(Theater theater, int row, int seatNumber) 
    {
        return row >= 1 && row <= theater.getRows() && seatNumber >= 1 && seatNumber <= theater.getSeatsPerRow();
    }
    
    public void cancelBooking(Scanner scanner) 
    {
        if (customers.isEmpty()) {
            System.out.println("No customers available.");
            return;
        }
    
        displayCustomers();
        System.out.print("Enter customer number to cancel booking: ");
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Please enter a valid number: ");
        }
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
    
        if (index < 0 || index >= customers.size()) {
            System.out.println("Invalid customer number.");
            return;
        }
    
        Customer selectedCustomer = customers.get(index);
        List<Booking> customerBookings = getBookingsByCustomer(selectedCustomer);
    
        if (customerBookings.isEmpty()) {
            System.out.println("No bookings found for " + selectedCustomer.getName() + ".");
            return;
        }
    
        System.out.println("Select a booking to cancel:");
        for (int i = 0; i < customerBookings.size(); i++) {
            Booking booking = customerBookings.get(i);
            System.out.println((i + 1) + ": " + booking.getShow().getMovieName() + "\n\t at " + booking.getShow().getShowTime() 
            + " | Row: " + booking.getSeat().getRow() + ", Seat Number: " + booking.getSeat().getSeatNumber());
        }
    
        System.out.print("Enter the booking number to cancel (1 to " + customerBookings.size() + "): ");
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Please enter a valid number: ");
        }
        int bookingNumber = scanner.nextInt() - 1;
        scanner.nextLine();
    
        if (bookingNumber < 0 || bookingNumber >= customerBookings.size()) {
            System.out.println("Invalid booking number.");
            return;
        }
    
        Booking bookingToCancel = customerBookings.get(bookingNumber);
        bookings.remove(bookingToCancel);
        bookingToCancel.getSeat().setAvailable(true);
        System.out.println("Booking cancelled successfully for " + bookingToCancel.getShow().getMovieName() + ".");
    }
    
    private List<Booking> getBookingsByCustomer(Customer customer) {
        List<Booking> result = new ArrayList<>();
        for (Booking b : bookings) {
            if (b.getCustomer().equals(customer)) {
                result.add(b);
            }
        }
        return result;
    }
}