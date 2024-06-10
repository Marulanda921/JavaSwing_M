package Logica.Paneles;

import javax.swing.*;
import Logica.Paneles.metodosTratamiento.mostrarTratamientos;
import java.awt.*;

public class PanelIngresoTratamiento extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldRaza;
    private JTextField textFieldEdad;
    private JTextArea textAreaSintomas;
    private JTextArea textAreaResultados;
    private JPanel panelCards;
    private static final String FORMULARIO = "Formulario";
    private static final String RESULTADOS = "Resultados";

    public PanelIngresoTratamiento() {
        setLayout(new BorderLayout());

        panelCards = new JPanel(new CardLayout());
        add(panelCards, BorderLayout.CENTER);


        JPanel panelFormulario = new JPanel(new BorderLayout());
        panelCards.add(panelFormulario, FORMULARIO);

        JPanel Superior = new JPanel();
        panelFormulario.add(Superior, BorderLayout.NORTH);

        JLabel TituloPrincipal = new JLabel("Tratamientos");
        TituloPrincipal.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        Superior.add(TituloPrincipal);

        JPanel Centro = new JPanel(new GridLayout(4, 2, 5, 5));
        panelFormulario.add(Centro, BorderLayout.CENTER);

        JLabel lblRaza = new JLabel("Raza del animal:");
        Centro.add(lblRaza);

        textFieldRaza = new JTextField();
        Centro.add(textFieldRaza);
        textFieldRaza.setColumns(10);

        JLabel lblEdad = new JLabel("Edad del animal:");
        Centro.add(lblEdad);

        textFieldEdad = new JTextField();
        Centro.add(textFieldEdad);
        textFieldEdad.setColumns(10);

        JLabel lblSintomas = new JLabel("Síntoma Principal:");
        Centro.add(lblSintomas);

        textAreaSintomas = new JTextArea();
        JScrollPane scrollPaneSintomas = new JScrollPane(textAreaSintomas);
        Centro.add(scrollPaneSintomas);


        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarTratamiento());
        panelFormulario.add(btnGuardar, BorderLayout.SOUTH);


        JPanel panelResultados = new JPanel(new BorderLayout());
        panelCards.add(panelResultados, RESULTADOS);

        JLabel lblResultados = new JLabel("Resultados de la búsqueda:");
        panelResultados.add(lblResultados, BorderLayout.NORTH);

        textAreaResultados = new JTextArea();
        textAreaResultados.setEditable(false);
        JScrollPane scrollPaneResultados = new JScrollPane(textAreaResultados);
        panelResultados.add(scrollPaneResultados, BorderLayout.CENTER);


        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(e -> buscarTratamientos());
        panelFormulario.add(btnBuscar, BorderLayout.SOUTH);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> volverAlFormulario());
        panelResultados.add(btnVolver, BorderLayout.SOUTH);
    }

    private void guardarTratamiento() {

    }

    private void buscarTratamientos() {
        String raza = textFieldRaza.getText();
        String sintomas = textAreaSintomas.getText();
        String resultados = mostrarTratamientos.buscarTratamientosPorSintomaPrincipalYRaza(raza, sintomas);
        if (!resultados.isEmpty()) {
            CardLayout cardLayout = (CardLayout) panelCards.getLayout();
            cardLayout.show(panelCards, RESULTADOS);
            textAreaResultados.setText(resultados);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron resultados", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void volverAlFormulario() {
        CardLayout cardLayout = (CardLayout) panelCards.getLayout();
        cardLayout.show(panelCards, FORMULARIO);
    }
}

