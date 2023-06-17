package rs.ac.bg.fon.controller;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import rs.ac.bg.fon.domain.*;
import rs.ac.bg.fon.domain.util.*;

import java.util.Calendar;
import java.util.Date;
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
        grad.setGradID(29);
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
    void ucitajPutovanjeException(){
        Putovanje putovanje = new Putovanje();
        assertThrows(Exception.class, ()-> controller.ucitajPutovanje(putovanje));
    }

    @Test
    void ucitajPutovanje() throws Exception {
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
    void ucitajPutovanjaPutnikaException(){
        assertThrows(Exception.class, ()-> controller.ucitajPutovanjaPutnika(null));
        Putnik putnik = new Putnik();
        assertThrows(Exception.class, ()-> controller.ucitajPutovanjaPutnika(putnik));
    }

    @Test
    void ucitajPutovanjaPutnika() throws Exception {
        Putnik putnik = new Putnik();
        putnik.setIme("Nikola");
        putnik.setPrezime("Stojilkovic");
        putnik.setPol(Pol.MUSKI);
        putnik.setEmail("nikola.stojilkovic6@gmail.com");
        putnik.setBrojTelefona("0601111111");
        putnik.setSifra("nikola123");
        putnik = controller.zapamtiPutnika(putnik);

        Grad g1 = new Grad();
        g1.setGradID(28);
        Grad g2 = new Grad();
        g2.setGradID(29);
        Putovanje putovanje = new Putovanje();
        putovanje.setPocetniGrad(g1);
        putovanje.setKrajnjiGrad(g2);
        putovanje.setPrevoz(Prevoz.AVION);
        putovanje.setSmestaj(Smestaj.HOTEL);
        putovanje.setPonuda(Ponuda.POLU_PANSION);
        putovanje.setKratakOpis("Opis putovanja");
        putovanje.setNaziv("Obilazak Rima");

        putovanje = controller.zapamtiPutovanje(putovanje);

        Termin termin = new Termin();
        termin.setCena(12000.00);
        termin.setDatumPolaska(new Date(2023, Calendar.OCTOBER, 13));
        termin.setDatumPovratka(new Date(2023, Calendar.OCTOBER, 20));
        termin.setPutovanje(putovanje);
        putovanje.setTermini(List.of(termin));

        putovanje = controller.zapamtiPutovanje(putovanje);
        termin.setTerminID(putovanje.getTermini().get(putovanje.getTermini().size() - 1).getTerminID());


        Rezervacija rezervacija = new Rezervacija();
        rezervacija.setPutnik(putnik);
        rezervacija.setPutovanje(putovanje);
        rezervacija.setTermin(termin);
        rezervacija.setStatus(StatusRezervacije.NEAKTIVAN);
        termin.setRezervacije(List.of(rezervacija));
        putnik.getRezervacije().add(rezervacija);

        controller.zapamtiRezervaciju(rezervacija);
        controller.zapamtiPutnika(putnik);


        List<Putovanje> putovanja = controller.ucitajPutovanjaPutnika(putnik);

        controller.obrisiPutnika(putnik);

        assertTrue(putovanja.size() == 1);
        assertEquals(putovanje.getPutovanjeID(), putovanja.get(0).getPutovanjeID());
        assertEquals(putovanje.getPocetniGrad().getGradID(), putovanja.get(0).getPocetniGrad().getGradID());
        assertEquals(putovanje.getKrajnjiGrad().getGradID(), putovanja.get(0).getKrajnjiGrad().getGradID());
        assertEquals(putovanje.getNaziv(), putovanja.get(0).getNaziv());
    }

    @Test
    void zapamtiRezervaciju() throws Exception {
        Putnik putnik = new Putnik();
        putnik.setIme("Nikola");
        putnik.setPrezime("Stojilkovic");
        putnik.setPol(Pol.MUSKI);
        putnik.setEmail("nikola.stojilkovic6@gmail.com");
        putnik.setBrojTelefona("0601111111");
        putnik.setSifra("nikola123");
        putnik = controller.zapamtiPutnika(putnik);

        Grad g1 = new Grad();
        g1.setGradID(28);
        Grad g2 = new Grad();
        g2.setGradID(29);
        Putovanje putovanje = new Putovanje();
        putovanje.setPocetniGrad(g1);
        putovanje.setKrajnjiGrad(g2);
        putovanje.setPrevoz(Prevoz.AVION);
        putovanje.setSmestaj(Smestaj.HOTEL);
        putovanje.setPonuda(Ponuda.POLU_PANSION);
        putovanje.setKratakOpis("Opis putovanja");
        putovanje.setNaziv("Obilazak Rima");

        putovanje = controller.zapamtiPutovanje(putovanje);

        Termin termin = new Termin();
        termin.setCena(12000.00);
        termin.setDatumPolaska(new Date(2023, Calendar.OCTOBER, 13));
        termin.setDatumPovratka(new Date(2023, Calendar.OCTOBER, 20));
        termin.setPutovanje(putovanje);
        putovanje.setTermini(List.of(termin));

        putovanje = controller.zapamtiPutovanje(putovanje);
        termin.setTerminID(putovanje.getTermini().get(putovanje.getTermini().size() - 1).getTerminID());


        Rezervacija rezervacija = new Rezervacija();
        rezervacija.setPutnik(putnik);
        rezervacija.setPutovanje(putovanje);
        rezervacija.setTermin(termin);
        rezervacija.setStatus(StatusRezervacije.NEAKTIVAN);
        termin.setRezervacije(List.of(rezervacija));
        putnik.getRezervacije().add(rezervacija);

        Rezervacija dbRezervacija = controller.zapamtiRezervaciju(rezervacija);

        assertEquals(rezervacija.getPutnik(), dbRezervacija.getPutnik());
        assertEquals(rezervacija.getPutovanje(), dbRezervacija.getPutovanje());
        assertEquals(rezervacija.getTermin(), dbRezervacija.getTermin());
        assertEquals(rezervacija.getStatus(), dbRezervacija.getStatus());

        controller.obrisiPutnika(putnik);
    }

    @Test
    void pronadjiRezervacije() throws Exception {
        Putnik putnik = new Putnik();
        putnik.setIme("Nikola");
        putnik.setPrezime("Stojilkovic");
        putnik.setPol(Pol.MUSKI);
        putnik.setEmail("nikola.stojilkovic6@gmail.com");
        putnik.setBrojTelefona("0601111111");
        putnik.setSifra("nikola123");
        putnik = controller.zapamtiPutnika(putnik);

        Grad g1 = new Grad();
        g1.setGradID(28);
        Grad g2 = new Grad();
        g2.setGradID(29);
        Putovanje putovanje = new Putovanje();
        putovanje.setPocetniGrad(g1);
        putovanje.setKrajnjiGrad(g2);
        putovanje.setPrevoz(Prevoz.AVION);
        putovanje.setSmestaj(Smestaj.HOTEL);
        putovanje.setPonuda(Ponuda.POLU_PANSION);
        putovanje.setKratakOpis("Opis putovanja");
        putovanje.setNaziv("Obilazak Rima");

        putovanje = controller.zapamtiPutovanje(putovanje);

        Termin termin = new Termin();
        termin.setCena(12000.00);
        termin.setDatumPolaska(new Date(2023, Calendar.OCTOBER, 13));
        termin.setDatumPovratka(new Date(2023, Calendar.OCTOBER, 20));
        termin.setPutovanje(putovanje);
        putovanje.setTermini(List.of(termin));

        putovanje = controller.zapamtiPutovanje(putovanje);
        termin.setTerminID(putovanje.getTermini().get(putovanje.getTermini().size() - 1).getTerminID());


        Rezervacija rezervacija = new Rezervacija();
        rezervacija.setPutnik(putnik);
        rezervacija.setPutovanje(putovanje);
        rezervacija.setTermin(termin);
        rezervacija.setStatus(StatusRezervacije.NEAKTIVAN);
        termin.setRezervacije(List.of(rezervacija));
        putnik.getRezervacije().add(rezervacija);

        controller.zapamtiRezervaciju(rezervacija);
        controller.zapamtiPutnika(putnik);

        List<Rezervacija> rezervacije = controller.pronadjiRezervacije(putnik, putovanje);

        assertTrue(rezervacije.size() == 1);
        assertEquals(rezervacija.getPutnik(), rezervacije.get(0).getPutnik());
        assertEquals(rezervacija.getPutovanje(), rezervacije.get(0).getPutovanje());
        assertEquals(rezervacija.getStatus(), rezervacije.get(0).getStatus());

        controller.obrisiPutnika(putnik);
    }

    @Test
    void ucitajRezervacije() throws Exception {
        Putnik putnik = new Putnik();
        putnik.setIme("Nikola");
        putnik.setPrezime("Stojilkovic");
        putnik.setPol(Pol.MUSKI);
        putnik.setEmail("nikola.stojilkovic6@gmail.com");
        putnik.setBrojTelefona("0601111111");
        putnik.setSifra("nikola123");
        putnik = controller.zapamtiPutnika(putnik);

        Grad g1 = new Grad();
        g1.setGradID(28);
        Grad g2 = new Grad();
        g2.setGradID(29);
        Putovanje putovanje = new Putovanje();
        putovanje.setPocetniGrad(g1);
        putovanje.setKrajnjiGrad(g2);
        putovanje.setPrevoz(Prevoz.AVION);
        putovanje.setSmestaj(Smestaj.HOTEL);
        putovanje.setPonuda(Ponuda.POLU_PANSION);
        putovanje.setKratakOpis("Opis putovanja");
        putovanje.setNaziv("Obilazak Rima");

        putovanje = controller.zapamtiPutovanje(putovanje);

        Termin termin = new Termin();
        termin.setCena(12000.00);
        termin.setDatumPolaska(new Date(2023, Calendar.OCTOBER, 13));
        termin.setDatumPovratka(new Date(2023, Calendar.OCTOBER, 20));
        termin.setPutovanje(putovanje);
        putovanje.setTermini(List.of(termin));

        putovanje = controller.zapamtiPutovanje(putovanje);
        termin.setTerminID(putovanje.getTermini().get(putovanje.getTermini().size() - 1).getTerminID());


        Rezervacija rezervacija = new Rezervacija();
        rezervacija.setPutnik(putnik);
        rezervacija.setPutovanje(putovanje);
        rezervacija.setTermin(termin);
        rezervacija.setStatus(StatusRezervacije.NEAKTIVAN);
        termin.setRezervacije(List.of(rezervacija));
        putnik.getRezervacije().add(rezervacija);

        controller.zapamtiRezervaciju(rezervacija);
        controller.zapamtiPutnika(putnik);

        List<Rezervacija> rezervacije = controller.ucitajRezervacije(termin);
        assertTrue(rezervacije.size() == 1);
        assertEquals(rezervacija.getPutnik().getPutnikID(), rezervacije.get(0).getPutnik().getPutnikID());
        assertEquals(rezervacija.getTermin().getTerminID(), rezervacija.getTermin().getTerminID());
        assertEquals(rezervacija.getStatus(), rezervacije.get(0).getStatus());

        controller.obrisiPutnika(putnik);
    }
}