package com.github.hardselius.guicedemo.servlet.modules.auth;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.servlet.RequestScoped;

import javax.servlet.http.HttpSession;

public class AuthModule extends AbstractModule {
    @Override
    protected void configure() {
    }

    @Provides @RequestScoped
    public AuthService provideAuthService(HttpSession session) {
        return new AuthServiceImpl(session);
    }
}
