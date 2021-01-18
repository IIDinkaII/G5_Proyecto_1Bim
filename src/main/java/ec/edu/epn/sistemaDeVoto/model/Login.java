package ec.edu.epn.sistemaDeVoto.model;

import ec.edu.epn.sistemaDeVoto.dao.ElectorDAOImpl;

public class Login {

    private ValidacionCedula validador = new ValidacionCedula();
    private ElectorDAOImpl modelo = new ElectorDAOImpl();

    public boolean ingresarAlSistema(String cedula) {
        if (validador.validarCI(cedula)) {
            if (modelo.comprobarElector(cedula) != null){
                System.out.println("Bienvenido al Sistema");
                return true;
            } else {
                System.out.println("No se encuentra registrado en este recinto electoral");
            }
        } else {
            System.out.println("Cédula inválida");
        }
        return false;
    }
}
