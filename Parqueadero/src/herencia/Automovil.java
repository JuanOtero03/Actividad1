package herencia;


class Automovil extends Vehiculo {
    private String tipoCombustible;

    public Automovil(String placa, String marca, String modelo, String tipoCombustible) {
        super(placa, marca, modelo);
        this.tipoCombustible = tipoCombustible;
    }
    
    @Override
    public double getTarifaPorHora() {
        return 5000;
    }
}