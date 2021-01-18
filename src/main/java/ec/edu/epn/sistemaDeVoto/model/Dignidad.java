package ec.edu.epn.sistemaDeVoto.model;

public class Dignidad {
    private String nombre;

    public Dignidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Dignidad) {
            Dignidad dignidad2 = (Dignidad) obj;
            return this.nombre.equals(dignidad2.nombre);
        }
        return false;
    }
}
