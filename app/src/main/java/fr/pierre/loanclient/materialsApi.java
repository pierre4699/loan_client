package fr.pierre.loanclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface materialsApi {

    @GET("materials/get")
    Call<List<Material>> getMaterials();

    @POST("materials/create")
    Call<Material> createMaterial(@Body Material material);

    @POST("materials/create")
    @FormUrlEncoded
    Call<Material> createMaterial(
            @Field("libelle") String libelle
    );

}
