package com.kushmyruk.dao;

import com.kushmyruk.domain.Auditorium;

import java.util.Collection;

public interface AuditoriumDao extends GenericDao<Auditorium, Long> {
    /**
     * Counts how many vip seats are there in supplied <code>seats</code>
     *
     * @param seats Seats to process
     * @return number of vip seats in request
     */
    long countVipSeats(Collection<Long> seats);


}
