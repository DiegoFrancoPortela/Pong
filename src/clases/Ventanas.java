package clases;
import libreria.*;
import javax.swing.JFrame;

public class Ventanas extends JFrame {

    static final int ANCHO=800,ALTO=500;
    private Ventana ventana;
    private EventoTeclado teclado;
    private TableroJuego lamina;
    private Hilo hilo;
    public Ventanas() {
        lamina = new TableroJuego();
        hilo = new Hilo(lamina);
        teclado=new EventoTeclado();
        ventana= new libreria.Ventana("Pong",ANCHO,ALTO,lamina,hilo,teclado);
    }

}
