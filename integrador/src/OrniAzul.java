package RepasoJava3.integrador.src;

class OrniAzul extends Castor {
    private String nombre;
    private double propulsion; // km/s

    public OrniAzul(String nombre, double longitudCola, double velocidad, double propulsion) {
        super(longitudCola, velocidad);
        this.nombre = nombre;
        this.propulsion = propulsion;
    }

    @Override
    public void nadar() {
        double totalVelocidad = velocidad + propulsion;
        System.out.println(nombre + " nada a velocidad de " + totalVelocidad + " km/s (propulsión incluida)");
    }

    public double getPropulsion() {
        return propulsion;
    }

    public String getNombre() {
        return nombre;
    }
}