package com.example.newsupdates.ViewClass;

//import android.widget.ImageView;

//import java.util.Date;

public class ChildViewClass {
    String image;
    String title;
    String date;
    String Url;
    public ChildViewClass(String image,String title, String date,String Url) {
        this.image = image;
        this.title = title;
        this.date = date;
        this.Url=Url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() { return Url; }

    public void setUrl(String url) { this.Url = url; }
}
