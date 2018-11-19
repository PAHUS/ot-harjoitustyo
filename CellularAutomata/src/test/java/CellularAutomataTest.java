/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cellularAutomata.Main;
import static org.hamcrest.CoreMatchers.is;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testMethod() {
        assertThat(Main.hello(), is("Hello World"));
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
