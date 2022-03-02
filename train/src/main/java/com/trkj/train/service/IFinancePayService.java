package com.trkj.train.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.entity.FinancePay;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IFinancePayService extends IService<FinancePay> {
//    添加
    int insertpay(FinancePay financePay);

    Result paging(Page<FinancePay> financePayPage, String search);

    Result export(HttpServletResponse response) throws Exception;

    Result saveAll(MultipartFile excelFile) throws Exception;
}
