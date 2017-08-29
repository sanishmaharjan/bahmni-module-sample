package com.lftechnology.module.api.web.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lftechnology.module.api.model.Temp;
import com.lftechnology.module.api.service.TempService;
import com.lftechnology.module.api.web.BaseIntegrationTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TempControllerIT extends BaseIntegrationTest {
    @InjectMocks
    TempController tempController;

    @Mock
    TempService tempService;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(tempController).build();
        List<Temp> temps = new ArrayList<>();
        temps.add(new Temp(1, "sanish"));
        Mockito.when(tempService.getAllTemps()).thenReturn(temps);
    }

    @Test
    public void getAllAppointmentServices() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/rest/v1/temp/all").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        String content = result.getResponse().getContentAsString();
        //System.out.println(content);
        JsonArray jsonArray = new JsonParser().parse(content).getAsJsonArray();;
        JsonObject row = jsonArray.get(0).getAsJsonObject();
        Assert.assertEquals("sanish", row.get("name").getAsString());
    }

}
