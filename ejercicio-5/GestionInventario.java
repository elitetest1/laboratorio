import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionInventario {
    private List<Producto> listaProductos;
    private Map<String, Integer> stock;
    public GestionInventario() {
        this.listaProductos = new ArrayList<>();
        this.stock = new HashMap<>();
    }
    public void agregarProducto(Producto producto, int stockInicial) {
        if (!stock.containsKey(producto.getCodigo())) {
            this.listaProductos.add(producto);
            this.stock.put(producto.getCodigo(), stockInicial);
            System.out.println("-> Producto '" + producto.getNombre() + "' agregado.");
        } else {
            System.out.println("-> Error: El producto con código " + producto.getCodigo() + " ya existe.");
        }
    }
    public void actualizarStock(String codigo, int nuevoStock) {
        if (stock.containsKey(codigo)) {
            stock.put(codigo, nuevoStock);
            System.out.println("-> Stock del producto con código " + codigo + " actualizado a " + nuevoStock + ".");
        } else {
            System.out.println("-> Error: No se encontró el producto con código " + codigo + ".");
        }
    }
    public void eliminarProducto(String codigo) {
        if (stock.containsKey(codigo)) {
            stock.remove(codigo);
            listaProductos.removeIf(p -> p.getCodigo().equals(codigo));
            System.out.println("-> Producto con código " + codigo + " eliminado.");
        } else {
            System.out.println("-> Error: No se encontró el producto con código " + codigo + " para eliminar.");
        }
    }
    public void mostrarProductosOrdenados() {
        if (listaProductos.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }
        
        List<Producto> productosOrdenados = new ArrayList<>(this.listaProductos);
        Collections.sort(productosOrdenados);

        System.out.println("--- Inventario Ordenado ---");
        for (Producto p : productosOrdenados) {
            int stockDisponible = stock.getOrDefault(p.getCodigo(), 0);
            System.out.println(p + ", Stock: " + stockDisponible);
        }
        System.out.println("---------------------------");
    }
}