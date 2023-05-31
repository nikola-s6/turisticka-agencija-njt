package rs.ac.bg.fon.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.ac.bg.fon.domain.util.Pol;
import rs.ac.bg.fon.domain.util.Ponuda;
import rs.ac.bg.fon.domain.util.Smestaj;
import rs.ac.bg.fon.domain.util.StatusRezervacije;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TerminTest {

    private Termin termin;

    @BeforeEach
    void setUp() {
        this.termin = new Termin();
    }

    @AfterEach
    void tearDown() {
        this.termin = null;
    }

    @Test
    void setTerminID() {
        termin.setTerminID(1);
        assertEquals(1, termin.getTerminID());
    }

    @Test
    void setCena() {
        termin.setCena(10_000.00);
        assertEquals(10_000.00, termin.getCena());
    }

    @Test
    void setDatumPolaska() {
        Date datum = new Date(2023, Calendar.JUNE, 11);
        termin.setDatumPolaska(datum);
        assertEquals(datum, termin.getDatumPolaska());
    }

    @Test
    void setDatumPovratka() {
        Date datum = new Date(2023, Calendar.JUNE, 11);
        termin.setDatumPovratka(datum);
        assertEquals(datum, termin.getDatumPovratka());
    }

    @Test
    void setPutovanje() {
        Putovanje putovanje = new Putovanje(1, "Obilazak Praga", new Grad(1, "Beograd", "Srbija"),
                new Grad(2, "Prag", "Ceska"), Smestaj.HOTEL, Ponuda.POLU_PANSION, "Obilazak grada Praga i svih njegovih znamenitosti.");
        termin.setPutovanje(putovanje);
        assertEquals(putovanje, termin.getPutovanje());
    }

    @Test
    void setRezervacije() {
        Putovanje putovanje = new Putovanje(1, "Krstarenje mediteranom", new Grad(1, "Beograd", "Srbija"), new Grad(2, "Palermo", "Italija"), Smestaj.HOTEL, Ponuda.POLU_PANSION, "Kratak opis putovanja");
        Rezervacija r1 = new Rezervacija(
                new Putnik(1, "Nikola", "Stojilkovic", Pol.MUSKI, "nikola.stojilkovic6@gmail.com", "0601111111", "sifra"),
                putovanje,
                new Termin(1, 12_000.00, new Date(2023,7,13), new Date(2023, 7, 24), putovanje),
                1,
                StatusRezervacije.AKTIVAN
        );

        Rezervacija r2 = new Rezervacija(
                new Putnik(2, "Marko", "Nikolic", Pol.MUSKI, "nikola.stojilkovic6@gmail.com", "0601111111", "sifra"),
                putovanje,
                new Termin(1, 12_000.00, new Date(2023,7,13), new Date(2023, 7, 24), putovanje),
                1,
                StatusRezervacije.AKTIVAN
        );

        List<Rezervacija> rezervacije = List.of(r1, r2);

        termin.setRezervacije(rezervacije);

        assertEquals(2, termin.getRezervacije().size());
        assertEquals(r1, termin.getRezervacije().get(0));
        assertNotEquals(termin.getRezervacije().get(1), r1);
    }
}