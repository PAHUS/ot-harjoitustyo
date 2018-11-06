
import Maksukortti.Maksukortti;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;
    Maksukortti kortti2;
    Maksukortti kortti3;
    Maksukortti kortti4;
    
    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
        kortti2 = new Maksukortti(2);
        kortti3 = new Maksukortti(2.5);
        kortti4 = new Maksukortti(4);
    }

    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }

    @Test
    public void syoEdullisestiVahentaaSaldoaOikein() {
        kortti.syoEdullisesti();
        assertEquals("Kortilla on rahaa 7.5 euroa", kortti.toString());
    }

    @Test
    public void syoMaukkaastiVahentaaSaldoaOikein() {
        kortti.syoMaukkaasti();
        assertEquals("Kortilla on rahaa 6.0 euroa", kortti.toString());
    }

    @Test
    public void syoEdullisestiEiVieSaldoaNegatiiviseksi() {
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        kortti.syoEdullisesti();
        assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
    }

    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(25);
        assertEquals("Kortilla on rahaa 35.0 euroa", kortti.toString());
    }

    @Test
    public void kortinSaldoEiYlitaMaksimiarvoa() {
        kortti.lataaRahaa(200);
        assertEquals("Kortilla on rahaa 150.0 euroa", kortti.toString());
    }
    
    @Test
    public void suoMaukkaastiEiVieSaldoaNegatiiviseksi() {
        kortti2.syoMaukkaasti();
        assertThat(kortti2.toString(), is(equalTo("Kortilla on rahaa 2.0 euroa")));
    }
    
    public void negatiivisendSummanLataaminenEiMuutaSaldoa() {
        kortti.lataaRahaa(-2);
        assertThat(kortti.toString(), is(equalTo("Kortilla on rahaa 10.0 euroa")));
    }
    
    public void riittavastiRahaaEdulliseenLounaaseen(){
        kortti3.syoEdullisesti();
        assertThat(kortti.toString(), is(equalTo("Kortilla on rahaa 0.0 euroa")));
    }
    
    public void riittavastiRahaaMaukkaaseenLounaaseen(){
        kortti4.syoMaukkaasti();
        assertThat(kortti.toString(), is(equalTo("Kortilla on rahaa 0.0 euroa")));
    }
    
    
    
}