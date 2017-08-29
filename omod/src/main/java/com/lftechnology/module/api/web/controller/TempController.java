package com.lftechnology.module.api.web.controller;

import com.lftechnology.module.api.model.Temp;
import com.lftechnology.module.api.service.TempService;
import com.lftechnology.module.api.web.service.BahmniService;
import org.bahmni.module.bahmnicore.contract.patient.response.PatientConfigResponse;
import org.bahmni.module.bahmnicore.service.BahmniConceptService;
import org.bahmni.module.bahmnicore.service.BahmniPatientService;
import org.openmrs.Concept;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/rest/" + RestConstants.VERSION_1 + "/temp")
public class TempController {

    @Autowired
    private TempService tempService;

    @Autowired
    private BahmniPatientService patientService;

    @Autowired
    private BahmniService bahmniService;

    @Autowired
    private BahmniConceptService conceptService;

    @RequestMapping(method = RequestMethod.GET, value = "all")
    @ResponseBody
    public List getAllTemps() {
        List<Temp> temps = tempService.getAllTemps();
        List listTemps = new ArrayList();
        for (Temp temp : temps) {
            HashMap response = new HashMap<>();
            response.put("name", temp.getName());
            response.put("uuid", temp.getUuid());
            listTemps.add(response);
        }
        return listTemps;
    }

    @RequestMapping(method = RequestMethod.GET, value = "config")
    @ResponseBody
    public PatientConfigResponse getOrderByUid() {
        PatientConfigResponse patientConfigResponse = patientService.getConfig();
        return patientConfigResponse;
    }

    @RequestMapping(method = RequestMethod.GET, value = "sampleId")
    @ResponseBody
    public Integer getConcept() {
        Concept concept = bahmniService.getBahmniConceptByFullySpecifiedName("Lab Samples");
        return concept.getConceptId();
    }
}
