
package cellularautomata;

import cellularautomata.gui.GUI;
import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        GameLogic logic = initializeDefault();
        
        Application gui = new GUI();
        gui.launch(GUI.class);
        //käynnistetään GUI
        
//        
//        Grid grid3 = new Grid(new boolean[][] {{false, true, true, false},
//                                             {false, true, false, false},
//                                             {false, true, false, false},
//                                             {false, true, false, false}});
//        
//        GameLogic gl = new GameLogic(grid3, rules);
//        for (int i =0; i<grid3.getxSize();i++){
//            for (int j = 0; j < grid3.getySize(); j++) {
//                int n = gl.aliveNeighbors(i, j);
//                System.out.println(n);
//            }
//        }
//        
//        System.out.println(Arrays.deepToString(grid3.getStates()));    
//        gl.iterate();
//        System.out.println(Arrays.deepToString(grid3.getStates()));   
//        
        
    }
    
    public static GameLogic initializeDefault(){
        Grid grid = new Grid(50,50);
        Rules rules = new GameOfLifeRules();
        GameLogic logic = new GameLogic(grid, rules);
        return logic;
    } 
    
}
