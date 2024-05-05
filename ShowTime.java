import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Write a description of class ShowTime here.
 *
 * @authors Steven Coss &
 * @version 5.5.2024
 */
public class ShowTime
{
    private LocalTime startTime;
    private LocalTime endTime;
    
    /**
     * Constructor for objects of class ShowTime
     */
    public ShowTime(int startHour, int startMinute, int endHour, int endMinute) 
    {
        this.startTime = LocalTime.of(startHour, startMinute);
        this.endTime = LocalTime.of(endHour, endMinute);
    }
    
    public LocalTime getStartTime() 
    {
        return startTime;
    }

    public LocalTime getEndTime() 
    {
        return endTime;
    }
}
