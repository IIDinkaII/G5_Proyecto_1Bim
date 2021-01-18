package ec.edu.epn.sistemaDeVoto.dao;

import ec.edu.epn.sistemaDeVoto.model.Candidato;
import ec.edu.epn.sistemaDeVoto.model.Dignidad;
import ec.edu.epn.sistemaDeVoto.dao.ICandidatoDAO;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ICandidatoDAOTest {

    @Test
    public void given_vote_when_updating_votes_then_ok() {
        List<Candidato> expected = new ArrayList<Candidato>();
        expected.add(new Candidato("Juan Luis", "Perez Lopez", new Dignidad("Presidente/a")));
        expected.add(new Candidato("María Juliana", "Maldonado Tusa", new Dignidad("Vicepresidente/a")));

        ICandidatoDAO iCandidato = Mockito.mock(ICandidatoDAO.class);
        Mockito.when(iCandidato.actualizarVotos(Mockito.any()))
                .thenReturn(Arrays.asList(new Candidato("Juan Luis", "Perez Lopez", new Dignidad("Presidente/a")),
                        new Candidato("María Juliana", "Maldonado Tusa", new Dignidad("Vicepresidente/a"))));
    }

}