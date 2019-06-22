
package java_db_mysql_barang;

public class Divisi {
    String id_divisi, divisi, honor_divisi;

    public Divisi(String id_divisi, String divisi, String honor_divisi) {
        this.id_divisi = id_divisi;
        this.divisi = divisi;
        this.honor_divisi = honor_divisi;
    }

    Divisi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getId_divisi() {
        return id_divisi;
    }

    public String getDivisi() {
        return divisi;
    }

    public String getHonor_divisi() {
        return honor_divisi;
    }
}
