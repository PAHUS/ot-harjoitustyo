
package cellularautomata;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(5,5);
        Rules rules = new GameOfLifeRules();
        GameLogic logic = new GameLogic(grid, rules);
        System.out.println("Hellou");
        
        
        
    }
    
    
    
    
}
