package com.lftechnology.module.api.web.service.impl;

import com.lftechnology.module.api.web.service.BahmniService;
import org.bahmni.module.bahmnicore.service.BahmniConceptService;
import org.openmrs.Concept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BahmniServiceImpl implements BahmniService {

    @Autowired
    private BahmniConceptService conceptService;

    @Override
    public Concept getBahmniConceptByFullySpecifiedName(String name) {
        return conceptService.getConceptByFullySpecifiedName("Lab Samples");
    }
}
