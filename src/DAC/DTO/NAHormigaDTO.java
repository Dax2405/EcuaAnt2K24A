package DAC.DTO;

public class NAHormigaDTO {

    private Integer IdHormiga;
    private Integer IdCatalogoTipo;
    private Integer IdCatalogoSexo;
    private Integer IdCatalogoEstado;
    private Integer IdCataloGenoAlimento;
    private Integer IdCataloIngestaNativa;
    private String Nombre;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;

    public NAHormigaDTO() {
    }

    public NAHormigaDTO(Integer idCatalogoTipo, Integer idCatalogoSexo, Integer idCatalogoEstado,
            Integer idCataloGenoAlimento, Integer idCataloIngestaNativa, String nombre) {
        IdCatalogoTipo = idCatalogoTipo;
        IdCatalogoSexo = idCatalogoSexo;
        IdCatalogoEstado = idCatalogoEstado;
        IdCataloGenoAlimento = idCataloGenoAlimento;
        IdCataloIngestaNativa = idCataloIngestaNativa;
        Nombre = nombre;
    }

    public NAHormigaDTO(Integer idHormiga, Integer idCatalogoTipo, Integer idCatalogoSexo, Integer idCatalogoEstado,
            Integer idCataloGenoAlimento, Integer idCataloIngestaNativa, String nombre) {
        IdHormiga = idHormiga;
        IdCatalogoTipo = idCatalogoTipo;
        IdCatalogoSexo = idCatalogoSexo;
        IdCatalogoEstado = idCatalogoEstado;
        IdCataloGenoAlimento = idCataloGenoAlimento;
        IdCataloIngestaNativa = idCataloIngestaNativa;
        Nombre = nombre;
    }

    public NAHormigaDTO(Integer idHormiga, Integer idCatalogoTipo, Integer idCatalogoSexo, Integer idCatalogoEstado,
            Integer idCataloGenoAlimento, Integer idCataloIngestaNativa, String nombre,
            String estado, String fechaCrea,
            String fechaModifica) {
        IdHormiga = idHormiga;
        IdCatalogoTipo = idCatalogoTipo;
        IdCatalogoSexo = idCatalogoSexo;
        IdCatalogoEstado = idCatalogoEstado;
        IdCataloGenoAlimento = idCataloGenoAlimento;
        IdCataloIngestaNativa = idCataloIngestaNativa;
        Nombre = nombre;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }

    public Integer getIdHormiga() {
        return IdHormiga;
    }

    public void setIdHormiga(Integer idHormiga) {
        IdHormiga = idHormiga;
    }

    public Integer getIdCatalogoTipo() {
        return IdCatalogoTipo;
    }

    public void setIdCatalogoTipo(Integer idCatalogoTipo) {
        IdCatalogoTipo = idCatalogoTipo;
    }

    public Integer getIdCatalogoSexo() {
        return IdCatalogoSexo;
    }

    public void setIdCatalogoSexo(Integer idCatalogoSexo) {
        IdCatalogoSexo = idCatalogoSexo;
    }

    public Integer getIdCatalogoEstado() {
        return IdCatalogoEstado;
    }

    public void setIdCatalogoEstado(Integer idCatalogoEstado) {
        IdCatalogoEstado = idCatalogoEstado;
    }

    public Integer getIdCataloGenoAlimento() {
        return IdCataloGenoAlimento;
    }

    public void setIdCataloGenoAlimento(Integer idCataloGenoAlimento) {
        IdCataloGenoAlimento = idCataloGenoAlimento;
    }

    public Integer getIdCataloIngestaNativa() {
        return IdCataloIngestaNativa;
    }

    public void setIdCataloIngestaNativa(Integer idCataloIngestaNativa) {
        IdCataloIngestaNativa = idCataloIngestaNativa;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
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
                + "\n IdHormiga                 : " + getIdHormiga()
                + "\n IdCatalogoTipo            : " + getIdCatalogoTipo()
                + "\n IdCatalogoSexo            : " + getIdCatalogoSexo()
                + "\n IdCatalogoEstado          : " + getIdCatalogoEstado()
                + "\n IdCatalogoGenoAlimento    : " + getIdCataloGenoAlimento()
                + "\n IdCatalogoIngestaNativa   : " + getIdCataloIngestaNativa()
                + "\n Nombre                    : " + getNombre()
                + "\n Estado                    : " + getEstado()
                + "\n FechaCrea                 : " + getFechaCrea()
                + "\n FechaModifica             : " + getFechaModifica();

    }

}
