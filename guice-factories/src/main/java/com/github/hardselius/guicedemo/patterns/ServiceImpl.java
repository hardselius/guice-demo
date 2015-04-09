package com.github.hardselius.guicedemo.patterns;

public class ServiceImpl implements Service {
    @Override
    public String go() {
        return "Some expensive stuff...";
    }
}
