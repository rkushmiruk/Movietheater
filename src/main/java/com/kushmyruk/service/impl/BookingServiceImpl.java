package com.kushmyruk.service.impl;

import com.kushmyruk.domain.Event;
import com.kushmyruk.domain.Ticket;
import com.kushmyruk.domain.User;
import com.kushmyruk.service.BookingService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Set;

@Service
public class BookingServiceImpl implements BookingService {
    @Override
    public double getTicketsPrice(Event event, Date dateTime, User user, Set<Long> seats) {
        Double totalPrice = event.getRating().getRate() * event.getBasePrice() +
                seats.stream().filter(event.getAuditorium().getVipSeats()::contains).findFirst().orElse(0L);
        totalPrice *= seats.size();
        return totalPrice;
    }

    @Override
    public void bookTickets(Set<Ticket> tickets) {

    }

    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(Event event, Date dateTime) {
        return null;
    }
}
