package com.lftechnology.module.api.dao;

import com.lftechnology.module.api.exception.SaveEntityException;
import com.lftechnology.module.api.exception.UpdateEntityException;
import com.lftechnology.module.api.model.Temp;

import java.util.List;

public interface TempDao {

    Temp save(Temp temp) throws SaveEntityException;

    Temp update(Temp temp) throws UpdateEntityException;

    Temp getTempByUuid(String uuid);

    List<Temp> getAllTemps();
}
