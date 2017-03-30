/** @author José Miguel Guimerá Padrón.  */
package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {
    
    private JLabel labelSubtitulo;
    private JButton btnRegistro,btnSalir;
    
    public Menu(){

        componentes();
                                                      // Al cerrar la ventana 
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
            
            btnSalir=new JButton();
            btnSalir.setBounds(120,400, 150, 20);
            btnSalir.setText("Salir");
            add(btnSalir);
        
     }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(btnRegistro)){

   //       System.out.println("Se ha pulsado el botón Registrar");
   //       System.out.println("Esta accion abrira una futura ventana de Registro");
            this.dispose();            
            new Registro();
        }
    }
  
} // fin de la clase Menu
