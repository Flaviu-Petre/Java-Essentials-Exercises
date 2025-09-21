package models;

import java.util.ArrayList;

public class MusicService {
    //region variables
    private ArrayList<Song> songs;
    private ArrayList<User> users;
    //endregion

    //region constructor
    public MusicService() {
        this.songs = new ArrayList<>();
        this.users = new ArrayList<>();
    }
    //endregion

    //region getters
    public ArrayList<Song> getSongs() {
        return songs;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
    //endregion

    //region methods
    public void addSong(Song song) {
        songs.add(song);
    }

    public void addUser(User user) {
        users.add(user);
    }
    //endregion

    //region methods
    public void addNewSong(){
        // Logic to add a new song to the music service
        Song newSong = new Song("New Song", "New Artist", 300);
        songs.add(newSong);
        System.out.println("New song added to the music service");
    }

    public void addNewUser(){
        // Logic to add a new user to the music service
        User newUser = new User(users.size() + 1, "New User", new ArrayList<>());
        users.add(newUser);
        System.out.println("New user added to the music service");
    }

    public User getUserById(int userId){
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        System.out.println("User not found in the music service");
        return null;
    }

    public Song getSongByTitle(String title) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }
        System.out.println("Song not found in the music service");
        return null;
    }
    //endregion
}
