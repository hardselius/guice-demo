package com.github.hardselius.guicedemo.patterns.guice;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Main3 {

    private static Injector injector;

    public static void main(String... args) {
        injector = Guice.createInjector(
                new ServiceModule()
        );

        Client3 client3 = injector.getInstance(Client3.class);
        System.out.println(client3.go());
    }
}
