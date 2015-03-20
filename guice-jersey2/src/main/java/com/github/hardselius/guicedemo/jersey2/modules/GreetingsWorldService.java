package com.github.hardselius.guicedemo.jersey2.modules;

public class GreetingsWorldService implements GreetingsService {
    @Override
    public String greeting() {
        return "World";
    }
}
