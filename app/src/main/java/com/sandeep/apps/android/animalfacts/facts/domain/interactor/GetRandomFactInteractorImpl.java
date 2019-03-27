package com.sandeep.apps.android.animalfacts.facts.domain.interactor;

import com.sandeep.apps.android.animalfacts.common.AbstractInteractor;
import com.sandeep.apps.android.animalfacts.common.Executor;
import com.sandeep.apps.android.animalfacts.common.MainThread;
import com.sandeep.apps.android.animalfacts.facts.domain.repository.FactsRepository;
import com.sandeep.apps.android.animalfacts.facts.domain.entity.FactEntity;

public class GetRandomFactInteractorImpl extends AbstractInteractor implements GetRandomFactInteractor {

    private final FactsRepository factsRepository;
    private final CallBack callBack;

    public GetRandomFactInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                       FactsRepository factsRepository, GetRandomFactInteractor.CallBack callBack) {
        super(threadExecutor, mainThread);
        this.factsRepository = factsRepository;
        this.callBack = callBack;
    }

    @Override
    public void run() {
        final FactEntity fact = factsRepository.getRandomFacts();

        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                callBack.onFactFetched(fact);
            }
        });

    }
}