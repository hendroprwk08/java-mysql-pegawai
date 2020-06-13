package java_db_mysql_barang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class FKaryawan extends javax.swing.JFrame {

    java.sql.Connection conn;
    boolean isEdit;
    int id_karyawan, id_divisi, id_jabatan;
    double honor_divisi, honor_jabatan, total_gaji;
    String sql;
    
    Divisi divisi;
    ArrayList<Divisi> divisis = new ArrayList<>();
    
    Jabatan jabatan ;
    ArrayList<Jabatan> jabatans = new ArrayList<>();
    
    public FKaryawan() {
        initComponents();
        isEdit = false;
        id_karyawan = 0;
        
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
                        rs.getString("honor_divisi"));
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
                        rs.getString("honor_jabatan"));
                jabatans.add(jabatan);
            }
            
            //isi combobox
            for (int i = 0; i < jabatans.size(); i++){
                cbJabatan.addItem(jabatans.get(i).getJabatan());
            }
            
            DB.close();
        } catch (SQLException ex) {
            Logger.getLogger(FKaryawan.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tfNama = new javax.swing.JTextField();
        tfAlamat = new javax.swing.JTextField();
        tfUsia = new javax.swing.JTextField();
        cbStatus = new javax.swing.JComboBox();
        cbDivisi = new javax.swing.JComboBox();
        cbJabatan = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        tfCari = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lbGaji = new javax.swing.JLabel();
        cbKelamin = new javax.swing.JComboBox();

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

        jLabel4.setText("KELAMIN");

        jLabel5.setText("STATUS");

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

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Magang", "Kontrak", "Tetap", "Freelance" }));

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

        cbKelamin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Wanita", "Pria" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jButton1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbGaji)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbJabatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfNama)
                        .addComponent(tfAlamat)
                        .addComponent(tfUsia, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cbDivisi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbKelamin, javax.swing.GroupLayout.Alignment.TRAILING, 0, 205, Short.MAX_VALUE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(jLabel4)
                            .addComponent(cbKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tfNama.setText(null);
        tfAlamat.setText(null);
        tfUsia.setText(null);
        cbKelamin.setSelectedIndex(0);
        cbStatus.setSelectedIndex(0);
        cbDivisi.setSelectedIndex(0);
        cbJabatan.setSelectedIndex(0);
        lbGaji.setText("0");
        isEdit = false;
        id_karyawan = 0;
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
        
        String sql, kl, st;        
        if (isEdit == false){
            kl = cbKelamin.getSelectedItem().toString();
            st = cbStatus.getSelectedItem().toString();
            
            //simpan data 
            sql = "insert into karyawan (nama, alamat, usia, kelamin, status, id_divisi, id_jabatan)"
                    + "values ('"+ tfNama.getText() +"', '"+ tfAlamat.getText() +"', '"+ tfUsia.getText() +"' , "
                    + " '"+ kl +"', '"+ st +"', "+ id_divisi +", "+ id_jabatan +")"; 
        }else{
            kl = cbKelamin.getSelectedItem().toString();
            st = cbStatus.getSelectedItem().toString();
            
            //update data
            sql = "update karyawan set nama = '"+ tfNama.getText() +"', alamat = '"+ tfAlamat.getText() +"', "
                    +"usia = '"+ tfUsia.getText() +"', kelamin = '"+ kl +"', status = '"+ st +"', "
                    + "id_divisi ="+ id_divisi +", id_jabatan = "+ id_jabatan +" " 
                    + "where id_karyawan = " + id_karyawan;
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
            id_karyawan = Integer.parseInt(tbl.getModel().getValueAt(row, 0).toString());
            
            sql = "SELECT karyawan.id_karyawan, karyawan.nama,  "
                    +"karyawan.alamat, karyawan.usia,  karyawan.kelamin, "
                    +"karyawan.status, divisi.divisi, jabatan.jabatan "
                    +"FROM karyawan karyawan INNER join divisi "
                    +"on karyawan.id_divisi = divisi.id_divisi "
                    +"inner join jabatan on karyawan.id_jabatan = jabatan.id_jabatan "
                    +"where karyawan.id_karyawan = " + id_karyawan;
            
            ResultSet rs = DB.read(sql);
            
            while(rs.next()){
                System.out.println(rs.getString(1)  +" " +  rs.getString(2)  + " "+ rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) );
                
                tfNama.setText(rs.getString(2));
                tfAlamat.setText(rs.getString(3));
                tfUsia.setText(rs.getString(4));
                cbKelamin.setSelectedItem(rs.getString(5));
                cbStatus.setSelectedItem(rs.getString(6));
                cbDivisi.setSelectedItem(rs.getString(7));
                cbJabatan.setSelectedItem(rs.getString(8));
                hitung();
            }
            
            DB.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex);
        }
    }//GEN-LAST:event_tblMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (id_karyawan != 0 ){
            int resp = JOptionPane.showConfirmDialog(null, 
                        "Hapus "+ tfNama.getText() +"?", 
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.ERROR_MESSAGE);
            
            if (resp == JOptionPane.YES_OPTION){
                sql = "delete from karyawan where id_karyawan = "+ id_karyawan;
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
            sql =  "SELECT karyawan.id_karyawan, karyawan.nama,  " 
                    +"karyawan.alamat, karyawan.usia,  karyawan.kelamin, "
                    +"karyawan.status, divisi.divisi, jabatan.jabatan " 
                    +"FROM karyawan karyawan INNER join divisi "
                    +"on karyawan.id_divisi = divisi.id_divisi "
                    +"inner join jabatan on karyawan.id_jabatan = jabatan.id_jabatan "
                    + "where nama like '%"+ cari +"%'";
        }else{
            sql = "SELECT karyawan.id_karyawan, karyawan.nama,  " 
                    +"karyawan.alamat, karyawan.usia,  karyawan.kelamin, "
                    +"karyawan.status, divisi.divisi, jabatan.jabatan " 
                    +"FROM karyawan karyawan INNER join divisi "
                    +"on karyawan.id_divisi = divisi.id_divisi "
                    +"inner join jabatan on karyawan.id_jabatan = jabatan.id_jabatan";
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
            java.util.logging.Logger.getLogger(FKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbDivisi;
    private javax.swing.JComboBox cbJabatan;
    private javax.swing.JComboBox cbKelamin;
    private javax.swing.JComboBox cbStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
