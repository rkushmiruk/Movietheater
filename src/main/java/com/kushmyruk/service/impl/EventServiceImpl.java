package com.kushmyruk.service.impl;

import com.kushmyruk.dao.impl.EventDaoImpl;
import com.kushmyruk.domain.Event;
import com.kushmyruk.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    private EventDaoImpl eventDao;

    @Override
    public Event save(Event event) {
        eventDao.insert(event);
        return event;
    }

    @Override
    public void remove(Event event) {
        eventDao.delete(event.getId());
    }

    @Override
    public Event getById(Long id) {
        return eventDao.findById(id).get();
    }

    @Override
    public Collection<Event> getAll() {
        return eventDao.findAll();
    }

    @Override
    public Event getByName(String name) {
        List<Event> allEvents = eventDao.findAll();
        return allEvents.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Set<Event> getForDateRange(Date from, Date to) {
        List<Event> allEvents = eventDao.findAll();
        return allEvents.stream().filter(e -> (e.getAirDates().getTime() >= from.getTime()
                && e.getAirDates().getTime() <= to.getTime())).collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getNextEvents(Date to) {
        List<Event> allEvents = eventDao.findAll();
        return allEvents.stream().filter(e -> (e.getAirDates().getTime() >= new java.util.Date().getTime()
                && e.getAirDates().getTime() <= to.getTime())).collect(Collectors.toSet());
    }

    @Autowired
    public void setEventDao(EventDaoImpl eventDao) {
        this.eventDao = eventDao;
    }
}
