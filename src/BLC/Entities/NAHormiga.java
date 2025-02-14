package BLC.Entities;

public abstract class NAHormiga implements NAIHormiga {

    Integer naId;
    String naTipo;
    String naSexo;
    String naAlimentacion;
    String naEstado;
    Boolean naEntrenada;
    String naGenoAlimento = "XY";
    String naIngestaNativa = "Onmívoro";

    public NAHormiga(Integer naId, String naTipo, String naSexo, String naAlimentacion, String naEstado) {
        this.naId = naId;
        this.naTipo = naTipo;
        this.naSexo = naSexo;
        this.naAlimentacion = naAlimentacion;
        this.naEstado = naEstado;
        this.naEntrenada = false;
    }

    @Override
    public String toString() {
        return naId + "," + naTipo + "," + naSexo + "," + naAlimentacion + "," + naEstado + "\n";
    }

    public Integer getNaId() {
        return naId;
    }

    public void setNaId(Integer naId) {
        this.naId = naId;
    }

    public String getNaTipo() {
        return naTipo;
    }

    public void setNaTipo(String naTipo) {
        this.naTipo = naTipo;
    }

    public String getNaSexo() {
        return naSexo;
    }

    public void setNaSexo(String naSexo) {
        this.naSexo = naSexo;
    }

    public String getNaEstado() {
        return naEstado;
    }

    public void setNaEstado(String naEstado) {
        this.naEstado = naEstado;
    }

    public Boolean getNaEntrenada() {
        return naEntrenada;
    }

    public void setNaEntrenada(Boolean naEntrenada) {
        this.naEntrenada = naEntrenada;
    }

    public String getNaAlimentacion() {
        return naAlimentacion;
    }

    public void setNaAlimentacion(String naAlimentacion) {
        this.naAlimentacion = naAlimentacion;
    }

    public String getNaGenoAlimento() {
        return naGenoAlimento;
    }

    public void setNaGenoAlimento(String naGenoAlimento) {
        this.naGenoAlimento = naGenoAlimento;
    }

    public String getNaIngestaNativa() {
        return naIngestaNativa;
    }

    public void setNaIngestaNativa(String naIngestaNativa) {
        this.naIngestaNativa = naIngestaNativa;
    }

}
