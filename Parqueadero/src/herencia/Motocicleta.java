package herencia;

class Motocicleta extends Vehiculo {
    private int cilindraje;

    public Motocicleta(String placa, String marca, String modelo, int cilindraje) {
        super(placa, marca, modelo);
        this.cilindraje = cilindraje;
    }
    
    @Override
    public double getTarifaPorHora() {
        return 3000;
    }
}
