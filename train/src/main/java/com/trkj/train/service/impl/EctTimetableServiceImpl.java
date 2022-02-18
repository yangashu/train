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

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
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
    public IPage<EctTimetablepkDo> selectiptioncxpk(int page, int size, String classname, int deleted) {
        Page<EctTimetablepkDo> pasee=new Page<>(page,size);
        QueryWrapper queryWrapper=new QueryWrapper();
        if (deleted==0){
            queryWrapper.like("e.deleted",deleted);
            if (classname!=null&&classname.length()!=0){
                queryWrapper.like("c.classes_name",classname);
            }
        }
        IPage<EctTimetablepkDo> page1=ectTimetableMapper.selectiptionkbcx(pasee,queryWrapper);
        return page1;
    }

    @Override
    public int deletedpk(EctTimetable ectTimetable) {
        return ectTimetableMapper.deleteById(ectTimetable);
    }

    @Override
    public int insertpk(EctTimetable ectTimetable) {
        return ectTimetableMapper.insert(ectTimetable);
    }
}
