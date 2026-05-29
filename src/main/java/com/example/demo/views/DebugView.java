package com.example.demo.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.security.AuthenticationContext;
import jakarta.annotation.security.PermitAll;
import org.springframework.security.core.context.SecurityContextHolder;

@Route(value = "debug", autoLayout = true)
@PermitAll
@Menu(title = "Debug", icon = "vaadin:bug", order = 100)
public class DebugView extends Main {

    DebugView() {
        var user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        add(new H1("Welcome: " + user));
    }
}
