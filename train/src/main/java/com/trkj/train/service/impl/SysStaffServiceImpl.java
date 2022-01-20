package com.trkj.train.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.entity.SysPersonal;
import com.trkj.train.entity.SysPosition;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.entity.SysStaffPosition;
import com.trkj.train.mapper.SysPersonalMapper;
import com.trkj.train.mapper.SysStaffMapper;
import com.trkj.train.mapper.SysStaffPositionMapper;
import com.trkj.train.service.ISysStaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-18
 */
@Service
public class SysStaffServiceImpl extends ServiceImpl<SysStaffMapper, SysStaff> implements ISysStaffService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SysStaffMapper mapper;

    @Autowired
    private SysStaffPositionMapper staffPositionMapper;

    @Autowired
    private SysPersonalMapper personalMapper;



    @Override
    public IPage<SysStaff> paging(Page<SysStaff> page,String search){
        IPage<SysStaff> iPage= mapper.selectPage(page,new QueryWrapper<SysStaff>().like("staff_name",search));
        List<SysPersonal> personals = personalMapper.selectList(null);
        for (int i=0;i<iPage.getRecords().size();i++){
            List<SysPosition> position = staffPositionMapper.selectBystaffid(iPage.getRecords().get(i).getStaffId());
            for (SysPersonal personal : personals) {
                if(iPage.getRecords().get(i).getPersonalId()==personal.getPersonalId()){
                    iPage.getRecords().get(i).setPersonal(personal);
                }
            }
            iPage.getRecords().get(i).setPositions(position);
        }



        return iPage;
    }

    @Transactional
    @Override
    public Result insert(Map<String,Object> map) {


        List<Integer> ids = JSON.parseObject(JSON.toJSONString(map.get("ids")), List.class);
        SysStaff staff = JSON.parseObject(JSON.toJSONString(map.get("staff")), SysStaff.class);
        List<SysStaffPosition> staffPositions = new ArrayList<>();
        //密码加密
        String pass = passwordEncoder.encode(staff.getStaffPass());
        staff.setStaffPass(pass);
        int i = mapper.updateById(staff);
        int i1 = personalMapper.updateById(staff.getPersonal());
        if (i>0 && i1>0) {
            if (ids.size()>0 || !ids.isEmpty()) {
                for (Integer id : ids) {
                    SysStaffPosition staffPosition=new SysStaffPosition();
                    staffPosition.setStaffId(staff.getStaffId());
                    staffPosition.setPositionId(id);
                    staffPositions.add(staffPosition);
                }
                if (staffPositionMapper.deleteByStaffId(staff.getStaffId())) {
                    if (staffPositionMapper.insertBatch(staffPositions)) {
                        return Result.success("200", "操作成功！！！", null);
                    }
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return Result.error("-1", "操作有误！！！");
                }
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error("-1", "操作有误！！！");
            }else if (staffPositionMapper.deleteByStaffId(staff.getStaffId())){
                return Result.success("200", "操作成功！！！", null);
            }

        }
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return Result.error("-1", "操作有误！！！");
    }


    @Override
    public Result findByid(int id) {
        SysStaff staff = mapper.findByid(id);
        staff.setPersonal(personalMapper.selectById(staff.getPersonalId()));
        staff.setPositions(staffPositionMapper.selectBystaffid(staff.getStaffId()));
        if (StringUtils.isEmpty(staff)){
            return Result.error("-1","该数据不存在或已被移除！！！");
        }
        return Result.success("200",null,staff);
    }

    @Override
    public Result<?> deleteBatchIds(List<Integer> ids) {
        if(mapper.deleteBatchIds(ids)>0){
            return Result.success("200","操作成功！！！",null);
        }
        return Result.error("-1","操作失败！！！");
    }

    @Override
    public Result<?> deleteById(int id) {
        if (mapper.deleteById(id)>0){
            return Result.success("200","操作成功！！！",null);
        }
        return Result.error("-1","操作失败,该数据可能已被移除！！！");
    }
}
