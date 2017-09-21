package com.kushmyruk.service.impl;

import com.kushmyruk.dao.impl.AuditoriumDaoImpl;
import com.kushmyruk.domain.Auditorium;
import com.kushmyruk.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {
    private AuditoriumDaoImpl auditoriumDao;

    @Override
    public Auditorium save(Auditorium auditorium) {
        auditoriumDao.insert(auditorium);
        return auditorium;
    }

    @Override
    public void remove(Auditorium auditorium) {
        auditoriumDao.delete(auditorium.getId());
    }

    @Override
    public Auditorium getById(Long id) {
        return auditoriumDao.findById(id).get();
    }

    @Override
    public Set<Auditorium> getAll() {
        return new HashSet<>(auditoriumDao.findAll());
    }

    @Override
    public Auditorium getByName(String name) {
        List<Auditorium> allAuditoriums = auditoriumDao.findAll();
        return allAuditoriums.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    @Autowired
    public void setAuditoriumDao(AuditoriumDaoImpl auditoriumDao) {
        this.auditoriumDao = auditoriumDao;
    }
}
