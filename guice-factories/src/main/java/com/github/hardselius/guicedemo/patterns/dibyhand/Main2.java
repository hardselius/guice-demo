package com.github.hardselius.guicedemo.patterns.dibyhand;

import com.github.hardselius.guicedemo.patterns.Service;
import com.github.hardselius.guicedemo.patterns.factory.ServiceFactory;

public class Main2 {

    public static void main(String... args) {
        Service service = ServiceFactory.getInstance();
        Client2 client2 = new Client2(service);
        client2.go();
        // ...
    }
}
