package com.juliusnyambok.RecyclerView;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


//The interface responsible for handling the API call methods
public interface RequestInterface {
    @GET("api/v1")
    Call<OuterClass> getDisasters();


    @POST("api/v1")
    @FormUrlEncoded
    Call<OuterClass> setDisasters(
            @Field("disasterName") String disasterT,
            @Field("location") String locat,
            @Field("description") String disasterD);

}
