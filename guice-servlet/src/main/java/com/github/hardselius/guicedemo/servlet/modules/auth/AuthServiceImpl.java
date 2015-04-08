package com.github.hardselius.guicedemo.servlet.modules.auth;

import com.google.inject.Inject;

import javax.servlet.http.HttpSession;

public class AuthServiceImpl implements AuthService {
    private static final String IS_LOGGED_IN = "isLoggedIn";
    private static final String USER = "user";

    private final HttpSession session;

    @Inject
    AuthServiceImpl(HttpSession session) {
        this.session = session;
    }

    @Override
    public boolean isLoggedIn() {
        Boolean isLoggedIn = (Boolean) session.getAttribute(IS_LOGGED_IN);
        if (isLoggedIn == null) {
            return false;
        }
        return isLoggedIn;
    }

    @Override
    public void login(String user) {
        session.setAttribute(USER, user);
        session.setAttribute(IS_LOGGED_IN, true);
    }

    @Override
    public void logout() {
        session.removeAttribute(IS_LOGGED_IN);
        session.removeAttribute(USER);
    }

    @Override
    public String getUser() {
        return (String) session.getAttribute(USER);
    }
}
