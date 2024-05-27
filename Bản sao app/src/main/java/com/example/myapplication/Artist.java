package com.example.myapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


public class Artist {
    private long id;
    private String name;
    private int imageResource;

    public Artist(long id, String name, int imageResource) {
        this.id = id;
        this.name = name;
        this.imageResource = imageResource;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }
}
