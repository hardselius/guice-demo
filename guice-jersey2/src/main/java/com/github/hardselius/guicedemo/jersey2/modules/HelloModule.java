package com.github.hardselius.guicedemo.jersey2.modules;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;


public class HelloModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(GreetingsService.class).annotatedWith(Names.named("special")).to(GreetingsSpecialService.class);
        bind(GreetingsService.class).to(GreetingsWorldService.class);
    }

}
