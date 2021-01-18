package ec.edu.epn.sistemaDeVoto.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nombre;
    private List<Dignidad> listaDignidades = new ArrayList<Dignidad>();

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Dignidad> getListaDignidades() {
        return listaDignidades;
    }

    public void agregarDignidad(Dignidad nuevaDignidad) {
        this.listaDignidades.add(nuevaDignidad);
    }
}
