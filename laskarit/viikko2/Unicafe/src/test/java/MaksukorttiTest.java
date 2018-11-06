/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.unicafe.Maksukortti;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Tande
 */
public class MaksukorttiTest {
    Maksukortti kortti; 
    
    @Before
    public void setUp() {
        kortti = new Maksukortti(190);
    }
    
    @Test
    public void asettaaOikeanMaaran(){
        assertThat(kortti.toString(), is(equalTo("saldo: 1.90")));
    }
    @Test
    public void lataaminenPitaaOikeanMaaran(){
        kortti.lataaRahaa(150);
        assertThat(kortti.toString(), is(equalTo("saldo: 3.40")));
    }
    @Test
    public void saldoVahenee() {
        kortti.otaRahaa(100);
        assertThat(kortti.toString(), is(equalTo("saldo: 0.90")));
    }
    @Test
    public void saldoEiMuutuJosEiTarpeeksiRahaa(){
        kortti.otaRahaa(300);
        assertThat(kortti.toString(), is(equalTo("saldo: 1.90")));
    }
    @Test
    public void metodiPalauttaaTrueJosRahaa() {
        assertThat(kortti.otaRahaa(10), is(true));
    }
    @Test
    public void metodiPalauttaaFalseJosEiRahaa() {
        assertThat(kortti.otaRahaa(300), is(false));
    }
    @Test
    public void saldoToimii(){
        assertThat(kortti.saldo(), is(equalTo(190)));
    }
    
    
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//  
    
//    @After
//    public void tearDown() {
//    }
//    
    
//    
}
