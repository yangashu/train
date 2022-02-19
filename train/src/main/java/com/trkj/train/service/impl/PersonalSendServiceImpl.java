package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.dto.SendView;
import com.trkj.train.entity.PersonalReceiving;
import com.trkj.train.entity.PersonalSend;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.mapper.PersonalReceivingMapper;
import com.trkj.train.mapper.PersonalSendMapper;
import com.trkj.train.mapper.SysStaffMapper;
import com.trkj.train.service.IPersonalSendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
public class PersonalSendServiceImpl extends ServiceImpl<PersonalSendMapper, PersonalSend> implements IPersonalSendService {

    @Autowired
    private PersonalSendMapper sendMapper;
    @Autowired
    private SysStaffMapper staffMapper;
    @Autowired
    private PersonalReceivingMapper receivingMapper;
    @Override
    public IPage<SendView> SelectPage(int page, int size, int id) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("staff_id2",id);
        queryWrapper.eq("deleted",0);
        Page<PersonalSend> page1=new Page<>(page,size);
        IPage<PersonalSend> iPage = sendMapper.selectPage(page1,queryWrapper);
        IPage<SendView> viewIPage = new Page<>();
        List<SendView> list = new ArrayList();

        for(int i=0;i<iPage.getRecords().size();i++){
            QueryWrapper<SysStaff> queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("staff_id",iPage.getRecords().get(i).getStaffId2());
            queryWrapper.eq("deleted",0);
            SysStaff personal = staffMapper.selectOne(queryWrapper1);
            SendView sendView = new SendView();
            System.out.println(iPage.getRecords().get(i).getStaffId2());
            sendView.setStaffName(personal.getStaffName());
            sendView.setSendId(iPage.getRecords().get(i).getSendId());
            sendView.setSendDate(iPage.getRecords().get(i).getSendDate());
            sendView.setSendTitle(iPage.getRecords().get(i).getSendTitle());
            sendView.setSendContent(iPage.getRecords().get(i).getSendContent());
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
    public IPage<SendView> lickselect(int page, int size, String like, int id) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("staff_id2",id);
        queryWrapper.eq("deleted",0);
        queryWrapper.like("send_title",like);
        Page<PersonalSend> page1=new Page<>(page,size);
        IPage<PersonalSend> iPage = sendMapper.selectPage(page1,queryWrapper);
        IPage<SendView> viewIPage = new Page<>();
        List<SendView> list = new ArrayList();

        for(int i=0;i<iPage.getRecords().size();i++){
            QueryWrapper<SysStaff> queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("staff_id",iPage.getRecords().get(i).getStaffId2());
            queryWrapper.eq("deleted",0);
            SysStaff personal = staffMapper.selectOne(queryWrapper1);
            SendView sendView = new SendView();
            sendView.setStaffName(personal.getStaffName());
            sendView.setSendId(iPage.getRecords().get(i).getSendId());
            sendView.setSendDate(iPage.getRecords().get(i).getSendDate());
            sendView.setSendTitle(iPage.getRecords().get(i).getSendTitle());
            sendView.setSendContent(iPage.getRecords().get(i).getSendContent());
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
    public List<SysStaff> selectcheckd() {
        return staffMapper.selectList(null);
    }

    @Override
    public int adds(PersonalSend send) {
        int a=sendMapper.insert(send);
        PersonalReceiving r = new PersonalReceiving();
        r.setReceivingContent(send.getSendContent());
        r.setReceivingDate(new Date());
        r.setReceivingTitle(send.getSendTitle());
        r.setStaffId1(send.getStaffId2());
        r.setStaffId2(send.getStaffId1());
        r.setReceivingState(0);
        int b=receivingMapper.insert(r);
        return b;
    }

    public int ad(PersonalSend send){
        int b=sendMapper.insert(send);
        PersonalReceiving r = new PersonalReceiving();
        r.setReceivingContent(send.getSendContent());
        r.setReceivingDate(new Date());
        r.setReceivingTitle(send.getSendTitle());
        r.setStaffId1(send.getStaffId2());
        r.setStaffId2(send.getStaffId1());
        r.setReceivingState(0);
        int a = receivingMapper.insert(r);
        return a;
    }

    @Override
    public int delete(int id) {
        PersonalSend send = sendMapper.selectById(id);
        send.setDeleted(1);
        int i = sendMapper.deleteById(send);
        return i;
    }
}
