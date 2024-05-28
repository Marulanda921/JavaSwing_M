//package Panel;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollBar;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.SwingUtilities;
//import javax.swing.border.LineBorder;
//
//import Logica.LIngresarPacientes;
//import Principal.Inicio;
//import javax.swing.SwingConstants;
//
//public class JIngresarPacientes extends JPanel {
//	
//	private static final long serialVersionUID = 1L;
//	private JTextField textField;
//	private JTextField textField_1;
//	private JTextField textField_2;
//	private JTextField textField_3;
//	private JTextField textField_4;
//	private JTextField textField_5;
//	private JTextField textField_6;
//	private JTextField textField_7;
//	private JTextField textField_9;
//	private JComboBox<String> comboBoxGenero;
//	
//	LIngresarPacientes metodo = new LIngresarPacientes();
//	
//	
//	
//
//	public JIngresarPacientes(JDoctoresMenu ingresoDocPanel) {
//		setLayout(new BorderLayout());
//
//		JButton btnVolver = new JButton("Cerrar Sesión");
//		btnVolver.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JIngresarPacientes.this);
//				if (frame != null) {
//					frame.mostrarPanelInicioSesion();
//				}
//			}
//		});
//
//		JButton btnIrAMenu = new JButton("Menu Principal");
//		btnIrAMenu.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JIngresarPacientes.this);
//				if (frame != null) {
//					frame.mostrarJIngresoDoc();
//				}
//			}
//		});
//
//		JPanel Derecha = new JPanel();
//		Derecha.setLayout(new GridLayout(0, 1, 0, 0));
//
//		JLabel lblEspacio_1 = new JLabel("");
//		Derecha.add(lblEspacio_1);
//
//		JLabel lblEspacio_2 = new JLabel("");
//		Derecha.add(lblEspacio_2);
//
//		JLabel lblEspacio_3 = new JLabel("");
//		Derecha.add(lblEspacio_3);
//
//		JLabel lblEspacio_4 = new JLabel("");
//		Derecha.add(lblEspacio_4);
//		Derecha.add(btnIrAMenu);
//		Derecha.add(btnVolver);
//		add(Derecha, BorderLayout.EAST);
//
//		JPanel Arriba = new JPanel();
//		Arriba.setBorder(new LineBorder(new Color(0, 0, 0)));
//		Arriba.setBackground(new Color(255, 182, 193));
//		add(Arriba, BorderLayout.NORTH);
//
//		JLabel lblNewLabel = new JLabel("Ingrese sus Pacientes aqui <3");
//		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 15));
//		Arriba.add(lblNewLabel);
//
//		JPanel Inferior = new JPanel();
//		add(Inferior, BorderLayout.SOUTH);
//		JPanel Formulario = new JPanel();
//		Formulario.setLayout(new BoxLayout(Formulario, BoxLayout.Y_AXIS));
//		JPanel Centro = new JPanel(new GridLayout(1, 2));
//		Centro.add(Formulario);
//
//		JPanel NombreDueño = new JPanel();
//		Formulario.add(NombreDueño);
//		NombreDueño.setLayout(new GridLayout(0, 1, 0, 0));
//
//		JLabel lblNombre_Dueño = new JLabel("Nombre Dueño: ");
//		lblNombre_Dueño.setHorizontalAlignment(SwingConstants.CENTER);
//		NombreDueño.add(lblNombre_Dueño);
//
//		textField_1 = new JTextField();
//		NombreDueño.add(textField_1);
//		textField_1.setColumns(10);
//
//		JPanel Direccion = new JPanel();
//		Formulario.add(Direccion);
//
//		JLabel lblNewLabel_6 = new JLabel("Dirección: ");
//		Direccion.add(lblNewLabel_6);
//
//		textField_5 = new JTextField();
//		Direccion.add(textField_5);
//		textField_5.setColumns(10);
//
//		JPanel Telefono = new JPanel();
//		Formulario.add(Telefono);
//
//		JLabel lblNewLabel_3 = new JLabel("Telefeno: ");
//		Telefono.add(lblNewLabel_3);
//
//		textField_2 = new JTextField();
//		Telefono.add(textField_2);
//		textField_2.setColumns(10);
//
//		JPanel Correo = new JPanel();
//		Formulario.add(Correo);
//
//		JLabel lblNewLabel_4 = new JLabel("Correo Electronico: ");
//		Correo.add(lblNewLabel_4);
//
//		textField_3 = new JTextField();
//		Correo.add(textField_3);
//		textField_3.setColumns(10);
//
//		JPanel NombreMascota = new JPanel();
//		Formulario.add(NombreMascota);
//
//		JLabel lblNombre_Mascota = new JLabel("Nombre Mascota: ");
//		NombreMascota.add(lblNombre_Mascota);
//
//		textField = new JTextField();
//		NombreMascota.add(textField);
//		textField.setColumns(10);
//
//		JPanel Especie = new JPanel();
//		Formulario.add(Especie);
//
//		JLabel lblNewLabel_7 = new JLabel("Especie");
//		Especie.add(lblNewLabel_7);
//
//		textField_6 = new JTextField();
//		Especie.add(textField_6);
//		textField_6.setColumns(10);
//
//		JPanel Raza = new JPanel();
//		Formulario.add(Raza);
//
//		JLabel lblNewLabel_5 = new JLabel("Raza: ");
//		Raza.add(lblNewLabel_5);
//
//		textField_4 = new JTextField();
//		Raza.add(textField_4);
//		textField_4.setColumns(10);
//
//		JPanel Edad = new JPanel();
//		Formulario.add(Edad);
//
//		JLabel lblNewLabel_8 = new JLabel("Edad: ");
//		Edad.add(lblNewLabel_8);
//
//		textField_7 = new JTextField();
//		Edad.add(textField_7);
//		textField_7.setColumns(10);
//
//		JPanel Genero = new JPanel();
//		Formulario.add(Genero);
//
//		JLabel lblNewLabel_9 = new JLabel("Género: ");
//		Genero.add(lblNewLabel_9);
//
//		comboBoxGenero = new JComboBox<String>();
//		comboBoxGenero.addItem("Hembra");
//		comboBoxGenero.addItem("Macho");
//		Genero.add(comboBoxGenero);
//
//		JPanel Antecedentes = new JPanel();
//		Formulario.add(Antecedentes);
//
//		JLabel lblNewLabel_10 = new JLabel("Antecedentes Medicos Relevantes:");
//		Antecedentes.add(lblNewLabel_10);
//
//		textField_9 = new JTextField();
//		Antecedentes.add(textField_9);
//		textField_9.setColumns(10);
//
//		JScrollPane scrollPane = new JScrollPane(Centro);
//		add(scrollPane, BorderLayout.CENTER);
//
//		JScrollBar verticalScrollBar = new JScrollBar(JScrollBar.VERTICAL);
//		scrollPane.setVerticalScrollBar(verticalScrollBar);
//
//		JButton btnGuardar = new JButton("Guardar");
//		btnGuardar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				metodo.guardarDatos();
//			}
//		});
//		Inferior.add(btnGuardar);
//
//		JButton btnVerHistoriales = new JButton("Ver Historiales");
//		btnVerHistoriales.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				verHistoriales();
//			}
//		});
//		Inferior.add(btnVerHistoriales);
//	}
//
////private void guardarDatos() {
////		try {
////			FileWriter fw = new FileWriter("datos_pacientes.txt", true);
////			BufferedWriter bw = new BufferedWriter(fw);
////
////			String nombreDueño = textField_1.getText();
////			String direccion = textField_5.getText();
////			String telefono = textField_2.getText();
////			String correo = textField_3.getText();
////			String nombreMascota = textField.getText();
////			String especie = textField_6.getText();
////			String raza = textField_4.getText();
////			String edad = textField_7.getText();
////			String genero = (String) comboBoxGenero.getSelectedItem();
////			String antecedentes = textField_9.getText();
////
////			String datos = String.format(
////					"Nombre Dueño: %s, Dirección: %s, Teléfono: %s, Correo: %s, Nombre Mascota: %s, Especie: %s, Raza: %s, Edad: %s, Género: %s, Antecedentes: %s",
////					nombreDueño, direccion, telefono, correo, nombreMascota, especie, raza, edad, genero, antecedentes);
////
////			bw.write(datos);
////			bw.newLine();
////
////			bw.close();
////			fw.close();
////			//System.out.println("Datos guardados exitosamente en datos_pacientes.txt");
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////	}
//
//	private void verHistoriales() {
//		try {
//			FileReader fr = new FileReader("datos_pacientes.txt");
//			BufferedReader br = new BufferedReader(fr);
//			StringBuilder historiales = new StringBuilder();
//			String linea;
//
//			while ((linea = br.readLine()) != null) {
//				historiales.append(linea).append("\n");
//			}
//
//			br.close();
//			fr.close();
//			JTextArea textArea = new JTextArea(historiales.toString());
//			textArea.setEditable(false);
//			JScrollPane scrollPane = new JScrollPane(textArea);
//			scrollPane.setPreferredSize(new java.awt.Dimension(600, 400));
//			JOptionPane.showMessageDialog(this, scrollPane, "Historiales de Pacientes", JOptionPane.PLAIN_MESSAGE);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//}


package Panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import Logica.LIngresarPacientes;
import Principal.Inicio;
import javax.swing.SwingConstants;

public class JIngresarPacientes extends JPanel {
    
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_9;
    private JComboBox<String> comboBoxGenero;
    
    private LIngresarPacientes metodo;

    public JIngresarPacientes(JDoctoresMenu ingresoDocPanel) {
        setLayout(new BorderLayout());

        // Initialize components
        textField = new JTextField();
        textField_1 = new JTextField();
        textField_2 = new JTextField();
        textField_3 = new JTextField();
        textField_4 = new JTextField();
        textField_5 = new JTextField();
        textField_6 = new JTextField();
        textField_7 = new JTextField();
        textField_9 = new JTextField();
        comboBoxGenero = new JComboBox<>();
        comboBoxGenero.addItem("Hembra");
        comboBoxGenero.addItem("Macho");

        // Create LIngresarPacientes instance
        metodo = new LIngresarPacientes(textField, textField_1, textField_2, textField_3,
                                        textField_4, textField_5, textField_6, textField_7,
                                        textField_9, comboBoxGenero);
        
        

        JButton btnVolver = new JButton("Cerrar Sesión");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JIngresarPacientes.this);
                if (frame != null) {
                    frame.mostrarPanelInicioSesion();
                }
            }
        });

        JButton btnIrAMenu = new JButton("Menu Principal");
        btnIrAMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JIngresarPacientes.this);
                if (frame != null) {
                    frame.mostrarJIngresoDoc();
                }
            }
        });

        JPanel Derecha = new JPanel();
        Derecha.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblEspacio_1 = new JLabel("");
        Derecha.add(lblEspacio_1);

        JLabel lblEspacio_2 = new JLabel("");
        Derecha.add(lblEspacio_2);

        JLabel lblEspacio_3 = new JLabel("");
        Derecha.add(lblEspacio_3);

        JLabel lblEspacio_4 = new JLabel("");
        Derecha.add(lblEspacio_4);
        Derecha.add(btnIrAMenu);
        Derecha.add(btnVolver);
        add(Derecha, BorderLayout.EAST);

        JPanel Arriba = new JPanel();
        Arriba.setBorder(new LineBorder(new Color(0, 0, 0)));
        Arriba.setBackground(new Color(255, 182, 193));
        add(Arriba, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("Ingrese sus Pacientes aqui <3");
        lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        Arriba.add(lblNewLabel);

        JPanel Inferior = new JPanel();
        add(Inferior, BorderLayout.SOUTH);
        JPanel Formulario = new JPanel();
        Formulario.setLayout(new BoxLayout(Formulario, BoxLayout.Y_AXIS));
        JPanel Centro = new JPanel(new GridLayout(1, 2));
        Centro.add(Formulario);

        JPanel NombreDueño = new JPanel();
        Formulario.add(NombreDueño);
        NombreDueño.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblNombre_Dueño = new JLabel("Nombre Dueño: ");
        lblNombre_Dueño.setHorizontalAlignment(SwingConstants.CENTER);
        NombreDueño.add(lblNombre_Dueño);

        NombreDueño.add(textField_1);
        textField_1.setColumns(10);

        JPanel Direccion = new JPanel();
        Formulario.add(Direccion);

        JLabel lblNewLabel_6 = new JLabel("Dirección: ");
        Direccion.add(lblNewLabel_6);

        Direccion.add(textField_5);
        textField_5.setColumns(10);

        JPanel Telefono = new JPanel();
        Formulario.add(Telefono);

        JLabel lblNewLabel_3 = new JLabel("Telefeno: ");
        Telefono.add(lblNewLabel_3);

        Telefono.add(textField_2);
        textField_2.setColumns(10);

        JPanel Correo = new JPanel();
        Formulario.add(Correo);

        JLabel lblNewLabel_4 = new JLabel("Correo Electronico: ");
        Correo.add(lblNewLabel_4);

        Correo.add(textField_3);
        textField_3.setColumns(10);

        JPanel NombreMascota = new JPanel();
        Formulario.add(NombreMascota);

        JLabel lblNombre_Mascota = new JLabel("Nombre Mascota: ");
        NombreMascota.add(lblNombre_Mascota);

        NombreMascota.add(textField);
        textField.setColumns(10);

        JPanel Especie = new JPanel();
        Formulario.add(Especie);

        JLabel lblNewLabel_7 = new JLabel("Especie");
        Especie.add(lblNewLabel_7);

        Especie.add(textField_6);
        textField_6.setColumns(10);

        JPanel Raza = new JPanel();
        Formulario.add(Raza);

        JLabel lblNewLabel_5 = new JLabel("Raza: ");
        Raza.add(lblNewLabel_5);

        Raza.add(textField_4);
        textField_4.setColumns(10);

        JPanel Edad = new JPanel();
        Formulario.add(Edad);

        JLabel lblNewLabel_8 = new JLabel("Edad: ");
        Edad.add(lblNewLabel_8);

        Edad.add(textField_7);
        textField_7.setColumns(10);

        JPanel Genero = new JPanel();
        Formulario.add(Genero);

        JLabel lblNewLabel_9 = new JLabel("Género: ");
        Genero.add(lblNewLabel_9);

        Genero.add(comboBoxGenero);

        JPanel Antecedentes = new JPanel();
        Formulario.add(Antecedentes);

        JLabel lblNewLabel_10 = new JLabel("Antecedentes Medicos Relevantes:");
        Antecedentes.add(lblNewLabel_10);

        Antecedentes.add(textField_9);
        textField_9.setColumns(10);

        JScrollPane scrollPane = new JScrollPane(Centro);
        add(scrollPane, BorderLayout.CENTER);

        JScrollBar verticalScrollBar = new JScrollBar(JScrollBar.VERTICAL);
        scrollPane.setVerticalScrollBar(verticalScrollBar);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                metodo.guardarDatos();
            }
        });
        Inferior.add(btnGuardar);

        JButton btnVerHistoriales = new JButton("Ver Historiales");
        btnVerHistoriales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                metodo.verHistoriales();
            }
        });
        Inferior.add(btnVerHistoriales);
    }

}

