import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        GestionInventario inventario = new GestionInventario();
        System.out.println("--- 1. Agregando productos iniciales ---");
        inventario.agregarProducto(new Producto("A01", "Notebook Exo XQ3H", 750000, LocalDate.of(2024, 7, 15)), 10);
        inventario.agregarProducto(new Producto("A02", "Mouse Gamer T-Dagger Imperial", 9000, LocalDate.of(2024, 8, 1)), 50);
        inventario.agregarProducto(new Producto("B01", "Teclado Mecánico T-Dagger Sona", 80975, LocalDate.of(2024, 6, 20)), 30);
        inventario.agregarProducto(new Producto("C03", "Monitor Samsung SyncMaster 943 (vga y casi 720p)", 12000, LocalDate.of(2024, 8, 5)), 15);
        inventario.mostrarProductosOrdenados();
        System.out.println("--- 2. Actualizando stock ---");
        inventario.actualizarStock("A02", 45);
        inventario.mostrarProductosOrdenados();
        System.out.println("--- 3. Eliminando un producto ---");
        inventario.eliminarProducto("B01");
        inventario.mostrarProductosOrdenados();
    }
}