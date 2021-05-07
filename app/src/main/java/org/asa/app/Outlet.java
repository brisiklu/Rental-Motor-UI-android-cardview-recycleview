package org.asa.app;
import android.media.*;

/**
 * Created by Akshay Raj on 8/9/2016.
 * Snow Corporation Inc.
 * www.snowcorp.org
 */
public class Outlet {
    private String name;
    private String rating;
    private int thumbnail;
    private int cardViewOutlet;
    private String jarak;
    
    private int numOfSongs;
   

    public Outlet() {
    }

    public Outlet(String name, int numOfSongs, int thumbnail) {
        this.name = name;
        this.numOfSongs = numOfSongs;
        this.thumbnail = thumbnail;
    }
    
    
    public Outlet(String name, String jarak, String rating, int thumbnail, int cardViewOutlet){
        this.name = name;
        this.jarak = jarak;
        this.thumbnail = thumbnail;
        this.rating = rating;
        this.cardViewOutlet=cardViewOutlet;
    }

    public void setCardViewOutlet(int cardViewOutlet)
    {
        this.cardViewOutlet = cardViewOutlet;
    }

    public int getCardViewOutlet()
    {
        return cardViewOutlet;
    }

    public void setJarak(String jarak)
    {
        this.jarak = jarak;
    }

    public String getJarak()
    {
        return jarak;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}

