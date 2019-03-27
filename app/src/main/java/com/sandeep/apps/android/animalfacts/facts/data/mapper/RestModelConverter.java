package com.sandeep.apps.android.animalfacts.facts.data.mapper;

import com.sandeep.apps.android.animalfacts.facts.data.network.FactRestEntity;
import com.sandeep.apps.android.animalfacts.facts.domain.entity.FactEntity;

public class RestModelConverter {

    public static FactEntity convertToDomainModel(FactRestEntity factRestEntity) {
        FactEntity fact = null;
        if (factRestEntity != null) {
            fact = new FactEntity(factRestEntity.getId());
            fact.setId(factRestEntity.getId());
            fact.setUpdatedAt(factRestEntity.getUpdatedAt());
            fact.setCreatedAt(factRestEntity.getCreatedAt());
            fact.setId(factRestEntity.getId());
            fact.setText(factRestEntity.getText());
            fact.setType(factRestEntity.getType());
            fact.setV(factRestEntity.getV());
            fact.setDeleted(factRestEntity.isDeleted());
            fact.setUsed(factRestEntity.isUsed());
        }
        return fact;
    }
}