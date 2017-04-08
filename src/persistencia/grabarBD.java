package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class grabarBD {
    
    public static boolean grabandoBD(String nom,String ape,String mail,String telf){
        
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
                  System.out.println("Mensaje del Error SQL: "+sqle.getMessage());                
                  System.out.println("Estado del SQL: "+sqle.getSQLState());
                  System.out.println("Código del Error:"+sqle.getErrorCode());                            
             }
         }
      return ok;
    }
} //fin clase grabarBD
