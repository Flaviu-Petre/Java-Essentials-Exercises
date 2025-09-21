package models;

public class Song {
    //region variables
    private String title;
    private String artist;
    private int duration;
    //endregion

    //region constructor
    public Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
    //endregion

    //region getters

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }

    //endregion

    //region setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    //endregion
}
