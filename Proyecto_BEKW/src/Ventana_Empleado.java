

import com.placeholder.PlaceHolder;
import java.util.Date;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Ventana funcional para el Dueño.
 * @author BEKW
 */
public class Ventana_Empleado extends javax.swing.JFrame {
        Connection conect = null;
     Statement stmt = null;
     String cad = "";
     ResultSet res = null;
     public int row = 0;
     Login log = new Login();
     int r=0,c=0;
     float s = 0;
     int idCliente=0;
     DefaultTableModel tbmCompra;
     DefaultTableModel tbmMateriaPrima_Compra;
     DefaultTableModel tbmpedido;
     DefaultTableModel tbmVenta;
     int id_usuario=0;
     Date dateAct;
     float efectivo,cambio,SaldoRestante,AdelantoPedido;
     float VENTAS,COMPRAS,ADELANTOS,RELACION;
     String MATERIAPRIMA1,CLIENTE1,PROVEEDOR1,PRODUCTO1;
    /**
     * Creates nueva ventana Ventana_Dueno
     */
    public Ventana_Empleado() {
        
        initComponents();
        setLocationRelativeTo(null);
        seticon();
        this.setBackground(Color.WHITE);
        //this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        setResizable(false);
    }
    
    String nombreUsuario="";
    /**
     * Constructor de Ventana_Dueno.
     * @param nombreUsuario Nombre del usuario ingresado desde el Login.
     */
    public Ventana_Empleado(String nombreUsuario) {
        this.nombreUsuario=nombreUsuario;
        initComponents();
        setLocationRelativeTo(null);
        seticon();
        lblUsuario.setText("Bienvenido, "+this.nombreUsuario);
        //this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        setResizable(false);
    }
    
    CONECTAR_SERVER CS;
    /**
     * Constructor de Ventana_Dueno.
     * @param nombreUsuario Nombre del usuario ingresado desde el Login.
     * @param CS dato CONECTAR_SERVER para conectar con el servidor.
     */
    public Ventana_Empleado(String nombreUsuario,CONECTAR_SERVER CS) {
        this.nombreUsuario=nombreUsuario;
        initComponents();
        setLocationRelativeTo(null);
        seticon();
        lblUsuario.setText("Bienvenido, "+this.nombreUsuario);
        this.CS=CS;
        setResizable(false);
//this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
    }
    /**
     * Constructor de Ventana_Dueno.
     * @param id_usuario ID del usuario.
     * @param nombreUsuario Nombre del usuario ingresao desde el Login.
     * @param CS dato CONECTAR_SERVER para conectar con el servidor.
     */
    public Ventana_Empleado(int id_usuario,String nombreUsuario,CONECTAR_SERVER CS) {
        this.id_usuario=id_usuario;
        this.nombreUsuario=nombreUsuario;
        initComponents();
        setLocationRelativeTo(null);
        seticon();
        lblUsuario.setText("Bienvenido, "+nombreUsuario);
        this.CS=CS;
        setResizable(false);
//this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
    }
    /**
     * Colocar las imagenes en los TABS principales.
     */
    private void colocarImagenesTab(){
        ImageIcon ventas=createImageIcon("/ICON_BAR/coins_48px.png","");
        ImageIcon inventario=createImageIcon("/ICON_BAR/product_48px.png","");
        ImageIcon personas=createImageIcon("/ICON_BAR/persons_48px.png","");
        ImageIcon usuarios=createImageIcon("/ICON_BAR/team_48px.png","");
        ImageIcon balance=createImageIcon("/ICON_BAR/increase_48px.png","");
        
        tb_principal.setIconAt(0, ventas);
        tb_principal.setIconAt(1, inventario);
        tb_principal.setIconAt(2, personas);

        tb_principal.setBackground(Color.WHITE);
    }
    
    /**
     * Función para establecer el icono de los TABS.
     * @param path URL de la imagen.
     * @param description Descripción de la imagen.
     * @return Retorna una imagen.
     */
    protected ImageIcon createImageIcon(String path,
                                           String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
    }
}
    /**
     * Función para establecer conexión con el servidor del a Base de datos.
     * @throws ClassNotFoundException En caso de que no se encuentre la Clase.
     */
    private void conectarBD()throws ClassNotFoundException{
              CS.conectarBD();
              this.conect=CS.getConect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        grupoTipoNuevoProducto = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton25 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        tb_principal = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        tb_PuntoVenta = new javax.swing.JTabbedPane();
        jPanel21 = new javax.swing.JPanel();
        btnAddClienteVentas = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tblClientesVenta = new javax.swing.JTable();
        jLabel74 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblVenta = new javax.swing.JTable();
        btnGenerarVenta = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtBuscarClienteVenta = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblPedidosVentas = new javax.swing.JTable();
        jLabel72 = new javax.swing.JLabel();
        dateGeneracion = new com.toedter.calendar.JDateChooser();
        rdbGeneracion = new javax.swing.JRadioButton();
        rdbEntrega = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnRefreshProducto_Pedido1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        lblAnticipo = new javax.swing.JLabel();
        lblPagoRestante = new javax.swing.JLabel();
        btnCancelarVenta = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        lblTotalVenta1 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        txtEfectivo = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        lblCambio = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblClientes_Pedido = new javax.swing.JTable();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();
        btnEliminarArticuloPedido = new javax.swing.JButton();
        btnGenerarPedido = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtBuscarCliente_Pedido = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        tblProductos_Pedido = new javax.swing.JTable();
        txtBuscarProducto_Pedido = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        btnProductoAPedido = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        btnRefreshProducto_Pedido = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        spncantidadProducto_Pedido = new javax.swing.JSpinner();
        jSeparator5 = new javax.swing.JSeparator();
        btnCancelar_Pedido = new javax.swing.JButton();
        txtAdelantoPedido = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtTotalPedido = new javax.swing.JLabel();
        datePedido = new com.toedter.calendar.JDateChooser();
        jLabel43 = new javax.swing.JLabel();
        txtEfectivoPedido = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        lblCambioPedido = new javax.swing.JLabel();
        panelNuevaCompra = new javax.swing.JPanel();
        btnAgregarProvedor = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        tblProveedor_Compra = new javax.swing.JTable();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblCompra = new javax.swing.JTable();
        btnEliminarMateriaPrima_Compra = new javax.swing.JButton();
        btnGenerarCompra = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtTotalCompra = new javax.swing.JTextField();
        txtBuscarCompras = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        tblCompraslMateriasPrimas = new javax.swing.JTable();
        txtBuscasMateriaPrima_Compras = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        btnNuevaMateriaPrima_Compras = new javax.swing.JButton();
        jLabel86 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        spncantidadMP_Compra = new javax.swing.JSpinner();
        btnRefreshMateriaPrima_Compra = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        btnCancelar_Compra = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblHistorialVentas = new javax.swing.JTable();
        txtBuscarCodigoPedidos1 = new javax.swing.JTextField();
        txtBuscarClientePedidos1 = new javax.swing.JTextField();
        txtBuscarEmpleadoPedidos1 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        dateGeneracionPedido1 = new com.toedter.calendar.JDateChooser();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane22 = new javax.swing.JScrollPane();
        tblDetalleVentas = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblHistorialPedidos = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        rdbPagado = new javax.swing.JRadioButton();
        rdbNoPagado = new javax.swing.JRadioButton();
        txtBuscarCodigoPedidos = new javax.swing.JTextField();
        txtBuscarClientePedidos = new javax.swing.JTextField();
        txtBuscarEmpleadoPedidos = new javax.swing.JTextField();
        dateGeneracionPedido = new com.toedter.calendar.JDateChooser();
        dateEntegaPedidos = new com.toedter.calendar.JDateChooser();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblpruebapedidos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnCancelar_Pedido1 = new javax.swing.JButton();
        rdbCancelar = new javax.swing.JRadioButton();
        panelHistorialCompras = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblHistorialCompras = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        txtBuscarCodigoCompras = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtBuscarProveedorCompras = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblDetalleCompra = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        tb_Inventario = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablaMateriaPrima = new javax.swing.JTable();
        btnCancelarMP = new javax.swing.JButton();
        btnModificarMP = new javax.swing.JButton();
        MP = new javax.swing.JButton();
        btnAgregarMP = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        txtCantidadMP = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        txtDescripcionMP = new javax.swing.JTextArea();
        jLabel68 = new javax.swing.JLabel();
        txtNombreMP = new javax.swing.JTextField();
        cmbUnidadMedidaMP = new javax.swing.JComboBox<>();
        txtEstado = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtPrecioMateriaPrima = new javax.swing.JTextField();
        spnrMP = new javax.swing.JSpinner();
        jButton8 = new javax.swing.JButton();
        txtAgregarPresentacion1 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jLabel61 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnCancelarP = new javax.swing.JButton();
        btnModificarP = new javax.swing.JButton();
        btnAgregarP = new javax.swing.JButton();
        btnEliminarP = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtnomP = new javax.swing.JTextField();
        txtprecioP = new javax.swing.JTextField();
        txtBuscarP = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtdescP = new javax.swing.JTextArea();
        cmbUnidadMedidaProducto = new javax.swing.JComboBox<>();
        txtAgregarPresentacion = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        rdbPorPedido = new javax.swing.JRadioButton();
        rdbNoDisponible = new javax.swing.JRadioButton();
        jButton9 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        tb_Personas = new javax.swing.JTabbedPane();
        panelProveedor = new javax.swing.JPanel();
        txtBuscarProveedor = new javax.swing.JTextField();
        lblTelefonoProveedor = new javax.swing.JLabel();
        lblProveedorBuscar = new javax.swing.JLabel();
        txtProveedorTelefono = new javax.swing.JTextField();
        lblTituloProveedor = new javax.swing.JLabel();
        jScrollPaneProveedores = new javax.swing.JScrollPane();
        tblProveedores = new javax.swing.JTable();
        txtProveedorNombre = new javax.swing.JTextField();
        btnModificarProveedor = new javax.swing.JButton();
        lblNombreProveedor = new javax.swing.JLabel();
        btnEliminarProveedor = new javax.swing.JButton();
        lblDomicilioProveedor = new javax.swing.JLabel();
        btnAgregarProveedor = new javax.swing.JButton();
        txtProveedorDomicilio = new javax.swing.JTextField();
        btnCancelar1 = new javax.swing.JButton();
        txtProveedorCP = new javax.swing.JTextField();
        lblCPProveedor = new javax.swing.JLabel();
        panelCliente = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtNomC = new javax.swing.JTextField();
        txtAPPC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAPMC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnCancelarC = new javax.swing.JButton();
        btnEliminarC = new javax.swing.JButton();
        btnModificarC = new javax.swing.JButton();
        txtDomC = new javax.swing.JTextField();
        txtCPC = new javax.swing.JTextField();
        txtTelC = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCliente = new javax.swing.JTable();
        btnInsertarC = new javax.swing.JButton();
        txtBuscadorC = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        panelUsuarios = new javax.swing.JPanel();
        lblUsuarioTitulo = new javax.swing.JLabel();
        btnUsuariosAgregar = new javax.swing.JButton();
        btnUsuariosCancelar = new javax.swing.JButton();
        btnUsuariosModificar = new javax.swing.JButton();
        btnUsuariosEliminar = new javax.swing.JButton();
        jScrollPaneUsuarios = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        lblUsuario1 = new javax.swing.JLabel();
        lblTipoU = new javax.swing.JLabel();
        lblContra = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtUsuariosUsuario = new javax.swing.JTextField();
        txtUsuariosContraseña = new javax.swing.JTextField();
        txtUsuariosNombre = new javax.swing.JTextField();
        cmbUsuariosTipo = new javax.swing.JComboBox<>();
        panelEstadoResultados = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        lblMateriaVendida = new javax.swing.JLabel();
        lblClienteActivo = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        lblProveedormasCompras = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        lblProductomasVentas = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        lblTotalCompras = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        lblTotalVentas = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        lblTotalAdelantos = new javax.swing.JLabel();
        lblTotalCapital = new javax.swing.JLabel();
        lblTotalEgresos = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        lblTotalIngresos = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Pastelería El Merengue");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 95, -1, -1));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton25.setBackground(new java.awt.Color(255, 255, 255));
        jButton25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/exit30x30.png"))); // NOI18N
        jButton25.setText("Cerrar Sesion");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, 170, 54));

        jLabel3.setFont(new java.awt.Font("Ubuntu Light", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/EL MERENGUEx75.png"))); // NOI18N
        jLabel3.setText("               Empleado");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 563, -1));

        lblUsuario.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("Bienvenido, Usuario");
        jPanel4.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 77));

        tb_principal.setBackground(new java.awt.Color(102, 255, 102));
        tb_principal.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tb_principal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tb_principal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_principalMouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_PuntoVenta.setBackground(new java.awt.Color(255, 204, 204));
        tb_PuntoVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_PuntoVentaMouseClicked(evt);
            }
        });

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddClienteVentas.setBackground(new java.awt.Color(255, 255, 255));
        btnAddClienteVentas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAddClienteVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Add_User30px.png"))); // NOI18N
        btnAddClienteVentas.setText("Agregar Cliente");
        btnAddClienteVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClienteVentasActionPerformed(evt);
            }
        });
        jPanel21.add(btnAddClienteVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 80, -1, 70));
        jPanel21.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(818, 0, 205, -1));

        tblClientesVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre ", "A. Paterno", "A. Materno", "Telefono"
            }
        ));
        tblClientesVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesVentaMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(tblClientesVenta);

        jPanel21.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 530, 90));

        jLabel74.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel74.setText("Nueva Venta");
        jPanel21.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 160, -1));

        jLabel76.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel76.setText("Clientes");
        jPanel21.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        tblVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Producto", "Precio", "Cantidad", "Total"
            }
        ));
        jScrollPane4.setViewportView(tblVenta);

        jPanel21.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 690, 260));

        btnGenerarVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerarVenta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/success30x30.png"))); // NOI18N
        btnGenerarVenta.setText("Generar Venta");
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });
        btnGenerarVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnGenerarVentaKeyTyped(evt);
            }
        });
        jPanel21.add(btnGenerarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 150, 40));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("Total:");
        jPanel21.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, -1, 30));

        txtBuscarClienteVenta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscarClienteVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarClienteVentaMouseClicked(evt);
            }
        });
        txtBuscarClienteVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarClienteVentaActionPerformed(evt);
            }
        });
        txtBuscarClienteVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarClienteVentaKeyReleased(evt);
            }
        });
        jPanel21.add(txtBuscarClienteVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 250, -1));

        jLabel44.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel44.setText("Buscar:");
        jPanel21.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPedidosVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "No. Pedido", "Fecha generación", "Fecha entrega"
            }
        ));
        tblPedidosVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPedidosVentasMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(tblPedidosVentas);

        jPanel14.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 400, 310));

        jLabel72.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel72.setText("Pedidos");
        jPanel14.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        dateGeneracion.setDateFormatString("dd-MM-yyyy");
        dateGeneracion.setMinSelectableDate(new java.util.Date(-62135740700000L));
        jPanel14.add(dateGeneracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 210, -1));

        buttonGroup2.add(rdbGeneracion);
        rdbGeneracion.setSelected(true);
        rdbGeneracion.setText("Fecha Generación");
        jPanel14.add(rdbGeneracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        buttonGroup2.add(rdbEntrega);
        rdbEntrega.setText("Fecha Entrega");
        jPanel14.add(rdbEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        jLabel21.setText("Seleccionar pedido a pagar.");
        jPanel14.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 190, -1));

        btnRefreshProducto_Pedido1.setBackground(new java.awt.Color(255, 255, 255));
        btnRefreshProducto_Pedido1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/update_30px.png"))); // NOI18N
        btnRefreshProducto_Pedido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshProducto_Pedido1ActionPerformed(evt);
            }
        });
        jPanel14.add(btnRefreshProducto_Pedido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 40, -1));

        jPanel21.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 10, 430, 530));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel21.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 20, 560));

        jLabel18.setText("Anticipo:");
        jPanel21.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 470, -1, -1));

        lblAnticipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAnticipo.setText("0.00");
        jPanel21.add(lblAnticipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 470, 60, 20));

        lblPagoRestante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPagoRestante.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPagoRestante.setText("0.00");
        jPanel21.add(lblPagoRestante, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 500, 60, -1));

        btnCancelarVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelarVenta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/error30x30.png"))); // NOI18N
        btnCancelarVenta.setText("Cancelar");
        btnCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVentaActionPerformed(evt);
            }
        });
        jPanel21.add(btnCancelarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel21.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 20, 40));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Saldo restante:");
        jPanel21.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 500, -1, -1));

        lblTotalVenta1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalVenta1.setText("0.00");
        jPanel21.add(lblTotalVenta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 440, 50, -1));
        jPanel21.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, 180, 10));
        jPanel21.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, 190, 20));

        txtEfectivo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtEfectivo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEfectivoFocusLost(evt);
            }
        });
        txtEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEfectivoActionPerformed(evt);
            }
        });
        txtEfectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyTyped(evt);
            }
        });
        jPanel21.add(txtEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 160, -1));

        jLabel41.setText("Efectivo:");
        jPanel21.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, -1, -1));

        jLabel42.setText("Cambio:");
        jPanel21.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, -1, -1));

        lblCambio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCambio.setText("0.00");
        jPanel21.add(lblCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 120, -1));

        tb_PuntoVenta.addTab("Nueva Venta", jPanel21);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Add_User30px.png"))); // NOI18N
        jButton14.setText("Agregar Cliente");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel22.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 80, -1, 60));
        jPanel22.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(818, 0, 205, -1));

        tblClientes_Pedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre ", "A. Paterno", "A. Materno", "Telefono"
            }
        ));
        jScrollPane18.setViewportView(tblClientes_Pedido);

        jPanel22.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 75, 520, 80));

        jLabel78.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel78.setText("Nuevo Pedido");
        jPanel22.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        jLabel79.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel79.setText("Clientes");
        jPanel22.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Producto", "Precio", "Cantidad", "Total"
            }
        ));
        jScrollPane5.setViewportView(tblPedido);

        jPanel22.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 690, 260));

        btnEliminarArticuloPedido.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarArticuloPedido.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEliminarArticuloPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cart-17x30.png"))); // NOI18N
        btnEliminarArticuloPedido.setText("Eliminar artículo");
        btnEliminarArticuloPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarArticuloPedidoActionPerformed(evt);
            }
        });
        jPanel22.add(btnEliminarArticuloPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 160, 40));

        btnGenerarPedido.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerarPedido.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGenerarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/success30x30.png"))); // NOI18N
        btnGenerarPedido.setText("Generar Pedido");
        btnGenerarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPedidoActionPerformed(evt);
            }
        });
        jPanel22.add(btnGenerarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 160, 40));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Total:");
        jPanel22.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 520, -1, 30));

        txtBuscarCliente_Pedido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscarCliente_Pedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarCliente_PedidoKeyReleased(evt);
            }
        });
        jPanel22.add(txtBuscarCliente_Pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 250, -1));

        jLabel45.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel45.setText("Buscar:");
        jPanel22.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProductos_Pedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Estado", "Presentacion", "Precio"
            }
        ));
        jScrollPane20.setViewportView(tblProductos_Pedido);

        jPanel15.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 410, 340));

        txtBuscarProducto_Pedido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscarProducto_Pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarProducto_PedidoActionPerformed(evt);
            }
        });
        txtBuscarProducto_Pedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProducto_PedidotxtBuscarKeyReleased(evt);
            }
        });
        jPanel15.add(txtBuscarProducto_Pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 251, -1));

        jLabel30.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel30.setText("Buscar:");
        jPanel15.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 56, -1));

        btnProductoAPedido.setBackground(new java.awt.Color(255, 255, 255));
        btnProductoAPedido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnProductoAPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cart-16x30.png"))); // NOI18N
        btnProductoAPedido.setText("Añadir a Carrito");
        btnProductoAPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoAPedidojButton11ActionPerformed(evt);
            }
        });
        jPanel15.add(btnProductoAPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, -1, 50));

        jLabel85.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel85.setText("Productos");
        jPanel15.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        btnRefreshProducto_Pedido.setBackground(new java.awt.Color(255, 255, 255));
        btnRefreshProducto_Pedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/update_30px.png"))); // NOI18N
        btnRefreshProducto_Pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshProducto_PedidoActionPerformed(evt);
            }
        });
        jPanel15.add(btnRefreshProducto_Pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 40, -1));
        jPanel15.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 48, 371, 10));

        spncantidadProducto_Pedido.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        spncantidadProducto_Pedido.setValue(1);
        spncantidadProducto_Pedido.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spncantidadProducto_PedidoStateChanged(evt);
            }
        });
        jPanel15.add(spncantidadProducto_Pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 50, 30));

        jPanel22.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 430, 550));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel22.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 10, 40));

        btnCancelar_Pedido.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar_Pedido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelar_Pedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/error30x30.png"))); // NOI18N
        btnCancelar_Pedido.setText("Cancelar");
        btnCancelar_Pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar_PedidoActionPerformed(evt);
            }
        });
        jPanel22.add(btnCancelar_Pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        txtAdelantoPedido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAdelantoPedido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtAdelantoPedido.setText("0");
        txtAdelantoPedido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAdelantoPedidoFocusLost(evt);
            }
        });
        txtAdelantoPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAdelantoPedidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAdelantoPedidoKeyTyped(evt);
            }
        });
        jPanel22.add(txtAdelantoPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 480, 90, 30));

        jLabel12.setText("Anticipo:");
        jPanel22.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, -1, -1));

        jLabel17.setText("Fecha de Entrega");
        jPanel22.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, -1, -1));

        txtTotalPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtTotalPedido.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotalPedido.setText("0.00");
        jPanel22.add(txtTotalPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 530, 120, -1));

        datePedido.setDateFormatString("dd-MM-yyyy");
        jPanel22.add(datePedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 450, 130, -1));

        jLabel43.setText("Efectivo:");
        jPanel22.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, -1, -1));

        txtEfectivoPedido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtEfectivoPedido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEfectivoPedidoFocusLost(evt);
            }
        });
        txtEfectivoPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEfectivoPedidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEfectivoPedidoKeyTyped(evt);
            }
        });
        jPanel22.add(txtEfectivoPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, 160, -1));

        jLabel47.setText("Cambio:");
        jPanel22.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, -1, -1));

        lblCambioPedido.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCambioPedido.setText("0.00");
        jPanel22.add(lblCambioPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 530, 120, -1));

        tb_PuntoVenta.addTab("Nuevo Pedido", jPanel22);

        panelNuevaCompra.setBackground(new java.awt.Color(255, 255, 255));

        btnAgregarProvedor.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarProvedor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAgregarProvedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Add_User30px.png"))); // NOI18N
        btnAgregarProvedor.setText("Agregar Proveedor");
        btnAgregarProvedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProvedorActionPerformed(evt);
            }
        });

        tblProveedor_Compra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", "", ""}
            },
            new String [] {
                "Código", "Nombre ", "Domicilio", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane19.setViewportView(tblProveedor_Compra);

        jLabel82.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel82.setText("Nueva Compra");

        jLabel83.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel83.setText("Provedor");

        tblCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Materia", "Cantidad", "Precio", "Total"
            }
        ));
        jScrollPane6.setViewportView(tblCompra);

        btnEliminarMateriaPrima_Compra.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarMateriaPrima_Compra.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEliminarMateriaPrima_Compra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cart-17x30.png"))); // NOI18N
        btnEliminarMateriaPrima_Compra.setText("Eliminar artículo");
        btnEliminarMateriaPrima_Compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMateriaPrima_CompraActionPerformed(evt);
            }
        });

        btnGenerarCompra.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerarCompra.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGenerarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/success30x30.png"))); // NOI18N
        btnGenerarCompra.setText("Generar Compra");
        btnGenerarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarCompraActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText("Total:");

        txtTotalCompra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTotalCompra.setText("0");
        txtTotalCompra.setEnabled(false);
        txtTotalCompra.setFocusable(false);

        txtBuscarCompras.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscarCompras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarComprasKeyReleased(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel46.setText("Buscar:");

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblCompraslMateriasPrimas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Materia Prima", "Existencia", "Precio"
            }
        ));
        jScrollPane21.setViewportView(tblCompraslMateriasPrimas);

        jPanel16.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 360, 360));

        txtBuscasMateriaPrima_Compras.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscasMateriaPrima_Compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscasMateriaPrima_ComprasActionPerformed(evt);
            }
        });
        txtBuscasMateriaPrima_Compras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscasMateriaPrima_ComprasKeyTyped(evt);
            }
        });
        jPanel16.add(txtBuscasMateriaPrima_Compras, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 260, -1));

        jLabel31.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel31.setText("Buscar:");
        jPanel16.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 20));

        btnNuevaMateriaPrima_Compras.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevaMateriaPrima_Compras.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnNuevaMateriaPrima_Compras.setText("Nueva Materia Prima");
        btnNuevaMateriaPrima_Compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaMateriaPrima_ComprasActionPerformed(evt);
            }
        });
        jPanel16.add(btnNuevaMateriaPrima_Compras, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, 30));

        jLabel86.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel86.setText("Materia Prima");
        jPanel16.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 30));

        jButton20.setBackground(new java.awt.Color(255, 255, 255));
        jButton20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cart-16x30.png"))); // NOI18N
        jButton20.setText("Añadir a Carrito");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, -1, 56));

        spncantidadMP_Compra.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        spncantidadMP_Compra.setValue(1);
        spncantidadMP_Compra.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spncantidadMP_CompraStateChanged(evt);
            }
        });
        jPanel16.add(spncantidadMP_Compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, 44, 31));

        btnRefreshMateriaPrima_Compra.setBackground(new java.awt.Color(255, 255, 255));
        btnRefreshMateriaPrima_Compra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/update_30px.png"))); // NOI18N
        btnRefreshMateriaPrima_Compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshMateriaPrima_CompraActionPerformed(evt);
            }
        });
        jPanel16.add(btnRefreshMateriaPrima_Compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 40, -1));
        jPanel16.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 380, 10));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnCancelar_Compra.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar_Compra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelar_Compra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/error30x30.png"))); // NOI18N
        btnCancelar_Compra.setText("Cancelar");
        btnCancelar_Compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar_CompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNuevaCompraLayout = new javax.swing.GroupLayout(panelNuevaCompra);
        panelNuevaCompra.setLayout(panelNuevaCompraLayout);
        panelNuevaCompraLayout.setHorizontalGroup(
            panelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevaCompraLayout.createSequentialGroup()
                .addGap(818, 818, 818)
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelNuevaCompraLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelNuevaCompraLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnCancelar_Compra, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarMateriaPrima_Compra)
                        .addGap(32, 32, 32)
                        .addComponent(btnGenerarCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelNuevaCompraLayout.createSequentialGroup()
                        .addComponent(jLabel83)
                        .addGap(249, 249, 249)
                        .addComponent(jLabel82))
                    .addGroup(panelNuevaCompraLayout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(62, 62, 62)
                        .addComponent(txtBuscarCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelNuevaCompraLayout.createSequentialGroup()
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregarProvedor))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelNuevaCompraLayout.setVerticalGroup(
            panelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevaCompraLayout.createSequentialGroup()
                .addComponent(jLabel81)
                .addGap(10, 10, 10)
                .addGroup(panelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelNuevaCompraLayout.createSequentialGroup()
                        .addGroup(panelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelNuevaCompraLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel83))
                            .addComponent(jLabel82))
                        .addGap(8, 8, 8)
                        .addGroup(panelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(txtBuscarCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(panelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNuevaCompraLayout.createSequentialGroup()
                                .addComponent(btnAgregarProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)))
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(panelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnGenerarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminarMateriaPrima_Compra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator4)
                            .addComponent(btnCancelar_Compra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tb_PuntoVenta.addTab("Nueva Compra", panelNuevaCompra);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblHistorialVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Fecha Venta", "Cliente", "Empleado", "Total"
            }
        ));
        tblHistorialVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHistorialVentasMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tblHistorialVentas);

        jLabel37.setText("Empleado");

        jLabel38.setText("Fecha Generacion");

        dateGeneracionPedido1.setDateFormatString("dd-MM-yyyy");

        jLabel39.setText("Código");

        jLabel40.setText("Cliente");

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Search30px.png"))); // NOI18N
        jButton6.setText("Buscar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton7.setText("Limpiar busqueda");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        tblDetalleVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Precio unitario", "Presentacion", "Total"
            }
        ));
        jScrollPane22.setViewportView(tblDetalleVentas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscarCodigoPedidos1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel40)
                                    .addComponent(txtBuscarClientePedidos1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuscarEmpleadoPedidos1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateGeneracionPedido1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel37))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateGeneracionPedido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBuscarCodigoPedidos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40)
                                    .addComponent(jLabel37))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBuscarClientePedidos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBuscarEmpleadoPedidos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jButton6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton7))
                                    .addComponent(jLabel38))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tb_PuntoVenta.addTab("Historial deVentas", jPanel1);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        tblHistorialPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Fecha_Pedio", "Fecha Entrega", "Cliente", "Empleado", "Estado", "Adelanto", "Total", "Saldo Restante"
            }
        ));
        tblHistorialPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHistorialPedidosMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblHistorialPedidos);

        jLabel29.setText("Código");

        jLabel32.setText("Fecha Generación");

        jLabel33.setText("Fecha Entrega");

        jLabel34.setText("Cliente");

        jLabel35.setText("Empleado");

        jLabel36.setText("Estado");

        buttonGroup3.add(rdbPagado);
        rdbPagado.setText("Pagado");

        buttonGroup3.add(rdbNoPagado);
        rdbNoPagado.setText("No Pagado");

        dateGeneracionPedido.setDateFormatString("dd-MM-yyyy");

        dateEntegaPedidos.setDateFormatString("dd-MM-yyyy");

        tblpruebapedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Precio unitario", "Presentacion", "Total"
            }
        ));
        jScrollPane11.setViewportView(tblpruebapedidos);

        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Search30px.png"))); // NOI18N
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setText("Limpiar busqueda");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnCancelar_Pedido1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelar_Pedido1.setText("Cancelar pedido"); // NOI18N
        btnCancelar_Pedido1.setActionCommand("Cancelar \nPedido");
        btnCancelar_Pedido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar_Pedido1ActionPerformed(evt);
            }
        });

        buttonGroup3.add(rdbCancelar);
        rdbCancelar.setText("Cancelado");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addGap(106, 106, 106)
                                        .addComponent(jLabel32))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(txtBuscarCodigoPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(dateGeneracionPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel33))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(dateEntegaPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuscarClientePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34))
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtBuscarEmpleadoPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel35)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(rdbPagado)
                                        .addGap(2, 2, 2)
                                        .addComponent(rdbNoPagado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdbCancelar)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancelar_Pedido1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dateGeneracionPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtBuscarCodigoPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel35)
                                            .addComponent(jLabel34)
                                            .addComponent(jLabel36)))
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(dateEntegaPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBuscarClientePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBuscarEmpleadoPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar_Pedido1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdbPagado)
                                    .addComponent(rdbNoPagado)
                                    .addComponent(rdbCancelar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane11))
                .addContainerGap())
        );

        tb_PuntoVenta.addTab("Historial de Pedidos", jPanel13);

        panelHistorialCompras.setBackground(new java.awt.Color(255, 255, 255));

        tblHistorialCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Fecha", "Proveedor", "Total"
            }
        ));
        tblHistorialCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHistorialComprasMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblHistorialCompras);

        jLabel22.setText("Código");

        jLabel25.setText("Proveedor");

        jLabel28.setText("Fecha");

        jDateChooser1.setDateFormatString("dd-MM-yyyy");

        tblDetalleCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Materia Prima", "Cantidad", "Precio Unitario", "Presentacion", "Total"
            }
        ));
        jScrollPane10.setViewportView(tblDetalleCompra);

        jButton4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Search30px.png"))); // NOI18N
        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton5.setText("Limpiar busqueda");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHistorialComprasLayout = new javax.swing.GroupLayout(panelHistorialCompras);
        panelHistorialCompras.setLayout(panelHistorialComprasLayout);
        panelHistorialComprasLayout.setHorizontalGroup(
            panelHistorialComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHistorialComprasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHistorialComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHistorialComprasLayout.createSequentialGroup()
                        .addGroup(panelHistorialComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelHistorialComprasLayout.createSequentialGroup()
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelHistorialComprasLayout.createSequentialGroup()
                                .addGroup(panelHistorialComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel22))
                                .addGap(134, 134, 134)
                                .addGroup(panelHistorialComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelHistorialComprasLayout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(panelHistorialComprasLayout.createSequentialGroup()
                                        .addComponent(txtBuscarProveedorCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(120, 120, 120)
                                        .addGroup(panelHistorialComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(9, 9, 9))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarCodigoCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        panelHistorialComprasLayout.setVerticalGroup(
            panelHistorialComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHistorialComprasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelHistorialComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelHistorialComprasLayout.createSequentialGroup()
                        .addGroup(panelHistorialComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelHistorialComprasLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelHistorialComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBuscarCodigoCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBuscarProveedorCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28))
                            .addGroup(panelHistorialComprasLayout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelHistorialComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane10))
                .addGap(23, 23, 23))
        );

        tb_PuntoVenta.addTab("Historial de Compras", panelHistorialCompras);

        jPanel6.add(tb_PuntoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1170, 600));

        tb_principal.addTab("Punto de venta", jPanel6);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaMateriaPrima.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Descripción", "Cantidad disponible", "Unidad de medida", "Precio unitario"
            }
        ));
        tablaMateriaPrima.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMateriaPrimaMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tablaMateriaPrima);

        jPanel8.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 620, 370));

        btnCancelarMP.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelarMP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelarMP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/error30x30.png"))); // NOI18N
        btnCancelarMP.setText("Cancelar");
        btnCancelarMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarMPActionPerformed(evt);
            }
        });
        jPanel8.add(btnCancelarMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 154, 36));

        btnModificarMP.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarMP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnModificarMP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit30x30.png"))); // NOI18N
        btnModificarMP.setText("Modificar");
        btnModificarMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarMPActionPerformed(evt);
            }
        });
        jPanel8.add(btnModificarMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 165, 36));

        MP.setBackground(new java.awt.Color(255, 255, 255));
        MP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        MP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/garbage-1x30.png"))); // NOI18N
        MP.setText("Eliminar");
        MP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MPActionPerformed(evt);
            }
        });
        jPanel8.add(MP, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 165, 36));

        btnAgregarMP.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarMP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAgregarMP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus30x30.png"))); // NOI18N
        btnAgregarMP.setText("Agregar");
        btnAgregarMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMPActionPerformed(evt);
            }
        });
        jPanel8.add(btnAgregarMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 154, 36));

        jLabel56.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel56.setText("Materia Prima");
        jPanel8.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel64.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel64.setText("Presentacion:");
        jPanel8.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        txtCantidadMP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel8.add(txtCantidadMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 150, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Nombre:");
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Descripción:");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        txtDescripcionMP.setColumns(20);
        txtDescripcionMP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDescripcionMP.setLineWrap(true);
        txtDescripcionMP.setRows(5);
        jScrollPane13.setViewportView(txtDescripcionMP);

        jPanel8.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 240, 90));

        jLabel68.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel68.setText("Cantidad disponible:");
        jPanel8.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        txtNombreMP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombreMP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreMPKeyTyped(evt);
            }
        });
        jPanel8.add(txtNombreMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 230, -1));

        cmbUnidadMedidaMP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel8.add(cmbUnidadMedidaMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 180, -1));

        txtEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEstado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel8.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 620, 20));

        jLabel19.setText("Precio:");
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        txtPrecioMateriaPrima.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPrecioMateriaPrima.setText("0");
        txtPrecioMateriaPrima.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioMateriaPrimaFocusLost(evt);
            }
        });
        txtPrecioMateriaPrima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioMateriaPrimaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioMateriaPrimaKeyTyped(evt);
            }
        });
        jPanel8.add(txtPrecioMateriaPrima, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 180, -1));

        spnrMP.setValue(1);
        spnrMP.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnrMPStateChanged(evt);
            }
        });
        jPanel8.add(spnrMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 490, -1, -1));

        jButton8.setText("Retirar Materia Prima");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, 150, 40));

        txtAgregarPresentacion1.setText(" ");
        txtAgregarPresentacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgregarPresentacion1ActionPerformed(evt);
            }
        });
        txtAgregarPresentacion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAgregarPresentacion1KeyTyped(evt);
            }
        });
        jPanel8.add(txtAgregarPresentacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 490, 150, 30));

        jButton10.setText("+");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 490, 40, 30));

        jLabel69.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel69.setText("Agregar nueva presentacion:");
        jPanel8.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        tb_Inventario.addTab("Materia Prima", jPanel8);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Descripcion", "Tipo", "Presentacion", "Precio"
            }
        ));
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tblProducto);

        jPanel17.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 600, 450));

        jLabel61.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel61.setText("Producto");
        jPanel17.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setText("Nombre Producto:");
        jPanel17.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setText("Descripción:");
        jPanel17.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        btnCancelarP.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelarP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/error30x30.png"))); // NOI18N
        btnCancelarP.setText("Cancelar");
        btnCancelarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPActionPerformed(evt);
            }
        });
        jPanel17.add(btnCancelarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 140, 40));

        btnModificarP.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnModificarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit30x30.png"))); // NOI18N
        btnModificarP.setText("Modificar");
        btnModificarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPActionPerformed(evt);
            }
        });
        jPanel17.add(btnModificarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 150, 40));

        btnAgregarP.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAgregarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus30x30.png"))); // NOI18N
        btnAgregarP.setText("Agregar");
        btnAgregarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPActionPerformed(evt);
            }
        });
        jPanel17.add(btnAgregarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 140, 40));

        btnEliminarP.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEliminarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/garbage-1x30.png"))); // NOI18N
        btnEliminarP.setText("Eliminar");
        btnEliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPActionPerformed(evt);
            }
        });
        jPanel17.add(btnEliminarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 150, 40));

        jLabel65.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel65.setText("Tipo:");
        jPanel17.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        jLabel66.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel66.setText("Precio");
        jPanel17.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setText("Presentacion:");
        jPanel17.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        txtnomP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel17.add(txtnomP, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 152, -1));

        txtprecioP.setText(" ");
        txtprecioP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtprecioPFocusLost(evt);
            }
        });
        txtprecioP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprecioPKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioPKeyTyped(evt);
            }
        });
        jPanel17.add(txtprecioP, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 150, 23));

        txtBuscarP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscarP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPKeyReleased(evt);
            }
        });
        jPanel17.add(txtBuscarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 295, -1));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel27.setText("Buscar:");
        jPanel17.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        txtdescP.setColumns(20);
        txtdescP.setLineWrap(true);
        txtdescP.setRows(5);
        jScrollPane3.setViewportView(txtdescP);

        jPanel17.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 270, -1));

        cmbUnidadMedidaProducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel17.add(cmbUnidadMedidaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 180, -1));

        txtAgregarPresentacion.setText(" ");
        txtAgregarPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgregarPresentacionActionPerformed(evt);
            }
        });
        txtAgregarPresentacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAgregarPresentacionKeyTyped(evt);
            }
        });
        jPanel17.add(txtAgregarPresentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 150, 30));

        jLabel67.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel67.setText("Agregar presentacion:");
        jPanel17.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, -1, -1));

        grupoTipoNuevoProducto.add(rdbPorPedido);
        rdbPorPedido.setSelected(true);
        rdbPorPedido.setText("Por Pedido");
        jPanel17.add(rdbPorPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, -1));

        grupoTipoNuevoProducto.add(rdbNoDisponible);
        rdbNoDisponible.setText("No disponible");
        jPanel17.add(rdbNoDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        jButton9.setText("+");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, 40, 30));

        tb_Inventario.addTab("Producto", jPanel17);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(tb_Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 1146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(tb_Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        tb_principal.addTab("Inventario", jPanel5);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelProveedor.setBackground(new java.awt.Color(255, 255, 255));

        txtBuscarProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProveedorKeyReleased(evt);
            }
        });

        lblTelefonoProveedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTelefonoProveedor.setText("Teléfono:");

        lblProveedorBuscar.setText("Buscar:");

        txtProveedorTelefono.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtProveedorTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProveedorTelefonoKeyTyped(evt);
            }
        });

        lblTituloProveedor.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTituloProveedor.setText("Proveedor");

        tblProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Proveedor", "Domicilio", "Código_Postal", "Telefono"
            }
        ));
        tblProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedoresMouseClicked(evt);
            }
        });
        jScrollPaneProveedores.setViewportView(tblProveedores);

        txtProveedorNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtProveedorNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProveedorNombreKeyTyped(evt);
            }
        });

        btnModificarProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarProveedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnModificarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit30x30.png"))); // NOI18N
        btnModificarProveedor.setText("Modificar");
        btnModificarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProveedorActionPerformed(evt);
            }
        });

        lblNombreProveedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNombreProveedor.setText("Nombre:");

        btnEliminarProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarProveedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEliminarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/garbage-1x30.png"))); // NOI18N
        btnEliminarProveedor.setText("Eliminar");
        btnEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProveedorActionPerformed(evt);
            }
        });

        lblDomicilioProveedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDomicilioProveedor.setText("Domicilio:");

        btnAgregarProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarProveedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAgregarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus30x30.png"))); // NOI18N
        btnAgregarProveedor.setText("Agregar");
        btnAgregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProveedorActionPerformed(evt);
            }
        });

        txtProveedorDomicilio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnCancelar1.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/error30x30.png"))); // NOI18N
        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        txtProveedorCP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtProveedorCP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProveedorCPKeyTyped(evt);
            }
        });

        lblCPProveedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCPProveedor.setText("C.P:");

        javax.swing.GroupLayout panelProveedorLayout = new javax.swing.GroupLayout(panelProveedor);
        panelProveedor.setLayout(panelProveedorLayout);
        panelProveedorLayout.setHorizontalGroup(
            panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProveedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblProveedorBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178))
            .addGroup(panelProveedorLayout.createSequentialGroup()
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProveedorLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancelar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnModificarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelProveedorLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTituloProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelProveedorLayout.createSequentialGroup()
                                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDomicilioProveedor)
                                    .addComponent(lblNombreProveedor)
                                    .addComponent(lblCPProveedor)
                                    .addComponent(lblTelefonoProveedor))
                                .addGap(18, 18, 18)
                                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtProveedorCP, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProveedorTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProveedorDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProveedorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(146, 146, 146)))
                .addComponent(jScrollPaneProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        panelProveedorLayout.setVerticalGroup(
            panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProveedorLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProveedorBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProveedorLayout.createSequentialGroup()
                        .addComponent(lblTituloProveedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreProveedor)
                            .addComponent(txtProveedorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDomicilioProveedor)
                            .addComponent(txtProveedorDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProveedorCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCPProveedor))
                        .addGap(18, 18, 18)
                        .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProveedorTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefonoProveedor))
                        .addGap(27, 27, 27)
                        .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(129, 129, 129))
                    .addGroup(panelProveedorLayout.createSequentialGroup()
                        .addComponent(jScrollPaneProveedores)
                        .addContainerGap())))
        );

        tb_Personas.addTab("Proveedor", panelProveedor);

        panelCliente.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNomC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel7.add(txtNomC, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 234, -1));

        txtAPPC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel7.add(txtAPPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 120, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Nombre:");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Apellido Materno: ");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        txtAPMC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtAPMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAPMCActionPerformed(evt);
            }
        });
        jPanel7.add(txtAPMC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 118, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Domicilio:");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("C.P:");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Telefono:");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, 20));

        btnCancelarC.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelarC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/error30x30.png"))); // NOI18N
        btnCancelarC.setText("Cancelar");
        btnCancelarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCActionPerformed(evt);
            }
        });
        jPanel7.add(btnCancelarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 130, 40));

        btnEliminarC.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEliminarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/garbage-1x30.png"))); // NOI18N
        btnEliminarC.setText("Eliminar");
        btnEliminarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCActionPerformed(evt);
            }
        });
        jPanel7.add(btnEliminarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 140, 40));

        btnModificarC.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnModificarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit30x30.png"))); // NOI18N
        btnModificarC.setText("Modificar");
        btnModificarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCActionPerformed(evt);
            }
        });
        jPanel7.add(btnModificarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 140, 40));

        txtDomC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDomC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDomCActionPerformed(evt);
            }
        });
        jPanel7.add(txtDomC, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 231, -1));

        txtCPC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPCActionPerformed(evt);
            }
        });
        txtCPC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCPCKeyTyped(evt);
            }
        });
        jPanel7.add(txtCPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 140, -1));

        txtTelC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTelC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelCActionPerformed(evt);
            }
        });
        txtTelC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelCKeyTyped(evt);
            }
        });
        jPanel7.add(txtTelC, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 136, 30));

        tablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Apellido Paterno", "Apellido Materno", "Domicilio", "Codigo Postal", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaCliente);

        jPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 700, 360));

        btnInsertarC.setBackground(new java.awt.Color(255, 255, 255));
        btnInsertarC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnInsertarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus30x30.png"))); // NOI18N
        btnInsertarC.setText("Agregar");
        btnInsertarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarCActionPerformed(evt);
            }
        });
        jPanel7.add(btnInsertarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 130, 40));

        txtBuscadorC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtBuscadorC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorCActionPerformed(evt);
            }
        });
        txtBuscadorC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscadorCKeyTyped(evt);
            }
        });
        jPanel7.add(txtBuscadorC, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 310, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Buscar:");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, -1, 20));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel10.setText("Cliente");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Apellido Paterno: ");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        javax.swing.GroupLayout panelClienteLayout = new javax.swing.GroupLayout(panelCliente);
        panelCliente.setLayout(panelClienteLayout);
        panelClienteLayout.setHorizontalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1155, Short.MAX_VALUE)
            .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelClienteLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
        panelClienteLayout.setVerticalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
            .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelClienteLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );

        tb_Personas.addTab("Cliente", panelCliente);

        jPanel9.add(tb_Personas, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 23, 1160, -1));

        tb_principal.addTab("Personas", jPanel9);

        panelUsuarios.setBackground(new java.awt.Color(255, 255, 255));

        lblUsuarioTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblUsuarioTitulo.setText("Usuarios");

        btnUsuariosAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnUsuariosAgregar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnUsuariosAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus30x30.png"))); // NOI18N
        btnUsuariosAgregar.setText("Agregar");
        btnUsuariosAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosAgregarActionPerformed(evt);
            }
        });

        btnUsuariosCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnUsuariosCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnUsuariosCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/error30x30.png"))); // NOI18N
        btnUsuariosCancelar.setText("Cancelar");
        btnUsuariosCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosCancelarActionPerformed(evt);
            }
        });

        btnUsuariosModificar.setBackground(new java.awt.Color(255, 255, 255));
        btnUsuariosModificar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnUsuariosModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit30x30.png"))); // NOI18N
        btnUsuariosModificar.setText("Modificar");
        btnUsuariosModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosModificarActionPerformed(evt);
            }
        });

        btnUsuariosEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnUsuariosEliminar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnUsuariosEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/garbage-1x30.png"))); // NOI18N
        btnUsuariosEliminar.setText("Eliminar");
        btnUsuariosEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosEliminarActionPerformed(evt);
            }
        });

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuario", "Tipo_Usuario", "Contraseña", "Nombre"
            }
        ));
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPaneUsuarios.setViewportView(tblUsuarios);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario1.setText("Usuario:");
        jPanel12.add(lblUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        lblTipoU.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTipoU.setText("Tipo Usuario:");
        jPanel12.add(lblTipoU, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        lblContra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblContra.setText("Contraseña:");
        jPanel12.add(lblContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        lblNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNombre.setText("Nombre:");
        jPanel12.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, -1, -1));

        txtUsuariosUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtUsuariosUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuariosUsuarioKeyTyped(evt);
            }
        });
        jPanel12.add(txtUsuariosUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 130, -1));

        txtUsuariosContraseña.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtUsuariosContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuariosContraseñaKeyTyped(evt);
            }
        });
        jPanel12.add(txtUsuariosContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 130, -1));

        txtUsuariosNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtUsuariosNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuariosNombreKeyTyped(evt);
            }
        });
        jPanel12.add(txtUsuariosNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 170, -1));

        cmbUsuariosTipo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbUsuariosTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "EMPLEADO", "DUEÑO" }));
        cmbUsuariosTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUsuariosTipoActionPerformed(evt);
            }
        });
        jPanel12.add(cmbUsuariosTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 170, -1));

        javax.swing.GroupLayout panelUsuariosLayout = new javax.swing.GroupLayout(panelUsuarios);
        panelUsuarios.setLayout(panelUsuariosLayout);
        panelUsuariosLayout.setHorizontalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuariosLayout.createSequentialGroup()
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUsuariosLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelUsuariosLayout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUsuariosCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUsuariosAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUsuariosModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUsuariosEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelUsuariosLayout.createSequentialGroup()
                        .addGap(436, 436, 436)
                        .addComponent(lblUsuarioTitulo)))
                .addContainerGap(408, Short.MAX_VALUE))
        );
        panelUsuariosLayout.setVerticalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuariosLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblUsuarioTitulo)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jScrollPaneUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUsuariosCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuariosModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUsuariosAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuariosEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(207, Short.MAX_VALUE))
        );

        tb_principal.addTab("Usuarios", panelUsuarios);

        panelEstadoResultados.setBackground(new java.awt.Color(255, 255, 255));
        panelEstadoResultados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/print30.png"))); // NOI18N
        jButton11.setText("Imprimir Estado de Resultados");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        panelEstadoResultados.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 450, 320, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/EL MERENGUEx400.png"))); // NOI18N
        panelEstadoResultados.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 420, 390));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMateriaVendida.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMateriaVendida.setText("Materia Prima mas comprada");
        jPanel19.add(lblMateriaVendida, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        lblClienteActivo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblClienteActivo.setText("Cliente");
        jPanel19.add(lblClienteActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));

        jLabel59.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel59.setText("Cliente más activo:");
        jPanel19.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 140, -1));

        jLabel60.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel60.setText("Producto más vendido:");
        jPanel19.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 170, -1));

        lblProveedormasCompras.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblProveedormasCompras.setText("Proveedor");
        jPanel19.add(lblProveedormasCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        jLabel62.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel62.setText("Materia Prima más comprada:");
        jPanel19.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 210, -1));

        jLabel70.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel70.setText("Proveedor con más compras:");
        jPanel19.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 210, -1));

        lblProductomasVentas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblProductomasVentas.setText("Producto más vendido");
        jPanel19.add(lblProductomasVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        panelEstadoResultados.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 500, 180));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel48.setText("Egresos");
        jPanel20.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        jLabel49.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel49.setText("Ingresos");
        jPanel20.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        lblTotalCompras.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTotalCompras.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalCompras.setText("TotalCompras");
        jPanel20.add(lblTotalCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 110, -1));

        jLabel51.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel51.setText("Ventas:");
        jPanel20.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        lblTotalVentas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTotalVentas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalVentas.setText("Total Ventas");
        jPanel20.add(lblTotalVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 120, 20));

        jLabel54.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel54.setText("Adelantos:");
        jPanel20.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        lblTotalAdelantos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTotalAdelantos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalAdelantos.setText("TotalAdelantos");
        jPanel20.add(lblTotalAdelantos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 120, -1));

        lblTotalCapital.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTotalCapital.setText("TotalCapital");
        jPanel20.add(lblTotalCapital, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, -1, -1));

        lblTotalEgresos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTotalEgresos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalEgresos.setText("Total Egresos");
        jPanel20.add(lblTotalEgresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 120, -1));

        jLabel63.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel63.setText("Capital:");
        jPanel20.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        lblTotalIngresos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTotalIngresos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalIngresos.setText("Total Ingresos");
        jPanel20.add(lblTotalIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 110, -1));

        jLabel71.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel71.setText("Compras:");
        jPanel20.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));
        jPanel20.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 230, 10));

        panelEstadoResultados.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 500, 330));

        tb_principal.addTab("Estado de Resultados", panelEstadoResultados);

        getContentPane().add(tb_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Llena la tabla de Materia Prima en el Tab Materia Prima.
     * @throws ClassNotFoundException En caso de que no se enuentre la clase.
     */
    private void llenarMateriaPrima() throws ClassNotFoundException{
        try {
             
           Statement stmt = conect.createStatement();
           DefaultTableModel tbm=(DefaultTableModel)tablaMateriaPrima.getModel();
           tbm.setRowCount(0);
           res=stmt.executeQuery("select * from MATERIAS_PRIMAS");
             if(null!=res){
                while(res.next()){
                   tbm.addRow(new Object[]{res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getInt("PRECIO")});
                }  
            }
            stmt.close();
        }catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en la conexion LLENAR TABLA Materia Prima");
        } 
    }
    /**
     * Llena la tabla de Compra en Nueva compra.
     */
    private void llenarTablaCompra(){
        tbmCompra=(DefaultTableModel)tblCompra.getModel();
    }  
    /**
     * Llena la tabla de Pedidos en Nuevo Pedido.
     */
    private void llenarTablaPedidos(){
        tbmpedido=(DefaultTableModel)tblPedido.getModel();
    } 
    /**
     * Llenar la tabla de Venta en Nueva Venta.
     */
    private void LlenarTablaVenta(){
        tbmVenta = (DefaultTableModel)tblVenta.getModel();
    }
    /**
     * Llena la tabla de proveedores en el Tab Proveedores.
     * @throws ClassNotFoundException 
     */
    private void LlenarTablaProveedores() throws ClassNotFoundException{
         try {
             //conectarBD();
             stmt=conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblProveedores.getModel();
           tbm.setRowCount(0);
           
            res=stmt.executeQuery("select * from PERSONAS where TIPO = 'P'");
            if(null!=res){
                while(res.next()){
                   tbm.addRow(new Object[]{res.getInt(1),res.getString(2),res.getString(5),res.getString(6),res.getString(7)});
                }  
            }
            stmt.close();
        }catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en la conexion LLENAR TABLA");
        } 
    }
    /**
     * Llena la tabla de Productos en el Tab Producto.
     * @throws ClassNotFoundException En caso de que no se encuentre la clase.
     */
    private void LlenarTablaP() throws ClassNotFoundException{
         try {
             
           stmt = conect.createStatement();
           DefaultTableModel tbm=(DefaultTableModel)tblProducto.getModel();
           tbm.setRowCount(0);
           res=stmt.executeQuery("select * from PRODUCTOS WHERE TIPO = 'N' OR TIPO = 'P'");
            if(null!=res){
                while(res.next()){
                   Vector rowProductos=new Vector();
                  String tipo;
                  if(res.getString("TIPO") == null ? ("N") != null : !res.getString("TIPO").equals("N"))
                      tipo="No Disponible";
                  else
                      tipo="Por Pedido";
                  rowProductos.add(res.getString("NOMBRE"));
                  rowProductos.add(res.getString("DESCRIPCION"));
                  rowProductos.add(tipo);
                  rowProductos.add(res.getString("UNIDAD"));
                  rowProductos.add(res.getString("PRECIO"));
                  tbm.addRow(rowProductos);
                }
            }

            stmt.close();
        }catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en la conexion");
        }   
    }
  /**
   * Llena la tabla de usuarios del apartado de usuarios
   * @throws ClassNotFoundException 
   */
    private void LlenarTablaUsuarios() throws ClassNotFoundException{
         try {
             //conectarBD();
             Statement stmt = conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblUsuarios.getModel();
           tbm.setRowCount(0);
           res=stmt.executeQuery("select * from USUARIOS");
             if(null!=res){
                while(res.next()){
                    if(res.getString(4).toString().equals("E"))
                    tbm.addRow(new Object[]{res.getInt(1),res.getString(2),"EMPLEADO",res.getString(5),res.getString(3)});
                    else{
                        tbm.addRow(new Object[]{res.getInt(1),res.getString(2),"DUEÑO",res.getString(5),res.getString(3)});
                    }
                }  
            }
            stmt.close();
        }catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en la conexion LLENAR TABLA");
        } 
    }
    /**
     *  Llena la tabla cliente del apartado de personas
     */
    private void llenarTablaCliente(){
         try {
            
            Statement stmt=conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tablaCliente.getModel();
            tbm.setRowCount(0);
            res=stmt.executeQuery("select * from PERSONAS where TIPO = 'C'");
            if(null!=res){
                while(res.next()){
                   tbm.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7)});
                }  
            }
            stmt.close();
        }catch (SQLException ex) {
            showMessageDialog(null," Error en la conexion LLENAR TABLA CLIENTE. "); 
        }
    }
    /**
     * Llena la tabla de Materias Primas del apartado de Punto de venta en la pestaña de Nueva Compra
     * @throws ClassNotFoundException 
     */
    private void LlenarTablaCompras_MateriasPrimas() throws ClassNotFoundException{
         try {
             Statement stmt = conect.createStatement();
            tbmMateriaPrima_Compra=(DefaultTableModel)tblCompraslMateriasPrimas.getModel();
           tbmMateriaPrima_Compra.setRowCount(0);
           res=stmt.executeQuery("select * from MATERIAS_PRIMAS");
             if(null!=res){
                while(res.next()){
                   Vector rowProductos=new Vector();
                  rowProductos.add(res.getString("ID_MATERIA"));
                  rowProductos.add(res.getString("NOMBRE"));
                  rowProductos.add(res.getString("CANT_DISP"));
                  rowProductos.add(res.getString("PRECIO"));
                  tbmMateriaPrima_Compra.addRow(rowProductos);
                }
            }
            
            stmt.close();
            
        }catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en la conexion");
        } 
    }
    /**
     * 
     * @throws ClassNotFoundException 
     */
    public void LlenarTablaComprasProveedores() throws ClassNotFoundException{
         try {
             
             Statement stmt = conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblProveedor_Compra.getModel();
           tbm.setRowCount(0);
           res=stmt.executeQuery("select * from PERSONAS where TIPO = 'P'");
             if(null!=res){
                while(res.next()){
                   tbm.addRow(new Object[]{res.getInt(1),res.getString(2),res.getString(5),res.getString(7)});
                }  
            }
            stmt.close();
        }catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en la conexion LLENAR TABLA");
        } 
    }
   /**
    * Evento al abrir la ventana. E inicializa todas las funciones que se necesitan al abrir la ventana.
    * @param evt 
    */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     String pattern = "yyyy-MM-dd";
     SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); 
     String dates = simpleDateFormat.format(new Date());
      holders();
            try {
                dateAct = simpleDateFormat.parse(dates);
            } catch (ParseException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
            conectarBD();
            datePedido.setDate(dateAct);
            //dateEntrega.setDate(dateAct);
            dateGeneracion.setDate(dateAct);
            llenarMateriaPrima();
            LlenarTablaProveedores();
            LlenarTablaUsuarios();
            llenarTablaCliente();
            LlenarTablaP();
            LlenarTablaCompras_MateriasPrimas();
            LlenarTablaComprasProveedores();
            llenarTablaCompra();
            llenarTablaPedidos();
            LlenarTablaVenta();
            llenarPresentacion();
            llenarPresentacionM();
            llenarTablaCliente_Pedido();
            llenarTablaProductos();
            llenarTablaHistorialPedidos();
            llenarTablaHistorialVentas();
            llenarTablaHistorialCompras();
            llenarTablaClienteVenta();
            //REMOVER ESTADO DE RESOLTADOS
            tb_principal.remove(4);
            //REMOVER USUARIOS
            tb_principal.remove(3);
            //REMOVER PROVEEDOR 
            tb_Personas.remove(0);
            //REMOVER HISTORIAL COMPRAS
            tb_PuntoVenta.remove(5);
            //REMOVER COMPRAS
            tb_PuntoVenta.remove(2);
            
        } catch (Exception ex) {
            Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
        }
        colocarImagenesTab();
//        setDateTime();
       
    }//GEN-LAST:event_formWindowOpened
    
    private void txtNombreMPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreMPKeyTyped
        
    }//GEN-LAST:event_txtNombreMPKeyTyped

    /**
     * Evento del botón Agregar Materia Prima en materia prima
     * @param evt evento del botón
     */
    private void btnAgregarMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMPActionPerformed
        
        try {
            if(VerificarvaciosMP()){
                if(MPExistente()){
                    InsertarMP();
                    clearMP();
                }else{
                    showMessageDialog(null,"MATERIA PRIMA YA EXISTENTE");
                }
            }
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(GESTION_USUARIOS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarMPActionPerformed

    /**
     * Evento del botón Cancelar Mataeria prima en materia prima.
     * @param evt 
     */
    private void btnCancelarMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarMPActionPerformed
        clearMP();
        txtEstado.setText("Cancelado con éxito.");
        txtNombreMP.requestFocus();
    }//GEN-LAST:event_btnCancelarMPActionPerformed
    /**
     * LLena los campos de texto de la Materia Prima seleccionada de la tabla Materias Primas del apartado de inventario
     * @param evt 
     */
    private void tablaMateriaPrimaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMateriaPrimaMouseClicked
        tablaMateriaPrima.getSelectedRow();

        int selectedRowIndex=tablaMateriaPrima.getSelectedRow();
        r = Integer.parseInt(tablaMateriaPrima.getValueAt(selectedRowIndex,0).toString());
        try{
            txtNombreMP.setText(tablaMateriaPrima.getValueAt(selectedRowIndex, 1).toString());
            txtDescripcionMP.setText(tablaMateriaPrima.getValueAt(selectedRowIndex, 2).toString());
            txtCantidadMP.setValue((Integer.parseInt(tablaMateriaPrima.getValueAt(selectedRowIndex, 3).toString())));
            cmbUnidadMedidaMP.setSelectedItem(tablaMateriaPrima.getValueAt(selectedRowIndex, 4).toString());
            if(tablaMateriaPrima.getValueAt(selectedRowIndex, 5).toString().equals("")){
                txtPrecioMateriaPrima.setText("0");
            }else{
                txtPrecioMateriaPrima.setText(tablaMateriaPrima.getValueAt(selectedRowIndex, 5).toString());
            }
            
        }catch(Exception e){
            

        }

    }//GEN-LAST:event_tablaMateriaPrimaMouseClicked
    /**
     * solicita confirmación para salir del sistema
     * @param evt 
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        String[] options = new String[3];
        options[0] = new String("Minimizar");
        options[1] = new String("Salir");
        options[2]=new String("Cancelar");
        int res=JOptionPane.showOptionDialog(this,"¿Deseas salir o minimizar?","Salir", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
        if(res==0){
            this.setState(Frame.ICONIFIED);
        }else if(res==1){
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }else{
            
        }
    }//GEN-LAST:event_formWindowClosing
    /**
     * solicita condifirmación para salir de ls sesión actual
     * @param evt 
     */
    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        String[] options = new String[2];
        options[0] = new String("Cerrar sesión");
        options[1] = new String("Cancelar");
        int res=JOptionPane.showOptionDialog(this,"¿Deseas realmente cerrar sesión?","Cerrar sesión", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
        if(res==0){
            Login log=new Login();
            log.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton25ActionPerformed
    /**
     * Botón al presionar teclas en el cuadro de búsqueda de clientes.
     * @param evt 
     */
    private void txtBuscarCliente_PedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCliente_PedidoKeyReleased
        try {
                BuscarClientes();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_txtBuscarCliente_PedidoKeyReleased

    /**
     * Botón de agregar un nuevo cliente en pedidos. Abre una nueva ventana. 
     * @param evt 
     */
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
VentanaCliente mdC=new VentanaCliente();
        mdC.setVisible(true);        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    /**
     * Cuadro de texto de buscar el cliente en venta.
     * @param evt 
     */
    private void txtBuscarClienteVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClienteVentaKeyReleased
            try {
                BuscarClientesVenta();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_txtBuscarClienteVentaKeyReleased

    private void txtBuscarClienteVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarClienteVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarClienteVentaActionPerformed

    /**
     * Botón de agregar cliente en ventas. Abre una nueva ventana.
     * @param evt 
     */
    private void btnAddClienteVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClienteVentasActionPerformed
        VentanaCliente mdC=new VentanaCliente();
        mdC.setVisible(true);
    }//GEN-LAST:event_btnAddClienteVentasActionPerformed

    /**
     * Cuadro de texto para buscar el proveedor al presionar teclas.
     * @param evt 
     */
    private void txtBuscarProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProveedorKeyReleased
        try {
            BuscarProveedores();
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(GESTION_PROVEEDORES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtBuscarProveedorKeyReleased

    /**
     * Valida el número de teléfono en proveedor
     * @param evt 
     */
    private void txtProveedorTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProveedorTelefonoKeyTyped
   char l=evt.getKeyChar();
        if(!(Character.isDigit(l) ) )
            evt.consume();
        
    }//GEN-LAST:event_txtProveedorTelefonoKeyTyped
    /**
     * carga la información del proveedor a los campos de texto desde la tabla Proveedores del apartado Personas
     * @param evt 
     */
    private void tblProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedoresMouseClicked
        tblProveedores.getSelectedRow();
        rowProveedor = tblProveedores.getSelectedRow();
        txtProveedorNombre.setText(tblProveedores.getValueAt(rowProveedor, 1).toString());
        txtProveedorDomicilio.setText(tblProveedores.getValueAt(rowProveedor, 2).toString());
        txtProveedorCP.setText(tblProveedores.getValueAt(rowProveedor, 3).toString());
        txtProveedorTelefono.setText(tblProveedores.getValueAt(rowProveedor, 4).toString());
    }//GEN-LAST:event_tblProveedoresMouseClicked

    /**
     * Valida el nombre del proveedor.
     * @param evt 
     */
    private void txtProveedorNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProveedorNombreKeyTyped
        ValidarLetras(evt);
    }//GEN-LAST:event_txtProveedorNombreKeyTyped
 
    /**
     * verifica los campos de texto vacios de los Proveedores del apartado de Personas
     * @return 
     */
    private boolean VerificarvaciosProveedor(){
        
        if(txtProveedorNombre.getText().equals("")){
            showMessageDialog(null, "VERIFIQUE EL NOMBRE DEL PROVEEDOR");
            return false;
        }
        if(txtProveedorDomicilio.getText().equals("")){
            showMessageDialog(null, "VERIFIQUE EL DOMICILIO");
            return false;
        }
        if(txtProveedorTelefono.getText().equals("")){
            showMessageDialog(null, "VERIFIQUE EL TELEFONO");
            return false;
        }
        if (txtProveedorCP.getText().equals("")){
            showMessageDialog(null, "VERIFIQUE EL CODIGO POSTAL");
            return false;
        }
        return true;
    }
    /**
     * Botón de modificar proveedor.
     * @param evt 
     */
    
     private boolean VerificarvaciosCliente(){
        
        if(txtNomC.getText().equals("")){
            showMessageDialog(null, "VERIFIQUE EL NOMBRE DEL CLIENTE");
            return false;
        }
        if(txtAPPC.getText().equals("")){
            showMessageDialog(null, "VERIFIQUE EL APELLIDO PATERNO");
            return false;
        }
        if(txtAPMC.getText().equals("")){
            showMessageDialog(null, "VERIFIQUE EL APELLIDO MATERNO");
            return false;
        }
        if (txtDomC.getText().equals("")){
            showMessageDialog(null, "VERIFIQUE EL DOMICILIO");
            return false;
        }
        if (txtCPC.getText().equals("")){
            showMessageDialog(null, "VERIFIQUE EL CODIGO POSTAL");
            return false;
        }
        if (txtTelC.getText().equals("")){
            showMessageDialog(null, "VERIFIQUE EL NUMERO TELEFONICO");
            return false;
        }
        return true;
    }
    
    private void btnModificarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProveedorActionPerformed

        try {
            if(VerificarvaciosProveedor()){
                ModificarProveedor();
                limpiarProveedor();
            }
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(GESTION_PROVEEDORES.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnModificarProveedorActionPerformed
   public int rowProveedor = 0;
   /**
    * realiza la consulta de modificación de Proveedor
    * @throws ClassNotFoundException 
    */
    private void ModificarProveedor() throws ClassNotFoundException{
        try{
            conectarBD();

            String cad = "UPDATE PERSONAS "
                    + "SET NOMBRE='"+ txtProveedorNombre.getText()+"',"
                    + "APE_PAT='null',APE_MAT='null',DOMICILIO='"
                    + txtProveedorDomicilio.getText()+ "',COD_POSTAL='"
                    + txtProveedorCP.getText()+ "',TELEFONO='"
                    + txtProveedorTelefono.getText() + "',TIPO="
                    + "'P' WHERE ID_PERSONA="+ tblProveedores.getValueAt(rowProveedor,0);
            Statement stmt = conect.createStatement();
            stmt.executeUpdate(cad);
            showMessageDialog(null,"Proveedor Modificado");
            LlenarTablaProveedores();
            stmt.close();
        }
            catch (SQLException ex) 
            {
            System.out.println("Error modificar");   
            }
    }
    /**
     * solicita verificación para eliminar el Proveedor
     * @param evt 
     */
    private void btnEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProveedorActionPerformed

        try {
            if(VerificarvaciosProveedor()){
                int j = JOptionPane.showConfirmDialog(null, "¿Deeseas eliminar el proveedor?", "Eliminar Proveedor", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(j == JOptionPane.YES_OPTION){
                    EliminarProveedor();
                    limpiarProveedor();
                }
            }
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(GESTION_PROVEEDORES.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnEliminarProveedorActionPerformed
    /**
     * verifica si el proveedor existe e inserta la información sino lo notifica
     * @param evt 
     */
    private void btnAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProveedorActionPerformed
        try {
            if(VerificarvaciosProveedor()){
                if(ProveedorExistente())
                insertarProveedor();
                limpiarProveedor();
            }
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(GESTION_PROVEEDORES.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAgregarProveedorActionPerformed
    /**
     * realiza la consulta para el registro de un proveedor 
     * @throws ClassNotFoundException 
     */
    private void insertarProveedor() throws ClassNotFoundException{
        try{
            conectarBD();
            String cad = "INSERT INTO PERSONAS (NOMBRE,APE_PAT,APE_MAT,DOMICILIO,COD_POSTAL,TELEFONO,TIPO) "
                    + "VALUES('"+ txtProveedorNombre.getText()+"',"
                    + "'null','null','"
                    + txtProveedorDomicilio.getText()+ "','"
                    + txtProveedorCP.getText()+ "','"
                    + txtProveedorTelefono.getText() + "',"
                    + "'P')";
            Statement stmt = conect.createStatement();
            stmt.executeUpdate(cad);
            //showMessageDialog(null,"Proveedor Registrado");
            LlenarTablaProveedores();
            stmt.close();
        }
            catch (SQLException ex) 
            {
            System.out.println("Error insertar");   
            }
    }
    /**
     * Botón de limpiar campos en proveedor.
     * @param evt 
     */
    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        limpiarProveedor();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    /**
     * Validar el código postal al preisonar teclas.
     * @param evt 
     */
    private void txtProveedorCPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProveedorCPKeyTyped
         char l=evt.getKeyChar();
        if(!(Character.isDigit(l) ) )
            evt.consume();
     
    }//GEN-LAST:event_txtProveedorCPKeyTyped
    /**
     * Botón de agregar usuarios en usuarios.
     * @param evt 
     */
    private void btnUsuariosAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosAgregarActionPerformed
        try {
            if(VerificarvaciosUsuario()){
                if(UsuarioExistente()){
                    InsertarUsuario();
                    limpiarUsuarios();
                }else{
                    showMessageDialog(null,"USUARIO YA EXISTENTE");
                }
            }
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(GESTION_USUARIOS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUsuariosAgregarActionPerformed
    /**
     * vacía la información de los campos de texto de usuarios en el apartado de usuarios
     */
    private void limpiarUsuarios(){
        txtUsuariosNombre.setText(null);
        txtUsuariosUsuario.setText(null);
        txtUsuariosContraseña.setText(null);
        cmbUsuariosTipo.setSelectedIndex(0);
    }
    /**
     * Botón que limpia los campos de usuario.
     * @param evt 
     */
    private void btnUsuariosCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosCancelarActionPerformed
        limpiarUsuarios();
    }//GEN-LAST:event_btnUsuariosCancelarActionPerformed

    /**
     * Botón que modifica los datos de usuario.
     * @param evt 
     */
    private void btnUsuariosModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosModificarActionPerformed
        try {
            if(VerificarvaciosUsuario()){
                if(UsuarioExistente()){
                    showMessageDialog(null,"VERIFIQUE EL NOMBRE DE USUARIO");
                }else{

                    ModificarUsuario();
                    limpiarUsuarios();
                }
            }
        } catch (ClassNotFoundException ex) {
          
        }
    }//GEN-LAST:event_btnUsuariosModificarActionPerformed
    /**
     * verifica si el usuario existe, sino lo modifica
     * @param evt 
     */
    private void btnUsuariosEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosEliminarActionPerformed
        try {
            if(VerificarvaciosUsuario()){
                if(UsuarioExistente()){
                    showMessageDialog(null,"VERIFIQUE EL NOMBRE DE USUARIO");
                }else{
                    int j = JOptionPane.showConfirmDialog(null, "¿Está seguro?", "Eliminar Proveedor", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(j == JOptionPane.YES_OPTION){
                        EliminarUsuario();
                        limpiarUsuarios();
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(GESTION_USUARIOS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUsuariosEliminarActionPerformed
    public int rowUsuario = 0;
    
    /**
     * realiza la consulta para eliminar al usuario seleccionado
     * @throws ClassNotFoundException 
     */
    private void EliminarUsuario() throws ClassNotFoundException{
        try{
            String cad = "DELETE FROM USUARIOS WHERE ID_USUARIO =" + tblUsuarios.getValueAt(rowUsuario,0).toString();
            Statement stmt = conect.createStatement();
            stmt.executeUpdate(cad);
            LlenarTablaUsuarios();
            stmt.close();
        }
            catch (SQLException ex) 
            {
            System.out.println("Error Eliminar");   
            }
    }
    /**
     * realiza la consulta para eliminar la materia prima del apartado de inventario
     * @throws ClassNotFoundException 
     */
    private void EliminarMP() throws ClassNotFoundException{
        try{
            String cad = "DELETE FROM MATERIAS_PRIMAS WHERE ID_MATERIA =" + tablaMateriaPrima.getValueAt(tablaMateriaPrima.getSelectedRow(),0).toString();
            Statement stmt = conect.createStatement();
            stmt.executeUpdate(cad);
            llenarMateriaPrima();
            stmt.close();
        }
            catch (SQLException ex) 
            {
            System.out.println(ex.toString()+ "\n"+"Error Eliminar Materia Prima");   
            }
    }
    /**
     * realiza la consulta del registro de usuario
     */
    private void InsertarUsuario(){
        try{
            conectarBD();
            String cad = "INSERT INTO USUARIOS (NOMBRE_USUARIO,NOMBRE_PERSONA,TIPO,CONTRASEÑA) "
                    + "VALUES('"+ txtUsuariosUsuario.getText()+"','"
                    + txtUsuariosNombre.getText() + "','"
                    + cmbUsuariosTipo.getSelectedItem().toString().substring(0,1) + "','"
                    + txtUsuariosContraseña.getText() + "')";
            Statement stmt = conect.createStatement();
            stmt.executeUpdate(cad);
            LlenarTablaUsuarios();
            stmt.close();
        }
            catch (SQLException ex) 
            {
            System.out.println("Error insertar");   
            } catch (ClassNotFoundException ex) {
        //Logger.getLogger(GESTION_USUARIOS.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    /**
     * realia la consulta para el registro de una materia prima
     */
    private void InsertarMP(){
        try{
            
            String cad = "INSERT INTO MATERIAS_PRIMAS (NOMBRE,DESCRIPCION,CANT_DISP,UNIDAD_MEDIDA,PRECIO) "
                    + "VALUES('"+ txtNombreMP.getText()+"','"
                    + txtDescripcionMP.getText() + "','"
                    + txtCantidadMP.getValue().toString()+ "','"
                    + cmbUnidadMedidaMP.getSelectedItem().toString() + "',"
                    + txtPrecioMateriaPrima.getText()+")";
            Statement stmt = conect.createStatement();
            stmt.executeUpdate(cad);
            llenarMateriaPrima();
            stmt.close();
        }
            catch (SQLException ex) 
            {
            System.out.println(ex.toString() + "\n"+ "Error al insertar Materia Prima");   
            } catch (ClassNotFoundException ex) {
        //Logger.getLogger(GESTION_USUARIOS.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * realiza la consulta para la modificación de un usuario
     * @throws ClassNotFoundException 
     */
    private void ModificarUsuario() throws ClassNotFoundException{
        try{
            String cad;
            cad = "UPDATE USUARIOS "
                    + "SET NOMBRE_USUARIO='"+ txtUsuariosUsuario.getText()+"',"
                    + "NOMBRE_PERSONA='" + txtUsuariosNombre.getText()+ "',TIPO='"
                    + cmbUsuariosTipo.getSelectedItem().toString().substring(0,1) + "',CONTRASEÑA='"
                    + txtUsuariosContraseña.getText()
                    + "' WHERE ID_USUARIO="+ tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(),0);
            Statement stmt = conect.createStatement();
            stmt.executeUpdate(cad);
            LlenarTablaUsuarios();
            stmt.close();
        }
            catch (SQLException ex) 
            {
            System.out.println("Error modificar");   
            }
    }
    /**
     * realza la consulta para modificar una materia prima
     * @throws ClassNotFoundException 
     */
    private void ModificarMP() throws ClassNotFoundException{
        try{
            conectarBD();
            String cad;
            cad = "UPDATE MATERIAS_PRIMAS "
                    + "SET NOMBRE='"+ txtNombreMP.getText()+"',"
                    + "DESCRIPCION='" + txtDescripcionMP.getText() + "',"
                    + "CANT_DISP='"+ txtCantidadMP.getValue().toString() + "',"
                    + "UNIDAD_MEDIDA='"+ cmbUnidadMedidaMP.getSelectedItem().toString()+ "',"
                    + "PRECIO="+txtPrecioMateriaPrima.getText()
                    + " WHERE ID_MATERIA="+ tablaMateriaPrima.getValueAt(tablaMateriaPrima.getSelectedRow(),0);
            Statement stmt = conect.createStatement();
            stmt.executeUpdate(cad);
            llenarMateriaPrima();
            stmt.close();
        }
            catch (SQLException ex) 
            {
            System.out.println("Error modificar MATERIA PRIMA");   
            }
    }
    /**
     * llena la información de busqueda de la tabla Productos del apartado Punto de Venta de la pestaña de Nuevo Pedido
     */
    private void buscarTablaProductos_Pedido(){
        try {
            
            Statement stmt=conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblProductos_Pedido.getModel();
            tbm.setRowCount(0);
            res=stmt.executeQuery("select * from PRODUCTOS WHERE (TIPO = 'N' OR TIPO = 'P') AND NOMBRE LIKE '%"+txtBuscarProducto_Pedido.getText()+"%'");
            if(null!=res){
                while(res.next()){
                    String tipo;
                  if(res.getString("TIPO") == null ? ("N") != null : !res.getString("TIPO").equals("N"))
                      tipo="No Disponible";
                  else
                      tipo="Por Pedido";
                   tbm.addRow(new Object[]{res.getString("ID_PRODUCTO"),res.getString("NOMBRE"),tipo,res.getString("UNIDAD"),res.getString("PRECIO")});
                }  
            }
            stmt.close();
        }catch (SQLException ex) {
            showMessageDialog(null," Error en la conexion LLENAR TABLA PRODUCTOS. "); 
        }
    }
    /**
     * obtiene los datos para la generación del Estado de Resultados
     */
    private void datosreporte(){
        
    try {
        
    
    LocalDate initial = LocalDate.now();
    LocalDate start = initial.withDayOfMonth(1);
    LocalDate end = initial.withDayOfMonth(initial.lengthOfMonth());
    
    System.out.println(start);
    System.out.println(end);
    stmt=conect.createStatement();
    
        tbmVenta=(DefaultTableModel)tblVenta.getModel();
        tbmVenta.setRowCount(0);
        
        res = stmt.executeQuery("select sum (TOTAL) AS TOTAL_VENTAS " +
                     "FROM VENTAS " +
                     "WHERE FECHA  between '" + start.toString() + "' AND '" + end.toString() + "'");
        if(null!=res){
            while(res.next()){
                VENTAS = res.getInt("TOTAL_VENTAS");
            }
        }
        //stmt.close();
        //stmt=conect.createStatement();
        System.out.println(VENTAS);
        lblTotalVentas.setText(""+VENTAS);
        res = stmt.executeQuery("select sum (ADELANTO) as TOTAL_ADELANTOS " +
                     "FROM PEDIDOS " +
                     "WHERE PEDIDOS.ESTADO = 'N' " +
                     " AND FECHA_PEDIDO  between '" + start.toString() + "' AND '" + end.toString() + "'");
        if(null!=res){
            while(res.next()){
                ADELANTOS = res.getInt("TOTAL_ADELANTOS");
            }
        }
        //stmt=conect.createStatement();
        System.out.println(ADELANTOS);
        lblTotalAdelantos.setText(""+ADELANTOS);
        res=stmt.executeQuery("SELECT SUM(TOTAL) AS COMPRAS " +
                      "FROM COMPRAS " +
                     "WHERE FECHA  between '" + start.toString() + "' AND '" + end.toString() + "'");
                
                if(null!=res){
                    while(res.next()){
                      COMPRAS = res.getInt("COMPRAS");
                    }
                }
                //stmt=conect.createStatement();
                System.out.println(COMPRAS); 
                lblTotalCompras.setText(""+COMPRAS);
           res=stmt.executeQuery("select MATERIAS_PRIMAS.NOMBRE,sum(DETALLE_COMPRA.TOTAL) as COMPRADO " +
                        "FROM ((DETALLE_COMPRA INNER JOIN MATERIAS_PRIMAS ON DETALLE_COMPRA.ID_MATERIA_PRIMA = MATERIAS_PRIMAS.ID_MATERIA) " +
                        "INNER JOIN COMPRAS ON DETALLE_COMPRA.ID_COMPRA = COMPRAS.ID_COMPRA) " +
                        "WHERE COMPRAS.FECHA between '" + start.toString() + "' AND '" + end.toString() + "'" +
                        " group by MATERIAS_PRIMAS.NOMBRE " +
                        "Order by 2 DESC");
                
                if(null!=res){
                    for(int i = 0;i<1 ;i++){
                        res.next();
                        if(res != null){
                            MATERIAPRIMA1 = res.getString(1);
                            //MATERIAPRIMA1 = res.getString(2);
                        }else{
                        
                        }
                    }
                }
            //stmt=conect.createStatement();
               System.out.println(MATERIAPRIMA1);
                lblMateriaVendida.setText(""+MATERIAPRIMA1);
                res=stmt.executeQuery("Select PERSONAS.NOMBRE " +
                             "From COMPRAS INNER JOIN PERSONAS ON COMPRAS.ID_PROVEEDOR = PERSONAS.ID_PERSONA " +
                             "WHERE FECHA  between '" + start.toString() + "' AND '" + end.toString() + "'" +
                             "Group By PERSONAS.NOMBRE " +
                             "Order By PERSONAS.ID_PERSONA ASC LIMIT 1");
                if(null!=res){
                    
                    
                    for(int i = 0;i<1;i++){
                        res.next();
                        PROVEEDOR1 = res.getString("NOMBRE");
                    }
                }
                
               // stmt=conect.createStatement();   
             System.out.println(PROVEEDOR1);
             lblProveedormasCompras.setText(""+PROVEEDOR1);
             res=stmt.executeQuery("SELECT PERSONAS.NOMBRE " +
                          "from VENTAS INNER JOIN PERSONAS ON VENTAS.ID_CLIENTE = PERSONAS.ID_PERSONA " +
                          "WHERE FECHA between '" + start.toString() + "' AND '" + end.toString() + "' " +
                          "GROUP BY PERSONAS.NOMBRE " +
                          "ORDER BY PERSONAS.ID_PERSONA ASC LIMIT 1");
                if(null!=res){
                    
                    
                    for(int i = 0;i<1;i++){
                        res.next();
                        CLIENTE1 = res.getString(1);
                    }
                }
                 System.out.println(CLIENTE1);
             lblClienteActivo.setText(""+CLIENTE1);
             
             //stmt=conect.createStatement();   
            
             
             res=stmt.executeQuery("SELECT PRODUCTOS.NOMBRE " +
                          "FROM DETALLE_VENTAS INNER JOIN PRODUCTOS ON DETALLE_VENTAS.ID_PRODUCTO=PRODUCTOS.ID_PRODUCTO " +
                          "GROUP BY PRODUCTOS.NOMBRE " +
                          "ORDER BY PRODUCTOS.ID_PRODUCTO ASC LIMIT 1");
                if(null!=res){
                    
                    
                    for(int i = 0;i<1;i++){
                        res.next();
                        PRODUCTO1 = res.getString(1);
                    }
                }
                lblProductomasVentas.setText(PRODUCTO1);
                
            
             stmt.close();
            
           
         
            RELACION = ((VENTAS + ADELANTOS)-COMPRAS);
           lblTotalCapital.setText(""+ RELACION);
            System.out.println(RELACION);
            lblTotalIngresos.setText(""+(VENTAS+ADELANTOS));
            lblTotalEgresos.setText(""+COMPRAS);
            
    } catch (SQLException ex) {
        //Logger.getLogger(GESTION_USUARIOS.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
    }
    /**
     * llena la tabla productos del apartado de Pedido
     */
    private void llenarTablaProductos(){
         try {
            String tipo;
            Statement stmt=conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblProductos_Pedido.getModel();
            tbm.setRowCount(0);
            res=stmt.executeQuery("select * from PRODUCTOS where tipo = 'N' OR tipo ='P'");
            if(null!=res){
                while(res.next()){
                  
                  if(res.getString("TIPO") == null ? ("N") != null : !res.getString("TIPO").equals("N"))
                      tipo="Por Pedido";
                  else
                      tipo="No Disponible";
                   tbm.addRow(new Object[]{res.getString("ID_PRODUCTO"),res.getString("NOMBRE"),tipo,res.getString("UNIDAD"),res.getString("PRECIO")});
                }  
            }
            stmt.close();
        }catch (SQLException ex) {
            showMessageDialog(null," Error en AL LLENAR TABLA PRODUCTOS POR BUSQUEDA. "); 
        }
    }
    /**
     * llena la tabala de cliente del apartado Punto de Venta de la pestaña Nueva Venta
     */
    private void llenarTablaClienteVenta(){
         try {
            
            Statement stmt=conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblClientesVenta.getModel();
            tbm.setRowCount(0);
            res=stmt.executeQuery("select ID_PERSONA, NOMBRE ,APE_PAT, APE_MAT ,TELEFONO from PERSONAS where TIPO = 'C'");
            if(null!=res){
                while(res.next()){
                   tbm.addRow(new Object[]{res.getString("ID_PERSONA"),res.getString("NOMBRE"),res.getString("APE_PAT"),res.getString("APE_MAT"),res.getString("TELEFONO")});
                }  
            }
            stmt.close();
        }catch (SQLException ex) {
            showMessageDialog(null,"Error en la conexion LLENAR TABLA CLIENTES EN VENTAS. "); 
        }
    }
    /**
     * verifica si la materia prima existe
     * @return
     * @throws ClassNotFoundException 
     */
    private boolean MPExistente() throws ClassNotFoundException{
         try {
             conectarBD();
             Statement stmt = conect.createStatement();
             res=stmt.executeQuery("select * from MATERIAS_PRIMAS WHERE NOMBRE='"+ txtNombreMP.getText()+"'");
             if(null!=res){
                while(res.next()){
                   return false;
                }
             }
             stmt.close();
        }catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en la conexion LLENAR TABLA");
        }
         return true;
    }
    /**
     * verifica si el usuario ya existe
     * @return
     * @throws ClassNotFoundException 
     */
    private boolean UsuarioExistente() throws ClassNotFoundException{
         try {
             Statement stmt = conect.createStatement();
             res=stmt.executeQuery("select * from USUARIOS WHERE NOMBRE_USUARIO ='"+ txtUsuariosUsuario.getText()+"'");
             if(null!=res){
                while(res.next()){
                   return false;
                }
             }
             stmt.close();
        }catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en la conexion LLENAR TABLA");
        }
         return true;
    }
    /**
     * verifica los campos vacíos de usuario
     * @return 
     */
    private boolean VerificarvaciosUsuario(){
        
        if(txtUsuariosNombre.getText().equals("")){
            showMessageDialog(null, "VERIFIQUE EL NOMBRE DE LA PERSONA");
            return false;
        }
        if(txtUsuariosContraseña.getText().equals("")){
            showMessageDialog(null, "VERIFIQUELA CONTRASEÑA");
            return false;
        }
        if(txtUsuariosUsuario.getText().equals("")){
            showMessageDialog(null, "VERIFIQUE EL NOMBRE DE USUARIO");
            return false;
        }
        if (cmbUsuariosTipo.getSelectedIndex() == 0){
            showMessageDialog(null, "SELECCIONE UN TIPO DE USUARIO");
            return false;
        }
        return true;
    }
    /**
     * verifica los campos vacios de materias primas
     * @return 
     */
    private boolean VerificarvaciosMP(){
        
        if(txtNombreMP.getText().equals("")){
            showMessageDialog(null, "VERIFIQUE EL NOMBRE DE LA MATERIA PRIMA");
            return false;
        }
        
//        if (cmbUnidadMedidaMP.getSelectedIndex() == 0){
//            showMessageDialog(null, "SELECCIONE UNA UNIDAD DE MEDIDA");
//            return false;
//        }
        return true;
    }
    /**
     * carga la información del usuario seleccionado de la tabla de usuarios
     * @param evt 
     */
    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        rowUsuario = tblUsuarios.getSelectedRow();
        txtUsuariosUsuario.setText(tblUsuarios.getValueAt(rowUsuario, 1).toString());
        cmbUsuariosTipo.setSelectedItem(tblUsuarios.getValueAt(rowUsuario, 2));
        txtUsuariosContraseña.setText(tblUsuarios.getValueAt(rowUsuario,3).toString());
        txtUsuariosNombre.setText(tblUsuarios.getValueAt(rowUsuario, 4).toString());
    }//GEN-LAST:event_tblUsuariosMouseClicked

    /**
     * Valida el texto del usuario al presionar teclas.
     * @param evt 
     */
    private void txtUsuariosUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuariosUsuarioKeyTyped
        ValidarEspacios(evt);
    }//GEN-LAST:event_txtUsuariosUsuarioKeyTyped

    /**
     * Valida el texto de contraseña del usuario al presionar teclas.
     * @param evt 
     */
    private void txtUsuariosContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuariosContraseñaKeyTyped
        ValidarEspacios(evt);
    }//GEN-LAST:event_txtUsuariosContraseñaKeyTyped
    /**
     * Valida el nombre dle usuario al presionar teclas.
     * @param evt 
     */
    private void txtUsuariosNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuariosNombreKeyTyped
        ValidarLetras(evt);
    }//GEN-LAST:event_txtUsuariosNombreKeyTyped

    private void txtAPMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAPMCActionPerformed

    }//GEN-LAST:event_txtAPMCActionPerformed

    /**
     * Botón de cancelar compra.
     * @param evt 
     */
    private void btnCancelarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCActionPerformed
        borrarC();
       
    }//GEN-LAST:event_btnCancelarCActionPerformed
    /**
     * solicitaverificación para eliminar al cliente
     * @param evt 
     */
    private void btnEliminarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCActionPerformed
        BaseDatosCliente c=new BaseDatosCliente();
        int j = JOptionPane.showConfirmDialog(null, "¿Estás seguro?", "Eliminar Cliente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(j == JOptionPane.YES_OPTION){
            try {
                if(c.eliminar(IDCliente_Cliente))
                borrarC();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VentanaCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(VentanaCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch(ArrayIndexOutOfBoundsException ex){
                showMessageDialog(null, "No ha seleccionado ninguna fila.");
            }
            llenarTablaCliente();
        }

    }//GEN-LAST:event_btnEliminarCActionPerformed
    
    /**
     * Filtro para buscar en Materia primas en compras.
     */
    public void filtro() {
        int columnaABuscar = 1;
        trsFiltro.setRowFilter(RowFilter.regexFilter(txtBuscasMateriaPrima_Compras.getText(), columnaABuscar));
    }
    
    private TableRowSorter trsFiltro;
    /**
     * Función para limpiar campos en compras.
     */
    void borrarC(){
        txtNomC.setText("");
        txtAPPC.setText("");
        txtAPMC.setText("");
        txtDomC.setText("");
        txtCPC.setText("");
        txtTelC.setText("");
    }
    
    /**
     * carga la información del cliente de la tabla clientes
     */
    public void seleccionar(){
        int filaseleccionada;
            //Guardamos en un entero la fila seleccionada.
            filaseleccionada = tablaCliente.getSelectedRow();
            if (filaseleccionada == -1){
               showMessageDialog(null, "No ha seleccionado ninguna fila.");
            }
            IDCliente_Cliente = (String) tablaCliente.getValueAt(filaseleccionada,0);
            String NOMBRE=(String)tablaCliente.getValueAt(filaseleccionada,1);
            String APE_PAT=(String)tablaCliente.getValueAt(filaseleccionada,2);
            String APE_MAT=(String)tablaCliente.getValueAt(filaseleccionada,3);
            String DOMICILIO=(String)tablaCliente.getValueAt(filaseleccionada,4);
            String COD_POSTAL=(String)tablaCliente.getValueAt(filaseleccionada,5);
            String TELEFONO=(String)tablaCliente.getValueAt(filaseleccionada,6);
            
            Object [] v=new Object [6];
            v[0]=NOMBRE;
            v[1]=APE_PAT;
            v[2]=APE_MAT;
            v[3]=DOMICILIO;
            v[4]=COD_POSTAL;
            v[5]=TELEFONO;
            
            txtNomC.setText(String.valueOf(v[0]));
            txtAPPC.setText(String.valueOf(v[1]));
            txtAPMC.setText(String.valueOf(v[2]));
            txtDomC.setText(String.valueOf(v[3]));
            txtCPC.setText(String.valueOf(v[4]));
            txtTelC.setText(String.valueOf(v[5]));
    }
    /**
     * Botón de Modificar clientes.
     * @param evt 
     */
    private void btnModificarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCActionPerformed
        BaseDatosCliente c=new BaseDatosCliente();
        try {
            if(c.modificar(IDCliente_Cliente,txtNomC.getText(),txtAPPC.getText(),txtAPMC.getText(),txtDomC.getText(),txtCPC.getText(),txtTelC.getText()))
            borrarC();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentanaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch(ArrayIndexOutOfBoundsException ex){
            showMessageDialog(null, "No ha seleccionado ninguna fila.");
        }
        llenarTablaCliente();

    }//GEN-LAST:event_btnModificarCActionPerformed

    String IDCliente_Cliente=null;
    private void txtDomCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDomCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomCActionPerformed

    private void txtCPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPCActionPerformed

    private void txtTelCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelCActionPerformed

    private void tablaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClienteMouseClicked
        seleccionar();
    }//GEN-LAST:event_tablaClienteMouseClicked

    /**
     * Botón de insertar clientes en clientes.
     * @param evt 
     */
    private void btnInsertarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarCActionPerformed
       if(VerificarvaciosCliente()){
        BaseDatosCliente c=new BaseDatosCliente();
        try {
            if(c.insertar(txtNomC.getText(),txtAPPC.getText(),txtAPMC.getText(),txtDomC.getText(),txtCPC.getText(),txtTelC.getText()))
            borrarC();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentanaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        llenarTablaCliente();}
    }//GEN-LAST:event_btnInsertarCActionPerformed

    private void txtBuscadorCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorCActionPerformed

    /**
     * Texto de buscar cliente al presionar teclas.
     * @param evt 
     */
    private void txtBuscadorCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorCKeyTyped
        txtBuscadorC.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                //                String cadena = (txtBuscadorC.getText());
                //                txtBuscadorC.setText(cadena);
                repaint();
                filtro();
            }
        });
        trsFiltro = new TableRowSorter(tablaCliente.getModel());
        tablaCliente.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txtBuscadorCKeyTyped

    /**
     * Botón de modificar Materia prima.
     * @param evt 
     */
    private void btnModificarMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarMPActionPerformed
        try {
            if(VerificarvaciosMP()){
                

                    ModificarMP();
                    clearMP();
                
            }
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(GESTION_USUARIOS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModificarMPActionPerformed
/**
 * verifica si la materia prima ya existe
 * @param evt 
 */
    private void MPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MPActionPerformed
        try {
            if(VerificarvaciosMP()){
                if(MPExistente()){
                    showMessageDialog(null,"VERIFIQUE EL NOMBRE DE MATERIA PRIMA");
                }else{
                    int j = JOptionPane.showConfirmDialog(null, "¿Estás seguro?", "Eliminar Materia Prima", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(j == JOptionPane.YES_OPTION){
                        EliminarMP();
                        clearMP();
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(GESTION_USUARIOS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MPActionPerformed
    /**
     * carga la información del producto de la tabla de productos
     * @param evt 
     */
    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        tblProducto.getSelectedRow();
        int selectedRowIndex=tblProducto.getSelectedRow();
        txtnomP.setText(tblProducto.getValueAt(selectedRowIndex, 0).toString());
        txtdescP.setText(tblProducto.getValueAt(selectedRowIndex, 1).toString());
        cmbUnidadMedidaProducto.setSelectedItem(tblProducto.getValueAt(selectedRowIndex, 3).toString());
        txtprecioP.setText(tblProducto.getValueAt(selectedRowIndex, 4).toString());
        if(tblProducto.getValueAt(selectedRowIndex, 2).toString().equals("Por Pedido"))
            rdbPorPedido.isSelected();
        else
            rdbNoDisponible.isSelected();
        // TODO add your handling code here:
    }//GEN-LAST:event_tblProductoMouseClicked
    /**
     * vacía la información de los campos de texto de los  productos
     */
    private void clearP(){
        txtnomP.setText(null);
        txtdescP.setText(null);
        cmbUnidadMedidaProducto.setSelectedItem("Pieza");
        txtprecioP.setText(null);
        txtBuscarP.setText(null);
        cmbUnidadMedidaProducto.setSelectedItem(conect);
        try {
            LlenarTablaP();
        } catch (ClassNotFoundException ex) {
            
        }
    }
    /**
     * Botón de limpiar los campos de productos.
     * @param evt 
     */
    private void btnCancelarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPActionPerformed
        clearP();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarPActionPerformed



    /**
     * verifica los campos vacios de productos
     * @return 
     */
private boolean validarVacioP(){
            if((("".equals(txtdescP.getText()) || "".equals(txtnomP.getText())) || "".equals(txtprecioP.getText()))|| "".equals(cmbUnidadMedidaProducto.getSelectedItem().toString())){
                showMessageDialog(null,"Favor de llenar todos los campos. ");
                return false;
            } 
//            if (cmbUnidadMedidaProducto.getSelectedIndex() == 0){
//            showMessageDialog(null, "SELECCIONE UNA UNIDAD DE MEDIDA");
//            return false;
//            }
            return true;
     }
     /**
      * realiza la consulta para la modificación del producto
      * @param evt 
      */
    private void btnModificarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPActionPerformed
        if(validarVacioP()){
            DefaultTableModel prod=(DefaultTableModel) tblProducto.getModel();
            String nombre=txtnomP.getText();
            String nombreSelec= tblProducto.getValueAt(tblProducto.getSelectedRow(), 0)+"";
            String descripcion=txtdescP.getText();
              String tipo;
            if(rdbPorPedido.isSelected())
                tipo="P";
            else
                tipo="N";
            String u_medida=cmbUnidadMedidaProducto.getSelectedItem().toString();
            String precio=txtprecioP.getText();

            String cad = "update productos set NOMBRE='"+nombre+"', DESCRIPCION ='"+descripcion+"',TIPO='"+tipo+"',UNIDAD='"+u_medida+"',PRECIO = "+precio+" WHERE (TIPO = 'N' OR TIPO = 'P') AND NOMBRE='"+nombreSelec+"'";
            try {
                java.sql.Statement stmt=conect.createStatement();

                stmt.executeUpdate(cad);
                LlenarTablaP();
            } catch (ClassNotFoundException ex) {

            } catch (SQLException ex) {

            }

            clearP();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarPActionPerformed
    /**
     * Realiza la consulta para registrar el producto del apartado de inventario
     * @param evt 
     */
    private void btnAgregarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPActionPerformed
        if(validarVacioP()){
            DefaultTableModel prod=(DefaultTableModel) tblProducto.getModel();
            String nombre=txtnomP.getText();
            String descripcion=txtdescP.getText();
            String tipo;
            if(rdbPorPedido.isSelected())
                tipo="P";
            else
                tipo="N";
            
            String u_medida=cmbUnidadMedidaProducto.getSelectedItem().toString();
            Float precio=Float.parseFloat((txtprecioP.getText()));

            String cad = "INSERT INTO PRODUCTOS (NOMBRE,DESCRIPCION,TIPO,UNIDAD,PRECIO) VALUES('"+nombre+"','"+descripcion+"','"+tipo+"','"+u_medida+"',"+precio+")";
            try {
                //java.sql.Statement stmt=conect.createStatement();

                stmt.executeUpdate(cad);
                LlenarTablaP();
            } catch (ClassNotFoundException ex) {
                
            } catch (SQLException ex) {
                
            }

            clearP();}
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarPActionPerformed
/**
 * Cambia el estado  del producto a Eliminado
 * @param evt 
 */
    private void btnEliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPActionPerformed
        if(validarVacioP()){
            
              String tipo;
            if(rdbPorPedido.isSelected())
                tipo="P";
            else
                tipo="N";
            String u_medida=cmbUnidadMedidaProducto.getSelectedItem().toString();
            String precio=txtprecioP.getText();
            String nombre=txtnomP.getText();
            String cad = "update productos set TIPO='E' WHERE  NOMBRE='"+nombre+"'";
            try {
                java.sql.Statement stmt=conect.createStatement();

                stmt.executeUpdate(cad);
                LlenarTablaP();
            } catch (ClassNotFoundException ex) {

            } catch (SQLException ex) {

            }
            
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarPActionPerformed

    /**
     * Valida el precio del producto en producto al presionar teclas.
     * @param evt 
     */
    private void txtprecioPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioPKeyTyped
 ValidarNumeros(evt,txtprecioP);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioPKeyTyped
   /**
    * llena la tabla de productos al buscar
    * @throws ClassNotFoundException 
    */
    private void LlenarTablaBus() throws ClassNotFoundException{
         try {
             conectarBD();

             Statement stmt = conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblProducto.getModel();
           tbm.setRowCount(0);
           res=stmt.executeQuery("select * from PRODUCTOS where (TIPO = 'N' OR TIPO = 'P') AND NOMBRE LIKE '%"+txtBuscarP.getText()+"%'");
            if(null!=res){
                while(res.next()){
                    String tipo;
                  if(res.getString("TIPO") == null ? ("N") != null : !res.getString("TIPO").equals("N"))
                      tipo="No Disponible";
                  else
                      tipo="Por Pedido";
                   Vector rowProductos=new Vector();
                  rowProductos.add(res.getString("NOMBRE"));
                  rowProductos.add(res.getString("DESCRIPCION"));
                  rowProductos.add(tipo);
                  rowProductos.add(res.getString("UNIDAD"));
                  rowProductos.add(res.getString("PRECIO"));
                  tbm.addRow(rowProductos);
                }
            }

            stmt.close();
        }catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en la conexion");
        }  
    }
    private void cmbUsuariosTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUsuariosTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUsuariosTipoActionPerformed
    /**
     * busca los pedidos ya sea por la fecha de generación y la fecha de entrega
     */
    private void BuscarPedidos(){
         try {
             
            Statement stmt = conect.createStatement();
            DefaultTableModel tbmPedidosVenta=(DefaultTableModel)tblPedidosVentas.getModel();
            tbmPedidosVenta.setRowCount(0);
            
           idCliente=Integer.parseInt(tblClientesVenta.getValueAt(tblClientesVenta.getSelectedRow(), 0).toString());
            //BUSCA TODO DE PEDIDO
            
            if(idCliente>0){
                stmt = conect.createStatement();
            String Bus;
           if(rdbGeneracion.isSelected())
               Bus = "PEDIDO";
           else
               Bus = "ENTREGA";
        String pattern = "yyyy-MM-dd";
               
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date2 = simpleDateFormat.format(dateGeneracion.getDate());
        System.err.println(date2);
            tbmPedidosVenta.setRowCount(0);
           res=stmt.executeQuery("select ID_PEDIDO,FECHA_PEDIDO,FECHA_ENTREGA from PEDIDOS "
                + "where FECHA_"+Bus+" = '"+date2+"'  and ESTADO = 'N' and ID_CLIENTE = "+ idCliente+"");  
            if(res!=null){
                while(res.next()){
                   tbmPedidosVenta.addRow(new Object[]{tblClientesVenta.getValueAt(tblClientesVenta.getSelectedRow(), 1),res.getInt("ID_PEDIDO"), res.getString("FECHA_PEDIDO"),res.getString("FECHA_ENTREGA")});
                }  
            }
            stmt.close();
            }else{
                
            }
            
            
         
            
            
        }catch (SQLException ex) {
             System.out.println("ERROR AL LLENAR PEDIDOS EN VENTA");
        } 
    }
    /**
     * llen ala informació de pedidos en base al cliente seleccionado en el apartado de Nueva Venta
     */
    private void llenarTablaPedidos_Venta(){
         try {
             
            
            DefaultTableModel tbmPedidosVenta=(DefaultTableModel)tblPedidosVentas.getModel();
            idCliente=Integer.parseInt(tblClientesVenta.getValueAt(tblClientesVenta.getSelectedRow(), 0).toString());
            //BUSCA TODO DE PEDIDO
            tbmPedidosVenta.setRowCount(0);
            if(idCliente>0){
                stmt=conect.createStatement();
                res=stmt.executeQuery("SELECT ID_PEDIDO,FECHA_PEDIDO,FECHA_ENTREGA from PEDIDOS where ID_CLIENTE ="+idCliente+" AND ESTADO = 'N'");
                
            if(null!=res){
                while(res.next()){
                   tbmPedidosVenta.addRow(new Object[]{tblClientesVenta.getValueAt(tblClientesVenta.getSelectedRow(), 1),res.getInt("ID_PEDIDO"), res.getString("FECHA_PEDIDO"),res.getString("FECHA_ENTREGA")});
                }  
            }
            stmt.close();
            
            }else{
                showMessageDialog(this, "Selecciona un cliente para buscar pedidos en Venta.");
            }
            
        }catch (SQLException ex) {
             System.out.println("ERROR AL LLENAR PEDIDOS EN VENTA");
        } 
    }
    /**
     * Botón de agregar productos.
     * @param evt 
     */
    private void btnAgregarProvedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProvedorActionPerformed
        ventanaProveedor VP=new ventanaProveedor();
        VP.setLocationRelativeTo(null);

        VP.setVisible(true);
    }//GEN-LAST:event_btnAgregarProvedorActionPerformed

    /**
     * Cuadro de texto para buscar compras al presionar teclas.
     * @param evt 
     */
    private void txtBuscarComprasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarComprasKeyReleased
            try {
                BuscarProveedores();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_txtBuscarComprasKeyReleased

    /**
     * Cuadro de texto de buscar Producto en pedido al presionar teclas
     * @param evt 
     */
    private void txtBuscarProducto_PedidotxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProducto_PedidotxtBuscarKeyReleased
        buscarTablaProductos_Pedido();
    }//GEN-LAST:event_txtBuscarProducto_PedidotxtBuscarKeyReleased

    /**
     * Botón para agregar producto al carrito.
     * @param evt 
     */
    private void btnProductoAPedidojButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoAPedidojButton11ActionPerformed
         if(tblProductos_Pedido.getSelectedRow()>-1){
            
            AgregarcarritoPedido();
             sumartotalPedido();
        }
        else
        showMessageDialog(this,"Debe de seleccionar un articulo.");
    }//GEN-LAST:event_btnProductoAPedidojButton11ActionPerformed

    /**
     * Botón de eliminar Materia prima en Compra
     * @param evt 
     */
    private void btnEliminarMateriaPrima_CompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMateriaPrima_CompraActionPerformed
        restartotalyeliminarrow();
    }//GEN-LAST:event_btnEliminarMateriaPrima_CompraActionPerformed
    /**
     * Función que valida si existe en MAteria prima.
     * @param tMateriasPrimas Tabla de Materias Primas
     * @param tCompra Tabla de Compra
     * @param spin Spinner de la cantidad.
     * @return 
     */
    private boolean existeEnTabla(JTable tMateriasPrimas, JTable tCompra, JSpinner spin){

        for(int i = 0;i<tblCompra.getRowCount();i++){
            if (tblCompraslMateriasPrimas.getValueAt(tMateriasPrimas.getSelectedRow(),0)== tblCompra.getValueAt(i,0)){
                tblCompra.setValueAt((Integer.parseInt(tblCompra.getValueAt(i,2)+"")+Integer.parseInt(spin.getValue()+"")),i, 2);
                return true;
            }
        }
        
        return false;
    }
    /**
     * llena tabla con la información de bsuqueda  del proveedor del apartado de Nueva Compra
     * @throws ClassNotFoundException 
     */
    private void BuscarProveedores() throws ClassNotFoundException{
         try {
             conectarBD();
             Statement stmt = conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblProveedor_Compra.getModel();
           tbm.setRowCount(0);
           res=stmt.executeQuery("select * from PERSONAS "
                                            + "where TIPO = 'P' "
                                            + "AND NOMBRE LIKE '%" + txtBuscarCompras.getText() + "%'");
            if(null!=res){
                while(res.next()){
                   Vector rowProductos=new Vector();
                  rowProductos.add(res.getString("ID_PERSONA"));
                  rowProductos.add(res.getString("NOMBRE"));
                  rowProductos.add(res.getString("DOMICILIO"));
                  rowProductos.add(res.getString("TELEFONO"));
                  tbm.addRow(rowProductos);
                }
            }
            stmt.close();
        }catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en la conexion LLENAR TABLA");
        } 
    }
    /**
     * Genera la compra
     * @param evt 
     */
    private void btnGenerarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarCompraActionPerformed
    if(tblCompra.getRowCount()!=0 && tblProveedor_Compra.getSelectedRow()>-1){
        try { System.out.println("insertado");
                insertarCompra();
                detalle_compra();
                DefaultTableModel tbm=(DefaultTableModel)tblCompra.getModel();
                tbm.setRowCount(0);
                txtTotalCompra.setText("0");
                tblCompra.setModel(tbm);
                LlenarTablaCompras_MateriasPrimas();
                showMessageDialog(this, "¡Compra realizada exitosamente!");
            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    else if(tblProveedor_Compra.getSelectedRow()>-1){
            showMessageDialog(this,"Debe de ingresar articulos a la compra.");
    }
    else
        showMessageDialog(this,"Debe de seleccionar un proveedor.");
        
    }//GEN-LAST:event_btnGenerarCompraActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated
    /**
     * Genera la venta
     * @param evt 
     */
    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
        if(tblVenta.getRowCount() !=0 && tblClientesVenta.getSelectedRow()>-1){
        try {   
                
                insertarVenta();
                int idVentaImprimir=detalle_venta();
                actualizarEstadoPedido();
                llenarTablaPedidos_Venta();
                llenarTablaHistorialVentas();
                lblCambio.setText(cambio+"");
                Imprimir printVenta=new Imprimir();
                printVenta.imprimirVenta(nombreUsuario, idVentaImprimir,efectivo,cambio);
                txtEfectivo.setText("0.00");
                lblCambio.setText("0.00");
                
                tbmVenta.setRowCount(0);
                lblAnticipo.setText("0.00");
                lblTotalVenta1.setText("0.00");
                lblPagoRestante.setText("0.00");
                cambio=0;
                efectivo=0;
                
                System.out.println("¡Venta realizada exitosamente!");
            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(tblPedidosVentas.getSelectedRow()>-1){
            showMessageDialog(this,"Debe seleccionar el cliente y el pedido a pagar");
        

        // TODO add your handling code here:
                                      
        }
    }//GEN-LAST:event_btnGenerarVentaActionPerformed
    /**
     * realiza el cualculo del cambio al ingresar el importe en el apartado de Nueva venta
     */
    private void generarCambio(){
        try{
            efectivo = Float.parseFloat(txtEfectivo.getText());
        SaldoRestante = Float.parseFloat(lblPagoRestante.getText());
         
        if(efectivo >= SaldoRestante){
            cambio =Math.abs(efectivo - SaldoRestante);
            lblCambio.setText(""+cambio);
            
        }else{
            lblCambio.setText(0.0+"");
        }
        }catch(Exception e){
            
        }
        
        
    }
    /**
     * realiza el calculo del cambio al ingresar el importe  en el apartado de Nuevo Pedido
     */
    private void generarCambioPedido(){
        try{
            efectivo = Float.parseFloat(txtEfectivoPedido.getText());
            AdelantoPedido = Float.parseFloat(txtAdelantoPedido.getText());
         
        if(efectivo >= AdelantoPedido){
            cambio =Math.abs(efectivo - AdelantoPedido);
            lblCambioPedido.setText(""+cambio);
            
        }else{
            lblCambioPedido.setText(0.0+"");
        }
        }catch(Exception e){
            
        }
        
        
    }
    
    PlaceHolder holder;
    private void holders(){
        holder= new PlaceHolder(txtEfectivo,"0.0");

    }
    /**
     * Cambia el estado del pedido de No pagado a Pagado
     */
    private void actualizarEstadoPedido(){
        
            try {
                String cad = "UPDATE PEDIDOS " +
                        "SET ESTADO = 'P' " +
                        "WHERE ID_PEDIDO =" + tblPedidosVentas.getValueAt(tblPedidosVentas.getSelectedRow(),1) ;
                Statement stmt = conect.createStatement();
                stmt.executeUpdate(cad);
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }
    /**
     * limpia le carrito de compra del apartado Nueva Compra
     */
    void cancelarCompra(){
         DefaultTableModel tbm = (DefaultTableModel) tblCompra.getModel();
            for (int i = 0; i < tblCompra.getRowCount(); i++) {
            tbm.removeRow(i);
            i-=1;
            }
            tblCompra.setModel(tbm);
            txtTotalCompra.setText("0");
            s = 0;
    }
    /**
     * Botón de cancelar compra.
     * @param evt 
     */
    private void btnCancelar_CompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar_CompraActionPerformed
        cancelarCompra();
    }//GEN-LAST:event_btnCancelar_CompraActionPerformed
    /**
     * Cuadro de texto de buscar materias primas en compras.
     * @param evt 
     */
    private void txtBuscasMateriaPrima_ComprasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscasMateriaPrima_ComprasKeyTyped
        txtBuscasMateriaPrima_Compras.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                repaint();
                filtro();
            }
        });
        trsFiltro = new TableRowSorter(tblCompraslMateriasPrimas.getModel());
        tblCompraslMateriasPrimas.setRowSorter(trsFiltro);  
    }//GEN-LAST:event_txtBuscasMateriaPrima_ComprasKeyTyped

    /**
     * Botón de cancelar pedido.
     * @param evt 
     */
    private void btnCancelar_PedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar_PedidoActionPerformed
        cancelarPedido();
    }//GEN-LAST:event_btnCancelar_PedidoActionPerformed

    private void spncantidadMP_CompraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spncantidadMP_CompraStateChanged
        spinnerNeg(spncantidadMP_Compra);
    }//GEN-LAST:event_spncantidadMP_CompraStateChanged

    private void spncantidadProducto_PedidoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spncantidadProducto_PedidoStateChanged
        spinnerNeg(spncantidadMP_Compra);
    }//GEN-LAST:event_spncantidadProducto_PedidoStateChanged
    /**
     * Genera el pedido
     * @param evt 
     */
    private void btnGenerarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPedidoActionPerformed
        if(datePedido.getDate()!=null){
     
            
        
        if(tblPedido.getRowCount()!=0 && tblClientes_Pedido.getSelectedRow()>-1 && Float.parseFloat(txtAdelantoPedido.getText())>=(Float.parseFloat(txtTotalPedido.getText()))*.5){
        try { System.out.println("insertado");
                insertarPedido();
                int idPedido=detalle_pedido();
                DefaultTableModel tbm=(DefaultTableModel)tblPedido.getModel();
                Imprimir printPedido=new Imprimir();
                printPedido.imprimirPedido(nombreUsuario, idPedido, efectivo, cambio, AdelantoPedido);
                
                tbm.setRowCount(0);
                txtTotalPedido.setText("0");
                tblPedido.setModel(tbm);
                
                txtEfectivoPedido.setText("0.00");
                txtAdelantoPedido.setText("0");
                System.out.println("¡Pedido realizado exitosamente!");
            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    else if(tblClientes_Pedido.getSelectedRow()==-1){
            showMessageDialog(this,"Debe de seleccionar un cliente.");
    }
    else if(tblPedido.getRowCount()==0)
        showMessageDialog(this,"Debe de agregar un producto.");
        else
            showMessageDialog(this, "Debe de pagar un Anticipo minimo del 50%.");
        
        }
        else
            showMessageDialog(this,"Debe de seleccionar una de fecha entrega para la el pedido.");
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarPedidoActionPerformed

    /**
     * Botón de cancelar la venta.
     * @param evt 
     */
    private void btnCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVentaActionPerformed
        cancelarVenta();
    }//GEN-LAST:event_btnCancelarVentaActionPerformed
    /**
     * Botón de eliminar articulo en pedido.
     * @param evt 
     */
    private void btnEliminarArticuloPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarArticuloPedidoActionPerformed
        restartotalyeliminarrowPedido();
    }//GEN-LAST:event_btnEliminarArticuloPedidoActionPerformed

    private void txtBuscarClienteVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarClienteVentaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarClienteVentaMouseClicked

    /**
     * Evento al dar click en clientes de venta.
     * @param evt 
     */
    private void tblClientesVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesVentaMouseClicked
        llenarTablaPedidos_Venta();
    }//GEN-LAST:event_tblClientesVentaMouseClicked

    /**
     * Evento al dar click a la tabla de pedidos en venta.
     * @param evt 
     */
    private void tblPedidosVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidosVentasMouseClicked
        cargarPedido();
        generarCambio();
    }//GEN-LAST:event_tblPedidosVentasMouseClicked
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if(dateGeneracion.getDate()!=null){
       if(tblClientesVenta.getSelectedRow()>-1)
            BuscarPedidos();
       else
           showMessageDialog(this,"Debe de seleccionar un cliente para la busqueda.");
    }
    else 
        showMessageDialog(this,"Debe de seleccionar una fecha para la busqueda.");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Volver a llenar la tabla de pedidos en venta.
     * @param evt 
     */
    private void btnRefreshProducto_Pedido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshProducto_Pedido1ActionPerformed
    if(tblClientesVenta.getSelectedRow()>=0)
        llenarTablaPedidos_Venta();
    else
        showMessageDialog(null," Favor de seleccionar un cliente.");
    }//GEN-LAST:event_btnRefreshProducto_Pedido1ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        if(tblCompraslMateriasPrimas.getSelectedRow()>-1){
            
            Agregarcarrito();
             sumartotal();
        }
        else
        showMessageDialog(this,"Debe de seleccionar un articulo.");
     
    }//GEN-LAST:event_jButton20ActionPerformed
    /**
     * abre la ventana de acceso rapido de Materia Prima
     * @param evt 
     */
    private void btnNuevaMateriaPrima_ComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaMateriaPrima_ComprasActionPerformed
        VentanaMateriaPrima VMP=new VentanaMateriaPrima();
        VMP.setLocationRelativeTo(null);
        VMP.setVisible(true);
    }//GEN-LAST:event_btnNuevaMateriaPrima_ComprasActionPerformed

    private void txtBuscasMateriaPrima_ComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscasMateriaPrima_ComprasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscasMateriaPrima_ComprasActionPerformed

    /**
     * Botón para volver a llenar Materia prima en compra
     * @param evt 
     */
    private void btnRefreshMateriaPrima_CompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshMateriaPrima_CompraActionPerformed
        try {
                tbmCompra.setRowCount(0);
                //Busqueda
                LlenarTablaComprasMateriasPrimas();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnRefreshMateriaPrima_CompraActionPerformed
/**
 * Botón para volver a llenar la tabla de productos en pedido.
 * @param evt 
 */
    private void btnRefreshProducto_PedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshProducto_PedidoActionPerformed
        llenarTablaProductos();
    }//GEN-LAST:event_btnRefreshProducto_PedidoActionPerformed
/**
 * Evento al dar click en historial de compra para llenar el historial de compra.
 * @param evt 
 */
    private void tblHistorialComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHistorialComprasMouseClicked
        llenarTablaDetalleCompra();
    }//GEN-LAST:event_tblHistorialComprasMouseClicked
/**
 * Evento al dar click en historial de pedido para llenar el historial de pedido
 * @param evt 
 */
    private void tblHistorialPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHistorialPedidosMouseClicked
        llenarTablaDetallePedido();
    }//GEN-LAST:event_tblHistorialPedidosMouseClicked

    private void tb_PuntoVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_PuntoVentaMouseClicked
                llenarTablaHistorialPedidos();
                llenarTablaHistorialCompras();
    }//GEN-LAST:event_tb_PuntoVentaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            try {
                buscarHistorialPedido();
                // TODO add your handling code here:
            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton2ActionPerformed
/**
 * Reestablece la Busqueda del Historial de Pedidos
 * @param evt 
 */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        llenarTablaHistorialPedidos();
        txtBuscarCodigoPedidos.setText("");
        dateGeneracionPedido.setDate(null);
        dateEntegaPedidos.setDate(null);
        txtBuscarClientePedidos.setText("");
        txtBuscarEmpleadoPedidos.setText("");
        rdbPagado.setSelected(false);
        rdbNoPagado.setSelected(false);
        rdbCancelar.setSelected(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed
/**
 * Botón para buscar historial de compra.
 * @param evt 
 */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            try {
                buscarHistorialCompra();
                // TODO add your handling code here:
            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton4ActionPerformed
/**
 * Reestablece la busqueda del Historial de Compras
 * @param evt 
 */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         llenarTablaHistorialCompras();
        txtBuscarCodigoCompras.setText("");
        txtBuscarProveedorCompras.setText("");
        jDateChooser1.setDate(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed
/**
 * Evento de la tabla de historial de ventas para llenar su tabla.
 * @param evt 
 */
    private void tblHistorialVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHistorialVentasMouseClicked
        llenarTablaDetalleVenta();
    }//GEN-LAST:event_tblHistorialVentasMouseClicked
/**
 * Bottón paara buscar historial de venta.
 * @param evt 
 */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
            try {
                buscarHistorialVenta();
                // TODO add your handling code here:
            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton6ActionPerformed
/**
 * Restablece la busqueda del Historial de Pedidos
 * @param evt 
 */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

         llenarTablaHistorialVentas();
         txtBuscarCodigoPedidos1.setText("");
         txtBuscarClientePedidos1.setText("");
         txtBuscarEmpleadoPedidos1.setText("");
         dateGeneracionPedido1.setDate(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed
/**
 * Valida que no se pueda retirar una cantidad mayor de materia prima a la actual
 * @param evt 
 */
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
            try {
                if( Integer.parseInt(tablaMateriaPrima.getValueAt(tablaMateriaPrima.getSelectedRow(),3).toString()) >= Integer.parseInt(spnrMP.getValue().toString())){
                retirarMateriaPrima();
                llenarMateriaPrima();
            }
                else{
                    showMessageDialog(null,"Porfavor ingrese una cantidad válida no puede retirar mas materias primas de las actuales");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void spnrMPStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnrMPStateChanged
        spinnerNeg(spnrMP);
    }//GEN-LAST:event_spnrMPStateChanged

    private void btnGenerarVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGenerarVentaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarVentaKeyTyped

    private void txtEfectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyTyped
      
      
              ValidarNumeros(evt,txtEfectivo);
        generarCambio();
    }//GEN-LAST:event_txtEfectivoKeyTyped

    private void txtEfectivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyReleased
generarCambio();
 
    }//GEN-LAST:event_txtEfectivoKeyReleased

    private void txtEfectivoPedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoPedidoKeyReleased
        
     generarCambioPedido();
    }//GEN-LAST:event_txtEfectivoPedidoKeyReleased

    private void txtEfectivoPedidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoPedidoKeyTyped
        generarCambioPedido();
        ValidarNumeros(evt,txtEfectivoPedido);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEfectivoPedidoKeyTyped

    private void txtAgregarPresentacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgregarPresentacionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgregarPresentacionKeyTyped

    private void txtAgregarPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgregarPresentacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgregarPresentacionActionPerformed
/**
 * Realiza el registro de una nueva MPresentación para los Produtos
 * @param evt 
 */
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
         if(!txtAgregarPresentacion.getText().equals("")){
                        String cad = "INSERT INTO Presentacion VALUES('"+txtAgregarPresentacion.getText()+"',)";
            try {
                java.sql.Statement stmt=conect.createStatement();

                stmt.executeUpdate(cad);
                LlenarTablaP();
                   stmt.close();
            } catch (ClassNotFoundException ex) {
                
            } catch (SQLException ex) {
                
            }
         }
            try {
                llenarPresentacion();
                // TODO add your handling code here:
            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void txtAgregarPresentacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgregarPresentacion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgregarPresentacion1ActionPerformed

    private void txtAgregarPresentacion1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgregarPresentacion1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgregarPresentacion1KeyTyped
/**
 * Reliza la inserción de una nueva presentación para Materias Primas
 * @param evt 
 */
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
             if(!txtAgregarPresentacion1.getText().equals("")){
                        String cad = "INSERT INTO PresentacionM VALUES('"+txtAgregarPresentacion1.getText()+"')";
            try {
                java.sql.Statement stmt=conect.createStatement();

                stmt.executeUpdate(cad);
                LlenarTablaP();
                   stmt.close();
            } catch (ClassNotFoundException ex) {
                
            } catch (SQLException ex) {
                
            }
         }
            try {
                llenarPresentacionM();
                // TODO add your handling code here:
            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void tb_principalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_principalMouseClicked
        datosreporte();
    }//GEN-LAST:event_tb_principalMouseClicked

    private void txtBuscarPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPKeyReleased
            try {
                LlenarTablaBus();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_txtBuscarPKeyReleased
/**
 * cambia el estado del pedido a cancelado
 */
    private void btnCancelar_Pedido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar_Pedido1ActionPerformed
      
         
            
            try {
                String cad = "update pedidos set estado='C' WHERE  ID_PEDIDO="+tblHistorialPedidos.getValueAt(tblHistorialPedidos.getSelectedRow(),0)+"";
                java.sql.Statement stmt=conect.createStatement();

                stmt.executeUpdate(cad);
                llenarTablaHistorialPedidos();
            } catch (Exception ex) {

            }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelar_Pedido1ActionPerformed
    /**
     * Imprimer el Estado  de Resultados
     */
    private void imprimirDatosReporte(){
        Imprimir printReporte=new Imprimir();
        String fecha="05";
        VENTAS=Float.parseFloat(lblTotalVentas.getText());
        ADELANTOS=Float.parseFloat(lblTotalAdelantos.getText());
        COMPRAS=Float.parseFloat(lblTotalCompras.getText());
        
        printReporte.imprimirReporte(fecha,VENTAS,ADELANTOS,COMPRAS,(VENTAS+ADELANTOS),COMPRAS,RELACION,lblMateriaVendida.getText(),lblProductomasVentas.getText(),lblProveedormasCompras.getText(),lblClienteActivo.getText());
    }
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        imprimirDatosReporte();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void txtBuscarProducto_PedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarProducto_PedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProducto_PedidoActionPerformed

    private void txtEfectivoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEfectivoFocusLost
     
        
    }//GEN-LAST:event_txtEfectivoFocusLost

    private void txtEfectivoPedidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEfectivoPedidoFocusLost
 
    }//GEN-LAST:event_txtEfectivoPedidoFocusLost

    private void txtAdelantoPedidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAdelantoPedidoFocusLost
  
    }//GEN-LAST:event_txtAdelantoPedidoFocusLost

    private void txtPrecioMateriaPrimaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioMateriaPrimaFocusLost
     
    }//GEN-LAST:event_txtPrecioMateriaPrimaFocusLost

    private void txtprecioPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtprecioPFocusLost
  
    }//GEN-LAST:event_txtprecioPFocusLost

    private void txtAdelantoPedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdelantoPedidoKeyReleased
       
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdelantoPedidoKeyReleased

    private void txtPrecioMateriaPrimaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioMateriaPrimaKeyReleased
    
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioMateriaPrimaKeyReleased

    private void txtprecioPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioPKeyReleased
       
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioPKeyReleased

    private void txtEfectivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyPressed
    
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEfectivoKeyPressed

    private void txtAdelantoPedidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdelantoPedidoKeyTyped
          ValidarNumeros(evt,txtAdelantoPedido);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdelantoPedidoKeyTyped

    private void txtPrecioMateriaPrimaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioMateriaPrimaKeyTyped
        ValidarNumeros(evt,txtPrecioMateriaPrima);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioMateriaPrimaKeyTyped

    private void txtEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEfectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEfectivoActionPerformed

    private void txtCPCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPCKeyTyped
           char l=evt.getKeyChar();
        if(!(Character.isDigit(l) ) )
            evt.consume();
     
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPCKeyTyped

    private void txtTelCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelCKeyTyped
           char l=evt.getKeyChar();
        if(!(Character.isDigit(l) ) )
            evt.consume();
     
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelCKeyTyped
    /**
     * Lllena el combo de las presentaciones de Materias Primas
     * @throws SQLException 
     */
       private void llenarPresentacionM() throws SQLException{
             stmt=conect.createStatement();
            res=stmt.executeQuery("Select presentacionM from presentacionM");
            if(null!=res){
                cmbUnidadMedidaMP.removeAllItems();
                while(res.next()){
                   cmbUnidadMedidaMP.addItem(res.getString(1));
                }  
            }
            stmt.close();
        }
    /**
     * LLen el combo de las presentaciones de los Productos
     * @throws SQLException 
     */
   private void llenarPresentacion() throws SQLException{
             stmt=conect.createStatement();
            res=stmt.executeQuery("Select presentacion from presentacion");
            if(null!=res){
                cmbUnidadMedidaProducto.removeAllItems();
                while(res.next()){
                   cmbUnidadMedidaProducto.addItem(res.getString(1));
                }  
            }
            stmt.close();
        }
/**
 * Decrece la existencia de materias primas existentes
 */
    private void retirarMateriaPrima(){
         try {
            
            Statement stmt = conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tablaMateriaPrima.getModel();
            tbm.setRowCount(0);
            stmt.executeUpdate("UPDATE MATERIAS_PRIMAS " +
                               "  SET CANT_DISP = (CANT_DISP - " + spnrMP.getValue() + ")" +
                               "  where ID_MATERIA = " + r);
            res=stmt.executeQuery("SELECT * from MATERIAS_PRIMAS");
            if(null!=res){
                while(res.next()){
                   tbm.addRow(new Object[]{res.getInt(1),res.getDate(2),res.getDate(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7),res.getInt(8),res.getInt(8)-res.getInt(7)});
                }  
            }
            stmt.close();
        }catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en llenar tabla HistorialPedidos");
        } 
    }
    /**
     * Busca la información y la muestra en la tabla de Historial de compras en base a los diferentes filtros que se presentan
     * @throws SQLException 
     */
    private void buscarHistorialCompra() throws SQLException{
            stmt = conect.createStatement();
          
            String  bus1="",bus2="",bus3="";
           
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        //insersion de codigos de busqueda
        if(!txtBuscarCodigoCompras.getText().equals(""))
            bus1= " AND ID_COMPRA LIKE '%"+txtBuscarCodigoCompras.getText()+"%'";
        if(!txtBuscarProveedorCompras.getText().equals(""))
            bus2 = " AND PERSONAS.NOMBRE LIKE '%"+txtBuscarProveedorCompras.getText()+"%'";
        if(jDateChooser1.getDate()!=null){
            String date2 = simpleDateFormat.format(jDateChooser1.getDate());
            bus3=" AND FECHA = '"+ date2+"'";}
 
          Statement stmt = conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblHistorialCompras.getModel();
            tbm.setRowCount(0);
            
            res=stmt.executeQuery("SELECT ID_COMPRA, PERSONAS.NOMBRE, FECHA,TOTAL FROM COMPRAS, PERSONAS WHERE PERSONAS.ID_PERSONA = COMPRAS.ID_PROVEEDOR"
                     + bus1 +bus2+bus3);
            if(null!=res){
                while(res.next()){
                   tbm.addRow(new Object[]{res.getInt(1),res.getString(3),res.getString(2),res.getInt(4)});
                }  
            }
    
    }
    
    /**
     * Busca la información y la presenta en la tabla de historial de Pedidos en base  a los diferentes filtros que se presentan
     * @throws SQLException 
     */
    private void buscarHistorialPedido() throws SQLException{
            stmt = conect.createStatement();
          String  Bus = "";
            String  bus1="",bus2="",bus3="",bus4="",bus5="";
           if(rdbPagado.isSelected())
               Bus = "P";
           if(rdbNoPagado.isSelected())
               Bus = "N";
           if(rdbCancelar.isSelected())
               Bus = "C";
           System.out.println("select ID_PEDIDO, FECHA_PEDIDO, FECHA_ENTREGA, PERSONAS.NOMBRE,NOMBRE_USUARIO,ESTADO,ADELANTO,TOTAL FROM"
                    + " PERSONAS, PEDIDOS,USUARIOS "
                    + "WHERE PERSONAS.ID_PERSONA = PEDIDOS.ID_CLIENTE AND PEDIDOS.ID_USUARIO = USUARIOS.ID_USUARIO "
                    + ""
                    + bus1 + bus2 + bus3 + bus4 + bus5);
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        //insersion de codigos de busqueda
        if(!txtBuscarCodigoPedidos.getText().equals(""))
            bus1= " AND ID_PEDIDO LIKE '%"+txtBuscarCodigoPedidos.getText()+"%'";
        
        if(dateGeneracionPedido.getDate()!=null){
            String date2 = simpleDateFormat.format(dateGeneracionPedido.getDate());
            bus2=" AND FECHA_PEDIDO = '"+ date2+"'";}
        
        if(dateEntegaPedidos.getDate()!=null){
            String date = simpleDateFormat.format(dateEntegaPedidos.getDate());
            bus2=" AND FECHA_ENTREGA = '"+ date +"'";}
        
        if(!txtBuscarClientePedidos.getText().equals(""))
            bus3 = " AND PERSONAS.NOMBRE LIKE '%"+txtBuscarClientePedidos.getText()+"%'";
        
        if(!txtBuscarEmpleadoPedidos.getText().equals(""))
            bus4 = " AND NOMBRE_USUARIO LIKE '%"+txtBuscarEmpleadoPedidos.getText()+"%'";
       
        if(rdbPagado.isSelected()||rdbNoPagado.isSelected()||rdbCancelar.isSelected())
            bus5 = " AND ESTADO = '"+Bus+"'";
           
          Statement stmt = conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblHistorialPedidos.getModel();
            tbm.setRowCount(0);
            res=stmt.executeQuery("select ID_PEDIDO, FECHA_PEDIDO, FECHA_ENTREGA, PERSONAS.NOMBRE,NOMBRE_USUARIO,ESTADO,ADELANTO,TOTAL FROM"
                    + " PERSONAS, PEDIDOS,USUARIOS "
                    + "WHERE PERSONAS.ID_PERSONA = PEDIDOS.ID_CLIENTE AND PEDIDOS.ID_USUARIO = USUARIOS.ID_USUARIO "
                    + ""
                    + bus1 + bus2 + bus3 + bus4 + bus5);

 System.out.println("select ID_PEDIDO, FECHA_PEDIDO, FECHA_ENTREGA, PERSONAS.NOMBRE,NOMBRE_USUARIO,ESTADO,ADELANTO,TOTAL FROM"
                    + " PERSONAS, PEDIDOS,USUARIOS "
                    + "WHERE PERSONAS.ID_PERSONA = PEDIDOS.ID_CLIENTE AND PEDIDOS.ID_USUARIO = USUARIOS.ID_USUARIO "
                    + ""
                    + bus1 + bus2 + bus3 + bus4 + bus5);

            if(null!=res){
                while(res.next()){
                   tbm.addRow(new Object[]{res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7),res.getInt(8),res.getInt(8)-res.getInt(7)});
                }  
            }
    
    }
    /**
     * Llena la tabla de historial de Pedidos
     */
    private void llenarTablaHistorialPedidos(){
         try {
             
            DefaultTableModel tbm=(DefaultTableModel)tblHistorialPedidos.getModel();
            tbm.setRowCount(0);
            res=stmt.executeQuery("select ID_PEDIDO, FECHA_PEDIDO, FECHA_ENTREGA, PERSONAS.NOMBRE,NOMBRE_USUARIO,ESTADO,ADELANTO,TOTAL FROM PERSONAS, PEDIDOS,USUARIOS WHERE PERSONAS.ID_PERSONA = PEDIDOS.ID_CLIENTE AND PEDIDOS.ID_USUARIO = USUARIOS.ID_USUARIO");
            if(null!=res){
                while(res.next()){
                   tbm.addRow(new Object[]{res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7),res.getInt(8),res.getInt(8)-res.getInt(7)});
                }  
            }
            stmt.close();
        }catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex.toString() + "\n" +"Error en llenar tabla HistorialPedidos");
        } 
    }  
    /**
     * Llena la tabla de historial de Ventas
     */
     private void llenarTablaHistorialVentas(){
         try {
             
            Statement stmt = conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblHistorialVentas.getModel();
            tbm.setRowCount(0);
            res=stmt.executeQuery("select ID_VENTA, FECHA, PERSONAS.NOMBRE ,NOMBRE_USUARIO,TOTAL FROM PERSONAS, VENTAS,USUARIOS WHERE PERSONAS.ID_PERSONA = VENTAS.ID_CLIENTE AND VENTAS.ID_USUARIO = USUARIOS.ID_USUARIO");
            if(null!=res){
                while(res.next()){
                   tbm.addRow(new Object[]{res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5)});
                }  
            }
            stmt.close();
        }catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en llenar tabla HistorialVentas");
        } 
    } 
     /**
      * Llena la tabla de historial de Ventas
      * @throws SQLException 
      */
     private void buscarHistorialVenta() throws SQLException{
            stmt = conect.createStatement();
         
            String  bus1="",bus2="",bus3="",bus4="";
           
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        //insersion de codigos de busqueda
        if(!txtBuscarCodigoPedidos1.getText().equals(""))
            bus1= " AND ID_VENTA LIKE '%"+txtBuscarCodigoPedidos1.getText()+"%'";
        
        if(dateGeneracionPedido1.getDate()!=null){
            String date2 = simpleDateFormat.format(dateGeneracionPedido1.getDate());
            System.err.println(date2);
            bus2=" AND FECHA = '"+ date2+"'";}
        
 
        if(!txtBuscarClientePedidos1.getText().equals(""))
            bus3 = " AND PERSONAS.NOMBRE LIKE '%"+txtBuscarClientePedidos1.getText()+"%'";
        
        if(!txtBuscarEmpleadoPedidos1.getText().equals(""))
            bus4 = " AND NOMBRE_USUARIO LIKE '%"+txtBuscarEmpleadoPedidos1.getText()+"%'";
       
     
           
          stmt = conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblHistorialVentas.getModel();
            tbm.setRowCount(0);
            res=stmt.executeQuery("select ID_VENTA, FECHA, PERSONAS.NOMBRE ,NOMBRE_USUARIO,TOTAL FROM PERSONAS, VENTAS,USUARIOS WHERE PERSONAS.ID_PERSONA = VENTAS.ID_CLIENTE AND VENTAS.ID_USUARIO = USUARIOS.ID_USUARIO "
                    + ""
                    + bus1 + bus2 + bus3 + bus4 );
            
            
            if(null!=res){
                while(res.next()){
                   tbm.addRow(new Object[]{res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5)});}  
            }
    
    }
     
     /**
      * Muestra el detalle del pedido seleccionado de la tabla Historial Pedidos
      * 
      */
private void llenarTablaDetallePedido(){
         try {

            Statement stmt=conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblpruebapedidos.getModel();
            tbm.setRowCount(0);
            res=stmt.executeQuery("SELECT PRODUCTOS.NOMBRE,DETALLE_PEDIDO.CANTIDAD,(DETALLE_PEDIDO.TOTAL/DETALLE_PEDIDO.CANTIDAD) AS UNITARIO,PRODUCTOS.UNIDAD,DETALLE_PEDIDO.TOTAL " +
                         "FROM PRODUCTOS INNER JOIN DETALLE_PEDIDO ON PRODUCTOS.ID_PRODUCTO = DETALLE_PEDIDO.ID_PRODUCTO " +
                         "AND DETALLE_PEDIDO.ID_PEDIDO = " + tblHistorialPedidos.getValueAt(tblHistorialPedidos.getSelectedRow(),0)
                        );
            if(null!=res){
                while(res.next()){
                   tbm.addRow(new Object[]{res.getString("NOMBRE"),res.getString("CANTIDAD"),res.getString("UNITARIO"),res.getString("UNIDAD"),res.getString("TOTAL")});
                }
            }
            stmt.close();
        }catch (SQLException ex) {
            showMessageDialog(null," Error en AL LLENAR TABLA PRODUCTOS POR BUSQUEDA. "); 
        }
    }
/**
 * Muestra el detalle de la venta  seleccionada de la tabla Hisotrial de Venta
 */
    private void llenarTablaDetalleVenta(){
         try {

            Statement stmt=conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblDetalleVentas.getModel();
            tbm.setRowCount(0);
            res=stmt.executeQuery("SELECT PRODUCTOS.NOMBRE,DETALLE_VENTAS.CANTIDAD,(DETALLE_VENTAS.TOTAL/DETALLE_VENTAS.CANTIDAD) AS UNITARIO,PRODUCTOS.UNIDAD,DETALLE_VENTAS.TOTAL " +
                         "FROM PRODUCTOS INNER JOIN DETALLE_VENTAS ON PRODUCTOS.ID_PRODUCTO = DETALLE_VENTAS.ID_PRODUCTO " +
                         "AND DETALLE_VENTAS.ID_VENTA ="+ tblHistorialVentas.getValueAt(tblHistorialVentas.getSelectedRow(),0)
                        );
            if(null!=res){
                while(res.next()){
                   tbm.addRow(new Object[]{res.getString("NOMBRE"),res.getString("CANTIDAD"),res.getString("UNITARIO"),res.getString("UNIDAD"),res.getString("TOTAL")});
                }
            }
            stmt.close();
        }catch (SQLException ex) {
            showMessageDialog(null," Error en AL LLENAR TABLA PRODUCTOS POR BUSQUEDA. "); 
        }
    }
    /**
     * Llena la tabla del historial de comoras
     */
    
    private void llenarTablaHistorialCompras(){
         try {
            DefaultTableModel tbm=(DefaultTableModel)tblHistorialCompras.getModel();
            tbm.setRowCount(0);
            res=stmt.executeQuery("SELECT ID_COMPRA, FECHA, PERSONAS.NOMBRE, TOTAL " +
                         "FROM COMPRAS INNER JOIN PERSONAS ON COMPRAS.ID_PROVEEDOR = PERSONAS.ID_PERSONA " 
                        );
            if(null!=res){
                while(res.next()){
                   tbm.addRow(new Object[]{res.getString("ID_COMPRA"),res.getString("FECHA"),res.getString("NOMBRE"),res.getString("TOTAL")});
                }  
            }
            stmt.close();
        }catch (SQLException ex) {
            showMessageDialog(null," Error en AL LLENAR TABLA PRODUCTOS POR BUSQUEDA. "); 
        }
    }

/**
     * Muestra el detalle de la compra seleccionada en la tabla de Historial Compras
     */
private void llenarTablaDetalleCompra(){
         try {
            DefaultTableModel tbm=(DefaultTableModel)tblDetalleCompra.getModel();
            tbm.setRowCount(0);
            res=stmt.executeQuery("SELECT MATERIAS_PRIMAS.NOMBRE,DETALLE_COMPRA.CANTIDAD,(DETALLE_COMPRA.TOTAL/DETALLE_COMPRA.CANTIDAD)AS UNITARIO,MATERIAS_PRIMAS.UNIDAD_MEDIDA,DETALLE_COMPRA.TOTAL " +
                         "FROM MATERIAS_PRIMAS INNER JOIN DETALLE_COMPRA ON MATERIAS_PRIMAS.ID_MATERIA = DETALLE_COMPRA.ID_MATERIA_PRIMA " +
                         "AND DETALLE_COMPRA.ID_COMPRA = " + tblHistorialCompras.getValueAt(tblHistorialCompras.getSelectedRow(),0)
                        );
            if(null!=res){
                while(res.next()){
                   tbm.addRow(new Object[]{res.getString("NOMBRE"),res.getString("CANTIDAD"),res.getString("UNITARIO"),res.getString("UNIDAD_MEDIDA"),res.getString("TOTAL")});
                }
            }
            stmt.close();
        }catch (SQLException ex) {
            showMessageDialog(null," Error en AL LLENAR TABLA PRODUCTOS POR BUSQUEDA. "); 
        }
    }
    
    /**
     * Restablece los valores por defecto de la ventana de Nueva Venta
     */
    void cancelarVenta(){
         DefaultTableModel tbm = (DefaultTableModel) tblVenta.getModel();
            for (int i = 0; i < tblVenta.getRowCount(); i++) {
            tbm.removeRow(i);
            i-=1;
            }
            lblCambio.setText("0.00");
            tblVenta.setModel(tbm);
            txtEfectivo.setText("0.00");
            lblAnticipo.setText("0.00");
            lblTotalVenta1.setText("0.00");
            lblPagoRestante.setText("0.00");
    }
    /**
     * Reestablece los valores por defecto de la ventana de Nueo Pedido
     */
    void cancelarPedido(){
         DefaultTableModel tbm = (DefaultTableModel) tblPedido.getModel();
            for (int i = 0; i < tblPedido.getRowCount(); i++) {
            tbm.removeRow(i);
            i-=1;
            }
            txtAdelantoPedido.setText("0.00");
            txtEfectivoPedido.setText("0.00");
            lblCambioPedido.setText("0.00");
            tblPedido.setModel(tbm);
            txtTotalPedido.setText("0.00");
            
            s = 0;
    }

    /**
     * Inserta el detalle del nuevo pedido registrado
     * @return 
     */
    private int detalle_pedido(){
            try {
                cad ="";
                int idp = tblClientes_Pedido.getSelectedRow();
                Statement stmt = conect.createStatement();
                res=stmt.executeQuery("SELECT MAX (ID_PEDIDO)  FROM PEDIDOS");
                int id = 0;
                while (res.next()){
                    id = res.getInt(1);
                }
                for (int i = 0;i< tblPedido.getRowCount();i++){
                    cad = "INSERT INTO DETALLE_PEDIDO" +
                            " VALUES( " + id +
                            "," + tblPedido.getValueAt(i,0).toString() +
                            "," + tblPedido.getValueAt(i,3).toString() +
                            "," + tblClientes_Pedido.getValueAt(idp,0) +
                            "," + tblPedido.getValueAt(i,4).toString() +
                            ")";
                            stmt.executeUpdate(cad);
                            }
               stmt.close(); 
               return id;
            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            }
               return 0;
    }
    

    /**
     * Realiza la consulta para el registro de una nueva Venta
     * @throws SQLException 
     */
    private void insertarVenta() throws SQLException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        
        String date = simpleDateFormat.format(new Date());
        String cad = "INSERT INTO VENTAS (FECHA,ID_CLIENTE,ID_USUARIO,TOTAL) "
                    + "VALUES('"+ date +"',"
                    + idCliente +","+id_usuario+","+lblTotalVenta1.getText()+")";
            Statement stmt = conect.createStatement();
            stmt.executeUpdate(cad);
            actCant();
            //showMessageDialog(null,"Proveedor Registrado");
            stmt.close();

    }
    /**
     * Realiza el registro de el detalle de una Nueva Venta
     * @return 
     */
    private int detalle_venta(){
            try {
                cad ="";
                Statement stmt = conect.createStatement();
                res=stmt.executeQuery("SELECT MAX (ID_VENTA)  FROM VENTAS");
                int id = 0;
                while (res.next()){
                    id = res.getInt(1);
                }
                for (int i = 0;i< tblVenta.getRowCount();i++){
                    cad = "INSERT INTO DETALLE_VENTAS" +
                            " VALUES( " + id +
                            "," + tblVenta.getValueAt(i,0).toString() +
                            "," + tblVenta.getValueAt(i,3).toString() +
                            "," + idCliente +
                            "," + tblVenta.getValueAt(i,4).toString() +
                            ")";
                            stmt.executeUpdate(cad);
                            }
               stmt.close(); 
               return id;
            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            }
               return 0;
    }
    /**
     * Actualiza el total del pedido al eliminar un producto del carrito de pedido
     */
    void restartotalyeliminarrowPedido(){
        r = tblPedido.getSelectedRow();
        if( r != -1){
            DefaultTableModel tbm = (DefaultTableModel) tblPedido.getModel();
            s -= Float.parseFloat(tblPedido.getValueAt(r,4).toString());
            tbm.removeRow(r);
            tblPedido.setModel(tbm);
            txtTotalPedido.setText("" +s);
            System.out.print("IF" +   "    " +r);
        }else{
            r = tblPedido.getRowCount()-1;
            DefaultTableModel tbm = (DefaultTableModel) tblPedido.getModel();
            s -= Float.parseFloat(tblPedido.getValueAt(r,4).toString());
            tbm.removeRow(r);
            tblPedido.setModel(tbm);
            txtTotalPedido.setText("" +s);
            System.out.print("ELSE");
        }
        
    }
    /**
     * suma el monto total de lso pedidos agregardos al carrito de pedidos
     */
    void sumartotalPedido(){
        s = Float.parseFloat(txtTotalPedido.getText());
        r =tblPedido.getRowCount()-1;
        s+= Float.parseFloat(tblPedido.getValueAt(r,4).toString());
        txtTotalPedido.setText(""+s);
    }
    
    /**
     *Realiza la carga de datos de el pedido seleccionado y llena la tabla de ventas  
     */
    private void cargarPedido(){
            try {
     
                stmt = conect.createStatement();
                tbmVenta=(DefaultTableModel)tblVenta.getModel();
                tbmVenta.setRowCount(0);
                System.out.print(tblPedidosVentas.getValueAt(tblPedidosVentas.getSelectedRow(),1));
                res=stmt.executeQuery("SELECT PRODUCTOS.ID_PRODUCTO,PRODUCTOS.NOMBRE,PRODUCTOS.PRECIO, DETALLE_PEDIDO.CANTIDAD, (DETALLE_PEDIDO.CANTIDAD * PRODUCTOS.PRECIO) AS TOTAL " +
                                "FROM PRODUCTOS INNER JOIN DETALLE_PEDIDO ON PRODUCTOS.ID_PRODUCTO = DETALLE_PEDIDO.ID_PRODUCTO " +
                                "AND DETALLE_PEDIDO.ID_PEDIDO =" + tblPedidosVentas.getValueAt(tblPedidosVentas.getSelectedRow(),1));
                if(null!=res){
                    while(res.next()){
                        Vector rowProductos=new Vector();
                        rowProductos.add(res.getString(1));
                        rowProductos.add(res.getString(2));
                        rowProductos.add(res.getString(3));
                        rowProductos.add(res.getString(4));
                        rowProductos.add(res.getString(5));
                        tbmVenta.addRow(rowProductos);
                    }
                    
                    res=stmt.executeQuery("SELECT ADELANTO FROM PEDIDOS WHERE ID_PEDIDO =" + tblPedidosVentas.getValueAt(tblPedidosVentas.getSelectedRow(),1));
                    if(null!=res){
                        while(res.next()){
                            lblAnticipo.setText(""+res.getFloat(1));
                        }
                    }
                    
                    stmt.executeQuery("SELECT TOTAL FROM PEDIDOS WHERE ID_PEDIDO =" + tblPedidosVentas.getValueAt(tblPedidosVentas.getSelectedRow(),1));
                    if(null!=res){
                        while(res.next()){
                            lblTotalVenta1.setText(""+ res.getFloat(1));
                        }
                    }
                    Float T,A;
                    
                    T = Float.parseFloat(lblTotalVenta1.getText());
                    A = Float.parseFloat(lblAnticipo.getText());
                    lblPagoRestante.setText("" + (T-A));
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }
    
    /**
     * Realiza la busqueda de los clientes en la ventana Ventas y filtra la tabla de clientes con la busqueda
     * @throws ClassNotFoundException 
     */
    private void BuscarClientesVenta() throws ClassNotFoundException{
         try {
             
             Statement stmt = conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblClientesVenta.getModel();
           tbm.setRowCount(0);
           res=stmt.executeQuery("select ID_PERSONA, NOMBRE ,APE_PAT, APE_MAT ,TELEFONO from PERSONAS "
                                            + "where TIPO = 'C' "
                                            + "AND NOMBRE LIKE '%" + txtBuscarClienteVenta.getText() + "%'");
            if(null!=res){
                while(res.next()){
                   Vector rowCliente=new Vector();
                  rowCliente.add(res.getInt("ID_PERSONA"));
                  rowCliente.add(res.getString("NOMBRE"));
                  rowCliente.add(res.getString("APE_PAT"));
                  rowCliente.add(res.getString("APE_MAT"));
                  rowCliente.add(res.getString("TELEFONO"));
                  tbm.addRow(rowCliente);
                }
            }
            stmt.close();
        }catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en la conexion LLENAR TABLA");
        } 
    }
    
    /**
     * Agrega el product seleccionado a la tabla de Pedidos (Carrit de pedido)
     */
    private void AgregarcarritoPedido(){
    
            r = tblProductos_Pedido.getSelectedRow();
            String pedido[] = new String[5];
            pedido[0] = tblProductos_Pedido.getValueAt(r,0).toString();
            pedido[1] = tblProductos_Pedido.getValueAt(r,1).toString();
            pedido[2] = tblProductos_Pedido.getValueAt(r,4).toString();
            pedido[3] = spncantidadProducto_Pedido.getValue().toString();
            pedido[4] = ""+Float.parseFloat(pedido[2]) * Float.parseFloat(pedido[3]);
       
            tbmpedido.addRow(pedido);
    }

    



    /**
     * Agrega el producto seleccionado a la tabla de Compra(carrito de compra)
     */
    void Agregarcarrito(){
        
        if(existeEnTabla(tblCompraslMateriasPrimas, tblCompra, spncantidadMP_Compra)){
        }else{
            r = tblCompraslMateriasPrimas.getSelectedRow();
            String compra[] = new String[5];
            compra[0] = tblCompraslMateriasPrimas.getValueAt(r,0).toString();
            compra[1] = tblCompraslMateriasPrimas.getValueAt(r,1).toString();
            compra[2] = spncantidadMP_Compra.getValue().toString();
            compra[3] = tblCompraslMateriasPrimas.getValueAt(r,3).toString();
            compra[4] = ""+Float.parseFloat(compra[2]) * Float.parseFloat(compra[3]);
       
            tbmCompra.addRow(compra);
        }
        
    }
   
    /**
     *  Realiza la busqueda de los clientes en la ventana Pedidos y filtra la tabla de clientes con la busqueda
     * @throws ClassNotFoundException Clase no encontrada
     */
    private void BuscarClientes() throws ClassNotFoundException{
         try {
            conectarBD();
            Statement stmt = conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblClientes_Pedido.getModel();
           tbm.setRowCount(0);
           res=stmt.executeQuery("select ID_PERSONA, NOMBRE ,APE_PAT, APE_MAT ,TELEFONO from PERSONAS "
                                            + "where TIPO = 'C' "
                                            + "AND NOMBRE LIKE '%" + txtBuscarCliente_Pedido.getText() + "%'");
            if(null!=res){
                while(res.next()){
                   Vector rowProductos=new Vector();
                  rowProductos.add(res.getString("ID_PERSONA"));
                  rowProductos.add(res.getString("NOMBRE"));
                  rowProductos.add(res.getString("APE_PAT"));
                  rowProductos.add(res.getString("APE_MAT"));
                  rowProductos.add(res.getString("TELEFONO"));
                  tbm.addRow(rowProductos);
                }
            }
            stmt.close();
        }catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en la conexion LLENAR TABLA");
        } 
    }
    
    /**
     * Genera el pedido con los datos ingresados en la tabla pedidos y se insertan en la BD
     * @throws SQLException 
     */
            private void insertarPedido() throws SQLException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        
        String date = simpleDateFormat.format(new Date());
        String date2 = simpleDateFormat.format(datePedido.getDate());
        System.out.println(date2);
        r = tblClientes_Pedido.getSelectedRow();
        String cad = "INSERT INTO PEDIDOS (FECHA_PEDIDO,FECHA_ENTREGA,ID_CLIENTE,ID_USUARIO,ESTADO,ADELANTO,TOTAL)"
                    + "VALUES('"+ date +"','"+date2+"',"
                    + tblClientes_Pedido.getValueAt(r,0).toString()+","+id_usuario+",'N',"+txtAdelantoPedido.getText()+","+txtTotalPedido.getText()+")";
            //Statement stmt = conect.createStatement();
            stmt.executeUpdate(cad);
            actCant();
            //showMessageDialog(null,"Proveedor Registrado");
            stmt.close();

    }

            /**
             *  Genera a compra con los datos ingresados en la tabla compra y se insertan en la BD
             * @throws SQLException 
             */
    private void insertarCompra () throws SQLException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(new Date());
        r = tblProveedor_Compra.getSelectedRow();
    
        String cad = "INSERT INTO COMPRAS (FECHA,ID_PROVEEDOR,TOTAL) "
                    + "VALUES('"+ date +"',"
                    + tblProveedor_Compra.getValueAt(r,0).toString()+","+ txtTotalCompra.getText()+")";
            Statement stmt = conect.createStatement();
            stmt.executeUpdate(cad);
            actCant();
            //showMessageDialog(null,"Proveedor Registrado");
            stmt.close();

    }
    
    /**
     * Genera los detales de la compra y se insertan en la BD
     */
        private void detalle_compra(){
            try {
                cad ="";
                int idp = tblProveedor_Compra.getSelectedRow();
                Statement stmt = conect.createStatement();
                res=stmt.executeQuery("SELECT MAX (ID_COMPRA)  FROM COMPRAS");
                int id = 0;
                while (res.next()){
                    id = res.getInt(1);
                }
                for (int i = 0;i< tblCompra.getRowCount();i++){
                    cad = "INSERT INTO DETALLE_COMPRA" +
                            " VALUES( " + id +
                            "," + tblCompra.getValueAt(i,0).toString() +
                            "," + tblCompra.getValueAt(i,2).toString() +
                            "," + tblProveedor_Compra.getValueAt(idp,0) +
                            "," + tblCompra.getValueAt(i,4) +
                            ")";
                            stmt.executeUpdate(cad);
                            }
               stmt.close(); 
            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Dueno.class.getName()).log(Level.SEVERE, null, ex);
            }
               
    }

/**
 * Actualiza la exsitencia de las materias primas en la BD al realiza a compra
 * @throws SQLException 
 */
    private void actCant() throws SQLException{
      for(int i  = 0; i < tblCompra.getRowCount();i++){
         String id= tblCompra.getValueAt(i,0).toString();
          int cant = Integer.parseInt(tblCompra.getValueAt(i,2).toString());
          cad = "UPDATE MATERIAS_PRIMAS "
                    + "SET CANT_DISP = CANT_DISP + "+ cant +" WHERE ID_MATERIA = "+id;
           stmt = conect.createStatement();
            stmt.executeUpdate(cad);
      }

    }
    
    /**
     * Realiza la suma total de la compra y la muestra en un campo de texto
     */
    void sumartotal(){
        r =tblCompra.getRowCount()-1;
        s+= Float.parseFloat(tblCompra.getValueAt(r,4).toString());
        txtTotalCompra.setText(""+s);
    }
   
   
     /**
     * Actualiza el total del pedido al eliminar un producto del carrito de compra
     */
     
    void restartotalyeliminarrow(){
        r = tblCompra.getSelectedRow();
        if( r != -1){
            DefaultTableModel tbm = (DefaultTableModel) tblCompra.getModel();
            s -= Float.parseFloat(tblCompra.getValueAt(r,4).toString());
            tbm.removeRow(r);
            tblCompra.setModel(tbm);
            txtTotalCompra.setText("" +s);
            System.out.print("IF" +   "    " +r);
        }else{
            r = tblCompra.getRowCount()-1;
            DefaultTableModel tbm = (DefaultTableModel) tblCompra.getModel();
            s -= Float.parseFloat(tblCompra.getValueAt(r,4).toString());
            tbm.removeRow(r);
            tblCompra.setModel(tbm);
            txtTotalCompra.setText("" +s);
            System.out.print("ELSE");
        }
        
    }
    
   /**
    * LLena la tabla de materias primas dentro de la ventana de compras
    * @throws ClassNotFoundException 
    */ 
    private void LlenarTablaComprasMateriasPrimas() throws ClassNotFoundException{
         try {
            res=null;
            stmt = conect.createStatement();
            
           tbmMateriaPrima_Compra.setRowCount(0);
           res=stmt.executeQuery("select * from MATERIAS_PRIMAS where NOMBRE LIKE '%"+txtBuscasMateriaPrima_Compras.getText()+"%'");
            if(null!=res){
                while(res.next()){
                   Vector rowProductos=new Vector();
                   rowProductos.add(res.getString("ID_MATERIA"));
                   rowProductos.add(res.getString("NOMBRE"));
//                  rowProductos.add(res.getString("DESCRIPCION"));
                   rowProductos.add(res.getString("CANT_DISP"));
                   rowProductos.add(res.getString("PRECIO"));
                   tbmMateriaPrima_Compra.addRow(rowProductos);
                }
            }
            
            
            stmt.close();
        }catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en la conexion");
        } 
    }
    
    /**
     * Valida que no existan espacios y consume el evento
     * @param evt 
     */
    private void ValidarEspacios(KeyEvent evt) {
       char l=evt.getKeyChar();
        if( l == KeyEvent.VK_SPACE )
           evt.consume();
    }

    /**
     * Eliminar el provedor seleccionado
     * @throws ClassNotFoundException 
     */
    private void EliminarProveedor() throws ClassNotFoundException{
        try{
            conectarBD();
            
            String cad = "DELETE FROM PERSONAS WHERE ID_PERSONA =" + tblProveedores.getValueAt(rowProveedor,0).toString();
            Statement stmt = conect.createStatement();
            stmt.executeUpdate(cad);
            showMessageDialog(null,"Proveedor Eliminado");
            LlenarTablaProveedores();
            stmt.close();
        }
            catch (SQLException ex) 
            {
            System.out.println("Error Eliminar");   
            }
    }
   /**
    * Limpia los campos en la ventna poveedor
    */ 
     private void limpiarProveedor(){
        txtProveedorNombre.setText(null);
        txtProveedorDomicilio.setText(null);
        txtProveedorCP.setText(null);
        txtProveedorTelefono.setText(null);
    }
     /**
      * Valida la existencia de numeros y consume el evento
      * @param evt 
      */
     private void ValidarNumeros(KeyEvent evt,JTextField textF) {
        char someChar = '.';
        int count = 0;
        for (int i = 0; i < textF.getText().length(); i++) {
            if (textF.getText().charAt(i) == someChar) {
        count++;
            }
        } 
        char l=evt.getKeyChar();
        if ((l == KeyEvent.VK_PERIOD) && (count>0))
            evt.consume();
       
        if(!(Character.isDigit(l) || l == KeyEvent.VK_PERIOD ) )
            evt.consume();
    }
     /**
      * Valida la existencia de letras y consume el evento
      * @param evt 
      */
     private void ValidarLetras(KeyEvent evt) {
       char l=evt.getKeyChar();
        if(Character.isDigit(l))
           evt.consume();
    }
/**
 * Valid la existencias de los proveedores
 * @return
 * @throws ClassNotFoundException 
 */
     private boolean ProveedorExistente() throws ClassNotFoundException{
         try {
             conectarBD();
             Statement stmt = conect.createStatement();
             res=stmt.executeQuery("select * from USUARIOS WHERE NOMBRE_USUARIO ='"+ txtProveedorNombre.getText()+"'");
             if(null!=res){
                while(res.next()){
                   return false;
                }
             }
             stmt.close();
        }catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en la conexion LLENAR TABLA");
        }
         return true;
    }

    /**
     *  Limpia los campos en la ventana materias primas
     */
    private void clearMP(){
        txtNombreMP.setText(null);
        txtDescripcionMP.setText(null);
        txtCantidadMP.setValue(0);
        cmbUnidadMedidaMP.setSelectedIndex(0);
        txtPrecioMateriaPrima.setText("0");
    }
    /**
     * Se encarga de llenar la tabla clientes en la ventana pedidos
     */
    private void llenarTablaCliente_Pedido(){
         try {
             
            Statement stmt = conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblClientes_Pedido.getModel();
            tbm.setRowCount(0);
            res=stmt.executeQuery("select ID_PERSONA, NOMBRE ,APE_PAT, APE_MAT ,TELEFONO from PERSONAS where TIPO = 'C'");
            if(null!=res){
                while(res.next()){
                   tbm.addRow(new Object[]{res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)});
                }  
            }
            stmt.close();
        }catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en llenar tabla Clientes en Pedido");
        } 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana_Dueno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Dueno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Dueno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Dueno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Empleado().setVisible(true);
            }
        });
    }
    public Ventana_Dueno VD;
    /**
     * Evita que el spinner genere numeros negativos
     * @param spin 
     */
    private void spinnerNeg( JSpinner spin){
        if(Integer.parseInt(spin.getValue().toString())<1)
            spin.setValue(1);
    }
    
    private void seticon() {
     setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Icons/EL MERENGUE_icon.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MP;
    private javax.swing.JButton btnAddClienteVentas;
    private javax.swing.JButton btnAgregarMP;
    private javax.swing.JButton btnAgregarP;
    private javax.swing.JButton btnAgregarProvedor;
    private javax.swing.JButton btnAgregarProveedor;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnCancelarC;
    private javax.swing.JButton btnCancelarMP;
    private javax.swing.JButton btnCancelarP;
    private javax.swing.JButton btnCancelarVenta;
    private javax.swing.JButton btnCancelar_Compra;
    private javax.swing.JButton btnCancelar_Pedido;
    private javax.swing.JButton btnCancelar_Pedido1;
    private javax.swing.JButton btnEliminarArticuloPedido;
    private javax.swing.JButton btnEliminarC;
    private javax.swing.JButton btnEliminarMateriaPrima_Compra;
    private javax.swing.JButton btnEliminarP;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnGenerarCompra;
    private javax.swing.JButton btnGenerarPedido;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton btnInsertarC;
    private javax.swing.JButton btnModificarC;
    private javax.swing.JButton btnModificarMP;
    private javax.swing.JButton btnModificarP;
    private javax.swing.JButton btnModificarProveedor;
    private javax.swing.JButton btnNuevaMateriaPrima_Compras;
    private javax.swing.JButton btnProductoAPedido;
    private javax.swing.JButton btnRefreshMateriaPrima_Compra;
    private javax.swing.JButton btnRefreshProducto_Pedido;
    private javax.swing.JButton btnRefreshProducto_Pedido1;
    private javax.swing.JButton btnUsuariosAgregar;
    private javax.swing.JButton btnUsuariosCancelar;
    private javax.swing.JButton btnUsuariosEliminar;
    private javax.swing.JButton btnUsuariosModificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cmbUnidadMedidaMP;
    private javax.swing.JComboBox<String> cmbUnidadMedidaProducto;
    private javax.swing.JComboBox<String> cmbUsuariosTipo;
    private com.toedter.calendar.JDateChooser dateEntegaPedidos;
    private com.toedter.calendar.JDateChooser dateGeneracion;
    private com.toedter.calendar.JDateChooser dateGeneracionPedido;
    private com.toedter.calendar.JDateChooser dateGeneracionPedido1;
    private com.toedter.calendar.JDateChooser datePedido;
    private javax.swing.ButtonGroup grupoTipoNuevoProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JScrollPane jScrollPaneProveedores;
    private javax.swing.JScrollPane jScrollPaneUsuarios;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblAnticipo;
    private javax.swing.JLabel lblCPProveedor;
    private javax.swing.JLabel lblCambio;
    private javax.swing.JLabel lblCambioPedido;
    private javax.swing.JLabel lblClienteActivo;
    private javax.swing.JLabel lblContra;
    private javax.swing.JLabel lblDomicilioProveedor;
    private javax.swing.JLabel lblMateriaVendida;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreProveedor;
    private javax.swing.JLabel lblPagoRestante;
    private javax.swing.JLabel lblProductomasVentas;
    private javax.swing.JLabel lblProveedorBuscar;
    private javax.swing.JLabel lblProveedormasCompras;
    private javax.swing.JLabel lblTelefonoProveedor;
    private javax.swing.JLabel lblTipoU;
    private javax.swing.JLabel lblTituloProveedor;
    private javax.swing.JLabel lblTotalAdelantos;
    private javax.swing.JLabel lblTotalCapital;
    private javax.swing.JLabel lblTotalCompras;
    private javax.swing.JLabel lblTotalEgresos;
    private javax.swing.JLabel lblTotalIngresos;
    private javax.swing.JLabel lblTotalVenta1;
    private javax.swing.JLabel lblTotalVentas;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JLabel lblUsuarioTitulo;
    private javax.swing.JPanel panelCliente;
    public static javax.swing.JPanel panelEstadoResultados;
    private javax.swing.JPanel panelHistorialCompras;
    private javax.swing.JPanel panelNuevaCompra;
    private javax.swing.JPanel panelProveedor;
    private javax.swing.JPanel panelUsuarios;
    private javax.swing.JRadioButton rdbCancelar;
    private javax.swing.JRadioButton rdbEntrega;
    private javax.swing.JRadioButton rdbGeneracion;
    private javax.swing.JRadioButton rdbNoDisponible;
    private javax.swing.JRadioButton rdbNoPagado;
    private javax.swing.JRadioButton rdbPagado;
    private javax.swing.JRadioButton rdbPorPedido;
    private javax.swing.JSpinner spncantidadMP_Compra;
    private javax.swing.JSpinner spncantidadProducto_Pedido;
    private javax.swing.JSpinner spnrMP;
    private javax.swing.JTable tablaCliente;
    private javax.swing.JTable tablaMateriaPrima;
    private javax.swing.JTabbedPane tb_Inventario;
    private javax.swing.JTabbedPane tb_Personas;
    public static javax.swing.JTabbedPane tb_PuntoVenta;
    public static javax.swing.JTabbedPane tb_principal;
    private javax.swing.JTable tblClientesVenta;
    private javax.swing.JTable tblClientes_Pedido;
    private javax.swing.JTable tblCompra;
    private javax.swing.JTable tblCompraslMateriasPrimas;
    private javax.swing.JTable tblDetalleCompra;
    private javax.swing.JTable tblDetalleVentas;
    private javax.swing.JTable tblHistorialCompras;
    private javax.swing.JTable tblHistorialPedidos;
    private javax.swing.JTable tblHistorialVentas;
    private javax.swing.JTable tblPedido;
    private javax.swing.JTable tblPedidosVentas;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTable tblProductos_Pedido;
    private javax.swing.JTable tblProveedor_Compra;
    private javax.swing.JTable tblProveedores;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTable tblVenta;
    private javax.swing.JTable tblpruebapedidos;
    private javax.swing.JTextField txtAPMC;
    private javax.swing.JTextField txtAPPC;
    private javax.swing.JTextField txtAdelantoPedido;
    private javax.swing.JTextField txtAgregarPresentacion;
    private javax.swing.JTextField txtAgregarPresentacion1;
    private javax.swing.JTextField txtBuscadorC;
    private javax.swing.JTextField txtBuscarClientePedidos;
    private javax.swing.JTextField txtBuscarClientePedidos1;
    private javax.swing.JTextField txtBuscarClienteVenta;
    private javax.swing.JTextField txtBuscarCliente_Pedido;
    private javax.swing.JTextField txtBuscarCodigoCompras;
    private javax.swing.JTextField txtBuscarCodigoPedidos;
    private javax.swing.JTextField txtBuscarCodigoPedidos1;
    private javax.swing.JTextField txtBuscarCompras;
    private javax.swing.JTextField txtBuscarEmpleadoPedidos;
    private javax.swing.JTextField txtBuscarEmpleadoPedidos1;
    private javax.swing.JTextField txtBuscarP;
    private javax.swing.JTextField txtBuscarProducto_Pedido;
    private javax.swing.JTextField txtBuscarProveedor;
    private javax.swing.JTextField txtBuscarProveedorCompras;
    private javax.swing.JTextField txtBuscasMateriaPrima_Compras;
    private javax.swing.JTextField txtCPC;
    private javax.swing.JSpinner txtCantidadMP;
    private javax.swing.JTextArea txtDescripcionMP;
    private javax.swing.JTextField txtDomC;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtEfectivoPedido;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JTextField txtNomC;
    private javax.swing.JTextField txtNombreMP;
    private javax.swing.JTextField txtPrecioMateriaPrima;
    private javax.swing.JTextField txtProveedorCP;
    private javax.swing.JTextField txtProveedorDomicilio;
    private javax.swing.JTextField txtProveedorNombre;
    private javax.swing.JTextField txtProveedorTelefono;
    private javax.swing.JTextField txtTelC;
    private javax.swing.JTextField txtTotalCompra;
    private javax.swing.JLabel txtTotalPedido;
    private javax.swing.JTextField txtUsuariosContraseña;
    private javax.swing.JTextField txtUsuariosNombre;
    private javax.swing.JTextField txtUsuariosUsuario;
    private javax.swing.JTextArea txtdescP;
    private javax.swing.JTextField txtnomP;
    private javax.swing.JTextField txtprecioP;
    // End of variables declaration//GEN-END:variables
}
