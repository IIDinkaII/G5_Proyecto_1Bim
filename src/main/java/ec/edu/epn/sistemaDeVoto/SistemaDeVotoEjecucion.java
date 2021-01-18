package ec.edu.epn.sistemaDeVoto;

import ec.edu.epn.sistemaDeVoto.dao.*;
import ec.edu.epn.sistemaDeVoto.model.Categoria;
import ec.edu.epn.sistemaDeVoto.model.Dignidad;
import ec.edu.epn.sistemaDeVoto.model.Elector;
import ec.edu.epn.sistemaDeVoto.model.PartidoPolitico;

import java.util.ArrayList;
import java.util.List;

public class SistemaDeVotoEjecucion {
    public static void main(String[] args) {
        CandidatoDAOImpl candDAO = new CandidatoDAOImpl();
        candDAO.leerDatos("src/main/resources/candidatos.dat");
        ElectorDAOImpl elecDAO = new ElectorDAOImpl();
        elecDAO.leerDatos("src/main/resources/electores.txt");
        PartidoPoliticoDAOImpl partDAO = new PartidoPoliticoDAOImpl();
        partDAO.leerDatos("src/main/resources/partidos.txt");

        List<Categoria> listaCat = new ArrayList<Categoria>();
        listaCat.add(new Categoria("Binomio Presidencial"));
        listaCat.get(0).agregarDignidad(new Dignidad("Presidente/a"));
        listaCat.get(0).agregarDignidad(new Dignidad("Vicepresidente/a"));

        FormularioVoto form = new FormularioVoto();
        VisualizadorResultados resultados = new VisualizadorResultados(listaCat, partDAO.getPartidos());

        Controlador c = new Controlador(resultados, form, elecDAO, candDAO, partDAO);

        System.out.println("\n --------------------Resultados antes de votar:-------------------- \n");
        resultados.mostrarOpciones();
        resultados.mostrarResultados(1);

        // Se crea el Elector que va a sufragar
        Elector elector = elecDAO.getElectores().get(1);
        System.out.println("\nElector: " + elector.toString());
        // Se selecciona por quienes va a votar (partido, categoria)
        PartidoPolitico partidoSeleccionado = partDAO.getPartidos().get(0);
        Categoria categoriaSeleccionada = listaCat.get(0);

        // Vota
        elector.votar(partidoSeleccionado, categoriaSeleccionada);

        // Resultados despues del voto
        System.out.println("\n --------------------Resultados despues de votar:-------------------- \n");
        resultados.mostrarResultados(1);

    }
}
