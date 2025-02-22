package feriaempresarial;
import feriaempresarial.Stands;
import feriaempresarial.Visitantes;
import feriaempresarial.TipoTamano;

import java.util.ArrayList;

public class GestionEmpresarial {
    private ArrayList<Empresa> empresas;
    private ArrayList<Stands> stands;
    private ArrayList<Visitantes> visitantes;
    private ArrayList<TextoComentarios> comentarios;

    public GestionEmpresarial() {
        empresas = new ArrayList<>();
        stands = new ArrayList<>();
        visitantes = new ArrayList<>();
        comentarios = new ArrayList<>();
    }

    // MÉTODOS PARA EMPRESAS
    public void registrarEmpresa(Empresa empresa) {
        empresas.add(empresa);
    }

    public void eliminarEmpresa(String nombreEmpresa) {
        int i = 0;
        while (i < empresas.size()) {
            Empresa empresa = empresas.get(i);
            if (empresa.getNombreEmpresa().equals(nombreEmpresa)) {
                empresas.remove(i);
                break;
            }
            i++;
        }
    }

    public Empresa buscarEmpresa(String nombreEmpresa) {
        int i = 0;
        while (i < empresas.size()) {
            Empresa empresa = empresas.get(i);
            if (empresa.getNombreEmpresa().equals(nombreEmpresa)) {
                return empresa;
            }
            i++;
        }
        return null;
    }

    // MÉTODOS PARA STANDS
    public void registrarStand(Stands stand) {
        stands.add(stand);
    }

    public void eliminarStand(int numeroStand) {
        int i = 0;
        while (i < stands.size()) {
            Stands stand = stands.get(i);
            if (stand.getNumero() == numeroStand) {
                stands.remove(i);
                break;
            }
            i++;
        }
    }

    public Stands buscarStand(int numeroStand) {
        int i = 0;
        while (i < stands.size()) {
            Stands stand = stands.get(i);
            if (stand.getNumero() == numeroStand) {
                return stand;
            }
            i++;
        }
        return null;
    }

    // MÉTODOS PARA VISITANTES
    public void registrarVisitante(Visitantes visitante) {
        visitantes.add(visitante);
    }

    public void eliminarVisitante(String identificacion) {
        int i = 0;
        while (i < visitantes.size()) {
            Visitantes visitante = visitantes.get(i);
            if (visitante.getIdentificacion().equals(identificacion)) {
                visitantes.remove(i);
                break;
            }
            i++;
        }
    }

    public Visitantes buscarVisitante(String identificacion) {
        int i = 0;
        while (i < visitantes.size()) {
            Visitantes visitante = visitantes.get(i);
            if (visitante.getIdentificacion().equals(identificacion)) {
                return visitante;
            }
            i++;
        }
        return null;
    }

    // MÉTODOS PARA COMENTARIOS
    public void agregarComentario(TextoComentarios comentario) {
        comentarios.add(comentario);
    }

    public ArrayList<TextoComentarios> obtenerComentariosPorStand(Stands stand) {
        ArrayList<TextoComentarios> comentariosStand = new ArrayList<>();
        int i = 0;
        while (i < comentarios.size()) {
            TextoComentarios comentario = comentarios.get(i);
            if (comentario.getStands() == stand) {
                comentariosStand.add(comentario);
            }
            i++;
        }
        return comentariosStand;
    }

    // MÉTODOS DE REPORTE
    public void mostrarEmpresas() {
        System.out.println("\n--- Empresas ---");
        int i = 0;
        while (i < empresas.size()) {
            Empresa empresa = empresas.get(i);
            System.out.println("Nombre: " + empresa.getNombreEmpresa());
            i++;
        }
    }

    public void mostrarVisitantes() {
        System.out.println("\n--- Visitantes ---");
        int i = 0;
        while (i < visitantes.size()) {
            Visitantes visitante = visitantes.get(i);
            System.out.println("Nombre: " + visitante.getNombreVisitante());
            i++;
        }
    }

    public void mostrarStands() {
        System.out.println("\n--- Stands ---");
        int i = 0;
        while (i < stands.size()) {
            Stands stand = stands.get(i);
            System.out.println("Número de Stand: " + stand.getNumero());
            i++;
        }
    }
}
