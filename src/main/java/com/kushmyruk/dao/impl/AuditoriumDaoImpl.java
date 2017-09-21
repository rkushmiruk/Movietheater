package com.kushmyruk.dao.impl;

import com.kushmyruk.dao.AuditoriumDao;
import com.kushmyruk.domain.Auditorium;
import com.kushmyruk.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AuditoriumDaoImpl implements AuditoriumDao {
    private Store store;

    @Override
    public Optional<Auditorium> findById(Long id) {
        return Optional.ofNullable(store.getAuditoriumStore().get(id));
    }

    @Override
    public List<Auditorium> findAll() {
        return new ArrayList<>(store.getAuditoriumStore().values());
    }

    @Override
    public boolean insert(Auditorium auditorium) {
        if (auditorium != null) {
            Map<Long, Auditorium> auditoriumMap = store.getAuditoriumStore();
            auditoriumMap.put((long) (auditoriumMap.size() + 1), auditorium);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Auditorium auditorium) {
        Map<Long, Auditorium> auditoriumMap = store.getAuditoriumStore();
        auditoriumMap.put(auditorium.getId(), auditorium);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Map<Long, Auditorium> auditoriumMap = store.getAuditoriumStore();
        auditoriumMap.remove(id);
        return true;
    }

    @Override
    public long countVipSeats(Collection<Long> vipSeats) {
        return vipSeats.stream().filter(vipSeats::contains).count();
    }

    @Autowired
    public void setStore(Store store) {
        this.store = store;
    }
}
