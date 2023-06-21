package rs.ac.bg.fon.domain;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Klasa koja predstavlja usputni grad nekog putovanja.
 * Klasa Usputni sadrzi objekat klase Grad, objekat klase Putovanje i rednji broj putovanja.
 *
 * @author Nikola Stojilkovic
 */
public class Usputni implements Serializable {

    /**
     * Objekat klase grad koji predstavlja usputni grad putovanja.
     */
    @Expose
    private Grad grad;

    /**
     * Objekat klase putovanje koji predstavlja putovanje za koje je vezan usputni grad.
     */
    private Putovanje putovanje;

    /**
     * Redni broj koji oznacava koji je po redu odgovarajuci grad u nizu usputnih gradova.
     */
    @Expose
    private int redniBroj;

    /**
     * Neparametrizovani konstruktor za kreiranje instance klase Upsutni.
     */
    public Usputni() {
    }

    /**
     * Parametrizovani konstruktor za kreiranje instance klase Usputni.
     * @param grad Objekat tipa Grad koji pradstavlja koji grad se upisuje kao usputni.
     * @param putovanje Objekat klase Putovanje koji predstavlja za koje putovanje se vezuje usputni grad.
     * @param redniBroj Int vrednost rednog broja putovanja.
     */
    public Usputni(Grad grad, Putovanje putovanje, int redniBroj) {
        setGrad(grad);
        setPutovanje(putovanje);
        setRedniBroj(redniBroj);
    }

    /**
     * Vraca grad usputni grad.
     *
     * @return usputni grad.
     */
    public Grad getGrad() {
        return grad;
    }

    /**
     * Postavlja vrednost atributa grad.
     *
     * @param grad Objekat klase Grad koji predstavlja pocetni grad.
     * @throws NullPointerException ako je grad null
     */
    public void setGrad(Grad grad) {
        if (grad == null){
            throw new NullPointerException("Usputni grad ne sme biti null");
        }
        this.grad = grad;
    }

    /**
     * Vraca vrednost atributa putovanje.
     *
     * @return putovanje za koje je vezan usputni grad.
     */
    public Putovanje getPutovanje() {
        return putovanje;
    }

    /**
     * Postavlja vrednost atributa putovanje.
     *
     * @param putovanje Objekat klase Putovanje koji vezuje putovanje za pocetni grad.
     * @throws NullPointerException ako je putovanje null
     */
    public void setPutovanje(Putovanje putovanje) {
        if(putovanje == null){
            throw new NullPointerException("Putovanje ne sme biti null");
        }
        this.putovanje = putovanje;
    }

    /**
     * Vraca vrednost atributa redniBroj.
     *
     * @return redniBroj kao int vrenost.
     */
    public int getRedniBroj() {
        return redniBroj;
    }

    /**
     * Postavlja vrednost atributa redniBroj.
     *
     * @param redniBroj Int vrednost atributa vredniBroj.
     * @throws IllegalArgumentException ako je redniBroj za neki usputni grad putovanja 0
     */
    public void setRedniBroj(int redniBroj) {
        if(redniBroj == 0){
            throw new IllegalArgumentException("Redni broj usputnig grada ne sme biti promenjen na 0");
        }
        this.redniBroj = redniBroj;
    }
}