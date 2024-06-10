package LogicaPerfilDoc;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MetodosDoctores {

	private String doctorID;

	public MetodosDoctores(String doctorID) {
		this.doctorID = doctorID;
	}

	public void registrarDoctor(String datos) {
		guardarDatos(datos);
		JOptionPane.showMessageDialog(null, "Doctor registrado exitosamente.", "Registro Exitoso",
				JOptionPane.INFORMATION_MESSAGE);
	}

	private void guardarDatos(String nuevoRegistro) {
		try (BufferedWriter writer = new BufferedWriter(
				new FileWriter("Archivos\\datosDoc" + doctorID + ".txt", true))) {
			writer.write(nuevoRegistro);
			writer.newLine();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al guardar los datos del doctor.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public String[] mostrarRegistro(String numLicencia) {
		File file = new File("Archivos\\datosDoc" + doctorID + ".txt");
		if (!file.exists()) {
			JOptionPane.showMessageDialog(null, "El archivo de doctores no existe.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains("Número de Licencia Médica: " + numLicencia)) {
					String[] datos = new String[14];
					datos[0] = line.split(": ").length > 1 ? line.split(": ")[1] : "";
					for (int i = 1; i < datos.length; i++) {
						line = br.readLine();
						if (line != null && i < datos.length) {
							datos[i] = line.split(": ").length > 1 ? line.split(": ")[1] : "";
						} else {
							datos[i] = "";
						}
					}
					return datos;
				}
			}
			JOptionPane.showMessageDialog(null, "No se encontró el registro del doctor.", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al leer el archivo de doctores.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

}
