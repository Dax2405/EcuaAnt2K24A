package BLC.Entities;

public class NAEntomologo implements NAIEntomologo {
    @Override
    public void entrenar(NAHormiga naHormiga) {
        ((NAHZangano) naHormiga).entrenar(naHormiga);
        System.out.println("Entrenada y sumisa!");
    }
}
