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

    @Test
    void stortnirajRezervacijuExceptionNull(){
        assertThrows(Exception.class, () -> controller.stornirajRezervaciju(null));
    }

    @Test
    void stortnirajRezervacijuExceptionBezBroja(){
        assertThrows(Exception.class, () -> controller.stornirajRezervaciju(new Rezervacija()));
    }

    @Test
    void stortnirajRezervacijuExceptionNeaktivna() throws Exception {
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

        assertThrows(Exception.class, () -> controller.stornirajRezervaciju(rezervacija));

        controller.obrisiPutnika(putnik);
    }

    @Test
    void stortnirajRezervaciju() throws Exception {
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
        rezervacija.setStatus(StatusRezervacije.AKTIVAN);
        termin.setRezervacije(List.of(rezervacija));
        putnik.getRezervacije().add(rezervacija);

        controller.zapamtiRezervaciju(rezervacija);
        controller.zapamtiPutnika(putnik);

        controller.stornirajRezervaciju(rezervacija);

        rezervacija = controller.pronadjiRezervacije(putnik, putovanje).get(0);

        assertTrue(rezervacija.getStatus().equals(StatusRezervacije.NEAKTIVAN));

        controller.obrisiPutnika(putnik);
    }

    @Test
    void obradiRezervacijuExceptionNull() throws Exception {
        assertThrows(Exception.class, () -> controller.obradiRezervaciju(null));
    }

    @Test
    void obradiRezervacijuExceptionBezBroja(){
        assertThrows(Exception.class, () -> controller.obradiRezervaciju(new Rezervacija()));
    }

    @Test
    void obradiRezervacijuExceptionAktivan() throws Exception {
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
        rezervacija.setStatus(StatusRezervacije.AKTIVAN);
        termin.setRezervacije(List.of(rezervacija));
        putnik.getRezervacije().add(rezervacija);

        controller.zapamtiRezervaciju(rezervacija);
        controller.zapamtiPutnika(putnik);

        assertThrows(Exception.class, () -> controller.obradiRezervaciju(rezervacija));

        controller.obrisiPutnika(putnik);
    }

    @Test
    void obradiRezervaciju() throws Exception {
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

        controller.obradiRezervaciju(rezervacija);

        rezervacija = controller.pronadjiRezervacije(putnik, putovanje).get(0);

        assertTrue(rezervacija.getStatus().equals(StatusRezervacije.AKTIVAN));

        controller.obrisiPutnika(putnik);
    }

    @Test
    void ucitajListuGradova() throws Exception {
        List<Grad> gradovi = controller.ucitajListuGradova();
        assertTrue(gradovi.size() == 2);
    }

    @Test
    void ucitajListuPutnika() throws Exception {
        Putnik putnik1 = new Putnik();
        putnik1.setIme("Nikola");
        putnik1.setPrezime("Stojilkovic");
        putnik1.setPol(Pol.MUSKI);
        putnik1.setEmail("nikola.stojilkovic6@gmail.com");
        putnik1.setBrojTelefona("0601111111");
        putnik1.setSifra("nikola123");
        putnik1 = controller.zapamtiPutnika(putnik1);

        Putnik putnik2 = new Putnik();
        putnik2.setIme("Marko");
        putnik2.setPrezime("Nikolic");
        putnik2.setPol(Pol.MUSKI);
        putnik2.setEmail("marko.nikolic@gmail.com");
        putnik2.setBrojTelefona("0602222222");
        putnik2.setSifra("marko123");
        putnik2 = controller.zapamtiPutnika(putnik2);

        List<Putnik> putnici = controller.ucitajListuPutnika();

        assertTrue(putnici.size() == 2);
        assertEquals(putnik1.getPutnikID(), putnici.get(0).getPutnikID());
        assertEquals(putnik2.getPutnikID(), putnici.get(1).getPutnikID());

        controller.obrisiPutnika(putnik1);
        controller.obrisiPutnika(putnik2);
    }

    @Test
    void ucitajListuPutovanja() throws Exception {
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

        List<Putovanje> putovanja = controller.ucitajListuPutovanja();

        assertTrue(putovanja.size() > 0);
        assertEquals(putovanje.getPutovanjeID(), putovanja.get(putovanja.size() - 1).getPutovanjeID());

        controller.obrisiPutnika(putnik);
    }

    @Test
    void ucitajListuTermina() throws Exception {
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

        Termin termin1 = new Termin();
        termin1.setCena(12000.00);
        termin1.setDatumPolaska(new Date(2023, Calendar.OCTOBER, 13));
        termin1.setDatumPovratka(new Date(2023, Calendar.OCTOBER, 20));
        termin1.setPutovanje(putovanje);

        Termin termin2 = new Termin();
        termin2.setCena(13000.00);
        termin2.setDatumPolaska(new Date(2023, Calendar.OCTOBER, 19));
        termin2.setDatumPovratka(new Date(2023, Calendar.OCTOBER, 26));
        termin2.setPutovanje(putovanje);

        putovanje.setTermini(List.of(termin1, termin2));

        putovanje = controller.zapamtiPutovanje(putovanje);
        termin1.setTerminID(putovanje.getTermini().get(0).getTerminID());
        termin2.setTerminID(putovanje.getTermini().get(1).getTerminID());

        List<Termin> termini = controller.ucitajListuTermina(putovanje);

        assertTrue(termini.size() == 2);
        assertEquals(termin1.getTerminID(), termini.get(0).getTerminID());
        assertEquals(termin2.getTerminID(), termini.get(1).getTerminID());

    }
}