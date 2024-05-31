package Panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class JRegistrarse extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel messageError;
	private String usuario;
	private String contraseña;
	String n;

	public JRegistrarse() {
		setLayout(new BorderLayout(0, 0));

		JPanel Superior = new JPanel();
		add(Superior, BorderLayout.NORTH);

		JLabel lbl_Registrarse = new JLabel("Registrarse !!");
		Superior.add(lbl_Registrarse);

		JPanel Inferior = new JPanel();
		add(Inferior, BorderLayout.SOUTH);

		JButton btnGuardar = new JButton("Guardar");

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuarioIngresado = textField.getText();
				String contrasena = textField_1.getText();
				String confirmacionContrasena = textField_2.getText();

				if (!usuarioIngresado.isEmpty() && !contrasena.isEmpty() && !confirmacionContrasena.isEmpty()) {
					if (contrasena.equals(confirmacionContrasena)) {
						usuario = usuarioIngresado;
						contraseña = contrasena;
						try {
							PrintWriter writer = new PrintWriter(
									new BufferedWriter(new FileWriter("Archivos\\usuarios.txt", true)));
							writer.println(usuario + "," + contraseña);
							writer.close();
							messageError.setText("Usuario guardado correctamente.");
							messageError.setFont(new Font("Segoe Print", Font.PLAIN, 15));
							messageError.setForeground(Color.GREEN);
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					} else {
						messageError.setText("Las contraseñas no coinciden.");
						messageError.setFont(new Font("Segoe Print", Font.PLAIN, 15));
						messageError.setForeground(Color.RED);
					}
				} else {
					messageError.setText("Por favor, complete todos los campos.");
					messageError.setFont(new Font("Segoe Print", Font.PLAIN, 15));
					messageError.setForeground(Color.RED);
				}
			}
		});

		Inferior.add(btnGuardar);

		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JLogin inicioPanel = new JLogin();
				getParent().add(inicioPanel);
				inicioPanel.setVisible(true);
			}
		});
		Inferior.add(btnRegresar);

		JPanel Izquierdo = new JPanel();
		add(Izquierdo, BorderLayout.WEST);

		JPanel Derecho = new JPanel();
		add(Derecho, BorderLayout.EAST);

		JPanel Centro = new JPanel();
		Centro.setBackground(new Color(255, 255, 255));
		add(Centro, BorderLayout.CENTER);
		Centro.setLayout(new BoxLayout(Centro, BoxLayout.Y_AXIS));

		JLabel lblNewLabel_1 = new JLabel("Usuario:      ");
		Centro.add(lblNewLabel_1);

		JPanel panel_Usuario = new JPanel();
		panel_Usuario.setBackground(new Color(255, 204, 230));
		panel_Usuario.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Usuario.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		Centro.add(panel_Usuario);

		textField = new JTextField();
		textField.setPreferredSize(new Dimension(200, 25));
		panel_Usuario.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Contraseña:  ");
		lblNewLabel_2.setAlignmentX(Component.LEFT_ALIGNMENT);
		Centro.add(lblNewLabel_2);

		JPanel panel_Contraseña = new JPanel();
		panel_Contraseña.setBackground(new Color(255, 204, 230));
		panel_Contraseña.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Contraseña.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		Centro.add(panel_Contraseña);

		textField_1 = new JTextField();
		textField_1.setPreferredSize(new Dimension(200, 25));
		panel_Contraseña.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Confirmar contraseña:");
		Centro.add(lblNewLabel_3);

		JPanel panel_ConfirmarContraseña = new JPanel();
		panel_ConfirmarContraseña.setBackground(new Color(255, 204, 230));
		panel_ConfirmarContraseña.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_ConfirmarContraseña.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		Centro.add(panel_ConfirmarContraseña);

		textField_2 = new JTextField();
		textField_2.setPreferredSize(new Dimension(200, 25));
		panel_ConfirmarContraseña.add(textField_2);
		textField_2.setColumns(10);

		messageError = new JLabel("");
		Centro.add(messageError);

		JPanel panel_Errores = new JPanel();
		Centro.add(panel_Errores);

	}
}
