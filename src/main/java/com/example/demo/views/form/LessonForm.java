package com.example.demo.views.form;

import com.example.demo.backend.domain.Lesson;
import com.example.demo.backend.domain.Stage;
import com.example.demo.backend.service.StageService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;

public class LessonForm extends FormLayout {

    private final StageService stageService;
    ComboBox<Stage> stage = new ComboBox<>("Stage");
    IntegerField orderIndex = new IntegerField("Order Index");



    Button save = new Button("Save");
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete");
    Binder<Lesson> binder = new BeanValidationBinder<>(Lesson.class);

    public LessonForm(StageService stageService) {
        this.stageService = stageService;
        binder.bindInstanceFields(this);
        stage.setItems(stageService.findAllStages());
//        stage.setItemLabelGenerator(s -> s.getName());
        // Add stuff
        add(stage, orderIndex, save, cancel, delete);
    }

    public void setLesson(Lesson lesson) {
        binder.setBean(lesson);
    }
}
