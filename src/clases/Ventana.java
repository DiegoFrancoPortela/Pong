package clases;

import javax.swing.JFrame;

public class Ventana extends JFrame {

    static final int ANCHO=800,ALTO=500;
    private TableroJuego lamina;
    private Hilo hilo;
    public Ventana() {
        setTitle("Pong");
        setSize(ANCHO,ALTO);
        setLocationRelativeTo(null); //Ventana en el centro de la pantalla
        setResizable(false);
        lamina = new TableroJuego();
        add(lamina);
        addKeyListener(new EventoTeclado());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        hilo = new Hilo(lamina);
        hilo.start();
//        lamina.iterarJuego();
    }

}
