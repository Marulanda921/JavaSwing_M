package Panel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import LogicaPacientes.MetodosPacientes;
import Principal.Inicio;

public class JPacientes extends JPanel {

	private static final long serialVersionUID = 1L;

	private MetodosPacientes metodosPacientes;

	public JPacientes(String doctorID) {
		this.metodosPacientes = new MetodosPacientes(doctorID);

		setLayout(new BorderLayout());

		JPanel derechaPanel = new JPanel();
		derechaPanel.setLayout(new GridLayout(0, 1));

		JLabel lblEspacio_1 = new JLabel("");
		derechaPanel.add(lblEspacio_1);

		JLabel lblEspacio_2 = new JLabel("");
		derechaPanel.add(lblEspacio_2);

		JLabel lblEspacio_3 = new JLabel("");
		derechaPanel.add(lblEspacio_3);

		JButton btnMenuPrincipal = new JButton("Menu Principal");
		derechaPanel.add(btnMenuPrincipal);

		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JPacientes.this);
				if (frame != null) {
					frame.mostrarJIngresoDoc();
				}
			}
		});

		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		derechaPanel.add(btnCerrarSesion);

		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JPacientes.this);
				if (frame != null) {
					frame.mostrarPanelInicioSesion();
				}
			}
		});

		add(derechaPanel, BorderLayout.EAST);

		JPanel superiorPanel = new JPanel();
		add(superiorPanel, BorderLayout.NORTH);

		JLabel tituloPrincipal = new JLabel("Pacientes");
		tituloPrincipal.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		superiorPanel.add(tituloPrincipal);

		JPanel centroPanel = new JPanel();
		centroPanel.setLayout(new GridLayout(0, 1));

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodosPacientes.registrarPaciente();
			}
		});

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodosPacientes.eliminarPaciente();
			}
		});

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodosPacientes.modificarPaciente();
			}
		});

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodosPacientes.verHistoriales();
			}
		});

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodosPacientes.buscarPaciente();
			}
		});

		JButton btnAgregarChequeo = new JButton("Agregar Chequeo");
		btnAgregarChequeo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodosPacientes.agregarChequeo();
			}
		});

		centroPanel.add(btnRegistrar);
		centroPanel.add(btnEliminar);
		centroPanel.add(btnModificar);
		centroPanel.add(btnListar);
		centroPanel.add(btnBuscar);
		centroPanel.add(btnAgregarChequeo);

		add(centroPanel, BorderLayout.CENTER);
	}
}
