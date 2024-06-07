package Logica.Paneles.metodosTratamiento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class mostrarMedicina {

    public static String listarMedicinas() {
        StringBuilder medicinas = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("Archivos\\Medicinas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                medicinas.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al leer las medicinas.";
        }

        return medicinas.toString();
    }

    public static String buscarMedicinasPorNombre(String nombreMedicina) {
        try (BufferedReader br = new BufferedReader(new FileReader("Archivos\\Medicinas.txt"))) {
            String linea;
            StringBuilder resultado = new StringBuilder(); 
            boolean encontrado = false;

            while ((linea = br.readLine()) != null) {
                // Verificar si la línea comienza con el nombre de la medicina buscado
                if (linea.toLowerCase().startsWith(nombreMedicina.toLowerCase() + ":")) {
                    // Agregar la medicina encontrada a los resultados
                    resultado.append(linea).append("\n");
                    // Leer y agregar la descripción completa de la medicina
                    while ((linea = br.readLine()) != null && !linea.trim().isEmpty()) {
                        resultado.append(linea).append("\n");
                    }
                    // Se encontró la medicina, establecer el indicador encontrado y salir del bucle
                    encontrado = true;
                    break;
                }
            }

            // Si no se encontró ninguna medicina, retornamos el mensaje de no encontrada
            if (!encontrado) {
                resultado.setLength(0); // Limpiar el StringBuilder
                resultado.append("No se encontró la medicina con el nombre proporcionado.");
            }

            return resultado.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return "Error al buscar las medicinas.";
        }
    }






    public static String agregarMedicina(String nombre, String descripcion) {
        try (FileWriter writer = new FileWriter("Archivos\\Medicinas.txt", true)) {
            writer.write("Medicina: " + nombre + "\n");
            writer.write(descripcion + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al agregar la medicina.";
        }
        return "Medicina agregada exitosamente.";
    }

    public static String eliminarMedicina(String nombre) {
        String archivoTemp = "Archivos\\temp_Medicinas.txt";
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader("Archivos\\Medicinas.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemp))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().toLowerCase().startsWith("medicina:") && linea.toLowerCase().contains(nombre.toLowerCase())) {
                    encontrado = true;

                    while ((linea = br.readLine()) != null && !linea.trim().isEmpty()) {
                        // Saltar las líneas de la medicina a eliminar
                    }
                } else {
                    bw.write(linea + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al eliminar la medicina.";
        }

        try {
            Files.delete(Paths.get("Archivos\\tratamientos.txt"));
            Files.move(Paths.get(archivoTemp), Paths.get("Archivos\\Medicinas.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al actualizar el archivo de medicinas.";
        }

        return encontrado ? "Medicina eliminada exitosamente." : "No se encontró la medicina con el nombre proporcionado.";
    }
}