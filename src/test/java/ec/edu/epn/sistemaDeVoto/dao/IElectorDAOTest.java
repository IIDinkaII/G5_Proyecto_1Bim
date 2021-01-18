package ec.edu.epn.sistemaDeVoto.dao;

import ec.edu.epn.sistemaDeVoto.dao.IElectorDAO;
import ec.edu.epn.sistemaDeVoto.model.Elector;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class IElectorDAOTest {
    @Test
    public void given_existing_id_when_searching_in_files_then_obtain_elector() {
        Elector expected = new Elector("1724466543", "MAHATMA ISRAEL", "QUIJANO ZANIPATTINI");
        IElectorDAO imod = Mockito.mock(IElectorDAO.class);
        Mockito.when(imod.comprobarElector("1724466543")).thenReturn(new Elector("1724466543", "MAHATMA ISRAEL", "QUIJANO ZANIPATTINI"));
        assertEquals(expected, imod.comprobarElector("1724466543"));
    }
}

