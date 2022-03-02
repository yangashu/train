package com.trkj.train.service.impl;

import com.trkj.train.entity.EctRefund;
import com.trkj.train.mapper.EctRefundMapper;
import com.trkj.train.service.IEctRefundService;
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
public class EctRefundServiceImpl extends ServiceImpl<EctRefundMapper, EctRefund> implements IEctRefundService {
    @Autowired
    private EctRefundMapper ectRefundMapper;


    @Override
    public int inserttuifei(EctRefund ectRefund) {
        try {
            int tuifei=ectRefundMapper.insert(ectRefund);
            return (ectRefund.getRefundId());
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }
}
