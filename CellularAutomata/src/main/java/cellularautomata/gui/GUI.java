
package cellularautomata.gui;
import cellularautomata.GameLogic;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class GUI extends Application{
    private GameLogic logic;
   

    @Override
    public void init() throws Exception {
        super.init(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public void start(Stage window) {
        window.setTitle("Cellular Automaton"); //Setup of stage settings
        window.centerOnScreen();
        
        
        Button reset = new Button("Reset"); //Setup of Layout 
        Button next = new Button(">");
        Button start = new Button("Start");
        FlowPane components = new FlowPane();
        components.setHgap(3);
        components.setVgap(5);
        components.getChildren().add(reset);
        components.getChildren().add(next);
        components.getChildren().add(start);
        
        
        
        Scene defaultScene = new Scene(components); //Initializing default scene
        window.setScene(defaultScene);
        window.show();
        
        
        
    }

}
