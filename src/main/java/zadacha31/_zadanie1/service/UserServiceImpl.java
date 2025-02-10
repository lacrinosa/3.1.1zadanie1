package zadacha31._zadanie1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import zadacha31._zadanie1.dao.UserDAO;
import zadacha31._zadanie1.model.User;


@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> showUsers() {
        return userDAO.showUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void addUser(String name, String surname) {
        User user = new User(name, surname);
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(Long id, String name, String surname) {
        User user = userDAO.getUser(id);
        if (user != null) {
            user.setName(name);
            user.setSurname(surname);
            userDAO.updateUser(user);
        }
    }
}
