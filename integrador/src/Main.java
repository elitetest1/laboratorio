package RepasoJava3.integrador.src;

import java.util.*;


public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Datos de entrada
        System.out.print("Ingrese longitud de cola para orniVerde: ");
        double colaVerde = sc.nextDouble();
        System.out.print("Ingrese velocidad para orniVerde: ");
        double velVerde = sc.nextDouble();

        System.out.print("Ingrese longitud de cola para blue: ");
        double colaBlue = sc.nextDouble();
        System.out.print("Ingrese velocidad para blue: ");
        double velBlue = sc.nextDouble();
        System.out.print("Ingrese propulsión para blue (5-10): ");
        double propBlue = sc.nextDouble();

        System.out.print("Ingrese longitud de cola para blui: ");
        double colaBlui = sc.nextDouble();
        System.out.print("Ingrese velocidad para blui: ");
        double velBlui = sc.nextDouble();
        System.out.print("Ingrese propulsión para blui (5-10): ");
        double propBlui = sc.nextDouble();

        // Instancias
        OrniVerde orniVerde = new OrniVerde("Victor", colaVerde, velVerde);
        OrniAzul blue = new OrniAzul("blue", colaBlue, velBlue, propBlue);
        OrniAzul blui = new OrniAzul("blui", colaBlui, velBlui, propBlui);

        // Habilidades
        System.out.println("\n--- Habilidades de Victor (OrniVerde) ---");
        orniVerde.nadar();
        orniVerde.tocarGuitarra();
        orniVerde.tocarOrgano();
        orniVerde.tocarGuitorgan();

        System.out.println("\n--- Habilidades de blue (OrniAzul) ---");
        blue.nadar();
        blue.tocarGuitarra();

        System.out.println("\n--- Habilidades de blui (OrniAzul) ---");
        blui.nadar();
        blui.tocarGuitarra();

        // Arreglo de hermanos
        Castor[] hermanos = new Castor[3];
        try {
            hermanos[1] = orniVerde;
            hermanos[0] = blue;
            hermanos[2] = blui;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: índice fuera de rango.");
        } finally {
            System.out.println("los ornitohermanos estan juntos al fin…");
        }

        // Lista de mejores nadadores (solo orniAzul)
        List<OrniAzul> nadadores = new ArrayList<>();
        for (Castor h : hermanos) {
            if (h instanceof OrniAzul) {
                nadadores.add((OrniAzul) h);
            }
        }

        // Ordenar por propulsión ascendente
        nadadores.sort(Comparator.comparingDouble(OrniAzul::getPropulsion));

        System.out.println("\n--- Mejores nadadores (ordenados por propulsión) ---");
        Iterator<OrniAzul> it = nadadores.iterator();
        while (it.hasNext()) {
            OrniAzul o = it.next();
            System.out.println(o.getNombre() + " - Propulsión: " + o.getPropulsion());
        }
    }
}