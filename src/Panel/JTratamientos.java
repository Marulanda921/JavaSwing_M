package Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Principal.Inicio;
import Logica.Paneles.*;
import Logica.Paneles.metodosTratamiento.EliminarTratamientos;

public class JTratamientos extends JPanel {

    private static final long serialVersionUID = 1L;

    private JPanel panelContenedor;
    private PanelIngresoTratamiento panelIngresoTratamiento;
    private PanelListarTratamientos panelListarTratamientos;
    private AgregarTratamientos agregarTratamientos;
    private EliminarTratamientos eliminarTratamientos;

    public JTratamientos() {
        setLayout(new BorderLayout());

        panelContenedor = new JPanel(new CardLayout());

        panelIngresoTratamiento = new PanelIngresoTratamiento();
        panelListarTratamientos = new PanelListarTratamientos();
        agregarTratamientos = new AgregarTratamientos();
        eliminarTratamientos = new EliminarTratamientos();

        panelContenedor.add(panelIngresoTratamiento, "INGRESO");
        panelContenedor.add(panelListarTratamientos, "LISTAR");
        panelContenedor.add(agregarTratamientos, "AGREGAR");
        panelContenedor.add(eliminarTratamientos, "ELIMINAR");

        add(panelContenedor, BorderLayout.CENTER);

        JPanel panelDerecha = new JPanel();
        add(panelDerecha, BorderLayout.EAST);
        panelDerecha.setLayout(new GridLayout(0, 1, 0, 0));

        JButton btnMenuPrincipal = new JButton("Menu Principal");
        panelDerecha.add(btnMenuPrincipal);
        btnMenuPrincipal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JTratamientos.this);
                if (frame != null) {
                    frame.mostrarJIngresoDoc();
                }
            }
        });

        JButton btnPacienteNuevo = new JButton("Buscar Tratamiento");
        panelDerecha.add(btnPacienteNuevo);
        btnPacienteNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPanelIngresoTratamiento();
            }
        });

        JButton btnHistorialPacientes = new JButton("Listar Tratamientos");
        panelDerecha.add(btnHistorialPacientes);
        btnHistorialPacientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelListarTratamientos();
            }
        });

        JButton btnModificarDatos = new JButton("Agregar Tratamiento");
        panelDerecha.add(btnModificarDatos);
        btnModificarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelAgregarTratamientos();
            }
        });

        JButton btnEliminarTratamientos = new JButton("Eliminar Tratamientos");
        btnEliminarTratamientos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPanelEliminarTratamientos();
            }
        });
        panelDerecha.add(btnEliminarTratamientos);

        JLabel lblEspacio_1 = new JLabel("");
        panelDerecha.add(lblEspacio_1);

        JLabel lblEspacio_2 = new JLabel("");
        panelDerecha.add(lblEspacio_2);

        JLabel lblEspacio_3 = new JLabel("");
        panelDerecha.add(lblEspacio_3);

        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
        panelDerecha.add(btnCerrarSesion);
        btnCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JTratamientos.this);
                if (frame != null) {
                    frame.mostrarPanelInicioSesion();
                }
            }
        });
    }

    private void mostrarPanelIngresoTratamiento() {
        CardLayout cardLayout = (CardLayout) panelContenedor.getLayout();
        cardLayout.show(panelContenedor, "INGRESO");
    }

    private void mostrarPanelListarTratamientos() {
        panelListarTratamientos.actualizarListadoTratamientos(); // Actualizar listado de tratamientos
        CardLayout cardLayout = (CardLayout) panelContenedor.getLayout();
        cardLayout.show(panelContenedor, "LISTAR");
    }

    private void mostrarPanelAgregarTratamientos() {
        CardLayout cardLayout = (CardLayout) panelContenedor.getLayout();
        cardLayout.show(panelContenedor, "AGREGAR");
    }

    private void mostrarPanelEliminarTratamientos() {
        CardLayout cardLayout = (CardLayout) panelContenedor.getLayout();
        cardLayout.show(panelContenedor, "ELIMINAR");
    }
}




