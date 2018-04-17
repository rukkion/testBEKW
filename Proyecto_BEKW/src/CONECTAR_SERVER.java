
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willi
 */
public class CONECTAR_SERVER {
    Connection conect = null;
    /******************************CONECTAR BD*********************************/
//    //LAPTOP WILLY
//        String rutaBD="jdbc:sqlserver://BRICAIRE\\ABD;databaseName=BEKW";
    //ESCRITORIO WILLY
          String rutaBD="jdbc:sqlserver://localhost;databaseName=BEKW";

    public CONECTAR_SERVER() {
    }

    
    public Connection getConect(){
        
        return conect;
    }

    public void setConect(Connection conect) {
        this.conect = conect;
    }

    public String getRutaBD() {
        return rutaBD;
    }

    /**************************************************************************/
    public void setRutaBD(String rutaBD) {
        this.rutaBD = rutaBD;
    }

    public void conectarBD() throws ClassNotFoundException {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conect = DriverManager.getConnection(rutaBD,"sa","123");
            System.out.println("Conectado.");
        }
        catch (SQLException ex)
        {
            System.out.println("Error.");
        }
    }
}
