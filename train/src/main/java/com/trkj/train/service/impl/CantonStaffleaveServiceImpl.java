package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
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
        IPage<staffAndPersonalAndLeave> iPage=new Page<>();
        int total=0;
        for (CantonStaffleave leave : iPage0.getRecords()) {
            if(like==""){
                //查询请假人信息
                SysStaff staff1=staffMapper.selectOne(new QueryWrapper<SysStaff>().eq("staff_id",leave.getStaffId1()));
                SysPersonal personal1=personalMapper.selectOne(new QueryWrapper<SysPersonal>().eq("personal_id",staff1.getPersonalId()));
                //查询审批人信息
                SysPersonal personal2=null;
                if(leave.getLeaveState()!=0){
                    SysStaff staff2=staffMapper.selectOne(new QueryWrapper<SysStaff>().eq("staff_id",leave.getStaffId2()));
                    personal2=personalMapper.selectOne(new QueryWrapper<SysPersonal>().eq("personal_id",staff2.getPersonalId()));
                }
                //要返回的实体类
                staffAndPersonalAndLeave spl=new staffAndPersonalAndLeave();
                spl.setLeaveId(leave.getLeaveId());
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
                iPage.setTotal(iPage0.getTotal());
            }else{
                //查询请假人信息
                List<SysPersonal> personalist=personalMapper.selectList(new QueryWrapper<SysPersonal>().like("personal_name",like));
                //查询审批人信息
                SysPersonal personal2=null;
                if(leave.getLeaveState()!=0){
                    SysStaff staff2=staffMapper.selectOne(new QueryWrapper<SysStaff>().eq("staff_id",leave.getStaffId2()));
                    personal2=personalMapper.selectOne(new QueryWrapper<SysPersonal>().eq("personal_id",staff2.getPersonalId()));
                }
                staffAndPersonalAndLeave spl=new staffAndPersonalAndLeave();
                //要返回的实体类
                for(SysPersonal personal:personalist){
                    SysStaff staff1=staffMapper.selectOne(new QueryWrapper<SysStaff>().eq("personal_id",personalist.get(0).getPersonalId()));
                    if(staff1.getStaffId()==leave.getStaffId1()){
                        spl.setStaffId1(leave.getStaffId1());
                        spl.setPersonalName1(personal.getPersonalName());
                        spl.setPersonalPhone(personal.getPersonalPhone());
                        spl.setPersonalMail(personal.getPersonalMail());
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
                        total=total+1;
                    }else{
                        continue;
                    }
                }
                iPage.setTotal(total);
            }

        }

        iPage.setPages(iPage0.getPages());
        iPage.setSize(iPage0.getSize());
        iPage.setCurrent(iPage0.getCurrent());
        iPage.setRecords(list);
        return iPage;
    }

    //添加一张请假条
    @Override
    public Result addLeave(CantonStaffleave leave) {
        int i=staffleaveMapper.insert(leave);
        if(i>0){
            return Result.success("0","申请成功，等待审批中",i);
        }else{
            return Result.error("1","不知名的原因");
        }

    }

    @Override
    public Result approveLeave(int leaveId,int staffId) {
        CantonStaffleave leave=new CantonStaffleave();
        leave.setLeaveState(1);
        leave.setStaffId2(staffId);
        int i=staffleaveMapper.update(leave,new QueryWrapper<CantonStaffleave>().eq("leave_id",leaveId));
        if(i>0){
            return Result.success("0","审批完成",i);
        }else{
            return Result.error("1","莫名错误");
        }
    }
}
