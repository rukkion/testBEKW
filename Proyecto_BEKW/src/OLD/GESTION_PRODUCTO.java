package OLD;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Key
 */
public class GESTION_PRODUCTO extends javax.swing.JFrame {
    java.sql.Connection conect=null;
     java.sql.Statement stmt=null; 
     ResultSet res;
    
    /**
     * Creates new form ProductoFinal
     */
    public GESTION_PRODUCTO() {
        initComponents();
        txtdescP.setLineWrap(true);
    }
    private void conectarBD() throws ClassNotFoundException, SQLException{
            conect = null;
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conect = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-E9BN4AL;databaseName=BEKW","sa","123");
            System.out.println("Conectado.");
            }
            catch (SQLException ex) 
            {
            System.out.println("Error.");   
            }
    }

  private void ValidarNumeros(KeyEvent evt) {
      int counter = 0;
        for( int i=0; i<txtprecioP.getText().length(); i++ ) {
        if( txtprecioP.getText().charAt(i) == '.' ) {
        counter++;
            } 
        }
       char l=evt.getKeyChar();
        if(!(Character.isDigit(l) || l == KeyEvent.VK_SPACE || ((int)l== 46 && counter<1) ))
           evt.consume();
    }
     
     private void ValidarLetras(KeyEvent evt) {
       char l=evt.getKeyChar();
        if(Character.isDigit(l))
           evt.consume();
    }
  
     private boolean validarVacioP(){
            if((("".equals(txtdescP.getText()) || "".equals(txtnomP.getText())) || "".equals(txtprecioP.getText()))|| "".equals(txtunidadP.getText())){
                showMessageDialog(null,"Favor de llenar todos los campos. ");
                return false;
            } else {
            }
            return true;
     }
     
    private void LlenarTablaP() throws ClassNotFoundException{
         try {
             conectarBD();
             
            stmt = conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblProducto.getModel();
           tbm.setRowCount(0);stmt.execute("select * from PRODUCTOS");
            res=stmt.getResultSet();
            if(null!=res){
                while(res.next()){
                   Vector rowProductos=new Vector();
                  rowProductos.add(res.getString("NOMBRE"));
                  rowProductos.add(res.getString("DESCRIPCION"));
                  rowProductos.add(res.getString("CANT_DISP"));
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
    
    private void LlenarTablaBus() throws ClassNotFoundException{
         try {
             conectarBD();
             
            stmt = conect.createStatement();
            DefaultTableModel tbm=(DefaultTableModel)tblProducto.getModel();
           tbm.setRowCount(0);stmt.execute("select * from PRODUCTOS where NOMBRE LIKE '%"+txtBuscarP.getText()+"%'");
            res=stmt.getResultSet();
            if(null!=res){
                while(res.next()){
                   Vector rowProductos=new Vector();
                  rowProductos.add(res.getString("NOMBRE"));
                  rowProductos.add(res.getString("DESCRIPCION"));
                  rowProductos.add(res.getString("CANT_DISP"));
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane12 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jLabel61 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnCancelarP = new javax.swing.JButton();
        btnModificarP = new javax.swing.JButton();
        btnAgregarP = new javax.swing.JButton();
        btnEliminarP = new javax.swing.JButton();
        txtunidadP = new javax.swing.JTextField();
        spincantP = new javax.swing.JSpinner();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtnomP = new javax.swing.JTextField();
        txtprecioP = new javax.swing.JTextField();
        txtBuscarP = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdescP = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
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
                "Producto", "Descripcion", "Cantidad", "Unidad", "Precio"
            }
        ));
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tblProducto);

        getContentPane().add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 98, 478, 458));

        jLabel61.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel61.setText("Producto");
        getContentPane().add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 23, -1, -1));

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setText("Nombre Producto:");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setText("Descripción:");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 119, -1, -1));

        btnCancelarP.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelarP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/error30x30.png"))); // NOI18N
        btnCancelarP.setText("Cancelar");
        btnCancelarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, 36));

        btnModificarP.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnModificarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit30x30.png"))); // NOI18N
        btnModificarP.setText("Modificar");
        btnModificarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, -1, 36));

        btnAgregarP.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAgregarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus30x30.png"))); // NOI18N
        btnAgregarP.setText("Agregar");
        btnAgregarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 123, 36));

        btnEliminarP.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEliminarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/garbage-1x30.png"))); // NOI18N
        btnEliminarP.setText("Eliminar");
        btnEliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 123, 36));

        txtunidadP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtunidadP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtunidadPActionPerformed(evt);
            }
        });
        getContentPane().add(txtunidadP, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 150, -1));

        spincantP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        spincantP.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spincantPStateChanged(evt);
            }
        });
        spincantP.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                spincantPVetoableChange(evt);
            }
        });
        getContentPane().add(spincantP, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 151, -1));

        jLabel65.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel65.setText("Cantidad:");
        getContentPane().add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        jLabel66.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel66.setText("Precio");
        getContentPane().add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setText("Unidad:");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        txtnomP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtnomP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomPActionPerformed(evt);
            }
        });
        txtnomP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnomPKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnomPKeyTyped(evt);
            }
        });
        getContentPane().add(txtnomP, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 152, -1));

        txtprecioP.setText(" ");
        txtprecioP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioPActionPerformed(evt);
            }
        });
        txtprecioP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtprecioPKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprecioPKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioPKeyTyped(evt);
            }
        });
        getContentPane().add(txtprecioP, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 150, 23));

        txtBuscarP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarPActionPerformed(evt);
            }
        });
        txtBuscarP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarPKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarPKeyTyped(evt);
            }
        });
        getContentPane().add(txtBuscarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 58, 295, -1));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel25.setText("Buscar:");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 61, -1, -1));

        txtdescP.setColumns(20);
        txtdescP.setRows(5);
        jScrollPane1.setViewportView(txtdescP);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 270, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
  private void clear(){
        txtnomP.setText(null);
        txtdescP.setText(null);
        txtunidadP.setText(null);
        txtprecioP.setText(null);
        txtBuscarP.setText(null);
        spincantP.setValue(0);
        try {
            LlenarTablaP();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GESTION_PRODUCTO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        tblProducto.getSelectedRow();
        int selectedRowIndex=tblProducto.getSelectedRow();
        txtnomP.setText(tblProducto.getValueAt(selectedRowIndex, 0).toString());
        txtdescP.setText(tblProducto.getValueAt(selectedRowIndex, 1).toString());
        spincantP.setValue(Integer.parseInt((tblProducto.getValueAt(selectedRowIndex, 2)).toString()));
        txtunidadP.setText(tblProducto.getValueAt(selectedRowIndex, 3).toString());
        txtprecioP.setText(tblProducto.getValueAt(selectedRowIndex, 4).toString());
        // TODO add your handling code here:
    }//GEN-LAST:event_tblProductoMouseClicked

    private void btnCancelarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPActionPerformed
        clear();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarPActionPerformed

    private void btnModificarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPActionPerformed
      if(validarVacioP()){  
        DefaultTableModel prod=(DefaultTableModel) tblProducto.getModel();
        String nombre=txtnomP.getText();
        String descripcion=txtdescP.getText();
        String cantidad_disp=(spincantP.getValue().toString());
        String u_medida=txtunidadP.getText();
        String precio=txtprecioP.getText();

        String cad = "update productos set NOMBRE='"+nombre+"', DESCRIPCION ='"+descripcion+"',CANT_DISP="+cantidad_disp+",UNIDAD='"+u_medida+"',PRECIO = "+precio+" WHERE NOMBRE='"+nombre+"'";
        try {
            java.sql.Statement stmt=conect.createStatement();

            stmt.executeUpdate(cad);
            LlenarTablaP();
        } catch (ClassNotFoundException ex) {
            
        } catch (SQLException ex) {
            
        }

        clear();
      }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarPActionPerformed

    private void btnAgregarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPActionPerformed
  if(validarVacioP()){  
        DefaultTableModel prod=(DefaultTableModel) tblProducto.getModel();
        String nombre=txtnomP.getText();
        String descripcion=txtdescP.getText();
        String cantidad_disp=(spincantP.getValue().toString());
        String u_medida=txtunidadP.getText();
        Float precio=Float.parseFloat((txtprecioP.getText()));

        String cad = "INSERT INTO PRODUCTOS VALUES('"+nombre+"','"+descripcion+"',"+cantidad_disp+",'"+u_medida+"',"+precio+")";
        try {
            java.sql.Statement stmt=conect.createStatement();

            stmt.executeUpdate(cad);
            LlenarTablaP();
        } catch (ClassNotFoundException ex) {
            
        } catch (SQLException ex) {
            
        }

        clear();}
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarPActionPerformed

    private void btnEliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPActionPerformed
  if(validarVacioP()){  
        DefaultTableModel prod=(DefaultTableModel) tblProducto.getModel();

        String nombre=txtnomP.getText();

        String cad = "DELETE FROM PRODUCTOS"
        + " WHERE NOMBRE='"+nombre+"'";
        try {
            java.sql.Statement stmt=conect.createStatement();

            stmt.executeUpdate(cad);

            stmt.close();

            LlenarTablaP();
        } catch (SQLException ex) {
           
        } catch (ClassNotFoundException ex) {
           
        }
        clear();
  }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarPActionPerformed

    private void txtunidadPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtunidadPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtunidadPActionPerformed

    private void txtnomPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomPActionPerformed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomPActionPerformed

    private void txtprecioPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioPActionPerformed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioPActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         try {
            LlenarTablaP();
            
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(GESTION_PRODUCTO.class.getName()).log(Level.SEVERE, null, ex);
         }

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void spincantPVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_spincantPVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_spincantPVetoableChange

    private void spincantPStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spincantPStateChanged
        if (Integer.parseInt(spincantP.getValue().toString())<0)
            spincantP.setValue(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_spincantPStateChanged

    private void txtBuscarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarPActionPerformed

    private void txtBuscarPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPKeyPressed
//       try {
//            LlenarTablaBus();
//            // TODO add your handling code here:
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(GESTION_PRODUCTO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarPKeyPressed

    private void txtBuscarPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPKeyTyped
        try {
            LlenarTablaBus();
            // TODO add your handling code here:
        } catch (ClassNotFoundException ex) {
            
        }
    }//GEN-LAST:event_txtBuscarPKeyTyped

    private void txtBuscarPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPKeyReleased
//           try {
//            LlenarTablaBus();
//            // TODO add your handling code here:
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(GESTION_PRODUCTO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarPKeyReleased

    private void txtnomPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomPKeyTyped
        
      
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomPKeyTyped

    private void txtnomPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomPKeyPressed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomPKeyPressed

    private void txtprecioPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioPKeyPressed
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioPKeyPressed

    private void txtprecioPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioPKeyTyped

        ValidarNumeros(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioPKeyTyped

    private void txtprecioPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioPKeyReleased
   
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioPKeyReleased

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
            java.util.logging.Logger.getLogger(GESTION_PRODUCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GESTION_PRODUCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GESTION_PRODUCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GESTION_PRODUCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GESTION_PRODUCTO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarP;
    private javax.swing.JButton btnCancelarP;
    private javax.swing.JButton btnEliminarP;
    private javax.swing.JButton btnModificarP;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JSpinner spincantP;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtBuscarP;
    private javax.swing.JTextArea txtdescP;
    private javax.swing.JTextField txtnomP;
    private javax.swing.JTextField txtprecioP;
    private javax.swing.JTextField txtunidadP;
    // End of variables declaration//GEN-END:variables
}
