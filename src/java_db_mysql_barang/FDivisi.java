package java_db_mysql_barang;

import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils; //rs2xml.jar

public class FDivisi extends javax.swing.JFrame {

    java.sql.Connection conn;
    boolean isEdit;
    int id;
    
    public FDivisi() {
        initComponents();
        
        isEdit = false;
        id = 0;
        showData(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfDivisi = new javax.swing.JTextField();
        btSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tfHonor = new javax.swing.JTextField();
        btHapus = new javax.swing.JButton();
        btTambah = new javax.swing.JButton();
        tfCari = new javax.swing.JTextField();
        btCari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("DIVISI");

        btSimpan.setText("SIMPAN");
        btSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanActionPerformed(evt);
            }
        });

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl);

        jLabel2.setText("HONOR");

        btHapus.setText("HAPUS");
        btHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHapusActionPerformed(evt);
            }
        });

        btTambah.setText("TAMBAH");
        btTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTambahActionPerformed(evt);
            }
        });

        btCari.setText("...");
        btCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDivisi, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfHonor, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btHapus)
                                .addGap(85, 85, 85))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCari, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfDivisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHonor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSimpan)
                    .addComponent(btHapus)
                    .addComponent(btTambah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTambahActionPerformed
        tfDivisi.setText(null);
        tfHonor.setText(null);
        isEdit = false;
        id = 0;
    }//GEN-LAST:event_btTambahActionPerformed

    private void btSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanActionPerformed
        if (tfDivisi.getText().equals("") || tfHonor.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Lengkapi data");
            return; //keluar dari void
        }
        
        String sql;        
        if (isEdit == false){
            //simpan data 
            sql = "insert into divisi (divisi, honor_divisi)" 
                                                                                                                                                                                                                                           + "values ('"+ tfDivisi.getText() +"', "
                    + ""+ tfHonor.getText() +")";
        }else{
            //update data
            sql = "update divisi set divisi = '"+ tfDivisi.getText() +"', "
                    + "honor_divisi = "+ tfHonor.getText() +" "
                    + "where id_divisi = " + id;
        }
        
        try {
            conn = (Connection) java_db_mysql_barang.DB.connectDB();
            
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute(sql);
            conn.close();

            JOptionPane.showMessageDialog(null, "Data disimpan!");

            btTambahActionPerformed(null); //panggil fungsi btTambah
            showData(null);
            isEdit = false;
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, sQLException.toString());
        }
    }//GEN-LAST:event_btSimpanActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        // TODO add your handling code here:
        int row = tbl.getSelectedRow();
        
        id = Integer.parseInt(tbl.getModel().getValueAt(row, 0).toString());
        tfDivisi.setText(tbl.getModel().getValueAt(row, 1).toString());
        tfHonor.setText(tbl.getModel().getValueAt(row, 2).toString());
        isEdit = true;
    }//GEN-LAST:event_tblMouseClicked

    private void btHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHapusActionPerformed
        // TODO add your handling code here:
        if (id != 0 ){
            int resp = JOptionPane.showConfirmDialog(null, 
                        "Hapus "+ tfDivisi.getText() +"?", 
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.ERROR_MESSAGE);
            
            if (resp == JOptionPane.YES_OPTION){
                try {
                    conn = (Connection) java_db_mysql_barang.DB.connectDB();
                    String sql = "delete from divisi where id_divisi = "+id;
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.execute(sql);
                    conn.close();

                    btTambahActionPerformed(null); //panggil fungsi btTambah
                    showData(null);
                    isEdit = false;
                } catch (SQLException sQLException) {
                    JOptionPane.showMessageDialog(null, sQLException.toString());
                }
            }
        }
    }//GEN-LAST:event_btHapusActionPerformed

    private void btCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCariActionPerformed
        // TODO add your handling code here:
        showData(tfCari.getText().toString());
    }//GEN-LAST:event_btCariActionPerformed

    void showData(String s){
        try {
            conn = (Connection) java_db_mysql_barang.DB.connectDB();
            Statement st = conn.createStatement();
            ResultSet sql;
            
            if (s != null){
                sql = st.executeQuery("select * from divisi "
                        + "where divisi like '%"+ tfCari.getText() +"%'");
            }else{
                sql = st.executeQuery("select * from divisi");
            }
            
            tbl.setModel(DbUtils.resultSetToTableModel(sql));
            conn.close(); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
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
            java.util.logging.Logger.getLogger(FDivisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FDivisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FDivisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FDivisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FDivisi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCari;
    private javax.swing.JButton btHapus;
    private javax.swing.JButton btSimpan;
    private javax.swing.JButton btTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField tfCari;
    private javax.swing.JTextField tfDivisi;
    private javax.swing.JTextField tfHonor;
    // End of variables declaration//GEN-END:variables
}
