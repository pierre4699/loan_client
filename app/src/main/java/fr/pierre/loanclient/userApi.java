package fr.pierre.loanclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface userApi {

    @GET("users/get")
    Call<List<User>> getUsers();

    @POST("users/create")
    @FormUrlEncoded
    Call<User> createUsers(
            @Field("libelle") String libelle
    );

    @DELETE("users/delete/{id}")
    Call<Void> deleteUser(@Path("id")int id);
}
