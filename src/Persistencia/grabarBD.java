package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** @author José Miguel Guimerá Padrón.*/
public class grabarBD {
    
    public static boolean grabandoBD(String nom,String ape,String data,String mail,String telf){
        
        boolean ok=false;
        PreparedStatement ps = null;
        OracleDB db = new OracleDB();
        Object TIPO_DATOS=null;     
        
          String sqlq="insert into AGENDA values(?,?,TIPO_DATOS(?,?))";
        try{
          
            ps = db.conectarDB().prepareStatement(sqlq);
            ps.setString(1, nom);
            ps.setString(2, ape);
            ps.setObject(3, TIPO_DATOS);
            ps.setString(3, mail);
            ps.setString(4, telf);
            
            ps.executeUpdate();
            
            ok=true;
            
         }
        catch(SQLException sqle){
            
            Logger.getLogger(grabarBD.class.getName()).log(Level.SEVERE, null, sqle);
            System.out.println("Mensaje del Error SQL: "+sqle.getMessage());                
            System.out.println("Estado del SQL: "+sqle.getSQLState());
            System.out.println("Código del Error:"+sqle.getErrorCode());            
            
         }
        finally{
            
            try{
                ps.close();
                ps = null;
                db.cerrarDB();
             }
            catch(SQLException sqle){
                
                Logger.getLogger(grabarBD.class.getName()).log(Level.SEVERE, null, sqle);                
                System.out.println("Mensaje del Error SQL: "+sqle.getMessage());                
                System.out.println("Estado del SQL: "+sqle.getSQLState());
                System.out.println("Código del Error:"+sqle.getErrorCode());                            
                 
             }
        
        }
        
    return ok;
    
    }
    
} //fin clase grabarBD
