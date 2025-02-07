package BLC.Entities;

public class NAHZangano extends NAHormiga implements NAEntrenamiento {

    public NAHZangano(NAHLarva larva) {
        super(larva.naId, "Zangano", "Macho", larva.naAlimentacion, larva.naEstado);
    }

    public NAHZangano(Integer naId, String naTipo, String naSexo, String naAlimentacion, String naEstado) {
        super(naId, naTipo, naSexo, naAlimentacion, naEstado);
    }

    @Override
    public NAHormiga comer(NAIngestaNativa ingesta) {
        if (ingesta == null || ingesta.naGenoAlimento == null) {
            naEstado = "MUERTA";
            return this;
        }
        if (ingesta.naIngestaNativa.equals("Omnivoro") && ingesta.naGenoAlimento.naGenoAlimento.equals("XY")) {
            return this;
        } else {
            naEstado = "MUERTA";
            return this;
        }
    }

    @Override
    public void entrenar() {
        this.setNaEntrenada(true);
    }

}
