package LogicaPacientes;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MetodosPacientes {

	private JTextField textFieldNombreDueño;
	private JTextField textFieldDireccion;
	private JTextField textFieldTelefono;
	private JTextField textFieldNombrePaciente;
	private JTextField textFieldEspecie;
	private JTextField textFieldRaza;
	private JTextField textFieldEdad;
	private JTextField textFieldSexo;
	private JTextField textFieldColor;
	private JComboBox<String> comboBoxVacunacion;
	private JTextArea textAreaCorreoElectronico;
	private JTextArea textAreaVacunacion;
	private JTextArea textAreaDesparasitaciones;
	private JTextArea textAreaEnfermedadesPrevias;
	private JTextArea textAreaCirugiasAnteriores;
	private JTextArea textAreaAlergias;
	private JTextArea textAreaMedicamentosActuales;

	private Pacientes pacienteManager;

	public MetodosPacientes(String doctorID) {
		this.pacienteManager = new Pacientes(doctorID);
	}

	public void registrarPaciente() {
		if (textFieldNombreDueño == null) {
			getFormularioPanel();
		}
		limpiarFormulario();
		int result = JOptionPane.showConfirmDialog(null, getFormularioPanel(), "Registrar Paciente",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			if (textFieldNombreDueño.getText().isEmpty()) {

				JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del dueño.", "Error",
						JOptionPane.ERROR_MESSAGE);

			} else {
				String nuevoRegistro = obtenerDatosFormulario();
				pacienteManager.guardarDatos(nuevoRegistro);
				llenarFormulario(nuevoRegistro);
			}
		}
	}

	public void buscarPaciente() {
		String nombreDueño = JOptionPane.showInputDialog(null, "Ingrese el nombre del dueño:", "Buscar Paciente",
				JOptionPane.PLAIN_MESSAGE);
		if (nombreDueño != null) {
			String resultados = pacienteManager.buscarPaciente(nombreDueño);
			mostrarResultados(resultados, "Buscar Paciente");
		}
	}

	public void modificarPaciente() {
		String nombreDueño = JOptionPane.showInputDialog(null, "Ingrese el nombre del dueño:", "Modificar Paciente",
				JOptionPane.PLAIN_MESSAGE);
		if (nombreDueño != null) {
			String datosPaciente = pacienteManager.modificarPaciente(nombreDueño);
			if (datosPaciente != null) {
				int result = JOptionPane.showConfirmDialog(null, getFormularioPanel(), "Modificar Paciente",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					String nuevoRegistro = obtenerDatosFormulario();
					pacienteManager.eliminarRegistroOriginal();
					pacienteManager.guardarDatos(nuevoRegistro);
				}
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró el paciente.", "Modificar Paciente",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void eliminarPaciente() {
		String nombreDueño = JOptionPane.showInputDialog(null, "Ingrese el nombre del dueño:", "Eliminar Paciente",
				JOptionPane.PLAIN_MESSAGE);
		if (nombreDueño != null) {
			pacienteManager.eliminarPaciente(nombreDueño);

		}
	}

	public void verHistoriales() {
		String historiales = pacienteManager.verHistoriales();
		mostrarResultados(historiales, "Historiales de Pacientes");
	}

	public void agregarChequeo() {
		String nombreDueño = JOptionPane.showInputDialog(null, "Ingrese el nombre del dueño:",
				"Agregar Chequeo Clínico", JOptionPane.PLAIN_MESSAGE);
		if (nombreDueño != null) {
			String pacienteChequeo = pacienteManager.agregarChequeoClinico(nombreDueño);
			if (pacienteChequeo != null) {
				String chequeoClinico = JOptionPane.showInputDialog(null, "Ingrese el chequeo clínico:",
						"Agregar Chequeo Clínico", JOptionPane.PLAIN_MESSAGE);
				if (chequeoClinico != null && !chequeoClinico.trim().isEmpty()) {
					pacienteManager.guardarChequeoClinico(pacienteChequeo, chequeoClinico, nombreDueño);
				} else {
					JOptionPane.showMessageDialog(null, "Debe ingresar el chequeo clínico.", "Agregar Chequeo Clínico",
							JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró el paciente.", "Agregar Chequeo Clínico",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public JPanel getFormularioPanel() {
		JPanel formularioPanel = new JPanel();
		formularioPanel.setLayout(new GridLayout(0, 2, 5, 5));

		formularioPanel.add(new JLabel("Nombre Dueño:"));
		textFieldNombreDueño = new JTextField();
		formularioPanel.add(textFieldNombreDueño);

		formularioPanel.add(new JLabel("Dirección:"));
		textFieldDireccion = new JTextField();
		formularioPanel.add(textFieldDireccion);

		formularioPanel.add(new JLabel("Teléfono:"));
		textFieldTelefono = new JTextField();
		formularioPanel.add(textFieldTelefono);

		formularioPanel.add(new JLabel("Correo Electrónico:"));
		textAreaCorreoElectronico = new JTextArea();
		formularioPanel.add(new JScrollPane(textAreaCorreoElectronico));

		formularioPanel.add(new JLabel("Nombre Paciente:"));
		textFieldNombrePaciente = new JTextField();
		formularioPanel.add(textFieldNombrePaciente);

		formularioPanel.add(new JLabel("Especie:"));
		textFieldEspecie = new JTextField();
		formularioPanel.add(textFieldEspecie);

		formularioPanel.add(new JLabel("Raza:"));
		textFieldRaza = new JTextField();
		formularioPanel.add(textFieldRaza);

		formularioPanel.add(new JLabel("Edad:"));
		textFieldEdad = new JTextField();
		formularioPanel.add(textFieldEdad);

		formularioPanel.add(new JLabel("Sexo:"));
		textFieldSexo = new JTextField();
		formularioPanel.add(textFieldSexo);

		formularioPanel.add(new JLabel("Color:"));
		textFieldColor = new JTextField();
		formularioPanel.add(textFieldColor);

		formularioPanel.add(new JLabel("Vacunación:"));
		comboBoxVacunacion = new JComboBox<>(new String[] { "Sí", "No" });
		formularioPanel.add(comboBoxVacunacion);

		formularioPanel.add(new JLabel("Vacunación (Lista de vacunas con fechas):"));
		textAreaVacunacion = new JTextArea();
		formularioPanel.add(new JScrollPane(textAreaVacunacion));

		formularioPanel.add(new JLabel("Desparasitaciones (Fechas y productos usados):"));
		textAreaDesparasitaciones = new JTextArea();
		formularioPanel.add(new JScrollPane(textAreaDesparasitaciones));

		formularioPanel.add(new JLabel("Enfermedades Previas:"));
		textAreaEnfermedadesPrevias = new JTextArea();
		formularioPanel.add(new JScrollPane(textAreaEnfermedadesPrevias));

		formularioPanel.add(new JLabel("Cirugías Anteriores:"));
		textAreaCirugiasAnteriores = new JTextArea();
		formularioPanel.add(new JScrollPane(textAreaCirugiasAnteriores));

		formularioPanel.add(new JLabel("Alergias (alimentos, medicamentos, etc.):"));
		textAreaAlergias = new JTextArea();
		formularioPanel.add(new JScrollPane(textAreaAlergias));

		formularioPanel.add(new JLabel("Medicamentos Actuales:"));
		textAreaMedicamentosActuales = new JTextArea();
		formularioPanel.add(new JScrollPane(textAreaMedicamentosActuales));

		return formularioPanel;
	}

	public void limpiarFormulario() {
		textFieldNombreDueño.setText("");
		textFieldDireccion.setText("");
		textFieldTelefono.setText("");
		textAreaCorreoElectronico.setText("");
		textFieldNombrePaciente.setText("");
		textFieldEspecie.setText("");
		textFieldRaza.setText("");
		textFieldEdad.setText("");
		textFieldSexo.setText("");
		textFieldColor.setText("");
		comboBoxVacunacion.setSelectedIndex(0);
		textAreaVacunacion.setText("");
		textAreaDesparasitaciones.setText("");
		textAreaEnfermedadesPrevias.setText("");
		textAreaCirugiasAnteriores.setText("");
		textAreaAlergias.setText("");
		textAreaMedicamentosActuales.setText("");
	}

	private String obtenerDatosFormulario() {
		StringBuilder datos = new StringBuilder();
		datos.append("Nombre Dueño: ").append(textFieldNombreDueño.getText()).append("\n");
		datos.append("Dirección: ").append(textFieldDireccion.getText()).append("\n");
		datos.append("Teléfono: ").append(textFieldTelefono.getText()).append("\n");
		datos.append("Correo Electrónico: ").append(textAreaCorreoElectronico.getText()).append("\n");
		datos.append("Nombre Paciente: ").append(textFieldNombrePaciente.getText()).append("\n");
		datos.append("Especie: ").append(textFieldEspecie.getText()).append("\n");
		datos.append("Raza: ").append(textFieldRaza.getText()).append("\n");
		datos.append("Edad: ").append(textFieldEdad.getText()).append("\n");
		datos.append("Sexo: ").append(textFieldSexo.getText()).append("\n");
		datos.append("Color: ").append(textFieldColor.getText()).append("\n");
		datos.append("Vacunación: ").append(comboBoxVacunacion.getSelectedItem().toString()).append("\n");
		datos.append("Vacunación (Lista de vacunas con fechas): ").append(textAreaVacunacion.getText()).append("\n");
		datos.append("Desparasitaciones (Fechas y productos usados): ").append(textAreaDesparasitaciones.getText())
				.append("\n");
		datos.append("Enfermedades Previas: ").append(textAreaEnfermedadesPrevias.getText()).append("\n");
		datos.append("Cirugías Anteriores: ").append(textAreaCirugiasAnteriores.getText()).append("\n");
		datos.append("Alergias (alimentos, medicamentos, etc.): ").append(textAreaAlergias.getText()).append("\n");
		datos.append("Medicamentos Actuales: ").append(textAreaMedicamentosActuales.getText()).append("\n");
		datos.append("-----------------------------------------\n\n");
		return datos.toString();
	}

	public void llenarFormulario(String datosPaciente) {
		String[] datos = datosPaciente.split("\n");
		if (datos.length >= 17) {
			textFieldNombreDueño.setText(datos[0].substring(14));
			textFieldDireccion.setText(datos[1].substring(11));
			textFieldTelefono.setText(datos[2].substring(10));
			textAreaCorreoElectronico.setText(datos[3].substring(20));
			textFieldNombrePaciente.setText(datos[4].substring(17));
			textFieldEspecie.setText(datos[5].substring(8));
			textFieldRaza.setText(datos[6].substring(6));
			textFieldEdad.setText(datos[7].substring(6));
			textFieldSexo.setText(datos[8].substring(6));
			textFieldColor.setText(datos[9].substring(7));
			comboBoxVacunacion.setSelectedItem(datos[10].substring(12));
			textAreaVacunacion.setText(datos[11].substring(37));
			textAreaDesparasitaciones.setText(datos[12].substring(43));
			textAreaEnfermedadesPrevias.setText(datos[13].substring(21));
			textAreaCirugiasAnteriores.setText(datos[14].substring(20));
			textAreaAlergias.setText(datos[15].substring(31));
			textAreaMedicamentosActuales.setText(datos[16].substring(22));
		} else {
			JOptionPane.showMessageDialog(null, "Los datos del paciente son incompletos.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void mostrarResultados(String resultados, String titulo) {
		JTextArea textArea = new JTextArea(resultados);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(500, 400));

		JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.PLAIN_MESSAGE);
	}
}