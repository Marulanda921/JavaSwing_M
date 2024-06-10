package Logica.Paneles;

import javax.swing.*;
import java.awt.*;
import Logica.Paneles.metodosTratamiento.MetodoAgregar;

public class AgregarTratamientos extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField textFieldRaza;
    private JTextField textFieldSintomaPrincipal;
    private JTextArea textAreaSintomasSecundarios;
    private JTextArea textAreaTratamiento;

    public AgregarTratamientos() {
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));


        JLabel lblRaza = new JLabel("Raza:");
        formPanel.add(lblRaza);
        textFieldRaza = new JTextField();
        formPanel.add(textFieldRaza);


        JLabel lblSintomaPrincipal = new JLabel("Síntoma Principal:");
        formPanel.add(lblSintomaPrincipal);
        textFieldSintomaPrincipal = new JTextField();
        formPanel.add(textFieldSintomaPrincipal);


        JLabel lblSintomasSecundarios = new JLabel("Síntomas Secundarios:");
        formPanel.add(lblSintomasSecundarios);
        textAreaSintomasSecundarios = new JTextArea(3, 20);
        JScrollPane scrollPaneSintomasSecundarios = new JScrollPane(textAreaSintomasSecundarios);
        formPanel.add(scrollPaneSintomasSecundarios);


        JLabel lblTratamiento = new JLabel("Tratamientos:");
        formPanel.add(lblTratamiento);
        textAreaTratamiento = new JTextArea(3, 20);
        JScrollPane scrollPaneTratamiento = new JScrollPane(textAreaTratamiento);
        formPanel.add(scrollPaneTratamiento);

        add(formPanel, BorderLayout.CENTER);


        JButton modifyButton = new JButton("Agregar");
        add(modifyButton, BorderLayout.SOUTH);


        MetodoAgregar metodoAgregar = new MetodoAgregar(this);
        modifyButton.addActionListener(e -> metodoAgregar.agregarTratamiento());
    }

    public String getRaza() {
        return textFieldRaza.getText();
    }

    public String getSintomaPrincipal() {
        return textFieldSintomaPrincipal.getText();
    }

    public String getSintomasSecundarios() {
        return textAreaSintomasSecundarios.getText();
    }

    public String getTratamiento() {
        return textAreaTratamiento.getText();
    }
}