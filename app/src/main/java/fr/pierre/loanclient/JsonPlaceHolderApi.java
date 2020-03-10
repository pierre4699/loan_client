package fr.pierre.loanclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("api/materials/get")
    Call<List<Post>> getPosts();
}
