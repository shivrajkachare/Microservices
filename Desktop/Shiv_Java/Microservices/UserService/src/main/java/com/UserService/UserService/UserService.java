package com.UserService.UserService;

import java.util.List;

public interface UserService {

    public User addUser(User user);
    public User getUser(int id);
    public String deleteUser(int id);
    public List<User> getAllUsers();
}
