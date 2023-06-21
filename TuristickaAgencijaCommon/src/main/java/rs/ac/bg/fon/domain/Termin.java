package rs.ac.bg.fon.domain;

import com.google.gson.annotations.Expose;

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
    @Expose
    private int terminID;

    /**
     * Cena putovanja u terminu kao double vrednost.
     */
    @Expose
    private Double cena;

    /**
     * Datum polaska putnika na putovnje.
     */
    @Expose
    private Date datumPolaska;

    /**
     * Datum povratka putnika sa putovanja.
     */
    @Expose
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
        setTerminID(terminID);
        setCena(cena);
        setDatumPovratka(datumPolaska);
        setDatumPovratka(datumPovratka);
        setPutovanje(putovanje);
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
     * @throws IllegalArgumentException ako je terminID 0
     */
    public void setTerminID(int terminID) {
        if (terminID == 0){
            throw new IllegalArgumentException("Id termina ne sme biti promenjen na 0");
        }
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
     * @throws IllegalArgumentException ako je cena manja od 1000rsd
     */
    public void setCena(Double cena) {
        if (cena < 1000d){
            throw new IllegalArgumentException("Cena putovanja u nekom terminu mora biti veca od 1000rsd");
        }
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
     * @throws NullPointerException ako je datumPolaska null
     */
    public void setDatumPolaska(Date datumPolaska) {
        if (datumPolaska == null){
            throw new NullPointerException("Datum polaska na putovanje ne sme biti null");
        }
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
     * @throws NullPointerException ako je datumPovratka null
     */
    public void setDatumPovratka(Date datumPovratka) {
        if (datumPovratka == null){
            throw new NullPointerException("Datum povratka sa putovanja ne sem biti null");
        }
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
     * @throws NullPointerException ako je putovanje null
     */
    public void setPutovanje(Putovanje putovanje) {
        if(putovanje == null){
            throw new NullPointerException("Putovanje ne sme biti null");
        }
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
     * @throws NullPointerException ako je lista rezervacija za neki termin null
     */
    public void setRezervacije(List<Rezervacija> rezervacije) {
        if(rezervacije == null){
            throw new NullPointerException("Rezervacije u nekom terminu ne smeju biti promenjene na null");
        }
        this.rezervacije = rezervacije;
    }
}