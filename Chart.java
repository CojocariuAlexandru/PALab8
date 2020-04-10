package com.company;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Shows the albums in a specific order, in this example I sorted by release_year
 */

public class Chart {
    public void showChart(){
        ResultSet returnedByQuery;
        String queryToBeExecuted;
        List<String> albumsByRequiredArtist = new ArrayList<>();

        queryToBeExecuted = "SELECT * FROM albums ORDER BY release_year;";
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
