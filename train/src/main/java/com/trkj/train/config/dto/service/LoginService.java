package com.trkj.train.config.dto.service;

import com.trkj.train.config.Result;
import com.trkj.train.entity.SysStaff;

public interface LoginService {
    public Result login(SysStaff staff);

    Result logout();
}
