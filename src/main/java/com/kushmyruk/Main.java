package com.kushmyruk;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("com/kushmyruk/domain/store-context-config.xml");

        context.refresh();


//        store.getUserStore().entrySet().forEach(LOGGER::info);
//        store.getTicketStore().entrySet().forEach(LOGGER::info);

    }



}
