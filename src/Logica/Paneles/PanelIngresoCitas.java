package Logica.Paneles;
import javax.swing.*;

import Logica.Paneles.metodosTratamiento.mostrarCitas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelIngresoCitas extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldNombre;
    private JTextArea textAreaResultados;
    private JPanel panelCards;
    private static final String FORMULARIO = "Formulario";
    private static final String RESULTADOS = "Resultados";
    private JPanel panelResultados;

    public PanelIngresoCitas() {
        setLayout(new BorderLayout());

        panelCards = new JPanel(new CardLayout());
        add(panelCards, BorderLayout.CENTER);


        JPanel panelFormulario = new JPanel(new BorderLayout());
        panelCards.add(panelFormulario, FORMULARIO);

        JPanel Superior = new JPanel();
        panelFormulario.add(Superior, BorderLayout.NORTH);

        JLabel lblTituloPrincipal = new JLabel("Buscar Citas");
        lblTituloPrincipal.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        Superior.add(lblTituloPrincipal);

        JPanel Centro = new JPanel(new GridLayout(1, 2, 5, 5));
        panelFormulario.add(Centro, BorderLayout.CENTER);

        JLabel lblNombre = new JLabel("Nombre:");
        Centro.add(lblNombre);

        textFieldNombre = new JTextField();
        Centro.add(textFieldNombre);
        textFieldNombre.setColumns(10);


        JButton btnBuscar = new JButton("Buscar Citas");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarCitasPorNombre();
            }
        });
        panelFormulario.add(btnBuscar, BorderLayout.SOUTH);


        panelResultados = new JPanel(new BorderLayout());
        panelCards.add(panelResultados, RESULTADOS);

        JLabel lblResultados = new JLabel("Resultados de la búsqueda:");
        panelResultados.add(lblResultados, BorderLayout.NORTH);

        textAreaResultados = new JTextArea();
        textAreaResultados.setEditable(false);
        JScrollPane scrollPaneResultados = new JScrollPane(textAreaResultados);
        panelResultados.add(scrollPaneResultados, BorderLayout.CENTER);


        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                volverAlFormulario();
            }
        });
        panelResultados.add(btnVolver, BorderLayout.SOUTH);
    }

    private void buscarCitasPorNombre() {
        String nombre = textFieldNombre.getText();
        System.out.println(nombre);


        String resultadoBusqueda = mostrarCitas.buscarCitasPorNombre(nombre);

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