package BLC.Entities;

public class NAHLarva extends NAHormiga {

    public NAHLarva(Integer naId) {
        super(naId, "larva", "Asexual", "", "VIVA");
    }

    public NAHLarva(Integer naId, String naTipo, String naSexo, String naAlimentacion, String naEstado) {
        super(naId, naTipo, naSexo, naAlimentacion, naEstado);
    }

    @Override
    public NAHormiga comer(NAIngestaNativa ingesta) {
        if (ingesta == null || ingesta.naGenoAlimento == null) {
            naEstado = "MUERTA";
            return this;
        }

        if (ingesta.naIngestaNativa.equals("Omnivoro") && ingesta.naGenoAlimento.naGenoAlimento.equals("XY")) {
            setNaGenoAlimento(ingesta.naGenoAlimento.naGenoAlimento);
            setNaAlimentacion("Onmivoro");
            setNaIngestaNativa(ingesta.naIngestaNativa);
            return new NAHZangano(this);
        } else {
            naEstado = "MUERTA";
            return this;
        }

    }
}
