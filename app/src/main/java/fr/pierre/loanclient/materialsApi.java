package fr.pierre.loanclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface materialsApi {

    @GET("materials/get")
    Call<List<Material>> getMaterials();

    @POST("materials/create")
    @FormUrlEncoded
    Call<Material> createMaterial(
            @Field("libelle") String libelle
    );

    @DELETE("materials/delete/{id}")
    Call<Void> deleteMaterial(@Path("id")int id);
}
