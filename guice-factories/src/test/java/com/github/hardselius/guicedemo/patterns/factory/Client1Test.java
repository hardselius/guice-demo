package com.github.hardselius.guicedemo.patterns.factory;

import com.github.hardselius.guicedemo.patterns.DummyService;
import com.github.hardselius.guicedemo.patterns.Service;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class Client1Test {

    @Test
    public void testGo() throws Exception {
        Service previous = ServiceFactory.getInstance();
        ServiceFactory.setInstance(new DummyService());

        try {
            Client1 client1 = new Client1();
            Assertions.assertThat(client1.go())
                    .isTrue();
        } finally {
            ServiceFactory.setInstance(previous);
        }
    }
}