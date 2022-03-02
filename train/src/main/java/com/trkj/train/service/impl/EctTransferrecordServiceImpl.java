package com.trkj.train.service.impl;

import com.trkj.train.entity.EctTransferrecord;
import com.trkj.train.mapper.EctTransferrecordMapper;
import com.trkj.train.service.IEctTransferrecordService;
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
public class EctTransferrecordServiceImpl extends ServiceImpl<EctTransferrecordMapper, EctTransferrecord> implements IEctTransferrecordService {
    @Autowired
    private EctTransferrecordMapper ectTransferrecordMapper;

    @Override
    public int insertZhuanban(EctTransferrecord ectTransferrecord) {
        try {
            return ectTransferrecordMapper.insert(ectTransferrecord);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }
}
