package rs.ac.bg.fon.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.ac.bg.fon.domain.util.Ponuda;
import rs.ac.bg.fon.domain.util.Smestaj;

import static org.junit.jupiter.api.Assertions.*;

class UsputniTest {

    private Usputni usputni;

    @BeforeEach
    void setUp() {
        this.usputni = new Usputni();
    }

    @AfterEach
    void tearDown() {
        this.usputni = null;
    }

    @Test
    void setGradNull(){
        assertThrows(NullPointerException.class, ()->usputni.setGrad(null));
    }

    @Test
    void setGrad() {
        Grad grad = new Grad(2, "Prag", "Ceska");
        usputni.setGrad(grad);
        assertEquals(grad, usputni.getGrad());
    }

    @Test
    void setPutoavnjeNull(){
        assertThrows(NullPointerException.class, ()->usputni.setPutovanje(null));
    }


    @Test
    void setPutovanje() {
        Putovanje putovanje = new Putovanje(1, "Krstarenje mediteranom", new Grad(1, "Beograd", "Srbija"), new Grad(2, "Palermo", "Italija"), Smestaj.HOTEL, Ponuda.POLU_PANSION, "Kratak opis putovanja");
        usputni.setPutovanje(putovanje);
        assertEquals(putovanje, usputni.getPutovanje());
    }

    @Test
    void setRedniBrojNula(){
        assertThrows(IllegalArgumentException.class,()->usputni.setRedniBroj(0));
    }

    @Test
    void setRedniBroj() {
        usputni.setRedniBroj(1);
        assertEquals(1, usputni.getRedniBroj());
    }
}