package com.kushmyruk;

import com.kushmyruk.dao.impl.UserDaoImpl;
import com.kushmyruk.domain.User;
import com.kushmyruk.service.impl.BookingServiceImpl;
import com.kushmyruk.service.impl.UserServiceImpl;
import com.kushmyruk.store.Store;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static Store store;
    private static UserDaoImpl userDao;
    private static UserServiceImpl userService;
    private static BookingServiceImpl bookingService;
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("com/kushmyruk/domain/store-context-config.xml");

        Set<Long> set = new HashSet<>();
        set.add(1L);
        set.add(2L);

        store = (Store) context.getBean("store");
        userDao = (UserDaoImpl) context.getBean("userDaoImpl");
        userService = (UserServiceImpl) context.getBean("userServiceImpl");
        bookingService = (BookingServiceImpl) context.getBean("bookingServiceImpl");

        User user3 = new User(4L, "Leaha", "Kushmyruk", "Ramon_2@mail.ru");
        User user2 = new User(2L, "Mia", "Kushmyruk", "Ravioli@mail.ru");
        User user5 = new User(5L, "Dina", "Liamel", "Linch@mail.ru");

        userService.save(user5);
        userDao.insert(user3);
        userDao.update(user2);

        userDao.findAll().forEach(LOGGER::info);
        LOGGER.info(userService.getAll());
        LOGGER.info(bookingService.getTicketsPrice(store.getEventStore().get(1L),
                new Date(new java.util.Date().getTime()),
                user2, set));


    }

}
