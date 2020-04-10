package com.company;

public class Artist extends Database {

    public Artist(){
        availableID = 0;
    }


    /**
     * Creates the album table
     */
    public void createArtistTable(){
        String createTableScript;
        try {
            //Scipt taken from problem statement
            createTableScript = "create table artists(\n" +
                    "    id integer not null generated always as identity (start with 1, increment by 1),\n" +
                    "    name varchar(100) not null,\n" +
                    "    country varchar(100),\n" +
                    "    primary key (id)\n" +
                    ");";
            this.executeQuery(createTableScript);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
