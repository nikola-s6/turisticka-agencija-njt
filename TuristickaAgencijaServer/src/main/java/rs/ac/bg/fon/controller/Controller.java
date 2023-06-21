package rs.ac.bg.fon.controller;


import rs.ac.bg.fon.domain.*;
import rs.ac.bg.fon.domain.util.StatusRezervacije;
import rs.ac.bg.fon.repository.Repository;
import rs.ac.bg.fon.repository.db.impl.*;
import rs.ac.bg.fon.repository.db.DbConnectionRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa koja sadrzi sve sistemske operacije implementirane u obliku metoda ove klase.
 * Klasa je singleton patern. Kao atribute ima pojedinacne implementacije interfejsa Repository
 * u zavisnosti od domenske klase za koju je operacije potrebno izvrsiti.
 * @author Nikola Stojilkovic
 */
public class Controller {

    /**
     * Predstavlja repozitorijum za upravljanjem podataka domenske klase Putnik.
     * Implementacija interfejsa Repository je data u klsasi RepositoryDBPutnik.
     * @see rs.ac.bg.fon.repository.db.impl.RepositoryDBPutnik
     * @see rs.ac.bg.fon.domain.Putnik
     */
    private final Repository repositoryPutnik;

    /**
     * Predstavlja repozitorijum za upravljanjem podataka domenske klase Grad.
     * Implementacija interfejsa Repository je data u klsasi RepositoryDBGrad.
     * @see rs.ac.bg.fon.repository.db.impl.RepositoryDBGrad
     * @see rs.ac.bg.fon.domain.Grad
     */
    private final Repository repositoryGrad;

    /**
     * Predstavlja repozitorijum za upravljanjem podataka domenske klase Putovanje.
     * Implementacija interfejsa Repository je data u klsasi RepositoryDBPutovanje.
     * @see rs.ac.bg.fon.repository.db.impl.RepositoryDBPutovanje
     * @see rs.ac.bg.fon.domain.Putovanje
     */
    private final Repository repositoryPutovanje;

    /**
     * Predstavlja repozitorijum za upravljanjem podataka domenske klase rezervacija.
     * Implementacija interfejsa Repository je data u klsasi RepositoryDBRezervacija.
     * @see rs.ac.bg.fon.repository.db.impl.RepositoryDBRezervacija
     * @see rs.ac.bg.fon.domain.Rezervacija
     */
    private final Repository repositoryRezervacija;

    /**
     * Predstavlja repozitorijum za upravljanjem podataka domenske klase Termin.
     * Implementacija interfejsa Repository je data u klsasi RepositoryDBTermin.
     * @see rs.ac.bg.fon.repository.db.impl.RepositoryDBTermin
     * @see rs.ac.bg.fon.domain.Termin
     */
    private final Repository repositoryTermin;

    /**
     * Predstavlja repozitorijum za upravljanjem podataka domenske klase Usputni.
     * Implementacija interfejsa Repository je data u klsasi RepositoryDBUsputni.
     * @see rs.ac.bg.fon.repository.db.impl.RepositoryDBUsputni
     * @see rs.ac.bg.fon.domain.Usputni
     */
    private final Repository repositoryUsputni;

    /**
     * Atribut koji predstavja instancu klase Controller.
     * Obzirom da je klasa implementirana kao singleton patern
     * ova instanca predstavlja jedini objekat klase tokom rada servera.
     */
    private static Controller instance;

    /**
     * Privatni neparametrizovani konstruktor koji zadaje odgovarajuce implementacije
     * interfejsa Repository inicijalizacijom atributa.
     */
    private Controller() {
        this.repositoryPutnik = new RepositoryDBPutnik();
        this.repositoryGrad = new RepositoryDBGrad();
        this.repositoryPutovanje = new RepositoryDBPutovanje();
        this.repositoryRezervacija = new RepositoryDBRezervacija();
        this.repositoryTermin = new RepositoryDBTermin();
        this.repositoryUsputni = new RepositoryDBUsputni();
    }

    /**
     * Metoda koja vraca jedinu instancu klase singleton paterna.
     * Ukoliko instanca jos uvek ne postoji, onda ona biva kreirana.
     * Ukoliko instanca postoji, ne kreira se nova, vec se vraca vec postojeca.
     * @return jedini objekat klase Controller
     */
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    /**
     * Sistemska operacija za prijavu korisnika na sistem.
     * Iz baze podataka se ucitava lista svih putnika i zatim se proverava da li se putnik sa prosledjenim
     * kredencijalima nalazi u listi.
     *
     * @param p Objekat domenske klase putnik koji ima postavljene atribute email i sifra.
     * @return Putnik kao prijavljeni korisnik.
     * @throws Exception ukoliko ne postoji registrovani korisnik ili ukoliko dodje dogreske prilikom komunikacije
     * sa bazom podataka.
     */
    public Putnik logovanje(Putnik p) throws Exception {
        try {
            ((DbConnectionRepository) repositoryPutnik).connect();
            List<Putnik> putnici = repositoryPutnik.getAll();
            ((DbConnectionRepository) repositoryPutnik).commit();

            for (Putnik putnik : putnici) {
                if (putnik.getEmail().equals(p.getEmail()) && putnik.getSifra().equals(Integer.toString(p.getSifra().hashCode()))) {
                    return putnik;
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ((DbConnectionRepository) repositoryPutnik).disconnect();
        }
        throw new Exception("Nepoznat korisnik!");
    }

    /**
     * Sistemska operacija za perzistenciju putnika i izmenu podataka putnika.
     * Ukoliko putnik sa prosledjenim id-em postoji u bazi podataka onda se vrsi izmena entiteta iz baze podataka.
     * Ukoliko putnik (putnikID) ne postoji u bazi podataka onda se vrsi cuvanje podataka u bazu.
     *
     * @param putnik Objekat domenske klase Putnik koji je potrebno sacuvati ili izmeniti.
     * @throws Exception ukoliko dodje do greske prilikom cuvanja ili izmene podataka putnika u bazi podataka.
     */
    public Putnik zapamtiPutnika(Putnik putnik) throws Exception {
        try {
            ((DbConnectionRepository) repositoryPutnik).connect();
            if (putnik.getPutnikID() != 0) {
                repositoryPutnik.edit(putnik);
            } else {
                putnik.setSifra(Integer.toString(putnik.getSifra().hashCode()));
                repositoryPutnik.add(putnik);
            }
            ((DbConnectionRepository) repositoryPutnik).commit();
        } catch (Exception ex) {
            ((DbConnectionRepository) repositoryPutnik).rollback();
            throw ex;
        } finally {
            ((DbConnectionRepository) repositoryPutnik).disconnect();
        }
        return putnik;
    }

    /**
     * Sistemska operacija zaduzena za pronalazenje svih putnika koji odgovaraju kriterijumu pretrage.
     * Kriterijum pretrage za putnika je ime putnika i on je zadat preko atributa ime parametra putnik.
     * @param putnik objekat domenske klase koji ima postavljene atribute za kriterijum pretraeg.
     * @return lista putnika kao rezultat pretrage putnika koji odgovaraju kriterijumu pretrage.
     * @throws Exception ukoliko dodje do greske prilikom pretrage putnika iz baze podataka.
     */
    public List<Putnik> pronadjiPutnike(Putnik putnik) throws Exception {
        List<Putnik> putnici = new ArrayList<>();
        try {
            ((DbConnectionRepository) repositoryPutnik).connect();
            putnici = repositoryPutnik.getAll(putnik);
            ((DbConnectionRepository) repositoryPutnik).commit();
        } catch (Exception ex) {
            ((DbConnectionRepository) repositoryPutnik).rollback();
            throw ex;
        } finally {
            ((DbConnectionRepository) repositoryPutnik).disconnect();
        }
        return putnici;
    }

    /**
     * Ucitavanje jednog jedinstvenog putnika iz baze podataka.
     * Pretraga se vrsi preko id-a koji je zadat kao atribut parametra putnik.
     *
     * @param putnik objekat domenske klase koji ima postavljene atribute za kriterijum pretrage.
     * @return objekat domenske klase Putnik koji odgovara kriterijumu pretrage.
     * @throws Exception ukoliko nije postavljen id kao atribut parametra putnik (id je 0) ili ukoliko dodje
     * do greske prilikom ucitavanja putnika iz baze podataka.
     */
    public Putnik ucitajPutnika(Putnik putnik) throws Exception {
        if (putnik.getPutnikID() == 0) {
            throw new Exception("Za ucitavanje putnika potrebno je poslati njegov id");
        }
        Putnik p = new Putnik();
        try {
            ((DbConnectionRepository) repositoryPutnik).connect();
            p = (Putnik) repositoryPutnik.getOne(putnik);
            ((DbConnectionRepository) repositoryPutnik).commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            ((DbConnectionRepository) repositoryPutnik).disconnect();
        }
        return p;
    }

    /**
     * Sistemska operacija brisanja putnika iz baze podataka.
     * Pretraga se vrsi preko id-a koji je zadat kao atribut parametra putnik.
     *
     * @param putnik objekat domenske klase koji ima postavljene atribute za kriterijum pretrage.
     * @throws Exception ukoliko nije postavljen id kao atribut parametra putnik (id je 0) ili ukoliko dodje
     * do greske prilikom brisanja putnika iz baze podataka.
     */
    public void obrisiPutnika(Putnik putnik) throws Exception {
        if (putnik.getPutnikID() == 0) {
            throw new Exception("Za brisanje putnika potrebno je poslati njegov id");
        }
        try {
            ((DbConnectionRepository) repositoryPutnik).connect();
            repositoryPutnik.delete(putnik);
            ((DbConnectionRepository) repositoryPutnik).commit();
        } catch (Exception e) {
            ((DbConnectionRepository) repositoryPutnik).rollback();
            throw e;
        } finally {
            ((DbConnectionRepository) repositoryPutnik).disconnect();
        }
    }

    /**
     * Sistemska operacija za pronalazenje putovanja prema kriterijumu pretrae.
     * Kriterijm pretrage je grad koji predstavlja destinaciju (krajnji grad) putovanja.
     * Ucitavaju se osnovni podaci o putovanju (id, naziv, krajnji i pocetni grad), dok se
     * ucitavanje slozenijih potadata (termini, usputni gradovi, ...) vrsi ucitavanjem pojedinacnih
     * putovanja sistemskom operacijom ucitajPutovanje.
     *
     * @param grad objekat domenske klase Grad kriterijum pretrage putovanja (krajnja destinacija putovanja).
     * @return lista svih putovanja koji odgovaraju kriterijumu pretrage.
     * @throws Exception ukoliko je parametar grad null ili ukoliko dodje do greske prilikom ucitavalja putovanja iz baze podataka.
     */
    public List<Putovanje> pronadjiPutovanja(Grad grad) throws Exception {
        if (grad == null) {
            throw new Exception("Za pretragu putoavnja potrebno je uneti grad");
        }
        if(grad.getNaziv() == null || grad.getNaziv().isEmpty()){
            throw new Exception("Za pretragu putoavnja potrebno je uneti informacije o gradu");
        }
        List<Putovanje> putovanja = new ArrayList<>();

        try {
            ((DbConnectionRepository) repositoryPutovanje).connect();
//            zato sto mora da se posalje putovanje u upit
            Putovanje pom = new Putovanje();
            pom.setKrajnjiGrad(grad);
            putovanja = repositoryPutovanje.getAll(pom);
            ((DbConnectionRepository) repositoryPutovanje).commit();
        } catch (Exception e) {
            ((DbConnectionRepository) repositoryPutovanje).rollback();
            throw e;
        } finally {
            ((DbConnectionRepository) repositoryPutovanje).disconnect();
        }
        return putovanja;
    }


    /**
     * Ucitavajne pojedinacog putovanja koje odgovara kriterijumu pretrage. Kao kriterijum pretrage
     * uzima se putovanjeID iz parametra putovanje.
     * Ucitano putovanje u sebi sadrzi sve slozene informacije, ali termini putovanja ne sadrze liste
     * rezeravcija. Rezervacije se dobijaju sistemskom operacijom ucitajRezervacije.
     * @param putovanje objekat domenske klase koji sadrzi atribut putovanjeID i sluzi kao parametar pretrage.
     * @return objekat domenske klase Putovanje koji odgovara parametru pretrage.
     * @throws Exception ukoliko je atribut putovanjeID parametra putovanje null ili ukoliko dodje do greske prilikom ucitavanja
     * putovanja iz baze podataka.
     */
    public Putovanje ucitajPutovanje(Putovanje putovanje) throws Exception {
        if (putovanje.getPutovanjeID() == 0) {
            throw new Exception("za ucitavanje putovanje je potrebno poslati id putovanja");
        }
        Putovanje p = new Putovanje();
        List<Usputni> usputni = new ArrayList<>();
        List<Termin> termini = new ArrayList<>();
        try {
            ((DbConnectionRepository) repositoryPutovanje).connect();

            p = (Putovanje) repositoryPutovanje.getOne(putovanje);

            Usputni usputniPom = new Usputni();
            usputniPom.setPutovanje(p);
            usputni = repositoryUsputni.getAll(usputniPom);
            p.setUsputniGradovi(usputni);

            Termin terminPom = new Termin();
            terminPom.setPutovanje(p);
            termini = repositoryTermin.getAll(terminPom);
            p.setTermini(termini);

            ((DbConnectionRepository) repositoryPutovanje).commit();
        } catch (Exception e) {
            ((DbConnectionRepository) repositoryPutovanje).rollback();
            throw e;
        } finally {
            ((DbConnectionRepository) repositoryPutovanje).disconnect();
        }
        return p;
    }

    /**
     * Sistemska operacija za perzistenciju putovanja i izmenu putovanja.
     * Ukoliko putovanje sa prosledjenim id-em postoji u bazi podataka onda se vrsi izmena entiteta
     * iz baze podataka. Ukoliko putovanje (putovanjeID) ne postoji u bazi podataka onda se vrsi perzistencija podataka.
     *
     * @param putovanje objekat domenske klase Putovanje koji je potrebno sacuvati ili izemniti.
     * @throws Exception ukoliko dodje do greske u bazi podataka prilikom izmene ili cuvanja podataka putovanja.
     */
    public Putovanje zapamtiPutovanje(Putovanje putovanje) throws Exception {
        try {
            ((DbConnectionRepository) repositoryPutovanje).connect();
            if (putovanje.getPutovanjeID() == 0) {
                repositoryPutovanje.add(putovanje);
                for (Termin termin : putovanje.getTermini()) {
//                    termin.setPutovanje(putovanje);
                    repositoryTermin.add(termin);
                }
                for (Usputni usputni : putovanje.getUsputniGradovi()) {
//                    usputni.setPutovanje(putovanje);
                    repositoryUsputni.add(usputni);
                }
            } else {
                Termin termin = new Termin();
                termin.setPutovanje(putovanje);
                repositoryTermin.delete(termin);

                Usputni usputni = new Usputni();
                usputni.setPutovanje(putovanje);
                repositoryUsputni.delete(usputni);

                repositoryPutovanje.edit(putovanje);

                for (Termin termin1 : putovanje.getTermini()) {
                    repositoryTermin.add(termin1);
                }

                for (Usputni usputni1 : putovanje.getUsputniGradovi()) {
                    repositoryUsputni.add(usputni1);
                }
            }
            ((DbConnectionRepository) repositoryPutovanje).commit();
        } catch (Exception e) {
            ((DbConnectionRepository) repositoryPutovanje).rollback();
            throw e;
        } finally {
            ((DbConnectionRepository) repositoryPutovanje).disconnect();
        }
        return putovanje;
    }

    /**
     * Sistemska operacija za ucitavanje osnovnih podataka za sva rezervisana putovanja jednog putnika.
     *
     * @param putnik objekat domenske klase Putnik koji sluzi kao parametar pretrage za putovanje.
     * @return lista svih rezervisanih putovanja jedno putnika.
     * @throws Exception ukoliko je parametar putnik null ili ukoliko dodje do greske prilikom
     * ucitavanja putovanja iz baze podataka.
     */
    public List<Putovanje> ucitajPutovanjaPutnika(Putnik putnik) throws Exception {
        if (putnik == null) {
            throw new Exception("Za pretragu putovanja potrebno je uneti putnika");
        }
        if(putnik.getPutnikID() == 0){
            throw new Exception("Za pretragu putoavnja potrebno je uneti postojeceg putnika");
        }
        List<Putovanje> putovanja = new ArrayList<>();

        try {
            ((DbConnectionRepository) repositoryPutovanje).connect();

            putovanja = ((RepositoryDBPutovanje)repositoryPutovanje).getAll(putnik);
            ((DbConnectionRepository) repositoryPutovanje).commit();
        } catch (Exception e) {
            ((DbConnectionRepository) repositoryPutovanje).rollback();
            throw e;
        } finally {
            ((DbConnectionRepository) repositoryPutovanje).disconnect();
        }
        return putovanja;
    }

    /**
     * Sistemska operacija za perzistenciju rezervacija u bazu podataka.
     *
     * @param rezervacija objekat domenske klase Rezervacija koji je potrebno sacuvati u bazu podataka.
     * @return objekat domenske klase Rezervacija koji je sacuvan u bazu podataka.
     * @throws Exception ukoliko dodje do graske prilikom cuvanja podataka u bazu.
     */
    public Rezervacija zapamtiRezervaciju(Rezervacija rezervacija) throws Exception {
        try {
            ((DbConnectionRepository) repositoryRezervacija).connect();
            repositoryRezervacija.add(rezervacija);
            ((DbConnectionRepository) repositoryRezervacija).commit();
        } catch (Exception e) {
            ((DbConnectionRepository) repositoryRezervacija).rollback();
            throw e;
        } finally {
            ((DbConnectionRepository) repositoryRezervacija).disconnect();
        }
        return rezervacija;
    }

    //    pronalazi rezervacije putnika za odredjeno putovanje

    /**
     * Sistemska operacija koja pronalazi rezervacije putnika za odredjeno putovanje.
     * Kriterijumi pretrage su dati preko id-a (atributi) parametara putnik i putovanje.
     *
     * @param putnik objekat domenske klase Putnik koji sadrzi atribut putnikID i sluzi kao parametar pretrage.
     * @param putovanje objekat domenske klase Putovanje koji sadrzi atribut putovanjeID i sluzi kao parametar pretrage.
     * @return lista svih rezervacija putnika za zadato putovanje.
     * @throws Exception ukoliko nisu prosledjeni putnikID ili putovanjeID ili ukoliko dodje do greske prilik citanja podataka iz baze.
     */
    public List<Rezervacija> pronadjiRezervacije(Putnik putnik, Putovanje putovanje) throws Exception {
        if(putnik.getPutnikID() == 0){
            throw new Exception("Za ucitavanje podatak potrebno je poslati id putnika");
        }
        if(putovanje.getPutovanjeID() == 0){
            throw new Exception("Za ucitavanje podataka potrebno je poslati id putovanja");
        }
        List<Rezervacija> rezervacije = new ArrayList<>();
        Rezervacija rezervacija = new Rezervacija();
        rezervacija.setPutnik(putnik);
        rezervacija.setPutovanje(putovanje);

        try {
            ((DbConnectionRepository) repositoryRezervacija).connect();
            rezervacije = repositoryRezervacija.getAll(rezervacija);
            ((DbConnectionRepository) repositoryRezervacija).commit();
        } catch (Exception e) {
            ((DbConnectionRepository) repositoryRezervacija).rollback();
            throw e;
        } finally {
            ((DbConnectionRepository) repositoryRezervacija).disconnect();
        }
        return rezervacije;
    }

    /**
     * Sistemska operacija koja ucitava sve rezervacije za neki termin putovanja.
     *
     * @param termin objekat domenske klase Termin koji sluzi kao kriterijum za pretragu.
     * @return lista rezervacija u zadatom terminu.
     * @throws Exception ukoliko nije postavljen terminID (terminID je 0) ili ukoliko
     * dodje do greske prilikom ucitavanja podataka iz baze.
     */
    public List<Rezervacija> ucitajRezervacije(Termin termin) throws Exception {
        if(termin.getTerminID() == 0){
            throw new Exception("Za ucitavanje podataka potrebno je poslati id termina");
        }
        List<Rezervacija> rezervacije = new ArrayList<>();

        try {
            ((DbConnectionRepository) repositoryRezervacija).connect();
            rezervacije = ((RepositoryDBRezervacija) repositoryRezervacija).getAll(termin);
            ((DbConnectionRepository) repositoryRezervacija).commit();
        } catch (Exception e) {
            ((DbConnectionRepository) repositoryRezervacija).rollback();
            throw e;
        } finally {
            ((DbConnectionRepository) repositoryRezervacija).disconnect();
        }
        return rezervacije;
    }

    /**
     * Sistemska operacija storniranja rezervacije. Postavlja status rezervacije na neaktivan.
     * @param rezervacija objekat domenske klase Rezervacija koji oznacava koju rezervaciju je potrebno stornirati.
     * @throws Exception ukoliko je status rezervacije null, ukoliko je status vec postavljen na neaktivan ili ukoiko dodje do
     * greske prilikom izmena statusa rezervacije u bazi podataka.
     */
    public Rezervacija stornirajRezervaciju(Rezervacija rezervacija) throws Exception {
        if (rezervacija.getStatus() == null) {
            throw new Exception("Rezervacija mora imati status");
        }
        if(rezervacija.getBrojRezervacije() == 0){
            throw new Exception("Rezervacija mora imati broj");
        }
        if (rezervacija.getStatus().equals(StatusRezervacije.NEAKTIVAN)) {
            throw new Exception("Rezervaciju je moguce stornirati samo ako je aktivna!");
        }
        rezervacija.setStatus(StatusRezervacije.NEAKTIVAN);
        try {
            ((DbConnectionRepository) repositoryRezervacija).connect();
            repositoryRezervacija.edit(rezervacija);
            ((DbConnectionRepository) repositoryRezervacija).commit();
        } catch (Exception e) {
            rezervacija.setStatus(StatusRezervacije.AKTIVAN);
            ((DbConnectionRepository) repositoryRezervacija).rollback();
            throw e;
        } finally {
            ((DbConnectionRepository) repositoryRezervacija).disconnect();
        }
        return rezervacija;
    }

    /**
     * Sistemska operacija obradjivanja rezervacije. Postavlja status rezervacije na aktivan.
     * @param rezervacija objekat domenske klase Rezervacija koji oznacava koju rezervaciju je potrebno obraditi (aktivirati).
     * @throws Exception ukoliko je status rezervacije null, ukoliko je status vec postavljen na aktivan ili ukoiko dodje do
     * greske prilikom izmene statusa rezervacije u bazi podataka.
     */
    public Rezervacija obradiRezervaciju(Rezervacija rezervacija) throws Exception {
        if (rezervacija.getStatus() == null) {
            throw new Exception("Rezervacija mora imati status");
        }
        if(rezervacija.getBrojRezervacije() == 0){
            throw new Exception("Rezervacija mora imati broj");
        }
        if (rezervacija.getStatus().equals(StatusRezervacije.AKTIVAN)) {
            throw new Exception("Rezervaciju je moguce obraditi samo kada nije aktivna!");
        }
        rezervacija.setStatus(StatusRezervacije.AKTIVAN);
        try {
            ((DbConnectionRepository) repositoryRezervacija).connect();
            repositoryRezervacija.edit(rezervacija);
            ((DbConnectionRepository) repositoryRezervacija).commit();
        } catch (Exception e) {
            rezervacija.setStatus(StatusRezervacije.NEAKTIVAN);
            ((DbConnectionRepository) repositoryRezervacija).rollback();
            throw e;
        } finally {
            ((DbConnectionRepository) repositoryRezervacija).disconnect();
        }
        return rezervacija;
    }

    /**
     * Sistemska operacija koja ucitava listu svih gradova iz baze podataka.
     *
     * @return lista svih gradova iz baze podataka.
     * @throws Exception ukoliko dodje do greske prilikom ucitavanja radova iz baze podataka.
     */
    public List<Grad> ucitajListuGradova() throws Exception {
        List<Grad> gradovi = new ArrayList<>();
        try {
            ((DbConnectionRepository) repositoryGrad).connect();
            gradovi = repositoryGrad.getAll();
            ((DbConnectionRepository) repositoryGrad).commit();
        } catch (Exception e) {
            ((DbConnectionRepository) repositoryGrad).rollback();
            throw e;
        } finally {
            ((DbConnectionRepository) repositoryGrad).disconnect();
        }
        return gradovi;
    }

    /**
     * Ucitava listu svih putnika iz baze podataka.
     *
     * @return lista svih putnika iz baze podataka.
     * @throws Exception ukoliko dodje do greske prilikom ucitavanja putnika iz baze podataka.
     */
    public List<Putnik> ucitajListuPutnika() throws Exception {
        List<Putnik> putnici = new ArrayList<>();
        try {
            ((DbConnectionRepository) repositoryPutnik).connect();
            putnici = repositoryPutnik.getAll();
            ((DbConnectionRepository) repositoryPutnik).commit();

        } catch (Exception e) {
            ((DbConnectionRepository) repositoryPutnik).rollback();
            throw e;
        } finally {
            ((DbConnectionRepository) repositoryPutnik).disconnect();
        }
        return putnici;
    }

    /**
     * Ucitava listu svih putovanja iz baze podataka.
     *
     * @return lista svih putovanja iz baze podataka.
     * @throws Exception ukoliko dodje do greske prilikom ucitavanja putovanja iz baze podataka.
     */
    public List<Putovanje> ucitajListuPutovanja() throws Exception {
        List<Putovanje> putovanja = new ArrayList<>();
        try {
            ((DbConnectionRepository) repositoryPutovanje).connect();
            putovanja = repositoryPutovanje.getAll();
            ((DbConnectionRepository) repositoryPutovanje).commit();
        } catch (Exception e) {
            ((DbConnectionRepository) repositoryPutovanje).rollback();
            throw e;
        } finally {
            ((DbConnectionRepository) repositoryPutovanje).disconnect();
        }
        return putovanja;
    }

    /**
     * Ucitava listu svih termina zadatog putovanja iz baze podataka.
     *
     * @param putovanje objekat domenske klase Putovanje koji sluzi kao kriterijum pretrage termina (pretraga prema putovanjeID).
     * @return lista svih termina koji odgovaraju kriterijumu pretrage.
     * @throws Exception ukoliko nije postavljeno putovanjeID iz parametra putovanje (putovanjeID je 0) ili ukoliko
     * dodje do greske prilikom ucitavanja podataka iz baze.
     */
    public List<Termin> ucitajListuTermina(Putovanje putovanje) throws Exception {
        if(putovanje.getPutovanjeID() == 0){
            throw new Exception("Za ucitavanje podataka potrebno je poslati id putovanja");
        }
        List<Termin> termini = new ArrayList<>();
        try {
            ((DbConnectionRepository) repositoryTermin).connect();
            Termin pom = new Termin();
            pom.setPutovanje(putovanje);
            termini = repositoryTermin.getAll(pom);
//            putovanje im je svima setovano u bazi, ne mora i ovde, zato nije napisano
            ((DbConnectionRepository) repositoryTermin).commit();
        } catch (Exception e) {
            ((DbConnectionRepository) repositoryTermin).connect();
            throw e;
        } finally {
            ((DbConnectionRepository) repositoryTermin).disconnect();
        }
        return termini;
    }

}