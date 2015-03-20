package com.github.hardselius.guicedemo.jersey2;

import com.github.hardselius.guicedemo.jersey2.modules.HelloModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

import javax.servlet.ServletContextEvent;

public class GuiceServletConfig extends GuiceServletContextListener {
    private static Injector INJECTOR;

    public static Injector getInjectorInstance() {
        return INJECTOR;
    }

    private void createInjectorInstance() {
        INJECTOR = Guice.createInjector(
                new HelloModule());
    }

    @Override
    protected Injector getInjector() {
        return getInjectorInstance();
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        createInjectorInstance();
        super.contextInitialized(servletContextEvent);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        super.contextDestroyed(servletContextEvent);
    }
}
