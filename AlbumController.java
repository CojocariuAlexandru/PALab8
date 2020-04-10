package com.company;
import java.sql.ResultSet;
import java.util.*;

/**
 * Does different operations on the album table
 */

public class AlbumController {

    /**
     * Creates a row in the album table, having specifications described by parameters
     * @param name
     * @param id
     * @param releaseYear
     */
    public void create(String name, int id, int releaseYear){
        String queryToBeExecuted;
        queryToBeExecuted = "INSERT INTO albums VALUES (";
        queryToBeExecuted = queryToBeExecuted + Main.album.getAvailableID();
        queryToBeExecuted = queryToBeExecuted + ", " + name + "," + id + "," + releaseYear;
        queryToBeExecuted = queryToBeExecuted + ");";
        Main.album.executeQuery(queryToBeExecuted);

        Main.album.increaseID();
    }

    /**
     * Returns a list of album names written by a certain artist
     * @param artistID
     * @return
     */
    public List<String> findByArtist(int artistID){
        ResultSet returnedByQuery;
        String queryToBeExecuted;
        List<String> albumsByRequiredArtist = new ArrayList<>();

        queryToBeExecuted = "SELECT * FROM albums WHERE artist_id = " + artistID + ";";
        returnedByQuery = Main.album.executeQuery(queryToBeExecuted);
        try{
            while (returnedByQuery.next()) {
                 albumsByRequiredArtist.add(returnedByQuery.getString(2));
             }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return albumsByRequiredArtist;
    }
}
