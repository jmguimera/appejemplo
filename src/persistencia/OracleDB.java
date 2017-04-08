/** @author José Miguel Guimerá Padrón. */
package persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleDataSource;

public class OracleDB {

    private Connection conn = null;

    public Connection conectarDB(){
    
        try{
            OracleDataSource ods = new OracleDataSource();
            String oracle_url="jdbc:oracle:thin:@//127.0.0.1:"+1521+"/"+"xe";
            ods.setURL(oracle_url);
            ods.setUser("josem");
            ods.setPassword("viviana1");
            conn = ods.getConnection();
           
         }
        catch (SQLException sqle){
            Logger.getLogger(OracleDB.class.getName()).log(Level.SEVERE, null, sqle);
            conn=null;   
         }

        return conn;
     }
    
    public void cerrarDB(){
        try{
            conn.commit();
            conn.close();
            conn=null;
            
         }
        catch(SQLException sqle){
            System.out.println("Ha ocurrido un error al intentar cerrar la conexion con Oracle. Error:" + sqle.getMessage());
            System.out.println("Estado del SQL: "+sqle.getSQLState());
            System.out.println("Código del Error:"+sqle.getErrorCode());           
         }
    
    }

    public Connection getConn() {
        return conn;
    }
    
    
} //fin de la clase OracleDB
