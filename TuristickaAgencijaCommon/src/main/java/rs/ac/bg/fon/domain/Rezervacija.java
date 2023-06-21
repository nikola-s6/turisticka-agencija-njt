package rs.ac.bg.fon.domain;


import com.google.gson.annotations.Expose;
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
    @Expose
    private Putnik putnik;

    /**
     * Objekat klase Putovanje koji predstavlja putovanje za koje je rezervacija izvrsena.
     */
    @Expose
    private Putovanje putovanje;

    /**
     * Objekat klase Termin koji predstavlja za koji termin putovanja je rezervacija izvrsena.
     */
    @Expose
    private Termin termin;

    /**
     * Broj rezervacije kao int.
     */
    @Expose
    private int brojRezervacije;

    /**
     * Status rezervacije koji pokazuje da li je rezervacija aktivna.
     */
    @Expose
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
     * @throws NullPointerException ukoliko je putnik null
     */
    public void setPutnik(Putnik putnik) {
        if (putnik == null){
            throw new NullPointerException("Putnik ne sme biti null");
        }
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
     * @throws NullPointerException ukoliko je putovanje null
     */
    public void setPutovanje(Putovanje putovanje) {
        if (putovanje == null){
            throw new NullPointerException("Putovanje ne sme biti null");
        }
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
     * @throws NullPointerException ukoliko je termin null
     */
    public void setTermin(Termin termin) {
        if (termin == null){
            throw new NullPointerException("Termin ne sme biti null");
        }
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
     * @throws IllegalArgumentException ako je broj rezervacije 0
     */
    public void setBrojRezervacije(int brojRezervacije) {
        if(brojRezervacije == 0){
            throw new IllegalArgumentException("Broj rezervacije ne sme biti promenjen na 0");
        }
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
     * @throws NullPointerException ukoliko je status rezervacije null
     */
    public void setStatus(StatusRezervacije status) {
        if(status == null){
            throw new NullPointerException("Status rezervacije ne sme biti null");
        }
        this.status = status;
    }
}