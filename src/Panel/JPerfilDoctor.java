////// JPerfilDoctor.java
////package Panel;
////
////import java.awt.BorderLayout;
////import java.awt.Font;
////import java.awt.GridLayout;
////import java.awt.event.ActionEvent;
////import java.awt.event.ActionListener;
////import javax.swing.JButton;
////import javax.swing.JLabel;
////import javax.swing.JPanel;
////import javax.swing.JScrollPane;
////import javax.swing.JTextArea;
////import javax.swing.JTextField;
////import LogicaPerfilDoc.MetodosDoctores;
////
////public class JPerfilDoctor extends JPanel {
////
////    private static final long serialVersionUID = 1L;
////    private MetodosDoctores metodosDoctores;
////    private JTextField textFieldNombreCompleto;
////    private JTextField textFieldNumLicencia;
////    private JTextField textFieldEspecialidad;
////    private JTextField textFieldNumTelefono;
////    private JTextField textFieldCorreoElectronico;
////    private JTextField textFieldDireccionConsultorio;
////    private JTextField textFieldAniosExperiencia;
////    private JTextField textFieldEducacion;
////    private JTextField textFieldUniversidad;
////    private JTextField textFieldTitulo;
////    private JTextField textFieldAnioGraduacion;
////    private JTextArea textAreaCertificaciones;
////    private JTextArea textAreaIdiomas;
////    private JTextField textFieldHorarioAtencion;
////
////    public JPerfilDoctor() {
////    	 metodosDoctores = new MetodosDoctores(); // Ensure 
////        setLayout(new BorderLayout());
////
////        JPanel topPanel = new JPanel();
////        JPanel formPanel = new JPanel(new GridLayout(0, 2, 5, 5));
////        JPanel buttonPanel = new JPanel();
////
////        formPanel.add(new JLabel("Nombre Completo:"));
////        textFieldNombreCompleto = new JTextField();
////        formPanel.add(textFieldNombreCompleto);
////        formPanel.add(new JLabel("Número de Licencia Médica:"));
////        textFieldNumLicencia = new JTextField();
////        formPanel.add(textFieldNumLicencia);
////        formPanel.add(new JLabel("Especialidad:"));
////        textFieldEspecialidad = new JTextField();
////        formPanel.add(textFieldEspecialidad);
////        formPanel.add(new JLabel("Número de Teléfono:"));
////        textFieldNumTelefono = new JTextField();
////        formPanel.add(textFieldNumTelefono);
////        formPanel.add(new JLabel("Correo Electrónico:"));
////        textFieldCorreoElectronico = new JTextField();
////        formPanel.add(textFieldCorreoElectronico);
////        formPanel.add(new JLabel("Dirección de Consultorio:"));
////        textFieldDireccionConsultorio = new JTextField();
////        formPanel.add(textFieldDireccionConsultorio);
////        formPanel.add(new JLabel("Años de Experiencia:"));
////        textFieldAniosExperiencia = new JTextField();
////        formPanel.add(textFieldAniosExperiencia);
////        formPanel.add(new JLabel("Educación:"));
////        textFieldEducacion = new JTextField();
////        formPanel.add(textFieldEducacion);
////        formPanel.add(new JLabel("Universidad/Institución:"));
////        textFieldUniversidad = new JTextField();
////        formPanel.add(textFieldUniversidad);
////        formPanel.add(new JLabel("Título Obtenido:"));
////        textFieldTitulo = new JTextField();
////        formPanel.add(textFieldTitulo);
////        formPanel.add(new JLabel("Año de Graduación:"));
////        textFieldAnioGraduacion = new JTextField();
////        formPanel.add(textFieldAnioGraduacion);
////        formPanel.add(new JLabel("Certificaciones:"));
////        textAreaCertificaciones = new JTextArea();
////        formPanel.add(new JScrollPane(textAreaCertificaciones));
////        formPanel.add(new JLabel("Idiomas Hablados:"));
////        textAreaIdiomas = new JTextArea();
////        formPanel.add(new JScrollPane(textAreaIdiomas));
////        formPanel.add(new JLabel("Horario de Atención:"));
////        textFieldHorarioAtencion = new JTextField();
////        formPanel.add(textFieldHorarioAtencion);
////
////        JScrollPane scrollPane = new JScrollPane(formPanel);
////
////        JLabel titleLabel = new JLabel("Perfil Doctor");
////        titleLabel.setFont(new Font("Segoe Print", Font.PLAIN, 15));
////        topPanel.add(titleLabel);
////
////        JButton registrarButton = new JButton("Registrar Doctor");
////        registrarButton.addActionListener(new ActionListener() {
////            public void actionPerformed(ActionEvent e) {
////                metodosDoctores.registrarDoctor();
////            }
////        });
////        buttonPanel.add(registrarButton);
////        
////        JButton mostrarButton = new JButton("Mostrar Doctor");
////        mostrarButton.addActionListener(new ActionListener() {
////            public void actionPerformed(ActionEvent e) {
////                metodosDoctores.mostrarRegistro(TOOL_TIP_TEXT_KEY);
////            }
////        });
////        buttonPanel.add(mostrarButton);
////
////        add(topPanel, BorderLayout.NORTH);
////        add(scrollPane, BorderLayout.CENTER);
////        add(buttonPanel, BorderLayout.SOUTH);
////    }
////}
//
//
//package Panel;
//
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import java.awt.BorderLayout;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import LogicaPerfilDoc.MetodosDoctores;
//
//public class JPerfilDoctor extends JPanel {
//
//    private static final long serialVersionUID = 1L;
//    private MetodosDoctores metodosDoctores;
//    private JTextField textFieldNombreCompleto;
//    private JTextField textFieldNumLicencia;
//    private JTextField textFieldEspecialidad;
//    private JTextField textFieldNumTelefono;
//    private JTextField textFieldCorreoElectronico;
//    private JTextField textFieldDireccionConsultorio;
//    private JTextField textFieldAniosExperiencia;
//    private JTextField textFieldEducacion;
//    private JTextField textFieldUniversidad;
//    private JTextField textFieldTitulo;
//    private JTextField textFieldAnioGraduacion;
//    private JTextArea textAreaCertificaciones;
//    private JTextArea textAreaIdiomas;
//    private JTextField textFieldHorarioAtencion;
//
//    public JPerfilDoctor() {
//        metodosDoctores = new MetodosDoctores(); // Instanciar la clase MetodosDoctores
//        setLayout(new BorderLayout());
//
//        JPanel topPanel = new JPanel();
//        JPanel formPanel = new JPanel(new GridLayout(0, 2, 5, 5));
//        JPanel buttonPanel = new JPanel();
//
//        formPanel.add(new JLabel("Nombre Completo:"));
//        textFieldNombreCompleto = new JTextField();
//        formPanel.add(textFieldNombreCompleto);
//        formPanel.add(new JLabel("Número de Licencia Médica:"));
//        textFieldNumLicencia = new JTextField();
//        formPanel.add(textFieldNumLicencia);
//        formPanel.add(new JLabel("Especialidad:"));
//        textFieldEspecialidad = new JTextField();
//        formPanel.add(textFieldEspecialidad);
//        formPanel.add(new JLabel("Número de Teléfono:"));
//        textFieldNumTelefono = new JTextField();
//        formPanel.add(textFieldNumTelefono);
//        formPanel.add(new JLabel("Correo Electrónico:"));
//        textFieldCorreoElectronico = new JTextField();
//        formPanel.add(textFieldCorreoElectronico);
//        formPanel.add(new JLabel("Dirección de Consultorio:"));
//        textFieldDireccionConsultorio = new JTextField();
//        formPanel.add(textFieldDireccionConsultorio);
//        formPanel.add(new JLabel("Años de Experiencia:"));
//        textFieldAniosExperiencia = new JTextField();
//        formPanel.add(textFieldAniosExperiencia);
//        formPanel.add(new JLabel("Educación:"));
//        textFieldEducacion = new JTextField();
//        formPanel.add(textFieldEducacion);
//        formPanel.add(new JLabel("Universidad/Institución:"));
//        textFieldUniversidad = new JTextField();
//        formPanel.add(textFieldUniversidad);
//        formPanel.add(new JLabel("Título Obtenido:"));
//        textFieldTitulo = new JTextField();
//        formPanel.add(textFieldTitulo);
//        formPanel.add(new JLabel("Año de Graduación:"));
//        textFieldAnioGraduacion = new JTextField();
//        formPanel.add(textFieldAnioGraduacion);
//        formPanel.add(new JLabel("Certificaciones:"));
//        textAreaCertificaciones = new JTextArea();
//        formPanel.add(new JScrollPane(textAreaCertificaciones));
//        formPanel.add(new JLabel("Idiomas Hablados:"));
//        textAreaIdiomas = new JTextArea();
//        formPanel.add(new JScrollPane(textAreaIdiomas));
//        formPanel.add(new JLabel("Horario de Atención:"));
//        textFieldHorarioAtencion = new JTextField();
//        formPanel.add(textFieldHorarioAtencion);
//
//        JScrollPane scrollPane = new JScrollPane(formPanel);
//
//        JLabel titleLabel = new JLabel("Perfil Doctor");
//        titleLabel.setFont(new Font("Segoe Print", Font.PLAIN, 15));
//        topPanel.add(titleLabel);
//
//        JButton registrarButton = new JButton("Registrar Doctor");
//        registrarButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                registrarDoctor();
//            }
//        });
//        buttonPanel.add(registrarButton);
//
//        JButton mostrarButton = new JButton("Mostrar Doctor");
//        mostrarButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                obtenerDatosDoctor();
//            }
//        });
//        buttonPanel.add(mostrarButton);
//
//        add(topPanel, BorderLayout.NORTH);
//        add(scrollPane, BorderLayout.CENTER);
//        add(buttonPanel, BorderLayout.SOUTH);
//    }
//
//    private void registrarDoctor() {
//        // Obtener los detalles del doctor
//        String datosDoctor = obtenerDatosDoctor();
//        // Llamar al método registrarDoctor() de MetodosDoctores
//        metodosDoctores.registrarDoctor(datosDoctor);
//    }
//
//    private String obtenerDatosDoctor() {
//        StringBuilder datos = new StringBuilder();
//        datos.append("Nombre Completo: ").append(textFieldNombreCompleto.getText()).append("\n");
//        datos.append("Número de Licencia Médica: ").append(textFieldNumLicencia.getText()).append("\n");
//        datos.append("Especialidad: ").append(textFieldEspecialidad.getText()).append("\n");
//        datos.append("Número de Teléfono: ").append(textFieldNumTelefono.getText()).append("\n");
//        datos.append("Correo Electrónico: ").append(textFieldCorreoElectronico.getText()).append("\n");
//        datos.append("Dirección de Consultorio: ").append(textFieldDireccionConsultorio.getText()).append("\n");
//        datos.append("Años de Experiencia: ").append(textFieldAniosExperiencia.getText()).append("\n");
//        datos.append("Educación: ").append(textFieldEducacion.getText()).append("\n");
//        datos.append("Universidad/Institución: ").append(textFieldUniversidad.getText()).append("\n");
//        datos.append("Título Obtenido: ").append(textFieldTitulo.getText()).append("\n");
//        datos.append("Año de Graduación: ").append(textFieldAnioGraduacion.getText()).append("\n");
//        datos.append("Certificaciones: ").append(textAreaCertificaciones.getText()).append("\n");
//        datos.append("Idiomas Hablados: ").append(textAreaIdiomas.getText()).append("\n");
//        datos.append("Horario de Atención: ").append(textFieldHorarioAtencion.getText()).append("\n");
//        metodosDoctores.mostrarRegistro(TOOL_TIP_TEXT_KEY);
//        return datos.toString();
//    }
//}

//package Panel;
//
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import java.awt.BorderLayout;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import LogicaPerfilDoc.MetodosDoctores;
//
//public class JPerfilDoctor extends JPanel {
//
//    private static final long serialVersionUID = 1L;
//    private MetodosDoctores metodosDoctores;
//    private JTextField textFieldNombreCompleto;
//    private JTextField textFieldNumLicencia;
//    private JTextField textFieldEspecialidad;
//    private JTextField textFieldNumTelefono;
//    private JTextField textFieldCorreoElectronico;
//    private JTextField textFieldDireccionConsultorio;
//    private JTextField textFieldAniosExperiencia;
//    private JTextField textFieldEducacion;
//    private JTextField textFieldUniversidad;
//    private JTextField textFieldTitulo;
//    private JTextField textFieldAnioGraduacion;
//    private JTextArea textAreaCertificaciones;
//    private JTextArea textAreaIdiomas;
//    private JTextField textFieldHorarioAtencion;
//
//    public JPerfilDoctor() {
//        metodosDoctores = new MetodosDoctores(); // Instanciar la clase MetodosDoctores
//        setLayout(new BorderLayout());
//
//        JPanel topPanel = new JPanel();
//        JPanel formPanel = new JPanel(new GridLayout(0, 2, 5, 5));
//        JPanel buttonPanel = new JPanel();
//
//        formPanel.add(new JLabel("Nombre Completo:"));
//        textFieldNombreCompleto = new JTextField();
//        formPanel.add(textFieldNombreCompleto);
//        formPanel.add(new JLabel("Número de Licencia Médica:"));
//        textFieldNumLicencia = new JTextField();
//        formPanel.add(textFieldNumLicencia);
//        formPanel.add(new JLabel("Especialidad:"));
//        textFieldEspecialidad = new JTextField();
//        formPanel.add(textFieldEspecialidad);
//        formPanel.add(new JLabel("Número de Teléfono:"));
//        textFieldNumTelefono = new JTextField();
//        formPanel.add(textFieldNumTelefono);
//        formPanel.add(new JLabel("Correo Electrónico:"));
//        textFieldCorreoElectronico = new JTextField();
//        formPanel.add(textFieldCorreoElectronico);
//        formPanel.add(new JLabel("Dirección de Consultorio:"));
//        textFieldDireccionConsultorio = new JTextField();
//        formPanel.add(textFieldDireccionConsultorio);
//        formPanel.add(new JLabel("Años de Experiencia:"));
//        textFieldAniosExperiencia = new JTextField();
//        formPanel.add(textFieldAniosExperiencia);
//        formPanel.add(new JLabel("Educación:"));
//        textFieldEducacion = new JTextField();
//        formPanel.add(textFieldEducacion);
//        formPanel.add(new JLabel("Universidad/Institución:"));
//        textFieldUniversidad = new JTextField();
//        formPanel.add(textFieldUniversidad);
//        formPanel.add(new JLabel("Título Obtenido:"));
//        textFieldTitulo = new JTextField();
//        formPanel.add(textFieldTitulo);
//        formPanel.add(new JLabel("Año de Graduación:"));
//        textFieldAnioGraduacion = new JTextField();
//        formPanel.add(textFieldAnioGraduacion);
//        formPanel.add(new JLabel("Certificaciones:"));
//        textAreaCertificaciones = new JTextArea();
//        formPanel.add(new JScrollPane(textAreaCertificaciones));
//        formPanel.add(new JLabel("Idiomas Hablados:"));
//        textAreaIdiomas = new JTextArea();
//        formPanel.add(new JScrollPane(textAreaIdiomas));
//        formPanel.add(new JLabel("Horario de Atención:"));
//        textFieldHorarioAtencion = new JTextField();
//        formPanel.add(textFieldHorarioAtencion);
//
//        JScrollPane scrollPane = new JScrollPane(formPanel);
//
//        JLabel titleLabel = new JLabel("Perfil Doctor");
//        titleLabel.setFont(new Font("Segoe Print", Font.PLAIN, 15));
//        topPanel.add(titleLabel);
//
//        JButton registrarButton = new JButton("Registrar Doctor");
//        registrarButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                registrarDoctor();
//            }
//        });
//        buttonPanel.add(registrarButton);
//
//        JButton mostrarButton = new JButton("Mostrar Doctor");
//        mostrarButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                mostrarDoctor();
//            }
//        });
//        buttonPanel.add(mostrarButton);
//
//        add(topPanel, BorderLayout.NORTH);
//        add(scrollPane, BorderLayout.CENTER);
//        add(buttonPanel, BorderLayout.SOUTH);
//    }
//
//    private void registrarDoctor() {
//        // Obtener los detalles del doctor
//        String datosDoctor = obtenerDatosDoctor();
//        // Llamar al método registrarDoctor() de MetodosDoctores
//        metodosDoctores.registrarDoctor(datosDoctor);
//    }
//
//    private String obtenerDatosDoctor() {
//        StringBuilder datos = new StringBuilder();
//        datos.append("Nombre Completo: ").append(textFieldNombreCompleto.getText()).append("\n");
//        datos.append("Número de Licencia Médica: ").append(textFieldNumLicencia.getText()).append("\n");
//        datos.append("Especialidad: ").append(textFieldEspecialidad.getText()).append("\n");
//        datos.append("Número de Teléfono: ").append(textFieldNumTelefono.getText()).append("\n");
//        datos.append("Correo Electrónico: ").append(textFieldCorreoElectronico.getText()).append("\n");
//        datos.append("Dirección de Consultorio: ").append(textFieldDireccionConsultorio.getText()).append("\n");
//        datos.append("Años de Experiencia: ").append(textFieldAniosExperiencia.getText()).append("\n");
//        datos.append("Educación: ").append(textFieldEducacion.getText()).append("\n");
//        datos.append("Universidad/Institución: ").append(textFieldUniversidad.getText()).append("\n");
//        datos.append("Título Obtenido: ").append(textFieldTitulo.getText()).append("\n");
//        datos.append("Año de Graduación: ").append(textFieldAnioGraduacion.getText()).append("\n");
//        datos.append("Certificaciones: ").append(textAreaCertificaciones.getText()).append("\n");
//        datos.append("Idiomas Hablados: ").append(textAreaIdiomas.getText()).append("\n");
//        datos.append("Horario de Atención: ").append(textFieldHorarioAtencion.getText()).append("\n");
//        return datos.toString();
//    }
//
//    private void mostrarDoctor() {
//        String numLicencia = textFieldNumLicencia.getText();
//        if (!numLicencia.isEmpty()) {
//            metodosDoctores.mostrarRegistro(numLicencia);
//        } else {
//            JOptionPane.showMessageDialog(this, "Por favor, ingrese el número de licencia médica.", "Error",
//                    JOptionPane.ERROR_MESSAGE);
//        }
//    }
//}


//package Panel;
//
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.SwingUtilities;
//import java.awt.BorderLayout;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import LogicaPerfilDoc.MetodosDoctores;
//import Principal.Inicio;
//
//public class JPerfilDoctor extends JPanel {
//
//    private static final long serialVersionUID = 1L;
//    private MetodosDoctores metodosDoctores;
//    private JTextField textFieldNombreCompleto;
//    private JTextField textFieldNumLicencia;
//    private JTextField textFieldEspecialidad;
//    private JTextField textFieldNumTelefono;
//    private JTextField textFieldCorreoElectronico;
//    private JTextField textFieldDireccionConsultorio;
//    private JTextField textFieldAniosExperiencia;
//    private JTextField textFieldEducacion;
//    private JTextField textFieldUniversidad;
//    private JTextField textFieldTitulo;
//    private JTextField textFieldAnioGraduacion;
//    private JTextArea textAreaCertificaciones;
//    private JTextArea textAreaIdiomas;
//    private JTextField textFieldHorarioAtencion;
//    private JLabel lblNewLabel;
//    private JLabel lblNewLabel_1;
//    private JLabel lblNewLabel_2;
//
//    public JPerfilDoctor() {
//        metodosDoctores = new MetodosDoctores(metodosDoctores);
//        setLayout(new BorderLayout());
//
//        JPanel topPanel = new JPanel();
//        JPanel formPanel = new JPanel(new GridLayout(0, 2, 5, 5));
//        JPanel buttonPanel = new JPanel();
//        JPanel rightPanel = new JPanel(new GridLayout(0, 1, 5, 5));
//
//        formPanel.add(new JLabel("Nombre Completo:"));
//        textFieldNombreCompleto = new JTextField();
//        formPanel.add(textFieldNombreCompleto);
//        formPanel.add(new JLabel("Número de Licencia Médica:"));
//        textFieldNumLicencia = new JTextField();
//        formPanel.add(textFieldNumLicencia);
//        formPanel.add(new JLabel("Especialidad:"));
//        textFieldEspecialidad = new JTextField();
//        formPanel.add(textFieldEspecialidad);
//        formPanel.add(new JLabel("Número de Teléfono:"));
//        textFieldNumTelefono = new JTextField();
//        formPanel.add(textFieldNumTelefono);
//        formPanel.add(new JLabel("Correo Electrónico:"));
//        textFieldCorreoElectronico = new JTextField();
//        formPanel.add(textFieldCorreoElectronico);
//        formPanel.add(new JLabel("Dirección de Consultorio:"));
//        textFieldDireccionConsultorio = new JTextField();
//        formPanel.add(textFieldDireccionConsultorio);
//        formPanel.add(new JLabel("Años de Experiencia:"));
//        textFieldAniosExperiencia = new JTextField();
//        formPanel.add(textFieldAniosExperiencia);
//        formPanel.add(new JLabel("Educación:"));
//        textFieldEducacion = new JTextField();
//        formPanel.add(textFieldEducacion);
//        formPanel.add(new JLabel("Universidad/Institución:"));
//        textFieldUniversidad = new JTextField();
//        formPanel.add(textFieldUniversidad);
//        formPanel.add(new JLabel("Título Obtenido:"));
//        textFieldTitulo = new JTextField();
//        formPanel.add(textFieldTitulo);
//        formPanel.add(new JLabel("Año de Graduación:"));
//        textFieldAnioGraduacion = new JTextField();
//        formPanel.add(textFieldAnioGraduacion);
//        formPanel.add(new JLabel("Certificaciones:"));
//        textAreaCertificaciones = new JTextArea();
//        formPanel.add(new JScrollPane(textAreaCertificaciones));
//        formPanel.add(new JLabel("Idiomas Hablados:"));
//        textAreaIdiomas = new JTextArea();
//        formPanel.add(new JScrollPane(textAreaIdiomas));
//        formPanel.add(new JLabel("Horario de Atención:"));
//        textFieldHorarioAtencion = new JTextField();
//        formPanel.add(textFieldHorarioAtencion);
//
//        JScrollPane scrollPane = new JScrollPane(formPanel);
//
//        JLabel titleLabel = new JLabel("Perfil Doctor");
//        titleLabel.setFont(new Font("Segoe Print", Font.PLAIN, 15));
//        topPanel.add(titleLabel);
//
//        JButton registrarButton = new JButton("Registrar Doctor");
//        registrarButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                registrarDoctor();
//            }
//        });
//        buttonPanel.add(registrarButton);
//
//        JButton mostrarButton = new JButton("Mostrar Doctor");
//        mostrarButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                mostrarDoctor();
//            }
//        });
//        buttonPanel.add(mostrarButton);
//        
//        lblNewLabel = new JLabel("");
//        rightPanel.add(lblNewLabel);
//        
//        lblNewLabel_2 = new JLabel("");
//        rightPanel.add(lblNewLabel_2);
//        
//        lblNewLabel_1 = new JLabel("");
//        rightPanel.add(lblNewLabel_1);
//
//        JButton btnMenuPrincipal = new JButton("Menu Principal");
//        rightPanel.add(btnMenuPrincipal);
//        
//        btnMenuPrincipal.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JPerfilDoctor.this);
//                if (frame != null) {
//                    frame.mostrarJIngresoDoc();
//                }
//            }
//        });
//        
//        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
//        rightPanel.add(btnCerrarSesion);
//        
//        btnCerrarSesion.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JPerfilDoctor.this);
//                if (frame != null) {
//                    frame.mostrarPanelInicioSesion();
//                }
//            }
//        });
//
//        add(topPanel, BorderLayout.NORTH);
//        add(scrollPane, BorderLayout.CENTER);
//        add(buttonPanel, BorderLayout.SOUTH);
//        add(rightPanel, BorderLayout.EAST);
//    }
//
//    private void registrarDoctor() {
//        String datosDoctor = obtenerDatosDoctor();
//        metodosDoctores.registrarDoctor(datosDoctor);
//    }
//
//    private String obtenerDatosDoctor() {
//        StringBuilder datos = new StringBuilder();
//        datos.append("Nombre Completo: ").append(textFieldNombreCompleto.getText()).append("\n");
//        datos.append("Número de Licencia Médica: ").append(textFieldNumLicencia.getText()).append("\n");
//        datos.append("Especialidad: ").append(textFieldEspecialidad.getText()).append("\n");
//        datos.append("Número de Teléfono: ").append(textFieldNumTelefono.getText()).append("\n");
//        datos.append("Correo Electrónico: ").append(textFieldCorreoElectronico.getText()).append("\n");
//        datos.append("Dirección de Consultorio: ").append(textFieldDireccionConsultorio.getText()).append("\n");
//        datos.append("Años de Experiencia: ").append(textFieldAniosExperiencia.getText()).append("\n");
//        datos.append("Educación: ").append(textFieldEducacion.getText()).append("\n");
//        datos.append("Universidad/Institución: ").append(textFieldUniversidad.getText()).append("\n");
//        datos.append("Título Obtenido: ").append(textFieldTitulo.getText()).append("\n");
//        datos.append("Año de Graduación: ").append(textFieldAnioGraduacion.getText()).append("\n");
//        datos.append("Certificaciones: ").append(textAreaCertificaciones.getText()).append("\n");
//        datos.append("Idiomas Hablados: ").append(textAreaIdiomas.getText()).append("\n");
//        datos.append("Horario de Atención: ").append(textFieldHorarioAtencion.getText()).append("\n");
//        return datos.toString();
//    }
//
//    private void mostrarDoctor() {
//        String numLicencia = textFieldNumLicencia.getText();
//        if (!numLicencia.isEmpty()) {
//            metodosDoctores.mostrarRegistro(numLicencia);
//        } else {
//            JOptionPane.showMessageDialog(this, "Por favor, ingrese el número de licencia médica.", "Error",
//                    JOptionPane.ERROR_MESSAGE);
//        }
//    }
//}


package Panel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import LogicaPerfilDoc.MetodosDoctores;
import Principal.Inicio;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class JPerfilDoctor extends JPanel {

    private static final long serialVersionUID = 1L;
    private MetodosDoctores metodosDoctores;
    private JTextField textFieldNombreCompleto;
    private JTextField textFieldNumLicencia;
    private JTextField textFieldEspecialidad;
    private JTextField textFieldNumTelefono;
    private JTextField textFieldCorreoElectronico;
    private JTextField textFieldDireccionConsultorio;
    private JTextField textFieldAniosExperiencia;
    private JTextField textFieldEducacion;
    private JTextField textFieldUniversidad;
    private JTextField textFieldTitulo;
    private JTextField textFieldAnioGraduacion;
    private JTextArea textAreaCertificaciones;
    private JTextArea textAreaIdiomas;
    private JTextField textFieldHorarioAtencion;
    private JLabel lblNewLabel_1;
    private JPanel panel;
    private String doctorID;

    public JPerfilDoctor() {
        metodosDoctores = new MetodosDoctores(doctorID);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        topPanel.setBackground(Color.PINK);
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        JPanel buttonPanel = new JPanel();
        JPanel rightPanel = new JPanel(new GridLayout(0, 1, 5, 5));

        formPanel.add(new JLabel("Nombre Completo:"));
        textFieldNombreCompleto = new JTextField();
        formPanel.add(textFieldNombreCompleto);
        formPanel.add(new JLabel("Número de Licencia Médica:"));
        textFieldNumLicencia = new JTextField();
        formPanel.add(textFieldNumLicencia);
        formPanel.add(new JLabel("Especialidad:"));
        textFieldEspecialidad = new JTextField();
        formPanel.add(textFieldEspecialidad);
        formPanel.add(new JLabel("Número de Teléfono:"));
        textFieldNumTelefono = new JTextField();
        formPanel.add(textFieldNumTelefono);
        formPanel.add(new JLabel("Correo Electrónico:"));
        textFieldCorreoElectronico = new JTextField();
        formPanel.add(textFieldCorreoElectronico);
        formPanel.add(new JLabel("Dirección de Consultorio:"));
        textFieldDireccionConsultorio = new JTextField();
        formPanel.add(textFieldDireccionConsultorio);
        formPanel.add(new JLabel("Años de Experiencia:"));
        textFieldAniosExperiencia = new JTextField();
        formPanel.add(textFieldAniosExperiencia);
        formPanel.add(new JLabel("Educación:"));
        textFieldEducacion = new JTextField();
        formPanel.add(textFieldEducacion);
        formPanel.add(new JLabel("Universidad/Institución:"));
        textFieldUniversidad = new JTextField();
        formPanel.add(textFieldUniversidad);
        formPanel.add(new JLabel("Título Obtenido:"));
        textFieldTitulo = new JTextField();
        formPanel.add(textFieldTitulo);
        formPanel.add(new JLabel("Año de Graduación:"));
        textFieldAnioGraduacion = new JTextField();
        formPanel.add(textFieldAnioGraduacion);
        formPanel.add(new JLabel("Certificaciones:"));
        textAreaCertificaciones = new JTextArea();
        formPanel.add(new JScrollPane(textAreaCertificaciones));
        formPanel.add(new JLabel("Idiomas Hablados:"));
        textAreaIdiomas = new JTextArea();
        formPanel.add(new JScrollPane(textAreaIdiomas));
        formPanel.add(new JLabel("Horario de Atención:"));
        textFieldHorarioAtencion = new JTextField();
        formPanel.add(textFieldHorarioAtencion);

        JScrollPane scrollPane = new JScrollPane(formPanel);

        JLabel titleLabel = new JLabel("Perfil Doctor");
        titleLabel.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        topPanel.add(titleLabel);
        
                JButton registrarButton = new JButton("Registrar Doctor");
                rightPanel.add(registrarButton);
                registrarButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        registrarDoctor();
                    }
                });
        
                JButton mostrarButton = new JButton("Mostrar Doctor");
                rightPanel.add(mostrarButton);
                mostrarButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        mostrarDoctor();
                    }
                });

        lblNewLabel_1 = new JLabel("");
        rightPanel.add(lblNewLabel_1);

        JButton btnMenuPrincipal = new JButton("Menu Principal");
        rightPanel.add(btnMenuPrincipal);

        btnMenuPrincipal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JPerfilDoctor.this);
                if (frame != null) {
                    frame.mostrarJIngresoDoc();
                }
            }
        });

        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
        rightPanel.add(btnCerrarSesion);

        btnCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JPerfilDoctor.this);
                if (frame != null) {
                    frame.mostrarPanelInicioSesion();
                }
            }
        });

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        panel = new JPanel();
        scrollPane.setRowHeaderView(panel);
        add(buttonPanel, BorderLayout.SOUTH);
        add(rightPanel, BorderLayout.EAST);
    }

    private void registrarDoctor() {
        String datosDoctor = obtenerDatosDoctor();
        metodosDoctores.registrarDoctor(datosDoctor);
    }

    private String obtenerDatosDoctor() {
        StringBuilder datos = new StringBuilder();
        datos.append("Nombre Completo: ").append(textFieldNombreCompleto.getText()).append("\n");
        datos.append("Número de Licencia Médica: ").append(textFieldNumLicencia.getText()).append("\n");
        datos.append("Especialidad: ").append(textFieldEspecialidad.getText()).append("\n");
        datos.append("Número de Teléfono: ").append(textFieldNumTelefono.getText()).append("\n");
        datos.append("Correo Electrónico: ").append(textFieldCorreoElectronico.getText()).append("\n");
        datos.append("Dirección de Consultorio: ").append(textFieldDireccionConsultorio.getText()).append("\n");
        datos.append("Años de Experiencia: ").append(textFieldAniosExperiencia.getText()).append("\n");
        datos.append("Educación: ").append(textFieldEducacion.getText()).append("\n");
        datos.append("Universidad/Institución: ").append(textFieldUniversidad.getText()).append("\n");
        datos.append("Título Obtenido: ").append(textFieldTitulo.getText()).append("\n");
        datos.append("Año de Graduación: ").append(textFieldAnioGraduacion.getText()).append("\n");
        datos.append("Certificaciones: ").append(textAreaCertificaciones.getText()).append("\n");
        datos.append("Idiomas Hablados: ").append(textAreaIdiomas.getText()).append("\n");
        datos.append("Horario de Atención: ").append(textFieldHorarioAtencion.getText()).append("\n");
        return datos.toString();
    }

    private void mostrarDoctor() {
        String numLicencia = textFieldNumLicencia.getText();
        if (!numLicencia.isEmpty()) {
            String[] datosDoctor = metodosDoctores.mostrarRegistro(numLicencia);
            if (datosDoctor != null) {
                llenarFormulario(datosDoctor);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el número de licencia médica.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarFormulario(String[] datos) {
        textFieldNombreCompleto.setText(datos[0]);
        textFieldNumLicencia.setText(datos[1]);
        textFieldEspecialidad.setText(datos[2]);
        textFieldNumTelefono.setText(datos[3]);
        textFieldCorreoElectronico.setText(datos[4]);
        textFieldDireccionConsultorio.setText(datos[5]);
        textFieldAniosExperiencia.setText(datos[6]);
        textFieldEducacion.setText(datos[7]);
        textFieldUniversidad.setText(datos[8]);
        textFieldTitulo.setText(datos[9]);
        textFieldAnioGraduacion.setText(datos[10]);
        textAreaCertificaciones.setText(datos[11]);
        textAreaIdiomas.setText(datos[12]);
        textFieldHorarioAtencion.setText(datos[13]);
    }
}

