/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cellularautomata.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class CellularAutomataTest {
    Grid grid;
    Grid grid2;
    GameLogic gl;
    GameLogic gl2;
    Rules r1;
    
    @Before
    public void setUp() {
        this.grid = new Grid(5,5);
        this.grid2 = new Grid(new boolean[][] {{false,true,false},
                                                {false,true,false}}); 
        this.r1 = new GameOfLifeRules();
        this.gl = new GameLogic(grid, r1);
        this.gl2 = new GameLogic(grid2, r1);
    }
    
    
    @Test
    public void gridSizeIsCorrect() {
        assertThat(grid.size(), is(25));
        
    }
    
    @Test
    public void constructorValuesAreCorrect() {
        for(boolean[] row : grid.getStates()){
            for(boolean state : row){
                assertThat(state, is(false));
            }
    }
    }
    
    @Test
    public void constructorWithArrayCreatesArrayWithRightSize() {
        assertThat(grid2.size(), is(6));
    }
    
    @Test
    public void constructorWithArrayCreatesArrayWithRightWidth() {
        assertThat(grid2.getxSize(), is(2));
    }
    
    @Test
    public void constructorWithArrayCreatesArrayWithRightHeight() {
        assertThat(grid2.getySize(), is(3));
    }
    
    @Test
    public void constructorWithArrayCreatesRightValues() {
        boolean[][] values = new boolean[][] {{false,true,false},   //  0   0
                                                {false,true,false}};//  1   1
                                                                    //  0   0
        assertThat(values, is(grid2.getStates()));
        
    }
    
    @Test
    public void countsNeighbors() {
        assertThat(gl2.aliveNeighbors(0, 0),is(2));
    }
    @Test
    public void countsNeighbors2() {
        assertThat(gl2.aliveNeighbors(1, 1),is(1));
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
