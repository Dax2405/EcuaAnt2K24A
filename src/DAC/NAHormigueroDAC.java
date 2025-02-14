package DAC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BLC.Entities.NAHLarva;
import BLC.Entities.NAHZangano;
import BLC.Entities.NAHormiga;
import Infra.Config;

public class NAHormigueroDAC {

    public void naSaveHormigueroToCSV(String fullData) {
        try (FileWriter writer = new FileWriter(Config.DATAFILE, false)) {
            writer.write(fullData);
            writer.write(System.lineSeparator());
            Config.showMsg("Datos guardados exitosamente en " + Config.DATAFILE);
        } catch (IOException e) {
            Config.showMsgError("Error al guardar datos: " + e.getMessage());
        }
    }

    public List<NAHormiga> naGetHormigueroFromCSV() {
        List<NAHormiga> hormigas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(Config.DATAFILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if (values[1].equals("larva") && values[3].equals("Omnívoro")) {
                    NAHLarva hormiga = new NAHLarva(Integer.parseInt(values[0]), values[1], values[2], values[3],
                            values[4]);
                    hormigas.add(hormiga);
                } else if (values[1].equals("Zángano") && values[3].equals("Omnívoro")) {
                    NAHZangano hormiga = new NAHZangano(Integer.parseInt(values[0]), values[1], values[2], values[3],
                            values[4]);
                    hormigas.add(hormiga);
                } else {
                    Config.showMsgError("Tipo de hormiga no reconocido, solo se soportan larvas y zánganos");
                }

            }
        } catch (IOException e) {
            Config.showMsgError("Error al leer datos: " + e.getMessage());
        }
        return hormigas;
    }
}
