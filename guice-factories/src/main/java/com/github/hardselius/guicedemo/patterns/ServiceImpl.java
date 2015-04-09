package com.github.hardselius.guicedemo.patterns;

public class ServiceImpl implements Service {
    @Override
    public boolean go() {
        System.out.println("Something expensive going on...");
        return true;
    }
}
