package day02;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    // --- attributes ---------------------------------------------------------

    private List<Movie> movies;

    // --- constructors -------------------------------------------------------

    public MovieService() {
        movies = new ArrayList<>();
    }

    // --- getters and setters ------------------------------------------------

    public List<Movie> getMovies() { return movies; }

    // --- public methods -----------------------------------------------------

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> moviesWithActor(String actor) {
        return movies.stream().filter(movie -> movie.getActors().contains(actor)).toList();
    }

    public int getLongestFilmLength() {
        return movies.stream()
            .mapToInt(Movie::getLength).max()
            .orElseThrow(() -> new IllegalStateException("Empty movie list."));
    }
}