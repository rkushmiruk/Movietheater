package com.kushmyruk.service;

import com.kushmyruk.domain.Event;

import java.sql.Date;
import java.util.Set;

public interface EventService extends AbstractDomainObjectService<Event> {
    /**
     * Finding event by name
     *
     * @param name Name of the event
     * @return found event or <code>null</code>
     */
    Event getByName(String name);

    /**
     * Finding all events that air on specified date range
     *
     * @param from Start date
     * @param to   End date inclusive
     * @return Set of events
     */
    Set<Event> getForDateRange(Date from, Date to);

    /**
     * Return events from 'now' till the the specified date time
     *
     * @param to End date time inclusive
     *           s
     * @return Set of events
     */
    Set<Event> getNextEvents(Date to);

}
