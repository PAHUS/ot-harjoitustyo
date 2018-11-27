package cellularautomata.gui;

import cellularautomata.logic.GameLogic;
import cellularautomata.logic.rules.GameOfLifeRules;
import cellularautomata.logic.Grid;
import cellularautomata.logic.rules.Rules;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {

    private GameLogic logic;
    private Rules rules;
    private Grid grid;
    private Button[][] buttons;

    @Override
    public void init() throws Exception {
        initializeDefault();

    }

    @Override
    public void start(Stage window) {
        window.setTitle("Cellular Automaton"); //Setup of stage settings
        window.centerOnScreen();

        BorderPane panel = new BorderPane();

        FlowPane actions = new FlowPane(); //Setting Buttons
        Button reset = new Button("Reset");
        reset.setOnAction((event) -> {
            initializeDefault();
            drawButtons();
        });
        Button next = new Button(">");
        next.setOnAction((event) -> {
            logic.iterate();
            drawButtons();
        });
        Button start = new Button("Start");
        actions.setHgap(3);
        actions.setVgap(5);
        actions.getChildren().add(reset);
        actions.getChildren().add(next);
        actions.getChildren().add(start);

        GridPane graphics = new GridPane(); //Making the grid
        //graphics.setGridLinesVisible(true);
        buttons = new Button[grid.getxSize()][grid.getySize()]; //wip
        for (int r = 0; r < grid.getxSize(); r++) {
            for (int c = 0; c < grid.getySize(); c++) {
                Button button = new Button();
                buttons[r][c] = button;
                final int rr = r;
                final int cc = c;
                button.setOnAction((event) -> {
                    grid.switchState(rr, cc);
                    drawButton(rr, cc);
                });

                button.setPrefSize(10, 10);
                graphics.add(button, c, r);
            }
        }
        drawButtons();
        panel.setBottom(actions);
        panel.setCenter(graphics);
        graphics.setPrefHeight(1000);
        graphics.setPrefWidth(700);
        graphics.gridLinesVisibleProperty();

        Scene defaultScene = new Scene(panel); //Initializing default scene
        window.setScene(defaultScene);
        window.show();

    }

    public static void main(String[] args) {
        launch(GUI.class);
    }

    public void drawButtons() {
        for (int r = 0; r < grid.getxSize(); r++) {
            for (int c = 0; c < grid.getySize(); c++) {
                drawButton(r, c);
            }
        }
    }

    public void drawButton(int x, int y) {
        boolean alive = grid.getCoordinate(x, y);
        Button button = buttons[x][y];
        String style = (alive) ? "-fx-base: CadetBlue;" : "-fx-base: LightGoldenRodYellow;";
        button.setStyle(style);
    }

    public void initializeDefault() {
        this.grid = new Grid(30, 30);
        this.rules = new GameOfLifeRules();
        this.logic = new GameLogic(grid, rules);

    }

}
