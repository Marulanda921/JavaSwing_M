package Panel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import Principal.Inicio;
import Logica.Paneles.AgregarCita; // Importar el panel AgregarCita
import Logica.Paneles.PanelIngresoCitas; // Importar el panel PanelIngresoCitas
import Logica.Paneles.PanelModificarCitas; // Importar el panel PanelModificarCitas
import Logica.Paneles.metodosTratamiento.mostrarCitas; // Importar el método mostrarCitas

public class JCitas extends JPanel {

    private static final long serialVersionUID = 1L;
    private CardLayout cardLayout;
    private JPanel panelContainer;
    private JTextArea textAreaCitas;

    public JCitas() {
        setLayout(new BorderLayout(0, 0));

        JPanel Derecha = new JPanel();
        add(Derecha, BorderLayout.EAST);
        Derecha.setLayout(new GridLayout(0, 1, 0, 0));

        JButton btnMenuPrincipal = new JButton("Menu Principal");
        Derecha.add(btnMenuPrincipal);

        btnMenuPrincipal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JCitas.this);
                if (frame != null) {
                    frame.mostrarJIngresoDoc();
                }
            }
        });

        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
        Derecha.add(btnCerrarSesion);

        btnCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JCitas.this);
                if (frame != null) {
                    frame.mostrarPanelInicioSesion();
                }
            }
        });

        JLabel lblEspacio_2 = new JLabel("");
        Derecha.add(lblEspacio_2);

        JButton btnAgregarCita = new JButton("Agregar Cita");
        Derecha.add(btnAgregarCita);

        btnAgregarCita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelContainer, "AgregarCita");
            }
        });

        JButton btnBuscarCita = new JButton("Buscar Cita ");
        Derecha.add(btnBuscarCita);

        btnBuscarCita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelContainer, "BuscarCita");
            }
        });

        JButton btnListarCitas = new JButton("Listar Citas");
        Derecha.add(btnListarCitas);

        btnListarCitas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarCitas();
            }
        });

        JButton btnModificarCitas = new JButton("Modificar Citas");
        Derecha.add(btnModificarCitas);

        btnModificarCitas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarYMostrarPanelModificar();
            }
        });
        
        // Botón para eliminar citas
        JButton btnEliminarCita = new JButton("Eliminar Cita");
        Derecha.add(btnEliminarCita);
        
        btnEliminarCita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarCita();
            }
        });

        JLabel lblEspacio_3 = new JLabel("");
        Derecha.add(lblEspacio_3);

        JPanel Superior = new JPanel();
        add(Superior, BorderLayout.NORTH);

        JLabel TituloPrincipal = new JLabel("Citas Programadas");
        TituloPrincipal.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        Superior.add(TituloPrincipal);

        JPanel Izquierda = new JPanel();
        add(Izquierda, BorderLayout.WEST);

        JPanel Inferior = new JPanel();
        add(Inferior, BorderLayout.SOUTH);

        panelContainer = new JPanel();
        cardLayout = new CardLayout();
        panelContainer.setLayout(cardLayout);
        add(panelContainer, BorderLayout.CENTER);

        JPanel panelCitasProgramadas = new JPanel();
        panelCitasProgramadas.add(new JLabel("Citas Programadas Panel"));

        AgregarCita panelAgregarCita = new AgregarCita();

        // Panel para buscar citas por nombre
        PanelIngresoCitas panelBuscarCita = new PanelIngresoCitas();

        // Panel para mostrar todas las citas
        JPanel panelListarCitas = new JPanel(new BorderLayout());
        textAreaCitas = new JTextArea();
        textAreaCitas.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaCitas);
        panelListarCitas.add(scrollPane, BorderLayout.CENTER);

        // Panel para modificar citas
        PanelModificarCitas panelModificarCitas = new PanelModificarCitas();

        panelContainer.add(panelCitasProgramadas, "CitasProgramadas");
        panelContainer.add(panelAgregarCita, "AgregarCita");
        panelContainer.add(panelBuscarCita, "BuscarCita");
        panelContainer.add(panelListarCitas, "ListarCitas");
        panelContainer.add(panelModificarCitas, "ModificarCitas");
    }

    private void listarCitas() {
        String listaCitas = mostrarCitas.listarCitas();
        textAreaCitas.setText(listaCitas);
        cardLayout.show(panelContainer, "ListarCitas");
    }

    private void buscarYMostrarPanelModificar() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre a buscar:");
        if (nombre != null && !nombre.isEmpty()) {
            String resultadoBusqueda = mostrarCitas.buscarCitasPorNombre(nombre);
            if (!resultadoBusqueda.isEmpty()) {
                String[] citaSplit = resultadoBusqueda.split("\n");
                if (citaSplit.length >= 5) { // Verificar que hay suficientes elementos en la división
                    String apellido = citaSplit[1].substring("Apellido:".length()).trim();
                    String fecha = citaSplit[2].substring("Fecha:".length()).trim();
                    String hora = citaSplit[3].substring("Hora:".length()).trim();
                    String descripcion = citaSplit[4].substring("Descripción:".length()).trim();

                    PanelModificarCitas panelModificarCitas = (PanelModificarCitas) panelContainer.getComponent(panelContainer.getComponentCount() - 1);
                    panelModificarCitas.setCita(nombre, apellido, fecha, hora, descripcion);
                    cardLayout.show(panelContainer, "ModificarCitas");
                } else {
                    JOptionPane.showMessageDialog(this, "El usuario no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se encontraron citas con el nombre proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
 // Método para eliminar cita
    private void eliminarCita() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre de la cita a eliminar:");
        String apellido = JOptionPane.showInputDialog(this, "Ingrese el apellido de la cita a eliminar:");
        String usuarioLogueado = JLogin.getUsuarioLogueado();
        String resultadoEliminacion = mostrarCitas.eliminarCita(nombre, apellido, usuarioLogueado);
        JOptionPane.showMessageDialog(this, resultadoEliminacion);
    }
}





