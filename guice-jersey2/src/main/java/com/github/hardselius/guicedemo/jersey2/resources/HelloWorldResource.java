package com.github.hardselius.guicedemo.jersey2.resources;

import com.github.hardselius.guicedemo.jersey2.modules.GreetingsService;
import com.google.common.base.Strings;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldResource {

    private final GreetingsService greeting;
    private final GreetingsService special;

    @Inject
    public HelloWorldResource(
            GreetingsService greeting,
            @Named("special") GreetingsService special) {
        this.greeting = greeting;
        this.special = special;
    }


    @GET
    @Produces("text/plain")
    public Response sayHello(@QueryParam("name") String name) {
        if (Strings.isNullOrEmpty(name)) {
            return Response.ok(formatGreeting(greeting.greeting())).build();
        }
        if (name.equalsIgnoreCase("special")) {
            return Response.ok(formatGreeting(special.greeting())).build();
        }
        return Response.ok(formatGreeting(name)).build();
    }

    private String formatGreeting(String who) {
        return String.format("Hello, %s!", who);
    }
}
