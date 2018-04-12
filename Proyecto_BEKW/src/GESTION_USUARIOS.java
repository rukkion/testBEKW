
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAIDDIAS
 */
public class GESTION_USUARIOS extends javax.swing.JFrame {
Connection conect = null;
     Statement stmt = null;
     String cad = "";
     ResultSet res = null;
     public int row = 0;
     Login log = new Login();
    /**
     * Creates new form GESTION_USUARIOS
     */
    public GESTION_USUARIOS() {
        initComponents();
    }
    
    
    private void InsertarUsuario(){
        try{
            conectarBD();
            cad = "INSERT INTO USUARIOS "
                    + "VALUES('"+ txtUsuariosUsuario.getText()+"','"
                    + txtUsuariosNombre.getText() + "','"
                    + cmbUsuariosTipo.getSelectedItem().toString().substring(0) + "','"
                    + txtUsuariosContraseña.getText() + "')";
            stmt = conect.createStatement();
            stmt.executeUpdate(cad);
            LlenarTablaUsuarios();
            stmt.close();
        }
            catch (SQLException ex) 
            {
            System.out.println("Error insertar");   
            } catch (ClassNotFoundException ex) {
        Logger.getLogger(GESTION_USUARIOS.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    private void ModificarUsuario() throws ClassNotFoundException{
        try{
            conectarBD();
            cad = "UPDATE USUARIOS "
                    + "SET NOMBRE_USUARIO='"+ txtUsuariosUsuario.getText()+"',"
                    + "NOMBRE_PERSONA='" + txtUsuariosNombre.getText()+ "',TIPO='"
                    + cmbUsuariosTipo.getSelectedItem().toString() + "',CONTRASEÑA='"
                    + txtUsuariosContraseña.getText()
                    + "' WHERE ID_USUARIO="+ tblUsuarios.getValueAt(row,0);
            stmt = conect.createStatement();
            stmt.executeUpdate(cad);
            LlenarTablaUsuarios();
            stmt.close();
        }
            catch (SQLException ex) 
            {
            System.out.println("Error modificar");   
            }
    }
    
    private void EliminarUsuario() throws ClassNotFoundException{
        try{
            conectarBD();
            cad = "DELETE FROM USUARIOS WHERE ID_USUARIO =" + tblUsuarios.getValueAt(row,0).toString();
            stmt = conect.createStatement();
            stmt.executeUpdate(cad);
            LlenarTablaUsuarios();
            stmt.close();
        }
            catch (SQLException ex) 
            {
            System.out.println("Error Eliminar");   
            }
    }
    
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
    
    private void LlenarTablaUsuarios() throws ClassNotFoundException{
         try {
             conectarBD();
             stmt=conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblUsuarios.getModel();
           tbm.setRowCount(0);stmt.execute("select * from USUARIOS");
            res=stmt.getResultSet();
            if(null!=res){
                while(res.next()){
                   tbm.addRow(new Object[]{res.getInt(1),res.getString(2),res.getString(4),res.getString(5),res.getString(3)});
                }  
            }
            stmt.close();
        }catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en la conexion LLENAR TABLA");
        } 
    }
    
     private boolean UsuarioExistente() throws ClassNotFoundException{
         try {
             conectarBD();
             stmt=conect.createStatement();
             stmt.execute("select * from USUARIOS WHERE NOMBRE_USUARIO ='"+ txtUsuariosUsuario.getText()+"'");
             res=stmt.getResultSet();
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
    
    private void conectarBD() throws ClassNotFoundException, SQLException{
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conect = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=BEKW","sa","123");
            System.out.println("Conectado.");
            }
            catch (SQLException ex) 
            {
            System.out.println("Error.");   
            }
    }
    
    private void limpiarUsuarios(){
        txtUsuariosNombre.setText(null);
        txtUsuariosUsuario.setText(null);
        txtUsuariosContraseña.setText(null);
        cmbUsuariosTipo.setSelectedIndex(0);
    }
     
     private void ValidarEspacios(KeyEvent evt) {
       char l=evt.getKeyChar();
        if( l == KeyEvent.VK_SPACE )
           evt.consume();
    }
     
     private void ValidarLetras(KeyEvent evt) {
       char l=evt.getKeyChar();
        if(Character.isDigit(l))
           evt.consume();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblTipoU = new javax.swing.JLabel();
        lblContra = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtUsuariosUsuario = new javax.swing.JTextField();
        txtUsuariosContraseña = new javax.swing.JTextField();
        txtUsuariosNombre = new javax.swing.JTextField();
        cmbUsuariosTipo = new javax.swing.JComboBox<>();
        jScrollPaneUsuarios = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        lblUsuarioTitulo = new javax.swing.JLabel();
        btnUsuariosAgregar = new javax.swing.JButton();
        btnUsuariosCancelar = new javax.swing.JButton();
        btnUsuariosModificar = new javax.swing.JButton();
        btnUsuariosEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario.setText("Usuario:");
        jPanel12.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

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
        cmbUsuariosTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "EMPLEADO", "ADMINISTRADOR" }));
        jPanel12.add(cmbUsuariosTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 170, -1));

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUsuariosCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUsuariosAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUsuariosModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUsuariosEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(436, 436, 436)
                        .addComponent(lblUsuarioTitulo)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblUsuarioTitulo)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jScrollPaneUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUsuariosCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuariosModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUsuariosAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuariosEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuariosCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosCancelarActionPerformed
        limpiarUsuarios();
    }//GEN-LAST:event_btnUsuariosCancelarActionPerformed

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
        Logger.getLogger(GESTION_USUARIOS.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnUsuariosAgregarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    try {
        LlenarTablaUsuarios();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(GESTION_USUARIOS.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_formWindowOpened

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
       row = tblUsuarios.getSelectedRow();
       txtUsuariosUsuario.setText(tblUsuarios.getValueAt(row, 1).toString());
       cmbUsuariosTipo.setSelectedItem(tblUsuarios.getValueAt(row, 2));
       txtUsuariosContraseña.setText(tblUsuarios.getValueAt(row,3).toString());
       txtUsuariosNombre.setText(tblUsuarios.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tblUsuariosMouseClicked

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
        Logger.getLogger(GESTION_USUARIOS.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnUsuariosModificarActionPerformed

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
        Logger.getLogger(GESTION_USUARIOS.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnUsuariosEliminarActionPerformed

    private void txtUsuariosUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuariosUsuarioKeyTyped
        ValidarEspacios(evt);
    }//GEN-LAST:event_txtUsuariosUsuarioKeyTyped

    private void txtUsuariosNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuariosNombreKeyTyped
        ValidarLetras(evt);
    }//GEN-LAST:event_txtUsuariosNombreKeyTyped

    private void txtUsuariosContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuariosContraseñaKeyTyped
        ValidarEspacios(evt);
    }//GEN-LAST:event_txtUsuariosContraseñaKeyTyped

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GESTION_USUARIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GESTION_USUARIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GESTION_USUARIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GESTION_USUARIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GESTION_USUARIOS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUsuariosAgregar;
    private javax.swing.JButton btnUsuariosCancelar;
    private javax.swing.JButton btnUsuariosEliminar;
    private javax.swing.JButton btnUsuariosModificar;
    private javax.swing.JComboBox<String> cmbUsuariosTipo;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPaneUsuarios;
    private javax.swing.JLabel lblContra;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTipoU;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuarioTitulo;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtUsuariosContraseña;
    private javax.swing.JTextField txtUsuariosNombre;
    private javax.swing.JTextField txtUsuariosUsuario;
    // End of variables declaration//GEN-END:variables
}
