package com.kushmyruk.domain;

import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.*;

@Repository
public class Event extends DomainObject {
    private String name;
    private Set<Date> airDates = new TreeSet<>();
    private Double basePrice;
    private EventRating rating;
    private Auditorium auditorium;

    public Event(String name, Set<Date> airDates, Double basePrice, EventRating rating, Auditorium auditorium) {
        this.name = name;
        this.airDates = airDates;
        this.basePrice = basePrice;
        this.rating = rating;
        this.auditorium = auditorium;
    }

    public Event() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Date> getAirDates() {
        return airDates;
    }

    public void setAirDates(Set<Date> airDates) {
        this.airDates = airDates;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public EventRating getRating() {
        return rating;
    }

    public void setRating(EventRating rating) {
        this.rating = rating;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (airDates != null ? !airDates.equals(event.airDates) : event.airDates != null) return false;
        if (basePrice != null ? !basePrice.equals(event.basePrice) : event.basePrice != null) return false;
        if (rating != event.rating) return false;
        return auditorium != null ? auditorium.equals(event.auditorium) : event.auditorium == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (airDates != null ? airDates.hashCode() : 0);
        result = 31 * result + (basePrice != null ? basePrice.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (auditorium != null ? auditorium.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", airDates=" + airDates +
                ", basePrice=" + basePrice +
                ", rating=" + rating +
                ", auditorium=" + auditorium +
                '}';
    }
}
