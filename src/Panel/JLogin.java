package Panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class JLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private JLabel lblMensajeError;
	private static String usuarioLogueado;

	public JLogin() {

			setBackground(new Color(192, 192, 192));
			setLayout(new BorderLayout(0, 0));

			JPanel Izquierda = new JPanel();
			Izquierda.setBackground(new Color(255, 176, 216));
			add(Izquierda, BorderLayout.WEST);
			Izquierda.setLayout(new GridLayout(0, 1, 0, 0));

			JPanel panel = new JPanel();
			Izquierda.add(panel);

			JPanel Superior = new JPanel();
			Superior.setBorder(new LineBorder(new Color(0, 0, 0)));
			add(Superior, BorderLayout.NORTH);

			JLabel lblTitulo = new JLabel("Veterinaria");
			lblTitulo.setFont(new Font("Segoe Print", Font.PLAIN, 15));
			Superior.add(lblTitulo);

			JPanel Derecha = new JPanel();
			add(Derecha, BorderLayout.EAST);
			Derecha.setLayout(new GridLayout(0, 1, 0, 0));
			
			JPanel panel_1 = new JPanel();
			Derecha.add(panel_1);

			JPanel Inferior = new JPanel();
			add(Inferior, BorderLayout.SOUTH);

			JPanel Centro = new JPanel();
			Centro.setBorder(null);
			Centro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			add(Centro, BorderLayout.CENTER);

			JPanel Login_1 = new JPanel();
			Centro.add(Login_1);
			Login_1.setLayout(new GridLayout(0, 1, 0, 15));

			JPanel UsuarioP_1 = new JPanel();
			UsuarioP_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			UsuarioP_1.setBackground(new Color(255, 204, 204));
			Login_1.add(UsuarioP_1);
			UsuarioP_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

			JLabel lblTextUsuario_1 = new JLabel("Usuario:");
			lblTextUsuario_1.setFont(new Font("Segoe Print", Font.PLAIN, 15));
			UsuarioP_1.add(lblTextUsuario_1);

			textField_1 = new JTextField();
			textField_1.setPreferredSize(new Dimension(150, 25));
			UsuarioP_1.add(textField_1);
			textField_1.setColumns(15);

			JPanel ContraseñaP_1 = new JPanel();
			ContraseñaP_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			ContraseñaP_1.setBackground(new Color(255, 204, 204));
			Login_1.add(ContraseñaP_1);
			ContraseñaP_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

			JLabel lblTextContraseña_1 = new JLabel("Contraseña:");
			lblTextContraseña_1.setFont(new Font("Segoe Print", Font.PLAIN, 15));
			ContraseñaP_1.add(lblTextContraseña_1);

			passwordField_1 = new JPasswordField();
			passwordField_1.setPreferredSize(new Dimension(150, 25));
			ContraseñaP_1.add(passwordField_1);

			JPanel IngresarP_1 = new JPanel();
			IngresarP_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			IngresarP_1.setBackground(new Color(255, 204, 204));
			Login_1.add(IngresarP_1);
			IngresarP_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JButton btnTextIngresar_1 = new JButton("Ingresar");
			btnTextIngresar_1.setFont(new Font("Segoe Print", Font.PLAIN, 15));
			btnTextIngresar_1.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        String usuarioIngresado = textField_1.getText();
			        String contrasenaIngresada = new String(passwordField_1.getPassword());

			        boolean usuarioValido = false;
			        try {
			            FileReader fileReader = new FileReader("Archivos\\usuarios.txt");
			            BufferedReader bufferedReader = new BufferedReader(fileReader);
			            String line;

			            while ((line = bufferedReader.readLine()) != null) {
			                String[] parts = line.split(",");
			                if (parts.length >= 2) {
			                    String usuarioGuardado = parts[0];
			                    String contraseñaGuardada = parts[1];
			                    if (usuarioGuardado.equals(usuarioIngresado)
			                            && contraseñaGuardada.equals(contrasenaIngresada)) {
			                        usuarioValido = true;
			                        usuarioLogueado = usuarioIngresado; // Almacenar el usuario que ha iniciado sesión
			                        break;
			                    }
			                }
			            }

			            bufferedReader.close();
			        } catch (IOException ex) {
			            ex.printStackTrace();
			        }

			        if (usuarioValido) {
			            setVisible(false);
			            JDoctoresMenu ingresoDocPanel = new JDoctoresMenu(usuarioIngresado);
			            getParent().add(ingresoDocPanel);
			            ingresoDocPanel.setVisible(true);
			        } else {
			            lblMensajeError.setVisible(true);
						
			        }
			    }
			});
			IngresarP_1.add(btnTextIngresar_1);

			JButton btnRegistrarse = new JButton("Registrarse");
			btnRegistrarse.setFont(new Font("Segoe Print", Font.PLAIN, 15));
			btnRegistrarse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					JRegistrarse inicioPanel = new JRegistrarse();
					getParent().add(inicioPanel);
					inicioPanel.setVisible(true);
					
				}
			});
			IngresarP_1.add(btnRegistrarse);
			lblMensajeError = new JLabel("No se ha registrado ese usuario y contraseña, por favor regístrese.");
			lblMensajeError.setFont(new Font("Segoe Print", Font.PLAIN, 15));
			lblMensajeError.setForeground(Color.RED);
			lblMensajeError.setVisible(false);
			Login_1.add(lblMensajeError);
		
	}
	 // Método para obtener el usuario que ha iniciado sesión
   public static String getUsuarioLogueado() {
        return usuarioLogueado;
    }

}