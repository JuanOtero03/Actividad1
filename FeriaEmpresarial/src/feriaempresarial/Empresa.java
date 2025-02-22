package feriaempresarial;


public class Empresa {
    private String nombreEmpresa;
    private String sector;
    private String correoElectronico;

    public Empresa(String nombreEmpresa, String sector, String correoElectronico) {
        this.nombreEmpresa = nombreEmpresa;
        this.sector = sector;
        this.correoElectronico = correoElectronico;
    }

    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getSector() {
        return this.sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
