package rs.ac.bg.fon.domain;


import rs.ac.bg.fon.domain.util.Pol;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Predstavlja putnika sa njegovim osnovnim licnim podacima, kao i listom njegovih rezervacija.
 * Klasa Putnik sadrzi purnikID, ime, prezime, pol, email, brojTelefona, sifru i rezervacije.
 *
 * @author Nikola Stojilkovic
 */
public class Putnik implements Serializable{

    /**
     * ID putnika kao int.
     */
    private int putnikID;
    /**
     * Ime putnika kao String.
     */
    private String ime;

    /**
     * Prezime putnika kao String.
     */
    private String prezime;

    /**
     * Pol putnika kao tip Pol.
     */
    private Pol pol;

    /**
     * Email putnika kao String.
     */
    private String email;

    /**
     * Broj telefona kao String.
     */
    private String brojTelefona;

    /**
     * Sifru putnika kao String za prijavljivanje na korisnicki nalog.
     * Sifra putnika treba da bude hash vrednost originalne sifre.
     */
    private String sifra;

    /**
     * Lista rezervacija putnika.
     *
     * Lista ne moze biti null, ali moze biti prazna. Lista sadrzi sve aktivne ali i neaktivne rezervacije putnika.
     */

    private List<Rezervacija> rezervacije;

    /**
     * Prazan konstruktor za kreiranje instance putnika.
     * Inicijalizuje listu rezervacija - ArrayList implementacija.
     */
    public Putnik() {
        this.rezervacije = new ArrayList<>();
    }

    /**
     * Parametrizovani konstruktor za kreiranje instance putnika.
     * Pored postavljenih vrednosti inicijalizuje i listu rezervacija - ArrayList implementacija.
     *
     * @param putnikID Int vrednost ID-a putnika
     * @param ime String vrednost imena putnika.
     * @param prezime String vrednost prezimena putnika.
     * @param pol Pol putnika koji je tipa Pol.
     * @param email String vrednost email-a putnika.
     * @param brojTelefona String vrednost broja telefona putnika.
     * @param sifra String vredsnot sifre putnika.
     */
    public Putnik(int putnikID, String ime, String prezime, Pol pol, String email, String brojTelefona, String sifra) {
        setPutnikID(putnikID);
        setIme(ime);
        setPrezime(prezime);
        setPol(pol);
        setEmail(email);
        setBrojTelefona(brojTelefona);
        setSifra(sifra);
        this.rezervacije = new ArrayList<>();
    }

    /**
     * Vraca  ID putnika.
     *
     * @return putnikID kao int vrednost.
     */
    public int getPutnikID() {
        return putnikID;
    }

    /**
     * Postavlja vrednost atributa putnikID.
     *
     * @param putnikID nova vrednost atributa putnikID.
     */
    public void setPutnikID(int putnikID) {
        this.putnikID = putnikID;
    }

    /**
     * Vraca ime putnika.
     *
     * @return ime putnika.
     */
    public String getIme() {
        return ime;
    }

    /**
     * Posatavlja vrednost atributa ime.
     *
     * @param ime String vrednost za ime putnika.
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * Vraca prezime putnika.
     *
     * @return prezime putnika.
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Postavlja vrednost atributa prezime.
     *
     * @param prezime String vrednost za prezime putnika.
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * Vraca vrednost pola putnika.
     * @return pol putnika kao vrednost enum-a Pol.
     */
    public Pol getPol() {
        return pol;
    }

    /**
     * Postavlja vrednost atributa pol.
     *
     * @param pol vrednost atributa pol tipa Pol.
     */
    public void setPol(Pol pol) {
        this.pol = pol;
    }

    /**
     * Vraca email putnika.
     *
     * @return email kao String.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Postavlja vrednost atributa email.
     *
     * @param email nova vrednost atributa email kao String.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Vraca vrednost atributa brojTelefona.
     *
     * @return broj telefona putnika kao String vrednost.
     */
    public String getBrojTelefona() {
        return brojTelefona;
    }

    /**
     * Postavlja vrednost atributa brojTelefona.
     *
     * @param brojTelefona String vrednost broja telefona.
     */
    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    /**
     * Vraca vrednost atributa sifra.
     * Vrednost ovog atributa u aplikaciji ce uvek biti hash-irana.
     *
     * @return sifra kao String vrednost sifre putnika.
     */
    public String getSifra() {
        return sifra;
    }

    /**
     * Postavlja vrednost atributa sifra.
     *
     * @param sifra nova vrednost atributa sifra.
     */
    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    /**
     * Vraca listu rezervacija putnika.
     * @return lista sa rezervacijama putnika.
     */
    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    /**
     * Postavlja listu sa rezervacijama putnika.
     *
     * @param rezervacije lista sa rezervacijama putnika.
     */
    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[id: ");
        sb.append(putnikID);
        sb.append(", ime: ");
        sb.append(ime);
        sb.append(", prezime: ");
        sb.append(prezime);
        sb.append(", pol: ");
        sb.append(pol.toString().toLowerCase());
        sb.append(", email: ");
        sb.append(email);
        sb.append(", broj telefona: ");
        sb.append(brojTelefona);
        sb.append("]");
        return sb.toString();
    }
}
