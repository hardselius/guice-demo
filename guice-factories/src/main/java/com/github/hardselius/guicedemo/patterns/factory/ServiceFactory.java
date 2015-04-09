package com.github.hardselius.guicedemo.patterns.factory;

import com.github.hardselius.guicedemo.patterns.Service;
import com.github.hardselius.guicedemo.patterns.ServiceImpl;

public class ServiceFactory {

    private static Service instance = null;

    public static Service getInstance() {
        if (instance == null) {
            instance  = new ServiceImpl();
        }
        return instance;
    }

    public static void setInstance(Service service) {
        instance = service;
    }
}
