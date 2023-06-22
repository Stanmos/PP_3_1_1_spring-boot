package ru.javamentor.service;

import ru.javamentor.model.User;

import java.util.List;

public interface UsersService {
    void addUser(User user);

    List<User> getUsers();

    void updateUser(User user);

    void deleteUser(int id);

    User getUserById(int id);
}
