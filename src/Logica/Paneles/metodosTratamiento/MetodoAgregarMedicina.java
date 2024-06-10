package Logica.Paneles.metodosTratamiento;

import javax.swing.JOptionPane;

import Logica.Paneles.AgregarMedicina; // Cambio aquí

public class MetodoAgregarMedicina {
    private AgregarMedicina AgregarMedicina;

    public MetodoAgregarMedicina(AgregarMedicina AgregarMedicina) { 
        this.AgregarMedicina = AgregarMedicina; 
    }

    public void agregarMedicina() {
        String nombre = AgregarMedicina.getNombreMedicina(); 
        String descripcion = AgregarMedicina.getDescripcionMedicina(); 
        String resultado = mostrarMedicina.agregarMedicina(nombre, descripcion);
        System.out.println(resultado);
        JOptionPane.showMessageDialog(AgregarMedicina, resultado);
    }
}
