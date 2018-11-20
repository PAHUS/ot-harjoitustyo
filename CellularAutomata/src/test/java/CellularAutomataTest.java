/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cellularAutomata.Grid;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Tande
 */
public class CellularAutomataTest {
    
    public CellularAutomataTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Test
    public void gridSizeIsCorrect() {
        Grid grid = new Grid(5,5);
        assertThat(grid.size(), is(25));
    }
    
    
    /*
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }*/

}
