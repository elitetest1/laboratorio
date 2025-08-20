
package ejercicio2;

public class EstudianteNoExiste extends Exception {
    public EstudianteNoExiste(String dni) {
        super("No se encontro un estudiante con DNI: " + dni);
    }
}
