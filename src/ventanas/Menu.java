/** @author José Miguel Guimerá Padrón.  */
package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener,MouseListener {
    
    private JLabel labelSubtitulo,labelMensaje;
    private JButton btnRegistro,btnSalir,btnModificar;
    
    public Menu(){

        componentes();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// se detiene el programa 
        setSize(400,450); // Tamaño de la Ventana Ancho y Largo
        setLocationRelativeTo(null); // Centra la ventana en el monitor
        setLayout(null); // elimina toda plantilla.
        setResizable(false); // eviata que se pueda modificar el tamaño de ventana
        setVisible(true); // hace visible la ventana
        setTitle("  ** Menú Principal **"); // Le pone un titulo a la ventana
    
     }
    
    public void componentes(){

            labelSubtitulo=new JLabel();
            labelSubtitulo.setBounds(110, 25, 180, 20);
            labelSubtitulo.setText("Seleccione  una  opción");
            add(labelSubtitulo);
            
            btnRegistro=new JButton();
            btnRegistro.setBounds(120, 50, 150, 20);
            btnRegistro.setText("Registrar"); 
            add(btnRegistro);
            btnRegistro.addActionListener(this);
            btnRegistro.addMouseListener(this);
  
            btnModificar=new JButton();
            btnModificar.setBounds(120, 80, 150, 20);
            btnModificar.setText("Modificar"); 
            add(btnModificar);
            btnModificar.addActionListener(this);
            btnModificar.addMouseListener(this);
            
            labelMensaje=new JLabel();
            labelMensaje.setBounds(40,370, 350, 20);
            add(labelMensaje);
            
                    
            btnSalir=new JButton();
            btnSalir.setBounds(120,400, 150, 20);
            btnSalir.setText("Salir");
            add(btnSalir);
            btnSalir.addActionListener(this);        
     }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(btnRegistro)){

            this.dispose();            
            new Registro();
         }
        
        if (e.getSource().equals(btnSalir)){
            System.out.println("Estoy dentro de Salir");
            this.dispose();

         }        
     }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource().equals(btnRegistro)){
        
            labelMensaje.setText("Para insertar un nuevo registro en la tabla agenda");
            labelMensaje.setVisible(true);
        }   
    }

    @Override
    public void mouseExited(MouseEvent e) {
         if(e.getSource().equals(btnRegistro)){
        
            labelMensaje.setText("");
            labelMensaje.setVisible(false);
        }       
    }

} // fin de la clase Menu
