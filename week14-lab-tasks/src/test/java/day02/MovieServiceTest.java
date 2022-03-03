package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    MovieService movieService;
    Movie movieA;
    Movie movieB;
    @BeforeEach
    void setUp() {
        movieService = new MovieService();

        movieA = new Movie("Title A", 100, List.of("Actor A", "Actor C"));
        movieB = new Movie("Title B", 120, List.of("Actor B", "Actor C"));
    }

    @Test
    void getMoviesTest() {
        assertEquals(new ArrayList<>(), movieService.getMovies());
    }

    @Test
    void addMovieTest() {
        movieService.addMovie(movieA);
        movieService.addMovie(movieB);

        assertEquals(List.of(movieA, movieB), movieService.getMovies());
    }

    @Test
    void moviesWithActorTest() {
        movieService.addMovie(movieA);
        movieService.addMovie(movieB);

        assertEquals(List.of(movieA), movieService.moviesWithActor("Actor A"));
        assertEquals(List.of(movieA, movieB), movieService.moviesWithActor("Actor C"));
    }

    @Test
    void getLongestFilmLengthTest() {
        movieService.addMovie(movieA);
        movieService.addMovie(movieB);

        assertEquals(120, movieService.getLongestFilmLength());
    }
}