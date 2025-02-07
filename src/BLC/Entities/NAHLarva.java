package BLC.Entities;

public class NAHLarva extends NAHormiga {

    public NAHLarva(Integer naId) {
        super(naId, "Larva", "Asexual", "VIVA");
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
