import java.time.LocalDate;

public class Producto implements Comparable<Producto> {
    private String codigo;
    private String nombre;
    private double precio;
    private LocalDate fechaDeIngreso;
    public Producto(String codigo, String nombre, double precio, LocalDate fechaDeIngreso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaDeIngreso = fechaDeIngreso;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public LocalDate getFechaDeIngreso() {
        return fechaDeIngreso;
    }
    @Override
    public String toString() {
        return String.format("Producto [Código=%s, Nombre=%s, Precio=$%.2f, Fecha de Ingreso=%s]",
                             codigo, nombre, precio, fechaDeIngreso);
    }
    @Override
    public int compareTo(Producto otro) {
        int comparacionPorPrecio = Double.compare(otro.getPrecio(), this.getPrecio());
        if (comparacionPorPrecio != 0) {
            return comparacionPorPrecio;
        }
        return otro.getFechaDeIngreso().compareTo(this.getFechaDeIngreso());
    }
}