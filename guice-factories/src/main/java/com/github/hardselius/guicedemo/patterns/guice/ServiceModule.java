package com.github.hardselius.guicedemo.patterns.guice;

import com.github.hardselius.guicedemo.patterns.Service;
import com.github.hardselius.guicedemo.patterns.ServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Client3.class);
        bind(Service.class)
                .to(ServiceImpl.class)
                .in(Scopes.SINGLETON);
    }
}
