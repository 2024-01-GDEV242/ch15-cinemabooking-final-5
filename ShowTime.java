import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Write a description of class ShowTime here.
 *
 * @authors Steven Coss & Matt Romond & Fhaungfha Suvannakajorn 
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
    
    /**
     * Override toString() method to provide a representation
     * @Override
     */
    public String toString() 
    {
        int startHour = startTime.getHour();
        int startMinute = startTime.getMinute();
        int endHour = endTime.getHour();
        int endMinute = endTime.getMinute();
        
        String startAMPM = startHour < 12 ? "AM" : "PM";
        if (startHour == 0) {
            startHour = 12;
        } else if (startHour > 12) {
            startHour -= 12;
        }
        String startTimeStr = startHour + ":" + (startMinute < 10 ? "0" : "") + startMinute;
        
        String endAMPM = endHour < 12 ? "AM" : "PM";
        if (endHour == 0) {
            endHour = 12;
        } else if (endHour > 12) {
            endHour -= 12;
        }
        String endTimeStr = endHour + ":" + (endMinute < 10 ? "0" : "") + endMinute;
        
        return startTimeStr + " " + startAMPM + " - " + endTimeStr + " " + endAMPM;
    }
}