package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.train.entity.EctStudentattend;
import com.trkj.train.mapper.EctStudentattendMapper;
import com.trkj.train.service.IEctStudentattendService;
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
public class EctStudentattendServiceImpl extends ServiceImpl<EctStudentattendMapper, EctStudentattend> implements IEctStudentattendService {
    @Autowired
    private EctStudentattendMapper mapper;

    @Override
    public List<EctStudentattend> one(QueryWrapper<EctStudentattend> queryWrapper) {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        List<EctStudentattend> list=mapper.selectList(queryWrapper);
        List<EctStudentattend> list1=new ArrayList<>();
        for(EctStudentattend s : list){
            String newDate = format.format(new Date());
            String oldDate = s.getStudentattendDate().toString().substring(0,10);
            if(newDate.equals(oldDate)){
                list1.add(s);
            }
        }
        return list1;
    }
}
