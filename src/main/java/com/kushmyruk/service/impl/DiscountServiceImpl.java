package com.kushmyruk.service.impl;

import com.kushmyruk.domain.Event;
import com.kushmyruk.domain.User;
import com.kushmyruk.service.DiscountService;

import java.sql.Date;

public class DiscountServiceImpl implements DiscountService {
    @Override
    public byte getDiscount(User user, Event event, Date airDateTime, long numberOfTickets) {
        return 0;
    }
}
