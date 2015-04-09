package com.github.hardselius.guicedemo.patterns.dibyhand;

import com.github.hardselius.guicedemo.patterns.Service;

public class Client2 {

    private final Service service;

    public Client2(Service service) {
        this.service = service;
    }

    public boolean go() {
        return service.go();
    }
}
