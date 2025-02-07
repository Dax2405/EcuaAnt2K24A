package BLC.Entities;

public abstract class NAHormiga implements NAIHormiga {

    Integer naId;
    String naTipo;
    String naSexo;
    String naEstado;
    Boolean naEntrenada;

    public NAHormiga(Integer naId, String naTipo, String naSexo, String naEstado) {
        this.naId = naId;
        this.naTipo = naTipo;
        this.naSexo = naSexo;
        this.naEstado = naEstado;
        this.naEntrenada = false;
    }

    @Override
    public String toString() {
        return naId + "," + naTipo + "," + naSexo + "," + naEstado;
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

}
