package ec.edu.epn.sistemaDeVoto.dao;

import ec.edu.epn.sistemaDeVoto.model.Elector;

import java.util.List;

public interface IElectorDAO {
    public Elector comprobarElector(String cedula);
    public void leerDatos(String path);
}
