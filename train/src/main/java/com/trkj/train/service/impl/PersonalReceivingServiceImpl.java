package com.trkj.train.service.impl;

import com.trkj.train.entity.PersonalReceiving;
import com.trkj.train.mapper.PersonalReceivingMapper;
import com.trkj.train.service.IPersonalReceivingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class PersonalReceivingServiceImpl extends ServiceImpl<PersonalReceivingMapper, PersonalReceiving> implements IPersonalReceivingService {
    @Autowired
    private PersonalReceivingMapper mapper;

    @Override
    public int one() {
        List<PersonalReceiving> list=mapper.selectList(null);
        List<PersonalReceiving> list1=new ArrayList<>();
        for(PersonalReceiving r : list){
            String newDate=new Date().toLocaleString().substring(0,10);
            String oldDate=r.getReceivingDate().toString().substring(0,10);
            if (newDate.equals(oldDate)){
                list1.add(r);
            }else {
                continue;
            }
        }
        return list1.size();
    }
}
