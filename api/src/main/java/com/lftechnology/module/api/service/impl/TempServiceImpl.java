package com.lftechnology.module.api.service.impl;

import com.lftechnology.module.api.dao.TempDao;
import com.lftechnology.module.api.model.Temp;
import com.lftechnology.module.api.service.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempServiceImpl implements TempService {

    private TempDao tempDao;



    @Autowired
    public TempServiceImpl(TempDao tempDao) {
        this.tempDao = tempDao;
    }

    @Override
    public Temp getTempByUuid(String uuid) {
        return tempDao.getTempByUuid(uuid);
    }

    @Override
    public List<Temp> getAllTemps() {
        return tempDao.getAllTemps();
    }


}
