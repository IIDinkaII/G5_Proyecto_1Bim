package ec.edu.epn.sistemaDeVoto.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class ValidacionCedulaParametersTest {

    private String cedula;
    private boolean expected;
    private ValidacionCedula vc;

    @Before
    public void setUp() {
        vc = new ValidacionCedula();
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters() {
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{"1724466543", true});  // Cédula Correcta
        objects.add(new Object[]{"1720817095", true});  // Cédula Correcta
        objects.add(new Object[]{"1717238412", true});  // Cédula Correcta
        objects.add(new Object[]{"0200573947", true});  // Cédula Correcta
        objects.add(new Object[]{"1720233943", false}); // Cédula Incorrecta
        return objects;
    }

    public ValidacionCedulaParametersTest(String cedula, boolean expected) {
        this.cedula = cedula;
        this.expected = expected;
    }

    @Test
    public void given_parameters_when_id_validation_then_ok() {
        assertEquals(expected, vc.validarCI(cedula));
    }
}