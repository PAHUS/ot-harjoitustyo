package cellularautomata.gui;

import cellularautomata.dao.FileGridDao;
import cellularautomata.dao.GridDao;
import cellularautomata.logic.GameLogic;
import cellularautomata.logic.rules.GameOfLifeRules;
import cellularautomata.logic.Grid;
import cellularautomata.logic.rules.Rules;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.IOException;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Handles the GUI of the Application
 * @author Tande
 */
public class GUI extends Application {

    private GameLogic logic;
    private Rules rules;
    private Grid grid;
    private Button[][] buttons;
    private boolean darkmode;
    private GridDao dao;

    /**
     * Initializes the default values of the application
     * @throws Exception 
     */
    @Override
    public void init() throws Exception {
        initializeGrid(100, 50);
        dao = new FileGridDao();
        darkmode = false;

    }

    /**
     * Defines the GUI
     * @param window 
     */
    @Override
    public void start(Stage window) {
        
        window.setTitle("Cellular Automaton"); // Setup of stage settings
        window.centerOnScreen();

        AnimationTimer timer = new AnimationTimer() { // Initializing Animation timer
            long prev = 0;
            @Override
            public void handle(long current) {
                if (current - prev < 100000000) {
                    return;
                }
                logic.iterate();
                drawButtons();
                this.prev = current;
            }
        };
        BorderPane panel = new BorderPane();
        Scene defaultScene = new Scene(panel); // Initializing default scene
        
        String css = getClass().getResource("/styleSheet.css").toExternalForm();
        defaultScene.getStylesheets().add(css);

        FlowPane actions = new FlowPane(); // Setting Buttons
        Button reset = new Button("Reset");
        reset.setOnAction((event) -> {
            timer.stop();
            resetGrid();
            start(window);
        });
        Button next = new Button(">");
        next.setOnAction((event) -> {
            timer.stop();
            logic.iterate();
            drawButtons();
        });
        
        
        Button start = new Button("Start");
        boolean on = false;
        start.setOnAction((event) -> {
            String text = start.getText();
            if(text.equals("Start")){
                timer.start();
                start.setText("Stop");
            }
            else{
                timer.stop();
                start.setText("Start");
            }
        });
        
        actions.setHgap(3);
        actions.setVgap(5);
        actions.getChildren().add(reset);
        actions.getChildren().add(next);
        actions.getChildren().add(start);
        panel.setBottom(actions);
        
        FlowPane sizeSet = new FlowPane(); //Setting Size buttons
        Button small = new Button("Small");
        small.setOnAction((event) -> {
            timer.stop();
            initializeGrid(40,30);
            start(window);
            window.centerOnScreen();
        });
        Button medium = new Button("Medium");
        medium.setOnAction((event) -> {
            timer.stop();
            initializeGrid(60,40);
            start(window);
            window.centerOnScreen();
        });
        Button large = new Button("Large");
        large.setOnAction((event) -> {
            timer.stop();
            initializeGrid(100,50);
            start(window);
            window.centerOnScreen();
        });
        Button invert = new Button("Invert Colors");
        invert.setOnAction((event) -> {
            darkmode = !darkmode;
            drawButtons();
        });
        Button save = new Button("Save"); //Move to different panel
        save.setOnAction((event) -> {
            try {
                dao.saveGrid("example", grid); 
                
            } catch (IOException exp) {
                //exp.printStackTrace(); //TODO
            } 
            
        });
        
        Button load = new Button("Load");
        load.setOnAction((event) -> {
            timer.stop();
            try{
                Grid grid = dao.loadGrid("example");
                initializeGrid(grid.getWidth(), grid.getHeight());
                this.grid = grid;
                this.logic = new GameLogic(grid, rules);
                start(window);
                window.centerOnScreen();
            } catch (IOException exp) {
                //exp.printStackTrace();
            }
        });
        
        sizeSet.setHgap(3);
        sizeSet.setVgap(5);
        sizeSet.getChildren().add(small);
        sizeSet.getChildren().add(medium);
        sizeSet.getChildren().add(large);
        
        sizeSet.getChildren().add(invert);
        sizeSet.getChildren().add(save);
        sizeSet.getChildren().add(load);
        
        panel.setTop(sizeSet);
        
        ScrollPane scrollable = new ScrollPane(); //Making a scrollpane into which embed the GridPane
        
        

        GridPane graphics = new GridPane(); //Making the grid
        graphics.isResizable();
        
        buttons = new Button[grid.getWidth()][grid.getHeight()]; //make smaller than grid???
        for (int x = 0; x < grid.getWidth(); x++) {
            for (int y = 0; y < grid.getHeight(); y++) {
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
        
        scrollable.setContent(graphics);
        panel.setCenter(scrollable);
        
        

        window.setMaxHeight(getScreenHeight());
        window.setMaxWidth(getScreenWidth());
        window.setScene(defaultScene);
        window.show();

    }

    public static void main(String[] args) {
        launch(GUI.class);
    }

    private void drawButtons() {
        for (int x = 0; x < grid.getWidth(); x++) {
            for (int y = 0; y < grid.getHeight(); y++) {
                drawButton(x, y);
            }
        }
    }

    private void drawButton(int x, int y) {
        boolean alive = grid.getCoordinate(x, y);
        Button button = buttons[x][y];
        String style;
        if(!darkmode){
            style = (alive) ? "-fx-base: CadetBlue; -fx-background-radius: 0em;" : "-fx-base: LightGoldenRodYellow; -fx-background-radius: 0em;";
        } else {
            style = (!alive) ? "-fx-base: CadetBlue; -fx-background-radius: 0em;" : "-fx-base: LightGoldenRodYellow; -fx-background-radius: 0em;";
        }
        
        button.setStyle(style);
        //        String style = "";
//        if(!darkmode){
//            style = (alive) ? "tile-alive" : "tile-dead";
//        } else{
//            style = (!alive) ? "tile-alive" : "tile-dead";
//        }
//        button.getStyleClass().removeAll("tile-alive", "tile-dead");
//        button.getStyleClass().add(style);
        
    }
    
    private double getScreenWidth(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return screenSize.getWidth();
    }
    
    private double getScreenHeight(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return screenSize.getHeight();
    }

    private void initializeGrid(int width, int height) {
        this.grid = new Grid(width, height);
        this.rules = new GameOfLifeRules();
        this.logic = new GameLogic(grid, rules);

    }
    
    private void resetGrid(){
        int height = grid.getHeight();
        int width = grid.getWidth();
        initializeGrid(width, height);
    }

   
}
