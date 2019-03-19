package com.sandeep.apps.android.animalfacts.domain;

public interface NetworkPort {

    void callFactsApi(String animalType, String number, CallBack onFactsResponse);

    interface CallBack {
        void onTaskCompleted(Fact fact);
        void onTaskError(String message);
    }
}