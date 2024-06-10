package Logica.Paneles;

import javax.swing.*;
import java.awt.*;
import Logica.Paneles.metodosTratamiento.MetodoAgregarMedicina;

public class AgregarMedicina extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField textFieldNombre;
    private JTextArea textAreaDescripcion;

    public AgregarMedicina() {
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));


        JLabel lblNombre = new JLabel("Nombre:");
        formPanel.add(lblNombre);
        textFieldNombre = new JTextField();
        formPanel.add(textFieldNombre);


        JLabel lblDescripcion = new JLabel("Descripción:");
        formPanel.add(lblDescripcion);
        textAreaDescripcion = new JTextArea(3, 20);
        JScrollPane scrollPaneDescripcion = new JScrollPane(textAreaDescripcion);
        formPanel.add(scrollPaneDescripcion);

        add(formPanel, BorderLayout.CENTER);


        JButton addButton = new JButton("Agregar");
        add(addButton, BorderLayout.SOUTH);


        MetodoAgregarMedicina metodoAgregarMedicina = new MetodoAgregarMedicina(this);
        addButton.addActionListener(e -> metodoAgregarMedicina.agregarMedicina());
    }

    public String getNombreMedicina() {
        return textFieldNombre.getText();
    }

    public String getDescripcionMedicina() {
        return textAreaDescripcion.getText();
    }
}
