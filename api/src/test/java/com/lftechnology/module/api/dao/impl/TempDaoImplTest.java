package com.lftechnology.module.api.dao.impl;

import com.lftechnology.module.api.BaseIntegrationTest;
import com.lftechnology.module.api.model.Temp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TempDaoImplTest extends BaseIntegrationTest {

    @Autowired
    TempDaoImpl tempDao;

    @Before
    public void setUp() throws Exception {
        executeDataSet("tempTestData.xml");
    }

    @Test
    public void testTepByUuid() throws Exception {
       String tempUuid = "c36006e5-9fbb-4f20-866b-0ece245615a1";
        Temp temp = tempDao.getTempByUuid(tempUuid);
        Assert.assertEquals("test", temp.getName());
    }

    @Test
    public void testGetAllTemps() throws Exception {
        List<Temp> temps = tempDao.getAllTemps();
        Assert.assertEquals(1, temps.size());
        Temp temp = temps.get(0);
        Assert.assertEquals("test", temp.getName());
    }
}