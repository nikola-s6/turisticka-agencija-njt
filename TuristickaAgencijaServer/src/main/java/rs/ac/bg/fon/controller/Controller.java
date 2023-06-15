package rs.ac.bg.fon.controller;


import rs.ac.bg.fon.domain.*;
import rs.ac.bg.fon.domain.util.StatusRezervacije;
import rs.ac.bg.fon.repository.Repository;
import rs.ac.bg.fon.repository.db.impl.*;
import rs.ac.bg.fon.repository.db.DbConnectionRepository;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final Repository repositoryPutnik;
    private final Repository repositoryGrad;
    private final Repository repositoryPutovanje;
    private final Repository repositoryRezervacija;
    private final Repository repositoryTermin;
    private final Repository repositoryUsputni;

    private static Controller instance;

    public Controller() {
        this.repositoryPutnik = new RepositoryDBPutnik();
        this.repositoryGrad = new RepositoryDBGrad();
        this.repositoryPutovanje = new RepositoryDBPutovanje();
        this.repositoryRezervacija = new RepositoryDBRezervacija();
        this.repositoryTermin = new RepositoryDBTermin();
        this.repositoryUsputni = new RepositoryDBUsputni();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

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

    //    ucitava najosnovnije podatke putovanja sa krajnjim gradom radi pretrage (ucitavanje termina i sivh ostalih podataka se radi u ucitajPutovanje())
    public List<Putovanje> pronadjiPutovanja(Grad grad) throws Exception {
        if (grad == null) {
            throw new Exception("Za pretragu putoavnja potrebno je uneti grad");
        }
        if(grad.getGradID() == 0){
            throw new Exception("Za pretragu putoavnja potrebno je uneti grad koji ima gradID");
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

    //    ucitani termini ovde u sebi nemaju rezervacije
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

    public List<Putovanje> ucitajPutovanjaPutnika(Putnik putnik) throws Exception {
        if (putnik == null) {
            throw new Exception("Za pretragu putoavnja potrebno je uneti putnika");
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
    public List<Rezervacija> pronadjiRezervacije(Putnik putnik, Putovanje putovanje) throws Exception {
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

    //    ucitava rezervacije za neki termin
    public List<Rezervacija> ucitajRezervacije(Termin termin) throws Exception {
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

    public void stornirajRezervaciju(Rezervacija rezervacija) throws Exception {
        if (rezervacija.getStatus() == null) {
            throw new Exception("Rezervacija mora imati status");
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
    }

    public void obradiRezervaciju(Rezervacija rezervacija) throws Exception {
        if (rezervacija.getStatus() == null) {
            throw new Exception("Rezervacija mora imati status");
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
    }

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

    public List<Termin> ucitajListuTermina(Putovanje putovanje) throws Exception {
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