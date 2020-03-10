package fr.pierre.loanclient;

import com.google.gson.annotations.SerializedName;

public class Post {
    private int id;

    @SerializedName("body")
    private String libelle;

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }
}
