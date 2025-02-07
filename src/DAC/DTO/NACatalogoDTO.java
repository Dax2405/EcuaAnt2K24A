package DAC.DTO;

public class NACatalogoDTO {

    private Integer IdCatalogo;
    private Integer IdCatalogoPadre;
    private String Nombre;
    private String Detalle;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;

    public NACatalogoDTO() {
    }

    public NACatalogoDTO(Integer idCatalogo, String nombre) {
        IdCatalogo = idCatalogo;
        Nombre = nombre;
    }

    public NACatalogoDTO(Integer idCatalogo, Integer idCatalogoPadre, String nombre, String detalle, String estado,
            String fechaCrea, String fechaModifica) {
        IdCatalogo = idCatalogo;
        IdCatalogoPadre = idCatalogoPadre;
        Nombre = nombre;
        Detalle = detalle;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }

    public Integer getIdCatalogo() {
        return IdCatalogo;
    }

    public void setIdCatalogo(Integer idCatalogo) {
        IdCatalogo = idCatalogo;
    }

    public Integer getIdCatalogoPadre() {
        return IdCatalogoPadre;
    }

    public void setIdCatalogoPadre(Integer idCatalogoPadre) {
        IdCatalogoPadre = idCatalogoPadre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String detalle) {
        Detalle = detalle;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getFechaCrea() {
        return FechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }

    public String getFechaModifica() {
        return FechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "\n IdCatalogo      : " + getIdCatalogo()
                + "\n IdCatalogoPadre : " + getIdCatalogoPadre()
                + "\n Nombre          : " + getNombre()
                + "\n Detalle         : " + getDetalle()
                + "\n Estado          : " + getEstado()
                + "\n FechaCrea       : " + getFechaCrea()
                + "\n FechaModifica   : " + getFechaModifica();
    }

}
