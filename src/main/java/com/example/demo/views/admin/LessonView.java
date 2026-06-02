package com.example.demo.views.admin;

import com.example.demo.backend.domain.Lesson;
import com.example.demo.backend.service.LessonService;
import com.example.demo.backend.service.StageService;
import com.example.demo.views.form.LessonForm;
import com.example.demo.views.util.CustomCrudView;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@Route(value = "lesson", autoLayout = true)
@Menu(title = "Lesson", icon = "vaadin:book", order = 3)
@PermitAll
public class LessonView extends VerticalLayout {
    private final LessonService lessonService;
    private final StageService stageService;
    Grid<Lesson> lessonGrid = new Grid<>(Lesson.class);
    LessonForm form;

    LessonView(LessonService lessonService, StageService stageService){
        this.lessonService = lessonService;
        this.stageService = stageService;
        var layout = new HorizontalLayout();
        configureGrid();
        configureForm();
        layout.add(lessonGrid, form);
        layout.setSizeFull();
        add(layout);
    }

    private void configureGrid(){
        updateList();
    }

    private void configureForm(){
        form = new LessonForm(stageService);

    }

    private void updateList(){
        lessonGrid.setItems(lessonService.findAllLessons());
    }


}
