package models;

import Interfaces.IPlayable;

import java.util.ArrayList;

public class Playlist implements IPlayable {
    //region variables
    private String name;
    private ArrayList<Song> songs = new ArrayList<>();
    //endregion

    //region constructor
    public Playlist(String name, ArrayList<Song> songs) {
        this.name = name;
        this.songs = songs;
    }
    //endregion

    //region getters

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    //endregion

    //region setters

    public void setName(String name) {
        this.name = name;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    //endregion

    //region methods
    @Override
    public void addToPlaylist(String song, String artist, int duration) {
        // Logic to add a song to the playlist
        Song newSong = new Song(song, artist, duration);
        songs.add(newSong);
        System.out.println("Song added to the playlist");
    }

    @Override
    public void removeFromPlaylist(String song) {
        // Logic to remove a song from the playlist
        for (Song s : songs) {
            if (s.getTitle().equals(song)) {
                songs.remove(s);
                System.out.println("Song removed from the playlist");
                return;
            }
        }
        System.out.println("Song not found in the playlist");
    }
    //endregion

}
