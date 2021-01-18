package ec.edu.epn.sistemaDeVoto;

import ec.edu.epn.sistemaDeVoto.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VisualizadorResultados {

    private List<Categoria> listaCategorias = new ArrayList<Categoria>();
    private List<PartidoPolitico> listaPartidos = new ArrayList<PartidoPolitico>();

    public VisualizadorResultados() {}

    public VisualizadorResultados(List<Categoria> listaCategorias, List<PartidoPolitico> listaPartidos) {
        this.listaCategorias = listaCategorias;
        this.listaPartidos = listaPartidos;
    }

    public void mostrarResultados(int opcionSeleccionada) {
        if (controladorOpciones(opcionSeleccionada)) {
            if (opcionSeleccionada != 0) {
                for (PartidoPolitico partido: this.listaPartidos) {
                    System.out.println(partido); // Imprime la información del Partido Político
                    // Iterar por cada candidato dentro de un partido
                    for (Candidato candidato: partido.getListaCandidatos()) {
                        // Imprimir los candidatos cuyas dignidades pertenezcan a la Categoría seleccionada
                        Categoria categoriaSeleccionada = this.listaCategorias.get(opcionSeleccionada - 1);
                        Dignidad dignidadDelCandidato = candidato.getDignidad();
                        if (categoriaSeleccionada.getListaDignidades().contains(dignidadDelCandidato)) {
                            // Imprime la información del Candidato
                            System.out.println(candidato + "\tVotos: " + candidato.getVotos());
                        }
                    }
                }
            }
        }
    }

    private boolean controladorOpciones(int opcionSeleccionada) {
        // Bucle para mostrar y seleccionar las opciones hasta Salir
        // o mientras se ingrese una opción incorrecta
        while (true) {
            if (opcionSeleccionada == 0) {
                System.out.println("¡Gracias por usar el sistema!");
                return false;
            } else if ((1 <= opcionSeleccionada) && (opcionSeleccionada <= this.listaCategorias.size())) {
                return true;
            } else {
                System.out.println("Opción incorrecta"); // El bucle no se cierra
            }
        }
    }

    public void mostrarOpciones() {
        // Menú de opciones
        System.out.print("\n|---- Bienvenido al Sistema de Voto Electrónico ----|\n" +
                "* Elija el número correspondiente a la categoría que desea observar: *\n");
        for (int i = 0; i < this.listaCategorias.size(); i++) {
            System.out.println((i + 1) + ". " + this.listaCategorias.get(i).getNombre());
        }
        System.out.println("* Ingrese 0 para Salir *");
    }

}
