package feriaempresarial;

import java.sql.Date;

public class Visitantes {
    private String NombreVisitante;
    private String Identificacion;
    private String Correo;
    private Date fechaVisita;

    public Visitantes(String NombreVisitante, String Identificacion, String Correo){
        this.NombreVisitante = NombreVisitante;
        this.Identificacion = Identificacion;
        this.Correo = Correo;
    }

    public String getNombreVisitante() {
        return this.NombreVisitante;
    }

    public void setNombreVisitante(String NombreVisitante) {
        this.NombreVisitante = NombreVisitante;
    }

    public String getIdentificacion() {
        return this.Identificacion;
    }

    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getCorreo() {
        return this.Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    public Date getFechaVisita() {  
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) { 
        this.fechaVisita = fechaVisita;
    }
}
