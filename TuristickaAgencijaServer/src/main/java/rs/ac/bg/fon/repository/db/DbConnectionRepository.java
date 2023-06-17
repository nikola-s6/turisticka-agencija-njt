package rs.ac.bg.fon.repository.db;

import rs.ac.bg.fon.repository.Repository;

/**
 * Genericki interfejs koji nasledjuje interfejs Repository.
 * Interfejs DbConnectionRepository sadrzi default metode koje sluze za upravljanje konekcijom
 * sa bazom podataka. Takodje interfejs sadrzi metode za upravljanje transakcijama.
 *
 * @param <T> predstavlja tip podataka (domensku klasu) za nasledjene metode iz repozitorijuma Repository
 * @see rs.ac.bg.fon.repository.Repository
 * @author Nikola Stojikovic
 */
public interface DbConnectionRepository<T> extends Repository<T> {

    /**
     * Default metoda za otvaranje konekcije sa bazom podataka.
     * Ukoliko je konekcija vec otvorena metoda nece otvoriti novu konekciju.
     *
     * @throws Exception ukoliko nije moguce ostvariti konekciju sa bazom podataka.
     */
    default public void connect() throws Exception {
        DbConnectionFactory.getInstance().getConnection();
    }

    /**
     * Metoda koja sluzi za prekidanje konekcije sa bazom podataka.
     * @throws Exception ukoliko dodje do greske prilikom prekidnja konekcije sa bazom podataka.
     */
    default public void disconnect() throws Exception {
        DbConnectionFactory.getInstance().getConnection().close();
    }

    /**
     * Metoda koja sluzi za povrdu transakcije baze podataka.
     *
     * @throws Exception ukoliko dodje do graske prilikom potvrde transakcije.
     */
    default public void commit() throws Exception {
        DbConnectionFactory.getInstance().getConnection().commit();
    }

    /**
     * Metoda koja sluzi za ponistavanje transakcije i vracanje stanja baze podataka na prethodnu potvrdu.
     *
     * @throws Exception ukoliko tokom ponistavanja transakcije dodje do greske.
     */
    default public void rollback() throws Exception {
        DbConnectionFactory.getInstance().getConnection().rollback();
    }
}
