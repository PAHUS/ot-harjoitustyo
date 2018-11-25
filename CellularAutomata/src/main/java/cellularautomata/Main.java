
package cellularautomata;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(20,20);
        Rules rules = new GameOfLifeRules();
        GameLogic logic = new GameLogic(grid, rules);
        System.out.println("Hellou");
        
        
        Grid grid3 = new Grid(new boolean[][] {{false, true, true, false},
                                             {false, true, false, false},
                                             {false, true, false, false},
                                             {false, true, false, false}});
        
        GameLogic gl = new GameLogic(grid3, rules);
        for (int i =0; i<grid3.getxSize();i++){
            for (int j = 0; j < grid3.getySize(); j++) {
                int n = gl.aliveNeighbors(i, j);
                System.out.println(n);
            }
        }
        
        System.out.println(Arrays.deepToString(grid3.getStates()));    
        gl.iterate();
        System.out.println(Arrays.deepToString(grid3.getStates()));   
        
        
        
    }
    
    
    
    
}
