package com.kushmyruk.service;

import com.kushmyruk.domain.Event;
import com.kushmyruk.domain.User;

import java.sql.Date;
import java.time.LocalDateTime;

public interface DiscountService {
    /**
     * Getting discount based on some rules for user that buys some number of
     * tickets for the specific date time of the event
     *
     * @param user            User that buys tickets. Can be <code>null</code>
     * @param event           Event that tickets are bought for
     * @param airDateTime     The date and time event will be aired
     * @param numberOfTickets Number of tickets that user buys
     * @return discount value from 0 to 100
     */
    byte getDiscount(User user, Event event, Date airDateTime, long numberOfTickets);

}
