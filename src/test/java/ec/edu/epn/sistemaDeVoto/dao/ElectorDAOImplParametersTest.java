package ec.edu.epn.sistemaDeVoto.dao;

import ec.edu.epn.sistemaDeVoto.model.Elector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class ElectorDAOImplParametersTest {

    private String cedulaElector;
    private Elector expected;

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters() {
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{"1724466543", new Elector("1724466543", "MAHATMA ISRAEL", "QUIJANO ZANIPATTINI")});
        objects.add(new Object[]{"1720817095", new Elector("1720817095", "DIANA STEFANIA", "LOPEZ PRIKHODKO")});
        objects.add(new Object[]{"1717238412", new Elector("1717238412","LIDIA","LOPEZ VINUEZA")});
        objects.add(new Object[]{"0200573947", new Elector("0200573947", "JAIME FERNANDO","QUIJANO ACOSTA")});
        return objects;
    }

    public ElectorDAOImplParametersTest(String cedulaElector, Elector expected) {
        this.cedulaElector = cedulaElector;
        this.expected = expected;
    }

    @Test
    public void given_parameters_when_searching_in_files_then_ok() {
        ElectorDAOImpl md = new ElectorDAOImpl();
        assertEquals(expected, md.comprobarElector(cedulaElector));
    }
}