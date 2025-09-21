package Interfaces;

import models.Song;

import java.util.ArrayList;

public interface IManageable {
    void creatPlaylist(String name, ArrayList<Song> songs);
    void addSongToPlaylist(Song song, int playlistIndex);
    void removeSongFromPlaylist(String songTitle, int playlistIndex);
}
