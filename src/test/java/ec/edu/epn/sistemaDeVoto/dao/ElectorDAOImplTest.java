package ec.edu.epn.sistemaDeVoto.dao;

import ec.edu.epn.sistemaDeVoto.dao.ElectorDAOImpl;
import ec.edu.epn.sistemaDeVoto.model.Elector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class ElectorDAOImplTest {

    @Test
    public void given_invalid_id_when_searching_in_files_then_error() {
        ElectorDAOImpl md = new ElectorDAOImpl();
        assertNull(md.comprobarElector("1784520365")); // Cédula Incorrecta
    }

    @Test(timeout = 45)
    public void given_valid_id_when_serching_in_files_then_timeout() {
        ElectorDAOImpl md = new ElectorDAOImpl();
        assertNotNull(md.comprobarElector("0200573947")); // Cédula válida
    }

}