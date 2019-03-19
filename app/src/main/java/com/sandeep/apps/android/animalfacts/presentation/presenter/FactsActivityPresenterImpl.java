package com.sandeep.apps.android.animalfacts.presentation.presenter;

import com.sandeep.apps.android.animalfacts.data.network.NetworkAdapter;
import com.sandeep.apps.android.animalfacts.domain.Fact;
import com.sandeep.apps.android.animalfacts.domain.NetworkPort;
import com.sandeep.apps.android.animalfacts.domain.interactor.MainInteractor;
import com.sandeep.apps.android.animalfacts.domain.interactor.MainInteractorImpl;

public class FactsActivityPresenterImpl implements FactsActivityPresenter, MainInteractor.CallBack {

    private View view;

    @Override
    public void fetchFacts(View view) {
        this.view = view;
        NetworkPort networkPort = new NetworkAdapter();
        new MainInteractorImpl().fetchFacts(networkPort, this);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onFactFetched(Fact fact) {
        view.onFactFetched(fact);
    }

    @Override
    public void onError(String message) {
        view.onError(message);
    }
}