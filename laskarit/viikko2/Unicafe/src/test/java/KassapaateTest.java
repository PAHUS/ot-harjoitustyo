/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.unicafe.Kassapaate;
import com.mycompany.unicafe.Maksukortti;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class KassapaateTest {
    Kassapaate paate;
    Maksukortti kortti;
    Maksukortti kortti2;
    @Before
    public void setUp() {
        this.paate = new Kassapaate();
        this.kortti = new Maksukortti(700);
        this.kortti2 = new Maksukortti(100);
    }
    
    @Test
    public void konstruktoriToimii() {
        assertThat(paate.kassassaRahaa(), is(100000));
        assertThat(paate.edullisiaLounaitaMyyty(), is(0));
        assertThat(paate.maukkaitaLounaitaMyyty(), is(0));
    }
    
    @Test
    public void kateisostoToimii() {
        assertThat(paate.syoEdullisesti(300), is(60));
        assertThat(paate.kassassaRahaa(), is(100240));
        assertThat(paate.syoMaukkaasti(500), is(100));
        assertThat(paate.kassassaRahaa(), is(100640));
    }
    @Test
    public void kateisostoToimiiKunEiRahaa() {
        assertThat(paate.syoEdullisesti(100), is(100));
        
        assertThat(paate.syoMaukkaasti(100), is(100));
        assertThat(paate.kassassaRahaa(), is(100000));
    }
    @Test
    public void maksukorttiMaksuToimiiKunRahaa() {
        assertThat(paate.syoEdullisesti(kortti), is(true));
        assertThat(kortti.saldo(), is(460));
        
        assertThat(paate.syoMaukkaasti(kortti), is(true));
        assertThat(paate.kassassaRahaa(), is(100000));
        assertThat(kortti.saldo(), is(60));
    }
    
    @Test
    public void negRaha() {
        paate.lataaRahaaKortille(kortti, -2);
        assertThat(kortti.saldo(), is(700));
        assertThat(paate.kassassaRahaa(), is(100000));
          
//        assertThat(paate.lataaRahaaKortille(kortti,-2),is(assertNullthis)));
    }
    
    @Test
    public void maksukorttiMaksuToimiiKunEiRahaa() {
        assertThat(paate.syoEdullisesti(kortti2), is(false));
        assertThat(paate.kassassaRahaa(), is(100000));
        assertThat(kortti2.saldo(), is(100));
        
        assertThat(paate.syoMaukkaasti(kortti2), is(false));
        assertThat(paate.kassassaRahaa(), is(100000));
        assertThat(kortti2.saldo(), is(100));
    }
    
    @Test
    public void kortilleLatausToimii() {
        paate.lataaRahaaKortille(kortti2, 900);
        assertThat(paate.kassassaRahaa(), is(100900));
        assertThat(kortti2.saldo(), is(1000));
        
    }
    
    
    
    
}
