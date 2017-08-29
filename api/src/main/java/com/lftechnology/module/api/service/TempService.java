package com.lftechnology.module.api.service;

import com.lftechnology.module.api.model.Temp;

import java.util.List;

public interface TempService {
    Temp getTempByUuid(String uuid);

    List<Temp> getAllTemps();
}
