package LogicaPacientes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Pacientes {
	private String doctorID;

	public Pacientes(String doctorID) {
		this.doctorID = doctorID;
	}

	public void guardarDatos(String nuevoRegistro) {
		try (FileWriter fw = new FileWriter("Archivos\\datos_pacientes_" + doctorID + ".txt", true)) {
			fw.write(nuevoRegistro + "\n");
			JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
		} catch (IOException e) {
			mostrarError("Error al guardar los datos.");
		}
	}

	public String buscarPaciente(String nombreDueño) {
		StringBuilder resultados = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader("Archivos\\datos_pacientes_" + doctorID + ".txt"))) {
			String linea;
			boolean encontrado = false;
			while ((linea = br.readLine()) != null) {
				if (linea.contains("Nombre Dueño: " + nombreDueño)) {
					encontrado = true;
					resultados.append(linea).append("\n");
					while ((linea = br.readLine()) != null
							&& !linea.equals("-----------------------------------------")) {
						resultados.append(linea).append("\n");
					}
					resultados.append("-----------------------------------------\n\n");
				}
			}
			if (!encontrado) {
				return "No se encontraron pacientes con el nombre del dueño proporcionado.";
			}
		} catch (IOException e) {
			mostrarError("Error al leer los datos.");
		}
		return resultados.toString();
	}

	public String modificarPaciente(String nombreDueño) {
		StringBuilder datosPaciente = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader("Archivos\\datos_pacientes_" + doctorID + ".txt"))) {
			String linea;
			boolean encontrado = false;
			while ((linea = br.readLine()) != null) {
				if (linea.contains("Nombre Dueño: " + nombreDueño)) {
					encontrado = true;
					datosPaciente.append(linea).append("\n");
					for (int i = 0; i < 17; i++) {
						datosPaciente.append(br.readLine()).append("\n");
					}
					break;
				}
			}
			if (!encontrado) {
				return null;
			}
		} catch (IOException e) {
			mostrarError("Error al leer los datos.");
		}
		JOptionPane.showMessageDialog(null, "Datos del paciente para modificar:\n\n" + datosPaciente,
				"Datos del Paciente", JOptionPane.INFORMATION_MESSAGE);
		return datosPaciente.toString();
	}

	public void eliminarRegistroOriginal() {
		List<String> lineas = leerArchivo();
		if (lineas == null)
			return;

		try (FileWriter fw = new FileWriter("Archivos\\datos_pacientes_" + doctorID + ".txt")) {
			for (String linea : lineas) {
				fw.write(linea + "\n");
			}
		} catch (IOException e) {
			mostrarError("Error al eliminar el registro original.");
		}
	}

	public void eliminarPaciente(String nombreDueño) {
		List<String> lineas = leerArchivo();
		if (lineas == null)
			return;

		StringBuilder registro = new StringBuilder();
		boolean encontrado = false;
		for (int i = 0; i < lineas.size(); i++) {
			if (lineas.get(i).contains("Nombre Dueño: " + nombreDueño)) {
				encontrado = true;
				for (int j = 0; j <= 17; j++) {
					registro.append(lineas.remove(i)).append("\n");
					eliminarPaciente(nombreDueño);
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
				mostrarError("Error al eliminar el paciente.");
			}
			JOptionPane.showMessageDialog(null, "Paciente eliminado correctamente.");
		} else {
			JOptionPane.showMessageDialog(null, "No se encontraron pacientes con el nombre del dueño proporcionado.");
		}
	}

	public String verHistoriales() {
		StringBuilder historialCompleto = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader("Archivos\\datos_pacientes_" + doctorID + ".txt"))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.startsWith("Nombre Dueño: ")) {
					if (historialCompleto.length() > 0) {
						historialCompleto.append("\n-----------------------------------------\n\n");
					}
				}
				historialCompleto.append(linea).append("\n");
			}
		} catch (IOException e) {
			mostrarError("Error al leer los datos.");
			return "Error al leer los datos.";
		}

		return historialCompleto.toString();
	}

	public String agregarChequeoClinico(String nombreDueño) {
		try (BufferedReader reader = new BufferedReader(
				new FileReader("Archivos\\datos_pacientes_" + doctorID + ".txt"))) {
			String linea;
			StringBuilder pacienteBuilder = new StringBuilder();
			boolean pacienteEncontrado = false;
			while ((linea = reader.readLine()) != null) {
				pacienteBuilder.append(linea).append("\n");
				if (linea.contains("Nombre Dueño: " + nombreDueño)) {
					pacienteEncontrado = true;
					for (int i = 0; i < 9; i++) {
						pacienteBuilder.append(reader.readLine()).append("\n");
					}
					break;
				} else {
					pacienteBuilder.setLength(0);
				}
			}
			if (!pacienteEncontrado) {
				return "No se encontró el paciente especificado.";
			}
			return pacienteBuilder.toString();
		} catch (IOException e) {
			mostrarError("Error al leer los datos.");
			return "Error al leer los datos.";
		}
	}

	public void guardarChequeoClinico(String datosPaciente, String chequeoClinico, String nombreDueño) {
		LocalDateTime ahora = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String fechaHora = ahora.format(formatter);

		try (FileWriter fw = new FileWriter("Archivos\\datos_pacientes_" + doctorID + ".txt", true)) {
			fw.write("Último Chequeo de " + nombreDueño + " :" + fechaHora + "\n" + chequeoClinico + "\n");
			JOptionPane.showMessageDialog(null, "Chequeo clínico guardado correctamente.");
		} catch (IOException e) {
			mostrarError("Error al guardar el chequeo clínico.");
		}
	}

	private List<String> leerArchivo() {
		List<String> lineas = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("Archivos\\datos_pacientes_" + doctorID + ".txt"))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				lineas.add(linea);
			}
		} catch (IOException e) {
			mostrarError("Error al leer los datos.");
			return null;
		}
		return lineas;
	}

	private void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
