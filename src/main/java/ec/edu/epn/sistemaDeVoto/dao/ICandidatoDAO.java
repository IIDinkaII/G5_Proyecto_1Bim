package ec.edu.epn.sistemaDeVoto.dao;

import ec.edu.epn.sistemaDeVoto.model.Candidato;
import ec.edu.epn.sistemaDeVoto.model.Voto;

import java.util.List;

public interface ICandidatoDAO {

    public List<Candidato> leerDatos(String path);
    public List<Candidato> actualizarVotos(Voto voto);

}
