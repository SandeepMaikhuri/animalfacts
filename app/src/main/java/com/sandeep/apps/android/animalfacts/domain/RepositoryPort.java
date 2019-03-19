package com.sandeep.apps.android.animalfacts.domain;

public interface RepositoryPort {

    void fetchFacts(String animalType, String number, CallBack onFactsFetched);

    interface CallBack {
        void onTaskCompleted(Fact fact);
        void onTaskError(String message);
    }
}