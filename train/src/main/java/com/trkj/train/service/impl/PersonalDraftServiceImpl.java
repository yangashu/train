package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.dto.DraftView;
import com.trkj.train.entity.PersonalDraft;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.mapper.PersonalDraftMapper;
import com.trkj.train.mapper.SysStaffMapper;
import com.trkj.train.service.IPersonalDraftService;
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
public class PersonalDraftServiceImpl extends ServiceImpl<PersonalDraftMapper, PersonalDraft> implements IPersonalDraftService {
    @Autowired
    private PersonalDraftMapper draftMapper;

    @Autowired
    private SysStaffMapper staffMapper;


    @Override
    public int add(PersonalDraft draft) {
        int a=draftMapper.insert(draft);
        return a;
    }

    @Override
    public IPage<DraftView> pageselect(int page, int size, int id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("deleted",0);
        queryWrapper.eq("staff_id2",id);
        Page<PersonalDraft> page1=new Page<>(page,size);
        IPage<PersonalDraft> iPage=draftMapper.selectPage(page1,queryWrapper);
        IPage<DraftView> viewIPage = new Page<>();
        List<DraftView> list = new ArrayList();

        for(int i=0;i<iPage.getRecords().size();i++){
            QueryWrapper<SysStaff> queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("staff_id",iPage.getRecords().get(i).getStaffId2());
            queryWrapper.eq("deleted",0);
            SysStaff personal = staffMapper.selectOne(queryWrapper1);
            DraftView sendView = new DraftView();
            sendView.setDraftId(iPage.getRecords().get(i).getDraftId());
            sendView.setStaffName(personal.getStaffName());
            sendView.setStaffId1(iPage.getRecords().get(i).getStaffId1());
            sendView.setStaffId2(iPage.getRecords().get(i).getStaffId2());
            sendView.setDraftId(iPage.getRecords().get(i).getDraftId());
            sendView.setDraftDate(iPage.getRecords().get(i).getDraftDate());
            sendView.setDraftTitle(iPage.getRecords().get(i).getDraftTitle());
            sendView.setDraftContent(iPage.getRecords().get(i).getDraftContent());
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
    public IPage<DraftView> pagelike(int page, int size, String like, int id) {
        return null;
    }

    @Override
    public int upzt(PersonalDraft id) {

        id.setDeleted(1);
        System.out.println("wsid"+id.toString());
        int i =draftMapper.deleteById(id);
        return i;
    }

}
