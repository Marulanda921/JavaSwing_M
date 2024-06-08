package Logica.Paneles;

import javax.swing.*;
import java.awt.*;
import Logica.Paneles.metodosTratamiento.mostrarMedicina;

public class PanelIngresoMedicina extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldNombreMedicina;
    private JTextArea textAreaResultados;
    private JPanel panelCards;
    private static final String FORMULARIO = "Formulario";
    private static final String RESULTADOS = "Resultados";
    private JPanel panelResultados; // Nuevo

    public PanelIngresoMedicina() {
        setLayout(new BorderLayout());

        panelCards = new JPanel(new CardLayout());
        add(panelCards, BorderLayout.CENTER);

        // Panel para el formulario
        JPanel panelFormulario = new JPanel(new BorderLayout());
        panelCards.add(panelFormulario, FORMULARIO);

        JPanel Superior = new JPanel();
        panelFormulario.add(Superior, BorderLayout.NORTH);

        JLabel lblTituloPrincipal = new JLabel("Medicinas");
        lblTituloPrincipal.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        Superior.add(lblTituloPrincipal);

        JPanel Centro = new JPanel(new GridLayout(1, 2, 5, 5));
        panelFormulario.add(Centro, BorderLayout.CENTER);

        JLabel lblNombreMedicina = new JLabel("Nombre de la medicina:");
        Centro.add(lblNombreMedicina);

        textFieldNombreMedicina = new JTextField();
        Centro.add(textFieldNombreMedicina);
        textFieldNombreMedicina.setColumns(10);

        // Botón de buscar medicinas
        JButton btnBuscar = new JButton("Buscar Medicinas");
        btnBuscar.addActionListener(e -> buscarMedicinas());
        panelFormulario.add(btnBuscar, BorderLayout.SOUTH);

        // Panel para los resultados
        panelResultados = new JPanel(new BorderLayout()); // Cambiado
        panelCards.add(panelResultados, RESULTADOS);

        JLabel lblResultados = new JLabel("Resultados de la búsqueda:");
        panelResultados.add(lblResultados, BorderLayout.NORTH);

        textAreaResultados = new JTextArea();
        textAreaResultados.setEditable(false);
        JScrollPane scrollPaneResultados = new JScrollPane(textAreaResultados);
        panelResultados.add(scrollPaneResultados, BorderLayout.CENTER);

        // Botón de volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> volverAlFormulario());
        panelResultados.add(btnVolver, BorderLayout.SOUTH); // Cambiado
    }

    private void buscarMedicinas() {
        String nombreMedicina = textFieldNombreMedicina.getText(); 
        
        // Llamar al método para buscar la medicina por nombre
        String resultadoBusqueda = mostrarMedicina.buscarMedicinasPorNombre(nombreMedicina);

        System.out.println(resultadoBusqueda);

        if (!resultadoBusqueda.isEmpty()) {
            CardLayout cardLayout = (CardLayout) panelCards.getLayout();
            cardLayout.show(panelCards, RESULTADOS);
            textAreaResultados.setText(resultadoBusqueda);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron resultados", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void volverAlFormulario() {
        CardLayout cardLayout = (CardLayout) panelCards.getLayout();
        cardLayout.show(panelCards, FORMULARIO);
    }
}



