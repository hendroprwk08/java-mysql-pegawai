package pegawai_app;

public class Divisi {
    int id, honor;
    String divisi;
 
    public Divisi(int id, int honor, String divisi) {
        this.id = id;
        this.honor = honor;
        this.divisi = divisi;
    }

    public int getId() {
        return id;
    }

    public int getHonor() {
        return honor;
    }

    public String getDivisi() {
        return divisi;
    }
    
}
