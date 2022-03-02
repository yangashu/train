package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.TalkeDo;
import com.trkj.train.entity.RecruitStudenttalk;
import com.trkj.train.mapper.RecruitStudenttalkMapper;
import com.trkj.train.service.IRecruitStudenttalkService;
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
public class RecruitStudenttalkServiceImpl extends ServiceImpl<RecruitStudenttalkMapper, RecruitStudenttalk> implements IRecruitStudenttalkService {
    @Autowired
    private RecruitStudenttalkMapper recruitStudenttalkMapper;


    @Override
    public IPage<TalkeDo> selecttalk(int page, int size, int studentId) {
        Page page1=new Page(page,size);
        IPage<TalkeDo> iPage=recruitStudenttalkMapper.selecttalk(page1,studentId);
        return iPage;
    }

    @Override
    public int inserttalk(RecruitStudenttalk recruitStudenttalk) {
        try {
            return recruitStudenttalkMapper.insert(recruitStudenttalk);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }

    @Override
    public int deletetalk(RecruitStudenttalk recruitStudenttalk) {
        try {
            return recruitStudenttalkMapper.deleteById(recruitStudenttalk);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }
}
