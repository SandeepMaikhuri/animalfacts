package com.sandeep.apps.android.animalfacts.facts.domain.interactor;

import com.sandeep.apps.android.animalfacts.facts.domain.entity.FactEntity;

public interface GetRandomFactInteractor {

    interface CallBack {
        void onFactFetched(FactEntity fact);

        void onError(String message);
    }
}