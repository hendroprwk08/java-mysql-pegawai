package pegawai_app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class FPegawai extends javax.swing.JFrame {

    ArrayList<Jabatan> arrJabatan = new ArrayList<>();
    ArrayList<Divisi> arrDivisi = new ArrayList<>();
    boolean st_edit;
    String sql;
    int id, id_div, id_jbt, honor, gaji, total;
    
    public FPegawai() {
        initComponents();
        
        id = 0;
        st_edit = false;
        loadDivisi();
        loadJabatan();
        showData( null );
        kosong();
    }

    private void kosong(){
        tf_nama.setText( null );
        tf_alamat.setText( null );
        tf_usia.setText( null );
        lb_total.setText( "0" );
    }
    
    private void showData( String cari ){
        if ( cari == null ){
            sql = "select id_pegawai as ID, nama as NAMA, "
                    + "divisi as DIVISI, jabatan as JABATAN "
                    + "from v_detil_pegawai";
        }else{
            sql = "select id_pegawai as ID, nama as NAMA, "
                    + "divisi as DIVISI, jabatan as JABATAN "
                    + "from v_detil_pegawai where nama like '%"+ cari +"%'";
        }
        
        try {
            //tampilkan data pada table
            ResultSet rs = DB.read(sql);
            tbl.setModel( DbUtils.resultSetToTableModel(rs));
            DB.closeDB();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex);
        }
        
    }
    
    private void loadDivisi(){
        cbx_divisi.removeAllItems();
        
        try {
            ResultSet rs = DB.read( "select * from divisi" );
            
            //masukkan kedalam class Divisi ( tampung )
            while( rs.next() ){
                arrDivisi.add( new Divisi( Integer.parseInt ( rs.getString("id_divisi") ),
                                        Integer.parseInt ( rs.getString("honor") ),
                                        rs.getString("divisi")));
            }
            
            //ambil dari class divisi dan munculkan pada combo box cbx_divisi
            for( int i = 0; i < arrDivisi.size(); i++ ){
                cbx_divisi.addItem( arrDivisi.get( i ).getDivisi());
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    private void loadJabatan(){
        cbx_jabatan.removeAllItems();
        
        try {
            ResultSet rs = DB.read( "select id_jabatan, jabatan, gaji_pokok from jabatan" );
            
            //masukkan kedalam class Divisi ( tampung )
            while( rs.next() ){
                arrJabatan.add( new Jabatan( Integer.parseInt ( rs.getString("id_jabatan") ),
                                        Integer.parseInt ( rs.getString("gaji_pokok") ),
                                        rs.getString("jabatan")));
            }
            
            //ambil dari class divisi dan munculkan pada combo box cbx_divisi
            for( int i = 0; i < arrJabatan.size(); i++ ){
                cbx_jabatan.addItem( arrJabatan.get( i ).getJabatan());
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_usia = new javax.swing.JTextField();
        tf_cari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bt_tambah = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        bt_simpan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        bt_hapus = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        bt_cari = new javax.swing.JButton();
        lb_total = new javax.swing.JLabel();
        cbx_divisi = new javax.swing.JComboBox();
        tf_nama = new javax.swing.JTextField();
        cbx_jabatan = new javax.swing.JComboBox();
        tf_alamat = new javax.swing.JTextField();
        bt_cari1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NAMA");

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

        jLabel2.setText("ALAMAT");

        jLabel3.setText("USIA");

        bt_tambah.setText("TAMBAH");
        bt_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahActionPerformed(evt);
            }
        });

        jLabel4.setText("DIVISI");

        bt_simpan.setText("SIMPAN");
        bt_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_simpanActionPerformed(evt);
            }
        });

        jLabel5.setText("JABATAN");

        bt_hapus.setText("HAPUS");
        bt_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_hapusActionPerformed(evt);
            }
        });

        jLabel6.setText("TOTAL");

        bt_cari.setText("Cari");
        bt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cariActionPerformed(evt);
            }
        });

        lb_total.setText("0");

        cbx_divisi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_divisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_divisiActionPerformed(evt);
            }
        });

        cbx_jabatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_jabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_jabatanActionPerformed(evt);
            }
        });

        bt_cari1.setText("CETAK");
        bt_cari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cari1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tf_nama))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cbx_divisi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_jabatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_alamat))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(lb_total))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(25, 25, 25)
                        .addComponent(tf_usia, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_tambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_simpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_hapus)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_cari1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_cari))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_cari)
                    .addComponent(bt_cari1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tf_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tf_usia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbx_divisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbx_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lb_total))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_tambah)
                            .addComponent(bt_simpan)
                            .addComponent(bt_hapus)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tambahActionPerformed
        kosong();
        st_edit = false;
        id = 0;
    }//GEN-LAST:event_bt_tambahActionPerformed

    private void bt_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_simpanActionPerformed
        
        if ( st_edit == false ){ //simpan
            sql = "insert into pegawai( id_divisi, id_jabatan, nama, alamat, usia ) "
                    + "values( "+ id_div +", "+ id_jbt +", "
                    + "'"+ tf_nama.getText().trim() +"', "
                    + "'"+ tf_alamat.getText().trim() +"', "
                    + ""+ tf_usia.getText().trim() +" )";
        }else{ //update / perbarui
            sql = "update pegawai set id_divisi = "+ id_div +", "
                    + "id_jabatan = "+ id_jbt +", "
                    + "nama = '"+ tf_nama.getText().trim() +"', "
                    + "alamat = '"+ tf_alamat.getText().trim() +"', "
                    + "usia = "+ tf_usia.getText().trim() +" "
                    + "where id_pegawai = "+ id;
        }
        
        //eksekusi sql
        boolean berhasil = false;
        
        try {
            berhasil = DB.exec(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex );
        }
        
        if ( berhasil ){
            kosong();
            showData( null );
            st_edit = false;
            id = 0;
        }else{
            JOptionPane.showMessageDialog(null, "Gagal eksekusi data");
        }
    }//GEN-LAST:event_bt_simpanActionPerformed

    private void cbx_divisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_divisiActionPerformed
        int idx = cbx_divisi.getSelectedIndex();
        
        if ( arrDivisi.size() > 0 ){
            id_div = arrDivisi.get(idx).getId();
            honor = arrDivisi.get(idx).getHonor();
        }
        
        hitung();
    }//GEN-LAST:event_cbx_divisiActionPerformed

    private void cbx_jabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_jabatanActionPerformed
        int idx = cbx_jabatan.getSelectedIndex();
        
        if ( arrJabatan.size() > 0 ){
            id_jbt = arrJabatan.get(idx).getId();
            gaji = arrJabatan.get(idx).getGaji();
        }
        
        hitung();
    }//GEN-LAST:event_cbx_jabatanActionPerformed

    private void bt_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_hapusActionPerformed
        //konfirmasi
        int respon = JOptionPane.showConfirmDialog(null, 
                "Hapus " + tf_nama.getText().trim() + " ?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION);
        
        if ( respon == JOptionPane.YES_OPTION ){ //hapus
            sql = "delete from pegawai where id_pegawai = "+ id;
            
            boolean berhasil = false;
            try {
                berhasil = DB.exec(sql);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog( null, ex );
            }
            
            if ( berhasil ){
                kosong();
                showData( null );
                st_edit = false;
                id = 0;
            }else{
                JOptionPane.showMessageDialog(null, "Data tak dihapus");
            }
        }
    }//GEN-LAST:event_bt_hapusActionPerformed

    private void bt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cariActionPerformed
        showData( tf_cari.getText().trim());
    }//GEN-LAST:event_bt_cariActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        st_edit = true;
        int baris = tbl.getSelectedRow();
        
        id = Integer.parseInt( tbl.getModel().getValueAt(baris, 0).toString() );
        
        //ambil data berdasarkan id
        sql = "select * from pegawai where id_pegawai = "+ id;
        
        try {
            ResultSet rs = DB.read(sql);
            
            while( rs.next() ){
                tf_nama.setText( rs.getString("nama"));
                tf_alamat.setText( rs.getString("alamat"));
                tf_usia.setText( rs.getString("usia"));
                
                //ambil id divisi dan id jabatan
                id_div = rs.getInt("id_divisi");
                id_jbt = rs.getInt("id_jabatan");
                
                //temukan index class Divisi dan Jabatan
                for( int i = 0; i < arrDivisi.size(); i++)
                    if ( id_div == arrDivisi.get(i).getId() )
                        cbx_divisi.setSelectedIndex(i);
                
                for( int i = 0; i < arrJabatan.size(); i++)
                    if ( id_jbt == arrJabatan.get(i).getId() )
                        cbx_jabatan.setSelectedIndex(i);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex.toString() );
        }
        
                
    }//GEN-LAST:event_tblMouseClicked

    private void bt_cari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cari1ActionPerformed
        String dir = System.getProperty("user.dir"); //lokasi project
        JasperPrint jp;
        
        try {
            JasperCompileManager.compileReportToFile(
                    dir + "/src/pegawai_app/RPegawai.jrxml",
                    dir + "/src/pegawai_app/RPegawai.jasper");
            
            jp = JasperFillManager.fillReport(
                    getClass().getResourceAsStream("RPegawai.jasper"),
                    null,
                    DB.connectDB());
            
            JasperViewer.viewReport(jp, false);
        } catch (JRException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.toString());
        }
    }//GEN-LAST:event_bt_cari1ActionPerformed

    private void hitung(){
        total = gaji + honor;
        lb_total.setText( String.valueOf( total ) );
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
    private javax.swing.JButton bt_cari;
    private javax.swing.JButton bt_cari1;
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_simpan;
    private javax.swing.JButton bt_tambah;
    private javax.swing.JComboBox cbx_divisi;
    private javax.swing.JComboBox cbx_jabatan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_total;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField tf_alamat;
    private javax.swing.JTextField tf_cari;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JTextField tf_usia;
    // End of variables declaration//GEN-END:variables
}
