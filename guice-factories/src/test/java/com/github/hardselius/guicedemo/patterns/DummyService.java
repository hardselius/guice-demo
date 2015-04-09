package com.github.hardselius.guicedemo.patterns;

public class DummyService implements Service {

    @Override
    public String go() {
        return "A mock service";
    }

}