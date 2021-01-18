package ec.edu.epn.sistemaDeVoto.model;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ElectorTest {

    private static Categoria categoriaPrueba;
    private static PartidoPolitico partidoPrueba;

    @BeforeClass
    public static void setUpClass() {
        categoriaPrueba = new Categoria("Binomio Presidencial");
        Dignidad presidente = new Dignidad("Presidente/a");
        Dignidad vicepresidente = new Dignidad("Vicepresidente/a");
        categoriaPrueba.agregarDignidad(presidente);
        categoriaPrueba.agregarDignidad(vicepresidente);

        partidoPrueba = new PartidoPolitico("Apoyo a la ciudadanía", 42);

        Candidato canPresidente = new Candidato("Juan Luis", "Perez Lopez", presidente, 150);
        Candidato canVice = new Candidato("María Juliana", "Maldonado Tusa", vicepresidente, 150);
        partidoPrueba.agregarCandidatos(canPresidente);
        partidoPrueba.agregarCandidatos(canVice);
    }

    @Test
    public void given_partido_and_category_when_voting_then_ok() {
        Elector elector = new Elector("1724466543" ,"MAHATMA ISRAEL", "QUIJANO ZANIPATTINI");
        List<Candidato> expected = new ArrayList<Candidato>();
        expected.add(new Candidato("Juan Luis", "Perez Lopez", new Dignidad("Presidente/a")));
        expected.add(new Candidato("María Juliana", "Maldonado Tusa", new Dignidad("Vicepresidente/a")));
        assertEquals(expected, elector.votar(partidoPrueba, categoriaPrueba));
    }

}