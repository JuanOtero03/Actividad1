package feriaempresarial;

import java.util.Scanner;

public class Stands {
    private Integer Numero;
    private String Ubicacion;
    private TipoTamano Tamaño;

    public Stands(Integer Numero, String Ubicacion, TipoTamano Tamaño) {
        this.Numero = Numero;
        this.Ubicacion = Ubicacion;
        this.Tamaño = Tamaño;
    }

    public Integer getNumero() {
        return this.Numero;
    }

    public void setNumero(Integer Numero) {
        this.Numero = Numero;
    }

    public String getUbicacion() {
        return this.Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public TipoTamano getTamaño() {
        return this.Tamaño;
    }

    // Corregido el nombre del método
    public void setTamaño(TipoTamano Tamaño) {
        this.Tamaño = Tamaño;
    }

    public static TipoTamano seleccionarTamaño() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el tamaño del Stand: ");
        System.out.println("1. Pequeño\n2. Mediano\n3. Grande");

        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                return TipoTamano.Pequeño;
            case 2:
                return TipoTamano.Mediano;
            case 3:
                return TipoTamano.Grande;
            default:
                System.out.println("Opción inválida, asignando tamaño Pequeño por defecto.");
                return TipoTamano.Pequeño;
        }
    }
}
