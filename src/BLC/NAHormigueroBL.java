package BLC;

import java.util.ArrayList;
import BLC.Entities.*;

import DAC.NAHormigueroDAC;
import Infra.AppException;

public class NAHormigueroBL {
    public ArrayList<NAHormiga> lstHormiguero = new ArrayList<>();

    public String crearLarva() throws AppException {
        NAHormiga hormiga = new NAHLarva(lstHormiguero.size() + 1);
        lstHormiguero.add(hormiga);
        return "HORMIGA LARVA, agregada al hormiguero";
    }

    public String eliminarHormiga(int idHormiga) throws Exception {
        String msg = "HORMIGA, no encontrada";
        for (int i = 0; i < lstHormiguero.size(); i++) {
            if (lstHormiguero.get(i).getNaId() == idHormiga) {
                msg = lstHormiguero.get(i).getNaTipo() + ", eliminada del hormiguero";
                lstHormiguero.remove(i);
            }
        }
        return msg;
    }

    public String guardarHormiquero() throws AppException {
        String fullDataHormiga = "";
        for (NAHormiga hormiga : lstHormiguero)
            fullDataHormiga += hormiga.toString();
        new NAHormigueroDAC().naSaveHormigueroToCSV(fullDataHormiga);
        return "HORMIGUERO, almacenado";
    }

    public String alimentarHormiga(int Idhormiga, String alimentoGeno, String alimentoNativo) throws AppException {
        int indexList = 0;
        NAGenoAlimento aGeno = null;
        NAIngestaNativa aNativo = null;
        NAHormiga hormiga = null;
        // creando GenoAlimento
        switch (alimentoGeno) {
            case "XX":
                aGeno = new NAXX();
                break;
            case "XY":
                aGeno = new NAXY();
                break;
            default:
                aGeno = new NAX();
                break;
        }

        // creando IngestaNativa
        switch (alimentoNativo) {

            case "Omnívoro":
                aNativo = new NAOmnivoro();
                break;

        }
        // buscar indexList y hormiga a alimentar
        for (; indexList < lstHormiguero.size(); indexList++)
            if (lstHormiguero.get(indexList).getNaId() == Idhormiga) {
                hormiga = lstHormiguero.get(indexList);
                break;
            }
        // validamos
        if (aNativo == null || aGeno == null || hormiga == null || hormiga.getNaEstado() == "MUERTA"
                || !(aGeno instanceof NAXY)) {
            lstHormiguero.set(indexList, hormiga.comer(aNativo));
            return "Ups...! alimento u hormiga no son válidos";
        }
        // inyectamos el genoAlimento a la ingestaNativa y se procede a alimenta a la
        // hormiga
        if (aNativo.naInyectar(aGeno))
            lstHormiguero.set(indexList, hormiga.comer(aNativo));
        else
            return hormiga.getNaTipo() + " NO alimentada";
        return lstHormiguero.get(indexList).getNaTipo() + " Alimentada";
    }
}