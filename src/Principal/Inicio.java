package Principal;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Panel.JDoctoresMenu;
import Panel.JLogin;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		mostrarPanelInicioSesion();
	}

	public void mostrarPanelInicioSesion() {
		Container contentPane = getContentPane();
		contentPane.removeAll();
		JLogin inicioSesionPanel = new JLogin();
		contentPane.add(inicioSesionPanel, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
	}

	public void mostrarJIngresoDoc() {
		Container contentPane = getContentPane();
		contentPane.removeAll();
		JDoctoresMenu ingresoDocPanel = new JDoctoresMenu("Nombre de Usuario");
		contentPane.add(ingresoDocPanel, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
	}

}
