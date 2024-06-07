package Logica.Paneles;

import javax.swing.*;
import java.awt.*;
import Logica.Paneles.metodosTratamiento.mostrarMedicina;

public class PanelListarMedicina extends JPanel {

    private static final long serialVersionUID = 1L; // Agregado para controlar la serialización
    private JTextArea textAreaHistorial;

    public PanelListarMedicina() {
        setLayout(new BorderLayout());

        textAreaHistorial = new JTextArea();
        textAreaHistorial.setEditable(false);
        JScrollPane scrollPaneHistorial = new JScrollPane(textAreaHistorial);
        add(scrollPaneHistorial, BorderLayout.CENTER);
    }

    public void actualizarListadoMedicinas() {
        String medicinas = mostrarMedicina.listarMedicinas();
        textAreaHistorial.setText(medicinas);
    }
}

