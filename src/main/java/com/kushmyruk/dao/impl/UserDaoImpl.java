package com.kushmyruk.dao.impl;

import com.kushmyruk.dao.UserDao;
import com.kushmyruk.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    @Autowired
    private GenericDaoImpl genericDao;
    @Override
    public Optional<User> findById(Long a) {
        System.out.println(genericDao);
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public Optional<Long> findId() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
