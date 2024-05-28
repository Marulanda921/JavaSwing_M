package Panel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Principal.Inicio;

public class JCitas extends JPanel {

	private static final long serialVersionUID = 1L;

	public JCitas() {

		 setLayout(new BorderLayout(0, 0));
	        
	        JPanel Derecha = new JPanel();
	        add(Derecha, BorderLayout.EAST);
	        Derecha.setLayout(new GridLayout(0, 1, 0, 0));
	        
	        JButton btnCitasProgramadas = new JButton("Citas Programadas");
	        Derecha.add(btnCitasProgramadas);
	        
	        JLabel lblEspacio_2 = new JLabel("");
	        Derecha.add(lblEspacio_2);
	        
	        JLabel lblEspacio_3 = new JLabel("");
	        Derecha.add(lblEspacio_3);
	        
	        JButton btnMenuPrincipal = new JButton("Menu Principal");
	        Derecha.add(btnMenuPrincipal);
	        
	        btnMenuPrincipal.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JCitas.this);
	                if (frame != null) {
	                    frame.mostrarJIngresoDoc();
	                }
	            }
	        });
	        
	        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
	        Derecha.add(btnCerrarSesion);
	        
	        btnCerrarSesion.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JCitas.this);
	                if (frame != null) {
	                    frame.mostrarPanelInicioSesion();
	                }
	            }
	        });

	        JPanel Superior = new JPanel();
	        add(Superior, BorderLayout.NORTH);
	        
	        JLabel TituloPrincipal = new JLabel("Citas Programadas");
	        TituloPrincipal.setFont(new Font("Segoe Print", Font.PLAIN, 15));
	        Superior.add(TituloPrincipal);
	        
	        JPanel Izquierda = new JPanel();
	        add(Izquierda, BorderLayout.WEST);
	        
	        JPanel Inferior = new JPanel();
	        add(Inferior, BorderLayout.SOUTH);
	        
	        JPanel Centro = new JPanel();
	        add(Centro, BorderLayout.CENTER);

		
	}

}
