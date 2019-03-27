package com.sandeep.apps.android.animalfacts.facts.data.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService {
    @GET("/facts/random")
    Call<FactRestEntity> getFacts(@Query("animal_type") String animalType,
                                  @Query("amount") String amount);
}