package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    Movie movie;
    List<String> actors;

    @BeforeEach
    void setUp() {
        actors = List.of("Actor A", "Actor B", "Actor C");
        movie = new Movie("Title", 100, actors);
    }

    @Test
    void getTitleTest() {
        assertEquals("Title", movie.getTitle());
    }

    @Test
    void getLengthTest() {
        assertEquals(100, movie.getLength());
    }

    @Test
    void getActorsTest() {
        assertEquals(actors, movie.getActors());
    }
}