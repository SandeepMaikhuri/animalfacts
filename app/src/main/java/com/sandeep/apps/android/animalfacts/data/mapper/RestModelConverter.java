package com.sandeep.apps.android.animalfacts.data.mapper;

import com.sandeep.apps.android.animalfacts.data.network.FactEntity;
import com.sandeep.apps.android.animalfacts.domain.Fact;

public class RestModelConverter {

    public static Fact convertToDomainModel(FactEntity factEntity) {
        Fact fact = null;
        if (factEntity != null) {
            fact = new Fact(factEntity.getId());
            fact.setId(factEntity.getId());
            fact.setUpdateAt(factEntity.getUpdatedAt());
            fact.setCreatedAt(factEntity.getCreatedAt());
            fact.setUserId(factEntity.getId());
            fact.setText(factEntity.getText());
            fact.setType(factEntity.getType());
            fact.setV(factEntity.getV());
            fact.setDeleted(factEntity.isDeleted());
            fact.setUsed(factEntity.isUsed());
        }
        return fact;
    }
}