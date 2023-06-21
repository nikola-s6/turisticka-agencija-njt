package rs.ac.bg.fon.domain;

import java.io.Serializable;

/**
 * Predstavlja grad koji je deo nekog putovanja.
 * Sadrzi gradID, naziv i drzavu.
 *
 * @author Nikola Stojilkovic
 */
public class Grad implements Serializable {
    /**
     * ID grada kao int.
     */
    private int gradID;

    /**
     * Naziv grada kao String.
     */
    private String naziv;

    /**
     * Drzava u kojoj se grad nalazi kao String vrednost.
     */
    private String drzava;

    /**
     * Prazan konstruktor za kreiranje instance grada.
     */
    public Grad() {
    }

    /**
     * Parametrizovani konstruktor za kreiranje instance grada.
     *
     * @param gradID Int vrednost ID-a grada.
     * @param naziv String vrednost naziva grada.
     * @param drzava String vrednost za naziv drzave u kojoj se grad nalazi.
     */
    public Grad(int gradID, String naziv, String drzava){
        setGradID(gradID);
        setNaziv(naziv);
        setDrzava(drzava);
    }

    /**
     * Vraca ID grada
     *
     * @return gradID kao int vrednost.
     */
    public int getGradID() {
        return gradID;
    }

    /**
     * Postavlja vrednost atributa gradID.
     *
     * @param gradID nova vrednost atributa gradID.
     * @throws IllegalArgumentException ukoliko je gradID 0
     */
    public void setGradID(int gradID){
        if(gradID == 0){
            throw new IllegalArgumentException("Id grada ne sme da se postavi na 0");
        }
        this.gradID = gradID;
    }

    /**
     * Vraca String vrednost naziva grada.
     *
     * @return naziv grada.
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Postavlja vrednost atributa naziv koji predstavlja naziv grada.
     *
     * @param naziv nova vrednost atributa naziv.
     * @throws  NullPointerException ukoliko je naziv grada null
     * @throws IllegalArgumentException ukoliko je naziv prazan string ili ako naziv grada ne pocinje velikim slovom
     */
    public void setNaziv(String naziv) {
        if(naziv == null){
            throw new NullPointerException("Naziv grada ne sme biti null");
        }
        if(naziv.isEmpty()){
            throw new IllegalArgumentException("Naziv grada mora biti prosledjen!");
        }
        if(!Character.isUpperCase(naziv.charAt(0))){
            throw new IllegalArgumentException("Naziv grada mora pocinjati velikim slovom");
        }
        this.naziv = naziv;
    }

    /**
     * Vraca String vresnost naziva drzave u kojoj se grad nalazi.
     *
     * @return drzava u kojoj se grad nalazi.
     */
    public String getDrzava() {
        return drzava;
    }

    /**
     * Postavlja vrednost atributa drzava koji predstavlja naziv drzave u kojoj se grad nalazi.
     *
     * @param drzava nova vrednost atributa drzava.
     * @throws NullPointerException ukoliko je drzava null
     * @throws IllegalArgumentException ukoliko je ime drzave prazan string ili ukoliko ne pocinje velikim slovom
     */
    public void setDrzava(String drzava) {
        if(drzava == null){
            throw new NullPointerException("Drzava ne sme biti null");
        }
        if(drzava.isEmpty()){
            throw new IllegalArgumentException("Naziv drzave mora biti prosledjen!");
        }
        if(!Character.isUpperCase(drzava.charAt(0))){
            throw new IllegalArgumentException("Naziv drzave mora pocinjati velikim slovom");
        }
        this.drzava = drzava;
    }


    @Override
    public String toString() {
        return this.naziv + ", " + this.drzava;
    }


}
