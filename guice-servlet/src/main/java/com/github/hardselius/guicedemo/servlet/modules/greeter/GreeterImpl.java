package com.github.hardselius.guicedemo.servlet.modules.greeter;

import com.github.hardselius.guicedemo.servlet.modules.auth.AuthService;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class GreeterImpl implements Greeter {

    private final Provider<AuthService> authServiceProvider;

    @Inject
    GreeterImpl(Provider<AuthService> authServiceProvider) {
        this.authServiceProvider = authServiceProvider;
    }

    @Override
    public String greet() {
        AuthService authService = authServiceProvider.get();
        return "Hello, " + (authService.isLoggedIn() ? authService.getUser() : "Stranger") + "!";
    }
}
