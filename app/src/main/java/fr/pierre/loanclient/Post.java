package fr.pierre.loanclient;

import com.google.gson.annotations.SerializedName;

public class Post {
    private Integer id;

    @SerializedName("body")
    private String libelle;

    public Post(String libelle) {
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }
}
