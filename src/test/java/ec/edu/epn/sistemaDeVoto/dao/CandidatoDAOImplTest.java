package ec.edu.epn.sistemaDeVoto.dao;

import ec.edu.epn.sistemaDeVoto.*;
import ec.edu.epn.sistemaDeVoto.dao.CandidatoDAOImpl;
import ec.edu.epn.sistemaDeVoto.model.Candidato;
import ec.edu.epn.sistemaDeVoto.model.Dignidad;
import ec.edu.epn.sistemaDeVoto.model.Voto;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CandidatoDAOImplTest {

    private static Voto voto = new Voto();

    @BeforeClass
    public static void setUpClass() {
        Candidato can1 = new Candidato("Juan Luis", "Perez Lopez", new Dignidad("Presidente/a"), 77);
        Candidato can2 = new Candidato("María Juliana", "Maldonado Tusa", new Dignidad("Vicepresidente/a"), 77);
        Candidato can3 = new Candidato("José Clemente", "Agualsaca Guamán", new Dignidad("Curul 88"), 103);
        Candidato can4 = new Candidato("José Ricardo", "Serrano Salgado", new Dignidad("Curul 24"), 56);

        voto.agregarCandidato(can1);
        voto.agregarCandidato(can2);
        voto.agregarCandidato(can3);
        voto.agregarCandidato(can4);
    }


    @Test
    public void given_vote_when_updating_votes_then_ok() {
        CandidatoDAOImpl candidatoDAO = new CandidatoDAOImpl();
        List<Candidato> expected = new ArrayList<Candidato>();
        expected.add(new Candidato("Juan Luis", "Perez Lopez", new Dignidad("Presidente/a")));
        expected.add(new Candidato("María Juliana", "Maldonado Tusa", new Dignidad("Vicepresidente/a")));
        expected.add(new Candidato("José Clemente", "Agualsaca Guamán", new Dignidad("Curul 88")));
        expected.add(new Candidato("José Ricardo", "Serrano Salgado", new Dignidad("Curul 24")));

        assertEquals(expected, candidatoDAO.actualizarVotos(voto));
    }
}