package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.EctTimetableClassDo;
import com.trkj.train.TyVo.EctTimetablepkDo;
import com.trkj.train.entity.EctTimetable;
import com.trkj.train.mapper.EctClassroomMapper;
import com.trkj.train.mapper.EctTimetableMapper;
import com.trkj.train.service.IEctTimetableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class EctTimetableServiceImpl extends ServiceImpl<EctTimetableMapper, EctTimetable> implements IEctTimetableService {
    @Autowired
    private EctTimetableMapper ectTimetableMapper;
    @Override
    public IPage<EctTimetableClassDo> selectiption(int page, int size, int classid) {
        System.out.println("jkhjk"+classid);
        Page<EctTimetableClassDo> pagess=new Page<>(page,size);
        return ectTimetableMapper.selectiptionkb(pagess,classid);
    }

    @Override
    public IPage<EctTimetablepkDo> selectpk(int page, int size) {
        IPage<EctTimetablepkDo> pagse=ectTimetableMapper.selectkcxkb(new Page<>(page,size));

        return pagse;
    }

    @Override
    public IPage<EctTimetablepkDo> selectiptioncxpk(int page, int size, String classname, int deleted) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        Date date1 = sdf.parse(format);

        Page<EctTimetablepkDo> pasee=new Page<>(page,size);
        QueryWrapper queryWrapper=new QueryWrapper();
        if (deleted==0){
            queryWrapper.like("e.deleted",deleted);
            if (classname!=null&&classname.length()!=0){
                queryWrapper.like("c.classes_name",classname);
            }
        }
        IPage<EctTimetablepkDo> page1=ectTimetableMapper.selectiptionkbcx(pasee,queryWrapper);
        for(EctTimetablepkDo dd: page1.getRecords()){
            String format1 = sdf.format(dd.getTimetableTime());
            Date date2 = sdf.parse(format1);
            if(date1.compareTo(date2)>=0){
                EctTimetable table=new EctTimetable();
                table.setTimetableId(dd.getTimetableId());
                table.setTimetableState(1);
                this.updatestate(table);
                dd.setTimetableState(1);
            }
        }
        return page1;
    }

    @Override
    public int deletedpk(EctTimetable ectTimetable) {
        try {
            return ectTimetableMapper.deleteById(ectTimetable);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }

    @Override
    public int insertpk(EctTimetable ectTimetable) {
        try {
            return ectTimetableMapper.insert(ectTimetable);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }

    @Override
    public int updatestate(EctTimetable ectTimetable) {
        try {
            int a=ectTimetableMapper.updateById(ectTimetable);
            return a;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }
}
