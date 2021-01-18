package ec.edu.epn.sistemaDeVoto.dao;

import ec.edu.epn.sistemaDeVoto.model.Candidato;
import ec.edu.epn.sistemaDeVoto.model.Dignidad;
import ec.edu.epn.sistemaDeVoto.model.PartidoPolitico;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PartidoPoliticoDAOImpl implements IPartidoPoliticoDAO{

    private List<PartidoPolitico> partidos;

    @Override
    public void leerDatos(String path) {
        partidos = new ArrayList<PartidoPolitico>();
        List<String> file = Arrays.asList(new String[]{"Apoyo a la ciudadanía,42,Juan Luis:Perez Lopez:Presidente/a:100-María Juliana:Maldonado Tusa:Vicepresidente/a:100","Por un país justo,51,Luis Alberto:Lopez Villareal:Presidente/a:80-Alejandra María:Ruiz Maldonado:Vicepresidente/a:80"});
        for (String datos: file) {
            String[] array = datos.split(",");
            PartidoPolitico partido = new PartidoPolitico(array[0], Integer.parseInt(array[1]));
            partidos.add(partido);
            String[] candidatoData = array[2].split("-");
            for (int i = 0; i < candidatoData.length; i++) {
                String[] info = candidatoData[i].split(":");
                Dignidad dig = new Dignidad(info[2]);
                partido.agregarCandidatos(new Candidato(info[0], info[1], dig, Integer.parseInt(info[3])));
            }
        }
    }

    public List<PartidoPolitico> getPartidos() {
        return partidos;
    }
}
