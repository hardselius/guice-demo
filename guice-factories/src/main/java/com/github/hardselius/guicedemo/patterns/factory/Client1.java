package com.github.hardselius.guicedemo.patterns.factory;

import com.github.hardselius.guicedemo.patterns.Service;

public class Client1 {
    public boolean go() {
        Service service = ServiceFactory.getInstance();
        return service.go();
    }
}
