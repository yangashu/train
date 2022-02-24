package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.dto.ReceivingView;
import com.trkj.train.entity.PersonalReceiving;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.mapper.PersonalReceivingMapper;
import com.trkj.train.mapper.SysStaffMapper;
import com.trkj.train.service.IPersonalReceivingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class PersonalReceivingServiceImpl extends ServiceImpl<PersonalReceivingMapper, PersonalReceiving> implements IPersonalReceivingService {
    @Autowired
    private PersonalReceivingMapper receivingMapper;

    @Autowired
    private SysStaffMapper staffMapper;

    @Override
    public IPage<ReceivingView> receiving(int page, int size, int id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("deleted",0);
        queryWrapper.eq("staff_id1",id);
        Page<PersonalReceiving> page1=new Page<>(page,size);
        IPage<PersonalReceiving> iPage=receivingMapper.selectPage(page1,queryWrapper);
        IPage<ReceivingView> viewIPage = new Page<>();
        List<ReceivingView> list = new ArrayList();

        for(int i=0;i<iPage.getRecords().size();i++){
            QueryWrapper<SysStaff> queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("staff_id",iPage.getRecords().get(i).getStaffId2());
            queryWrapper.eq("deleted",0);
            SysStaff personal = staffMapper.selectOne(queryWrapper1);
            ReceivingView sendView = new ReceivingView();
            sendView.setStaffName(personal.getStaffName());
            sendView.setStaffId1(iPage.getRecords().get(i).getStaffId1());
            sendView.setStaffId2(iPage.getRecords().get(i).getStaffId2());
            sendView.setReceivingState(iPage.getRecords().get(i).getReceivingState());
            sendView.setReceivingId(iPage.getRecords().get(i).getReceivingId());
            sendView.setReceivingDate(iPage.getRecords().get(i).getReceivingDate());
            sendView.setReceivingTitle(iPage.getRecords().get(i).getReceivingTitle());
            sendView.setReceivingContent(iPage.getRecords().get(i).getReceivingContent());
            list.add(sendView);
        }
        viewIPage.setCurrent(iPage.getCurrent());
        viewIPage.setPages(iPage.getPages());
        viewIPage.setRecords(list);
        viewIPage.setSize(iPage.getSize());
        viewIPage.setTotal(iPage.getTotal());
        return viewIPage;
    }

    @Override
    public IPage<ReceivingView> lickselect(int page, int size, String like ,int id) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.like("RECEIVING_TITLE",like);
        queryWrapper.eq("deleted",0);
        queryWrapper.eq("staff_id1",id);
        IPage<PersonalReceiving> iPage=receivingMapper.selectPage(new Page(page,size),queryWrapper);
        IPage<ReceivingView> viewIPage = new Page<>();
        List<ReceivingView> list = new ArrayList();
        for(int i=0;i<iPage.getRecords().size();i++){
            QueryWrapper<SysStaff> queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("staff_id",iPage.getRecords().get(i).getStaffId2());
            queryWrapper.eq("deleted",0);
            SysStaff personal = staffMapper.selectOne(queryWrapper1);
            ReceivingView sendView = new ReceivingView();
            sendView.setStaffName(personal.getStaffName());
            sendView.setStaffId1(iPage.getRecords().get(i).getStaffId1());
            sendView.setStaffId2(iPage.getRecords().get(i).getStaffId2());
            sendView.setReceivingState(iPage.getRecords().get(i).getReceivingState());
            sendView.setReceivingId(iPage.getRecords().get(i).getReceivingId());
            sendView.setReceivingDate(iPage.getRecords().get(i).getReceivingDate());
            sendView.setReceivingTitle(iPage.getRecords().get(i).getReceivingTitle());
            sendView.setReceivingContent(iPage.getRecords().get(i).getReceivingContent());
            list.add(sendView);
        }
        viewIPage.setCurrent(iPage.getCurrent());
        viewIPage.setPages(iPage.getPages());
        viewIPage.setRecords(list);
        viewIPage.setSize(iPage.getSize());
        viewIPage.setTotal(iPage.getTotal());
        return viewIPage;
    }

    @Override
    public int dele(int id) {
        PersonalReceiving receiving = receivingMapper.selectById(id);
        receiving.setDeleted(1);
        int i = receivingMapper.deleteById(receiving);
        return i;
    }

    @Override
    public int xiugai(PersonalReceiving id) {
        id.setReceivingState(1);
        int i = receivingMapper.updateById(id);
        return i;
    }

}
