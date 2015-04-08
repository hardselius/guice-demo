package com.github.hardselius.guicedemo.servlet.modules.servlet;

import com.github.hardselius.guicedemo.servlet.modules.auth.AuthService;
import com.github.hardselius.guicedemo.servlet.modules.greeter.Greeter;
import com.google.common.base.Optional;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Singleton
public class DemoServlet extends HttpServlet {

    private final Greeter greeter;
    private final Provider<AuthService> authServiceProvider;

    @Inject
    DemoServlet(Greeter greeter, Provider<AuthService> authServiceProvider) {
        this.greeter = greeter;
        this.authServiceProvider = authServiceProvider;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getQueryString();

        Splitter paramSplitter = Splitter.on("&").omitEmptyStrings().trimResults();
        Splitter keyValueSplitter = Splitter.on("=").omitEmptyStrings().trimResults();

        Map<String, String> queryParams = paramSplitter.withKeyValueSeparator(keyValueSplitter).split(Optional.fromNullable(query).or(""));
        String loginUser = queryParams.get("login");
        if (!Strings.isNullOrEmpty(loginUser)) {
            authServiceProvider.get().login(loginUser);
        }


        resp.setContentType("text/plain");
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.print(greeter.greet());
    }
}
