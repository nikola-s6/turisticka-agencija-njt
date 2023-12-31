package rs.ac.bg.fon.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rs.ac.bg.fon.domain.util.Pol;
import rs.ac.bg.fon.domain.util.Ponuda;
import rs.ac.bg.fon.domain.util.Smestaj;
import rs.ac.bg.fon.domain.util.StatusRezervacije;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PutnikTest {

    private Putnik putnik;
    @BeforeEach
    void setUp() {
        this.putnik = new Putnik();
    }

    @AfterEach
    void tearDown() {
        this.putnik = null;
    }

    @Test
    void setPutnikIDKadaJeNula(){
        assertThrows(IllegalArgumentException.class, ()-> putnik.setPutnikID(0));
    }

    @Test
    void setPutnikID() {
        putnik.setPutnikID(1);
        assertEquals(1, putnik.getPutnikID());
    }

    @Test
    void setImeNull(){
        assertThrows(NullPointerException.class, ()->putnik.setIme(null));
    }

    @Test
    void setImeDuzinaManjaOdJedan(){
        assertThrows(IllegalArgumentException.class, ()-> putnik.setIme(""));
        assertThrows(IllegalArgumentException.class, ()-> putnik.setIme("M"));
    }

    @Test
    void setImeMaloSlovo(){
        assertThrows(IllegalArgumentException.class, ()-> putnik.setIme("nikola"));
    }

    @Test
    void setIme() {
        putnik.setIme("Nikola");
        assertEquals("Nikola", putnik.getIme());
    }

    @Test
    void setPrezimeNull(){
        assertThrows(NullPointerException.class, ()->putnik.setPrezime(null));
    }

    @Test
    void setPrezimeDuzinaManjaOdJedan(){
        assertThrows(IllegalArgumentException.class, ()-> putnik.setPrezime(""));
        assertThrows(IllegalArgumentException.class, ()-> putnik.setPrezime("M"));
    }

    @Test
    void setPrezimeMaloSlovo(){
        assertThrows(IllegalArgumentException.class, ()-> putnik.setPrezime("stojilkovic"));
    }

    @Test
    void setPrezime() {
        putnik.setPrezime("Stojilkovic");
        assertEquals("Stojilkovic", putnik.getPrezime());
    }

    @Test
    void setPol() {
        putnik.setPol(Pol.MUSKI);
        assertEquals(Pol.MUSKI, putnik.getPol());
    }

    @Test
    void setEmailNull(){
        assertThrows(NullPointerException.class, () -> putnik.setEmail(null));
    }

    @Test
    void setEmailPrazanString(){
        assertThrows(IllegalArgumentException.class, () -> putnik.setEmail(""));
    }

    @Test
    void setEmailGreske(){
        assertThrows(IllegalArgumentException.class, () -> putnik.setEmail("nikola"));
        assertThrows(IllegalArgumentException.class, () -> putnik.setEmail("nikola@"));
        assertThrows(IllegalArgumentException.class, () -> putnik.setEmail("nikola@gmail"));
        assertThrows(IllegalArgumentException.class, () -> putnik.setEmail("@gmail.com"));
    }

    @Test
    void setEmail() {
        putnik.setEmail("nikola.stojilkovic6@gmail.com");
        assertEquals("nikola.stojilkovic6@gmail.com", putnik.getEmail());
    }

    @Test
    void setBrojTelefonaNull(){
        assertThrows(NullPointerException.class, ()-> putnik.setBrojTelefona(null));
    }

    @Test
    void setBrojTelefonaPrazanString(){
        assertThrows(IllegalArgumentException.class, ()-> putnik.setBrojTelefona(""));
    }

    @Test
    void setBrojTelefona() {
        putnik.setBrojTelefona("0601111111");
        assertEquals("0601111111", putnik.getBrojTelefona());
    }

    @Test
    void setSifraNull(){
        assertThrows(NullPointerException.class, ()-> putnik.setSifra(null));
    }

    @Test
    void setSifraNedovoljnaDuzina(){
        assertThrows(IllegalArgumentException.class, ()-> putnik.setSifra("as"));
        assertThrows(IllegalArgumentException.class, ()-> putnik.setSifra("asd"));
    }

    @Test
    void setSifra() {
        putnik.setSifra("sifra");
        assertEquals("sifra", putnik.getSifra());
    }

    @Test
    void setRezervacijeNull(){
        assertThrows(NullPointerException.class, ()->putnik.setRezervacije(null));
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
        putnik.setRezervacije(rezervacije);

        assertEquals(2, putnik.getRezervacije().size());
        assertEquals(r1, putnik.getRezervacije().get(0));
        assertNotEquals(putnik.getRezervacije().get(1), r1);
    }

    @Test
    void testToString() {
        putnik.setPutnikID(1);
        putnik.setIme("Nikola");
        putnik.setPrezime("Stojilkovic");
        putnik.setPol(Pol.MUSKI);
        putnik.setBrojTelefona("0601111111");
        putnik.setEmail("nikola.stojilkovic6@gmail.com");

        String str = putnik.toString();
        assertTrue(str.contains("1"));
        assertTrue(str.contains("Nikola"));
        assertTrue(str.contains("Stojilkovic"));
        assertTrue(str.contains("0601111111"));
        assertTrue(str.contains("nikola.stojilkovic6@gmail.com"));
        assertTrue(str.contains(Pol.MUSKI.toString().toLowerCase()));
    }
}