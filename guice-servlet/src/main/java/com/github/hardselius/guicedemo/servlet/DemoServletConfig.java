package com.github.hardselius.guicedemo.servlet;

import com.github.hardselius.guicedemo.servlet.modules.DemoServletModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class DemoServletConfig extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(
                new DemoServletModule());
    }
}
