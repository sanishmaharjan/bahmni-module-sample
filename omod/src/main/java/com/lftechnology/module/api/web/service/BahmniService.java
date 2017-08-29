package com.lftechnology.module.api.web.service;

import org.openmrs.Concept;

public interface BahmniService {
    Concept getBahmniConceptByFullySpecifiedName(String name);
}
