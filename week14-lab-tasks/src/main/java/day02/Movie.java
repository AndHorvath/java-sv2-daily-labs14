package day02;

import java.util.List;

public class Movie {

    // --- attributes ---------------------------------------------------------

    private String title;
    private int length;
    private List<String> actors;

    // --- constructors -------------------------------------------------------

    public Movie(String title, int length, List<String> actors) {
        this.title = title;
        this.length = length;
        this.actors = actors;
    }

    // --- getters and setters ------------------------------------------------

    public String getTitle() { return title; }
    public int getLength() { return length; }
    public List<String> getActors() { return actors; }
}