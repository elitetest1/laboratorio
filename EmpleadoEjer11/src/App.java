import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            String opt = JOptionPane.showInputDialog("DESEA INGRESAR UN EMPLEADO? SI/NO");
            List<Empleado> empleados = new ArrayList<>();

            while (opt.toUpperCase().equals("SI")) {
                Empleado emp = new Empleado();
                try {
                    emp.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del empleado:"));
                    emp.setLegajo(
                            Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de legajo del empleado:")));
                    emp.setSueldo(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario del empleado:")));
                    empleados.add(emp);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Error: Entrada no valida. Por favor, ingrese los datos correctamente.");
                }
                opt = JOptionPane.showInputDialog("DESEA INGRESAR OTRO EMPLEADO? SI/NO");

            }
        

        String legajoStr = JOptionPane.showInputDialog("Ingrese el legajo del empleado a buscar:");
        int legajoBuscado = Integer.parseInt(legajoStr);
            
        Iterator<Empleado> it = empleados.iterator();

        while (it.hasNext()) {
            Empleado emp = it.next();
            if (emp.getLegajo() == legajoBuscado) {
                JOptionPane.showMessageDialog(null,
                        "Nombre: " + emp.getNombre() + "\nLegajo: " + emp.getLegajo() + "\nSueldo: " + emp.getSueldo());
                break;
            }
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}
