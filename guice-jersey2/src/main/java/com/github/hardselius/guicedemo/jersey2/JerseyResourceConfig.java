package com.github.hardselius.guicedemo.jersey2;

import com.github.hardselius.guicedemo.jersey2.resources.HelloWorldResource;
import com.google.inject.Injector;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import javax.inject.Inject;

public class JerseyResourceConfig extends ResourceConfig {

    @Inject
    public JerseyResourceConfig(ServiceLocator serviceLocator) {
        register(HelloWorldResource.class);

        createBiDirectionalGuiceBridge(serviceLocator);
    }

    private Injector createBiDirectionalGuiceBridge(ServiceLocator serviceLocator) {
        Injector injector = GuiceServletConfig.getInjectorInstance();
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge g2h = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        g2h.bridgeGuiceInjector(injector);
        return injector;
    }
}
