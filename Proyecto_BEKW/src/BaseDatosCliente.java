
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EDGUR
 */
public class BaseDatosCliente {
  private Connection con;
  private Statement dec;
  private String query;
  private String id;
  private String nom;
  private String app;
  private String apm;
  private String dom;
  private String codp;
  private String tel;
  private String tipo;

  BaseDatosCliente() {
    con = null;
    dec = null;
    query = "";
    id="";
    nom = "";
    app = "";
    apm = "";
    dom = "";
    codp = "";
    tel = "";
    tipo = "C";
  }

  //Accion en la base datos Cliente
  boolean insertar(String nom,String app, String apm, String dom, String codp, String tel) throws ClassNotFoundException, SQLException {
    conectar();
    variables(nom,app,apm,dom,codp,tel);
    if(verificar()){
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=BEKW","sa","123");
        String cad = "INSERT INTO PERSONAS "+"VALUES('"+this.nom+"','"+this.app+"','"+this.apm+"','"+this.dom+"','"+this.codp+"','"+this.tel+"','C')";
        dec = con.createStatement();
        dec.executeUpdate(cad);
     }catch (SQLException ex) {
            System.out.println("Error.");   
     }
    return true;
    }else
        return false;
  }

  boolean eliminar(String id) throws ClassNotFoundException, SQLException {
    conectar();
    this.id = id;
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=BEKW","sa","123");
        String cad = "DELETE FROM PERSONAS WHERE ID_PERSONA='"+this.id+"'";
        dec = con.createStatement();
        dec.executeUpdate(cad);
        return true;
     }catch (SQLException ex) {
            System.out.println("Error.");   
     }
    return false;
  }

  boolean modificar(String id,String nom,String app, String apm, String dom, String codp, String tel) throws ClassNotFoundException, SQLException {
    conectar();
    this.id = id;
    variables(nom,app,apm,dom,codp,tel);
    if(verificar()){
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=BEKW","sa","123");
        String cad = "UPDATE PERSONAS SET NOMBRE = '"+this.nom+"',APE_PAT='"+this.app+"',APE_MAT='"+this.apm+"',DOMICILIO='"+this.dom+"',COD_POSTAL='"+this.codp+"',TELEFONO='"+this.tel+"'  WHERE ID_PERSONA ="+this.id;
        dec = con.createStatement();
        dec.executeUpdate(cad);
     }catch (SQLException ex) {
        System.out.println("Error.");   
     }
    return true;
    }else
        return false;
  }

  //Control
    void conectar() throws ClassNotFoundException, SQLException {
        con = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=BEKW","sa","123");
        }catch (SQLException ex) {
            System.out.println("Error Conexion.");
        }
    
    }

    private void variables(String nom,String app, String apm, String dom, String codp, String tel) {
        this.nom = nom;
        this.app = app;
        this.apm = apm;
        this.dom = dom;
        this.codp = codp;
        this.tel = tel;

    }
    
    private boolean verificar() {
          if(!vCadenasE(this.nom)){
              showMessageDialog(null,"Error en el Nombre");
              return false;
          }
          if(!vCadenas(this.app)){
              showMessageDialog(null,"Error en el apellido paterno");
              return false;
          }    
          if(!vCadenas(this.apm)){
              showMessageDialog(null,"Error en el apellido materno");
              return false;
          }    
          if(!vCadenasEN(this.dom)){
              showMessageDialog(null,"Error en el domicilio");
              return false;
          }    
          if(!vNumeros(this.codp)){
              showMessageDialog(null,"Error en el codigo Postal");
              return false;
          }    
          if(!vNumeros(this.tel)){
              showMessageDialog(null,"Error en el telefono");
              return false;
          }    
          return true;
    }
    
    private boolean vCadenasE(String cad){
          char [] arrayCad = cad.toCharArray();
          for(int i=0; i < arrayCad.length;i++){
              if(((int) arrayCad[i] < 65 || (int)arrayCad[i] > 90) && ((int)arrayCad[i] < 97 || (int)arrayCad[i] > 122))
                  if((int) arrayCad[i] != 32)
                    return false;             
          }
          return true;
    }
    
    private boolean vCadenas(String cad){
          char [] arrayCad = cad.toCharArray();
          for(int i=0; i < arrayCad.length;i++){
              if(((int) arrayCad[i] < 65 || (int)arrayCad[i] > 90) && ((int)arrayCad[i] < 97 || (int)arrayCad[i] > 122))
                    return false;             
          }
          return true;
    }
    
     private boolean vCadenasEN(String cad){
          char [] arrayCad = cad.toCharArray();
          for(int i=0; i < arrayCad.length;i++){
              if(((int) arrayCad[i] < 65 || (int)arrayCad[i] > 90) && ((int)arrayCad[i] < 97 || (int)arrayCad[i] > 122) 
              && ((int)arrayCad[i] < 48 || (int)arrayCad[i] > 57))
                  if((int) arrayCad[i] != 32)
                      if((int) arrayCad[i] != 35)
                        return false;             
          }
          return true;
    }
     
    private boolean vNumeros(String cad){
          char [] arrayCad = cad.toCharArray();
          for(int i=0; i < arrayCad.length;i++){
              if((int)arrayCad[i] < 48 || (int)arrayCad[i] > 57)
                    return false;             
          }
          return true;
    }
}
