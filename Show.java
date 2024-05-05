import java.time.LocalDateTime; // Import necessary for handling show times if ShowTime is based on LocalDateTime

/**
 * The Show class represents a film screening at a specific time in a specific theater.
 * It is crucial for scheduling and managing screenings in a cinema booking system.
 *
 * @authors Steven Coss & Fhaungfha Suvannakajorn
 * @version 5.5.2024
 */
class Show {
    private String movieName;
    private ShowTime showTime;
    private Theater theater;

    public Show(String movieName, ShowTime showTime, Theater theater) {
        this.movieName = movieName;
        this.showTime = showTime;
        this.theater = theater;
    }

    public String getMovieName() {
        return movieName;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public Theater getTheater() {
        return theater;
    }
}