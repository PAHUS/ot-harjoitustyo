package cellularautomata.gui;

import cellularautomata.logic.GameLogic;
import cellularautomata.logic.rules.GameOfLifeRules;
import cellularautomata.logic.Grid;
import cellularautomata.logic.rules.Rules;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.net.URL;
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
        initializeGrid(100, 50);

    }

    @Override
    public void start(Stage window) {
        window.setTitle("Cellular Automaton"); //Setup of stage settings
        window.centerOnScreen();

        BorderPane panel = new BorderPane();
        Scene defaultScene = new Scene(panel); //Initializing default scene
        
        String css = getClass().getResource("/styleSheet.css").toExternalForm();
//        if(url == null){
//            System.out.println("Styles not found. Abort");
//            System.exit(-1);
//        }
//        String css = url.toExternalForm();
        defaultScene.getStylesheets().add(css);

        FlowPane actions = new FlowPane(); //Setting Buttons
        Button reset = new Button("Reset");
        reset.setOnAction((event) -> {
            resetGrid();
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
        panel.setBottom(actions);
        
        FlowPane sizeSet = new FlowPane(); //Setting Size buttons
        Button small = new Button("Small");
        small.setOnAction((event) -> {
            initializeGrid(40,20);
            start(window);
        });
        Button medium = new Button("Medium");
        medium.setOnAction((event) -> {
            initializeGrid(60,30);
            start(window);
        });
        Button large = new Button("Large");
        large.setOnAction((event) -> {
            initializeGrid(100,40);
            start(window);
        });
        sizeSet.setHgap(3);
        sizeSet.setVgap(5);
        sizeSet.getChildren().add(small);
        sizeSet.getChildren().add(medium);
        sizeSet.getChildren().add(large);
        panel.setTop(sizeSet);
        

        GridPane graphics = new GridPane(); //Making the grid
        //graphics.setGridLinesVisible(true);
        buttons = new Button[grid.getHeight()][grid.getWidth()]; //wip
        for (int x = 0; x < grid.getHeight(); x++) {
            for (int y = 0; y < grid.getWidth(); y++) {
                Button button = new Button();
                button.getStyleClass().add("tile");
                buttons[x][y] = button;
                button.setMinSize(15, 15);
                button.setMaxSize(15, 15);
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
        for (int x = 0; x < grid.getHeight(); x++) {
            for (int y = 0; y < grid.getWidth(); y++) {
                drawButton(x, y);
            }
        }
    }

    public void drawButton(int x, int y) {
        boolean alive = grid.getCoordinate(x, y);
        Button button = buttons[x][y];
        //String style = (alive) ? "-fx-base: CadetBlue; -fx-background-radius: 0em;" : "-fx-base: LightGoldenRodYellow; -fx-background-radius: 0em;";
        String style = (alive) ? "tile-alive" : "tile-dead";
        //button.setStyle(style);
        button.getStyleClass().removeAll("tile-alive", "tile-dead");
        button.getStyleClass().add(style);
        
    }

    public void initializeGrid(int width, int height) {
        this.grid = new Grid(width, height);
        this.rules = new GameOfLifeRules();
        this.logic = new GameLogic(grid, rules);

    }
    
    public void resetGrid(){
        int width = grid.getWidth();
        int height = grid.getHeight();
        initializeGrid(width, height);
    }

}
