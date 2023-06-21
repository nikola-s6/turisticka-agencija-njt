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
    public Grad(int gradID, String naziv, String drzava) throws Exception {
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
     */
    public void setGradID(int gradID) throws Exception {
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
     */
    public void setNaziv(String naziv) {
        if(naziv == null || naziv.equals("")){
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
     */
    public void setDrzava(String drzava) {
        if(drzava == null || drzava.equals("")){
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
