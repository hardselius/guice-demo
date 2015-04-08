package com.github.hardselius.guicedemo.servlet.modules.servlet;

import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;

public class DemoServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        /*bind(GuiceFilter.class).in(Singleton.class);
        filter("*//*").through(GuiceFilter.class)*/;

        bind(DemoServlet.class).in(Singleton.class);
        serve("/demoservlet").with(DemoServlet.class);
    }
}
