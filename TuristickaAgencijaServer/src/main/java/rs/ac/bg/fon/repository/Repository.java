package rs.ac.bg.fon.repository;

import java.util.List;

/**
 * Genericka klasa Repository predstavlja ugovorene metode za komunikaciju pojedinacnih
 * repozitorijuma domenskih klasa sa bazom podataka.
 * @param <T> predstavlja tip podataka (domensku klasu) za kojiu se komunicira sa bazom podataka.
 * @author Nikola Stojilkovic
 */
public interface Repository<T> {

    /**
     * Predstavlja metodu za pretragu baze podataka uz parametar pretrage.
     * Parametar je prosledjen u obliku objekta ciji su atributi postavljeni u zavisnosti od implementacione klase.
     *
     * @param param objekat neke od domenskih klasa ciji atributi predstavljaju parametre pretrage podataka iz baze podataka.
     * @return lista svih objekata iz baze podataka koji odgovaraju datom parametru pretrage.
     * @throws Exception ukoliko sistem ne moze da ucita podatke iz baze podataka.
     */
    List<T> getAll(T param) throws Exception;

    /**
     * Metoda koja vraca listu svih objekata iz baze podataka odgovarajuce klase.
     * @return lista svih objekata zadate domenske klase.
     * @throws Exception ukoliko sistem ne moze da ucita podatke iz baze podataka.
     */
    List<T> getAll() throws Exception;

    /**
     * Metoda koja vraca jedinstven objekat iz baze podataka koji odgovara parametru pretrage.
     *
     * @param param objekat neke domenske klase koji sluzi kao parametar pretrage baze podataka.
     * @return objekat domenkse klase koji je rezultat jedinstvene pretrage baze podataka.
     * @throws Exception ukoliko sistem ne moze da ucita podatke iz baze podataka.
     */
    T getOne(T param) throws Exception;

    /**
     * Meotoda koja sluzi za perzistenciju (cuvanje) objekata domenskih klasa u bazu podataka.
     * Metoda prima jedan objekat klase, ne radi sa listom.
     * @param param objekat domenske klase koji je potrebno upisati u bazu podataka.
     * @throws Exception ukoliko je tokom cuvanja podataka doslo do greske u bazi podataka.
     */
    void add(T param) throws Exception;

    /**
     * Metoda koja sluzi za izmenu entiteta baze podataka.
     * Kao parametar je porsledjen objekat domenske klase koji ce predstavljati izmenjeni entitet iz baze.
     * Takodje pretraga objekta koji je potrebno izmeniti se obavlja uz pomoc jedinstvenog indetifikatora
     * koji je dat kao atribut parametra.
     *
     * @param param objekat domenske klase koji sadrzi jedinstveni identifikator i izmenjene podatke.
     * @throws Exception ukoliko je tokom izmene entiteta u bazi podataka doslo do greske.
     */
    void edit(T param) throws Exception;

    /**
     * Metoda koja sluzi za brisanje entiteta baze podataka.
     * Za odredjivanje koji entitet je za brisanje porsledjuje se objekat
     * domenske klase koji ima postavljen jedinstveni identifikator u vidu atributa objekta.
     *
     * @param param objekat domenske klase koji je potrebno obrisati iz baze podataka.
     * @throws Exception ukoliko toom brisanja entiteta iz baze podataka dodje do greske.
     */
    void delete(T param) throws Exception;
}
