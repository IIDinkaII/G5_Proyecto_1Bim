package ec.edu.epn.sistemaDeVoto.dao;

import ec.edu.epn.sistemaDeVoto.model.Elector;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ElectorDAOImpl implements IElectorDAO {

    private List<Elector> electores;

    @Override
    public void leerDatos(String path) {
        electores = new ArrayList<Elector>();
        List<String> file = Arrays.asList(new String[]{"1724466543,MAHATMA ISRAEL,QUIJANO ZANIPATTINI","1720817095,DIANA STEFANIA,LOPEZ PRIKHODKO","1717238412,LIDIA,LOPEZ VINUEZA","0200573947,JAIME FERNANDO,QUIJANO ACOSTA"});
        for (String datos: file) {
            String[] array = datos.split(",");
            electores.add(new Elector(array[0], array[1], array[2]));
        }
    }

    @Override
    public Elector comprobarElector(String cedula) {
        Elector elector = null;
        try {
            File archivo = new File("src/archivos/electores.txt");
            Scanner lector = new Scanner(archivo);
            while (lector.hasNextLine()) {
                String datos = lector.nextLine();
                String[] array = datos.split(",");
                if (array[0].equals(cedula)) {
                    elector = new Elector(array[0], array[1], array[2]);
                    break;
                }
            }
            return elector;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return elector;
        }
    }

}
