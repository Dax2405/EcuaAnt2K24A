package BLC.Entities;

public abstract class NAIngestaNativa extends NAAlimento implements NAIIngestaNativa {
    NAGenoAlimento naGenoAlimento;
    String naIngestaNativa;

    public NAIngestaNativa(String tipo) {
        super(tipo);
        naIngestaNativa = tipo;
    }

    public NAGenoAlimento getNaGenoAlimento() {
        return naGenoAlimento;
    }

    @Override
    public Boolean naInyectar(NAGenoAlimento genoAlimento) {
        if (genoAlimento.equals(" ") || genoAlimento == null) {
            return false;
        } else {
            naGenoAlimento = genoAlimento;
            super.setNaTipo(super.getNaTipo() + genoAlimento.naGenoAlimento);
            return true;
        }
    }

}
