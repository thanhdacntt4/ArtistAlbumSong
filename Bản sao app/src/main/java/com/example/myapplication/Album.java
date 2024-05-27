package com.example.myapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;




public class Album {
    private int id;
    private String name;
    private String artist;
    private int imageResId;

    public Album(int id, String name, String artist, int imageResId) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.imageResId = imageResId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getImageResId() {
        return imageResId;
    }
}

