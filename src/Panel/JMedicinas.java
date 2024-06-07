package Panel;

import javax.swing.*;

import Logica.Paneles.AgregarMedicina;
import Logica.Paneles.PanelIngresoMedicina;
import Logica.Paneles.PanelListarMedicina;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Principal.Inicio;

public class JMedicinas extends JPanel {

	 private static final long serialVersionUID = 1L;

	    private JPanel panelContenedor;
	    private PanelIngresoMedicina panelIngresoMedicina;
	    private PanelListarMedicina panelListarMedicina;
	    private AgregarMedicina agregarMedicina;

	    public JMedicinas() {
	        setLayout(new BorderLayout());

	        panelContenedor = new JPanel(new CardLayout());

	        // Crear instancias de los paneles necesarios
	        panelIngresoMedicina = new PanelIngresoMedicina();
	        panelListarMedicina = new PanelListarMedicina();
	        agregarMedicina = new AgregarMedicina();

	        // Agregar los paneles al contenedor
	        panelContenedor.add(panelIngresoMedicina, "INGRESO");
	        panelContenedor.add(panelListarMedicina, "LISTAR");
	        panelContenedor.add(agregarMedicina, "AGREGAR");

	        // Agregar el contenedor al panel principal
	        add(panelContenedor, BorderLayout.CENTER);

	        // Botones y acciones
	        JPanel panelDerecha = new JPanel();
	        add(panelDerecha, BorderLayout.EAST);
	        panelDerecha.setLayout(new GridLayout(0, 1, 0, 0));

	        JButton btnMenuPrincipal = new JButton("Menu Principal");
	        panelDerecha.add(btnMenuPrincipal);
	        btnMenuPrincipal.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JMedicinas.this);
	                if (frame != null) {
	                    frame.mostrarJIngresoDoc();
	                }
	            }
	        });

	        JButton btnBuscarMedicina = new JButton("Buscar Medicina");
	        panelDerecha.add(btnBuscarMedicina);
	        btnBuscarMedicina.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                mostrarPanelIngresoMedicina();
	            }
	        });

	        JButton btnListarMedicinas = new JButton("Listar Medicinas");
	        panelDerecha.add(btnListarMedicinas);
	        btnListarMedicinas.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                mostrarPanelListarMedicinas();
	            }
	        });

	        JButton btnAgregarMedicina = new JButton("Agregar Medicina");
	        panelDerecha.add(btnAgregarMedicina);
	        btnAgregarMedicina.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                mostrarPanelAgregarMedicinas();
	            }
	        });

	        JButton btnEliminarMedicinas = new JButton("Eliminar Medicinas");
	        btnEliminarMedicinas.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                mostrarPanelEliminarMedicinas();
	            }
	        });
	        panelDerecha.add(btnEliminarMedicinas);

	        JLabel lblEspacio_1 = new JLabel("");
	        panelDerecha.add(lblEspacio_1);

	        JLabel lblEspacio_2 = new JLabel("");
	        panelDerecha.add(lblEspacio_2);

	        JLabel lblEspacio_3 = new JLabel("");
	        panelDerecha.add(lblEspacio_3);

	        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
	        panelDerecha.add(btnCerrarSesion);
	        btnCerrarSesion.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JMedicinas.this);
	                if (frame != null) {
	                    frame.mostrarPanelInicioSesion();
	                }
	            }
	        });
	    }

	    private void mostrarPanelIngresoMedicina() {
	        CardLayout cardLayout = (CardLayout) panelContenedor.getLayout();
	        cardLayout.show(panelContenedor, "INGRESO");
	    }

	    private void mostrarPanelListarMedicinas() {
	        panelListarMedicina.actualizarListadoMedicinas(); // Actualizar listado de medicinas
	        CardLayout cardLayout = (CardLayout) panelContenedor.getLayout();
	        cardLayout.show(panelContenedor, "LISTAR");
	    }

	    private void mostrarPanelAgregarMedicinas() {
	        CardLayout cardLayout = (CardLayout) panelContenedor.getLayout();
	        cardLayout.show(panelContenedor, "AGREGAR");
	    }

	    private void mostrarPanelEliminarMedicinas() {
	        CardLayout cardLayout = (CardLayout) panelContenedor.getLayout();
	        cardLayout.show(panelContenedor, "ELIMINAR");
	    }
}


