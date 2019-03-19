package com.sandeep.apps.android.animalfacts.presentation.presenter;

import com.sandeep.apps.android.animalfacts.domain.Fact;
import com.sandeep.apps.android.animalfacts.presentation.view.BaseView;

public interface FactsActivityPresenter extends BasePresenter {

    void fetchFacts(View view);

    interface View extends BaseView {
        void onFactFetched(Fact fact);

        void onError(String message);
    }
}
