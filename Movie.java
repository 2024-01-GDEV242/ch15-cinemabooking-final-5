/**
 * The Movie class represents a film identified by its name.
 * This minimalist class is designed for use in systems where only the movie's name is required,
 * simplifying interactions and data management.
 *
 * @authors Steven Coss & Matt Romond & Fhaungfha Suvannakajorn 
 * @version 5.5.2024
 */
public class Movie {
    private String name;

    /**
     * Constructor for objects of class Movie that initializes the movie with a name.
     *
     * @param name The name of the movie.
     */
    public Movie(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the movie.
     * 
     * @return The name of the movie.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the movie.
     * 
     * @param name The new name of the movie.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Provides a string representation of the movie.
     *
     * @return A string that includes the name of the movie.
     */
    @Override
    public String toString() {
        return "Movie name: " + name;
    }
}
