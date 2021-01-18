package ec.edu.epn.sistemaDeVoto;

import ec.edu.epn.sistemaDeVoto.dao.*;


public class Controlador {

    private VisualizadorResultados visualizadorResultados;
    private FormularioVoto formularioVoto;
    private IElectorDAO electorDAO;
    private ICandidatoDAO candidatoDAO;
    private IPartidoPoliticoDAO partidoDAO;

    public Controlador(VisualizadorResultados visualizadorResultados, FormularioVoto formularioVoto, IElectorDAO electorDAO, ICandidatoDAO candidatoDAO, IPartidoPoliticoDAO partidoDAO) {
        this.visualizadorResultados = visualizadorResultados;
        this.formularioVoto = formularioVoto;
        this.electorDAO = electorDAO;
        this.candidatoDAO = candidatoDAO;
        this.partidoDAO = partidoDAO;
    }

}
