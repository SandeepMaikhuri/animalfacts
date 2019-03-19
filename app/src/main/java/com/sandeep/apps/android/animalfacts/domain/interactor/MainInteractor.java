package com.sandeep.apps.android.animalfacts.domain.interactor;

import com.sandeep.apps.android.animalfacts.domain.Fact;
import com.sandeep.apps.android.animalfacts.domain.NetworkPort;

public interface MainInteractor {
    void fetchFacts(NetworkPort networkPort, CallBack callBack);

    interface CallBack {
        void onFactFetched(Fact fact);

        void onError(String message);
    }
}
