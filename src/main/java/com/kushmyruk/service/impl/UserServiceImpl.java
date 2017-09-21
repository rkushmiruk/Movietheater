package com.kushmyruk.service.impl;

import com.kushmyruk.dao.impl.UserDaoImpl;
import com.kushmyruk.domain.User;
import com.kushmyruk.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao;

    @Override
    public User getUserByEmail(String email) {
        List<User> allUsers = userDao.findAll();
        return allUsers.stream().filter(e -> e.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public User save(User user) {
        userDao.insert(user);
        return user;
    }

    @Override
    public void remove(User user) {
        userDao.delete(user.getId());
    }

    @Override
    public User getById(Long id) {
        return userDao.findById(id).get();
    }

    @Override
    public Collection<User> getAll() {
        return userDao.findAll();
    }

    @Autowired
    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }
}
