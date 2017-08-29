package com.lftechnology.module.api.service.impl;

import com.lftechnology.module.api.dao.TempDao;
import com.lftechnology.module.api.model.Temp;
import com.lftechnology.module.api.service.TempService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@org.springframework.test.context.ContextConfiguration(locations = { "classpath:TestingApplicationContext.xml" }, inheritLocations = true)
public class TempServiceImplTest {

    @Mock
    TempDao tempDao;
    private TempService tempService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        tempService = new TempServiceImpl(tempDao);
        Temp temp = new Temp(1, "Sanish");
        Mockito.when(tempDao.getTempByUuid("c36006e5-9fbb-4f20-866b-0ece245615a1")).thenReturn(temp);
    }

    @Test
    public void testGetTempByUuid() throws Exception {
        Temp temp = tempService.getTempByUuid("c36006e5-9fbb-4f20-866b-0ece245615a1");
        Assert.assertEquals(temp.getName(), "Sanish");
    }

}
