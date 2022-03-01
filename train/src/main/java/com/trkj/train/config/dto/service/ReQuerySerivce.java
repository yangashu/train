package com.trkj.train.config.dto.service;

import com.trkj.train.config.Result;
import com.trkj.train.entity.SysStaff;

public interface ReQuerySerivce {
    Result requery(int pass,SysStaff staff);
}
