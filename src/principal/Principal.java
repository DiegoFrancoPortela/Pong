package principal;

import clases.Ventanas;

public class Principal {

    public Principal() {

    }

    public static void main(String[] args) {

        Ventanas ventanas = new Ventanas();
        ventanas.setVisible(true);
        ventanas.setDefaultCloseOperation(3);
    }

}