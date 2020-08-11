package com.hobbyappgame.retrofit.Interfaz;


import com.google.gson.annotations.SerializedName;
import com.hobbyappgame.retrofit.Model.GetBebes;
import com.hobbyappgame.retrofit.Model.Posts;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MiniTwitterService {

    @GET("posts")
    Call<List<Posts>> getPosts();

    @SerializedName("nombres")
    @GET("consulta.php?Genero=M")
    Call<List<GetBebes>> getBebesMasculino();

    @POST("index")
    Call<RequestAuth> Login(@Body RequestAuth apiLlamador);


}
