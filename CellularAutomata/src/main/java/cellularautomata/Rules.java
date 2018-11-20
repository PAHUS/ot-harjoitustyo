
package cellularautomata;

public interface Rules {
    boolean nextState(boolean state, int neighbors);
}
