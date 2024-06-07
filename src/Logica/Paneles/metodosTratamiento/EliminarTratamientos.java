package Logica.Paneles.metodosTratamiento;
import javax.swing.*;
import java.awt.*;

public class EliminarTratamientos extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField textFieldRaza;
    private JTextField textFieldSintomaPrincipal;

    public EliminarTratamientos() {
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        // Raza
        JLabel lblRaza = new JLabel("Raza:");
        formPanel.add(lblRaza);
        textFieldRaza = new JTextField();
        formPanel.add(textFieldRaza);

        // Síntoma Principal
        JLabel lblSintomaPrincipal = new JLabel("Síntoma Principal:");
        formPanel.add(lblSintomaPrincipal);
        textFieldSintomaPrincipal = new JTextField();
        formPanel.add(textFieldSintomaPrincipal);

        add(formPanel, BorderLayout.CENTER);

        // Crear el botón de eliminar
        JButton deleteButton = new JButton("Eliminar");
        add(deleteButton, BorderLayout.SOUTH);

        // Agregar el ActionListener para eliminar el tratamiento
        deleteButton.addActionListener(e -> eliminarTratamiento());
    }

    private void eliminarTratamiento() {
        String raza = textFieldRaza.getText();
        String sintomaPrincipal = textFieldSintomaPrincipal.getText();

        String resultado = mostrarTratamientos.eliminarTratamiento(raza, sintomaPrincipal);

        // Mostrar el resultado en un cuadro de diálogo
        JOptionPane.showMessageDialog(this, resultado);
    }
}