package com.github.hardselius.guicedemo.jersey2.modules;

public class GreetingsSpecialService implements GreetingsService {
    @Override
    public String greeting() {
        return "Special One";
    }
}
