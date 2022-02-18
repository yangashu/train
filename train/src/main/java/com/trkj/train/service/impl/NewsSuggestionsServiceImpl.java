package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.dto.ReceivingView;
import com.trkj.train.config.dto.SuggestionsView;
import com.trkj.train.entity.NewsSuggestions;
import com.trkj.train.entity.PersonalReceiving;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.mapper.NewsSuggestionsMapper;
import com.trkj.train.mapper.SysStaffMapper;
import com.trkj.train.service.INewsSuggestionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class NewsSuggestionsServiceImpl extends ServiceImpl<NewsSuggestionsMapper, NewsSuggestions> implements INewsSuggestionsService {

    @Autowired
    private SysStaffMapper staffMapper;

    @Autowired
    private NewsSuggestionsMapper suggestionsMapper;

    @Override
    public IPage<SuggestionsView> PageSelect(int page, int size) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("deleted",0);

        Page<NewsSuggestions> page1=new Page<>(page,size);
        //查询全部意见
        IPage<NewsSuggestions> iPage=suggestionsMapper.selectPage(page1,queryWrapper);
        //声明返回的Ipage聚合实体类
        IPage<SuggestionsView> viewIPage = new Page<>();
        List<SuggestionsView> list = new ArrayList();



        for(int i=0;i<iPage.getRecords().size();i++){
            QueryWrapper<SysStaff> queryWrapper1 = new QueryWrapper();
            SysStaff personal = new SysStaff();
            if(iPage.getRecords().get(i).getStaffId()==0){
                personal.setStaffName("该用户已匿名");
            }else{
                queryWrapper1.eq("staff_id",iPage.getRecords().get(i).getStaffId());

                personal = staffMapper.selectOne(queryWrapper1);
            }

            SuggestionsView sendView = new SuggestionsView();
            sendView.setStaffName(personal.getStaffName());
            sendView.setStaffId(iPage.getRecords().get(i).getStaffId());
            sendView.setSuggestionsId(iPage.getRecords().get(i).getSuggestionsId());
            sendView.setSuggestionsContent(iPage.getRecords().get(i).getSuggestionsContent());
            sendView.setSuggestionsDate(iPage.getRecords().get(i).getSuggestionsDate());
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
    public int addnews(NewsSuggestions suggestions) {
        suggestions.setSuggestionsDate(new Date());
        suggestions.setSuggestionsContent(suggestions.getSuggestionsContent());
        if (suggestions.getStaffId()==null){
            suggestions.setStaffId(null);
        }
        suggestions.setStaffId(suggestions.getStaffId());
        return suggestionsMapper.insert(suggestions);
    }

    @Override
    public IPage<SuggestionsView> Page(int page, int size, int id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("staff_id",id);
        queryWrapper.eq("deleted",0);

        Page<NewsSuggestions> page1=new Page<>(page,size);
        //查询全部意见
        IPage<NewsSuggestions> iPage=suggestionsMapper.selectPage(page1,queryWrapper);
        //声明返回的Ipage聚合实体类
        IPage<SuggestionsView> viewIPage = new Page<>();
        List<SuggestionsView> list = new ArrayList();



        for(int i=0;i<iPage.getRecords().size();i++){
            QueryWrapper<SysStaff> queryWrapper1 = new QueryWrapper();
            SysStaff personal = new SysStaff();
            if(iPage.getRecords().get(i).getStaffId()==0){
                personal.setStaffName("该用户已匿名");
            }else{
                queryWrapper1.eq("staff_id",iPage.getRecords().get(i).getStaffId());

                personal = staffMapper.selectOne(queryWrapper1);
            }

            SuggestionsView sendView = new SuggestionsView();
            sendView.setStaffName(personal.getStaffName());
            sendView.setStaffId(iPage.getRecords().get(i).getStaffId());
            sendView.setSuggestionsId(iPage.getRecords().get(i).getSuggestionsId());
            sendView.setSuggestionsContent(iPage.getRecords().get(i).getSuggestionsContent());
            sendView.setSuggestionsDate(iPage.getRecords().get(i).getSuggestionsDate());
            list.add(sendView);
        }
        viewIPage.setCurrent(iPage.getCurrent());
        viewIPage.setPages(iPage.getPages());
        viewIPage.setRecords(list);
        viewIPage.setSize(iPage.getSize());
        viewIPage.setTotal(iPage.getTotal());
        return viewIPage;
    }
}
