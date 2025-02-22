package feriaempresarial;

import java.util.ArrayList;
import java.util.Scanner;

public class FeriaEmpresarial {
    private ArrayList<Empresa> empresas;
    private ArrayList<Stands> stands;
    private ArrayList<Visitantes> visitantes;
    private ArrayList<TextoComentarios> comentarios;
    private Scanner scanner;

    public FeriaEmpresarial() {
        this.empresas = new ArrayList<>();
        this.stands = new ArrayList<>();
        this.visitantes = new ArrayList<>();
        this.comentarios = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // MÉTODOS PARA EMPRESAS
    public void registrarEmpresa() {
        System.out.print("Ingrese el nombre de la empresa: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el sector: ");
        String sector = scanner.nextLine();
        System.out.print("Ingrese el correo electrónico: ");
        String correo = scanner.nextLine();

        Empresa empresa = new Empresa(nombre, sector, correo);
        empresas.add(empresa);
        System.out.println("Empresa registrada con éxito.\n");
    }

    public void eliminarEmpresa() {
        System.out.print("Ingrese el nombre de la empresa a eliminar: ");
        String nombre = scanner.nextLine();
        empresas.removeIf(e -> e.getNombreEmpresa().equalsIgnoreCase(nombre));
        System.out.println("Empresa eliminada.\n");
    }

    public Empresa buscarEmpresa(String nombre) {
        for (Empresa empresa : empresas) {
            if (empresa.getNombreEmpresa().equalsIgnoreCase(nombre)) {
                return empresa;
            }
        }
        return null;
    }

    // MÉTODOS PARA STANDS
    public void registrarStand() {
        System.out.print("Ingrese el número del stand: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea
        System.out.print("Ingrese la ubicación del stand: ");
        String ubicacion = scanner.nextLine();
        TipoTamano tamano = Stands.seleccionarTamaño();

        Stands stand = new Stands(numero, ubicacion, tamano);
        stands.add(stand);
        System.out.println("Stand registrado con éxito.\n");
    }

    public void eliminarStand() {
        System.out.print("Ingrese el número del stand a eliminar: ");
        int numero = scanner.nextInt();
        stands.removeIf(s -> s.getNumero() == numero);
        System.out.println("Stand eliminado.\n");
    }

    public Stands buscarStand(int numero) {
        for (Stands stand : stands) {
            if (stand.getNumero() == numero) {
                return stand;
            }
        }
        return null;
    }

    // MÉTODOS PARA VISITANTES
    public void registrarVisitante() {
        System.out.print("Ingrese el nombre del visitante: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la identificación: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el correo: ");
        String correo = scanner.nextLine();

        Visitantes visitante = new Visitantes(nombre, id, correo);
        visitantes.add(visitante);
        System.out.println("Visitante registrado con éxito.\n");
    }

    public void eliminarVisitante() {
        System.out.print("Ingrese la identificación del visitante a eliminar: ");
        String id = scanner.nextLine();
        visitantes.removeIf(v -> v.getIdentificacion().equalsIgnoreCase(id));
        System.out.println("Visitante eliminado.\n");
    }

    

    // MÉTODOS PARA COMENTARIOS
    public void agregarComentario() {
        System.out.print("Ingrese la identificación del visitante: ");
        String idVisitante = scanner.nextLine();
        Visitantes visitante = buscarVisitante(idVisitante);
        
                if (visitante == null) {
                    System.out.println("Visitante no encontrado.");
                    return;
                }
        
                System.out.print("Ingrese el número del stand: ");
                int numeroStand = scanner.nextInt();
                Stands stand = buscarStand(numeroStand);
        
                if (stand == null) {
                    System.out.println("Stand no encontrado.");
                    return;
                }
        
                scanner.nextLine(); // Consumir nueva línea
                System.out.print("Ingrese su comentario: ");
                String comentarioTexto = scanner.nextLine();
                System.out.print("Ingrese una calificación (1-5): ");
                int calificacion = scanner.nextInt();
        
                TextoComentarios comentario = new TextoComentarios(comentarioTexto, calificacion, new java.sql.Date(System.currentTimeMillis()), stand, visitante);
                comentarios.add(comentario);
                System.out.println("Comentario agregado con éxito.\n");
            }
        
            private Visitantes buscarVisitante(String idVisitante) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'buscarVisitante'");
            }
        
            // REPORTES
    public void generarReporteEmpresas() {
        System.out.println("\n--- Reporte de Empresas ---");
        for (Empresa empresa : empresas) {
            System.out.println("Nombre: " + empresa.getNombreEmpresa());
            System.out.println("Sector: " + empresa.getSector());
            System.out.println("Correo: " + empresa.getCorreoElectronico());
            System.out.println("----------------------------");
        }
    }

    public void generarReporteVisitantes() {
        System.out.println("\n--- Reporte de Visitantes ---");
        for (Visitantes visitante : visitantes) {
            System.out.println("Nombre: " + visitante.getNombreVisitante());
            System.out.println("Identificación: " + visitante.getIdentificacion());
            System.out.println("Correo: " + visitante.getCorreo());
            System.out.println("----------------------------");
        }
    }

    public void generarReporteCalificaciones() {
        System.out.println("\n--- Reporte de Calificaciones ---");
        for (Stands stand : stands) {
            double promedio = calcularPromedioCalificacion(stand);
            System.out.println("Stand #" + stand.getNumero() + " - Ubicación: " + stand.getUbicacion());
            System.out.println("Calificación promedio: " + (promedio == -1 ? "Sin calificaciones" : promedio));
            System.out.println("----------------------------");
        }
    }

    private double calcularPromedioCalificacion(Stands stand) {
        int suma = 0, cantidad = 0;
        for (TextoComentarios comentario : comentarios) {
            if (comentario.getStands().equals(stand)) {
                suma += comentario.getCalificacion();
                cantidad++;
            }
        }
        return cantidad == 0 ? -1 : (double) suma / cantidad;
    }

    // MÉTODO PRINCIPAL PARA INTERACTUAR CON EL USUARIO
    public void menu() {
        int opcion;
        do {
            System.out.println("\n--- Feria Empresarial ---");
            System.out.println("1. Registrar Empresa");
            System.out.println("2. Registrar Stand");
            System.out.println("3. Registrar Visitante");
            System.out.println("4. Agregar Comentario");
            System.out.println("5. Generar Reporte Empresas");
            System.out.println("6. Generar Reporte Visitantes");
            System.out.println("7. Generar Reporte Calificaciones");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1 -> registrarEmpresa();
                case 2 -> registrarStand();
                case 3 -> registrarVisitante();
                case 4 -> agregarComentario();
                case 5 -> generarReporteEmpresas();
                case 6 -> generarReporteVisitantes();
                case 7 -> generarReporteCalificaciones();
                case 8 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 8);
    }

    public static void main(String[] args) {
        FeriaEmpresarial feria = new FeriaEmpresarial();
        feria.menu();
    }
}
