package cellularautomata;


import cellularautomata.logic.Grid;
import cellularautomata.logic.GameLogic;
import cellularautomata.logic.rules.Rules;
import cellularautomata.logic.rules.GameOfLifeRules;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class CellularAutomataTest {

    Grid grid;
    Grid grid2;
    Grid grid3;
    Grid grid4;
    GameLogic gl;
    GameLogic gl2;
    GameLogic gl3;
    GameLogic gl4;
    Rules r1;

    @Before
    public void setUp() {
        this.grid = new Grid(5, 5);
        this.grid2 = new Grid(new boolean[][]{{false, true, false},
        {false, true, false}});
        this.grid3 = new Grid(new boolean[][]{{false, true, true, false},
        {false, true, false, false},
        {false, true, false, false},
        {false, true, false, false}});
        this.grid4 = new Grid(new boolean[][]{{false, false, true, true, false}, // 0 0 1 1 0   0 1 1 1 0   0 1 1 1 0   0 1 1 1 1 
            {true, true, false, true, false},                                   //  1 1 0 1 0   1 0 0 1 0   1 0 0 1 1   1 0 0 0 1
            {false, true, true, false, false},                                 //   0 1 1 0 0   1 1 0 0 1   1 1 0 0 1   1 0 0 0 1
            {false, false, false, true, true}});                              //    0 0 0 1 1   0 0 1 1 0   0 1 1 1 0   1 1 1 1 0
        this.r1 = new GameOfLifeRules();
        this.gl = new GameLogic(grid, r1);
        this.gl2 = new GameLogic(grid2, r1);
        this.gl3 = new GameLogic(grid3, r1);
        this.gl4 = new GameLogic(grid4, r1);
    }

    @Test
    public void gridSizeIsCorrect() {
        assertThat(grid.size(), is(25));

    }

    @Test
    public void constructorValuesAreCorrect() {
        for (boolean[] row : grid.getStates()) {
            for (boolean state : row) {
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
        assertThat(grid2.getHeight(), is(3));
    }

    @Test
    public void constructorWithArrayCreatesArrayWithRightHeight() {
        assertThat(grid2.getWidth(), is(2));
    }

    @Test
    public void constructorWithArrayCreatesRightValues() {
        boolean[][] values = new boolean[][]{{false, true, false}, //  0   1   0
        {false, true, false}};//  0   1   0
        assertThat(values, is(grid2.getStates()));

    }

    @Test
    public void countsNeighbors() {
        assertThat(grid2.aliveNeighbors(0, 0), is(2));
    }

    @Test
    public void countsNeighbors2() {
        assertThat(grid2.aliveNeighbors(1, 1), is(1));
    }

    @Test
    public void testIfOutOfBounds() {
        assertThat(grid2.inBounds(0, 0), is(true));
    }

    @Test
    public void testIfOutOfBounds2() {
        assertThat(grid2.inBounds(1, 2), is(true));
    }

    @Test
    public void testIfOutOfBounds3() {
        assertThat(grid3.inBounds(4, 2), is(false));
    }

    @Test
    public void secondGenIsCorrect() {
        gl3.iterate();
        boolean[][] correct = new boolean[][]{{false, true, true, false},
        {true, true, false, false},
        {true, true, true, false},
        {false, false, false, false}};
        assertThat(gl3.getGrid().getStates(), is(correct));
    }
    
    @Test
    public void correctAfterSeveralIterations() {
        gl4.iterate();
        gl4.iterate();
        gl4.iterate();
        
        boolean[][] correct = new boolean[][]{{false, true, true, true, true},       //    0 1 1 1 1
                {true, false, false, false, true},                                  //     1 0 0 0 1 
                {true, false, false, false, true},                                 //      1 0 0 0 1
                {true, true, true, true, true}};                                 //       1 1 1 1 0
        assertThat(gl4.getGrid().getStates(), is(correct));
        
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
