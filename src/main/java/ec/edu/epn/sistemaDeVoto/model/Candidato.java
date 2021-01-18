package ec.edu.epn.sistemaDeVoto.model;

public class Candidato {
    private String nombres;
    private String apellidos;
    private Dignidad dignidad;
    private int votos;

    public Candidato(String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Candidato(String nombres, String apellidos, Dignidad dignidad) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dignidad = dignidad;
    }

    public Candidato(String nombres, String apellidos, Dignidad dignidad, int votos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dignidad = dignidad;
        this.votos = votos;
    }

    public void setDignidad(Dignidad dignidad) {
        this.dignidad = dignidad;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public Dignidad getDignidad() {
        return dignidad;
    }

    public void aumentarVoto() {
        this.votos += 1;
    }

    public int getVotos() {
        return votos;
    }

    @Override // Devuelve la información del Candidato con formato
    public String toString() {
        return this.dignidad.getNombre() + ": " + this.nombres + ' ' + this.apellidos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Candidato) {
            Candidato candidato2 = (Candidato) obj;
            return this.nombres.equals(candidato2.nombres) && this.apellidos.equals(candidato2.apellidos) && this.dignidad.equals(candidato2.dignidad);
        }
        return false;
    }
}
