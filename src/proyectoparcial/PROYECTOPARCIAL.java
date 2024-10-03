package proyectoparcial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
public class PROYECTOPARCIAL extends JFrame implements ActionListener {

    // Componentes de la interfaz de bienvenida
    private JTextField txtNombre;
    private JButton btnContinuarBienvenida;

    // Componentes de la interfaz de términos y condiciones
    private JCheckBox chkAceptar;
    private JButton btnContinuarTerminos, btnNoAceptar;
    private JTextArea txtTerminos;

    // Componentes de la pantalla principal
    private JTextField txtNombreEmpleado, txtApellidosEmpleado;
    private JComboBox<String> cbDepartamento, cbAntiguedad;
    private JButton btnCalcular, btnLimpiar, btnRegresar;

    private String nombreUsuario;
    private final CardLayout cardLayout;
    private final JPanel panelPrincipal;
    private final JPanel panelBienvenida;
    
    private final JPanel panelTerminos;
    private final JPanel panelPantallaPrincipal;
    private JTextArea txtVacaciones;

    private JMenuBar mb;
    private JMenu menu1;
    private JMenuItem mi1, mi2, mi3;
    private JLabel lblUsuario;


    public PROYECTOPARCIAL() {
        setTitle("EMPRESA CLARO");
        setBounds(600, 150, 430, 550); // Posición y tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Configuración del icono (favicon)
        Image icon = Toolkit.getDefaultToolkit().getImage("123.png");
        setIconImage(icon);

        // Panel principal con CardLayout para cambiar entre pantallas
        panelPrincipal = new JPanel();
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);

        // Crear pantallas y añadirlas al panel principal
        panelBienvenida = crearPantallaBienvenida();
        panelTerminos = crearPantallaTerminos();
        panelPantallaPrincipal = crearPantallaPrincipal();

        panelPrincipal.add(panelBienvenida, "Bienvenida");
        panelPrincipal.add(panelTerminos, "Terminos");
        panelPrincipal.add(panelPantallaPrincipal, "Principal");

        add(panelPrincipal, BorderLayout.CENTER);

        // Crear el menú de colores
        crearMenuColores();
        
        // Establecer color de fondo predeterminado (rojo)
        cambiarColorDeFondo(Color.RED);
    }

    // Pantalla de Bienvenida
private JPanel crearPantallaBienvenida() {
    JPanel panelBienvenida = new JPanel();
    panelBienvenida.setLayout(null);
    
    // Ajustar el tamaño de la pantalla de bienvenida
    panelBienvenida.setPreferredSize(new Dimension(400, 400));
    panelBienvenida.setBackground(Color.BLACK); // Establecer el fondo en negro
    
    JLabel lblTitulo = new JLabel("SISTEMA DE VACACIONES");
    lblTitulo.setBounds(50, 20, 350, 40); // Ajustar el tamaño del JLabel
    lblTitulo.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
    lblTitulo.setFont(new Font("Arial", Font.BOLD, 25)); // Cambiar el tamaño y estilo de la fuente
    panelBienvenida.add(lblTitulo);
    
    ImageIcon imagen2;//Utilización del método ImagIcon de java.
    imagen2 = new ImageIcon("1234.png");
    
    JLabel etiqueta3;//Asocia la etiqueta(etiqueta2) con la imágem
    etiqueta3 = new JLabel(imagen2);
    etiqueta3.setBounds(60, 250, 300,100 );//Establece las dimensiones y ubicación de la etiqueta donde lleva la imágen.
    etiqueta3.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(etiqueta3.getWidth(),etiqueta3.getHeight(), Image.SCALE_SMOOTH)));//Adapta las dimensiones 
        //de la imágen según la etiqueta
    panelBienvenida.add(etiqueta3);
    
    JLabel lblNombre = new JLabel("Introduce tu nombre:");
    
    lblNombre.setBounds(20, 95, 200, 30); // Ajustar el tamaño del JLabel
    lblNombre.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
    lblNombre.setFont(new Font("Arial", Font.BOLD, 16)); // Cambiar el tamaño y estilo de la fuente
    panelBienvenida.add(lblNombre);
    
    txtNombre = new JTextField();
    txtNombre.setBounds(200, 100, 200, 20);
    panelBienvenida.add(txtNombre);
    
    btnContinuarBienvenida = new JButton("Continuar");
    btnContinuarBienvenida.setBounds(150, 150, 100, 30);
    btnContinuarBienvenida.addActionListener(this);
    panelBienvenida.add(btnContinuarBienvenida);
    
    return panelBienvenida;
}


    // Pantalla de Términos y Condiciones
    private JPanel crearPantallaTerminos() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblUsuario = new JLabel("TERMINOS Y CONDICIONES ");
        lblUsuario.setBounds(50, 20, 300, 20);
        lblUsuario.setForeground(Color.WHITE); 
        panel.add(lblUsuario);

        txtTerminos = new JTextArea("Al utilizar este programa aceptas cumplir con nuestros términos y condiciones, que incluyen el uso adecuado del servicio, la prohibición de actividades ilegales y la responsabilidad limitada de nuestra parte por cualquier daño que pueda surgir del uso del mismo. Nos reservamos el derecho de modificar estos términos en cualquier momento, y tu uso continuado del servicio después de dichos cambios implica tu aceptación de los nuevos términos. Si no estás de acuerdo con alguna parte de estos términos, debes abstenerte de utilizar el servicio");
        txtTerminos.setBounds(50, 50, 300, 200);
        txtTerminos.setLineWrap(true);
        txtTerminos.setWrapStyleWord(true);
        txtTerminos.setEditable(false);
        panel.add(txtTerminos);

        chkAceptar = new JCheckBox("Acepto los términos y condiciones");
        chkAceptar.setBounds(50, 270, 280, 20);
        chkAceptar.addActionListener(this);
        panel.add(chkAceptar);

        btnContinuarTerminos = new JButton("Continuar");
        btnContinuarTerminos.setBounds(50, 310, 100, 30);
        btnContinuarTerminos.setEnabled(false);
        btnContinuarTerminos.addActionListener(this);
        panel.add(btnContinuarTerminos);

        btnNoAceptar = new JButton("No Aceptar");
        btnNoAceptar.setBounds(200, 310, 100, 30);
        btnNoAceptar.addActionListener(this);
        panel.add(btnNoAceptar);

        return panel;
    }

    // Pantalla Principal
    private JPanel crearPantallaPrincipal() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel lblTitulo2 = new JLabel("SISTEMA DE VACACIONES DE LA EMPRESA CLARO");
        lblTitulo2.setBounds(40, 1, 350, 40); // Ajustar el tamaño del JLabel
        lblTitulo2.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
        lblTitulo2.setFont(new Font("Arial", Font.BOLD, 14)); // Cambiar el tamaño y estilo de la fuente
        panel.add(lblTitulo2);
        
                //CONFIGURACIONES ETIQETA 2 || de imágen
        ImageIcon imagen;//Utilización del método ImagIcon de java.
        imagen = new ImageIcon("1234.png");
        JLabel etiqueta2 = new JLabel(imagen);//Asocia la etiqueta(etiqueta2) con la imágem
        etiqueta2.setBounds(200, 195, 180,75 );//Establece las dimensiones y ubicación de la etiqueta donde lleva la imágen.
        etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta2.getWidth(),etiqueta2.getHeight(), Image.SCALE_SMOOTH)));//Adapta las dimensiones 
        //de la imágen según la etiqueta
        panel.add(etiqueta2);

        
        JLabel lblTitulo3 = new JLabel("EMPRESA: CLARO.SA    DESARROLLADOR: CLAUDIO JOSIAS CUJCUJ BAJAN");
        lblTitulo3.setBounds(40, 430, 350, 40); // Ajustar el tamaño del JLabel
        lblTitulo3.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
        lblTitulo3.setFont(new Font("Arial", Font.BOLD, 9)); // Cambiar el tamaño y estilo de la fuente
        panel.add(lblTitulo3);
        
        JLabel lblTitulo4 = new JLabel("CURSO; PROGRAMACION 2   SECCION: A");
        lblTitulo4.setBounds(40, 450, 350, 40); // Ajustar el tamaño del JLabel
        lblTitulo4.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
        lblTitulo4.setFont(new Font("Arial", Font.BOLD, 9)); // Cambiar el tamaño y estilo de la fuente
        panel.add(lblTitulo4);
         // Agregar un JLabel para mostrar el nombre de usuario
        lblUsuario = new JLabel("Usuario: ");
        lblUsuario.setBounds(150, 18, 350, 40);
        lblUsuario.setForeground(Color.WHITE);
        panel.add(lblUsuario);
        
        JLabel lblNombreEmpleado = new JLabel("Nombre:");
        lblNombreEmpleado.setBounds(50, 50, 100, 20);
        lblNombreEmpleado.setForeground(Color.WHITE); 
        panel.add(lblNombreEmpleado);

        txtNombreEmpleado = new JTextField();
        txtNombreEmpleado.setBounds(150, 50, 200, 20);
        panel.add(txtNombreEmpleado);

        JLabel lblApellidosEmpleado = new JLabel("Apellidos:");
        lblApellidosEmpleado.setBounds(50, 90, 100, 20);
        lblApellidosEmpleado.setForeground(Color.WHITE); 
        panel.add(lblApellidosEmpleado);

        txtApellidosEmpleado = new JTextField();
        txtApellidosEmpleado.setBounds(150, 90, 200, 20);
        panel.add(txtApellidosEmpleado);

        JLabel lblDepartamento = new JLabel("Departamento:");
        lblDepartamento.setBounds(50, 130, 100, 20);
        lblDepartamento.setForeground(Color.WHITE); 
        panel.add(lblDepartamento);

        cbDepartamento = new JComboBox<>(new String[]{"Atención al cliente", "Logística", "Gerente"});
        cbDepartamento.setBounds(150, 130, 200, 20);
        panel.add(cbDepartamento);

        JLabel lblAntiguedad = new JLabel("Antigüedad:");
        lblAntiguedad.setBounds(50, 170, 100, 20);
        lblAntiguedad.setForeground(Color.WHITE); 
        panel.add(lblAntiguedad);

        cbAntiguedad = new JComboBox<>(new String[]{"1 año", "2-6 años", "7+ años"});
        cbAntiguedad.setBounds(150, 170, 200, 20);
        panel.add(cbAntiguedad);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(50, 210, 100, 30);
        btnCalcular.addActionListener(this);
        panel.add(btnCalcular);

        JLabel lblVacaciones = new JLabel("Días de vacaciones:");
        lblVacaciones.setBounds(50, 250, 150, 20);
        lblVacaciones.setForeground(Color.WHITE);
        panel.add(lblVacaciones);

        txtVacaciones = new JTextArea();
        txtVacaciones.setBounds(50, 280, 300, 100);
        txtVacaciones.setEditable(false);
        txtVacaciones.setLineWrap(true);
        txtVacaciones.setWrapStyleWord(true);
        panel.add(txtVacaciones);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(50, 400, 100, 30);
        btnLimpiar.addActionListener(this);
        panel.add(btnLimpiar);

        btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(200, 400, 100, 30);
        btnRegresar.addActionListener(this);
        panel.add(btnRegresar);

        return panel;
    }

    // Método para crear el menú de colores
    private void crearMenuColores() {
        mb = new JMenuBar();
        setJMenuBar(mb);

        menu1 = new JMenu("Colores");
        mb.add(menu1);

        mi1 = new JMenuItem("Rojo");
        mi2 = new JMenuItem("Verde");
        mi3 = new JMenuItem("Azul");

        menu1.add(mi1);
        menu1.add(mi2);
        menu1.add(mi3);

        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnContinuarBienvenida) {
        nombreUsuario = txtNombre.getText().trim(); // Eliminar espacios en blanco

        // Validar si el campo de nombre está vacío
        if (nombreUsuario.isEmpty()) {
            // Mostrar el nombre del usuario en la parte superior de la ventana
            JOptionPane.showMessageDialog(this, "Por favor, ingresa tu nombre.", "Error", JOptionPane.ERROR_MESSAGE);
            cardLayout.show(panelBienvenida, "Terminos"); // Solo cambia de tarjeta si el nombre es válido
       
        }
        lblUsuario.setText("Usuario: " + nombreUsuario);
        cardLayout.show(panelPrincipal, "Terminos");
        } else if (e.getSource() == btnContinuarTerminos) {
        cardLayout.show(panelPrincipal, "Principal");
        } else if (e.getSource() == btnNoAceptar) {
        System.exit(0);
        } else if (e.getSource() == chkAceptar) {
        btnContinuarTerminos.setEnabled(chkAceptar.isSelected());
        } else if (e.getSource() == btnCalcular) {
        calcularVacaciones();
        } else if (e.getSource() == btnLimpiar) {
        limpiarFormulario();
        } else if (e.getSource() == btnRegresar) {
        cardLayout.show(panelPrincipal, "Bienvenida");
    
}

        if (e.getSource() == mi1) { // Rojo
            cambiarColorDeFondo(Color.RED);
        } else if (e.getSource() == mi2) { // Verde
            cambiarColorDeFondo(Color.GREEN);
        } else if (e.getSource() == mi3) { // Azul
            cambiarColorDeFondo(Color.BLUE);
        } else if (e.getSource() == btnContinuarBienvenida) {
            nombreUsuario = txtNombre.getText();
            cardLayout.show(panelPrincipal, "Terminos");
        } else if (e.getSource() == btnContinuarTerminos) {
            cardLayout.show(panelPrincipal, "Principal");
        } else if (e.getSource() == btnNoAceptar) {
            System.exit(0);
        } else if (e.getSource() == chkAceptar) {
            btnContinuarTerminos.setEnabled(chkAceptar.isSelected());
        } else if (e.getSource() == btnCalcular) {
            calcularVacaciones();
        } else if (e.getSource() == btnLimpiar) {
            limpiarFormulario();
        } else if (e.getSource() == btnRegresar) {
            cardLayout.show(panelPrincipal, "Bienvenida");
        }
    }

    private void cambiarColorDeFondo(Color color) {
        panelBienvenida.setBackground(color);
        panelTerminos.setBackground(color);
        panelPantallaPrincipal.setBackground(color);
    }

    // Método para calcular las vacaciones
private void calcularVacaciones() {
    String nombre = txtNombreEmpleado.getText();
    String apellidos = txtApellidosEmpleado.getText();
    String departamento = (String) cbDepartamento.getSelectedItem();
    String antiguedad = (String) cbAntiguedad.getSelectedItem();
    int diasVacaciones = 0;
    
    if (nombre.isEmpty()) {
            // Mostrar el nombre del usuario en la parte superior de la ventana
            JOptionPane.showMessageDialog(this, "Por favor completa el nombre.", "Error", JOptionPane.ERROR_MESSAGE);
            cardLayout.show(panelBienvenida, "Terminos"); // Solo cambia de tarjeta si el nombre es válido
    // Lógica para calcular días de vacaciones según el departamento y antigüedad
    
    }else if (apellidos.isEmpty()) {
            // Mostrar el nombre del usuario en la parte superior de la ventana
            JOptionPane.showMessageDialog(this, "Por favor completa el apellido.", "Error", JOptionPane.ERROR_MESSAGE);
            cardLayout.show(panelBienvenida, "Terminos"); // Solo cambia de tarjeta si el nombre es válido
    // Lógica para calcular días de vacaciones según el departamento y antigüedad
    }
    
    if (departamento.equals("Atención al cliente")) {
        if (antiguedad.equals("1 año")) {
            diasVacaciones = 6;
        } else if (antiguedad.equals("2-6 años")) {
            diasVacaciones = 14;
        } else if (antiguedad.equals("7+ años")) {
            diasVacaciones = 20;
        }
    } else if (departamento.equals("Logística")) {
        if (antiguedad.equals("1 año")) {
            diasVacaciones = 7;
        } else if (antiguedad.equals("2-6 años")) {
            diasVacaciones = 15;
        } else if (antiguedad.equals("7+ años")) {
            diasVacaciones = 22;
        }
    } else if (departamento.equals("Gerente")) {
        if (antiguedad.equals("1 año")) {
            diasVacaciones = 10;
        } else if (antiguedad.equals("2-6 años")) {
            diasVacaciones = 20;
        } else if (antiguedad.equals("7+ años")) {
            diasVacaciones = 30;
        }
    }

    // Mostrar el resultado en el cuadro de texto, incluyendo nombre, apellido, puesto, antigüedad y vacaciones
    txtVacaciones.setText(
        "Empleado: " + nombre + " " + apellidos + "\n" +
        "Puesto: " + departamento + "\n" +
        "Antigüedad: " + antiguedad + "\n" +
        "Días de vacaciones: " + diasVacaciones
    );
}


    private void limpiarFormulario() {
        txtNombreEmpleado.setText("");
        txtApellidosEmpleado.setText("");
        txtVacaciones.setText("");
        cbDepartamento.setSelectedIndex(0);
        cbAntiguedad.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        PROYECTOPARCIAL miFormulario = new PROYECTOPARCIAL();
        miFormulario.setVisible(true);
    }
}
