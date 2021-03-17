package clases;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Pelota {
    private int x;
    private int y;
    private int dx=1,dy=1;
    private final int ANCHO=15,ALTO=15;
    static int cDerecha,cIzquierda;

    public Pelota(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle2D getPelota() {
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
    }

    public void mover(Rectangle limites, boolean colisionR1, boolean colisionR2) {
        x+=dx;
        y+=dy;

        if(colisionR1){
            dx=-dx;
            x=25;
        }
        if(colisionR2){
            dx=-dx;
            x=745;
        }

        if(x>limites.getMaxX()) {
            x= Ventanas.ANCHO/2-10;
            y= Ventanas.ALTO/2-10;
            cIzquierda++;

        }
        if(y>limites.getMaxY()) {
            dy=-dy;
        }
        if(x<0) {
            x= Ventanas.ANCHO/2-10;
            y= Ventanas.ALTO/2-10;
            cDerecha++;
        }
        if(y<0) {
            dy=-dy;
        }
    }

}
