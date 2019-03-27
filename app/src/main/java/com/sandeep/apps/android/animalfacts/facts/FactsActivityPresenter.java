package com.sandeep.apps.android.animalfacts.facts;

import com.sandeep.apps.android.animalfacts.common.MainThreadImpl;
import com.sandeep.apps.android.animalfacts.common.ThreadExecutor;
import com.sandeep.apps.android.animalfacts.facts.data.FactRepositoryImpl;
import com.sandeep.apps.android.animalfacts.facts.domain.entity.FactEntity;
import com.sandeep.apps.android.animalfacts.facts.domain.interactor.GetRandomFactInteractor;
import com.sandeep.apps.android.animalfacts.facts.domain.interactor.GetRandomFactInteractorImpl;

public class FactsActivityPresenter implements FactsContract.Presenter, GetRandomFactInteractor.CallBack {

    private FactsContract.View view;

    @Override
    public void fetchFacts(FactsContract.View view) {
        this.view = view;
//        NetworkPort networkPort = new FactRepositoryImpl();
//        new MainInteractorImpl().fetchFacts(networkPort, this);

        GetRandomFactInteractor getRandomFact = new GetRandomFactInteractorImpl(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(),
                new FactRepositoryImpl(), this);
        ((GetRandomFactInteractorImpl) getRandomFact).execute();
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
    public void onFactFetched(FactEntity fact) {
        view.onFactFetched(fact);
    }

    @Override
    public void onError(String message) {
        view.onError(message);
    }
}