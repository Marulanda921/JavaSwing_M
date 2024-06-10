package Logica.Paneles;

import javax.swing.*;
import java.awt.*;
import Logica.Paneles.metodosTratamiento.mostrarTratamientos;


public class PanelListarTratamientos extends JPanel {

    private static final long serialVersionUID = 1L; 
    private JTextArea textAreaHistorial;

    public PanelListarTratamientos() {
        setLayout(new BorderLayout());

        textAreaHistorial = new JTextArea();
        textAreaHistorial.setEditable(false);
        JScrollPane scrollPaneHistorial = new JScrollPane(textAreaHistorial);
        add(scrollPaneHistorial, BorderLayout.CENTER);
    }

    public void actualizarListadoTratamientos() {
        String tratamientos = mostrarTratamientos.listarTratamientos();
        textAreaHistorial.setText(tratamientos);
    }
}