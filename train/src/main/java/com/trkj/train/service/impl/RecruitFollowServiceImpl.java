package com.trkj.train.service.impl;

import com.trkj.train.entity.RecruitFollow;
import com.trkj.train.mapper.RecruitFollowMapper;
import com.trkj.train.service.IRecruitFollowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class RecruitFollowServiceImpl extends ServiceImpl<RecruitFollowMapper, RecruitFollow> implements IRecruitFollowService {
    @Autowired
    private RecruitFollowMapper mapper;

    @Override
    public List<RecruitFollow> one() {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM");
        List<RecruitFollow> list=mapper.selectList(null);
        List<RecruitFollow> list1=new ArrayList<>();
        for(RecruitFollow f : list){
            String newDate=format.format(new Date());
            String oldDate=format.format(f.getFollowDate());
            if(newDate.equals(oldDate)){
                list1.add(f);
            }
        }
        return list1;
    }
}
