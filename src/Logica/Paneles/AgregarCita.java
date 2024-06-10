package Logica.Paneles;

import javax.swing.*;
import java.awt.*;
import Logica.Paneles.metodosTratamiento.MetodoAgregarCita; // Asegúrate de tener esta clase después

public class AgregarCita extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldFecha;
    private JTextField textFieldHora;
    private JTextArea textAreaDescripcion;

    public AgregarCita() {
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));


        JLabel lblNombre = new JLabel("Nombre:");
        formPanel.add(lblNombre);
        textFieldNombre = new JTextField();
        formPanel.add(textFieldNombre);


        JLabel lblApellido = new JLabel("Apellido:");
        formPanel.add(lblApellido);
        textFieldApellido = new JTextField();
        formPanel.add(textFieldApellido);

        JLabel lblFecha = new JLabel("Fecha:");
        formPanel.add(lblFecha);
        textFieldFecha = new JTextField();
        formPanel.add(textFieldFecha);


        JLabel lblHora = new JLabel("Hora:");
        formPanel.add(lblHora);
        textFieldHora = new JTextField();
        formPanel.add(textFieldHora);


        JLabel lblDescripcion = new JLabel("Descripción:");
        formPanel.add(lblDescripcion);
        textAreaDescripcion = new JTextArea(3, 20);
        JScrollPane scrollPaneDescripcion = new JScrollPane(textAreaDescripcion);
        formPanel.add(scrollPaneDescripcion);

        add(formPanel, BorderLayout.CENTER);


        JButton addButton = new JButton("Agregar");
        add(addButton, BorderLayout.SOUTH);


        MetodoAgregarCita metodoAgregarCita = new MetodoAgregarCita(this);
        addButton.addActionListener(e -> metodoAgregarCita.agregarCita());
    }

    public String getNombreCita() {
        return textFieldNombre.getText();
    }

    public String getApellidoCita() {
        return textFieldApellido.getText();
    }

    public String getFechaCita() {
        return textFieldFecha.getText();
    }

    public String getHoraCita() {
        return textFieldHora.getText();
    }

    public String getDescripcionCita() {
        return textAreaDescripcion.getText();
    }
}
