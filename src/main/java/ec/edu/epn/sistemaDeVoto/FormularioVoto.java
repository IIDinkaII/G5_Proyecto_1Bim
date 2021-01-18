package ec.edu.epn.sistemaDeVoto;

import ec.edu.epn.sistemaDeVoto.model.Candidato;
import ec.edu.epn.sistemaDeVoto.model.Categoria;
import ec.edu.epn.sistemaDeVoto.model.Dignidad;
import ec.edu.epn.sistemaDeVoto.model.PartidoPolitico;

import java.util.ArrayList;
import java.util.List;

public class FormularioVoto {
    private List<Categoria> listaCategorias = new ArrayList<Categoria>();
    private List<PartidoPolitico> listaPartidosPoliticos = new ArrayList<PartidoPolitico>();

    public FormularioVoto() {}

    public FormularioVoto(List<Categoria> listaCategorias, List<PartidoPolitico> listaPartidosPoliticos) {
        this.listaCategorias = listaCategorias;
        this.listaPartidosPoliticos = listaPartidosPoliticos;
    }

    public List<Candidato> mostrarCategoria(Categoria categoria) {
        List<Candidato> candidatosDeCategoria = new ArrayList<Candidato>();
        System.out.println("---------- Categoría: " + categoria.getNombre() + "\t----------");
        for (PartidoPolitico partido: listaPartidosPoliticos) {
            System.out.println(partido.toString());
            for (Dignidad dignidad: categoria.getListaDignidades()) {
                for (Candidato candidato: partido.getListaCandidatos()) {
                    if (candidato.getDignidad().equals(dignidad)) {
                        candidatosDeCategoria.add(candidato);
                        System.out.println(candidato.toString());
                    }
                }
            }
        }
        return candidatosDeCategoria;
    }
}