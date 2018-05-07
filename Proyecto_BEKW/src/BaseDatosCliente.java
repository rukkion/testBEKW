
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
    /*Atributos que se utilizaran para esta clase y buen funcionamiento de la clase BaseDatosCliente. */
  private Connection con; //Atributo para conexion
  private Statement dec;
  private String query; //Atributo para cadena query sql
  private String id; //Atributo para id de la tabla persona
  private String nom; //Atributo Nombre del cliente
  private String app; //Atributo Apellido Paterno del cliente
  private String apm; //Atributo Apellido Materno del cliente
  private String dom; //Atributo Domicilio del cliente
  private String codp; //Atributo Codigo Postal del cliente
  private String tel; // Atributo Telefono del cliente
  private String tipo; // Atributo para tipo para tabla persona

//Constructor de la clase. 
//Ingresando valores vacion o nulos a los atributos 
//Excepto "tipo" ese atributo sera 'C' ya que en la tabla persona realizara modificacion en personas clientes.
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
  /*Metodo para Insertar Datos del cliente, ingresando en la base de datos tabla Persona Tipo c (Cliente), 
    retorna algun booleano (true o false) para saber si se realizo el metodo, si retorna un true la accion fue con exito, si fue un false
    no inserto nada informacion en la base de datos BEKW*/
  boolean insertar(String nom,String app, String apm, String dom, String codp, String tel) throws ClassNotFoundException, SQLException {
    //Llamando al metodo Conectar para realizar la instancia del sistema con la base de datos BEKW.
    conectar(); 
    //Llama al metodo variables, mandando como parametro los parametros del metodo insertar
    variables(nom,app,apm,dom,codp,tel); 
    /*Llamando al metodo verificar, para ver si los datos ingresados estan correctos y no tener problemas ingresar datos a 
    la Base de datos BEKW si el resultado es un true va entrar a la condicion if si no entra no realizara nada.*/
    if(verificar()){   
    /*Lineas de codigo que se debe realizar para insertar datos a la tabla persona en la base de datos BEKW: */
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=BEKW","sa","123");
        String cad = "INSERT INTO PERSONAS "+"VALUES('"+this.nom+"','"+this.app+"','"+this.apm+"','"+this.dom+"','"+this.codp+"','"+this.tel+"','C')";
        dec = con.createStatement();
        dec.executeUpdate(cad);
        //Excepciones que se realiza en el try
     }catch (SQLException ex) {
         //Mostrar Mensaje Error a la accion de la base de datos BEKW. 
            System.out.println("Error.");  
     }
    //Resultado con exito inserto informacion a la base de datos BEKW en la tabla persona. (Retorna True)
    return true;
    }else
    //Resultado que no realizo nada en la base de datos BEKW (Retorna False).    
    return false;
  }
/*Metodo para Eliminar la informacion cliente, Eliminando en la base de datos tabla Persona con el id seleccionado por el usuario indicado en el sistema, 
    retorna algun booleano (true o false) para saber si se realizo el metodo, si retorna un true la accion fue con exito, si fue un false
    no elimino informacion en la base de datos.*/
  boolean eliminar(String id) throws ClassNotFoundException, SQLException {
    //Llamando al metodo Conectar para realizar la instancia del sistema con la base de datos.  
    conectar();
    // Agregamos al atributo id de la clase con el valor que recibe desde el parametro
    this.id = id;
     /*Lineas de codigo que se debe realizar para eliminar datos a la tabla persona: */
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=BEKW","sa","123");
        String cad = "DELETE FROM PERSONAS WHERE ID_PERSONA='"+this.id+"'";
        dec = con.createStatement();
        dec.executeUpdate(cad);
     //Resultado con exito Elimino informacion a la base de datos en la tabla persona con el id que recibio como parametro el metodo. (Retorna True)
        return true;
     }catch (SQLException ex) {
            System.out.println("Error.");   
     }
    //Resultado que no realizo nada en la base de datos (Retorna False)
    return false;
  }
  /*Metodo para Modificar Datos de cliente, Modifica en la base de datos tabla Persona con el id seleccionado por el usuario indicado en el sistema, 
    retorna algun booleano (true o false) para saber si se realizo el metodo, si retorna un true la accion fue con exito, si fue un false
    no realizo modificaciones en la base de datos.*/
  boolean modificar(String id,String nom,String app, String apm, String dom, String codp, String tel) throws ClassNotFoundException, SQLException {
    //Llamando al metodo Conectar para realizar la instancia del sistema con la base de datos.
    conectar();
    // Agregamos al atributo id de la clase con el valor que recibe desde el parametro.
    this.id = id;
    //Llama al metodo variables, mandando como parametro los parametros del metodo modificar
    variables(nom,app,apm,dom,codp,tel);
    /*Llamando al metodo verificar, para ver si los datos ingresados estan correctos y no tener problemas ingresar datos a 
    la Base de datos si el resultado es un true va entrar a la condicion if si no entra no realizara nada.*/
    if(verificar()){
    /*Lineas de codigo que se debe realizar para Modificar datos a la tabla persona en la base de datos BEKW: */    
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=BEKW","sa","123");
        String cad = "UPDATE PERSONAS SET NOMBRE = '"+this.nom+"',APE_PAT='"+this.app+"',APE_MAT='"+this.apm+"',DOMICILIO='"+this.dom+"',COD_POSTAL='"+this.codp+"',TELEFONO='"+this.tel+"'  WHERE ID_PERSONA ="+this.id;
        dec = con.createStatement();
        dec.executeUpdate(cad);
     }catch (SQLException ex) {
        System.out.println("Error.");   
     }
    //Resultado con exito, modifico informacion a la base de datos BEKW en la tabla persona con el id que recibio como parametro el metodo Modificar. (Retorna True)
    return true;
    }else
    //Resultado que no realizo nada en la base de datos (Retorna False)
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
    /*Metodo Privado que se realiza nomas en la clase BaseDatosCliente, no retorna nada, recibe como parametros los atributos necesarios para
      la tabla persona en la base de datos BEKW.*/
    private void variables(String nom,String app, String apm, String dom, String codp, String tel) {
        //Los atributos reciben el valor que se mandan por el parametro de la clase:
        this.nom = nom;
        this.app = app;
        this.apm = apm;
        this.dom = dom;
        this.codp = codp;
        this.tel = tel;

    }
    /*Metodo Privado que se realiza nomas en la clase BaseDatosCliente, retorna un boleano (true o false), no recibe nada como parametro.
      el objetivo de este metodo es validar los campos si tienen los datos correctos para la tabla persona de la base de datos BEKW y no tener errores.
      si en un campo tiene un error le mandara un mensaje al usuario en que campo tiene datos erroneos.*/
    private boolean verificar() {
        /*Condicion que realiza metodo vCadenasE recibiendo como parametro el atributo nom (nombre cliente), para ver la condicion que almacena el usuario
          si es incorrecto lo que ingreso retorna un false para este metodo verificar*/
          if(!vCadenasE(this.nom)){
              showMessageDialog(null,"Error en el Nombre");
              return false;
          }
          /*Condicion que realiza metodo vCadenas recibiendo como parametro el atributo app (Apellido Paterno del Cliente), 
          para ver la condicion que almacena el usuario si es incorrecto lo que ingreso retorna un false para este metodo verificar*/
          if(!vCadenas(this.app)){
              showMessageDialog(null,"Error en el apellido paterno");
              return false;
          }
          
          /*Condicion que realiza metodo vCadenas recibiendo como parametro el atributo app (Apellido Materno del Cliente), 
          para ver la condicion que almacena el usuario si es incorrecto lo que ingreso retorna un false para este metodo verificar*/
          if(!vCadenas(this.apm)){
              showMessageDialog(null,"Error en el apellido materno");
              return false;
          }
          /*Condicion que realiza metodo vCadenasEN recibiendo como parametro el atributo dom(Domicilio del Cliente), 
          para ver la condicion que almacena el usuario si es incorrecto lo que ingreso retorna un false para este metodo verificar*/
          if(!vCadenasEN(this.dom)){
              showMessageDialog(null,"Error en el domicilio");
              return false;
          }
          /*Condicion que realiza metodo Numeros recibiendo como parametro el atributo codp (Codigo Postal del Cliente), 
          para ver la condicion que almacena el usuario si es incorrecto lo que ingreso retorna un false para este metodo verificar*/
          if(!vNumeros(this.codp)){
              showMessageDialog(null,"Error en el codigo Postal");
              return false;
          }
          /*Condicion que realiza metodo vNumeros recibiendo como parametro el atributo tel (Telefono del Cliente), 
          para ver la condicion que almacena el usuario si es incorrecto lo que ingreso retorna un false para este metodo verificar*/
          if(!vNumeros(this.tel)){
              showMessageDialog(null,"Error en el telefono");
              return false;
          }
          //Retorna un true cuando todos los campos tiene los datos correctos para la tabla persona base de dtaos BEKW.
          return true;
    }
 
       /*Metodo Privado que se realiza nomas en la clase BaseDatosCliente, retorna un boleano (true o false),recibe como parametro una cadena.
      El objetivo de este metodo es validar la cadena que solamente acepta caracteres minusculas,Mayusculas y espacios*/
    private boolean vCadenasE(String cad){
          char [] arrayCad = cad.toCharArray();
          for(int i=0; i < arrayCad.length;i++){
              if(((int) arrayCad[i] < 65 || (int)arrayCad[i] > 90) && ((int)arrayCad[i] < 97 || (int)arrayCad[i] > 122))
                  if((int) arrayCad[i] != 32)
                    return false;             
          }
          return true;
    }
        /*Metodo Privado que se realiza nomas en la clase BaseDatosCliente, retorna un boleano (true o false),recibe como parametro una cadena.
      El objetivo de este metodo es validar la cadena que solamente acepta caracteres minusculas y Mayusculas*/
    private boolean vCadenas(String cad){
          char [] arrayCad = cad.toCharArray();
          for(int i=0; i < arrayCad.length;i++){
              if(((int) arrayCad[i] < 65 || (int)arrayCad[i] > 90) && ((int)arrayCad[i] < 97 || (int)arrayCad[i] > 122))
                    return false;             
          }
          return true;
    }
    /*Metodo Privado que se realiza nomas en la clase BaseDatosCliente, retorna un boleano (true o false),recibe como parametro una cadena.
      El objetivo de este metodo es validar la cadena que solamente acepta caracteres Minusculas,Mayusculas, Espacios y el simbolo #*/
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
    /*Metodo Privado que se realiza nomas en la clase BaseDatosCliente, retorna un boleano (true o false),recibe como parametro una cadena.
      El objetivo de este metodo es validar la cadena que solamente acepta caracteres Digitos*/ 
    private boolean vNumeros(String cad){
          char [] arrayCad = cad.toCharArray();
          for(int i=0; i < arrayCad.length;i++){
              if((int)arrayCad[i] < 48 || (int)arrayCad[i] > 57)
                    return false;             
          }
          return true;
    }
}
