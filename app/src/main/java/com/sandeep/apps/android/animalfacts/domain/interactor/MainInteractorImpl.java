package com.sandeep.apps.android.animalfacts.domain.interactor;

import com.sandeep.apps.android.animalfacts.domain.Fact;
import com.sandeep.apps.android.animalfacts.domain.NetworkPort;

public class MainInteractorImpl implements MainInteractor, NetworkPort.CallBack {

    private CallBack callBack;

    @Override
    public void fetchFacts(NetworkPort networkPort, CallBack callBack) {
        this.callBack = callBack;
        networkPort.callFactsApi("dog", "1", this);
    }

    @Override
    public void onTaskCompleted(Fact fact) {
        callBack.onFactFetched(fact);
    }

    @Override
    public void onTaskError(String message) {
        callBack.onError(message);
    }
}