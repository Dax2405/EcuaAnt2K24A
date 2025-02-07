import java.util.Map;

import BLC.NACatalogoBL;
import BLC.NAHormigueroBL;
import BLC.Entities.NAHormiga;

public class App {
    public static void main(String[] args) throws Exception {

        NACatalogoBL oCatalogo = new NACatalogoBL();

        Map<Integer, String> hormigaTipos = oCatalogo.getAllHormigaTipo();
        System.out.println(hormigaTipos);
        Map<Integer, String> hormigaEstados = oCatalogo.getAllHormigaTipoEstado();
        System.out.println(hormigaEstados);
        Map<Integer, String> hormigaEstados2 = oCatalogo.getAllHormigaTipoGeno();
        System.out.println(hormigaEstados2);
        Map<Integer, String> hormigaEstados3 = oCatalogo.getAllHormigaTipoIngesta();
        System.out.println(hormigaEstados3);
        Map<Integer, String> hormigaEstados4 = oCatalogo.getAllHormigaTipoSexo();
        System.out.println(hormigaEstados4);
        System.out.println("-------------------");
        NAHormigueroBL hormigueroBL = new NAHormigueroBL();
        for (NAHormiga hormiga : hormigueroBL.lstHormiguero) {
            System.out.println(hormiga.toString());
        }

    }
}
