package zadacha31._zadanie1.dao;

import zadacha31._zadanie1.model.User;

import java.util.List;

public interface UserDAO {
    List<User> showUsers();

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    User getUser(Long id);
}