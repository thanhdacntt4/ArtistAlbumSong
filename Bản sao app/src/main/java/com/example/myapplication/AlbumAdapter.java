package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class AlbumAdapter extends BaseAdapter {
    private Context context;
    private List<Album> albums;

    public AlbumAdapter(Context context, List<Album> albums) {
        this.context = context;
        this.albums = albums;
    }

    @Override
    public int getCount() {
        return albums.size();
    }

    @Override
    public Object getItem(int position) {
        return albums.get(position);
    }

    @Override
    public long getItemId(int position) {
        return albums.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_album, parent, false);
        }

        Album album = albums.get(position);

        ImageView imageView = convertView.findViewById(R.id.imageViewAlbum);
        TextView textViewName = convertView.findViewById(R.id.textViewAlbumName);
        TextView textViewArtist = convertView.findViewById(R.id.textViewAlbumArtist);

        imageView.setImageResource(album.getImageResId());
        textViewName.setText(album.getName());
        textViewArtist.setText(album.getArtist());

        return convertView;
    }
}
