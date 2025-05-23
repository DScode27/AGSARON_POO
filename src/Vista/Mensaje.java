package Vista;

import javax.swing.*;

public class Mensaje {
    public static void mostrarMensaje(String cadena){
        JOptionPane.showMessageDialog(null, cadena);
    }

    public static void mensajeConsola(String cadena){
        System.out.println(cadena);
    }
}
