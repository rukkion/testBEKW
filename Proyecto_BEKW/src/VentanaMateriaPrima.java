
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willi
 */
public class VentanaMateriaPrima extends javax.swing.JFrame {

    /**
     * Creates new form VentanaMateriaPrima
     */
    public VentanaMateriaPrima() {
        initComponents();
        setLocationRelativeTo(null);
        seticon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnCancelarMP = new javax.swing.JButton();
        btnAgregarMP = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtNombreMP = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        cmbUnidadMedidaMP = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        txtDescripcionMP = new javax.swing.JTextArea();
        jLabel68 = new javax.swing.JLabel();
        txtCantidadMP = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Ubuntu Light", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/EL MERENGUEx75.png"))); // NOI18N
        jLabel3.setText("            Nueva Materia Prima");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnCancelarMP.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelarMP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelarMP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/error30x30.png"))); // NOI18N
        btnCancelarMP.setText("Cancelar");
        btnCancelarMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarMPActionPerformed(evt);
            }
        });

        btnAgregarMP.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarMP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAgregarMP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus30x30.png"))); // NOI18N
        btnAgregarMP.setText("Agregar");
        btnAgregarMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMPActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Nombre:");

        txtNombreMP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombreMP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreMPKeyTyped(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel64.setText("Unidad de medida:");

        cmbUnidadMedidaMP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbUnidadMedidaMP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "pza", "Kg", "L", "caja" }));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Descripción:");

        txtDescripcionMP.setColumns(20);
        txtDescripcionMP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDescripcionMP.setRows(5);
        jScrollPane13.setViewportView(txtDescripcionMP);

        jLabel68.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel68.setText("Cantidad disponible:");

        txtCantidadMP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel64))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addComponent(cmbUnidadMedidaMP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNombreMP, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel15)
                                .addGap(22, 22, 22)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel68)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCantidadMP, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelarMP)
                        .addGap(41, 41, 41)
                        .addComponent(btnAgregarMP)))
                .addGap(156, 156, 156))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombreMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(txtCantidadMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64)
                    .addComponent(cmbUnidadMedidaMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarMP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarMP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarMPActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarMPActionPerformed
    private void agregarMP(){
        try {
            if(VerificarvaciosMP()){
                if(MPExistente()){
                    InsertarMP();
                    
                    this.dispose();
                }else{
                    showMessageDialog(null,"MATERIA PRIMA YA EXISTENTE");
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GESTION_USUARIOS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void clearMP(){
        txtNombreMP.setText(null);
        txtDescripcionMP.setText(null);
        txtCantidadMP.setValue(0);
        cmbUnidadMedidaMP.setSelectedIndex(0);
    }
    private void InsertarMP(){
        try{
            conectarBD();
            String cad = "INSERT INTO MATERIAS_PRIMAS "
                    + "VALUES('"+ txtNombreMP.getText()+"','"
                    + txtDescripcionMP.getText() + "','"
                    + txtCantidadMP.getValue().toString()+ "','"
                    + cmbUnidadMedidaMP.getSelectedItem().toString() + "')";
            Statement stmt = conect.createStatement();
            stmt.executeUpdate(cad);
            //llenarMateriaPrima();
            stmt.close();
        }
            catch (SQLException ex) 
            {
            System.out.println("Error insertar");   
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GESTION_USUARIOS.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private boolean MPExistente() throws ClassNotFoundException{
         try {
             conectarBD();
             Statement stmt = conect.createStatement();
             stmt.execute("select * from MATERIAS_PRIMAS WHERE NOMBRE='"+ txtNombreMP.getText()+"'");
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
    private boolean VerificarvaciosMP(){
        
        if(txtNombreMP.getText().equals("")){
            showMessageDialog(null, "VERIFIQUE EL NOMBRE DE LA MATERIA PRIMA");
            return false;
        }
        
        if (cmbUnidadMedidaMP.getSelectedIndex() == 0){
            showMessageDialog(null, "SELECCIONE UNA UNIDAD DE MEDIDA");
            return false;
        }
        return true;
    }
    CONECTAR_SERVER CS;
    Connection conect = null;
    private void conectarBD()throws ClassNotFoundException{
              CS=new CONECTAR_SERVER();
              CS.conectarBD();
              this.conect=CS.getConect();
              
    }
    private void btnAgregarMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMPActionPerformed
        agregarMP();
    }//GEN-LAST:event_btnAgregarMPActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            conectarBD();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentanaMateriaPrima.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void txtNombreMPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreMPKeyTyped
        
    }//GEN-LAST:event_txtNombreMPKeyTyped

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
            java.util.logging.Logger.getLogger(VentanaMateriaPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMateriaPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMateriaPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMateriaPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaMateriaPrima().setVisible(true);
            }
        });
    }
     private void seticon() {
     setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Icons\\EL MERENGUE_icon.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarMP;
    private javax.swing.JButton btnCancelarMP;
    private javax.swing.JComboBox<String> cmbUnidadMedidaMP;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JSpinner txtCantidadMP;
    private javax.swing.JTextArea txtDescripcionMP;
    private javax.swing.JTextField txtNombreMP;
    // End of variables declaration//GEN-END:variables
}