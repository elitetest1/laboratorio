
package RepasoJava3.integrador.src;

import java.util.Scanner;

public class OrniVerde extends Castor implements MamaPata {

    private String nombre;
    
    public OrniVerde (String nombre, double longitudCola, double velocidad) {
        super(longitudCola, velocidad);
        this.nombre = nombre;
    }
    


    @Override
    public void tocarOrgano() {
        Scanner sc = new Scanner(System.in);
        System.out.println(nombre + " toca órgano: Do-Re-Mi (presiona Enter para continuar)");
        sc.nextLine();
        System.out.println("Fa-Sol-La-Si");
    }

    @Override
    public void tocarGuitarra() {
        System.out.println(nombre + " toca guitarra:");
        super.tocarGuitarra();
    }

    public void tocarGuitorgan() {
        System.out.println(nombre + " toca Guitorgan:");
        super.tocarGuitarra();
        tocarOrgano();
        System.out.println("cuac cuaac…!");
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}