package com.github.hardselius.guicedemo.patterns.dibyhand;

import com.github.hardselius.guicedemo.patterns.DummyService;
import com.github.hardselius.guicedemo.patterns.factory.Client1;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class Client2Test {

    @Test
    public void testGo() throws Exception {
        Client2 client2 = new Client2(new DummyService());
        Assertions.assertThat(client2.go())
                .isTrue();
    }
}