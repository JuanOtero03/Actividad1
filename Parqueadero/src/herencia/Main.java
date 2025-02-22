package herencia;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Parqueadero {
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void registrarEntrada() {
        System.out.println("Seleccione el tipo de vehículo: 1. Moto 2. Automóvil 3. Camión");
        int tipoVehiculo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la placa: ");
        String placa = scanner.nextLine();
        System.out.print("Ingrese la marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el modelo: ");
        String modelo = scanner.nextLine();

        switch (tipoVehiculo) {
            case 1:
                System.out.print("Ingrese el cilindraje de la moto: ");
                int cilindraje = scanner.nextInt();
                vehiculos.add(new Motocicleta(placa, marca, modelo, cilindraje));
                break;
            case 2:
                System.out.print("Ingrese el tipo de combustible: ");
                String combustible = scanner.nextLine();
                vehiculos.add(new Automovil(placa, marca, modelo, combustible));
                break;
            case 3:
                System.out.print("Ingrese la capacidad en toneladas del camión: ");
                double capacidad = scanner.nextDouble();
                vehiculos.add(new Camion(placa, marca, modelo, capacidad));
                break;
            default:
                System.out.println("Tipo de vehículo no válido.");
                return;
        }
        System.out.println("Vehículo registrado correctamente.");
    }

    public void registrarSalida() {
        System.out.print("Ingrese la placa del vehículo a retirar: ");
        String placa = scanner.next().trim();
        Iterator<Vehiculo> iterador = vehiculos.iterator();
        
        while (iterador.hasNext()) {
            Vehiculo vehiculo = iterador.next();
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                iterador.remove();
                long horas = Duration.between(vehiculo.getHoraEntrada(), LocalDateTime.now()).toHours();
                horas = (horas == 0) ? 1 : horas;
                double costo = vehiculo.getTarifaPorHora() * horas;
                System.out.println("Vehículo retirado. Costo total: $" + costo);
                return;
            }
        }
        System.out.println("No se encontró un vehículo con esa placa.");
    }

    public void consultarEstado() {
        if (vehiculos.isEmpty()) {
            System.out.println("El parqueadero está vacío.");
        } else {
            System.out.println("Vehículos en el parqueadero:");
            for (Vehiculo v : vehiculos) {
                System.out.println(v);
            }
        }
    }
    
    public void menu() {
        int opcion;
        do {
            System.out.println("\n--- Menú del Parqueadero ---");
            System.out.println("1. Registrar entrada");
            System.out.println("2. Registrar salida");
            System.out.println("3. Consultar estado");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: registrarEntrada(); break;
                case 2: registrarSalida(); break;
                case 3: consultarEstado(); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

        } 
    
    public class Main {
        public static void main(String[] args) {
            Parqueadero parqueadero = new Parqueadero();
            parqueadero.menu();
}
    }

