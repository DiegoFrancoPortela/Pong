package principal;

import clases.Ventana;

public class Principal {

    public Principal() {

    }

    public static void main(String[] args) {

        Ventana ventana = new Ventana();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(3);
    }

}