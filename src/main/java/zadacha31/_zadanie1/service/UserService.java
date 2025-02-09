package zadacha31._zadanie1.service;

import zadacha31._zadanie1.model.User;

import java.util.List;

public interface UserService {
    List<User> showUsers();

    User getUser(Long id);

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);
}
