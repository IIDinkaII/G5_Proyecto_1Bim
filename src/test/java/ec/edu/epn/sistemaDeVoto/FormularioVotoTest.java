package ec.edu.epn.sistemaDeVoto;

import ec.edu.epn.sistemaDeVoto.model.Candidato;
import ec.edu.epn.sistemaDeVoto.model.Categoria;
import ec.edu.epn.sistemaDeVoto.model.Dignidad;
import ec.edu.epn.sistemaDeVoto.model.PartidoPolitico;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FormularioVotoTest {

    private static FormularioVoto formularioVoto;
    private static List<Categoria> listaCategorias;
    
    @BeforeClass
    public static void setUpClass() {
        // Categoría Binomio
        Categoria binomio = new Categoria("Binomio Presidencial");
        Dignidad presidente = new Dignidad("Presidente/a");
        Dignidad vicepresidente = new Dignidad("Vicepresidente/a");
        binomio.agregarDignidad(presidente);
        binomio.agregarDignidad(vicepresidente);
        /* --- Partidos --- */
        PartidoPolitico partido1 = new PartidoPolitico("Apoyo a la ciudadanía", 42);
        PartidoPolitico partido2 = new PartidoPolitico("Por un país justo", 51);
        /* --- Candidatos Binomio presidencial --- */
        Candidato canPresidente1 = new Candidato("Juan Luis", "Perez Lopez", presidente, 150);
        Candidato canVice1 = new Candidato("María Juliana", "Maldonado Tusa", vicepresidente, 150);
        partido1.agregarCandidatos(canPresidente1);
        partido1.agregarCandidatos(canVice1);
        Candidato canPresidente2 = new Candidato("Luis Alberto", "Lopez Villareal", presidente, 176);
        Candidato canVice2 = new Candidato("Alejandra María", "Ruiz Maldonado", vicepresidente, 176);
        partido2.agregarCandidatos(canPresidente2);
        partido2.agregarCandidatos(canVice2);
        /* --- Cargar la información al Visualizador de Resultados --- */
        listaCategorias = new ArrayList<Categoria>();
        listaCategorias.add(binomio);
        List<PartidoPolitico> listaPartidos = new ArrayList<PartidoPolitico>();
        listaPartidos.add(partido1);
        listaPartidos.add(partido2);
        formularioVoto = new FormularioVoto(listaCategorias, listaPartidos);
    }

    @Test
    public void given_category_when_showing_category_then_ok() {
        Categoria categoria = listaCategorias.get(0);

        List<Candidato> expected = new ArrayList<Candidato>();
        expected.add(new Candidato("Juan Luis", "Perez Lopez", new Dignidad("Presidente/a")));
        expected.add(new Candidato("María Juliana", "Maldonado Tusa", new Dignidad("Vicepresidente/a")));
        expected.add(new Candidato("Luis Alberto", "Lopez Villareal", new Dignidad("Presidente/a")));
        expected.add(new Candidato("Alejandra María", "Ruiz Maldonado", new Dignidad("Vicepresidente/a")));

        assertEquals(expected, formularioVoto.mostrarCategoria(categoria));
    }
}