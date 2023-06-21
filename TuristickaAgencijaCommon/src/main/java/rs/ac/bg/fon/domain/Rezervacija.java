package rs.ac.bg.fon.domain;


import rs.ac.bg.fon.domain.util.StatusRezervacije;

import java.io.Serializable;

/**
 * Predstavlja rezervaciju putnika za odredjeno putovanje u nekom od termina.
 * Klasa Rezervacija sadrzi atribute putnik, putovanje, termin, brojRezervacije i status.
 *
 * @author Nikola Stojilkovic
 */
public class Rezervacija implements Serializable{

    /**
     * Objekat klase Putnik koji predstavlja putnika koji je izvrsio rezervaciju.
     */
    private Putnik putnik;

    /**
     * Objekat klase Putovanje koji predstavlja putovanje za koje je rezervacija izvrsena.
     */
    private Putovanje putovanje;

    /**
     * Objekat klase Termin koji predstavlja za koji termin putovanja je rezervacija izvrsena.
     */
    private Termin termin;

    /**
     * Broj rezervacije kao int.
     */
    private int brojRezervacije;

    /**
     * Status rezervacije koji pokazuje da li je rezervacija aktivna.
     */
    private StatusRezervacije status;

    /**
     * Neparametrizovani konstruktor za kreiranje instance klase Rezervacija.
     */
    public Rezervacija() {
    }

    /**
     * Parametrizovani konstruktor za kreiranje rezervacije.
     *
     * @param putnik Putnik koji je izvrsio rezervaciju.
     * @param putovanje Putovanje za koje je rezervacija izvrsena
     * @param termin Termin putovanja za koji je izvrsena rezervacija.
     * @param brojRezervacije Int vrednost broja rezervacije.
     * @param status Status rezervacije.
     */
    public Rezervacija(Putnik putnik, Putovanje putovanje, Termin termin, int brojRezervacije, StatusRezervacije status) {
        setPutnik(putnik);
        setPutovanje(putovanje);
        setTermin(termin);
        setBrojRezervacije(brojRezervacije);
        setStatus(status);
    }

    /**
     * Vraca vrednost atributa putnik.
     *
     * @return vrednost atributa putnik kao objekat kalse Putnik.
     */
    public Putnik getPutnik() {
        return putnik;
    }

    /**
     * Postavlja vrednost atributa putnik.
     *
     * @param putnik Objekat klase Putnik.
     */
    public void setPutnik(Putnik putnik) {
        this.putnik = putnik;
    }

    /**
     * Vraca vrednost atributa putovanje.
     *
     * @return vrednost atributa putovanje kao objekat kalse Putovanje.
     */
    public Putovanje getPutovanje() {
        return putovanje;
    }

    /**
     * Postavlja vrednost atributa putovanje.
     *
     * @param putovanje Objekat kalse putovanje.
     */
    public void setPutovanje(Putovanje putovanje) {
        this.putovanje = putovanje;
    }

    /**
     * Vraca vrednost atributa termin.
     *
     * @return termin rezervisanog putovanja kao objekat klase Termin.
     */
    public Termin getTermin() {
        return termin;
    }

    /**
     * Postavlja vrednost atributa Termin.
     *
     * @param termin Objekat kalse termin.
     */
    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    /**
     * Vraca vrednost atributa brojRezervacije.
     *
     * @return broj rezervacije kao int.
     */
    public int getBrojRezervacije() {
        return brojRezervacije;
    }

    /**
     * Postavlja vrednost atributa brojRezervacije.
     *
     * @param brojRezervacije Int vrednost broja rezervacije.
     */
    public void setBrojRezervacije(int brojRezervacije) {
        this.brojRezervacije = brojRezervacije;
    }

    /**
     * Vraca vrednost atributa status.
     *
     * @return status rezervacije kao vrednost enum-a Status.
     */
    public StatusRezervacije getStatus() {
        return status;
    }

    /**
     * Postavlja vrednost atributa status.
     *
     * @param status Enum Status koji predstavlja status rezervacije.
     */
    public void setStatus(StatusRezervacije status) {
        this.status = status;
    }
}