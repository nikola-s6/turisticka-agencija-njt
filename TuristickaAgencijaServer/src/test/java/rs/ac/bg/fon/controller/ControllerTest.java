package rs.ac.bg.fon.controller;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import rs.ac.bg.fon.domain.*;
import rs.ac.bg.fon.domain.util.Pol;


class ControllerTest {

    Controller controller = Controller.getInstance();

    @Test
    void zapamtiPutnikaKreiranje() throws Exception {
        Putnik p = new Putnik();
        p.setIme("Nikola");
        p.setPrezime("Stojilkvoic");
        p.setPol(Pol.MUSKI);
        p.setEmail("nikola.stojilkovic6@gmail.com");
        p.setBrojTelefona("0601111111");
        p.setSifra("nikola123");
        controller.zapamtiPutnika(p);

        Putnik pPretraga = new Putnik();
        pPretraga.setPutnikID(1);
        Putnik dbPutnik = controller.ucitajPutnika(pPretraga);
        assertEquals(1, dbPutnik.getPutnikID());
        assertEquals(p.getIme(), dbPutnik.getIme());
        assertEquals(p.getPrezime(), dbPutnik.getPrezime());
        assertEquals(p.getPol(), dbPutnik.getPol());
        assertEquals(p.getEmail(), dbPutnik.getEmail());
        assertEquals(p.getBrojTelefona(), dbPutnik.getBrojTelefona());
        assertEquals(Integer.toString(p.getSifra().hashCode()), dbPutnik.getSifra());
    }


}