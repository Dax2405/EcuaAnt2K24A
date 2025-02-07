import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;

import UIC.From.EcuaAntGUI;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        FlatLightLaf.supportsNativeWindowDecorations();
        try {
            UIManager.setLookAndFeel(new FlatOneDarkIJTheme());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new EcuaAntGUI().setVisible(true);
        });
    }
}