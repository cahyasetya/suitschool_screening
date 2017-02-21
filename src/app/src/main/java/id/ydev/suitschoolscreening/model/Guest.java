package id.ydev.suitschoolscreening.model;

import android.media.Image;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by cahya on 21/02/17.
 */

public class Guest {
    @SerializedName("name")
    private String nama;
    @SerializedName("birthdate")
    private String birthDate;
    private int image;
    @SerializedName("id")
    private int id;

    public Guest(int id, String birthDate, int image, String nama) {
        this.id=id;
        this.birthDate = birthDate;
        this.image = image;
        this.nama = nama;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
