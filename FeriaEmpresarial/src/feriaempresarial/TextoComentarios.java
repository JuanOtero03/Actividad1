package feriaempresarial;
import java.sql.Date;

public class TextoComentarios {
    
    private String Comentar;
    private Integer Calificacion;
    private Date FechaVisita;
    private Stands stands;
    private Visitantes visitantes;
    
    
    public TextoComentarios(String Comentar, Integer Calificacion, Date FechaVisita, Stands stands, Visitantes visitantes){
        this.Comentar = Comentar;
        this.Calificacion = Calificacion;
        this.FechaVisita = FechaVisita;
        this.stands = stands;
        this.visitantes = visitantes;
    }

    public String getComentar() {
        return this.Comentar;
    }

    public void setComentar(String Comentar) {
        this.Comentar = Comentar;
    }

    public Stands getStands() {
        return this.stands;
    }

    public void setStands(Stands stands) {
        this.stands = stands;
    }

    public Date getFechaVisita() {
        return this.FechaVisita;
    }

    public void setFechaVisita(Date FechaVisita) {
        this.FechaVisita = FechaVisita;
    }
    public Integer getCalificacion() {
        return this.Calificacion;
    }

    public void setCalificacion(Integer Calificacion) {
        this.Calificacion = Calificacion;
    }
    
    public Visitantes getVisitantes(){
        return this.visitantes;
    }

    public void setVisitantes( Visitantes visitantes){
        this.visitantes = visitantes;
    }
}
