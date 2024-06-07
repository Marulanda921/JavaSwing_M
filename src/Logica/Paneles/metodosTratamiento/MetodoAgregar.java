package Logica.Paneles.metodosTratamiento;

import javax.swing.JOptionPane;

import Logica.Paneles.AgregarTratamientos;

public class MetodoAgregar {
    private AgregarTratamientos agregarTratamientos;

    public MetodoAgregar(AgregarTratamientos agregarTratamientos) {
        this.agregarTratamientos = agregarTratamientos;
    }

    public void agregarTratamiento() {
        String raza = agregarTratamientos.getRaza();
        String sintomaPrincipal = agregarTratamientos.getSintomaPrincipal();
        String sintomasSecundarios = agregarTratamientos.getSintomasSecundarios();
        String tratamiento = agregarTratamientos.getTratamiento();

        // Llamar al método para agregar el tratamiento en el archivo
        String resultado = mostrarTratamientos.agregarTratamiento(raza, sintomaPrincipal, sintomasSecundarios, tratamiento);
        
        // Mostrar resultado (puede ser en la consola o en un cuadro de diálogo)
        System.out.println(resultado);
        JOptionPane.showMessageDialog(agregarTratamientos, resultado);
    }
}