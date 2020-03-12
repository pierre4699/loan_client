package fr.pierre.loanclient;

import com.google.gson.annotations.SerializedName;

public class Material {

    private Integer id;

    @SerializedName("libelle")
    private String libelle;

    public Material(String libelle) {

        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }
}
