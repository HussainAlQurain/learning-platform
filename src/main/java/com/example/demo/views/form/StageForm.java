package com.example.demo.views.form;

import com.example.demo.backend.domain.Stage;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.RegexpValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import lombok.Data;

@Data
public class StageForm extends FormLayout {
    // 1. Define UI components
    TextField name = new TextField("Name");
    TextField title = new TextField("Title");
    TextField arabicTitle = new TextField("Arabic Title");
    TextField levelEquivalent = new TextField("Level Equivalent");
    IntegerField orderIndex = new IntegerField("Order Index");

    Button save = new Button("Save");
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete");

    // 2. The binder connects to the UI to the stage class
    Binder<Stage> binder = new BeanValidationBinder<>(Stage.class);

    public StageForm() {
        addClassName("stage-form");
        binder.bindInstanceFields(this);
//        binder.forField(name).asRequired("Name is required").bind("name");
//        binder.forField(arabicTitle)
//                .withValidator(new RegexpValidator(
//                        "Only arabic characters are allowed",
//                        "^[\\u0600-\\u06FF\\s]*$"
//                )).bind("arabicTitle");
        // use the binder to automatically bind the form to the stage class
        add(name, title, arabicTitle, levelEquivalent, orderIndex, save, cancel, delete);
    }

    public void setStage(Stage stage) {
        binder.setBean(stage);
    }
}
