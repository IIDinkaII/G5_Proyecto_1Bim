package ec.edu.epn.sistemaDeVoto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PartidoPolitico {
    private String nombre;
    private int numero;
    private List<Candidato> listaCandidatos = new ArrayList<Candidato>();

    public PartidoPolitico(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public void agregarCandidatos(Candidato candidato) {
        this.listaCandidatos.add(candidato);
    }

    public List<Candidato> getListaCandidatos() {
        return listaCandidatos;
    }

    @Override // Devuelve la información del Partido Político con formato
    public String toString() {
        return "---- Partido " + this.numero + ":\t" + this.nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PartidoPolitico) {
            PartidoPolitico p = (PartidoPolitico) obj;
            return this.numero == p.numero && this.nombre.equals(p.nombre);
        }
        return false;
    }
}
