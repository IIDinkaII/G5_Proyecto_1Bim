package ec.edu.epn.sistemaDeVoto.model;

import ec.edu.epn.sistemaDeVoto.model.Login;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginTest {

    private Login log;

    @Before
    public void setUp(){
        log = new Login();
    }

    @Test
    public void given_valid_id_when_log_in_then_ok() {
        assertTrue(log.ingresarAlSistema("1724466543"));
    }

    @Test(timeout = 65)
    public void given_valid_id_when_log_in_then_timeout(){
        assertFalse(log.ingresarAlSistema("0921447272")); //Cédula válida que no se encuentra en el archivo
    }

}