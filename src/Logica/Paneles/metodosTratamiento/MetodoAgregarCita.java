package Logica.Paneles.metodosTratamiento;

import javax.swing.JOptionPane;
import Logica.Paneles.AgregarCita;

public class MetodoAgregarCita {
    private AgregarCita agregarCita;

    public MetodoAgregarCita(AgregarCita agregarCita) {
        this.agregarCita = agregarCita;
    }

    public void agregarCita() {
        String nombre = agregarCita.getNombreCita();
        String apellido = agregarCita.getApellidoCita();
        String fecha = agregarCita.getFechaCita();
        String hora = agregarCita.getHoraCita();
        String descripcion = agregarCita.getDescripcionCita();
        String resultado = mostrarCitas.agregarCita(nombre, apellido, fecha, hora, descripcion);
        System.out.println(resultado);
        JOptionPane.showMessageDialog(agregarCita, resultado);
    }
}
