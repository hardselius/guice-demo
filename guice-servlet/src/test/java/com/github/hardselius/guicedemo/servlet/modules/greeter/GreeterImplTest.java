package com.github.hardselius.guicedemo.servlet.modules.greeter;

import com.github.hardselius.guicedemo.servlet.modules.auth.AuthService;
import com.google.inject.*;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class GreeterImplTest {

    private Injector injector;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector(
                new AbstractModule() {
                    @Override
                    protected void configure() {
                        bind(Greeter.class).to(GreeterImpl.class);
                    }

                    @Provides @Singleton
                    public AuthService provideAuthService() {
                        return new AuthDummy();
                    }
                }
        );
    }

    @Test
    public void testGreetNotLoggedIn() throws Exception {


        Greeter greeter = injector.getInstance(Greeter.class);
        Assertions.assertThat(greeter.greet())
                .isEqualTo("Hello, Stranger!");
    }

    @Test
    public void testGreetLoggedIn() throws Exception {
        Provider<AuthService> authService = injector.getProvider(AuthService.class);
        Greeter greeter = injector.getInstance(Greeter.class);

        authService.get().login("Someone Special");
        Assertions.assertThat(greeter.greet())
                .isEqualTo("Hello, Someone Special!");

        authService.get().logout();
        Assertions.assertThat(greeter.greet())
                .isEqualTo("Hello, Stranger!");
    }

    private static class AuthDummy implements AuthService {
        private String user;
        private boolean isLoggedIn = false;

        @Override
        public boolean isLoggedIn() {
            return isLoggedIn;
        }

        @Override
        public void login(String user) {
            this.user = user;
            this.isLoggedIn = true;
        }

        @Override
        public void logout() {
            this.isLoggedIn = false;
        }

        @Override
        public String getUser() {
            return user;
        }
    }
}