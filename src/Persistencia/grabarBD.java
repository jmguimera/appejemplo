package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** @author José Miguel Guimerá Padrón.*/
public class grabarBD {
    
    
    public grabarBD(){}    
    
    public static boolean grabandoBD(String dato1,String dato2){
        
        boolean ok=false;
        PreparedStatement ps = null;
        OracleDB db = new OracleDB();
        String sqlq ="INSERT INTO AGENDA VALUES(?,?)";
    
        try{
          
            ps = db.conectarDB().prepareStatement(sqlq);
            ps.setString(1, dato1);
            ps.setString(2, dato2);
            
            ps.executeUpdate();
            
//            db.cerrarDB();
            
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
//                db.cerrarDB();
                db = null;
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
    
}
