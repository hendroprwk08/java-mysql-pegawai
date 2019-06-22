
package java_db_mysql_barang;

public class Jabatan {
    String id_jabatan, jabatan, honor_jabatan;

    public Jabatan(String id_jabatan, String jabatan, String honor_jabatan) {
        this.id_jabatan = id_jabatan;
        this.jabatan = jabatan;
        this.honor_jabatan = honor_jabatan;
    }

    public String getId_jabatan() {
        return id_jabatan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public String getHonor_jabatan() {
        return honor_jabatan;
    }    
}
