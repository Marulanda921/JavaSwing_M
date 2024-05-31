package Panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

import Principal.Inicio;

public class JIngresarPacientes extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldNombreDueño;
    private JTextField textFieldDireccion;
    private JTextField textFieldTelefono;
    private JTextField textFieldCorreo;
    private JTextField textFieldNombreMascota;
    private JTextField textFieldEspecie;
    private JTextField textFieldRaza;
    private JTextField textFieldEdad;
    private JTextField textFieldAntecedentes;
    private JComboBox<String> comboBoxGenero;

    private String doctorID;

    public JIngresarPacientes(String doctorID) {
        this.doctorID = doctorID;
        setLayout(new BorderLayout());

        // Initialize components
        textFieldNombreDueño = new JTextField();
        textFieldDireccion = new JTextField();
        textFieldTelefono = new JTextField();
        textFieldCorreo = new JTextField();
        textFieldNombreMascota = new JTextField();
        textFieldEspecie = new JTextField();
        textFieldRaza = new JTextField();
        textFieldEdad = new JTextField();
        textFieldAntecedentes = new JTextField();
        comboBoxGenero = new JComboBox<>();
        comboBoxGenero.addItem("Hembra");
        comboBoxGenero.addItem("Macho");

        JButton btnVolver = new JButton("Cerrar Sesión");
        btnVolver.addActionListener(e -> {
            Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JIngresarPacientes.this);
            if (frame != null) {
                frame.mostrarPanelInicioSesion();
            }
        });

        JButton btnIrAMenu = new JButton("Menu Principal");
        btnIrAMenu.addActionListener(e -> {
            Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JIngresarPacientes.this);
            if (frame != null) {
                frame.mostrarJIngresoDoc();
            }
        });

        JPanel panelDerecha = new JPanel();
        panelDerecha.setLayout(new GridLayout(0, 1, 0, 0));
        panelDerecha.add(new JLabel(""));
        panelDerecha.add(new JLabel(""));
        panelDerecha.add(new JLabel(""));
        panelDerecha.add(new JLabel(""));
        panelDerecha.add(btnIrAMenu);
        panelDerecha.add(btnVolver);
        add(panelDerecha, BorderLayout.EAST);

        JPanel panelArriba = new JPanel();
        panelArriba.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelArriba.setBackground(new Color(255, 182, 193));
        JLabel lblTitulo = new JLabel("Ingrese sus Pacientes aqui <3");
        lblTitulo.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        panelArriba.add(lblTitulo);
        add(panelArriba, BorderLayout.NORTH);

        JPanel panelInferior = new JPanel();
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarDatos());
        JButton btnVerHistoriales = new JButton("Ver Historiales");
        btnVerHistoriales.addActionListener(e -> verHistoriales());
        panelInferior.add(btnGuardar);
        panelInferior.add(btnVerHistoriales);
        add(panelInferior, BorderLayout.SOUTH);

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
        addFormularioComponent(panelFormulario, "Nombre Dueño: ", textFieldNombreDueño);
        addFormularioComponent(panelFormulario, "Dirección: ", textFieldDireccion);
        addFormularioComponent(panelFormulario, "Teléfono: ", textFieldTelefono);
        addFormularioComponent(panelFormulario, "Correo Electrónico: ", textFieldCorreo);
        addFormularioComponent(panelFormulario, "Nombre Mascota: ", textFieldNombreMascota);
        addFormularioComponent(panelFormulario, "Especie: ", textFieldEspecie);
        addFormularioComponent(panelFormulario, "Raza: ", textFieldRaza);
        addFormularioComponent(panelFormulario, "Edad: ", textFieldEdad);
        addFormularioComponent(panelFormulario, "Género: ", comboBoxGenero);
        addFormularioComponent(panelFormulario, "Antecedentes Médicos Relevantes:", textFieldAntecedentes);

        JScrollPane scrollPane = new JScrollPane(panelFormulario);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void addFormularioComponent(JPanel panel, String label, JTextField textField) {
        JPanel subPanel = new JPanel(new GridLayout(0, 1, 0, 0));
        JLabel lbl = new JLabel(label);
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        subPanel.add(lbl);
        subPanel.add(textField);
        textField.setColumns(10);
        panel.add(subPanel);
    }

    private void addFormularioComponent(JPanel panel, String label, JComboBox<String> comboBox) {
        JPanel subPanel = new JPanel(new GridLayout(0, 1, 0, 0));
        JLabel lbl = new JLabel(label);
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        subPanel.add(lbl);
        subPanel.add(comboBox);
        panel.add(subPanel);
    }

    private void guardarDatos() {
        try (FileWriter fw = new FileWriter("Archivos\\datos_pacientes_" + doctorID + ".txt", true)) {
            fw.write("Nombre Dueño: " + textFieldNombreDueño.getText() + "\n");
            fw.write("Dirección: " + textFieldDireccion.getText() + "\n");
            fw.write("Teléfono: " + textFieldTelefono.getText() + "\n");
            fw.write("Correo: " + textFieldCorreo.getText() + "\n");
            fw.write("Nombre Mascota: " + textFieldNombreMascota.getText() + "\n");
            fw.write("Especie: " + textFieldEspecie.getText() + "\n");
            fw.write("Raza: " + textFieldRaza.getText() + "\n");
            fw.write("Edad: " + textFieldEdad.getText() + "\n");
            fw.write("Género: " + comboBoxGenero.getSelectedItem() + "\n");
            fw.write("Antecedentes Médicos: " + textFieldAntecedentes.getText() + "\n");
            fw.write("\n-----------------------------------------\n\n");
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
            limpiarCampos();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar los datos.");
        }
    }

    private void verHistoriales() {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        try (BufferedReader br = new BufferedReader(new FileReader("Archivos\\datos_pacientes_" + doctorID + ".txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                textArea.append(linea + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            textArea.setText("Error al leer los datos.");
        }
        JScrollPane scrollPane = new JScrollPane(textArea);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        JOptionPane.showMessageDialog(null, panel, "Historiales de Pacientes", JOptionPane.INFORMATION_MESSAGE);
    }

    private void limpiarCampos() {
        textFieldNombreDueño.setText("");
        textFieldDireccion.setText("");
        textFieldTelefono.setText("");
        textFieldCorreo.setText("");
        textFieldNombreMascota.setText("");
        textFieldEspecie.setText("");
        textFieldRaza.setText("");
        textFieldEdad.setText("");
        textFieldAntecedentes.setText("");
        comboBoxGenero.setSelectedIndex(0);
    }
}
