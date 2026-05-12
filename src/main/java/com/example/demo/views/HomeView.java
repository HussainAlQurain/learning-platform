package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class HomeView extends VerticalLayout {

    public HomeView() {
        add(new H1("Welcome to your new application"));
        var nameField = new TextField("What is your name?");
        add(nameField);
        Paragraph paragraph = new Paragraph();
        add(paragraph);
        add(new Button("Say Hello", event -> paragraph.setText("Hello " + nameField.getValue())));
    }
}