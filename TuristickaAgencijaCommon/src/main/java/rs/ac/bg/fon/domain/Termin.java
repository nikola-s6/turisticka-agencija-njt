package rs.ac.bg.fon.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Klasa koja predstavlja termin nekog putovovanja.
 * Klasa Termin sadrzi atribute terminID, cena, datumPolaska, datumPovratka, putovanje i rezervacije.
 *
 * @author Nikola Stojilkovic
 */
public class Termin implements Serializable {

    /**
     * ID termina kao int vrednost.
     */
    private int terminID;

    /**
     * Cena putovanja u terminu kao double vrednost.
     */
    private Double cena;

    /**
     * Datum polaska putnika na putovnje.
     */
    private Date datumPolaska;

    /**
     * Datum povratka putnika sa putovanja.
     */
    private Date datumPovratka;

    /**
     * Putovanje za koje je termin vezan, dat kao objekat klase Putovanje.
     */
    private Putovanje putovanje;

    /**
     * Lista svih rezervacija za odgovarajuci termin.
     * Lista ne moze biti null, ali moze biti prazna.
     */
    private List<Rezervacija> rezervacije;

    /**
     * Neparametrizovani konstruktor za kreiranje instance termnina.
     * Inicijalizuje listu rezervacija - ArrayList implementacija.
     */
    public Termin() {
        this.rezervacije = new ArrayList<>();
    }

    /**
     * Parametrizovani konstruktor za kreiranje instance termina.
     * Pored prosledjenih vrednosti inicijalizuje i listu rezervacija - ArrayList implementacija.
     *
     * @param terminID Int vrednost ID-a termina.
     * @param cena Double vrednost cene putovanja.
     * @param datumPolaska Datum polaska putnika na putovanje.
     * @param datumPovratka Datum povratka putnika sa putovanja.
     * @param putovanje Putovanje za koje se kreira termin.
     */
    public Termin(int terminID, Double cena, Date datumPolaska, Date datumPovratka, Putovanje putovanje) {
        this.terminID = terminID;
        this.cena = cena;
        this.datumPolaska = datumPolaska;
        this.datumPovratka = datumPovratka;
        this.putovanje = putovanje;
        this.rezervacije = new ArrayList<>();
    }

    /**
     * Vraca ID termina.
     *
     * @return terminID kao int vrednost.
     */
    public int getTerminID() {
        return terminID;
    }

    /**
     * Postavlja vrednost atributa terminID.
     *
     * @param terminID nova vrednost atributa terminID.
     */
    public void setTerminID(int terminID) {
        this.terminID = terminID;
    }

    /**
     * Vraca vrednost atributa cena.
     *
     * @return cena kao double vrednost.
     */
    public Double getCena() {
        return cena;
    }

    /**
     * Postavlja vrednost atributa cena.
     *
     * @param cena nova vrednost atributa cena kao double.
     */
    public void setCena(Double cena) {
        this.cena = cena;
    }

    /**
     * Vraca datum polaska putnika na putovanje.
     *
     * @return datumPolaska kao objekat klase Date.
     */
    public Date getDatumPolaska() {
        return datumPolaska;
    }

    /**
     * Postavlja vrednost atributa datumPolaska.
     *
     * @param datumPolaska nova vrednost atributa datumPolaska.
     */
    public void setDatumPolaska(Date datumPolaska) {
        this.datumPolaska = datumPolaska;
    }

    /**
     * Vraca datum povratka putnika sa putovanja.
     *
     * @return datumPovratka kao objekat klase Date.
     */
    public Date getDatumPovratka() {
        return datumPovratka;
    }

    /**
     * Postavlja vrednost atributa datumPovratka.
     *
     * @param datumPovratka nova vrednost atributa datumPovratka.
     */
    public void setDatumPovratka(Date datumPovratka) {
        this.datumPovratka = datumPovratka;
    }

    /**
     * Vraca vrednost atributa putovanje.
     *
     * @return putovanje kao objekat klase Putovanje.
     */
    public Putovanje getPutovanje() {
        return putovanje;
    }

    /**
     * Postavlja vrednost atributa putovanje.
     *
     * @param putovanje nova vrednost atributa putovanje kao objekat klase Putovanje.
     */
    public void setPutovanje(Putovanje putovanje) {
        this.putovanje = putovanje;
    }

    /**
     * Vraca listu svih rezervacija u terminu.
     *
     * @return rezervacije kao lista objekata Rezervacija.
     */
    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    /**
     * Postavlja vrednost atributa rezervacije.
     *
     * @param rezervacije kao nova lista svih rezervacija putovanja u odredjenom terminu.
     */
    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }
}