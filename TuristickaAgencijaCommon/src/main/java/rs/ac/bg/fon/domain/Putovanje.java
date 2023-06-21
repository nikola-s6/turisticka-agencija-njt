package rs.ac.bg.fon.domain;

import rs.ac.bg.fon.domain.util.Ponuda;
import rs.ac.bg.fon.domain.util.Prevoz;
import rs.ac.bg.fon.domain.util.Smestaj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Predstavlja putovanje dostupno u turistickoj agenciji za rezervaciju.
 * Klasa Putovanje sadrzi putovanjeID, naziv, pocetniGrad, krajnjiGrad, prevoz, smestaj i kratakOpis.
 *
 * @author Nikola Stojilkovic
 */
public class Putovanje implements Serializable{

    /**
     * ID putovanja kao int.
     */
    private int putovanjeID;

    /**
     * Naziv putovanja kao String.
     */
    private String naziv;

    /**
     * Objekat klase Grad koji predstavlja grad odakle putovanje krece.
     */
    private Grad pocetniGrad;

    /**
     * Objekat klase Grad koji predstavlja zavrsnu destinaciju putovanja.
     */
    private Grad krajnjiGrad;

    /**
     * Nacin prevoza putnika tokom putovanja.
     */
    private Prevoz prevoz;

    /**
     * Smestaj putnika tokom putovanja.
     */
    private Smestaj smestaj;

    /**
     * Ponuda pansiona sadrzanog u putovanju.
     */
    private Ponuda ponuda;

    /**
     * Kratak opis putovanja kao String.
     */
    private String kratakOpis;

    /**
     * Lista dostupnih termina za dato putovanje.
     * Lista ne moze biti null, ali moze biti prazna.
     */
    private List<Termin> termini;

    /**
     * Lista usputnih gradova koji se obilaze tokom putovanja od pocetne do krajnje destinacije (grada).
     * Lista ne moze biti null, ali moze biti prazna.
     */
    private List<Usputni> usputniGradovi;

    /**
     * Prazan konstruktor za kreiranje instance putovanja.
     * Inicijalizuje listu termina i usputnih gradova - ArrayList implementacija.
     */
    public Putovanje() {
        this.termini = new ArrayList<>();
        this.usputniGradovi = new ArrayList<>();
    }

    /**
     * Parametrizovani konstruktor za kreiranje instance putovnja.
     * Pored prosledjenih vrednosti inicijalizuje se i lista termina i usputnih gradova - ArrayList implementacija.
     *
     * @param putovanjeID Int vrednost ID-a putovanja.
     * @param naziv String vrednost naziva putovanja.
     * @param pocetniGrad Grad koij predstavlja pocetnu destinaciju putovanja.
     * @param krajnjiGrad Grad koji predstavlja krajnju destinaciju putovanja.
     * @param smestaj Vrednost tipa Smestaj koji predstavlja tip smestaja tokom putovanja.
     * @param ponuda Vrednost tipa Ponuda koji predstavlja ponudu pansiona putovanja.
     * @param kratakOpis String vrednost opisa putovanja.
     */
    public Putovanje(int putovanjeID, String naziv, Grad pocetniGrad, Grad krajnjiGrad, Smestaj smestaj, Ponuda ponuda, String kratakOpis) {
        setPutovanjeID(putovanjeID);
        setNaziv(naziv);
        setPocetniGrad(pocetniGrad);
        setKrajnjiGrad(krajnjiGrad);
        setSmestaj(smestaj);
        setPonuda(ponuda);
        setKratakOpis(kratakOpis);
        this.termini = new ArrayList<>();
        this.usputniGradovi = new ArrayList<>();
    }

    /**
     * Vraca ID putovanja.
     *
     * @return putovanjeID kao int vrednost.
     */
    public int getPutovanjeID() {
        return putovanjeID;
    }

    /**
     * Postavlja vrednost atributa putovanjeID.
     *
     * @param putovanjeID nova vrednost atributa putovanjeID.
     */
    public void setPutovanjeID(int putovanjeID) {
        if(putovanjeID == 0){
            throw new IllegalArgumentException("Id putovanja ne sme biti promenjen na 0");
        }
        this.putovanjeID = putovanjeID;
    }

    /**
     * Vraca vrednost atributa naziv.
     *
     * @return naziv putovanja.
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Postavlja vrednost atributa naziv.
     *
     * @param naziv String vrednost naziva putovanja.
     */
    public void setNaziv(String naziv) {
        if(naziv == null){
            throw new NullPointerException("Naziv putovanja ne sme biti null");
        }
        if(naziv.isEmpty()){
            throw new IllegalArgumentException("Naziv putovanja mora biti prosledjen");
        }
        this.naziv = naziv;
    }

    /**
     * Vraca grad koji predstavlja pocetnu destinaciju putovanja.
     *
     * @return objekat klase grad koji predstavlja pocetni grad putovanja.
     */
    public Grad getPocetniGrad() {
        return pocetniGrad;
    }

    /**
     * Postavlja pocetni grad putovanja.
     *
     * @param pocetniGrad Objekat klase Grad koji predstavlja pocetni grad putovanja.
     */
    public void setPocetniGrad(Grad pocetniGrad) {
        if(pocetniGrad == null){
            throw new NullPointerException("Pocetni grad putovanja ne sme biti null");
        }
        this.pocetniGrad = pocetniGrad;
    }

    /**
     * Vraca grad koji predstavlja krajnju destinaciju putovanja.
     *
     * @return objekat klase grad koji predstavlja krajnju destinaciju putovanja.
     */
    public Grad getKrajnjiGrad() {
        return krajnjiGrad;
    }

    /**
     * Postavlja grad koji predstavlja krajnju destinaciju putovanja.
     *
     * @param krajnjiGrad Objekat klase Grad koji predstavlja krajnju destinaciju putovanja.
     */
    public void setKrajnjiGrad(Grad krajnjiGrad) {
        if(krajnjiGrad == null){
            throw new NullPointerException("Krajnji grad putovanja ne sme biti null");
        }
        this.krajnjiGrad = krajnjiGrad;
    }

    /**
     * Vraca vrednost atributa prevoz koji pokazuje nacin transporta putnika tokom putovanja.
     *
     * @return nacin prevoza putnika kao vrednost enum-a Prevoz.
     */
    public Prevoz getPrevoz() {
        return prevoz;
    }

    /**
     * Postavlja vrednost atributa prevoz.
     *
     * @param prevoz vrednost atributa prevoz tipa Prevoz.
     */
    public void setPrevoz(Prevoz prevoz) {
        if(prevoz == null){
            throw new NullPointerException("Prevoz ne sme biti promenjen na null");
        }
        this.prevoz = prevoz;
    }

    /**
     * Vraca vrednost atributa koji pokazuje tip smestaja tokom putovanja.
     *
     * @return tip smestaja tokom putovanja kao vrednost enum-a Smestaj.
     */
    public Smestaj getSmestaj() {
        return smestaj;
    }

    /**
     * Postavlja vrednost atributa smestaj.
     *
     * @param smestaj vrednost atributa smestaj tipa Smestaj.
     */
    public void setSmestaj(Smestaj smestaj) {
        if (smestaj == null){
            throw new NullPointerException("Smestaj ne sme biti promenjen na null");
        }
        this.smestaj = smestaj;
    }

    /**
     * Vraca vredsnot atributa koji pokazuje ponudu pansiona za putovanje.
     *
     * @return tip ponude pansiona kao vrednost enum-a Ponuda.
     */
    public Ponuda getPonuda() {
        return ponuda;
    }

    /**
     * Postavlja vrednost atributa ponuda.
     *
     * @param ponuda vrednost atributa ponuda tipa Ponuda.
     */
    public void setPonuda(Ponuda ponuda) {
        if (ponuda == null){
            throw new NullPointerException("Ponuda ne sme biti promenjena na null");
        }
        this.ponuda = ponuda;
    }

    /**
     * Vraca kratak opis putovanja.
     *
     * @return kratak opis putovanja kao String.
     */
    public String getKratakOpis() {
        return kratakOpis;
    }

    /**
     * Postavlja vrednost atributa karatakOpis.
     *
     * @param kratakOpis String vrednost za postavljanje opisa.
     */
    public void setKratakOpis(String kratakOpis) {
        if(kratakOpis == null){
            throw new NullPointerException("Opis putovanaj ne sme biti null");
        }
        if (kratakOpis.isEmpty()){
            throw new IllegalArgumentException("Opis putovanja ne sme biti prazan");
        }
        this.kratakOpis = kratakOpis;
    }

    /**
     * Vraca listu termina putovanja.
     *
     * @return lista termina putovanja.
     */
    public List<Termin> getTermini() {
        return termini;
    }

    /**
     * Postavlja listu termina putovanja.
     *
     * @param termini lista sa terminima putovanja.
     */
    public void setTermini(List<Termin> termini) {
        if(termini == null){
            throw new NullPointerException("Termini ne smeju biti promenjeni na null");
        }
        this.termini = termini;
    }

    /**
     * Vraca listu usputnih gradova putovanja.
     *
     * @return lista usputnih gradova putovanja.
     */
    public List<Usputni> getUsputniGradovi() {
        return usputniGradovi;
    }

    /**
     * Postavlja listu usputnih gradova putovanja.
     *
     * @param usputniGradovi lista sa usputnim gradovima putovanja.
     */
    public void setUsputniGradovi(List<Usputni> usputniGradovi) {
        if (usputniGradovi == null){
            throw new NullPointerException("Usputni gradovi putovanja ne smeju biti promenjeni na null");
        }
        this.usputniGradovi = usputniGradovi;
    }
}