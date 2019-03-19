package com.sandeep.apps.android.animalfacts.data.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService {
    @GET("/facts/random")
    Call<FactEntity> getFacts(@Query("animal_type") String animalType,
                              @Query("amount") String amount);
}