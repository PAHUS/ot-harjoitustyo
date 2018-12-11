
package cellularautomata.dao;

import cellularautomata.logic.Grid;
import java.io.IOException;

public interface GridDao {
    Grid findGrid(String key) throws IOException;
    void saveGrid(String key, Grid object) throws IOException;
    void deleteGrid(String key) throws IOException;
}

