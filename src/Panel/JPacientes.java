package Panel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import Principal.Inicio;

public class JPacientes extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombreDueño;
	private JTextField textFieldDireccion;
	private JTextField textFieldTelefono;
	private JTextField textFieldCorreo;
	private JTextField textFieldNombreMascota;
	private JTextField textFieldEspecie;
	private JTextField textFieldRaza;
	private JTextField textFieldEdad;
	private JTextField textFieldAntecedentes;
	private JComboBox<String> comboBoxGenero;
	private JPanel panelNuevoPaciente;
	private JPanel panelHistorialPacientes;
	private JTextArea textAreaHistorial;
	private JPanel panelChequeoClinico;
	private JTextField textFieldChequeoClinico;
	private CardLayout cardLayout;
	private JPanel panelContenido;
	private String doctorID;
	private String registroOriginal;
	private String pacienteChequeo;

	public JPacientes(String doctorID) {
		this.doctorID = doctorID;
		setLayout(new BorderLayout());

		textFieldNombreDueño = new JTextField();
		textFieldDireccion = new JTextField();
		textFieldTelefono = new JTextField();
		textFieldCorreo = new JTextField();
		textFieldNombreMascota = new JTextField();
		textFieldEspecie = new JTextField();
		textFieldRaza = new JTextField();
		textFieldEdad = new JTextField();
		textFieldAntecedentes = new JTextField();
		comboBoxGenero = new JComboBox<>();
		comboBoxGenero.addItem("Hembra");
		comboBoxGenero.addItem("Macho");

		JButton btnVolver = new JButton("Cerrar Sesión");
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JPacientes.this);
				if (frame != null) {
					frame.mostrarPanelInicioSesion();
				}
			}
		});

		JButton btnIrAMenu = new JButton("Menu Principal");
		btnIrAMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JPacientes.this);
				if (frame != null) {
					frame.mostrarJIngresoDoc();
				}
			}
		});

		JPanel panelDerecha = new JPanel();
		panelDerecha.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnPacienteNuevo = new JButton("Ingresar Paciente Nuevo");
		panelDerecha.add(btnPacienteNuevo);

		JButton btnHistorialPacientes = new JButton("Listar Pacientes");
		panelDerecha.add(btnHistorialPacientes);

		JButton btnModificarDatos = new JButton("Modificar Datos");
		panelDerecha.add(btnModificarDatos);

		JButton btnBuscarPacientes_1 = new JButton("Buscar Pacientes");
		panelDerecha.add(btnBuscarPacientes_1);

		btnBuscarPacientes_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buscarPaciente();
			}
		});

		JButton btnEliminarPacientes = new JButton("Eliminar Pacientes");
		panelDerecha.add(btnEliminarPacientes);

		btnEliminarPacientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarPaciente();
			}
		});

		JButton btnAgregarHistoriaClinica = new JButton("Agregar Chequeo Clinico");
		panelDerecha.add(btnAgregarHistoriaClinica);

		btnAgregarHistoriaClinica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarChequeoClinico();
			}
		});

		panelDerecha.add(new JLabel(""));
		panelDerecha.add(btnIrAMenu);
		panelDerecha.add(btnVolver);
		add(panelDerecha, BorderLayout.EAST);

		JPanel panelArriba = new JPanel();
		panelArriba.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelArriba.setBackground(Color.PINK);
		JLabel lblTitulo = new JLabel("Ingrese sus Pacientes aqui <3");
		lblTitulo.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		panelArriba.add(lblTitulo);
		add(panelArriba, BorderLayout.NORTH);

		JPanel panelInferior = new JPanel();
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guardarDatos();
			}
		});
		panelInferior.add(btnGuardar);
		add(panelInferior, BorderLayout.SOUTH);

		cardLayout = new CardLayout();
		panelContenido = new JPanel(cardLayout);

		panelNuevoPaciente = new JPanel();
		panelNuevoPaciente.setLayout(new BoxLayout(panelNuevoPaciente, BoxLayout.Y_AXIS));
		addFormularioComponent(panelNuevoPaciente, "Nombre Dueño: ", textFieldNombreDueño);
		addFormularioComponent(panelNuevoPaciente, "Dirección: ", textFieldDireccion);
		addFormularioComponent(panelNuevoPaciente, "Teléfono: ", textFieldTelefono);
		addFormularioComponent(panelNuevoPaciente, "Correo Electrónico: ", textFieldCorreo);
		addFormularioComponent(panelNuevoPaciente, "Nombre Mascota: ", textFieldNombreMascota);
		addFormularioComponent(panelNuevoPaciente, "Especie: ", textFieldEspecie);
		addFormularioComponent(panelNuevoPaciente, "Raza: ", textFieldRaza);
		addFormularioComponent(panelNuevoPaciente, "Edad: ", textFieldEdad);
		addFormularioComponent(panelNuevoPaciente, "Género: ", comboBoxGenero);
		addFormularioComponent(panelNuevoPaciente, "Antecedentes Médicos Relevantes:", textFieldAntecedentes);

		JScrollPane scrollPaneNuevoPaciente = new JScrollPane(panelNuevoPaciente);
		panelContenido.add(scrollPaneNuevoPaciente, "NuevoPaciente");

		panelHistorialPacientes = new JPanel(new BorderLayout());
		textAreaHistorial = new JTextArea();
		textAreaHistorial.setEditable(false);
		JScrollPane scrollPaneHistorial = new JScrollPane(textAreaHistorial);
		panelHistorialPacientes.add(scrollPaneHistorial, BorderLayout.CENTER);
		panelContenido.add(panelHistorialPacientes, "HistorialPacientes");

		panelChequeoClinico = new JPanel();
		panelChequeoClinico.setLayout(new BoxLayout(panelChequeoClinico, BoxLayout.Y_AXIS));
		textFieldChequeoClinico = new JTextField();
		addFormularioComponent(panelChequeoClinico, "Chequeo Clínico: ", textFieldChequeoClinico);
		JButton btnGuardarChequeo = new JButton("Guardar Chequeo");
		btnGuardarChequeo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guardarChequeoClinico();
			}
		});
		panelChequeoClinico.add(btnGuardarChequeo);
		JScrollPane scrollPaneChequeoClinico = new JScrollPane(panelChequeoClinico);
		panelContenido.add(scrollPaneChequeoClinico, "ChequeoClinico");

		add(panelContenido, BorderLayout.CENTER);

		btnPacienteNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelContenido, "NuevoPaciente");
			}
		});

		btnHistorialPacientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelContenido, "HistorialPacientes");
				verHistoriales();
			}
		});

		btnModificarDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modificarPaciente();
			}
		});
	}

	private void addFormularioComponent(JPanel panel, String label, JTextField textField) {
		JPanel subPanel = new JPanel(new GridLayout(0, 1, 0, 0));
		JLabel lbl = new JLabel(label);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		subPanel.add(lbl);
		subPanel.add(textField);
		panel.add(subPanel);
	}

	private void addFormularioComponent(JPanel panel, String label, JComboBox<String> comboBox) {
		JPanel subPanel = new JPanel(new GridLayout(0, 1, 0, 0));
		JLabel lbl = new JLabel(label);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		subPanel.add(lbl);
		subPanel.add(comboBox);
		panel.add(subPanel);
	}

	private void limpiarCampos() {
		textFieldNombreDueño.setText("");
		textFieldDireccion.setText("");
		textFieldTelefono.setText("");
		textFieldCorreo.setText("");
		textFieldNombreMascota.setText("");
		textFieldEspecie.setText("");
		textFieldRaza.setText("");
		textFieldEdad.setText("");
		textFieldAntecedentes.setText("");
		comboBoxGenero.setSelectedIndex(0);
	}

	private void guardarDatos() {
		try (FileWriter fw = new FileWriter("Archivos\\datos_pacientes_" + doctorID + ".txt", true)) {
			String nuevoRegistro = "Nombre Dueño: " + textFieldNombreDueño.getText() + "\n" + "Dirección: "
					+ textFieldDireccion.getText() + "\n" + "Teléfono: " + textFieldTelefono.getText() + "\n"
					+ "Correo: " + textFieldCorreo.getText() + "\n" + "Nombre Mascota: "
					+ textFieldNombreMascota.getText() + "\n" + "Especie: " + textFieldEspecie.getText() + "\n"
					+ "Raza: " + textFieldRaza.getText() + "\n" + "Edad: " + textFieldEdad.getText() + "\n" + "Género: "
					+ comboBoxGenero.getSelectedItem() + "\n" + "Antecedentes Médicos: "
					+ textFieldAntecedentes.getText() + "\n" + "\n-----------------------------------------\n\n";

			// Eliminar el registro original si estamos en modo de modificación
			if (registroOriginal != null) {
				eliminarRegistroOriginal();
				registroOriginal = null;
			}

			fw.write(nuevoRegistro);
			JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
			limpiarCampos();
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al guardar los datos.");
		}
	}

	private void buscarPaciente() {
		String nombreDueño = JOptionPane.showInputDialog("Ingrese el nombre del dueño:");

		if (nombreDueño != null && !nombreDueño.isEmpty()) {
			StringBuilder resultados = new StringBuilder();
			boolean encontrado = false;

			try (BufferedReader br = new BufferedReader(
					new FileReader("Archivos\\datos_pacientes_" + doctorID + ".txt"))) {
				String linea;
				while ((linea = br.readLine()) != null) {
					if (linea.contains("Nombre Dueño: " + nombreDueño)) {
						resultados.append(linea).append("\n");
						while ((linea = br.readLine()) != null
								&& !linea.equals("-----------------------------------------")) {
							resultados.append(linea).append("\n");
						}
						resultados.append("-----------------------------------------\n\n");
						encontrado = true;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al leer los datos.");
			}

			if (encontrado) {
				textAreaHistorial.setText(resultados.toString());
			} else {
				textAreaHistorial.setText("No se encontraron pacientes con el nombre del dueño proporcionado.");
			}
		}
	}

	private void modificarPaciente() {
		String nombreDueño = JOptionPane.showInputDialog("Ingrese el nombre del dueño:");

		if (nombreDueño != null && !nombreDueño.isEmpty()) {
			boolean encontrado = false;
			StringBuilder datosPaciente = new StringBuilder();

			try (BufferedReader br = new BufferedReader(
					new FileReader("Archivos\\datos_pacientes_" + doctorID + ".txt"))) {
				String linea;
				while ((linea = br.readLine()) != null) {
					if (linea.contains("Nombre Dueño: " + nombreDueño)) {
						encontrado = true;
						datosPaciente.append(linea).append("\n");
						for (int i = 0; i < 9; i++) {
							datosPaciente.append(br.readLine()).append("\n");
						}
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al leer los datos.");
			}

			if (encontrado) {
				// Store the original record
				registroOriginal = datosPaciente.toString();

				// Fill the form with the existing data
				String[] campos = registroOriginal.split("\n");
				textFieldNombreDueño.setText(campos[0].split(": ")[1]);
				textFieldDireccion.setText(campos[1].split(": ")[1]);
				textFieldTelefono.setText(campos[2].split(": ")[1]);
				textFieldCorreo.setText(campos[3].split(": ")[1]);
				textFieldNombreMascota.setText(campos[4].split(": ")[1]);
				textFieldEspecie.setText(campos[5].split(": ")[1]);
				textFieldRaza.setText(campos[6].split(": ")[1]);
				textFieldEdad.setText(campos[7].split(": ")[1]);
				comboBoxGenero.setSelectedItem(campos[8].split(": ")[1]);
				textFieldAntecedentes.setText(campos[9].split(": ")[1]);

				cardLayout.show(panelContenido, "NuevoPaciente");
			} else {
				JOptionPane.showMessageDialog(null,
						"No se encontraron pacientes con el nombre del dueño proporcionado.");
			}
		}
	}

	private void eliminarRegistroOriginal() {
		List<String> lineas = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader("Archivos\\datos_pacientes_" + doctorID + ".txt"))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				lineas.add(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] registroLineas = registroOriginal.split("\n");
		int inicio = lineas.indexOf(registroLineas[0]);

		for (int i = 0; i <= 11; i++) {
			lineas.remove(inicio);
		}

		try (FileWriter fw = new FileWriter("Archivos\\datos_pacientes_" + doctorID + ".txt")) {
			for (String linea : lineas) {
				fw.write(linea + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void eliminarPaciente() {
		String nombreDueño = JOptionPane.showInputDialog("Ingrese el nombre del dueño:");

		if (nombreDueño != null && !nombreDueño.isEmpty()) {
			boolean encontrado = false;
			List<String> lineas = new ArrayList<>();

			try (BufferedReader br = new BufferedReader(
					new FileReader("Archivos\\datos_pacientes_" + doctorID + ".txt"))) {
				String linea;
				while ((linea = br.readLine()) != null) {
					lineas.add(linea);
				}
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al leer los datos.");
				return;
			}

			StringBuilder registro = new StringBuilder();
			for (int i = 0; i < lineas.size(); i++) {
				if (lineas.get(i).contains("Nombre Dueño: " + nombreDueño)) {
					encontrado = true;
					for (int j = 0; j <= 11; j++) {
						registro.append(lineas.remove(i)).append("\n");
					}
					break;
				}
			}

			if (encontrado) {
				try (FileWriter fw = new FileWriter("Archivos\\datos_pacientes_" + doctorID + ".txt")) {
					for (String linea : lineas) {
						fw.write(linea + "\n");
					}
				} catch (IOException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al actualizar los datos.");
					return;
				}
				JOptionPane.showMessageDialog(null, "Paciente eliminado correctamente.");
			} else {
				JOptionPane.showMessageDialog(null,
						"No se encontraron pacientes con el nombre del dueño proporcionado.");
			}
		}
	}

	public void verHistoriales() {
		textAreaHistorial.setText("");
		StringBuilder historialCompleto = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader("Archivos\\datos_pacientes_" + doctorID + ".txt"))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.startsWith("Nombre Dueño: ")) {
					// Append previous record to text area if exists
					if (historialCompleto.length() > 0) {
						historialCompleto.append("\n-----------------------------------------\n\n");
					}
				}
				historialCompleto.append(linea).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
			textAreaHistorial.setText("Error al leer los datos.");
			return;
		}

		// Set the combined text to the text area
		textAreaHistorial.setText(historialCompleto.toString());
	}

	private void agregarChequeoClinico() {
		String nombreDueño = JOptionPane.showInputDialog(this, "Ingrese el nombre del dueño:");
		if (nombreDueño == null || nombreDueño.trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "El nombre del dueño no puede estar vacío.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		StringBuilder pacienteBuilder = new StringBuilder();
		boolean pacienteEncontrado = false;

		try (BufferedReader reader = new BufferedReader(
				new FileReader("Archivos\\datos_pacientes_" + doctorID + ".txt"))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				pacienteBuilder.append(linea).append("\n");
				if (linea.contains("Nombre Dueño: " + nombreDueño)) {
					for (int i = 0; i < 9; i++) {
						pacienteBuilder.append(reader.readLine()).append("\n");
					}
					pacienteChequeo = pacienteBuilder.toString();
					pacienteEncontrado = true;
					break;
				} else {
					pacienteBuilder.setLength(0); // Clear the builder for the next record
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error al buscar el paciente.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (pacienteEncontrado) {
			textFieldChequeoClinico.setText("");
			cardLayout.show(panelContenido, "ChequeoClinico");
		} else {
			JOptionPane.showMessageDialog(this, "No se encontró un paciente con el nombre del dueño proporcionado.",
					"Paciente no encontrado", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void guardarChequeoClinico() {
		if (pacienteChequeo == null || pacienteChequeo.isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"No se ha seleccionado ningún paciente para agregar el chequeo clínico.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		String chequeoClinico = textFieldChequeoClinico.getText().trim();
		if (chequeoClinico.isEmpty()) {
			JOptionPane.showMessageDialog(this, "El chequeo clínico no puede estar vacío.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		LocalDateTime fechaHoraActual = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String fechaHoraChequeo = fechaHoraActual.format(formatter);
		String registroChequeo = pacienteChequeo.trim() + "\nChequeo Clínico: " + fechaHoraChequeo + " - "
				+ chequeoClinico + "\n-----------------------------------------\n\n";

		try (FileWriter writer = new FileWriter("Archivos\\datos_pacientes_" + doctorID + ".txt", true)) {
			writer.write(registroChequeo);
			JOptionPane.showMessageDialog(this, "Chequeo clínico agregado con éxito.", "Éxito",
					JOptionPane.INFORMATION_MESSAGE);
			cardLayout.show(panelContenido, "HistorialPacientes");
			verHistoriales();
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error al agregar el chequeo clínico.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
