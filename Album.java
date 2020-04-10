package com.company;
import java.sql.*;

/**
 * Does set-ups for album tables and provides framework for executing queries
 */

public class Album extends Database{


    public Album(){
        availableID = 0;
    }

    /**
     * Creates the album table
     */
    public void createAlbumTable(){
        String createTableScript;
        try {
            //Scipt taken from problem statement
            createTableScript = "    create table albums(\n" +
                                "    id integer not null generated always as identity (start with 1, increment by 1),\n" +
                                "    name varchar(100) not null,\n" +
                                "    artist_id integer not null references artists on delete restrict,\n" +
                                "    release_year integer,\n" +
                                "    primary key (id)\n" +
                                "); ";
            this.executeQuery(createTableScript);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
