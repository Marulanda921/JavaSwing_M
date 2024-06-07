package Logica.Paneles.metodosTratamiento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class mostrarTratamientos {
    public static String listarTratamientos() {
        StringBuilder tratamientos = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("Archivos\\tratamientos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                tratamientos.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al leer los tratamientos.";
        }

        return tratamientos.toString();
    }

    public static String buscarTratamientosPorSintomaPrincipalYRaza(String raza, String sintomaPrincipal) {
        StringBuilder resultados = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("Archivos\\tratamientos.txt"))) {
            String linea;
            boolean encontrado = false; // Variable para indicar si se encontró al menos un tratamiento

            while ((linea = br.readLine()) != null) {
                // Verificar si la línea comienza con "Raza:" seguido de la raza buscada
                if (linea.trim().startsWith("Raza:") && linea.toLowerCase().contains(raza.toLowerCase())) {
                    // Inicializar el tratamiento para esta raza
                    StringBuilder tratamiento = new StringBuilder();
                    // Verificar si el siguiente síntoma principal coincide
                    while ((linea = br.readLine()) != null && !linea.trim().isEmpty()) {
                        if (linea.trim().startsWith("Síntoma Principal:") && linea.toLowerCase().contains(sintomaPrincipal.toLowerCase())) {
                            // Agregar el tratamiento encontrado a los resultados
                            tratamiento.append(linea).append("\n");
                            // Leer y agregar el tratamiento completo
                            while ((linea = br.readLine()) != null && !linea.trim().isEmpty()) {
                                tratamiento.append(linea).append("\n");
                            }
                            // Agregar el tratamiento encontrado a los resultados
                            resultados.append(tratamiento).append("\n");
                            encontrado = true; // Indicar que se encontró al menos un tratamiento
                            break; // Salir del bucle interno
                        }
                    }
                }
            }

            // Verificar si no se encontraron tratamientos
            if (!encontrado) {
                resultados.append("No se encontraron tratamientos para la raza y síntoma principal proporcionados.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "Error al buscar los tratamientos.";
        }
        return resultados.toString();
    }
    public static String agregarTratamiento(String raza, String sintomaPrincipal, String sintomasSecundarios, String tratamiento) {
        try (FileWriter writer = new FileWriter("Archivos\\tratamientos.txt", true)) {
            writer.write("Raza: " + raza + "\n");
            writer.write("Síntoma Principal: " + sintomaPrincipal + "\n");
            writer.write("Síntomas Secundarios: " + sintomasSecundarios + "\n");
            writer.write("Tratamiento: " + tratamiento + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al agregar el tratamiento.";
        }
        return "Tratamiento agregado exitosamente.";
    }
    
    public static String eliminarTratamiento(String raza, String sintomaPrincipal) {
        String archivoTemp = "Archivos\\temp_tratamientos.txt";
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader("Archivos\\tratamientos.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemp))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().startsWith("Raza:") && linea.toLowerCase().contains(raza.toLowerCase())) {
                    StringBuilder tratamiento = new StringBuilder();
                    tratamiento.append(linea).append("\n");

                    while ((linea = br.readLine()) != null && !linea.trim().isEmpty()) {
                        tratamiento.append(linea).append("\n");
                    }
                    tratamiento.append("\n");

                    if (tratamiento.toString().toLowerCase().contains("síntoma principal: " + sintomaPrincipal.toLowerCase())) {
                        encontrado = true;
                    } else {
                        bw.write(tratamiento.toString());
                    }
                } else {
                    bw.write(linea + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al eliminar el tratamiento.";
        }

        try {
            Files.delete(Paths.get("Archivos\\tratamientos.txt"));
            Files.move(Paths.get(archivoTemp), Paths.get("Archivos\\tratamientos.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al actualizar el archivo de tratamientos.";
        }

        return encontrado ? "Tratamiento eliminado exitosamente." : "No se encontró el tratamiento para la raza y síntoma principal proporcionados.";
    }



}
