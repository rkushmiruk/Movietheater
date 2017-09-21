package com.kushmyruk.dao.impl;

import com.kushmyruk.dao.TicketDao;
import com.kushmyruk.domain.Ticket;
import com.kushmyruk.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class TicketDaoImpl implements TicketDao {
    private Store store;

    @Override
    public Optional<Ticket> findById(Long id) {
        return Optional.ofNullable(store.getTicketStore().get(id));
    }

    @Override
    public List<Ticket> findAll() {
        return new ArrayList<>(store.getTicketStore().values());
    }

    @Override
    public boolean insert(Ticket ticket) {
        if (ticket != null) {
            Map<Long, Ticket> ticketMap = store.getTicketStore();
            ticketMap.put((long) (ticketMap.size() + 1), ticket);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Ticket ticket) {
        Map<Long, Ticket> ticketMap = store.getTicketStore();
        ticketMap.put(ticket.getId(), ticket);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Map<Long, Ticket> ticketMap = store.getTicketStore();
        ticketMap.remove(id);
        return true;
    }

    @Autowired
    public void setStore(Store store) {
        this.store = store;
    }
}
