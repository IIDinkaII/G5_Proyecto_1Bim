package ec.edu.epn.sistemaDeVoto.model;

public class ValidacionCedula {

    public boolean validarCI(String cedula) {
        if (cedula.matches("^[0-9]{10}$")) {
            int provincia = Integer.parseInt(cedula.substring(0, 2));
            if ((provincia <= 24) && (provincia >= 1)) {
                if (Integer.parseInt(cedula.substring(2, 3)) < 6) {
                    int suma = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        int digito = Integer.parseInt(cedula.substring(i, i+1));
                        if (i % 2 == 0) {
                            suma += digito * 2;
                            if (digito * 2 >= 10)
                                suma -= 9;
                        } else
                            suma += digito;
                    }
                    suma = 10 - (suma % 10);
                    int verificador = Integer.parseInt(cedula.substring(9));
                    if (verificador == suma) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

