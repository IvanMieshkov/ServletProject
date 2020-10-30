package ua.mieshkov.ivan.model.services;

import ua.mieshkov.ivan.model.dao.DaoFactory;
import ua.mieshkov.ivan.model.dao.UserDao;
import ua.mieshkov.ivan.model.entities.User;
import ua.mieshkov.ivan.model.exception.LoginAlreadyExistsException;

import java.util.Objects;

public class UserRegistrationService {
    public void register(User user) throws LoginAlreadyExistsException {
        UserDao userDao = DaoFactory.getInstance().createUserDao();

        if(Objects.nonNull(userDao.findByLogin(user.getLogin()))) {
            throw new LoginAlreadyExistsException();
        }

        userDao.create(user);
        userDao.close();
    }
}
