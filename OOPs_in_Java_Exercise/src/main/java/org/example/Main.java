package org.example;

import models.Song;
import models.Playlist;
import models.User;
import models.MusicService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MusicService musicService = new MusicService();
        User john_doe = new User(1, "john_doe", new ArrayList<>());
        User petre_flaviu = new User(2, "petre_flaviu", new ArrayList<>());

        musicService.addUser(john_doe);
        musicService.addUser(petre_flaviu);

        Song song1 = new Song("Song 1", "Artist 1", 200);
        Song song2 = new Song("Song 2", "Artist 2", 250);
        Song song3 = new Song("Song 3", "Artist 3", 300);
        Song song4 = new Song("Song 4", "Artist 4", 180);

        musicService.addSong(song1);
        musicService.addSong(song2);
        musicService.addSong(song3);
        musicService.addSong(song4);

        john_doe.creatPlaylist("My Playlist", new ArrayList<>());
        john_doe.addSongToPlaylist(song1, 0);
        john_doe.addSongToPlaylist(song2, 0);


        petre_flaviu.creatPlaylist("Petre's first Playlist", new ArrayList<>());
        petre_flaviu.creatPlaylist("Petre's second Playlist", new ArrayList<>());
        petre_flaviu.addSongToPlaylist(song3, 0);
        petre_flaviu.addSongToPlaylist(song4, 1);


        System.out.println("Petre's Playlists:");
        for (Playlist playlist : petre_flaviu.getPlaylist()) {
            System.out.println("Playlist Name: " + playlist.getName());
            for (Song song : playlist.getSongs()) {
                System.out.println(" - " + song.getTitle() + " by " + song.getArtist() + " (" + song.getDuration() + " seconds)");
            }
        }
    }
}