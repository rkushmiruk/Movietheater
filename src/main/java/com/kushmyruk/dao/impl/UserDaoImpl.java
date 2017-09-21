package com.kushmyruk.dao.impl;

import com.kushmyruk.dao.UserDao;
import com.kushmyruk.domain.User;
import com.kushmyruk.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {
    private Store store;

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.getUserStore().get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.getUserStore().values());
    }

    @Override
    public boolean insert(User user) {
        if (user != null) {
            Map<Long, User> userMap = store.getUserStore();
            userMap.put((long) (userMap.size() + 1), user);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        Map<Long, User> userMap = store.getUserStore();
        userMap.put(user.getId(), user);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Map<Long, User> userMap = store.getUserStore();
        userMap.remove(id);
        return true;
    }

    @Autowired
    public void setStore(Store store) {
        this.store = store;
    }
}
