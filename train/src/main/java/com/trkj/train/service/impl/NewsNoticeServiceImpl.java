package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.dto.NoticeView;
import com.trkj.train.config.dto.SendView;
import com.trkj.train.entity.NewsNotice;
import com.trkj.train.entity.PersonalSend;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.mapper.NewsNoticeMapper;
import com.trkj.train.mapper.SysStaffMapper;
import com.trkj.train.service.INewsNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class NewsNoticeServiceImpl extends ServiceImpl<NewsNoticeMapper, NewsNotice> implements INewsNoticeService {

    @Autowired
    private NewsNoticeMapper mapper;

    @Override
    public int one() {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
//        QueryWrapper<NewsNotice> wrapper=new QueryWrapper<>();
//        wrapper.eq("staff_id1",staffId);
        List<NewsNotice> list=mapper.selectList(null);
        List<NewsNotice> list1=new ArrayList<>();
        for(NewsNotice n : list){
            String newDate=format.format(new Date());
            String oldDate=format.format(n.getNoticeDate());
            if (newDate.equals(oldDate)){
                list1.add(n);
            }else {
                continue;
            }
        }
        return list1.size();
    }
    @Autowired
    private NewsNoticeMapper newsNoticeMapper;

    @Autowired
    private SysStaffMapper staffMapper;

    @Override
    public IPage<NoticeView> pageselect(int page, int size) {
        QueryWrapper queryWrapper=new QueryWrapper();
        Page<NewsNotice> page1=new Page<>(page,size);
        IPage<NewsNotice> iPage = newsNoticeMapper.selectPage(page1,queryWrapper);
        IPage<NoticeView> viewIPage = new Page<>();
        List<NoticeView> list = new ArrayList();

        for(int i=0;i<iPage.getRecords().size();i++){
            QueryWrapper<SysStaff> queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("staff_id",iPage.getRecords().get(i).getStaffId());
            SysStaff personal = staffMapper.selectOne(queryWrapper1);
            NoticeView noticeView = new NoticeView();
            noticeView.setNoticeId(iPage.getRecords().get(i).getNoticeId());
            noticeView.setNoticeDate(iPage.getRecords().get(i).getNoticeDate());
            noticeView.setNoticeContent(iPage.getRecords().get(i).getNoticeContent());
            noticeView.setNoticeType(iPage.getRecords().get(i).getNoticeType());
            noticeView.setNoticeTheme(iPage.getRecords().get(i).getNoticeTheme());
            noticeView.setStaffName(personal.getStaffName());
            noticeView.setDeleted(iPage.getRecords().get(i).getDeleted());
            noticeView.setState(iPage.getRecords().get(i).getState());
            list.add(noticeView);
        }
        viewIPage.setCurrent(iPage.getCurrent());
        viewIPage.setPages(iPage.getPages());
        viewIPage.setRecords(list);
        viewIPage.setSize(iPage.getSize());
        viewIPage.setTotal(iPage.getTotal());
        return viewIPage;
    }

    @Override
    public int xiugai(int id) {
        NewsNotice newsNotice1 = newsNoticeMapper.selectById(id);
        if (newsNotice1.getState()==0){
            newsNotice1.setState(1);
        }else if(newsNotice1.getState()==1){
            newsNotice1.setState(0);
        }
        return newsNoticeMapper.updateById(newsNotice1);
    }
}
