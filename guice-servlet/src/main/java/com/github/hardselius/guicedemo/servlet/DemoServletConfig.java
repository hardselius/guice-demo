package com.github.hardselius.guicedemo.servlet;

import com.github.hardselius.guicedemo.servlet.modules.servlet.DemoServletModule;
import com.github.hardselius.guicedemo.servlet.modules.auth.AuthModule;
import com.github.hardselius.guicedemo.servlet.modules.greeter.GreeterModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class DemoServletConfig extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(
                new DemoServletModule(),
                new AuthModule(),
                new GreeterModule());
    }
}
