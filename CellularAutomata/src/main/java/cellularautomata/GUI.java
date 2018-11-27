
package cellularautomata;
import cellularautomata.logic.GameLogic;
import cellularautomata.logic.rules.GameOfLifeRules;
import cellularautomata.logic.Grid;
import cellularautomata.logic.rules.Rules;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUI extends Application{
    private GameLogic logic;
    private Rules rules;
    private Grid grid;
   

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
        Button next = new Button(">");
        Button start = new Button("Start");
        actions.setHgap(3);
        actions.setVgap(5);
        actions.getChildren().add(reset);
        actions.getChildren().add(next);
        actions.getChildren().add(start);
        
        GridPane graphics = new GridPane(); //Making the grid
        //graphics.setGridLinesVisible(true);
        for (int r = 0; r < grid.getxSize(); r++) {
            for (int c = 0; c < grid.getySize(); c++) {
                Button button = new Button();
                button.autosize();
                //button.setBackground(new Background(new BackgroundFill(Color.WHEAT, CornerRadii.EMPTY, Insets.EMPTY)));
                //button.setPrefSize(20,20);
                graphics.add(button, c, r);
            }
    }
        panel.setBottom(actions);
        panel.setCenter(graphics);
        //graphics.setPrefHeight(700);
        //graphics.setPrefWidth(700);
        graphics.gridLinesVisibleProperty();
        
        
        
        Scene defaultScene = new Scene(panel); //Initializing default scene
        window.setScene(defaultScene);
        window.show();
       
    }
    public static void main(String[] args) {
        launch(GUI.class);
    }
    
    public void initializeDefault(){
        this.grid = new Grid(10,10);
        this.rules = new GameOfLifeRules();
        this.logic = new GameLogic(grid, rules);
        
    } 

}
