package com.github.hardselius.guicedemo.patterns.guice;

import com.github.hardselius.guicedemo.patterns.Service;
import com.google.inject.Inject;

public class Client3 {

    private final Service service;

    @Inject
    public Client3(Service service) {
        this.service = service;
    }

    public boolean go() {
        return service.go();
    }
}
