package BLC.Entities;

public class NAHZangano extends NAHormiga implements NAEntrenamiento {

    public NAHZangano(NAHLarva larva) {
        super(larva.naId, "Zangano", "Macho", larva.naEstado);
    }

    @Override
    public NAHormiga comer(NAIngestaNativa ingesta) {
        if (ingesta.naIngestaNativa.equals("Omnivoro") && ingesta.naGenoAlimento.naGenoAlimento.equals("XY")) {
            return this;
        } else {
            naEstado = "MUERTA";
            return this;
        }
    }

    @Override
    public entrenar(NAIEntomologo entomologo) {
        this.setNaEntrenada(true);
    }

}
