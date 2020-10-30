package ua.mieshkov.ivan.model.dao;

import ua.mieshkov.ivan.model.entities.User;

import java.util.List;

public interface UserDao extends GenericDao<User> {
    User findByLogin(String login);
    User findByLoginAndPassword(String login, String password);
    void updatePassword(Integer id, String newPassword);
    List<User> findByRole(String role);
}
