package com.github.hardselius.guicedemo.servlet.modules;

import com.github.hardselius.guicedemo.servlet.DemoServlet;
import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;

public class DemoServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        bind(DemoServlet.class).in(Scopes.SINGLETON);
        serve("/demoservlet").with(DemoServlet.class);
    }
}
