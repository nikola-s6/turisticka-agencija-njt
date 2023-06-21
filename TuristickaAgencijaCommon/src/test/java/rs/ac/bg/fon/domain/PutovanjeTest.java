package rs.ac.bg.fon.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.ac.bg.fon.domain.util.Ponuda;
import rs.ac.bg.fon.domain.util.Prevoz;
import rs.ac.bg.fon.domain.util.Smestaj;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PutovanjeTest {

    private Putovanje putovanje;

    @BeforeEach
    void setUp() {
        this.putovanje = new Putovanje();
    }

    @AfterEach
    void tearDown() {
        this.putovanje = null;
    }

    @Test
    void setPutovanjeIDNula(){
        assertThrows(IllegalArgumentException.class, ()-> putovanje.setPutovanjeID(0));
    }

    @Test
    void setPutovanjeID() {
        putovanje.setPutovanjeID(1);
        assertEquals(1, putovanje.getPutovanjeID());
    }

    @Test
    void setNazivNull(){
        assertThrows(NullPointerException.class, ()-> putovanje.setNaziv(null));
    }

    @Test
    void setNazivPrazanString(){
        assertThrows(IllegalArgumentException.class, ()-> putovanje.setNaziv(""));
    }

    @Test
    void setNaziv() {
        putovanje.setNaziv("Krstarenje mediteranom");
        assertEquals("Krstarenje mediteranom", putovanje.getNaziv());
    }

    @Test
    void setPocetniGradNull(){
        assertThrows(NullPointerException.class,()-> putovanje.setPocetniGrad(null));
    }

    @Test
    void setPocetniGrad() {
        Grad pocetni = new Grad(1, "Beograd", "Srbija");
        putovanje.setPocetniGrad(pocetni);
        assertEquals(pocetni, putovanje.getPocetniGrad());
    }

    @Test
    void setKrajnjiGradNull(){
        assertThrows(NullPointerException.class, ()-> putovanje.setKrajnjiGrad(null));
    }

    @Test
    void setKrajnjiGrad() {
        Grad krajnji = new Grad(1, "Denver", "Kolorado");
        putovanje.setKrajnjiGrad(krajnji);
        assertEquals(krajnji, putovanje.getKrajnjiGrad());
    }

    @Test
    void setPrevozNull(){
        assertThrows(NullPointerException.class, ()->putovanje.setPrevoz(null));
    }

    @Test
    void setPrevoz() {
        putovanje.setPrevoz(Prevoz.AVION);
        assertEquals(Prevoz.AVION, putovanje.getPrevoz());
    }

    @Test
    void setSmestajNull(){
        assertThrows(NullPointerException.class, ()->putovanje.setSmestaj(null));
    }

    @Test
    void setSmestaj() {
        putovanje.setSmestaj(Smestaj.HOTEL);
        assertEquals(Smestaj.HOTEL, putovanje.getSmestaj());
    }

    @Test
    void setPonudaNull(){
        assertThrows(NullPointerException.class, ()->putovanje.setPonuda(null));
    }

    @Test
    void setPonuda() {
        putovanje.setPonuda(Ponuda.POLU_PANSION);
        assertEquals(Ponuda.POLU_PANSION, putovanje.getPonuda());
    }

    @Test
    void setKratakOpisNull(){
        assertThrows(NullPointerException.class, ()-> putovanje.setKratakOpis(null));
    }

    @Test
    void setKratakOpisPrazanString(){
        assertThrows(IllegalArgumentException.class, ()->putovanje.setKratakOpis(""));
    }

    @Test
    void setKratakOpis() {
        putovanje.setKratakOpis("Kratak opis putovanja");
        assertEquals("Kratak opis putovanja", putovanje.getKratakOpis());
    }

    @Test
    void setTerminiNull(){
        assertThrows(NullPointerException.class, ()->putovanje.setTermini(null));
    }

    @Test
    void setTermini() {
        Termin t1 = new Termin(1, 14_000.00, new Date(2023, Calendar.NOVEMBER, 9), new Date(2023, Calendar.NOVEMBER, 17), this.putovanje);
        Termin t2 = new Termin(2, 19_000.00, new Date(2023, Calendar.AUGUST, 9), new Date(2023, Calendar.AUGUST, 17), this.putovanje);

        putovanje.setTermini(List.of(t1, t2));
        assertEquals(2, putovanje.getTermini().size());
        assertEquals(t1, putovanje.getTermini().get(0));
        assertEquals(t2, putovanje.getTermini().get(1));
    }

    @Test
    void setUsputniGradoviNull(){
        assertThrows(NullPointerException.class, ()->putovanje.setUsputniGradovi(null));
    }

    @Test
    void setUsputniGradovi() {
        Grad g1 = new Grad(1, "Denver", "Kolorado");
        Grad g2 = new Grad(1, "Beograd", "Srbija");

        Usputni u1 = new Usputni(g1, this.putovanje, 1);
        Usputni u2 = new Usputni(g2, this.putovanje, 2);

        putovanje.setUsputniGradovi(List.of(u1,u2));
        assertEquals(2, putovanje.getUsputniGradovi().size());
        assertEquals(u1, putovanje.getUsputniGradovi().get(0));
        assertEquals(u2, putovanje.getUsputniGradovi().get(1));
        assertEquals(g1, putovanje.getUsputniGradovi().get(0).getGrad());
        assertEquals(g2, putovanje.getUsputniGradovi().get(1).getGrad());
    }
}