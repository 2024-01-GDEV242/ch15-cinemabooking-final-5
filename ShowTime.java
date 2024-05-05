
/**
 * Write a description of class ShowTime here.
 *
 * @authors Steven Coss &
 * @version 5.5.2024
 */
public class ShowTime
{
    // instance variables - replace the example below with your own
    private int startTime;
    private int endTime;
    /**
     * Constructor for objects of class ShowTime
     */
    public ShowTime(int startTime, int endTime)
    {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public int getStartTime()
    {
        return startTime;
    }
    public int getEndTime()
    {
        return endTime;
    }
}
