package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.ectGraduationDo;
import com.trkj.train.entity.EctGraduation;
import com.trkj.train.mapper.EctGraduationMapper;
import com.trkj.train.service.IEctGraduationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;

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
public class EctGraduationServiceImpl extends ServiceImpl<EctGraduationMapper, EctGraduation> implements IEctGraduationService {
    @Autowired
    private EctGraduationMapper ectGraduationMapper;

    @Override
    public IPage<ectGraduationDo> selectlscx(int page, int size) {
        Page page1=new Page<>(page,size);
        return ectGraduationMapper.selectHistory(page1);
    }

    @Override
    public IPage<ectGraduationDo> selectiptionhistry(int page, int size, String valueone, String inputone, int deleted) {
        System.out.println("valueone"+valueone);
        System.out.println("inputone"+inputone);
        Page page1=new Page<>(page,size);
        QueryWrapper queryWrapper=new QueryWrapper();
        if (deleted==0){
            queryWrapper.eq("e.deleted", deleted);
            if (valueone.equals("学生姓名")){
                if (inputone!=null && inputone.length()!=0) {
                    queryWrapper.like("r.student_name", inputone);
                }
            }else if (valueone.equals("家庭地址")){
                if (inputone!=null && inputone.length()!=0) {
                    queryWrapper.like("r.student_loc", inputone);
                }
            }
        }
        IPage<ectGraduationDo> page2=ectGraduationMapper.selectiptionhistory(page1,queryWrapper);
        return page2;
    }

    @Override
    public int insertstudnetaaa(EctGraduation ectGraduation) {
        try {
            ectGraduation.setGraduationDate(new Date());
            return ectGraduationMapper.insert(ectGraduation);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }
}
