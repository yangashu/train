package com.trkj.train.config.dto.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.train.config.Result;
import com.trkj.train.config.dto.domain.Paging;
import com.trkj.train.config.dto.vo.ExpenditureAndRefundAndPurchaseAndStaffVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


public interface IExpenditureAndRefundAndPurchaseAndStaffService extends IService<ExpenditureAndRefundAndPurchaseAndStaffVo> {
    Result paging(Map<String, Object> map);

    Result export(HttpServletResponse response, Paging paging) throws Exception;

    Result updateBatchbyid(List<Integer> ids);
}
