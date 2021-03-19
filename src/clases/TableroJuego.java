package clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TableroJuego extends JPanel {
    Pelota pelota = new Pelota(Ventanas.ANCHO/2-10, Ventanas.ALTO/2-10);
    Raqueta r1 = new Raqueta(10,200);
    Raqueta r2 = new Raqueta(794-10-10-Raqueta.ANCHO,200);
    static boolean detener;
    public static final int YCONT = 10;
    public static final int XCONT_IZQUIERDA = 340;
    public static final int XCONT_DERECHA = 405;
    BufferedImage Izquierda_numero;
    BufferedImage Derecha_numero;
    public String ruta = "/home/diego/Documentos/DAM/Contornos/Pong/recursos/numero";
    public TableroJuego() {
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.WHITE);
        dibujar(g2);
        actualizar();
        try {
            //Contador Derecha
            if (Pelota.cDerecha==0){
                Derecha_numero = ImageIO.read(new File(ruta+"0.png"));
            } else if (Pelota.cDerecha==1){
                Derecha_numero = ImageIO.read(new File(ruta+"1.png"));
            } else if (Pelota.cDerecha==2){
                Derecha_numero = ImageIO.read(new File(ruta+"2.png"));
            } else if (Pelota.cDerecha==3){
                Derecha_numero = ImageIO.read(new File(ruta+"3.png"));
            } else if (Pelota.cDerecha==4){
                Derecha_numero = ImageIO.read(new File(ruta+"4.png"));
            } else if (Pelota.cDerecha==5){
                Derecha_numero = ImageIO.read(new File(ruta+"5.png"));
            }

            //Contador Izquierda
            if (Pelota.cIzquierda==0){
                Izquierda_numero = ImageIO.read(new File(ruta+"0.png"));
            } else if (Pelota.cIzquierda==1){
                Izquierda_numero = ImageIO.read(new File(ruta+"1.png"));
            } else if (Pelota.cIzquierda==2){
                Izquierda_numero = ImageIO.read(new File(ruta+"2.png"));
            } else if (Pelota.cIzquierda==3){
                Izquierda_numero = ImageIO.read(new File(ruta+"3.png"));
            } else if (Pelota.cIzquierda==4){
                Izquierda_numero = ImageIO.read(new File(ruta+"4.png"));
            } else if (Pelota.cIzquierda==5){
                Izquierda_numero = ImageIO.read(new File(ruta+"5.png"));
            }

        } catch (IOException e) {
            System.out.println("La imagen no se está leyendo correctamente");
            System.out.println(e.getLocalizedMessage());
        }
        g.drawImage(Izquierda_numero,XCONT_IZQUIERDA,YCONT,this);
        g.drawImage(Derecha_numero, XCONT_DERECHA, YCONT,this);
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