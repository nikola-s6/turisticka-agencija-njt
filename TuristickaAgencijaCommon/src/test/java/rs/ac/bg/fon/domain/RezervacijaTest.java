package rs.ac.bg.fon.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import rs.ac.bg.fon.domain.util.Pol;
import rs.ac.bg.fon.domain.util.Ponuda;
import rs.ac.bg.fon.domain.util.Smestaj;
import rs.ac.bg.fon.domain.util.StatusRezervacije;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RezervacijaTest {

    private Rezervacija rezervacija;
    @BeforeEach
    void setUp() {
        this.rezervacija = new Rezervacija();
    }

    @AfterEach
    void tearDown() {
        this.rezervacija = null;
    }

    @Test
    void setPutnikNull(){
        assertThrows(NullPointerException.class, ()-> rezervacija.setPutnik(null));
    }

    @Test
    void setPutnik() {
        Putnik putnik = new Putnik(1, "Nikola", "Stojilkovic", Pol.MUSKI, "nikola.stojilkovic6@gmail.com", "0601111111", "sifra");
        rezervacija.setPutnik(putnik);
        assertEquals(putnik, rezervacija.getPutnik());
    }

    @Test
    void setPutovanjeNull(){
        assertThrows(NullPointerException.class, ()-> rezervacija.setPutovanje(null));
    }

    @Test
    void setPutovanje() {
        Putovanje putovanje = new Putovanje(1, "Obilazak Praga", new Grad(1, "Beograd", "Srbija"),
                new Grad(2, "Prag", "Ceska"), Smestaj.HOTEL, Ponuda.POLU_PANSION, "Obilazak grada Praga i svih njegovih znamenitosti.");

        rezervacija.setPutovanje(putovanje);
        assertEquals(putovanje, rezervacija.getPutovanje());
    }

    @Test
    void setTerminNull(){
        assertThrows(NullPointerException.class, ()-> rezervacija.setTermin(null));
    }

    @Test
    void setTermin() {
        Termin termin = new Termin();
        termin.setTerminID(1);
        termin.setCena(14_000.00);
        termin.setDatumPolaska(new Date(2023, Calendar.NOVEMBER, 9));
        termin.setDatumPovratka(new Date(2023, Calendar.NOVEMBER, 17));
        rezervacija.setTermin(termin);
        assertEquals(termin, rezervacija.getTermin());
    }

    @Test
    void setBrojRezervacijeNula(){
        assertThrows(IllegalArgumentException.class, ()-> rezervacija.setBrojRezervacije(0));
    }

    @Test
    void setBrojRezervacije() {
        rezervacija.setBrojRezervacije(1);
        assertEquals(1, rezervacija.getBrojRezervacije());
    }

    @Test
    void setStatusNull(){
        assertThrows(NullPointerException.class, ()-> rezervacija.setStatus(null));
    }

    @Test
    void setStatus() {
        rezervacija.setStatus(StatusRezervacije.AKTIVAN);
        assertEquals(StatusRezervacije.AKTIVAN, rezervacija.getStatus());
    }
}