package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.punishDo;
import com.trkj.train.entity.RecruitStundentpunish;
import com.trkj.train.mapper.RecruitStundentpunishMapper;
import com.trkj.train.service.IRecruitStundentpunishService;
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
public class RecruitStundentpunishServiceImpl extends ServiceImpl<RecruitStundentpunishMapper, RecruitStundentpunish> implements IRecruitStundentpunishService {
    @Autowired
    private RecruitStundentpunishMapper recruitStundentpunishMapper;


    @Override
    public IPage<punishDo> selectpunish(int page, int size, int studentId) {
        Page page1=new Page(page,size);
        return recruitStundentpunishMapper.selectpunish(page1,studentId);
    }

    @Override
    public int insertpunish(RecruitStundentpunish recruitStundentpunish) {
        try {
            return recruitStundentpunishMapper.insert(recruitStundentpunish);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }
}
