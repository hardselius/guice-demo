package com.github.hardselius.guicedemo.patterns.guice;

import com.github.hardselius.guicedemo.patterns.DummyService;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Client3Test {

    @Test
    public void testGo() throws Exception {
        Client3 client3 = new Client3(new DummyService());
        Assertions.assertThat(client3.go())
                .isTrue();
    }
}