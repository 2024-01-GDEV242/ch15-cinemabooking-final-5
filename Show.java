
/**
 * Write a description of class Show here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Show
{
    private String movie;
    private Theater room;
    private ShowTime showTime;
    /**
     * Constructor for objects of class Show
     */
    public Show(String name,ShowTime showTime)
    {
        this.showTime = showTime;
        this.movie = name;
        room = new Theater (5,5);
    }
    public Theater getTheater()
    {
        return room;
    }
    public ShowTime getShowTime()
    {
        return showTime;
    }
    public String getName()
    {
        return movie;
    }
}
