package ec.edu.epn.sistemaDeVoto.model;

import java.util.ArrayList;
import java.util.List;

public class Voto {
    private List<Candidato> listaCandidatos = new ArrayList<Candidato>();

    public List<Candidato> getListaCandidatos() {
        return listaCandidatos;
    }

    public void agregarCandidato(Candidato candidato) {
        this.listaCandidatos.add(candidato);
    }
}
