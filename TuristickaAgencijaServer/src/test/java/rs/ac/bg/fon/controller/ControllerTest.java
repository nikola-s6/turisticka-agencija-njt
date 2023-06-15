package rs.ac.bg.fon.controller;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import rs.ac.bg.fon.domain.*;
import rs.ac.bg.fon.domain.util.Pol;
import rs.ac.bg.fon.domain.util.Ponuda;
import rs.ac.bg.fon.domain.util.Prevoz;
import rs.ac.bg.fon.domain.util.Smestaj;

import java.util.List;


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
        assertEquals(sacuvan.getPutnikID(), dbPutnik.getPutnikID());
        assertEquals(sacuvan.getIme(), dbPutnik.getIme());
        assertEquals(sacuvan.getPrezime(), dbPutnik.getPrezime());
        assertEquals(sacuvan.getPol(), dbPutnik.getPol());
        assertEquals(sacuvan.getEmail(), dbPutnik.getEmail());
        assertEquals(sacuvan.getBrojTelefona(), dbPutnik.getBrojTelefona());
        assertEquals(sacuvan.getSifra(), dbPutnik.getSifra());

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

    @Test
    void ucitajPutnika() throws Exception {
        Putnik p = new Putnik();
        p.setIme("Nikola");
        p.setPrezime("Stojilkovic");
        p.setPol(Pol.MUSKI);
        p.setEmail("nikola.stojilkovic6@gmail.com");
        p.setBrojTelefona("0601111111");
        p.setSifra("nikola123");
        Putnik sacuvan = controller.zapamtiPutnika(p);

        Putnik dbPutnik = controller.ucitajPutnika(sacuvan);

        assertTrue(dbPutnik.getPutnikID() != 0);
        assertEquals(sacuvan.getPutnikID(), dbPutnik.getPutnikID());
        assertEquals(sacuvan.getIme(), dbPutnik.getIme());
        assertEquals(sacuvan.getPrezime(), dbPutnik.getPrezime());
        assertEquals(sacuvan.getPol(), dbPutnik.getPol());
        assertEquals(sacuvan.getEmail(), dbPutnik.getEmail());
        assertEquals(sacuvan.getBrojTelefona(), dbPutnik.getBrojTelefona());
        assertEquals(sacuvan.getSifra(), dbPutnik.getSifra());

        controller.obrisiPutnika(dbPutnik);
    }

    @Test
    void obrisiPutnika() throws Exception {
        Putnik p = new Putnik();
        p.setIme("Nikola");
        p.setPrezime("Stojilkovic");
        p.setPol(Pol.MUSKI);
        p.setEmail("nikola.stojilkovic6@gmail.com");
        p.setBrojTelefona("0601111111");
        p.setSifra("nikola123");
        Putnik sacuvan = controller.zapamtiPutnika(p);

        controller.obrisiPutnika(sacuvan);

        List<Putnik> putnici = controller.pronadjiPutnike(sacuvan);
        assertEquals(0, putnici.size());
    }

    @Test
    void zapamtiPutovanjeKreiranje() throws Exception {
        Grad g1 = new Grad();
        g1.setGradID(28);
        Grad g2 = new Grad();
        g2.setGradID(29);
        Putovanje p = new Putovanje();
        p.setPocetniGrad(g1);
        p.setKrajnjiGrad(g2);
        p.setPrevoz(Prevoz.AVION);
        p.setSmestaj(Smestaj.HOTEL);
        p.setPonuda(Ponuda.POLU_PANSION);
        p.setKratakOpis("Opis putovanja");
        p.setNaziv("Obilazak Rima");

        Putovanje zapamceno = controller.zapamtiPutovanje(p);

        Putovanje dbPutovanje = controller.ucitajPutovanje(zapamceno);

        assertTrue(dbPutovanje.getPutovanjeID() != 0);
        assertEquals(zapamceno.getPutovanjeID(), dbPutovanje.getPutovanjeID());
        assertEquals(zapamceno.getPocetniGrad().getGradID(), dbPutovanje.getPocetniGrad().getGradID());
        assertEquals(zapamceno.getKrajnjiGrad().getGradID(), dbPutovanje.getKrajnjiGrad().getGradID());
        assertEquals(zapamceno.getPrevoz(), dbPutovanje.getPrevoz());
        assertEquals(zapamceno.getSmestaj(), dbPutovanje.getSmestaj());
        assertEquals(zapamceno.getPonuda(), dbPutovanje.getPonuda());
        assertEquals(zapamceno.getKratakOpis(), dbPutovanje.getKratakOpis());
        assertEquals(zapamceno.getNaziv(), dbPutovanje.getNaziv());
    }

    @Test
    void zapamtiPutovanjeIzmena() throws Exception {
        Grad g1 = new Grad();
        g1.setGradID(28);
        Grad g2 = new Grad();
        g2.setGradID(29);
        Putovanje p = new Putovanje();
        p.setPocetniGrad(g1);
        p.setKrajnjiGrad(g2);
        p.setPrevoz(Prevoz.AVION);
        p.setSmestaj(Smestaj.HOTEL);
        p.setPonuda(Ponuda.POLU_PANSION);
        p.setKratakOpis("Opis putovanja");
        p.setNaziv("Obilazak Rima");

        Putovanje pers = controller.zapamtiPutovanje(p);

        Putovanje zaIzmenu = controller.ucitajPutovanje(pers);
        zaIzmenu.setPrevoz(Prevoz.AUTOBUS);
        zaIzmenu.setSmestaj(Smestaj.APARTMAN);
        zaIzmenu.setPonuda(Ponuda.BEZ_PANSIONA);
        zaIzmenu.setKratakOpis("Izmenjen obilazak Rima");

        Putovanje zapamceno = controller.zapamtiPutovanje(zaIzmenu);

        Putovanje dbPutovanje = controller.ucitajPutovanje(zapamceno);

        assertTrue(dbPutovanje.getPutovanjeID() != 0);
        assertEquals(zapamceno.getPutovanjeID(), dbPutovanje.getPutovanjeID());
        assertEquals(zapamceno.getPocetniGrad().getGradID(), dbPutovanje.getPocetniGrad().getGradID());
        assertEquals(zapamceno.getKrajnjiGrad().getGradID(), dbPutovanje.getKrajnjiGrad().getGradID());
        assertEquals(zapamceno.getPrevoz(), dbPutovanje.getPrevoz());
        assertEquals(zapamceno.getSmestaj(), dbPutovanje.getSmestaj());
        assertEquals(zapamceno.getPonuda(), dbPutovanje.getPonuda());
        assertEquals(zapamceno.getKratakOpis(), dbPutovanje.getKratakOpis());
        assertEquals(zapamceno.getNaziv(), dbPutovanje.getNaziv());
    }

    @Test
    void pronadjiPutovanjaException() throws Exception {
        assertThrows(Exception.class, () -> controller.pronadjiPutovanja(null));
        Grad grad = new Grad();
        assertThrows(Exception.class, () -> controller.pronadjiPutovanja(grad));
    }

    @Test
    void pronadjiPutovanja() throws Exception {
        Grad grad = new Grad();
        grad.setGradID(29);
        grad.setNaziv("Rim");
        grad.setDrzava("Italija");
        List<Putovanje> putovanja = controller.pronadjiPutovanja(grad);
        assertTrue(putovanja.size() > 0);
    }

    @Test
    void ucitajPutovanje(){

    }

}