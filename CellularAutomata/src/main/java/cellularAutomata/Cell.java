
package cellularAutomata;

public class Cell {
    private boolean value;
    private boolean nextValue;

    public Cell(boolean value) {
        this.value = value;
        this.nextValue = false;
    }
    
    public void iterate(){
        this.value = this.nextValue;
        this.nextValue = false;
    }

    public void setNextValue(boolean nextValue) {
        this.nextValue = nextValue;
    }
    
    
    
    
    
    
    
}
