package Logica.Paneles.metodosTratamiento;

import javax.swing.JOptionPane;

import Logica.Paneles.AgregarMedicina; // Cambio aquí

public class MetodoAgregarMedicina {
    private AgregarMedicina AgregarMedicina; // Cambio aquí

    public MetodoAgregarMedicina(AgregarMedicina AgregarMedicina) { // Cambio aquí
        this.AgregarMedicina = AgregarMedicina; // Cambio aquí
    }

    public void agregarMedicina() {
        String nombre = AgregarMedicina.getNombreMedicina(); // Cambio aquí
        String descripcion = AgregarMedicina.getDescripcionMedicina(); // Cambio aquí

        // Llamar al método para agregar la medicina en el archivo
        String resultado = mostrarMedicina.agregarMedicina(nombre, descripcion);
        
        // Mostrar resultado (puede ser en la consola o en un cuadro de diálogo)
        System.out.println(resultado);
        JOptionPane.showMessageDialog(AgregarMedicina, resultado); // Cambio aquí
    }
}
