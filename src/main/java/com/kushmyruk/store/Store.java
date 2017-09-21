package com.kushmyruk.store;

import com.kushmyruk.domain.*;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

@Repository
public class Store {
    private Map<Long, User> userStore = new HashMap<>();
    private Map<Long, Ticket> ticketStore = new HashMap<>();
    private Map<Long, Auditorium> auditoriumStore = new HashMap<>();
    private Map<Long, Event> eventStore = new HashMap<>();

    @PostConstruct
    public void init() {
        Auditorium auditorium = new Auditorium();

        Event event = new Event("JavaDay", new TreeSet<>(), 100.00, EventRating.HIGH, auditorium);

        User user1 = new User(1L, "Roman", "Kushmyruk", "Ramon_2@mail.ru");
        User user2 = new User(2L, "Dima", "Kushmyruk", "Ramon@mail.ru");
        User user3 = new User(3L, "Valera", "Kushmyruk", "Ramon_3@mail.ru");

        Ticket ticket1 = new Ticket(user1, event, new Date(new java.util.Date().getTime()), 1);
        Ticket ticket2 = new Ticket(user2, event, new Date(new java.util.Date().getTime()), 2);
        Ticket ticket3 = new Ticket(user3, event, new Date(new java.util.Date().getTime()), 3);

        auditoriumStore.put(1L, auditorium);

        ticketStore.put(1L, ticket1);
        ticketStore.put(2L, ticket2);
        ticketStore.put(3L, ticket3);

        eventStore.put(1L, event);

        userStore.put(1L, user1);
        userStore.put(2L, user2);
        userStore.put(3L, user3);
    }

    public Map<Long, User> getUserStore() {
        return userStore;
    }

    public void setUserStore(Map<Long, User> userStore) {
        this.userStore = userStore;
    }

    public Map<Long, Ticket> getTicketStore() {
        return ticketStore;
    }

    public void setTicketStore(Map<Long, Ticket> ticketStore) {
        this.ticketStore = ticketStore;
    }

    public Map<Long, Auditorium> getAuditoriumStore() {
        return auditoriumStore;
    }

    public void setAuditoriumStore(Map<Long, Auditorium> auditoriumStore) {
        this.auditoriumStore = auditoriumStore;
    }

    public Map<Long, Event> getEventStore() {
        return eventStore;
    }

    public void setEventStore(Map<Long, Event> eventStore) {
        this.eventStore = eventStore;
    }
}
