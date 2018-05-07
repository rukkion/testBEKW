
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase configurada para la conexión del Servidor SQLServer.
 * @author BEKW
 */
public class CONECTAR_SERVER {
    
    Connection conect = null;
    String rutaBD="jdbc:sqlserver://localhost;databaseName=BEKW";


    
    public CONECTAR_SERVER() {
    }

    /**
    * Retorna la configuración de la conexión.
    * @return Retorna el tipo de conexión que se tiene de SQL.
    */
    public Connection getConect(){
        
        return conect;
    }
    
    /**
    * Establece la configuración de la conexión.
    * @param conect Conexion de SQL.
    */
    public void setConect(Connection conect) {
        this.conect = conect;
    }

    /**
    * Retorna la ruta del Servidor, así como la base de datos.
    * @return Retorna la cadena de la Ruta del servidor y la base de datos..
    */
    public String getRutaBD() {
        return rutaBD;
    }

    /**
    * Establece la ruta del Servidor y la Base de Datos.
    * @param rutaBD Cadena de la ruta completa del Servidor y la base de datos.
    */
    public void setRutaBD(String rutaBD) {
        this.rutaBD = rutaBD;
    }

    /**
    * Establece conexión al servidor.
    */
    public void conectarBD() throws ClassNotFoundException {
        try{
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conect = DriverManager.getConnection(rutaBD,"sa","123");
            System.out.println("Conectado.");
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
