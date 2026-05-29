package com.example.demo.views.component;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.spring.security.AuthenticationContext;

public class LogoutButton extends HorizontalLayout {
    public LogoutButton(AuthenticationContext authenticationContext) {
        Button logoutButton = new Button("Logout", VaadinIcon.SIGN_OUT.create());

        logoutButton.addClickListener(e -> authenticationContext.logout());

        add(logoutButton);
        setPadding(false);
        setSpacing(false);
    }
}
