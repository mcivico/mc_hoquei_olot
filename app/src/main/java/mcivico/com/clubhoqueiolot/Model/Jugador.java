package mcivico.com.clubhoqueiolot.Model;

import java.io.Serializable;

public class Jugador implements Serializable {

    public String id, title,cognom,number;
    public int image;
    public Jugador(String id, String title, String cognom, String number, int image){
        super();
        this.id = id;
        this.title = title;
        this.cognom = cognom;
        this.number = number;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
