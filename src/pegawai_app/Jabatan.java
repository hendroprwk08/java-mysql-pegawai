package pegawai_app;

public class Jabatan {
    int id, gaji;
    String jabatan;

    public Jabatan(int id, int gaji, String jabatan) {
        this.id = id;
        this.gaji = gaji;
        this.jabatan = jabatan;
    }

    public int getId() {
        return id;
    }

    public int getGaji() {
        return gaji;
    }

    public String getJabatan() {
        return jabatan;
    }
    
}
