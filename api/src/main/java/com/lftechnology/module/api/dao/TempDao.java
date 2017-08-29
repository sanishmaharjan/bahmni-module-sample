package com.lftechnology.module.api.dao;

import com.lftechnology.module.api.model.Temp;

import java.util.List;

public interface TempDao {
    Temp getTempByUuid(String uuid);

    List<Temp> getAllTemps();
}
