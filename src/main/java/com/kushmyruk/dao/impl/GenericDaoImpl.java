package com.kushmyruk.dao.impl;

import com.kushmyruk.dao.GenericDao;
import com.kushmyruk.domain.DomainObject;
import com.kushmyruk.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GenericDaoImpl<T extends DomainObject> implements GenericDao<T, Long> {
    @Autowired
    private Store store;

    @Override
    public Optional<T> findById(Long id) {
        System.out.println(store);
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public boolean insert(T t) {
        return false;
    }

    @Override
    public boolean update(T t) {
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

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "GenericDaoImpl{" +
                "store=" + store +
                '}';
    }
}
