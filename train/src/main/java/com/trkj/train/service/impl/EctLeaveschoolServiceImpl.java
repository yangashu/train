package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.tuixuesqDo;
import com.trkj.train.entity.EctLeaveschool;
import com.trkj.train.mapper.EctLeaveschoolMapper;
import com.trkj.train.service.IEctLeaveschoolService;
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
public class EctLeaveschoolServiceImpl extends ServiceImpl<EctLeaveschoolMapper, EctLeaveschool> implements IEctLeaveschoolService {
    @Autowired
    private EctLeaveschoolMapper ectLeaveschoolMapper;


    @Override
    public IPage<tuixuesqDo> selecttuixue(int page, int size, String studentName,int deleted) {
        Page page1=new Page(page,size);
        QueryWrapper<tuixuesqDo> queryWrapper=new QueryWrapper<>();
        if (deleted==0){
            queryWrapper.like("e.deleted",deleted);
            if (studentName!=null && studentName.length()!=0){
                queryWrapper.like("r.student_name",studentName);
            }
        }
        IPage<tuixuesqDo> iPage=ectLeaveschoolMapper.selecttuixue(page1,queryWrapper);
        return iPage;
    }

    @Override
    public int inserttuixue(EctLeaveschool ectLeaveschool) {
        try {
            int a=ectLeaveschoolMapper.insert(ectLeaveschool);
            return (ectLeaveschool.getLeaveschoolId());
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }
}
