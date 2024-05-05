
/**
 * Write a description of class Show here.
 *
 * @authors Steven Coss &
 * @version 5.5.2024
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
        room = new Theater (6,6);
    }
    /**
     * returns the theater
     */
    public Theater getTheater()
    {
        return room;
    }
    /**
     * returns the showTime object
     */
    public ShowTime getShowTime()
    {
        return showTime;
    }
    /**
     * returns the movies name
     */
    public String getName()
    {
        return movie;
    }
}
