
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
 * @author BEKW
 */
public class BaseDatosCliente {
    /**
   *Atributos que se utilizaran para esta clase y buen funcionamiento de la clase BaseDatosCliente. 
   */
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
  
//Constructor de la clase. 
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
  /**
  * Metodo para Insertar Datos del cliente, ingresando en la base de datos tabla Persona Tipo c (Cliente), 
  *@param nom Nombre del cliente 
  *@param app Apellido paterno del cliente
  *@param apm Apellido Materno del Cliente
  *@param dom Domicilio del Cliente
  *@param codp Codigo Postal del Cliente
  *@param tel Telefono del Cliente
  *@return retorna si se realiza las lineas de codigo para la base de datos SQL server, retornando solamente (True o False)   
  */
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
  
/**
 *Metodo para Eliminar la informacion cliente.
 *@param id Para identificar el cliente seleccionado para eliminar.
 *@return retorna un (True o False) para saber si se realiza los comando en la base de datos BEKW.   
 */
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
  
  /**
  *Metodo para Modificar Datos de cliente.
  *@param id seleccionado de la tabla para saber cual cliente sera modificado
  *@param nom Nombre del cliente 
  *@param app Apellido paterno del cliente
  *@param apm Apellido Materno del Cliente
  *@param dom Domicilio del Cliente
  *@param codp Codigo Postal del Cliente
  *@param tel Telefono del Cliente
  *@return si se realiza las lineas de codigo para la base de datos SQL server; retornando solamente (True o False)
   */
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

 //Metodos de Control. Para se realize en buen funcionamiento los metodos Insertar, Eliminar y Modificar.
 //Metodo Conectar, realizando la conexion de la base de datos BEKW en el sistema.
    void conectar() throws ClassNotFoundException, SQLException {
        con = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=BEKW","sa","123");
        }catch (SQLException ex) {
            System.out.println("Error Conexion.");
        }
    
    }
    
    
  /**
   *Metodo Privado variables.
   *@param nom Nombre del cliente para asignar el valor al atributo nom
   *@param app Apellido Paterno del cliente para asignar el valor al atributo app 
   *@param apm Apellido Materno del cliente para asignar el valor al atributo apm
   *@param dom Domicilio del cliente para asignar el valor al atributo dom
   *@param codp Codigo Postal del Cliente para asginar el valor al atributo codp
   *@param tel Telefono del cliente para asignar el valor al atributo tel
   */
    private void variables(String nom,String app, String apm, String dom, String codp, String tel) {
        this.nom = nom;
        this.app = app;
        this.apm = apm;
        this.dom = dom;
        this.codp = codp;
        this.tel = tel;

    }
    
    /**
     *Metodo Privado verificar que se realiza nomas en la clase BaseDatosCliente.
     *El objetivo de este metodo es validar los campos si tienen los datos correctos para la tabla persona de la base de datos BEKW y no tener errores.
      si en un campo tiene un error le mandara un mensaje al usuario en que campo tiene datos erroneos.   
     *@return retorna un (True o False) para validar el texto  
     */
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
 
    /**
     *Metodo Privado que se realiza nomas en la clase BaseDatosCliente.
     *El objetivo de este metodo es validar la cadena que solamente acepta caracteres minusculas,Mayusculas y espacios. 
     *@param cad Cadena que se va utilizar para realizar la condicion que tiene el metodo
     *@return Recibe una desicion si cumple con la condicion que realiza el metodo (True o False). 
     */
    private boolean vCadenasE(String cad){
          char [] arrayCad = cad.toCharArray();
          for(int i=0; i < arrayCad.length;i++){
              if(((int) arrayCad[i] < 65 || (int)arrayCad[i] > 90) && ((int)arrayCad[i] < 97 || (int)arrayCad[i] > 122))
                  if((int) arrayCad[i] != 32)
                    return false;             
          }
          return true;
    }
    
     /**
         * Metodo Privado que se realiza nomas en la clase BaseDatosCliente, retorna un boleano (true o false),recibe como parametro una cadena.
           El objetivo de este metodo es validar la cadena que solamente acepta caracteres minusculas y Mayusculas
         *@param cad Parametro de cadena para validar la cadena que reciba
         * @return (True o False) Retorna cuando cumple la condiciones 
      */
    private boolean vCadenas(String cad){
          char [] arrayCad = cad.toCharArray();
          for(int i=0; i < arrayCad.length;i++){
              if(((int) arrayCad[i] < 65 || (int)arrayCad[i] > 90) && ((int)arrayCad[i] < 97 || (int)arrayCad[i] > 122))
                    return false;             
          }
          return true;
    }
    
    /**
     *Metodo Privado que se realiza nomas en la clase BaseDatosCliente, retorna un boleano (true o false),recibe como parametro una cadena.
     *El objetivo de este metodo es validar la cadena que solamente acepta caracteres Minusculas,Mayusculas, Espacios y el simbolo #
     * @param cad Es una cadena para validar lo que se encuentra en la caja de textos
     * @return (True o False) para saber si se cumplio la condicion del Metodo
    */
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
     
    /**
     *Metodo Privado que se realiza nomas en la clase BaseDatosCliente.
     *El objetivo de este metodo es validar la cadena que solamente acepta caracteres Digitos 
     *@param cad Cadena que se va utilizar para realizar la condicion que tiene el metodo
     *@return Recibe una desicion si cumple con la condicion que realiza el metodo (True o False). 
     
     */ 
    private boolean vNumeros(String cad){
          char [] arrayCad = cad.toCharArray();
          for(int i=0; i < arrayCad.length;i++){
              if((int)arrayCad[i] < 48 || (int)arrayCad[i] > 57)
                    return false;             
          }
          return true;
    }
}// Cierre de la clase
