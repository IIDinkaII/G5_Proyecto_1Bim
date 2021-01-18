package ec.edu.epn.sistemaDeVoto.model;

import ec.edu.epn.sistemaDeVoto.model.ValidacionCedula;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class ValidacionCedulaTest {

    private ValidacionCedula vc;

    @Before
    public void setUp() {
        vc = new ValidacionCedula();
    }

    @Test
    public void given_invalid_id_when_validating_id_then_error() {
        assertFalse(vc.validarCI("172023394")); // Cédula Incorrecta
    }

    @Test(timeout = 10)
    public void given_valid_id_when_validating_id_the_timeout(){
        assertTrue(vc.validarCI("1720817095"));
    }

}
