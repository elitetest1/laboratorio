/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2;

import javax.swing.JOptionPane;

public class Ejercicio2 {
    public static void main(String[] args) {
        RegistroEstudiantes registro = new RegistroEstudiantes();
        boolean salir = false;

        while (!salir) {
            String opcion;
            opcion = JOptionPane.showInputDialog(null, """
                                                       === REGISTRO DE ESTUDIANTES ===
                                                       1) Agregar estudiante
                                                       2) Cambiar promedio
                                                       3) Borrar estudiante
                                                       4) Ver lista completa
                                                       5) Salir""",
                    "Menu principal", JOptionPane.QUESTION_MESSAGE);

            if (opcion == null) break;

            try {
                switch (opcion.trim()) {
                    case "1" -> {
                        String dni = pedirTexto("Ingrese DNI:");
                        if (dni == null) break;

                        String nombre = pedirTexto("Ingrese nombre:");
                        if (nombre == null) break;

                        String apellido = pedirTexto("Ingrese apellido:");
                        if (apellido == null) break;

                        Double promedio = pedirDouble("Ingrese promedio:");
                        if (promedio == null) break;

                        registro.agregar(dni, new Estudiante(nombre, apellido, promedio));
                        JOptionPane.showMessageDialog(null, "Estudiante agregado.");
                    }

                    case "2" -> {
                        String dniMod = pedirTexto("DNI del estudiante a modificar:");
                        if (dniMod == null) break;

                        Double nuevoProm = pedirDouble("Nuevo promedio:");
                        if (nuevoProm == null) break;

                        registro.modificarPromedio(dniMod, nuevoProm);
                        JOptionPane.showMessageDialog(null, "Promedio actualizado.");
                    }

                    case "3" -> {
                        String dniDel = pedirTexto("DNI del estudiante a borrar:");
                        if (dniDel == null) break;

                        registro.eliminar(dniDel);
                        JOptionPane.showMessageDialog(null, "Estudiante borrado.");
                    }

                    case "4" -> JOptionPane.showMessageDialog(null, registro.listar());

                    case "5" -> salir = true;

                    default -> JOptionPane.showMessageDialog(null, "Opcion invalida.");
                }
            } catch (EstudianteNoExiste ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException nf) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un numero valido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static String pedirTexto(String msg) {
        String s = JOptionPane.showInputDialog(null, msg);
        if (s == null || s.trim().isEmpty()) return null;
        return s.trim();
    }

    private static Double pedirDouble(String msg) {
        String s = JOptionPane.showInputDialog(null, msg);
        if (s == null) return null;
        return Double.valueOf(s.trim().replace(',', '.'));
    }
}
