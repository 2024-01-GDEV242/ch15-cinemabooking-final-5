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
    private String day;
    
    public Schedule(ArrayList<Theater> theaters, String day) 
    {
        this.shows = new ArrayList<>();
        this.theaters = theaters;
        this.day = day; 
        initializeShowTimes();
    }
    
    public void addShow(String showName, ShowTime showTime, Theater theater) 
    {
        shows.add(new Show(showName, showTime, theater));
    }
    
    private void initializeShowTimes() 
    {
        showTimes = new ArrayList<>();
        showTimes.add(new ShowTime(8, 30, 10, 45));
        showTimes.add(new ShowTime(10, 00, 12, 15));
        showTimes.add(new ShowTime(12, 30, 14, 45));
        showTimes.add(new ShowTime(15, 00, 17, 15));
        showTimes.add(new ShowTime(17, 30, 19, 45));
        showTimes.add(new ShowTime(20, 00, 22, 15));
    }
    
    public String getDay() {
        return day;
    }
       
    public ArrayList<Show> getShows() 
    {
        return shows;
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