package Interfaces;

public interface IPlayable {
    void addToPlaylist(String song, String artist, int duration);
    void removeFromPlaylist(String song);
}
