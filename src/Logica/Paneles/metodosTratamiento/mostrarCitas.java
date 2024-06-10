package Logica.Paneles.metodosTratamiento;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import Panel.JLogin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

public class mostrarCitas {
    public static String listarCitas() {
    	String usuarioLogueado = JLogin.getUsuarioLogueado();

        StringBuilder citas = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("Archivos\\Citas_" + usuarioLogueado))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                citas.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al leer las citas.";
        }

        return citas.toString();
    }
    public static String buscarCitasPorNombre(String nombre) {
        String usuarioLogueado = JLogin.getUsuarioLogueado();
        try (BufferedReader br = new BufferedReader(new FileReader("Archivos\\Citas_" + usuarioLogueado))) {
            String linea;
            StringBuilder resultado = new StringBuilder();
            boolean encontrado = false;
            boolean primeraLinea = true;

            while ((linea = br.readLine()) != null) {
                if (primeraLinea && linea.startsWith("Nombre:") && linea.substring("Nombre:".length()).trim().equalsIgnoreCase(nombre)) {
                    encontrado = true;
                    resultado.append(linea).append("\n");
                    while ((linea = br.readLine()) != null && !linea.trim().isEmpty()) {
                        resultado.append(linea).append("\n");
                    }
                    break; 
                }
                primeraLinea = linea.trim().isEmpty();
            }
            if (!encontrado) {
                resultado.setLength(0);
                resultado.append("No se encontró la cita con el nombre proporcionado.");
            }

            return resultado.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al buscar las citas.";
        }
    }
    public static String agregarCita(String nombre, String apellido, String fecha, String hora, String descripcion) {
        String usuarioLogueado = JLogin.getUsuarioLogueado();
        if (!existeUsuario(nombre)) {
            return "El usuario no existe en el archivo de pacientes.";
        }

        try (FileWriter writer = new FileWriter("Archivos\\Citas_" + usuarioLogueado, true);
             BufferedWriter bw = new BufferedWriter(writer);
             PrintWriter out = new PrintWriter(bw)) {
            out.write("Nombre: " + nombre + "\n");
            out.write("Apellido: " + apellido + "\n");
            out.write("Fecha: " + fecha + "\n");
            out.write("Hora: " + hora + "\n");
            out.write("Descripción: " + descripcion + "\n\n");
            out.write("\n");
            out.write("\n");
            return "Cita agregada exitosamente.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al agregar la cita.";
        }
    }

    private static boolean existeUsuario(String nombreDueño) {
        String usuarioLogueado = JLogin.getUsuarioLogueado();
        try (BufferedReader br = new BufferedReader(new FileReader("Archivos\\datos_pacientes_" + usuarioLogueado + ".txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().equalsIgnoreCase("Nombre Dueño: " + nombreDueño)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static String modificarCita(String nombre, String nuevoApellido, String nuevaFecha, String nuevaHora, String nuevaDescripcion, String usuarioLogueado) {
        String archivoOriginal = "Archivos\\Citas_" + usuarioLogueado;
        String archivoTemp = "Archivos\\temp_Citas_" + usuarioLogueado;
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemp))) {

            String linea;
            boolean esCitaActual = false;

            while ((linea = br.readLine()) != null) {
                String[] parts = linea.split(": ", 2);
                if (parts.length == 2) {
                    String nombreCampo = parts[0].trim();
                    String valorCampo = parts[1].trim();

                    if (nombreCampo.equalsIgnoreCase("Nombre") && valorCampo.equalsIgnoreCase(nombre)) {
                        esCitaActual = true;
                        encontrado = true;
                        bw.write(linea); 
                        bw.newLine();
                    } else if (esCitaActual && nombreCampo.equalsIgnoreCase("Apellido")) {
                        bw.write("Apellido: " + nuevoApellido);
                        bw.newLine();
                    } else if (esCitaActual && nombreCampo.equalsIgnoreCase("Fecha")) {
                        bw.write("Fecha: " + nuevaFecha);
                        bw.newLine();
                    } else if (esCitaActual && nombreCampo.equalsIgnoreCase("Hora")) {
                        bw.write("Hora: " + nuevaHora);
                        bw.newLine();
                    } else if (esCitaActual && nombreCampo.equalsIgnoreCase("Descripción")) {
                        bw.write("Descripción: " + nuevaDescripcion);
                        bw.newLine();
                        esCitaActual = false;
                    } else {
                        bw.write(linea);
                        bw.newLine();
                    }
                } else {
                    bw.write(linea);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al modificar la cita.";
        }

        if (!encontrado) {
            return "No se encontró la cita con el nombre proporcionado.";
        }

        try {
            Files.delete(Paths.get(archivoOriginal));
            Files.move(Paths.get(archivoTemp), Paths.get(archivoOriginal));
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al actualizar el archivo de citas.";
        }

        return "Cita modificada exitosamente.";
    }

    public static String eliminarCita(String nombre, String apellido, String usuarioLogueado) {
        String archivoOriginal = "Archivos\\Citas_" + usuarioLogueado;
        String archivoTemp = "Archivos\\temp_Citas_" + usuarioLogueado;
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemp))) {

            String linea;
            boolean enCitaAEliminar = false;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().equalsIgnoreCase("Nombre: " + nombre) && siguienteLineaContieneApellido(br, apellido)) {
                    encontrado = true; 
                    enCitaAEliminar = true;
                    continue;
                }
                if (enCitaAEliminar) {
                    if (linea.trim().isEmpty()) {
                        enCitaAEliminar = false;
                    }
                    continue;
                }
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al eliminar la cita.";
        }
        if (!encontrado) {
            return "No se encontró la cita con el nombre y apellido proporcionados.";
        }
        try {
            Files.delete(Paths.get(archivoOriginal));
            Files.move(Paths.get(archivoTemp), Paths.get(archivoOriginal));
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al actualizar el archivo de citas.";
        }
        return "Cita eliminada exitosamente.";
    }
    private static boolean siguienteLineaContieneApellido(BufferedReader br, String apellido) throws IOException {
        String siguienteLinea = br.readLine();
        if (siguienteLinea != null && siguienteLinea.trim().equalsIgnoreCase("Apellido: " + apellido)) {
            return true;
        }
        return false;
    }
}
