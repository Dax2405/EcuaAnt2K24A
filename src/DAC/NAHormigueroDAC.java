package DAC;

import java.io.FileWriter;
import java.io.IOException;

import Infra.Config;

public class NAHormigueroDAC {

    public void naSaveHormigueroToCSV(String fullData) {
        try (FileWriter writer = new FileWriter(Config.DATAFILE, true)) {
            writer.write(fullData);
            writer.write(System.lineSeparator());
            Config.showMsg("Datos guardados exitosamente en " + Config.DATAFILE);
        } catch (IOException e) {
            Config.showMsgError("Error al guardar datos: " + e.getMessage());
        }
    }
}
