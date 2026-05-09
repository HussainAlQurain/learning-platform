package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class HomeView extends VerticalLayout {

    public HomeView() {
        add(new H1("Welcome to your new application"));
        add(new Button("Say Hello", event -> add(new Paragraph("Hello, World"))));
    }
}