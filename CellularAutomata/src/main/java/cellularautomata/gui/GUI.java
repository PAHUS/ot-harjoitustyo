package cellularautomata.gui;

import cellularautomata.logic.GameLogic;
import cellularautomata.logic.rules.GameOfLifeRules;
import cellularautomata.logic.Grid;
import cellularautomata.logic.rules.Rules;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
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
        Scene defaultScene = new Scene(panel); //Initializing default scene
        defaultScene.getStylesheets().add("StyleSheet.css");

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
        for (int x = 0; x < grid.getxSize(); x++) {
            for (int y = 0; y < grid.getySize(); y++) {
                Button button = new Button();
                buttons[x][y] = button;
                final int xx = x;
                final int yy = y;
                button.setOnAction((event) -> {
                    grid.switchState(xx, yy);
                    drawButton(xx, yy);
                });
                graphics.add(button, x, y);
            }
        }
        drawButtons();
        panel.setBottom(actions);
        panel.setCenter(graphics);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        graphics.setPrefHeight(height/2);
        graphics.setPrefWidth(width/2);
        graphics.gridLinesVisibleProperty();

        
        window.setScene(defaultScene);
        window.show();

    }

    public static void main(String[] args) {
        launch(GUI.class);
    }

    public void drawButtons() {
        for (int x = 0; x < grid.getxSize(); x++) {
            for (int y = 0; y < grid.getySize(); y++) {
                drawButton(x, y);
            }
        }
    }

    public void drawButton(int x, int y) {
        boolean alive = grid.getCoordinate(x, y);
        Button button = buttons[x][y];
        String style = (alive) ? "-fx-base: CadetBlue; -fx-background-radius: 0em;" : "-fx-base: LightGoldenRodYellow; -fx-background-radius: 0em;";
        button.setStyle(style);
    }

    public void initializeDefault() {
        this.grid = new Grid(100, 25);
        this.rules = new GameOfLifeRules();
        this.logic = new GameLogic(grid, rules);

    }

}
