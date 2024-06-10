package Logica.Paneles;

import javax.swing.*;

import Logica.Paneles.metodosTratamiento.mostrarCitas;
import Panel.JLogin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelModificarCitas extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldFecha;
    private JTextField textFieldHora;
    private JTextArea textAreaDescripcion;

    public PanelModificarCitas() {
        setLayout(new BorderLayout());

        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 5, 5));
        add(panelFormulario, BorderLayout.CENTER);

        JLabel lblNombre = new JLabel("Nombre:");
        panelFormulario.add(lblNombre);

        textFieldNombre = new JTextField();
        panelFormulario.add(textFieldNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        panelFormulario.add(lblApellido);

        textFieldApellido = new JTextField();
        panelFormulario.add(textFieldApellido);

        JLabel lblFecha = new JLabel("Fecha:");
        panelFormulario.add(lblFecha);

        textFieldFecha = new JTextField();
        panelFormulario.add(textFieldFecha);

        JLabel lblHora = new JLabel("Hora:");
        panelFormulario.add(lblHora);

        textFieldHora = new JTextField();
        panelFormulario.add(textFieldHora);

        JLabel lblDescripcion = new JLabel("Descripción:");
        panelFormulario.add(lblDescripcion);

        textAreaDescripcion = new JTextArea();
        JScrollPane scrollPaneDescripcion = new JScrollPane(textAreaDescripcion);
        panelFormulario.add(scrollPaneDescripcion);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarCita();
            }
        });
        add(btnModificar, BorderLayout.SOUTH);
    }

    public void setCita(String nombre, String apellido, String fecha, String hora, String descripcion) {
        textFieldNombre.setText(nombre);
        textFieldApellido.setText(apellido);
        textFieldFecha.setText(fecha);
        textFieldHora.setText(hora);
        textAreaDescripcion.setText(descripcion);
    }

    private void modificarCita() {
        String nombre = textFieldNombre.getText();
        String apellido = textFieldApellido.getText();
        String fecha = textFieldFecha.getText();
        String hora = textFieldHora.getText();
        String descripcion = textAreaDescripcion.getText();

        String usuarioLogueado = JLogin.getUsuarioLogueado();
        String resultadoModificacion = mostrarCitas.modificarCita(nombre, apellido, fecha, hora, descripcion, usuarioLogueado);
        JOptionPane.showMessageDialog(this, resultadoModificacion);
    }
}



