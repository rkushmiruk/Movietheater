package com.kushmyruk.dao.impl;

import com.kushmyruk.dao.EventDao;
import com.kushmyruk.domain.Auditorium;
import com.kushmyruk.domain.Event;
import com.kushmyruk.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.*;

@Repository
public class EventDaoImpl implements EventDao {
    private Store store;

    @Override
    public Optional<Event> findById(Long id) {
        return Optional.ofNullable(store.getEventStore().get(id));
    }

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(store.getEventStore().values());
    }

    @Override
    public boolean insert(Event event) {
        if (event != null) {
            Map<Long, Event> eventMap = store.getEventStore();
            eventMap.put((long) (eventMap.size() + 1), event);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Event event) {
        Map<Long, Event> eventMap = store.getEventStore();
        eventMap.put(event.getId(), event);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Map<Long, Event> eventMap = store.getEventStore();
        eventMap.remove(id);
        return true;
    }

    @Override
    public boolean assignAuditorium(Event event, Date dateTime, Auditorium auditorium) {
        if (event.getAirDates().contains(dateTime)) {
            event.setAuditorium(auditorium);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAuditoriumAssignment(Date dateTime, Event event) {
        if (event.getAirDates().contains(dateTime)) {
            event.setAuditorium(null);
            return true;
        }
        return false;
    }

    @Override
    public boolean addAirDateTime(Date dateTime, Event event) {
        return event.getAirDates().add(dateTime);
    }

    @Override
    public boolean addAirDateTime(Event event, Date dateTime, Auditorium auditorium) {
        boolean result = event.getAirDates().add(dateTime);
        if (result) {
            event.setAuditorium(auditorium);
        }
        return result;

    }

    @Override
    public boolean removeAirDateTime(Event event, Date dateTime) {
        boolean result = event.getAirDates().remove(dateTime);
        if (result) {
            event.setAuditorium(null);
        }
        return result;

    }

    @Override
    public boolean airsOnDateTime(Event event, Date dateTime) {
        return event.getAirDates().stream().anyMatch(dt -> dt.equals(dateTime));
    }

    @Override
    public boolean airsOnDate(Event event, Date date) {
        return event.getAirDates().stream().anyMatch(dt -> dt.equals(date));
    }

    @Override
    public boolean airsOnDates(Event event, Date from, Date to) {
        return event.getAirDates().stream().anyMatch(dt -> dt.compareTo(from) >= 0 && dt.compareTo(to) <= 0);
    }

    @Autowired
    public void setStore(Store store) {
        this.store = store;
    }
}
