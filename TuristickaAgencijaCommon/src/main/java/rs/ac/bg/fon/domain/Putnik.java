package rs.ac.bg.fon.domain;


import rs.ac.bg.fon.domain.util.Pol;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
     * @throws IllegalArgumentException ukoliko je putnikID 0
     */
    public void setPutnikID(int putnikID) {
        if(putnikID == 0){
            throw new IllegalArgumentException("Id putnika ne sme biti promenjen na 0");
        }
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
     * @throws NullPointerException ukoliko je ime null
     * @throws IllegalArgumentException ukolike duzina imena nije duza od jednog karaktera
     * ili ukoliko ime ne pocinje velikim slovom
     */
    public void setIme(String ime) {
        if(ime == null){
            throw new NullPointerException("Ime ne sme bit null");
        }
        if(!(ime.length() > 1)){
            throw new IllegalArgumentException("Ime mora biti duze od jednog karaktera");
        }
        if(!Character.isUpperCase(ime.charAt(0))){
            throw new IllegalArgumentException("Ime mora pocinjati velikim slovom");
        }
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
     * @throws NullPointerException ukoliko je prezime null
     * @throws IllegalArgumentException ukoliko duzina prezimena nije duza od jednog karaktera ili
     * ukoliko prezime ne pocinje velikim slovom
     */
    public void setPrezime(String prezime) {
        if(prezime == null){
            throw new NullPointerException("Prezime ne sme biti null");
        }
        if(!(prezime.length() > 1)){
            throw new IllegalArgumentException("Prezime mora biti duze od jednog karaktera");
        }
        if(!Character.isUpperCase(prezime.charAt(0))){
            throw new IllegalArgumentException("Prezime mora pocinjati velikim slovom");
        }
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
     * @throws NullPointerException ukoliko je email null
     * @throws IllegalArgumentException ukoliko je prezime prazan string ili ukoliko string nije u email obliku.
     */
    public void setEmail(String email) {
        if(email == null){
            throw new NullPointerException("Email ne sme biti null");
        }
        if(email.isEmpty()){
            throw new IllegalArgumentException("Email mora biti prosledjen");
        }
        if(!Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$").matcher(email).matches()){
            throw new IllegalArgumentException("Email mora ima biti u odgovarajucoj formi");
        }
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
     * @throws NullPointerException ukoliko je brojTelefona null
     * @throws IllegalArgumentException ukoliko je brojTelefona prazan string
     */
    public void setBrojTelefona(String brojTelefona) {
        if(brojTelefona == null){
            throw new NullPointerException("Broj telefona ne sme biti null");
        }
        if(brojTelefona.isEmpty()){
            throw new IllegalArgumentException("Broj telefona mora biti prosledjen");
        }
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
     * @throws NullPointerException ukoliko je sifra null
     * @throws IllegalArgumentException ukoliko je sifra 3 karatkera ili kraca
     */
    public void setSifra(String sifra) {
        if(sifra == null){
            throw new NullPointerException("Sifra ne sme biti null");
        }
        if(!(sifra.length() > 3)){
            throw new IllegalArgumentException("Sifra mora biti duza od 3 karaktera");
        }
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
     * @throws NullPointerException ukoliko je lista rezervacija null
     */
    public void setRezervacije(List<Rezervacija> rezervacije) {
        if(rezervacije == null){
            throw new NullPointerException("Rezervacije ne smeju biti promenjene na null");
        }
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
