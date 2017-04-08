/** @author José Miguel Guimerá Padrón. */
package ventanas;

import persistencia.OracleDB;
import persistencia.grabarBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Registro extends JFrame implements ActionListener {
    
    private JLabel labelSubtitulo,labelNombres,labelApellidos;
    private JLabel labelEmail,labelTelefono;
    private JTextField txtEmail,txtTelefono;
    private JTextField txtNombres,txtApellidos;
    private JButton btnGuardar,btnCancelar;
    private JDialog dialogo;
    
    public Registro(){
        
        componentes();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(400,450); // Tamaño de la Ventana Ancho y Largo
        setLocationRelativeTo(null); // Centra la ventana en el monitor
        setLayout(null); // elimina toda plantilla.
        setResizable(false); // eviata que se pueda modificar el tamaño de ventana
        setVisible(true); // hace visible la ventana
        setTitle("  ** Módulo de Registros **"); // Le pone un titulo a la ventana    

    
    }
    
    public void componentes(){
     
        labelSubtitulo = new JLabel();
        labelSubtitulo.setBounds(92, 20, 260, 20);
        labelSubtitulo.setText("Rellene todos los recuadros");
        add(labelSubtitulo);
        
        /*--------- Campos ---------*/
        
        labelNombres = new JLabel(); // etiqueta
        labelNombres.setBounds(20, 50, 150,20);
        labelNombres.setText("Nombres");
        add(labelNombres);
        
        txtNombres = new JTextField(); // recuadro a rellenar
        txtNombres.setBounds(90, 50, 300, 20);
        add(txtNombres);
        
        labelApellidos = new JLabel();
        labelApellidos.setBounds(20, 80, 150, 20);
        labelApellidos.setText("Apellidos");
        add(labelApellidos);
        
        txtApellidos = new  JTextField();
        txtApellidos.setBounds(90, 80, 300, 20);
        add(txtApellidos);
        
        labelEmail = new JLabel(); //cambiado
        labelEmail.setBounds(45, 110, 150, 20);
        labelEmail.setText("Email");
        add(labelEmail);
        
        txtEmail = new  JTextField();
        txtEmail.setBounds(90, 110, 300, 20);
        add(txtEmail);

        labelTelefono = new JLabel(); //cambiado
        labelTelefono.setBounds(20, 140, 150, 20);
        labelTelefono.setText("Telefono");
        add(labelTelefono);
        
        txtTelefono = new  JTextField();
        txtTelefono.setBounds(90, 140, 120, 20);
        add(txtTelefono);        
        
        /*---------- Botones ----------*/
        
        btnGuardar = new JButton();
        btnGuardar.setBounds(100, 400, 100, 20);
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this);
        add(btnGuardar);
 
        btnCancelar = new JButton();
        btnCancelar.setBounds(220, 400, 100, 20);
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this);
        add(btnCancelar);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(btnGuardar)){
        System.out.println("Lanzamos una rutina para grabar los datos");

            OracleDB conn=new OracleDB();
           
            if(conn!=null){
            
                System.out.println("Base datos conectada "+conn);
                
                String dat1=txtNombres.getText();
                String dat2=txtApellidos.getText();
                String dat3=txtEmail.getText();
                String dat4=txtTelefono.getText();
                
                if(grabarBD.grabandoBD(dat1,dat2,dat3,dat4)){
                
                    System.out.println("\nGrabación echa ok");
                 }
             }
            
            this.dispose();
            new Menu();
         }
        
        if(e.getSource().equals(btnCancelar)){

            this.dispose();
            new Menu();
        
         }
        
     }
    
} //fin de la clase Registro
