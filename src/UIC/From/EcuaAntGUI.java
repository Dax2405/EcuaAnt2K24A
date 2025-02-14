package UIC.From;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import BLC.NACatalogoBL;
import BLC.NAHormigueroBL;
import BLC.Entities.NAHormiga;

import java.awt.*;
import java.util.Map;

public class EcuaAntGUI extends JFrame {
    private JPanel panelMenu;
    private JPanel panelMain;
    private JTable tableHormigas;
    private JComboBox<String> comboGenoAlimento;
    private JComboBox<String> comboIngestaNativa;
    private DefaultTableModel tableModel;
    private NAHormigueroBL hormigueroBL;
    private NACatalogoBL catalogoBL;
    private Integer selectedHormigaId;

    public EcuaAntGUI() {
        setTitle("EcuaAnt 2K24A");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        hormigueroBL = new NAHormigueroBL();
        catalogoBL = new NACatalogoBL();

        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        panelMenu = new JPanel();
        panelMain = new JPanel(new BorderLayout());

        add(panelMenu, BorderLayout.WEST);
        add(panelMain, BorderLayout.CENTER);

        initPanelMain();
        initStatusBar();
    }

    private void initPanelMain() {
        JPanel panelEcuaAnt = new JPanel(new BorderLayout());

        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/UIC/Resource/logo.png"));
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel labelLogo = new JLabel(resizedIcon);
        panelEcuaAnt.add(labelLogo, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(
                new Object[] { "ID", "TipoHormiga", "Sexo", "Alimentación", "Estado", "Entrenada" }, 0);
        tableHormigas = new JTable(tableModel);
        tableHormigas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableHormigas.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tableHormigas.getSelectedRow() != -1) {
                selectedHormigaId = (int) tableModel.getValueAt(tableHormigas.getSelectedRow(), 0);
            }
        });
        JScrollPane scrollPane = new JScrollPane(tableHormigas);
        panelEcuaAnt.add(scrollPane, BorderLayout.CENTER);

        JPanel panelCombos = new JPanel(new GridLayout(1, 2));
        comboGenoAlimento = new JComboBox<>();
        comboIngestaNativa = new JComboBox<>();
        panelCombos.add(comboGenoAlimento);
        panelCombos.add(comboIngestaNativa);

        JPanel panelBotones = new JPanel(new GridLayout(1, 5));
        JButton btnCrearLarva = new JButton("Crear Larva");
        JButton btnAlimentar = new JButton("Alimentar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnEntrenar = new JButton("Entrenar");
        JButton btnGuardar = new JButton("Guardar");

        panelBotones.add(btnCrearLarva);
        panelBotones.add(btnAlimentar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnEntrenar);
        panelBotones.add(btnGuardar);

        // Panel combinado para ComboBoxes y Botones
        JPanel panelSur = new JPanel(new BorderLayout());
        panelSur.add(panelCombos, BorderLayout.NORTH);
        panelSur.add(panelBotones, BorderLayout.SOUTH);

        panelEcuaAnt.add(panelSur, BorderLayout.SOUTH);

        panelMain.add(panelEcuaAnt, BorderLayout.CENTER);

        initComboBoxes();
        updateTable();

        // Agregar listeners a los botones
        btnCrearLarva.addActionListener(e -> crearLarva());
        btnAlimentar.addActionListener(e -> alimentarHormiga());
        btnEliminar.addActionListener(e -> eliminarHormiga());
        btnEntrenar.addActionListener(e -> entrenarHormiga());
        btnGuardar.addActionListener(e -> guardarHormiguero());
    }

    private void initComboBoxes() {
        try {
            Map<Integer, String> genoAlimentos = catalogoBL.getAllHormigaTipoGeno();
            Map<Integer, String> ingestaNativas = catalogoBL.getAllHormigaTipoIngesta();

            for (String value : genoAlimentos.values()) {
                comboGenoAlimento.addItem(value);
            }

            for (String value : ingestaNativas.values()) {
                comboIngestaNativa.addItem(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (NAHormiga hormiga : hormigueroBL.lstHormiguero) {
            tableModel.addRow(new Object[] {
                    hormiga.getNaId(),
                    hormiga.getNaTipo(),
                    hormiga.getNaSexo(),
                    hormiga.getNaAlimentacion(),
                    hormiga.getNaEstado(),
                    hormiga.getNaEntrenada() ? "Sí" : "No"
            });
        }
    }

    private void initStatusBar() {
        JLabel statusBar = new JLabel("Programación II | Cédula: 1725095150 | Nombres: Navarrete Freire Ariel Dax");
        add(statusBar, BorderLayout.SOUTH);
    }

    private void crearLarva() {
        int result = JOptionPane.showConfirmDialog(this, "¿Está seguro de crear una Hormiga larva?", "Confirmar",
                JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            try {
                hormigueroBL.crearLarva();
                updateTable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void alimentarHormiga() {
        String genoAlimento = (String) comboGenoAlimento.getSelectedItem();
        String ingestaNativa = (String) comboIngestaNativa.getSelectedItem();
        try {
            String result = hormigueroBL.alimentarHormiga(selectedHormigaId, genoAlimento, ingestaNativa);
            JOptionPane.showMessageDialog(this, result);
            updateTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eliminarHormiga() {
        int result = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar la hormiga?", "Confirmar",
                JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            try {
                String resultMsg = hormigueroBL.eliminarHormiga(selectedHormigaId);
                JOptionPane.showMessageDialog(this, resultMsg);
                updateTable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void entrenarHormiga() {
        try {
            String result = hormigueroBL.entrenarHormiga(selectedHormigaId);
            JOptionPane.showMessageDialog(this, result);
            updateTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
        updateTable();
    }

    private void guardarHormiguero() {
        try {
            String result = hormigueroBL.guardarHormiquero();
            JOptionPane.showMessageDialog(this, result);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ups...! tenemos problema al respaldar");
        }
    }
}