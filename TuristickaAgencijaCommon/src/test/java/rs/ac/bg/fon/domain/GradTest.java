package rs.ac.bg.fon.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradTest {

    private Grad grad;
    @BeforeEach
    void setUp() {
        this.grad = new Grad();
    }

    @AfterEach
    void tearDown() {
        this.grad = null;
    }

    @Test
    void setGradID() {
        grad.setGradID(1);
        assertEquals(1, grad.getGradID());
    }

    @Test
    void setNaziv() {
        grad.setNaziv("Beograd");
        assertEquals("Beograd", grad.getNaziv());
    }

    @Test
    void setDrzava() {
        grad.setDrzava("Srbija");
        assertEquals("Srbija", grad.getDrzava());
    }

    @Test
    void testToString() {
        grad.setNaziv("Beograd");
        grad.setDrzava("Srbija");

        assertTrue(grad.toString().contains("Beograd"));
        assertTrue(grad.toString().contains("Srbija"));
    }
}