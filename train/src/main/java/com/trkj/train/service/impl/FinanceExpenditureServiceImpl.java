package com.trkj.train.service.impl;

import com.trkj.train.entity.FinanceExpenditure;
import com.trkj.train.mapper.FinanceExpenditureMapper;
import com.trkj.train.service.IFinanceExpenditureService;
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
public class FinanceExpenditureServiceImpl extends ServiceImpl<FinanceExpenditureMapper, FinanceExpenditure> implements IFinanceExpenditureService {

    @Autowired
    private FinanceExpenditureMapper financeExpenditureMapper;

    @Override
    public int insertzckc(FinanceExpenditure financeExpenditure) {
        try {
            return financeExpenditureMapper.insert(financeExpenditure);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }
}
