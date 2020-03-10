package fr.pierre.loanclient;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @GET("api/materials/get")
    Call<List<Post>> getPosts();

    @POST("api/materials/create")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("api/materials/create")
    Call<Post> createPost(
            @Field("libelle") String libelle
    );

    @FormUrlEncoded
    @POST("api/materials/create")
    Call<Post> createPost(@FieldMap Map<String, String> fields);

}
