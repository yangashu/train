package com.trkj.train.service.impl;

import com.trkj.train.entity.FinancePay;
import com.trkj.train.mapper.FinancePayMapper;
import com.trkj.train.service.IFinancePayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@Transactional
@Service
public class FinancePayServiceImpl extends ServiceImpl<FinancePayMapper, FinancePay> implements IFinancePayService {
    @Autowired
    private FinancePayMapper financePayMapper;


    @Override
    public int insertpay(FinancePay financePay) {
        try {
            return financePayMapper.insert(financePay);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }
}
