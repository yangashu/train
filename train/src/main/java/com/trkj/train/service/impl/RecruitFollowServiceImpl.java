package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.train.entity.RecruitFollow;
import com.trkj.train.mapper.RecruitFollowMapper;
import com.trkj.train.service.IRecruitFollowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@Service
@Transactional
public class RecruitFollowServiceImpl extends ServiceImpl<RecruitFollowMapper, RecruitFollow> implements IRecruitFollowService {
    @Autowired
    private RecruitFollowMapper recruitFollowMapper;


    @Override
    public int insertgengjin(RecruitFollow recruitFollow) {
        try {
            return recruitFollowMapper.insert(recruitFollow);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }

    @Override
    public List<RecruitFollow> selectfollow(int id) {
        QueryWrapper<RecruitFollow> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("STUDENTFILES_ID",id);
        return recruitFollowMapper.selectList(queryWrapper);
    }
}
