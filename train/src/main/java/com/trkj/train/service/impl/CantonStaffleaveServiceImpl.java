package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.entity.CantonStaffleave;
import com.trkj.train.entity.SysPersonal;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.entity.vo.staffAndPersonalAndLeave;
import com.trkj.train.mapper.CantonStaffleaveMapper;
import com.trkj.train.mapper.SysPersonalMapper;
import com.trkj.train.mapper.SysStaffMapper;
import com.trkj.train.service.ICantonStaffleaveService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
public class CantonStaffleaveServiceImpl extends ServiceImpl<CantonStaffleaveMapper, CantonStaffleave> implements ICantonStaffleaveService {

    @Autowired
    private CantonStaffleaveMapper staffleaveMapper;

    @Autowired
    private SysStaffMapper staffMapper;

    @Autowired
    private SysPersonalMapper personalMapper;

    //员工请假分页查询
    @Override
    public IPage<staffAndPersonalAndLeave> selectLeaveAll(Page page,String like) {
        QueryWrapper<CantonStaffleave> wrapper=new QueryWrapper();
        wrapper.orderByDesc("leave_id");
        IPage<CantonStaffleave> iPage0=staffleaveMapper.selectPage(page,wrapper);
        //要返回的数据集合
        List<staffAndPersonalAndLeave> list=new ArrayList<>();
        for (CantonStaffleave leave : iPage0.getRecords()) {
            //查询请假人信息
            SysStaff staff1=staffMapper.selectOne(new QueryWrapper<SysStaff>().eq("staff_id",leave.getStaffId1()));
            SysPersonal personal1=personalMapper.selectOne(new QueryWrapper<SysPersonal>().eq("personal_id",staff1.getPersonalId()));
            //审批人实体
            SysPersonal personal2=null;
            if(leave.getLeaveState()!=0){
                SysStaff staff2=staffMapper.selectOne(new QueryWrapper<SysStaff>().eq("staff_id",leave.getStaffId2()));
                personal2=personalMapper.selectOne(new QueryWrapper<SysPersonal>().eq("personal_id",staff2.getPersonalId()));
            }
            //要返回的实体类
            staffAndPersonalAndLeave spl=new staffAndPersonalAndLeave();
            spl.setStaffId1(leave.getStaffId1());
            spl.setPersonalName1(personal1.getPersonalName());
            spl.setPersonalPhone(personal1.getPersonalPhone());
            spl.setPersonalMail(personal1.getPersonalMail());
            spl.setLeaveContent(leave.getLeaveContent());
            spl.setBeginTime(leave.getBeginTime());
            spl.setEndTime(leave.getEndTime());
            spl.setBeginTime1(leave.getBeginTime());
            spl.setEndTime1(leave.getEndTime());
            spl.setLeaveState(leave.getLeaveState());
            if(leave.getLeaveState()!=0){
                spl.setStaffId2(personal2.getPersonalId());
                spl.setPersonalName2(personal2.getPersonalName());
            }
            list.add(spl);
        }
        IPage<staffAndPersonalAndLeave> iPage=new Page<>();
        iPage.setPages(iPage0.getPages());
        iPage.setSize(iPage0.getSize());
        iPage.setCurrent(iPage0.getCurrent());
        iPage.setRecords(list);
        iPage.setTotal(iPage0.getTotal());
        return iPage;
    }
}
