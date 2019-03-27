package com.sandeep.apps.android.animalfacts.facts;

import com.sandeep.apps.android.animalfacts.common.BasePresenter;
import com.sandeep.apps.android.animalfacts.common.BaseView;
import com.sandeep.apps.android.animalfacts.facts.domain.entity.FactEntity;

public interface FactsContract extends BasePresenter {

    interface Presenter extends BasePresenter {

        void fetchFacts(View view);
    }

    interface View extends BaseView {
        void onFactFetched(FactEntity fact);

        void onError(String message);
    }
}