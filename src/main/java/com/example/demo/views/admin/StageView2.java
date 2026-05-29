package com.example.demo.views.admin;

import com.example.demo.backend.domain.Stage;
import com.example.demo.backend.service.StageService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.dataview.GridListDataView;
import com.vaadin.flow.component.grid.dnd.GridDropLocation;
import com.vaadin.flow.component.grid.dnd.GridDropMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

import java.util.ArrayList;
import java.util.List;

@Route(value = "stage-drag-drop", autoLayout = true)
@PermitAll
public class StageView2 extends VerticalLayout {
    private Stage draggedStage;
    private final StageService stageService;

    public StageView2(StageService stageService) {
        this.stageService = stageService;

        Grid<Stage> stageGrid = setupGrid();
        List<Stage> stages = new ArrayList<>(stageService.findAllStages());
        GridListDataView<Stage> dataView = stageGrid.setItems(stages);
        stageGrid.setRowsDraggable(true);
        stageGrid.addDragStartListener(e -> {
            draggedStage = e.getDraggedItems().get(0);
            stageGrid.setDropMode(GridDropMode.BETWEEN);
        });

        stageGrid.addDropListener(e -> {
            Stage targetStage = e.getDropTargetItem().orElse(null);
            GridDropLocation dropLocation = e.getDropLocation();

            boolean stageWasDroppedOntoItself = draggedStage.equals(targetStage);

            if(targetStage == null || stageWasDroppedOntoItself)
                return;

            dataView.removeItem(draggedStage);

            if (dropLocation == GridDropLocation.BELOW)
            {
                dataView.addItemAfter(draggedStage, targetStage);
            } else {
                dataView.addItemBefore(draggedStage, targetStage);
            }
        });

        stageGrid.addDragEndListener(e -> {
            draggedStage = null;
            stageGrid.setDropMode(null);
        });

        add(stageGrid);
    }

    private static Grid<Stage> setupGrid() {
        Grid<Stage> stageGrid = new Grid<>(Stage.class, false);
        stageGrid.addColumn(Stage::getName).setHeader("Name");
        stageGrid.addColumn(Stage::getArabicTitle).setHeader("Arabic Title");
        stageGrid.addColumn(Stage::getLevelEquivalent).setHeader("Level Equivalent");
        stageGrid.addColumn(Stage::getOrderIndex).setHeader("Order Index");
        return stageGrid;
    }
}
