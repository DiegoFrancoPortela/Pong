package clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class TableroJuego extends JPanel {
    Pelota pelota = new Pelota(Ventanas.ANCHO/2-10, Ventanas.ALTO/2-10);
    Raqueta r1 = new Raqueta(10,200);
    Raqueta r2 = new Raqueta(794-10-10-Raqueta.ANCHO,200);
    static boolean detener;
    BufferedImage img;

    public TableroJuego() {
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.WHITE);
        dibujar(g2);
        g.drawImage(img, 100, 100, this);
        actualizar();
        /*
        Realizamos una condicion que haga q cuando las valiables contado tanto izquierda como derecha lleguen
        a 5 se detenga el programa
         */

        if (Pelota.cDerecha==5||Pelota.cIzquierda==5){
            Hilo.detener();
        }

    }

    public void dibujar(Graphics2D g) {
        g.fill(pelota.getPelota());
        g.fill(r1.getRaqueta());
        g.fill(r2.getRaqueta());
        g.drawLine(Ventanas.ANCHO/2-10, 0, Ventanas.ANCHO/2-10, Ventanas.ALTO );
    }

    //Actualizar movimiento de la pelota
    public void actualizar() {
        pelota.mover(getBounds(),colision(r1.getRaqueta()),colision(r2.getRaqueta()));
        r1.moverR1(getBounds());
        r2.moverR2(getBounds());
    }

    //El .intersects controla que dos rectángulos se toquen.
    private boolean colision(Rectangle2D r) {
        return pelota.getPelota().intersects(r);
    }

}
