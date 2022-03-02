package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.recruitStudentHonorDo;
import com.trkj.train.entity.RecruitStudenthonor;
import com.trkj.train.mapper.RecruitStudenthonorMapper;
import com.trkj.train.service.IRecruitStudenthonorService;
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
public class RecruitStudenthonorServiceImpl extends ServiceImpl<RecruitStudenthonorMapper, RecruitStudenthonor> implements IRecruitStudenthonorService {
@Autowired
    private RecruitStudenthonorMapper recruitStudenthonorMapper;

    @Override
    public IPage<recruitStudentHonorDo> selectxyry(int page, int size, int studentId) {
        Page page1=new Page(page,size);
        IPage<recruitStudentHonorDo> page2=recruitStudenthonorMapper.studentry(page1,studentId);
        return page2;
    }

    @Override
    public int insertstudentry(RecruitStudenthonor recruitStudenthonor) {
        try {
            return recruitStudenthonorMapper.insert(recruitStudenthonor);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }
}
