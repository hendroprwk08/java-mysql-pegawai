package java_db_mysql_barang;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class FPegawai extends javax.swing.JFrame {

    java.sql.Connection conn;
    boolean isEdit;
    int id_pegawai, id_divisi, id_jabatan;
    double honor_divisi, honor_jabatan, total_gaji;
    String sql;
    
    Divisi divisi;
    ArrayList<Divisi> divisis = new ArrayList<>();
    
    Jabatan jabatan ;
    ArrayList<Jabatan> jabatans = new ArrayList<>();
    
    public FPegawai() {
        initComponents();
        isEdit = false;
        id_pegawai = 0;
        
        showComboDivisi();
        showComboJabatan();
        showData(null);
    }

    void showComboDivisi(){
        try {
            cbDivisi.removeAllItems();            
            ResultSet rs = DB.read("select * from divisi");
            
            //masukkan kedalam class
            while(rs.next()){
                divisi = new Divisi(rs.getString("id_divisi"),
                        rs.getString("divisi"),
                        rs.getString("honor"));
                divisis.add(divisi);
            }
            
            //isi combobox
            for (int i = 0; i < divisis.size(); i++){
                cbDivisi.addItem(divisis.get(i).getDivisi());
            }
            
            DB.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    void showComboJabatan(){
        try {
            cbJabatan.removeAllItems();
            
            ResultSet rs = DB.read("select * from jabatan");
            
            //masukkan kedalam class
            while(rs.next()){
                jabatan = new Jabatan(rs.getString("id_jabatan"),
                        rs.getString("jabatan"),
                        rs.getString("gaji_pokok"));
                jabatans.add(jabatan);
            }
            
            //isi combobox
            for (int i = 0; i < jabatans.size(); i++){
                cbJabatan.addItem(jabatans.get(i).getJabatan());
            }
            
            DB.close();
        } catch (SQLException ex) {
            Logger.getLogger(FPegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tfNama = new javax.swing.JTextField();
        tfAlamat = new javax.swing.JTextField();
        tfUsia = new javax.swing.JTextField();
        cbDivisi = new javax.swing.JComboBox();
        cbJabatan = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        tfCari = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lbGaji = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NAMA");

        jLabel2.setText("ALAMAT");

        jLabel3.setText("USIA");

        jLabel6.setText("DIVISI");

        jLabel7.setText("JABATAN");

        jButton1.setText("TAMBAH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SIMPAN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("HAPUS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cbDivisi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDivisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDivisiActionPerformed(evt);
            }
        });

        cbJabatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJabatanActionPerformed(evt);
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
        jScrollPane2.setViewportView(tbl);

        jButton4.setText("CARI");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setText("TOTAL GAJI");

        lbGaji.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbGaji)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbJabatan, 0, 205, Short.MAX_VALUE)
                        .addComponent(tfNama)
                        .addComponent(tfAlamat)
                        .addComponent(tfUsia, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cbDivisi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfUsia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbDivisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lbGaji))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton1)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tfNama.setText(null);
        tfAlamat.setText(null);
        tfUsia.setText(null);
        cbDivisi.setSelectedIndex(0);
        cbJabatan.setSelectedIndex(0);
        lbGaji.setText("0");
        isEdit = false;
        id_pegawai = 0;
    }//GEN-LAST:event_jButton1ActionPerformed

    void hitung(){
        double total = honor_jabatan + honor_divisi;
        lbGaji.setText(Double.toString(total));
    }
            
    private void cbDivisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDivisiActionPerformed
        int idx = cbDivisi.getSelectedIndex();
        
        if (divisis.size() != 0){
            id_divisi = Integer.parseInt(divisis.get(idx).getId_divisi());
            honor_divisi =  Double.parseDouble(divisis.get(idx).getHonor_divisi());
            hitung();
        }
    }//GEN-LAST:event_cbDivisiActionPerformed

    private void cbJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJabatanActionPerformed
        int idx = cbJabatan.getSelectedIndex();
        
        if (jabatans.size() != 0){
            id_jabatan = Integer.parseInt(jabatans.get(idx).getId_jabatan());
            honor_jabatan =  Double.parseDouble(jabatans.get(idx).getHonor_jabatan());
            hitung();
        }
    }//GEN-LAST:event_cbJabatanActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if (tfNama.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nama belum terisi");
            return; //keluar dari void
        }
               
        if (isEdit == false){
            //simpan data 
            sql = "insert into pegawai (nama, alamat, usia, kelamin, id_divisi, id_jabatan)"
                    + "values ('"+ tfNama.getText() +"', '"+ tfAlamat.getText() +"', "+ tfUsia.getText() +", "
                    + " "+ id_divisi +", "+ id_jabatan +")"; 
        }else{
            //update data
            sql = "update pegawai set nama = '"+ tfNama.getText() +"', alamat = '"+ tfAlamat.getText() +"', "              
                    + "usia = "+ tfUsia.getText() +", id_divisi = "+ id_divisi +", id_jabatan = "+ id_jabatan +" " 
                    + "where id_pegawai = " + id_pegawai;
        }
        
        boolean success = DB.exec(sql);
        DB.close();
        
        if ( success ){
            jButton1ActionPerformed(null); //panggil fungsi btTambah
            showData(null);
            isEdit = false;
        }else{
            JOptionPane.showMessageDialog( null, "Gagal eksekusi");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        showData(tfCari.getText());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        try {
            int row = tbl.getSelectedRow();
            id_pegawai = Integer.parseInt(tbl.getModel().getValueAt(row, 0).toString());
            
            sql = "SELECT pegawai.id_pegawai as ID, pegawai.nama as NAMA,  "
                    +"pegawai.alamat as ALAMAT, pegawai.usia as USIA, "
                    +"divisi.divisi as DIVISI, jabatan.jabatan as JABATAN "
                    +"FROM pegawai INNER join divisi "
                    +"on pegawai.id_divisi = divisi.id_divisi "
                    +"inner join jabatan on pegawai.id_jabatan = jabatan.id_jabatan "
                    +"where pegawai.id_pegawai = " + id_pegawai;
            
            ResultSet rs = DB.read(sql);
            
            while(rs.next()){
                System.out.println(rs.getString(1)  +" " +  rs.getString(2)  + " "+ rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) );
                
                tfNama.setText(rs.getString(2));
                tfAlamat.setText(rs.getString(3));
                tfUsia.setText(rs.getString(4));
                cbDivisi.setSelectedItem(rs.getString(5));
                cbJabatan.setSelectedItem(rs.getString(6));
                hitung();
            }
            
            DB.close();
            isEdit = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex);
        }
    }//GEN-LAST:event_tblMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (id_pegawai != 0 ){
            int resp = JOptionPane.showConfirmDialog(null, 
                        "Hapus "+ tfNama.getText() +"?", 
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.ERROR_MESSAGE);
            
            if (resp == JOptionPane.YES_OPTION){
                sql = "delete from karyawan where id_karyawan = "+ id_pegawai;
                boolean success = DB.exec(sql);
                DB.close();
        
                if ( success ){
                    jButton1ActionPerformed(null); //panggil fungsi btTambah
                    showData(null);
                    isEdit = false;
                }else{
                    JOptionPane.showMessageDialog( null, "Gagal eksekusi");
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

     void showData(String cari){         
        if (cari != null){
            sql =  "SELECT pegawai.id_pegawai as ID, pegawai.nama as NAMA, " 
                    +"pegawai.alamat as ALAMAT, pegawai.usia as USIA, "
                    +"divisi.divisi as DIVISI, jabatan.jabatan as JABATAN "  
                    +"FROM pegawai INNER join divisi "
                    +"on pegawai.id_divisi = divisi.id_divisi "
                    +"inner join jabatan on pegawai.id_jabatan = jabatan.id_jabatan "
                    + "where nama like '%"+ cari +"%'";
        }else{
            sql = "SELECT pegawai.id_pegawai as ID, pegawai.nama as NAMA, " 
                    +"pegawai.alamat as ALAMAT, pegawai.usia as USIA, "
                    +"divisi.divisi as DIVISI, jabatan.jabatan as JABATAN " 
                    +"FROM pegawai INNER join divisi "
                    +"on pegawai.id_divisi = divisi.id_divisi "
                    +"inner join jabatan on pegawai.id_jabatan = jabatan.id_jabatan";
        }
        
        ResultSet rs = DB.read(sql);
        tbl.setModel(DbUtils.resultSetToTableModel(rs));
        DB.close();
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
            java.util.logging.Logger.getLogger(FPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FPegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbDivisi;
    private javax.swing.JComboBox cbJabatan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbGaji;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField tfAlamat;
    private javax.swing.JTextField tfCari;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfUsia;
    // End of variables declaration//GEN-END:variables
}
