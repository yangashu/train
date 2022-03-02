package com.trkj.train.service.impl;

import com.trkj.train.entity.EctLeaverecord;
import com.trkj.train.mapper.EctLeaverecordMapper;
import com.trkj.train.service.IEctLeaverecordService;
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
public class EctLeaverecordServiceImpl extends ServiceImpl<EctLeaverecordMapper, EctLeaverecord> implements IEctLeaverecordService {
    @Autowired
    private EctLeaverecordMapper ectLeaverecordMapper;


    @Override
    public int inserttuixuejil(EctLeaverecord ectLeaverecord) {
        try {
            int txsq=ectLeaverecordMapper.insert(ectLeaverecord);
            return (ectLeaverecord.getLeaverecordId());
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }
}
