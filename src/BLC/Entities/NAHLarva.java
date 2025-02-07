package BLC.Entities;

public class NAHLarva extends NAHormiga {

    public NAHLarva(Integer naId) {
        super(naId, "Larva", "Asexual", "Omnívoro", "VIVA");
    }

    public NAHLarva(Integer naId, String naTipo, String naSexo, String naAlimentacion, String naEstado) {
        super(naId, naTipo, naSexo, naAlimentacion, naEstado);
    }

    @Override
    public NAHormiga comer(NAIngestaNativa ingesta) {

        if (ingesta.naIngestaNativa.equals("Omnivoro") && ingesta.naGenoAlimento.naGenoAlimento.equals("XY")) {
            return new NAHZangano(this);
        } else {
            naEstado = "MUERTA";
            return this;
        }

    }
}
