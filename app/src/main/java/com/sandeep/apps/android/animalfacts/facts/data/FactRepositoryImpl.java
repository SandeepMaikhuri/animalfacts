package com.sandeep.apps.android.animalfacts.facts.data;

import com.sandeep.apps.android.animalfacts.facts.data.mapper.RestModelConverter;
import com.sandeep.apps.android.animalfacts.facts.data.network.ApiFactory;
import com.sandeep.apps.android.animalfacts.facts.data.network.FactRestEntity;
import com.sandeep.apps.android.animalfacts.facts.data.network.WebService;
import com.sandeep.apps.android.animalfacts.facts.domain.entity.FactEntity;
import com.sandeep.apps.android.animalfacts.facts.domain.repository.FactsRepository;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class FactRepositoryImpl implements FactsRepository {

    private ApiFactory apiFactory;

    public FactRepositoryImpl() {
        apiFactory = new ApiFactory();
    }

    @Override
    public FactEntity getRandomFacts() {
        WebService service = apiFactory.getApi(WebService.class);
        Call<FactRestEntity> loginResponseCall = service.getFacts("dog", "1");

        try {
            Response<FactRestEntity> factEntityResponse = loginResponseCall.execute();
            return RestModelConverter.convertToDomainModel(factEntityResponse.body());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public FactEntity getFactsByType(String animalType) {
        return null;
    }
}