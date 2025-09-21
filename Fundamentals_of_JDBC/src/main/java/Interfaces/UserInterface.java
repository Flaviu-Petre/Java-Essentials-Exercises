package Interfaces;

import model.User;

public interface UserInterface {
     void insert(User user);
     void update(String userId, User user);
     void delete(String userId);
     void getAllUsers();
}
