package rs.ac.bg.fon.controller;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import rs.ac.bg.fon.domain.*;
import rs.ac.bg.fon.domain.util.Pol;


class ControllerTest {

    static Controller controller = Controller.getInstance();


    @Test
    void zapamtiPutnikaKreiranje() throws Exception {
        Putnik p = new Putnik();
        p.setIme("Nikola");
        p.setPrezime("Stojilkovic");
        p.setPol(Pol.MUSKI);
        p.setEmail("nikola.stojilkovic6@gmail.com");
        p.setBrojTelefona("0601111111");
        p.setSifra("nikola123");
        Putnik sacuvan = controller.zapamtiPutnika(p);

        // ovime se izbegne da vrednosti budu iste zbog prenosa preko reference
        // a da zapravo u bazi bude drugacije
        Putnik dbPutnik = controller.ucitajPutnika(sacuvan);

        assertTrue(dbPutnik.getPutnikID() != 0);
        assertEquals(p.getIme(), dbPutnik.getIme());
        assertEquals(p.getPrezime(), dbPutnik.getPrezime());
        assertEquals(p.getPol(), dbPutnik.getPol());
        assertEquals(p.getEmail(), dbPutnik.getEmail());
        assertEquals(p.getBrojTelefona(), dbPutnik.getBrojTelefona());
        assertEquals(p.getSifra(), dbPutnik.getSifra());

        controller.obrisiPutnika(dbPutnik);
    }

    @Test
    void zapamtiPutnikaIzmena() throws Exception {
        Putnik p = new Putnik();
        p.setIme("Nikola");
        p.setPrezime("Stojilkovic");
        p.setPol(Pol.MUSKI);
        p.setEmail("nikola.stojilkovic6@gmail.com");
        p.setBrojTelefona("0601111111");
        p.setSifra("nikola123");
        Putnik zapamcen = controller.zapamtiPutnika(p);

        Putnik dbPutnik = controller.ucitajPutnika(zapamcen);

        dbPutnik.setIme("Promenjeno ime");

        Putnik izmenjen = controller.zapamtiPutnika(dbPutnik);

        Putnik dbPutnikIzmenjen = controller.ucitajPutnika(izmenjen);

        assertEquals("Promenjeno ime", dbPutnikIzmenjen.getIme());

        controller.obrisiPutnika(dbPutnikIzmenjen);
    }

    @Test
    void logovanje() throws Exception {
        Putnik p = new Putnik();
        p.setIme("Nikola");
        p.setPrezime("Stojilkovic");
        p.setPol(Pol.MUSKI);
        p.setEmail("nikola.stojilkovic6@gmail.com");
        p.setBrojTelefona("0601111111");
        p.setSifra("nikola123");
        controller.zapamtiPutnika(p);

        Putnik p1 = new Putnik();
        p.setEmail("nikola.stojilkovic6@gmail.com");
        p.setSifra("nikola123");

        Putnik dbPutnik = controller.logovanje(p);

        assertTrue(dbPutnik.getPutnikID() != 0);
        assertEquals("Nikola", dbPutnik.getIme());
        assertEquals("Stojilkovic", dbPutnik.getPrezime());
        assertEquals(Pol.MUSKI, dbPutnik.getPol());
        assertEquals(p.getEmail(), dbPutnik.getEmail());
        assertEquals("0601111111", dbPutnik.getBrojTelefona());
        assertEquals(Integer.toString(p.getSifra().hashCode()), dbPutnik.getSifra());

        controller.obrisiPutnika(dbPutnik);
    }



}