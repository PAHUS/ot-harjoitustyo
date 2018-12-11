/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellularautomata.dao;

import cellularautomata.logic.Grid;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Tande
 */
public class FileGridDaoTest {
    FileGridDao dao;
    Grid grid;
    
    @Before
    public void setUp() {
        dao = new FileGridDao();
        
        this.grid = new Grid(new boolean[][]{{false, true, false},
        {false, true, false}});
    }
    
    @Test
    public void loadAndSaveAreSame() throws IOException{
        dao.saveGrid("test", grid);
        Grid testGrid = dao.loadGrid("test");
        assertThat(grid.getStates(), is(testGrid.getStates()));
    }
    
    
}
