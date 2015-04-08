package com.github.hardselius.guicedemo.servlet.modules.greeter;

import com.google.inject.AbstractModule;
import com.google.inject.servlet.RequestScoped;

@RequestScoped
public class GreeterModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Greeter.class).to(GreeterImpl.class);
    }
}
