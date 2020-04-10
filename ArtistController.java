package com.company;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Does different operations on the artist table
 */

public class ArtistController {
    /**
     * Inserts in the artists table, an artist having characteristics based on the parameters
     * @param name
     * @param country
     */
    public void create(String name, String country){
        String queryToBeExecuted;
        queryToBeExecuted = "INSERT INTO artists VALUES (";
        queryToBeExecuted = queryToBeExecuted + Main.artist.getAvailableID();
        queryToBeExecuted = queryToBeExecuted + ", " + name + "," + country;
        queryToBeExecuted = queryToBeExecuted + ");";
        Main.artist.executeQuery(queryToBeExecuted);

        Main.album.increaseID();
    }

    /**
     * Prints all information about an artist based on his name
     * @param artistName
     */
    public void findByName(String artistName){
        ResultSet returnedByQuery;
        String queryToBeExecuted;

        queryToBeExecuted = "SELECT * FROM artists WHERE name = " + artistName + ";";
        returnedByQuery = Main.album.executeQuery(queryToBeExecuted);
        try{
            while (returnedByQuery.next()) {
                System.out.println(returnedByQuery.getString(0));
                System.out.println(returnedByQuery.getString(1));
                System.out.println(returnedByQuery.getString(2));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
