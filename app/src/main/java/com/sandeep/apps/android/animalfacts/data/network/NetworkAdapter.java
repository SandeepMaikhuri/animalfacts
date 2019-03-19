package com.sandeep.apps.android.animalfacts.data.network;

import android.support.annotation.NonNull;

import com.sandeep.apps.android.animalfacts.data.mapper.RestModelConverter;
import com.sandeep.apps.android.animalfacts.domain.NetworkPort;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkAdapter implements NetworkPort {

    private ApiFactory apiFactory;

    public NetworkAdapter() {
        apiFactory = new ApiFactory();
    }

    @Override
    public void callFactsApi(String animalType, String number, final CallBack callBack) {
        WebService service = apiFactory.getApi(WebService.class);
        Call<FactEntity> loginResponseCall = service.getFacts(animalType, number);

        loginResponseCall.enqueue(new Callback<FactEntity>() {
            @Override
            public void onResponse(@NonNull Call<FactEntity> call, @NonNull Response<FactEntity> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callBack.onTaskCompleted(RestModelConverter.convertToDomainModel(response.body()));
                } else {
                    callBack.onTaskError("Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<FactEntity> call, @NonNull Throwable t) {
                callBack.onTaskError(t.getMessage());
            }
        });
    }
}