package com.kushmyruk.dao.impl;

import com.kushmyruk.store.Store;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Main {
    @Autowired
    private static Store store;

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("com/kushmyruk/domain/store-context-config.xml");

        context.refresh();

        System.out.println(store);
//        store.getUserStore().entrySet().forEach(LOGGER::info);
//        store.getTicketStore().entrySet().forEach(LOGGER::info);

    }

    @Autowired
    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }
}
