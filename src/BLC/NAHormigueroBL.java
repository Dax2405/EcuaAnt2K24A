package BLC;

import java.util.ArrayList;
import BLC.Entities.*;

import DAC.NAHormigueroDAC;
import DAC.DAO.NAHormigaDAO;
import DAC.DTO.NAHormigaDTO;
import Infra.AppException;

public class NAHormigueroBL {
    public ArrayList<NAHormiga> lstHormiguero = new ArrayList<>();
    public BLFactory<NAHormigaDTO> oHormiga = new BLFactory<>(NAHormigaDAO::new);

    public NAHormigueroBL() {

        NAHormigueroDAC hormigueroDAC = new NAHormigueroDAC();
        hormigueroDAC.naGetHormigueroFromCSV().forEach(hormiga -> lstHormiguero.add(hormiga));

    }

    public String crearLarva() throws AppException {
        int maxId = lstHormiguero.stream().mapToInt(NAHormiga::getNaId).max().orElse(0);
        NAHormiga hormiga = new NAHLarva(maxId + 1);
        lstHormiguero.add(hormiga);
        return "HORMIGA LARVA, agregada al hormiguero";
    }

    public String eliminarHormiga(int idHormiga) throws Exception {
        String msg = "HORMIGA, no encontrada";
        for (int i = 0; i < lstHormiguero.size(); i++) {
            if (lstHormiguero.get(i).getNaId() == idHormiga) {
                NAHormiga hormiga = lstHormiguero.get(i);
                hormiga.setNaEstado("MUERTA");
                msg = lstHormiguero.get(i).getNaTipo() + ", eliminada del hormiguero";
            }
        }
        return msg;
    }

    public String guardarHormiquero() throws Exception {
        String fullDataHormiga = "";
        for (NAHormiga hormiga : lstHormiguero) {
            NAHormigaDTO hormigaDTO = new NAHormigaDTO(hormiga.getNaId(), getIdHormigaTipo(hormiga.getNaTipo()),
                    getIdHormigaSexo(hormiga.getNaSexo()),
                    getIdHormigaEstado(hormiga.getNaEstado()), getIdGenoAlimento(hormiga.getNaGenoAlimento()),
                    getIdIngestaNativa(hormiga.getNaIngestaNativa()), "Las hormigas NO tienen");

            oHormiga.add(hormigaDTO);

            fullDataHormiga += hormiga.toString();
        }
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
        System.out.println("hormiga.getNaTipo() " + hormiga.getNaTipo());
        System.out.println("alimento " + alimentoNativo);
        if (hormiga.getNaTipo().equals("larva") && alimentoNativo.equals("Nectarívoro")) {
            hormiga.setNaAlimentacion(alimentoNativo);
            return lstHormiguero.get(indexList).getNaTipo() + " Alimentada";

        }
        if (hormiga.getNaEstado().equals("MUERTA")) {
            return "No se puede alimentar a muertas!";
        }
        System.out.println(alimentoGeno + " " + alimentoNativo);
        if (aNativo == null || aGeno == null || hormiga == null || hormiga.getNaEstado() == "MUERTA"
                || !alimentoGeno.equals("XY") || !alimentoNativo.equals("Omnívoro")) {
            lstHormiguero.set(indexList, hormiga.comer(aNativo));
            hormiga.setNaAlimentacion(alimentoNativo);
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

    public String entrenarHormiga(int idHormiga) throws AppException {
        for (int i = 0; i < lstHormiguero.size(); i++) {
            if (lstHormiguero.get(i).getNaId() == idHormiga) {
                NAHormiga hormiga = lstHormiguero.get(i);
                if (hormiga instanceof NAHZangano) {
                    if (hormiga.getNaEstado().equals("MUERTA")) {
                        return "No se puede entrenar a muertas!";
                    }
                    NAEntomologo naEntomologo = new NAEntomologo();
                    naEntomologo.entrenar(hormiga);
                } else {
                    return "Las Larvas, no se puede entrenar";
                }
                lstHormiguero.set(i, hormiga);

                return lstHormiguero.get(i).getNaTipo() + " Entrenada y sumisa!";
            }
        }
        return "HORMIGA, no encontrada";
    }

    private Integer getIdHormigaTipo(String tipo) {
        switch (tipo) {
            case "Larva":
                return 6;

            case "Zángano":
                return 7;
            default:
                return 6;
        }
    }

    private Integer getIdHormigaSexo(String sexo) {
        switch (sexo) {
            case "Asexual":
                return 10;

            case "Macho":
                return 8;
            default:
                return 8;
        }
    }

    private Integer getIdHormigaEstado(String estado) {
        switch (estado) {
            case "VIVA":
                return 11;

            case "MUERTA":
                return 12;
            default:
                return 11;
        }
    }

    private Integer getIdGenoAlimento(String genoAlimento) {
        switch (genoAlimento) {
            case "X":
                return 13;
            case "XX":
                return 14;

            case "XY":
                return 15;
            default:
                return 15;
        }
    }

    private Integer getIdIngestaNativa(String ingestaNativa) {
        switch (ingestaNativa) {
            case "Omnívoro":
                return 18;
            default:
                return 18;
        }
    }

}