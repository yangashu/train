package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.entity.CantonSatffsign;
import com.trkj.train.entity.SysPersonal;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.entity.vo.staffAndSign;
import com.trkj.train.mapper.SysPersonalMapper;
import com.trkj.train.mapper.SysStaffMapper;
import com.trkj.train.service.ICantonSatffsignService;
import com.trkj.train.service.ISysPersonalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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
public class SysPersonalServiceImpl extends ServiceImpl<SysPersonalMapper, SysPersonal> implements ISysPersonalService {

    @Autowired
    private SysPersonalMapper mapper;

    @Autowired
    private ICantonSatffsignService service;

    @Autowired
    private SysStaffMapper staffMapper;

    //员工打卡分页查询用到的方法
    @Override
    public SysPersonal one(int personalId) {
//        System.out.println(staffId);
        QueryWrapper<SysPersonal> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("personal_id",personalId);
        SysPersonal personal=mapper.selectOne(queryWrapper);
        return personal;
    }

    //员工打卡模糊查询分页用的方法
    @Override
    public IPage<staffAndSign> two(String information, String mode, int page, int size) {
        QueryWrapper<SysPersonal> queryWrapper = new QueryWrapper<>();
        if(mode.equals("员工姓名")){
            queryWrapper.like("PERSONAL_NAME",information);
        }else if(mode.equals("联系电话")){
            queryWrapper.like("PERSONAL_PHONE",information);
        }
        IPage<SysPersonal> iPage0=mapper.selectPage(new Page(page,size),queryWrapper);
        IPage<staffAndSign> iPage=new Page<>();
        List<staffAndSign> list=new ArrayList<>();
        for(int i=0;i<iPage0.getRecords().size();i++){
            QueryWrapper q=new QueryWrapper();
            q.eq("personal_id",iPage0.getRecords().get(i).getPersonalId());
            SysStaff staff=staffMapper.selectOne(q);
            CantonSatffsign s=service.three(staff.getStaffId());
            staffAndSign ss=new staffAndSign();
            ss.setSignId(s.getSignId());
            ss.setStaffId(staff.getStaffId());
            ss.setPersonalName(iPage0.getRecords().get(i).getPersonalName());
            ss.setPersonalPhone(iPage0.getRecords().get(i).getPersonalPhone());
            ss.setSignDate(s.getSignDate());
            ss.setSignState(s.getSignState());
            list.add(ss);
        }
        iPage.setCurrent(iPage0.getCurrent());
        iPage.setPages(iPage0.getPages());
        iPage.setTotal(iPage0.getTotal());
        iPage.setSize(iPage0.getSize());
        iPage.setRecords(list);
        return iPage;
    }

}
