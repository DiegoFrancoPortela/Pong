package clases;

//Esta clase actualiza el movimiento de la pelota y las raquetas

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread {

    static boolean ejecutar=true;

    TableroJuego lamina;

    public Hilo(TableroJuego lamina) {
        this.lamina=lamina;
    }
/*
Creamos un metodo que haga q cuando se ejecute se dentena el hilo
 */
public static void detener(){
        ejecutar=false;
}
    @Override
    public void run(){
        while(ejecutar) {
            try {
                Thread.sleep(2); //Recarga 1 milisegundo
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
            lamina.repaint();
        }
    }
}
