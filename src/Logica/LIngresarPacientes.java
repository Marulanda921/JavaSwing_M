package Logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LIngresarPacientes {
    
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_9;
    private JComboBox<String> comboBoxGenero;

    public LIngresarPacientes(JTextField textField, JTextField textField_1, JTextField textField_2, JTextField textField_3,
                             JTextField textField_4, JTextField textField_5, JTextField textField_6, JTextField textField_7,
                             JTextField textField_9, JComboBox<String> comboBoxGenero) {
        this.textField = textField;
        this.textField_1 = textField_1;
        this.textField_2 = textField_2;
        this.textField_3 = textField_3;
        this.textField_4 = textField_4;
        this.textField_5 = textField_5;
        this.textField_6 = textField_6;
        this.textField_7 = textField_7;
        this.textField_9 = textField_9;
        this.comboBoxGenero = comboBoxGenero;
    }

    public void guardarDatos() {
        try {
            FileWriter fw = new FileWriter("Archivos\\datos_pacientes.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            String nombreDueño = textField_1.getText();
            String direccion = textField_5.getText();
            String telefono = textField_2.getText();
            String correo = textField_3.getText();
            String nombreMascota = textField.getText();
            String especie = textField_6.getText();
            String raza = textField_4.getText();
            String edad = textField_7.getText();
            String genero = (String) comboBoxGenero.getSelectedItem();
            String antecedentes = textField_9.getText();

            String datos = String.format(
                    "Nombre Dueño: %s, Dirección: %s, Teléfono: %s, Correo: %s, Nombre Mascota: %s, Especie: %s, Raza: %s, Edad: %s, Género: %s, Antecedentes: %s",
                    nombreDueño, direccion, telefono, correo, nombreMascota, especie, raza, edad, genero, antecedentes);

            bw.write(datos);
            bw.newLine();

            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void verHistoriales() {
        try {
            FileReader fr = new FileReader("Archivos\\datos_pacientes.txt");
            BufferedReader br = new BufferedReader(fr);
            StringBuilder historiales = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null) {
                historiales.append(linea).append("\n");
            }

            br.close();
            fr.close();
            JTextArea textArea = new JTextArea(historiales.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new java.awt.Dimension(600, 400));
            JOptionPane.showMessageDialog(null, scrollPane, "Historiales de Pacientes", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
    
}