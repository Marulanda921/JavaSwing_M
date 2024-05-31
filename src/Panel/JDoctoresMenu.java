package Panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Principal.Inicio;

public class JDoctoresMenu extends JPanel {

    private static final long serialVersionUID = 1L;
    private String nombreUsuario; // Campo para almacenar el nombre del usuario

    public JDoctoresMenu(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario; // Asignar el nombre del usuario al campo
        setLayout(new BorderLayout());

        JButton btnIngresarPaciente = new JButton("Ingresar Paciente");
        btnIngresarPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                // Pasar el nombre del usuario como ID del doctor al constructor de JIngresarPacientes
                JIngresarPacientes ingresarPacientesPanel = new JIngresarPacientes(nombreUsuario);
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(JDoctoresMenu.this);
                frame.setContentPane(ingresarPacientesPanel);
                frame.setVisible(true);
            }
        });

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 1, 0, 10));
        centerPanel.add(btnIngresarPaciente);
        add(centerPanel, BorderLayout.CENTER);

        JButton btnTratamientos = new JButton("Tratamientos");
        btnTratamientos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JTratamientos TratamientosPanel = new JTratamientos();
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(JDoctoresMenu.this);
                frame.setContentPane(TratamientosPanel);
                frame.setVisible(true);
            }
        });
        centerPanel.add(btnTratamientos);

        JButton btnMedicinas = new JButton("Medicinas");
        btnMedicinas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JMedicinas MedicinasPanel = new JMedicinas();
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(JDoctoresMenu.this);
                frame.setContentPane(MedicinasPanel);
                frame.setVisible(true);
            }
        });
        centerPanel.add(btnMedicinas);

        JButton btnCitas = new JButton("Citas");
        btnCitas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JCitas CitasPanel = new JCitas();
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(JDoctoresMenu.this);
                frame.setContentPane(CitasPanel);
                frame.setVisible(true);
            }
        });
        centerPanel.add(btnCitas);

        JButton btnPerfilDoc = new JButton("PerfilDoc");
        btnPerfilDoc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JPerfilDoctor PerfilDocPanel = new JPerfilDoctor();
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(JDoctoresMenu.this);
                frame.setContentPane(PerfilDocPanel);
                frame.setVisible(true);
            }
        });
        centerPanel.add(btnPerfilDoc);

        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(JDoctoresMenu.this);
                if (frame instanceof Inicio) {
                    ((Inicio) frame).mostrarPanelInicioSesion();
                }
            }
        });

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        rightPanel.add(btnCerrarSesion);
        add(rightPanel, BorderLayout.EAST);

        JPanel topPanel = new JPanel();
        JLabel lblNewLabel_1 = new JLabel("Bienvenido Doctor(a) " + nombreUsuario);
        topPanel.add(lblNewLabel_1);
        add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        JLabel lblPRUEBA = new JLabel("MENU DE INICIO");
        bottomPanel.add(lblPRUEBA);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
