package ec.edu.epn.sistemaDeVoto.dao;

import ec.edu.epn.sistemaDeVoto.model.Candidato;
import ec.edu.epn.sistemaDeVoto.model.Dignidad;
import ec.edu.epn.sistemaDeVoto.model.Elector;
import ec.edu.epn.sistemaDeVoto.model.Voto;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CandidatoDAOImpl implements ICandidatoDAO{

    @Override
    public List<Candidato> leerDatos(String path) {
        List<Candidato> candidatos = new ArrayList<Candidato>();
        List<String> file = Arrays.asList(new String[]{"Juan Luis,Perez Lopez,Presidente/a,100","Luis Alberto,Lopez Villareal,Presidente/a,80","María Juliana,Maldonado Tusa,Vicepresidente/a,100","Alejandra María,Ruiz Maldonado,Vicepresidente/a,80"});
        for (String datos: file) {
            String[] array = datos.split(",");
            Dignidad dig = new Dignidad(array[2]);
            candidatos.add(new Candidato(array[0], array[1], dig, Integer.parseInt(array[3])));
        }
        return candidatos;
    }

    @Override
    public List<Candidato> actualizarVotos(Voto voto) {
        List<Candidato> candidatosVotados = new ArrayList<Candidato>();
        System.out.println("Se actualizaron los votos para los candidatos:");
        for (Candidato candidato: voto.getListaCandidatos()) {
            candidato.aumentarVoto();
            System.out.println(candidato.toString());
            candidatosVotados.add(candidato);
        }
        return candidatosVotados;
    }
}

