package com.sandeep.apps.android.animalfacts.facts.domain.repository;

import com.sandeep.apps.android.animalfacts.facts.domain.entity.FactEntity;

public interface FactsRepository {

    FactEntity getRandomFacts();

    FactEntity getFactsByType(String animalType);
}