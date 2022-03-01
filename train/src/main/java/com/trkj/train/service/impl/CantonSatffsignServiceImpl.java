package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.entity.CantonAttendance;
import com.trkj.train.entity.CantonSatffsign;
import com.trkj.train.entity.SysPersonal;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.entity.vo.staffAndSign;
import com.trkj.train.mapper.CantonAttendanceMapper;
import com.trkj.train.mapper.CantonSatffsignMapper;
import com.trkj.train.mapper.SysStaffMapper;
import com.trkj.train.service.ICantonAttendanceService;
import com.trkj.train.service.ICantonSatffsignService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.train.service.ISysPersonalService;
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
public class CantonSatffsignServiceImpl extends ServiceImpl<CantonSatffsignMapper, CantonSatffsign> implements ICantonSatffsignService {

    @Autowired
    private CantonSatffsignMapper mapper;

    @Autowired
    private CantonAttendanceMapper attendanceMapper;

    @Autowired
    private SysStaffMapper staffMapper;

    @Autowired
    private ISysPersonalService service;

    @Autowired
    private ICantonAttendanceService aservice;

    //分页查询员工打卡状态方法
    @Override
    public IPage<staffAndSign> one(int page, int size) {
        QueryWrapper<SysStaff> q=new QueryWrapper();
        q.eq("STAFF_STATE",0);
        q.orderByAsc("staff_id");
        IPage<SysStaff> iPage=staffMapper.selectPage(new Page<>(page,size),q);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        List<staffAndSign> list1=new ArrayList<>();
        IPage<staffAndSign> list=new Page<>();
        for(int i=0;i<iPage.getRecords().size();i++){
            QueryWrapper<CantonSatffsign> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("staff_id",iPage.getRecords().get(i).getStaffId());
            CantonSatffsign sta=mapper.selectOne(queryWrapper);
            SysPersonal p=service.one(iPage.getRecords().get(i).getPersonalId());
            staffAndSign ss=new staffAndSign();
            ss.setPersonalName(p.getPersonalName());
            ss.setPersonalPhone(p.getPersonalPhone());
            ss.setSignDate(sta.getSignDate());
            ss.setSignId(sta.getSignId());
            String newDate=format.format(new Date());
            String oldDate= format.format(sta.getSignDate());;
            if(newDate.equals(oldDate) && sta.getSignState()==0){
                ss.setSignState(2);
            }else if(newDate.equals(oldDate) && sta.getSignState()==1){
                ss.setSignState(1);
            }else{
                ss.setSignState(0);
            }
            ss.setStaffId(iPage.getRecords().get(i).getStaffId());
            list1.add(ss);
        }
        list.setCurrent(iPage.getCurrent());
        list.setPages(iPage.getPages());
        list.setSize(iPage.getSize());
        list.setTotal(iPage.getTotal());
        list.setRecords(list1);
        return list;
    }

    //打卡时自动修改状态方法
    @Override
    public int two(int userId) {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        List<CantonAttendance> list=attendanceMapper.selectList(null);
        boolean jg=true;
        for(CantonAttendance a: list){
            String newDate=format.format(new Date());
            String oldDate= format.format(a.getAttendanceDate());
            if(a.getStaffId()==userId && newDate.equals(oldDate)){
                jg=false;
                break;
            }else{
                jg=true;
            }
        }
        if(jg){
            aservice.one(userId);
            CantonSatffsign sign=new CantonSatffsign();
            sign.setSignState(1);
            sign.setSignDate(new Date());
            return mapper.update(sign,new QueryWrapper<CantonSatffsign>().eq("staff_id",userId));
        }else{
            aservice.one(userId);
            CantonSatffsign sign=new CantonSatffsign();
            sign.setSignState(0);
            sign.setSignDate(new Date());
            return mapper.update(sign,new QueryWrapper<CantonSatffsign>().eq("staff_id",userId));
        }

    }

    //查询当前登录账号是否打卡的方法
    @Override
    public int selectSignOne(int staffId) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("staff_id",staffId);
        CantonSatffsign sign=mapper.selectOne(wrapper);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String newDate=format.format(new Date());
        String oldDate= format.format(sign.getSignDate());
        if(newDate.equals(oldDate) && sign.getSignState()==0){
            return 0;
        }else {
            return 1;
        }
    }

    //员工打卡中模糊查询用到的方法
    @Override
    public CantonSatffsign three(int staffID) {
        System.out.println("查询"+staffID);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("STAFF_ID",staffID);
        return mapper.selectOne(queryWrapper);
    }
}
