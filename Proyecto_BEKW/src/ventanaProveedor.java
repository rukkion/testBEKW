
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;
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
public class ventanaProveedor extends javax.swing.JFrame {

    /**
     * Creates new form ventanaProveedor
     */
    public ventanaProveedor() {
        initComponents();
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        lblDomicilioProveedor = new javax.swing.JLabel();
        btnAgregarProveedor = new javax.swing.JButton();
        txtProveedorDomicilio = new javax.swing.JTextField();
        btnCancelar1 = new javax.swing.JButton();
        txtProveedorCP = new javax.swing.JTextField();
        lblCPProveedor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelProveedor.setBackground(new java.awt.Color(255, 255, 255));

        txtBuscarProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarProveedorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProveedorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarProveedorKeyTyped(evt);
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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Proveedor", "Domicilio", "Código_Postal", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
            .addGroup(panelProveedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTituloProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(959, 959, 959))
            .addGroup(panelProveedorLayout.createSequentialGroup()
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProveedorLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblProveedorBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelProveedorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPaneProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelProveedorLayout.createSequentialGroup()
                                    .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnAgregarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnModificarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelProveedorLayout.createSequentialGroup()
                                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblNombreProveedor)
                                        .addComponent(lblDomicilioProveedor)
                                        .addComponent(lblCPProveedor))
                                    .addComponent(lblTelefonoProveedor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtProveedorDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProveedorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProveedorCP, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProveedorTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelProveedorLayout.setVerticalGroup(
            panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProveedorLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTituloProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreProveedor)
                    .addComponent(txtProveedorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDomicilioProveedor)
                    .addComponent(txtProveedorDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPProveedor)
                    .addComponent(txtProveedorCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefonoProveedor)
                    .addComponent(txtProveedorTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProveedorBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProveedorKeyPressed

    }//GEN-LAST:event_txtBuscarProveedorKeyPressed

    private void txtBuscarProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProveedorKeyReleased
        try {
            BuscarProveedores();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GESTION_PROVEEDORES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtBuscarProveedorKeyReleased

    private void txtBuscarProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProveedorKeyTyped

    }//GEN-LAST:event_txtBuscarProveedorKeyTyped

    private void txtProveedorTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProveedorTelefonoKeyTyped
        ValidarNumeros(evt);
    }//GEN-LAST:event_txtProveedorTelefonoKeyTyped

    private void tblProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedoresMouseClicked
        tblProveedores.getSelectedRow();
        rowProveedor = tblProveedores.getSelectedRow();
        txtProveedorNombre.setText(tblProveedores.getValueAt(rowProveedor, 1).toString());
        txtProveedorDomicilio.setText(tblProveedores.getValueAt(rowProveedor, 2).toString());
        txtProveedorCP.setText(tblProveedores.getValueAt(rowProveedor, 3).toString());
        txtProveedorTelefono.setText(tblProveedores.getValueAt(rowProveedor, 4).toString());
    }//GEN-LAST:event_tblProveedoresMouseClicked

    private void txtProveedorNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProveedorNombreKeyTyped
        ValidarLetras(evt);
    }//GEN-LAST:event_txtProveedorNombreKeyTyped

    private void btnModificarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProveedorActionPerformed

        try {
            if(VerificarvaciosProveedor()){
                ModificarProveedor();
                limpiarProveedor();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GESTION_PROVEEDORES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModificarProveedorActionPerformed

    private void btnAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProveedorActionPerformed
        try {
            if(VerificarvaciosProveedor()){
                if(ProveedorExistente())
                insertarProveedor();
                limpiarProveedor();
                this.dispose();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GESTION_PROVEEDORES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarProveedorActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void txtProveedorCPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProveedorCPKeyTyped
        ValidarNumeros(evt);
    }//GEN-LAST:event_txtProveedorCPKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            LlenarTablaProveedores();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ventanaProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    private void ValidarEspacios(KeyEvent evt) {
       char l=evt.getKeyChar();
        if( l == KeyEvent.VK_SPACE )
           evt.consume();
    }
    /********************************FIN FORM*****************************/
    private void BuscarProveedores() throws ClassNotFoundException{
         try {
             conectarBD();
             Statement stmt = conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblProveedores.getModel();
           tbm.setRowCount(0);stmt.execute("select * from PERSONAS "
                                            + "where TIPO = 'P' "
                                            + "AND NOMBRE LIKE '%" + txtBuscarProveedor.getText() + "%'");
             ResultSet res = stmt.getResultSet();
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
    
     private void limpiarProveedor(){
        txtProveedorNombre.setText(null);
        txtProveedorDomicilio.setText(null);
        txtProveedorCP.setText(null);
        txtProveedorTelefono.setText(null);
    }
     private void ValidarNumeros(KeyEvent evt) {
       char l=evt.getKeyChar();
        if(!Character.isDigit(l) || l == KeyEvent.VK_SPACE )
           evt.consume();
    }
     
     private void ValidarLetras(KeyEvent evt) {
       char l=evt.getKeyChar();
        if(Character.isDigit(l))
           evt.consume();
    }
     private void LlenarTablaProveedores() throws ClassNotFoundException{
         try {
             conectarBD();
             Statement stmt = conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblProveedores.getModel();
           tbm.setRowCount(0);stmt.execute("select * from PERSONAS where TIPO = 'P'");
             ResultSet res = stmt.getResultSet();
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
     private boolean ProveedorExistente() throws ClassNotFoundException{
         try {
             conectarBD();
             Statement stmt = conect.createStatement();
             stmt.execute("select * from USUARIOS WHERE NOMBRE_USUARIO ='"+ txtProveedorNombre.getText()+"'");
             ResultSet res = stmt.getResultSet();
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
       // </editor-proveedor>  
//    private void setDateTime(){
//        Date date=new Date();
//        for(;;){
//        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss dd/mm/yyyy");
//        lblFecha_Hora.setText(sdf.format(date));    
//        }
//        
//    }
    
    CONECTAR_SERVER CS;
     private void conectarBD()throws ClassNotFoundException{
              CS= new CONECTAR_SERVER();
              CS.conectarBD();
              this.conect=CS.getConect();
    }
     
    public int rowProveedor = 0;
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
    
    Connection conect = null;
    
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
    
    private void insertarProveedor() throws ClassNotFoundException{
        try{
            conectarBD();
            String cad = "INSERT INTO PERSONAS "
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
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventanaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProveedor;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnModificarProveedor;
    private javax.swing.JScrollPane jScrollPaneProveedores;
    private javax.swing.JLabel lblCPProveedor;
    private javax.swing.JLabel lblDomicilioProveedor;
    private javax.swing.JLabel lblNombreProveedor;
    private javax.swing.JLabel lblProveedorBuscar;
    private javax.swing.JLabel lblTelefonoProveedor;
    private javax.swing.JLabel lblTituloProveedor;
    private javax.swing.JPanel panelProveedor;
    private javax.swing.JTable tblProveedores;
    private javax.swing.JTextField txtBuscarProveedor;
    private javax.swing.JTextField txtProveedorCP;
    private javax.swing.JTextField txtProveedorDomicilio;
    private javax.swing.JTextField txtProveedorNombre;
    private javax.swing.JTextField txtProveedorTelefono;
    // End of variables declaration//GEN-END:variables
}
