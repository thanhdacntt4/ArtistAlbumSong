package com.example.myapplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class ArtistAdapter extends ArrayAdapter<Artist> {

    public ArtistAdapter(MainActivity context, List<Artist> artists) {
        super(context, 0, artists);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Artist artist = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_artist, parent, false);
        }

        ImageView imageViewArtist = convertView.findViewById(R.id.imageViewArtist);
        TextView textViewArtistName = convertView.findViewById(R.id.textViewArtistName);

        imageViewArtist.setImageResource(artist.getImageResource());
        textViewArtistName.setText(artist.getName());

        return convertView;
    }
}
