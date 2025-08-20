package RepasoJava3.integrador.src;

import java.util.Random;

public class Castor {
    protected double longitudCola;
    protected double velocidad; // km/h

    public Castor(double longitudCola, double velocidad) {
        this.longitudCola = longitudCola;
        this.velocidad = velocidad;
    }

    public void nadar() {
        System.out.println("Nadando a velocidad de " + velocidad + " km/h ");
    }

    public void tocarGuitarra() {
        Random rand = new Random();
        System.out.println("Tocando guitarra:");
        for (int i = 0; i < 3; i++) {
            int cuerda = rand.nextInt(6) + 1;
            System.out.println("Toca cuerda " + cuerda);
        }
    }

}
