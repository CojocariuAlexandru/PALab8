package com.company;

/**
 * Creates and uses instances of album and artist
 */

public class Main {
    public static Album album;
    public static Artist artist;

    public static void main(String[] args) {
        album = new Album();
        album.connectToDatabase();

        artist = new Artist();
        artist.connectToDatabase();

        album.createAlbumTable();
        artist.createArtistTable();

        album.closeDatabase();
        artist.closeDatabase();
    }
}
