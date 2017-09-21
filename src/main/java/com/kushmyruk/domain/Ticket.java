package com.kushmyruk.domain;

import java.sql.Date;

public class Ticket extends DomainObject implements Comparable<Ticket> {
    private User user;
    private Event event;
    private Date dateTime;
    private long seat;

    public Ticket(User user, Event event, Date dateTime, long seat) {
        this.user = user;
        this.event = event;
        this.dateTime = dateTime;
        this.seat = seat;
    }

    public Ticket() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public long getSeat() {
        return seat;
    }

    public void setSeat(long seat) {
        this.seat = seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (seat != ticket.seat) return false;
        if (user != null ? !user.equals(ticket.user) : ticket.user != null) return false;
        if (event != null ? !event.equals(ticket.event) : ticket.event != null) return false;
        return dateTime != null ? dateTime.equals(ticket.dateTime) : ticket.dateTime == null;

    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (int) (seat ^ (seat >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "user=" + user +
                ", event=" + event +
                ", dateTime=" + dateTime +
                ", seat=" + seat +
                '}';
    }

    @Override
    public int compareTo(Ticket other) {
        if (other == null) {
            return 1;
        }
        int result = dateTime.compareTo(other.getDateTime());

        if (result == 0) {
            result = event.getName().compareTo(other.getEvent().getName());
        }
        if (result == 0) {
            result = Long.compare(seat, other.getSeat());
        }
        return result;

    }
}
