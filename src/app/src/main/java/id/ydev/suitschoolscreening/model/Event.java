package id.ydev.suitschoolscreening.model;

/**
 * Created by cahya on 21/02/17.
 */

public class Event {
    String nama;
    String tanggal;
    int image;

    public Event(int image, String nama, String tanggal) {
        this.image = image;
        this.nama = nama;
        this.tanggal = tanggal;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
