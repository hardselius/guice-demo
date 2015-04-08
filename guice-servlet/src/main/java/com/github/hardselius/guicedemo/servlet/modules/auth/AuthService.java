package com.github.hardselius.guicedemo.servlet.modules.auth;

public interface AuthService {

    boolean isLoggedIn();

    void login(String user);

    void logout();

    String getUser();
}
