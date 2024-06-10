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


        String resultado = mostrarTratamientos.agregarTratamiento(raza, sintomaPrincipal, sintomasSecundarios, tratamiento);
        

        System.out.println(resultado);
        JOptionPane.showMessageDialog(agregarTratamientos, resultado);
    }
}