package models;

import Interfaces.IManageable;

import java.util.ArrayList;

public class User implements IManageable {
    //region variables
    private int userId;
    private String username;
    private ArrayList<Playlist> playlistArray = new ArrayList<>();
    //endregion

    //region constructor
    public User(int userId, String username, ArrayList<Playlist> playlist) {
        this.userId = userId;
        this.username = username;
        this.playlistArray = playlist;
    }
    //endregion

    //region getters

    public String getUsername() {
        return username;
    }

    public int getUserId() {
        return userId;
    }

    public ArrayList<Playlist> getPlaylist() {
        return playlistArray;
    }

    //endregion

    //region setters

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPlaylist(ArrayList<Playlist> playlist) {
        this.playlistArray = playlist;
    }

    //endregion

    //region methods

    @Override
    public void creatPlaylist(String name, ArrayList<Song> songs) {
        // Logic to create a new playlist
        Playlist newPlaylist = new Playlist(name, songs);
        playlistArray.add(newPlaylist);
        System.out.println("Playlist created: " + name);
        System.out.println("------------------------------------------");
    }

    @Override
    public void addSongToPlaylist(Song song, int playlistIndex) {
        // Logic to add a song to the first playlist in the user's playlist array
        if (playlistIndex < 0 || playlistIndex >= playlistArray.size()) {
            System.out.println("Invalid playlist index.");
            return;
        }
        Playlist playlist = playlistArray.get(playlistIndex);
        playlist.addToPlaylist(song.getTitle(), song.getArtist(), song.getDuration());
        System.out.println("Song added to playlist: " + playlist.getName());
        System.out.println("------------------------------------------");
    }

    @Override
    public void removeSongFromPlaylist(String songTitle, int playlistIndex) {
        // Logic to remove a song from the specified playlist
        if (playlistIndex < 0 || playlistIndex >= playlistArray.size()) {
            System.out.println("Invalid playlist index.");
            return;
        }
        Playlist playlist = playlistArray.get(playlistIndex);
        ArrayList<Song> songs = playlist.getSongs();
        for (Song song : songs) {
            if (song.getTitle().equals(songTitle)) {
                songs.remove(song);
                System.out.println("Song removed from playlist: " + playlist.getName());
                return;
            }
        }
        System.out.println("Song not found in the specified playlist.");
        System.out.println("------------------------------------------");
    }
    //endregion
}
