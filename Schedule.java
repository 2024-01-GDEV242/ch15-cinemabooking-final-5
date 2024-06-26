import java.util.ArrayList;

/**
 * Write a description of class Schedule here.
 *
 * @authors Steven Coss &
 * @version 5.5.2024
 */
public class Schedule
{
    private ArrayList<Show> shows;
    private ArrayList<ShowTime> showTimes;
    //private ArrayList<Theater> theaters;
    //private int date;
    //private int time;
    // private int timeSlot1 = 12;
    // private int timeSlot2 = 14;
    // private int timeSlot3 = 16;
    // private int timeSlot4 = 20;

    /**
     * Constructor for objects of class Schedule
     */
    public Schedule()
    {
        //this.date = date;
        shows = new ArrayList<>();
        showTimes = new ArrayList<>();
        showTimes.add(new ShowTime(12,14));
        showTimes.add(new ShowTime(15,17));
        showTimes.add(new ShowTime(18,20));
        showTimes.add(new ShowTime(21,23));
        createShows("LOTR");
        createShows("Kong");
    }
    /**
     * creats a show for each showtime available
     * 
     * @param showName name of the show to be created
     */
    public void createShows(String showName)
    {
        for (int x = 0; x < showTimes.size(); x ++)
            {
                shows.add(new Show(showName,showTimes.get(x)));
            }
    }
    public Show getShow(String name,int startTime)
    {
        for (int x = 0; x < shows.size(); x ++)
        {
            if(shows.get(x).getName().equalsIgnoreCase(name) && shows.get(x).getShowTime().getStartTime() == startTime)
            {
                return shows.get(x);
            }
        }
        System.out.println("that show at that time doesn't exisit");
        return null;
    }
}
