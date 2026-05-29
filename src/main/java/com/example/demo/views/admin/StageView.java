package com.example.demo.views.admin;

import com.example.demo.backend.domain.Stage;
import com.example.demo.backend.service.StageService;
import com.example.demo.views.form.StageForm;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@Route(value = "stage", autoLayout = true)
@Menu(title = "Stage", icon = "vaadin:flag", order = 2)
@PermitAll
public class StageView extends VerticalLayout {

    private final StageService stageService;
    Grid<Stage> stageGrid = new Grid<>(Stage.class);
    StageForm form;
    Button addStage = new Button("Add Stage");
    StageView(StageService stageService){
        this.stageService = stageService;
        addClassName("list-view");
        setSizeFull();

        configureGrid();
        configureForm();
        configureButton();
        VerticalLayout layout = new VerticalLayout();

        HorizontalLayout content = new HorizontalLayout(stageGrid, form);
        stageGrid.setWidth("0");
        form.setWidth("0");
        content.setFlexGrow(2, stageGrid);
        content.setFlexGrow(1, form);
        content.setSizeFull();
        layout.add(addStage, content);
        add(layout);
        updateList();
        closeEditor();

    }

    private void configureGrid() {
        stageGrid.setColumns("name", "title", "arabicTitle", "levelEquivalent", "orderIndex");
        stageGrid.getColumns().forEach(col -> col.setAutoWidth(true));
        stageGrid.asSingleSelect().addValueChangeListener(event -> editStage(event.getValue()));
    }

    private void configureForm() {
        form = new StageForm();
        form.getSave().setEnabled(false);
        form.getBinder().addStatusChangeListener(e -> form.getSave().setEnabled(form.getBinder().isValid()));
        form.getSave().addClickListener(event -> saveStage());
        form.getDelete().addClickListener(event -> deleteStage());
        form.getCancel().addClickListener(event -> closeEditor());
    }

    private void editStage(Stage stage) {
        if (stage == null) {
            closeEditor();
        } else {
            form.setStage(stage);
            form.setVisible(true);
            addClassName("editing");
        }
    }

    private void saveStage() {
        var validationStatus = form.getBinder().validate();
        if (validationStatus.isOk()) {
            Stage stage = form.getBinder().getBean();
            stageService.saveStage(stage);
            updateList();
            closeEditor();
        }
        else {
            Notification.show("Please fix the validation errors before submitting the form!");
        }
    }
    private void deleteStage()
    {
        Stage stage = form.getBinder().getBean();
        stageService.deleteStage(stage);
        updateList();
        closeEditor();
    }

    private void closeEditor() {
        form.setStage(null);
        form.setVisible(false);
        removeClassName("editing");
    }
    private void updateList() {
        stageGrid.setItems(stageService.findAllStages());
    }
    private void configureButton() {
        addStage.addThemeVariants(ButtonVariant.AURA_PRIMARY);
        addStage.addClickListener(event -> addStage());
    }
    private void addStage() {
        form.setStage(new Stage());
        form.setVisible(true);
        addClassName("editing");
    }

}
