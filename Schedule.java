import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Write a description of class Schedule here.
 *
 * @authors Steven Coss & Fhaungfha Suvannakajorn
 * @version 5.5.2024
 */
public class Schedule {
    private ArrayList<Show> shows;
    private ArrayList<ShowTime> showTimes;
    private ArrayList<Theater> theaters;
    private LocalDate date;
    
    public Schedule(ArrayList<Theater> theaters) 
    {
        this.shows = new ArrayList<>();
        this.theaters = theaters;
        this.date = date; 
        initializeShowTimes();
    }
    
    private void initializeShowTimes() 
    {
        showTimes = new ArrayList<>();
        showTimes.add(new ShowTime(9, 0, 10, 50));
        showTimes.add(new ShowTime(11, 30, 13, 20));
        showTimes.add(new ShowTime(14, 0, 15, 50));
        showTimes.add(new ShowTime(16, 30, 18, 20));
        showTimes.add(new ShowTime(19, 0, 20, 50));
        showTimes.add(new ShowTime(21, 30, 23, 20));
        
        for (int i = 0; i < showTimes.size(); i++) {
        int theaterIndex = i % theaters.size();
        createShows("Movie " + (i + 1), showTimes.get(i), theaters.get(theaterIndex));
        }
    }
    
    public LocalDate getDate() 
    {
        return this.date; // Return the date of the schedule
    }
    
    private void createShows(String showName, ShowTime showTime, Theater theater) 
    {
        shows.add(new Show(showName, showTime, theater));
    }
    
    public Show getShow(String name, LocalTime startTime) 
    {
        for (Show show : shows) {
          if (show.getMovieName().equalsIgnoreCase(name) && show.getShowTime().getStartTime().equals(startTime)) {
            return show;
          }
        }
        System.out.println("That show at that time doesn't exist");
        return null;
    }
}
