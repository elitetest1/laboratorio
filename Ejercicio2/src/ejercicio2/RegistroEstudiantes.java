/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RegistroEstudiantes {
    private HashMap<String, Estudiante> mapa;

    public RegistroEstudiantes() {
        mapa = new HashMap<String, Estudiante>();
    }

    public void agregar(String dni, Estudiante estudiante) {
        mapa.put(dni, estudiante);
    }

    public void modificarPromedio(String dni, double nuevoPromedio) throws EstudianteNoExiste {
        if (mapa.containsKey(dni)) {
            Estudiante est = mapa.get(dni);
            est.setPromedio(nuevoPromedio);
        } else {
            throw new EstudianteNoExiste(dni);
        }
    }

    public void eliminar(String dni) throws EstudianteNoExiste {
        if (mapa.containsKey(dni)) {
            mapa.remove(dni);
        } else {
            throw new EstudianteNoExiste(dni);
        }
    }

    public String listar() {
        if (mapa.isEmpty()) {
            return "No hay estudiantes registrados.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Listado de estudiantes:\n");

        for (Map.Entry<String, Estudiante> entrada : mapa.entrySet()) {
            String dni = entrada.getKey();
            Estudiante est = entrada.getValue();
            sb.append("DNI: ").append(dni).append(" - ").append(est.toString()).append("\n");
        }

        return sb.toString();
    }
}
