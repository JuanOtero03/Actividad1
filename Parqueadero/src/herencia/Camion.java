package herencia;

class Camion extends Vehiculo {
    private double capacidadCarga;

    public Camion(String placa, String marca, String modelo, double capacidadCarga) {
        super(placa, marca, modelo);
        this.capacidadCarga = capacidadCarga;
    }
    
    @Override
    public double getTarifaPorHora() {
        return 8000;
    }
}
