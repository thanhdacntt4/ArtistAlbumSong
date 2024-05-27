package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewArtists;
    private ListView listViewAlbums;
    private ListView listViewSongs;

    private static List<Artist> artists;
    private static List<Album> albums;
    private static List<Song> songs;

    private List<Album> filteredAlbums;
    private List<Song> filteredSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        listViewArtists = findViewById(R.id.listViewArtists);
        listViewAlbums = findViewById(R.id.listViewAlbums);
        listViewSongs = findViewById(R.id.listViewSongs);

        // Initialize data
        initializeData();

        // Hiển thị danh sách nghệ sĩ
        ArtistAdapter artistAdapter = new ArtistAdapter(this, artists);
        listViewArtists.setAdapter(artistAdapter);

        // Sự kiện click vào artist
        listViewArtists.setOnItemClickListener((parent, view, position, id) -> {
            Artist selectedArtist = artists.get(position);
            showAlbumsForArtist(selectedArtist);
        });

        // Sự kiện click vào album
        listViewAlbums.setOnItemClickListener((parent, view, position, id) -> {
            Album selectedAlbum = filteredAlbums.get(position);
            showSongsForAlbum(selectedAlbum);
        });

        // Sự kiện click vào bài hát
        listViewSongs.setOnItemClickListener((parent, view, position, id) -> {
            // Xử lý sự kiện click vào bài hát nếu cần
        });
    }

    private void initializeData() {
        artists = new ArrayList<>();
        artists.add(new Artist(1, "Artist 1", R.drawable.play));
        artists.add(new Artist(2, "Artist 2", R.drawable.play));

        albums = new ArrayList<>();
        albums.add(new Album(1, "Album 1", "Artist 1", R.drawable.play));
        albums.add(new Album(2, "Album 2", "Artist 1", R.drawable.play));
        albums.add(new Album(3, "Album 3", "Artist 2", R.drawable.play));

        songs = new ArrayList<>();
        songs.add(new Song(1, "Song 1", "Artist 1", "Album 1"));
        songs.add(new Song(2, "Song 2", "Artist 1", "Album 1"));
        songs.add(new Song(3, "Song 3", "Artist 1", "Album 2"));
        songs.add(new Song(4, "Song 4", "Artist 2", "Album 3"));
    }

    private void showAlbumsForArtist(Artist artist) {
        filteredAlbums = new ArrayList<>();
        for (Album album : albums) {
            if (album.getArtist().equals(artist.getName())) {
                filteredAlbums.add(album);
            }
        }
        AlbumAdapter albumAdapter = new AlbumAdapter(this, filteredAlbums);
        listViewAlbums.setAdapter(albumAdapter);

        listViewArtists.setVisibility(View.GONE);
        listViewAlbums.setVisibility(View.VISIBLE);
    }

    private void showSongsForAlbum(Album album) {
        filteredSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song.getAlbum().equals(album.getName())) {
                filteredSongs.add(song);
            }
        }
        SongAdapter songAdapter = new SongAdapter(this, filteredSongs);
        listViewSongs.setAdapter(songAdapter);

        listViewAlbums.setVisibility(View.GONE);
        listViewSongs.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        if (listViewSongs.getVisibility() == View.VISIBLE) {
            listViewSongs.setVisibility(View.GONE);
            listViewAlbums.setVisibility(View.VISIBLE);
        } else if (listViewAlbums.getVisibility() == View.VISIBLE) {
            listViewAlbums.setVisibility(View.GONE);
            listViewArtists.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }
    }
}
