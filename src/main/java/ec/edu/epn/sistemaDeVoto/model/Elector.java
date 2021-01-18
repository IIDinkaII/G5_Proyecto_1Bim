package ec.edu.epn.sistemaDeVoto.model;

import java.util.ArrayList;
import java.util.List;

public class Elector {
    private String cedula;
    private String nombres;
    private String apellidos;
    private Voto voto;

    public Elector(String cedula, String nombres, String apellidos) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.voto = new Voto();
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Voto getVoto() {
        return voto;
    }

    public List<Candidato> votar(PartidoPolitico partido, Categoria categoria) {
        List<Candidato> candidatosSeleccionados = new ArrayList<Candidato>();
        for (Candidato candidato: partido.getListaCandidatos()) {
            for (Dignidad dignidad : categoria.getListaDignidades()) {
                if (candidato.getDignidad().equals(dignidad)) {
                    this.voto.agregarCandidato(candidato);
                    candidato.aumentarVoto();
                    candidatosSeleccionados.add(candidato);
                }
            }
        }
        return candidatosSeleccionados;
    }

    @Override
    public String toString() {
        return "\n" + this.cedula + "\t" + this.nombres + " " + this.apellidos;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Elector){
            Elector elector2 = (Elector) obj;
            return this.cedula.equals(elector2.cedula) && this.nombres.equals(elector2.nombres) && this.apellidos.equals(elector2.apellidos);
        }
        return false;
    }

}
